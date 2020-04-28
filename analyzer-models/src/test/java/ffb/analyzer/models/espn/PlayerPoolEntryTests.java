package ffb.analyzer.models.espn;

import java.io.IOException;
import org.junit.Assert;

/**
 * Unit tests for a {@link PlayerPoolEntry}.
 */
public class PlayerPoolEntryTests extends DeserializingResourceLoader {

    @Override
    public void testDeserialization() throws IOException {
        PlayerPoolEntry ppe = deserializeSingleObject(PlayerPoolEntry.class);

        Assert.assertEquals(7.7, ppe.getAppliedStatTotal(), .1);
        Assert.assertEquals(15825, ppe.getId());
        Assert.assertTrue(ppe.isLineupLocked());
        Assert.assertEquals(1, ppe.getTeamId());
        Assert.assertTrue(ppe.isRosterLocked());
        Assert.assertFalse(ppe.isTradeLocked());
        Assert.assertEquals(PlayerPoolEntry.PlayerStatus.ON_TEAM, ppe.getStatus());
    }

    @Override
    protected String getResourceFileName() {
        return "player-pool-entry.json";
    }
}
