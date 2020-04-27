package ffb.analyzer.models.espn;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeagueInformationTests extends DeserializingResourceLoader {

    private static final String LEAGUE_INFORMATION_FILE = "league-information.json";
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        EXPECTED_TRANSACTION_COUNTS = RAW_EXPECTED_TRANSACTION_COUNT
            .entrySet()
            .stream()
            .collect(Collectors.toMap(entry -> {
                String date = entry.getKey();
                return LocalDate.parse(entry.getKey(), formatter);
            }, Map.Entry::getValue));
    }

    @Override
    public void testDeserialization() throws IOException {
        File file = getResourceFile(LEAGUE_INFORMATION_FILE);
        LeagueInformation leagueInfo = mapper.readValue(file, LeagueInformation.class);

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
        Assert.assertFalse(league.willBeDeleted());

        Assert.assertEquals(12, league.getTeamsJoined());
    }

    private void checkScoringInformation(LeagueInformation league) {
        Assert.assertEquals(16, league.getCurrentWeek());
        Assert.assertEquals(16, league.getFinalWeek());
        Assert.assertEquals(1, league.getFirstWeek());
        Assert.assertEquals(18, league.getLastScoringPeriod());
        Assert.assertEquals(18, league.getTransactionScoringPeriod());
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
}
