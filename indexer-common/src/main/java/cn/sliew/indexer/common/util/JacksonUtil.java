package cn.sliew.indexer.common.util;

import cn.sliew.indexer.common.exception.IndexerException;
import cn.sliew.indexer.common.exception.IndexerExceptionEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

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
}
