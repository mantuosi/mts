package com.mantuosi.mts.common;

import org.springframework.core.convert.converter.Converter;

public class CustomConverter implements Converter<String, String> {

	public String convert(String source) {
		try {
			if (null != source) {
				source = source.trim();// " " ==> ""
				if (!"".equals(source)) {
					return source;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		return null;
	}

}
