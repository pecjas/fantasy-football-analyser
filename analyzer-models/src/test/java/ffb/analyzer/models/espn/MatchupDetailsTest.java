package ffb.analyzer.models.espn;

import org.junit.Assert;

import java.io.IOException;
import java.util.List;

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
