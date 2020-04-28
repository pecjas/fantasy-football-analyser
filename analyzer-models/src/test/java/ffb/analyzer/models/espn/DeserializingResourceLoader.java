package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

abstract class DeserializingResourceLoader {

    protected ObjectMapper mapper;

    DeserializingResourceLoader() {
        mapper = configureObjectMapper();
    }

    protected ObjectMapper configureObjectMapper() {
        return new ObjectMapper()
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }

    protected final File getResourceFile(String fileResource) {
        return new File(Objects.requireNonNull(getClass()
            .getClassLoader()
            .getResource(fileResource))
            .getFile()
        );
    }

    protected final File getResourceFile() {
        return new File(Objects.requireNonNull(getClass()
            .getClassLoader()
            .getResource(getResourceFileName()))
            .getFile()
        );
    }

    protected final <T> T deserializeSingleObject(Class<T> clazz) throws IOException {
        return mapper.readValue(
            getResourceFile(),
            clazz
        );
    }

    protected final <T> List<T> deserializeObjects(Class<T> clazz) throws IOException {
        return mapper.readValue(
            getResourceFile(),
            mapper.getTypeFactory().constructCollectionType(List.class, clazz)
        );
    }

    protected abstract String getResourceFileName();

    @Test
    public abstract void testDeserialization() throws IOException;
}
