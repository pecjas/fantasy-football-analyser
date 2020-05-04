package ffb.analyzer.models.espn;

import org.junit.Assert;

import java.io.IOException;

/**
 * Unit tests for {@link SeasonMatchups}.
 */
public class SeasonMatchupTests extends BaseSerializationTests {

    @Override
    public void testDeserialization() throws IOException {
        deserializeSingleObject(SeasonMatchups.class);
    }

    @Override
    protected String getResourceFileName() {
        return "season-matchups.json";
    }

    @Override
    protected Class<?> getClassUnderTest() {
        return SeasonMatchups.class;
    }
}
