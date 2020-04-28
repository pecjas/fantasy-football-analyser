package ffb.analyzer.models.espn;

import org.junit.Assert;

import java.io.IOException;

public class RosterTests extends DeserializingResourceLoader {
    private static final double EXPECTED_APPLIED_STAT_TOTAL = 28.1;

    @Override
    public void testDeserialization() throws IOException {
        Roster roster = deserializeSingleObject(Roster.class);

        Assert.assertEquals(EXPECTED_APPLIED_STAT_TOTAL, roster.getAppliedStatTotal(), 0.00001);
        Assert.assertEquals(1, roster.getPlayers().size());
    }

    @Override
    protected String getResourceFileName() {
        return "roster.json";
    }
}
