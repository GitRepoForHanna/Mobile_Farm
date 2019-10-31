package utils.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializationUtils {

    public static <T>T deserializeObject(String content, Class<T> valueType) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        T result = null;
        try {
            result = mapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to deserialize content: " + content);
        }
        return result;
    }
}
