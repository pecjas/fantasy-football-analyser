package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

abstract class DeserializingResourceLoader {

    protected static ObjectMapper mapper = new ObjectMapper()
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    protected File getResourceFile(String fileResource) {
        return new File(Objects.requireNonNull(getClass()
            .getClassLoader()
            .getResource(fileResource))
            .getFile()
        );
    }

    @Test
    public abstract void testDeserialization() throws IOException;
}
