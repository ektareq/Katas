package com.tek.kata.args;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArgsParser {

	private final Map<String, ArgsModel<?>> args;
	private final static ObjectMapper mapper = new ObjectMapper();

	public ArgsParser(String rawArgs, Map<String, ArgsModel<?>> schema) throws JsonMappingException, JsonProcessingException {
		String[] keyValues = rawArgs.split("-");
		for (String keyValue : keyValues) {
			// unique key value
			if (keyValue == null || keyValue.isEmpty())
				continue;
			String[] uKv = keyValue.split("\s");
			if (uKv.length > 2)
				throw new IllegalStateException("raw argument is kaput, it contains more than 2 keyvalue pairs ! : " + uKv);
			String key = uKv[0];
			if (key.length() != 1)
				throw new IllegalStateException("key is kaput, it should be 1 char letter ! " + key);

			ArgsModel<?> model = schema.get(key);
			if (model != null) {
				if (uKv.length == 1) {
					model.setValue(Boolean.TRUE);
				} else {
					String value = uKv[1];
					model.setValue( model.getType() != String.class ? mapper.readValue(value, model.getType()) : value);
					//model.setValue(value);
				}
			}
		}
		args = schema;
	}

	public Object getValueOf(String string) {
		ArgsModel<?> model = args.get(string);
		if (model != null) {
			return model.getValue();
		}
		return false;
	}
}
