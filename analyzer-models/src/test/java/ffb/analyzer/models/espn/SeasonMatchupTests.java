package ffb.analyzer.models.espn;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SeasonMatchupTests extends DeserializingResourceLoader {

    @Test
    public void testDeserialization() throws IOException {
        SeasonMatchups seasonMatchups = deserializeSingleObject(SeasonMatchups.class);
    }

    @Override
    protected String getResourceFileName() {
        return "season-matchups.json";
    }
}
