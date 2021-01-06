package cn.sliew.indexer.common.util;

import cn.sliew.indexer.common.exception.IndexerException;
import cn.sliew.indexer.common.exception.IndexerExceptionEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class JacksonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JacksonUtil() {
        throw new IllegalStateException("can't do this");
    }

    public static String toJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IndexerException(IndexerExceptionEnum.FAILURE.getMessage(), e);
        }
    }

    public static <T> T parseJsonString(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new IndexerException(IndexerExceptionEnum.FAILURE.getMessage(), e);
        }
    }

    /**
     * json to list
     *
     * @param json json string
     * @param clazz class
     * @param <T> T
     * @return list
     */
    public static <T> List<T> parseJsonArray(String json, Class<T> clazz) {
        if (json == null || json.length() == 0) {
            return Collections.emptyList();
        }
        try {
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
            return objectMapper.readValue(json, listType);
        } catch (Exception e) {
            throw new IndexerException(IndexerExceptionEnum.FAILURE.getMessage(), e);
        }
    }
}
