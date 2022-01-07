package com.thecollective.api.enums.converter;

import org.springframework.core.convert.converter.Converter;

import com.thecollective.api.enums.ResultType;

public class ResultTypeConverter implements Converter<String, ResultType> {

	@Override
	public ResultType convert(String source) {

		try {
			return ResultType.valueOf(source.toUpperCase());
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

}
