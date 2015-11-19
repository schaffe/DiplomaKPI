package com.dzidzoiev.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by dzidzoiev on 11/18/15.
 */
public class Json {
    ObjectMapper mapper;

    private Json() {
        mapper = new ObjectMapper();
//        mapper.writerWithDefaultPrettyPrinter();
//        mapper.setDefaultPrettyPrinter(new DefaultPrettyPrinter());
    }

    public static Json getInstnce() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        static Json INSTANCE = new Json();
    }

    public static String toJson(Object object) {
        try {
            return getInstnce().mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
}
