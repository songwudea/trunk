package com.babailiren.ec.jdbc.sqlgenerator.metadata;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.babailiren.ec.model.Site;

public class MetadataCreateUtils {
	public static Table createTable(Class clazz) {

		BeanInfo info = getBeanInfo(clazz);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		List<Column> columns = new ArrayList();
		for (PropertyDescriptor pd : pds) {
			if ("class".equals(pd.getName()))
				continue;
			Method readMethod = pd.getReadMethod();
			if (readMethod == null || pd.getWriteMethod() == null) {
				continue;
			}
			if (isTransientProperty(readMethod, pd.getWriteMethod())) {
				continue;
			}
			if (!isNativeJavaType(readMethod.getReturnType())) {
				continue;
			}
			boolean isPrimaryKey = isPrimaryKeyColumn(readMethod);
			String sqlName = getColumnSqlName(pd, readMethod);
			Column column = new Column(sqlName, pd.getName(), isPrimaryKey);
			columns.add(column);
		}

		Table t = new Table(getTableName(clazz), columns);
		return t;
	}

	static boolean isNativeJavaType(Class clazz) {
		if (clazz == null)
			return false;
		if (clazz.isArray())
			return false;

		if (clazz.isPrimitive() || clazz.getName().startsWith("java.")
				|| clazz.getName().startsWith("javax.")) {
			return true;
		}
		return false;
	}

	private static BeanInfo getBeanInfo(Class clazz) {
		try {
			return Introspector.getBeanInfo(clazz);
		} catch (IntrospectionException e) {
			throw new IllegalArgumentException(
					"error: generate Table instance from Class,clazz:" + clazz,
					e);
		}
	}

	private static boolean isJPAClassAvaiable = false;
	static {
		try {
			Class.forName("javax.persistence.Table");
			isJPAClassAvaiable = true;
		} catch (ClassNotFoundException e) {
		}
	}

	private static boolean isPrimaryKeyColumn(Method readMethod) {
		boolean isPrimaryKey = false;
		if("getId".equals(readMethod.getName())) {
			isPrimaryKey = true;
		}
		return isPrimaryKey;
	}

	private  static boolean isTransientProperty(Method readMethod,Method writeMethod) {
//		if(isJPAClassAvaiable) {
//			if(readMethod.isAnnotationPresent(Transient.class)) {
//				return true;
//		 	}
//		 }
		 return false;
	}
	
	private static String getColumnSqlName(PropertyDescriptor pd,
			Method readMethod) {
		String sqlName = null;
//		if (isJPAClassAvaiable) {
//			javax.persistence.Column annColumn = (javax.persistence.Column) readMethod
//					.getAnnotation(javax.persistence.Column.class);
//			if (annColumn != null) {
//				sqlName = annColumn.name();
//			}
//		}
		if (sqlName == null || sqlName.length() == 0) {
			sqlName = toUnderscoreName(pd.getName());
		}
		return sqlName;
	}

	private static boolean getColumnInsertable(PropertyDescriptor pd,
			Method method) {
		boolean insertable = true;
//		if (isJPAClassAvaiable) {
//			javax.persistence.Column annColumn = (javax.persistence.Column) method
//					.getAnnotation(javax.persistence.Column.class);
//			if (annColumn != null) {
//				insertable = annColumn.insertable();
//			}
//		}
		return insertable;
	}

	private static boolean getColumnUpdatable(PropertyDescriptor pd,
			Method method) {
		boolean updatable = true;
//		if (isJPAClassAvaiable) {
//			javax.persistence.Column annColumn = (javax.persistence.Column) method
//					.getAnnotation(javax.persistence.Column.class);
//			if (annColumn != null) {
//				updatable = annColumn.updatable();
//			}
//		}
		return updatable;
	}

	private static boolean getColumnUnique(PropertyDescriptor pd, Method method) {
		boolean unique = false;
//		if (isJPAClassAvaiable) {
//			javax.persistence.Column annColumn = (javax.persistence.Column) method
//					.getAnnotation(javax.persistence.Column.class);
//			if (annColumn != null) {
//				unique = annColumn.unique();
//			}
//		}
		return unique;
	}

	private static String getTableName(Class clazz) {
		String tableName = toUnderscoreName(clazz.getSimpleName());
//		if (isJPAClassAvaiable) {
//			javax.persistence.Table annTable = (javax.persistence.Table) clazz
//					.getAnnotation(javax.persistence.Table.class);
//			if (annTable != null) {
//				tableName = annTable.name();
//			}
//		}
		return tableName;
	}

	private static String toUnderscoreName(String name) {
		if (name == null)
			return null;

		String filteredName = name;
		if (filteredName.indexOf("_") >= 0
				&& filteredName.equals(filteredName.toUpperCase())) {
			filteredName = filteredName.toLowerCase();
		}
		if (filteredName.indexOf("_") == -1
				&& filteredName.equals(filteredName.toUpperCase())) {
			filteredName = filteredName.toLowerCase();
		}

		StringBuffer result = new StringBuffer();
		if (filteredName != null && filteredName.length() > 0) {
			result.append(filteredName.substring(0, 1).toLowerCase());
			for (int i = 1; i < filteredName.length(); i++) {
				String preChart = filteredName.substring(i - 1, i);
				String c = filteredName.substring(i, i + 1);
				if (c.equals("_")) {
					result.append("_");
					continue;
				}
				if (preChart.equals("_")) {
					result.append(c.toLowerCase());
					continue;
				}
				if (c.matches("\\d")) {
					result.append(c);
				} else if (c.equals(c.toUpperCase())) {
					result.append("_");
					result.append(c.toLowerCase());
				} else {
					result.append(c);
				}
			}
		}
		return result.toString();
	}
	
//	public static String getUpdateByPkSql() {
//		StringBuilder sb = new StringBuilder("UPDATE ").append(getTableName())
//				.append(" SET ");
//
//		sb.append(StringUtils.join(getUpdateColumns().iterator(), ","));
//		sb.append(" WHERE ");
//
//		for (int i = 0; i < getPrimaryKeyColumns().size(); i++) {
//			Column c = getPrimaryKeyColumns().get(i);
//			sb.append(c.getSqlName() + " = " + getColumnPlaceholder(c));
//			if (i < getPrimaryKeyColumns().size() - 1)
//				sb.append(" AND ");
//		}
//		return sb.toString();
//	}
	
	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(Site.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		List<Column> columns = new ArrayList<Column>();
		for (PropertyDescriptor pd : pds) {
			if ("class".equals(pd.getName())) {
				continue;
			}
			Method readMethod = pd.getReadMethod();
			String sqlName = getColumnSqlName(pd, readMethod);
			Column column = new Column(sqlName, pd.getName());
			column.setInsertable(getColumnInsertable(pd, readMethod));
			column.setUpdatable(getColumnUpdatable(pd, readMethod));
			column.setUnique(getColumnUnique(pd, readMethod));
			columns.add(column);
		}
		
		
		System.out.println(columns.size());
	}
}
