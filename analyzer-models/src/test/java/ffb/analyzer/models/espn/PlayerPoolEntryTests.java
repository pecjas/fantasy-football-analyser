package ffb.analyzer.models.espn;

import java.io.IOException;

import org.junit.Assert;

/**
 * Unit tests for a {@link PlayerPoolEntry}.
 */
public class PlayerPoolEntryTests extends DeserializingResourceLoader {
    private static final double EXPECTED_STAT_TOTAL = 7.7;
    private static final int EXPECTED_PLAYER_ID = 15825;
    private static final int EXPECTED_TEAM_ID = 1;
    private static final double DELTA = .1;

    @Override
    public void testDeserialization() throws IOException {
        PlayerPoolEntry ppe = deserializeSingleObject(PlayerPoolEntry.class);

        Assert.assertEquals(EXPECTED_STAT_TOTAL, ppe.getAppliedStatTotal(), DELTA);
        Assert.assertEquals(EXPECTED_PLAYER_ID, ppe.getId());
        Assert.assertEquals(EXPECTED_TEAM_ID, ppe.getTeamId());

        Assert.assertTrue(ppe.isRosterLocked());
        Assert.assertFalse(ppe.isTradeLocked());
        Assert.assertTrue(ppe.isLineupLocked());

        Assert.assertEquals(PlayerPoolEntry.PlayerStatus.ON_TEAM, ppe.getStatus());
    }

    @Override
    protected String getResourceFileName() {
        return "player-pool-entry.json";
    }
}
