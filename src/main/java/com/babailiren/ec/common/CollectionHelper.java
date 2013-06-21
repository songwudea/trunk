package com.babailiren.ec.common;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

@SuppressWarnings("unchecked")
public class CollectionHelper {

	private CollectionHelper() {
	}

	public static List selectProperty(Iterable from, String propertyName) {
		if (propertyName == null)
			throw new IllegalArgumentException(
					"'propertyName' must be not null");
		if (from == null)
			return null;

		List result = new ArrayList();
		for (Object o : from) {
			try {
				if (o == null) {
					result.add(null);
				} else {
					Object value = PropertyUtils.getSimpleProperty(o, propertyName);
					result.add(value);
				}
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException(
						"Cannot get propertyValue by propertyName:"
								+ propertyName + " on class:" + o.getClass(), e);
			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException(
						"Cannot get propertyValue by propertyName:"
								+ propertyName + " on class:" + o.getClass(), e
								.getTargetException());
			} catch (NoSuchMethodException e) {
				throw new IllegalArgumentException("no such property:"
						+ propertyName + " on class:" + o.getClass(), e);
			}
		}
		return result;
	}

	public static double avg(Iterable objects, String propertyName) {
		List<Number> propertyValues = CollectionHelper.selectProperty(objects,
				propertyName);
		return avg(propertyValues);
	}

	public static double avg(Collection<Number> values) {
		if (values == null)
			return 0;
		if (values.isEmpty())
			return 0;
		return sum(values) / values.size();
	}

	public static double sum(Iterable objects, String propertyName) {
		if (objects == null)
			return 0;
		List<Number> propertyValues = CollectionHelper.selectProperty(objects,
				propertyName);
		return sum(propertyValues);
	}

	public static double sum(Iterable<Number> values) {
		if (values == null)
			return 0;

		double sum = 0;
		for (Number num : values) {
			if (num == null)
				continue;
			sum += num.doubleValue();
		}
		return sum;
	}

	public static Object max(Collection objects, String propertyName) {
		List<Comparable> propertyValues = CollectionHelper.selectProperty(
				objects, propertyName);
		return Collections.max(propertyValues);
	}

	public static Object min(Collection objects, String propertyName) {
		List<Comparable> propertyValues = CollectionHelper.selectProperty(
				objects, propertyName);
		return Collections.min(propertyValues);
	}
}
