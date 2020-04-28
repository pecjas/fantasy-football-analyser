package ffb.analyzer.models.espn;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;

/**
 * Unit tests for {@link Player}.
 */
public class PlayerTests extends DeserializingResourceLoader {

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

        Assert.assertEquals(15825, player.getId());
        Assert.assertTrue(player.isActive());
        Assert.assertFalse(player.isInjured());
        Assert.assertTrue(player.isDroppable());

        Assert.assertEquals(Player.InjuryStatus.ACTIVE, player.getStatus());
        Assert.assertEquals(Player.Position.RB, player.getPosition());

        Assert.assertTrue(player.getFullName().equalsIgnoreCase("First Last"));
        Assert.assertTrue(player.getFirstName().equalsIgnoreCase("First"));
        Assert.assertTrue(player.getLastName().equalsIgnoreCase("Last"));

        Assert.assertEquals(EXPECTED_ELIGIBLE_SLOTS, player.getEligibleSlots());
        Assert.assertEquals(20, player.getProTeamId());
    }

    @Override
    protected String getResourceFileName() {
        return "player.json";
    }
}
