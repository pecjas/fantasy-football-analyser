package ffb.analyzer.models.espn;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Assert;

/**
 * Unit tests for {@link RosterEntry}.
 */
public class RosterEntryTests extends BaseSerializationTests {
    private static final Long EPOCH_MILLISECONDS = 1566059532616L;
    private static final LocalDate EXPECTED_ACQUISITION_DATE =
        LocalDate.ofInstant(Instant.ofEpochMilli(EPOCH_MILLISECONDS), ZoneId.systemDefault());
    private static final int EXPECTED_ROSTER_SIZE = 20;
    private static final int EXPECTED_PLAYER_ID = 15825;

    @Override
    public void testDeserialization() throws IOException {
        RosterEntry rosterEntry = deserializeSingleObject(RosterEntry.class);

        Assert.assertEquals(EXPECTED_ACQUISITION_DATE, rosterEntry.getAcquisitionDate());
        Assert.assertEquals(RosterEntry.AcquisitionType.DRAFT, rosterEntry.getAcquisitionType());

        Assert.assertEquals(EXPECTED_ROSTER_SIZE, rosterEntry.getLineupSlotId());
        Assert.assertEquals(EXPECTED_PLAYER_ID, rosterEntry.getPlayerId());

        Assert.assertEquals(RosterEntry.RosterStatus.NORMAL, rosterEntry.getStatus());
        Assert.assertEquals(Player.InjuryStatus.NORMAL, rosterEntry.getInjuryStatus());
    }

    @Override
    protected String getResourceFileName() {
        return "roster-entry.json";
    }

    @Override
    protected Class<?> getClassUnderTest() {
        return RosterEntry.class;
    }
}
