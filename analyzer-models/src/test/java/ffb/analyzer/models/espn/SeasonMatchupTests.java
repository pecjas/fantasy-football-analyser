package ffb.analyzer.models.espn;

import java.io.IOException;

/**
 * Unit tests for {@link SeasonMatchups}.
 */
public class SeasonMatchupTests extends DeserializingResourceLoader {

    @Override
    public void testDeserialization() throws IOException {
        deserializeSingleObject(SeasonMatchups.class);
    }

    @Override
    protected String getResourceFileName() {
        return "season-matchups.json";
    }
}
