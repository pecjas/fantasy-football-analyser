package ffb.analyzer.models.espn;

import org.junit.Test;

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
