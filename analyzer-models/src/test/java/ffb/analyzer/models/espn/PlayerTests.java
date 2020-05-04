package ffb.analyzer.models.espn;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

/**
 * Unit tests for {@link Player}.
 */
public class PlayerTests extends BaseSerializationTests {
    private static final int EXPECTED_PRO_TEAM_ID = 20;
    private static final int EXPECTED_PLAYER_ID = 15825;
    private static final String EXPECTED_FIRST_NAME = "FIRST";
    private static final String EXPECTED_LAST_NAME = "Last";
    private static final String EXPECTED_FULL_NAME = String.format("%s %s", EXPECTED_FIRST_NAME, EXPECTED_LAST_NAME);

    private static final List<Integer> EXPECTED_ELIGIBLE_SLOTS = List.of(
        2,
        3,
        23,
        7,
        20,
        21
    );

    @Override
    public void testDeserialization() throws IOException {
        Player player = deserializeSingleObject(Player.class);

        Assert.assertEquals(EXPECTED_PLAYER_ID, player.getId());
        Assert.assertTrue(player.isActive());
        Assert.assertFalse(player.isInjured());
        Assert.assertTrue(player.isDroppable());

        Assert.assertEquals(Player.InjuryStatus.ACTIVE, player.getInjuryStatus());
        Assert.assertEquals(Player.Position.RB, player.getPosition());

        Assert.assertTrue(player.getFullName().equalsIgnoreCase(EXPECTED_FULL_NAME));
        Assert.assertTrue(player.getFirstName().equalsIgnoreCase(EXPECTED_FIRST_NAME));
        Assert.assertTrue(player.getLastName().equalsIgnoreCase(EXPECTED_LAST_NAME));

        Assert.assertEquals(EXPECTED_ELIGIBLE_SLOTS, player.getEligibleSlots());
        Assert.assertEquals(EXPECTED_PRO_TEAM_ID, player.getProTeamId());
    }

    @Override
    protected String getResourceFileName() {
        return "player.json";
    }

    @Override
    protected Class<?> getClassUnderTest() {
        return Player.class;
    }
}
