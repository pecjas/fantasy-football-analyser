package ffb.analyzer.models.espn;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;

/**
 * Unit tests for {@link MatchupDetails}.
 */
public class MatchupDetailsTest extends DeserializingResourceLoader {

    @Override
    public void testDeserialization() throws IOException {
        List<MatchupDetails> matchups = deserializeObjects(MatchupDetails.class);

        Assert.assertEquals(1, matchups.size());
    }

    @Override
    protected String getResourceFileName() {
        return "schedule.json";
    }
}
