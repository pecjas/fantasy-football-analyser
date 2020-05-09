package ffb.analyzer.models.espn;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.Assert;

import ffb.analyzer.core.utilities.DateUtils;

/**
 * Unit Tests for {@link LeagueInformation}.
 */
public class LeagueInformationTests extends BaseSerializationTests {

    private static final int EXPECTED_WEEK = 16;
    private static final int EXPECTED_NUMBER_OF_TEAMS = 12;
    private static final int EXPECTED_SCORING_PERIOD = 18;

    private static final LocalDate EXPECTED_DATE = LocalDate.of(2020, 1, 1);
    private static final List<Integer> PREVIOUS_SEASONS = List.of(
        2014,
        2015,
        2016,
        2017,
        2018,
        2019
    );

    private static final Map<String, Integer> RAW_EXPECTED_TRANSACTION_COUNT = Map.of(
        "2019-08-19T07:41:09.149+0000", 3,
        "2019-09-03T07:38:44.151+0000", 1,
        "2019-07-03T07:38:44.151+0000", 5
    );

    private static final Map<LocalDate, Integer> EXPECTED_TRANSACTION_COUNTS;

    static {
        EXPECTED_TRANSACTION_COUNTS = RAW_EXPECTED_TRANSACTION_COUNT
            .entrySet()
            .stream()
            .collect(Collectors.toMap(entry ->
                DateUtils.fromString(entry.getKey(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
                Entry::getValue)
            );
    }

    @Override
    public void testDeserialization() throws IOException {
        LeagueInformation leagueInfo = deserializeSingleObject(LeagueInformation.class);

        checkBasicLeagueInformation(leagueInfo);
        checkScoringInformation(leagueInfo);
        checkTransactionHistory(leagueInfo);
        checkPreviousSeasons(leagueInfo);
    }

    private void checkBasicLeagueInformation(LeagueInformation league) {
        Assert.assertEquals(EXPECTED_DATE, league.getActivatedDate());

        Assert.assertEquals(LeagueInformation.LeagueType.PRIVATE, league.getCreatedAsType());
        Assert.assertEquals(LeagueInformation.LeagueType.PRIVATE, league.getCurrentType());

        Assert.assertTrue(league.isActive());
        Assert.assertTrue(league.isFull());
        Assert.assertTrue(league.isViewable());

        Assert.assertFalse(league.isExpired());
        Assert.assertFalse(league.getIsToBeDeleted());

        Assert.assertEquals(EXPECTED_NUMBER_OF_TEAMS, league.getTeamsJoined());
    }

    private void checkScoringInformation(LeagueInformation league) {
        Assert.assertEquals(EXPECTED_WEEK, league.getCurrentWeek());
        Assert.assertEquals(EXPECTED_WEEK, league.getFinalWeek());
        Assert.assertEquals(EXPECTED_WEEK, league.getFirstWeek());

        Assert.assertEquals(EXPECTED_SCORING_PERIOD, league.getLastScoringPeriod());
        Assert.assertEquals(EXPECTED_SCORING_PERIOD, league.getTransactionScoringPeriod());

        Assert.assertEquals(EXPECTED_DATE, league.getStandingsUpdateDate());
    }

    private void checkTransactionHistory(LeagueInformation league) {
        Map<LocalDate, Integer> transactions = league.getTransactions();

        Assert.assertEquals(EXPECTED_TRANSACTION_COUNTS.size(), transactions.size());
        transactions.forEach((key, value) -> Assert.assertEquals(value, EXPECTED_TRANSACTION_COUNTS.get(key)));
    }

    private void checkPreviousSeasons(LeagueInformation league) {
        List<Integer> previousSeasons = league.getPreviousSeasons();

        Assert.assertEquals(PREVIOUS_SEASONS.size(), previousSeasons.size());

        previousSeasons.forEach(year -> Assert.assertTrue(PREVIOUS_SEASONS.contains(year)));
    }

    @Override
    protected String getResourceFileName() {
        return "league-information.json";
    }

    @Override
    protected Class<?> getClassUnderTesting() {
        return LeagueInformation.class;
    }
}
