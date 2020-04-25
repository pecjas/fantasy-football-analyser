package ffb.analyzer.models.espn;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class LeagueInformationTests extends DeserializingResourceLoader {

    private static final String LEAGUE_INFORMATION_FILE = "league-information.json";
    private static final Date TEST_DATE = new Date("1/1/2020");


    @Override
    public void testDeserialization() throws IOException {
        File file = getResourceFile(LEAGUE_INFORMATION_FILE);

        LeagueInformation leagueInfo = mapper.readValue(file, LeagueInformation.class);
        //Tuesday, July 2, 2019 12:03:29.235 AM
        //TODO: Refactor into own method
        Assert.assertEquals(TEST_DATE, leagueInfo.getActivatedDate());
        Assert.assertEquals(LeagueInformation.LeagueType.PRIVATE, leagueInfo.getCreatedAsType());
        Assert.assertEquals(LeagueInformation.LeagueType.PRIVATE, leagueInfo.getCurrentType());
        Assert.assertEquals(16, leagueInfo.getCurrentWeek());
        Assert.assertEquals(16, leagueInfo.getFinalWeek());
        Assert.assertEquals(1, leagueInfo.getFirstWeek());
        Assert.assertTrue(leagueInfo.isActive());
        Assert.assertFalse(leagueInfo.isExpired());
        Assert.assertTrue(leagueInfo.isFull());
        Assert.assertFalse(leagueInfo.willBeDeleted());
        Assert.assertTrue(leagueInfo.isViewable());
        Assert.assertEquals(18, leagueInfo.getLastScoringPeriod());

        Assert.assertEquals(6, leagueInfo.getPreviousSeasons().size());
        Assert.assertEquals(TEST_DATE, leagueInfo.getStandingsUpdateDate());
        Assert.assertEquals(12, leagueInfo.getTeamsJoined());
        Assert.assertEquals(18, leagueInfo.getTransactionScoringPeriod());
        Assert.assertEquals(3, leagueInfo.getTransactions().size()); //TODO: Check dates and counts


    }
}
