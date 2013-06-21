package com.babailiren.ec.lang.enums;

import java.util.LinkedHashMap;

@SuppressWarnings("unchecked")
public class EnumBaseUtils {
	/**
	 * ?EnumBase.getCode()??Key,EnumBase.getDesc()??value,???Map????
	 * 
	 * @param <T>
	 * @param values
	 * @return
	 */
	public static <T extends EnumBase> LinkedHashMap toMap(
			Class<? extends EnumBase> enumClass) {
		return toMap(enumClass.getEnumConstants());
	}

	/**
	 * ?EnumBase.getCode()??Key,EnumBase.getDesc()??value,???Map????
	 * 
	 * @param <T>
	 * @param values
	 * @return
	 */
	public static <T extends EnumBase> LinkedHashMap toMap(T[] values) {
		LinkedHashMap map = new LinkedHashMap();
		for (EnumBase item : values) {
			map.put(item.getCode(), item.getDesc());
		}
		return map;
	}

	public static <T extends EnumBase> Object getCode(T kv) {
		if (kv == null)
			return null;
		return kv.getCode();
	}

	public static <T extends EnumBase> String getDesc(T kv) {
		if (kv == null)
			return null;
		return kv.getDesc();
	}

	public static <T extends Enum> String getName(T kv) {
		if (kv == null)
			return null;
		return kv.name();
	}

	/**
	 * ??code????Enum
	 * 
	 * @param code
	 * @param values
	 * @return
	 */
	public static <T extends EnumBase> T getByCode(Object code,
			Class<? extends EnumBase> enumClass) {
		return (T) getByCode(code, enumClass.getEnumConstants());
	}

	/**
	 * ??code????Enum
	 * 
	 * @param code
	 * @param values
	 * @return
	 */
	public static <T extends EnumBase> T getByCode(Object code, T[] values) {
		if (code == null)
			return null;
		for (T item : values) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * ??code????Enum
	 * 
	 * @param code
	 * @param values
	 * @return
	 */
	public static <T extends EnumBase> T getRequiredByCode(Object code,
			Class<? extends EnumBase> enumClass) {
		return (T) getRequiredByCode(code, enumClass.getEnumConstants());
	}

	/**
	 * ??code??Enum,???????
	 * 
	 * @param <T>
	 * @param code
	 * @param values
	 * @return
	 * @throws IllegalArgumentException
	 *             ??code??Enum,???????
	 */
	public static <T extends EnumBase> T getRequiredByCode(Object code,
			T[] values) throws IllegalArgumentException {
		if (code == null)
			return null;
		EnumBase v = getByCode(code, values);
		if (v == null) {
			if (values.length > 0) {
				String className = values[0].getClass().getName();
				throw new IllegalArgumentException("not found " + className
						+ " value by code:" + code);
			} else {
				throw new IllegalArgumentException("not found Enum by code:"
						+ code);
			}
		}
		return (T) v;
	}
}
