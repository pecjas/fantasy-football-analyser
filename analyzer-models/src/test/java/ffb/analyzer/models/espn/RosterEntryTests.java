package ffb.analyzer.models.espn;

import org.junit.Assert;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class RosterEntryTests extends DeserializingResourceLoader {
    private static final Long EPOCH_MILLISECONDS = 1566059532616L;
    private static final LocalDate EXPECTED_ACQUISITION_DATE =
        LocalDate.ofInstant(Instant.ofEpochMilli(EPOCH_MILLISECONDS), ZoneId.systemDefault());

    @Override
    protected String getResourceFileName() {
        return "roster-entry.json";
    }

    @Override
    public void testDeserialization() throws IOException {
        RosterEntry rosterEntry = deserializeSingleObject(RosterEntry.class);

        Assert.assertEquals(EXPECTED_ACQUISITION_DATE, rosterEntry.getAcquisitionDate());
        Assert.assertEquals(RosterEntry.AcquisitionType.DRAFT, rosterEntry.getAcquisitionType());
        Assert.assertEquals(Player.InjuryStatus.NORMAL, rosterEntry.getInjuryStatus());
        Assert.assertEquals(20, rosterEntry.getLineupSlotId());
        Assert.assertEquals(15825, rosterEntry.getPlayerId());
        Assert.assertEquals(RosterEntry.RosterStatus.NORMAL, rosterEntry.getStatus());
    }
}
