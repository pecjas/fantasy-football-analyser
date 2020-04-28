package ffb.analyzer.models.espn;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link SeasonInformation}.
 */
public class SeasonInformationTests extends DeserializingResourceLoader {

    private static final String SEASON_INFORMATION_FILE = "season-information.json";
    private static final int EXPECTED_SEASON_COUNT = 17;
    private static final LocalDate END_DATE =
        LocalDate.ofInstant(Instant.ofEpochMilli(1646809200000L), ZoneId.systemDefault());

    private static final LocalDate START_DATE =
        LocalDate.ofInstant(Instant.ofEpochMilli(1583737200000L), ZoneId.systemDefault());
    private static final int ID = 2020;

    /**
     * Verifies that a {@link SeasonInformation} can be serialized to JSON.
     *
     * @throws JsonProcessingException Thrown if deserializers fails.
     */
    @Test
    public void testSeasonInformationSerialization() throws JsonProcessingException {
        ScoringPeriod scoringPeriod = new ScoringPeriod();
        scoringPeriod.setId(ID);

        SeasonInformation info = new SeasonInformation();
        info.setAbbreviation("AAA");
        info.setActive(true);
        info.setDisplayOrder(0);
        info.setGameId(1);
        info.setName("Test Season");
        info.setScoringPeriod(scoringPeriod);
        info.setEndDate(END_DATE);
        info.setStartDate(START_DATE);
        String json = mapper.writeValueAsString(info);

        Assert.assertFalse(json.isEmpty());
    }

    /**
     * Verifies that JSON can be deserialied into {@link SeasonInformation}.
     *
     * @throws IOException Thrown if deserializers fails, or resource does not exist.
     */
    @Test
    public void testDeserialization() throws IOException {
        List<SeasonInformation> seasons = deserializeObjects(SeasonInformation.class);

        Assert.assertFalse(seasons.isEmpty());
        Assert.assertEquals(EXPECTED_SEASON_COUNT, seasons.size());

        checkForExpectedValues(seasons.get(0));
    }

    private void checkForExpectedValues(SeasonInformation season) {
        Assert.assertTrue(season.isActive());
        Assert.assertTrue(season.shouldDisplay());

        Assert.assertEquals(1, season.getScoringPeriod().getId());
        Assert.assertEquals(1, season.getGameId());
        Assert.assertEquals(2020, season.getYear());
        Assert.assertEquals(0, season.getDisplayOrder());

        Assert.assertEquals(START_DATE, season.getStartDate());
        Assert.assertEquals(END_DATE, season.getEndDate());

        Assert.assertTrue(season.getName().equalsIgnoreCase("Fantasy Football 2020"));
        Assert.assertTrue(season.getAbbreviation().equalsIgnoreCase("FFL 2020"));
    }

    @Override
    protected String getResourceFileName() {
        return "season-information.json";
    }
}
