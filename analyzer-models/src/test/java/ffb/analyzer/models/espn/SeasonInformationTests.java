package ffb.analyzer.models.espn;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

import ffb.analyzer.core.utilities.DateUtils;


/**
 * Unit tests for {@link SeasonInformation}.
 */
public class SeasonInformationTests extends DeserializingResourceLoader {

    private static final int EXPECTED_INT_VALUE = 5;
    private static final int EXPECTED_YEAR = 2020;
    private static final String EXPECTED_SEASON_NAME = "Fantasy Football 2020";
    private static final String EXPECTED_SEASON_ABBREVIATION = "FFL 2020";
    private static final int EXPECTED_SEASON_COUNT = 1;
    private static final LocalDate END_DATE = DateUtils.fromEpochMillisecond(1646809200000L);
    private static final LocalDate START_DATE = DateUtils.fromEpochMillisecond(1583737200000L);
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
        Assert.assertTrue(season.isDisplayable());

        Assert.assertEquals(EXPECTED_INT_VALUE, season.getScoringPeriod().getId());
        Assert.assertEquals(EXPECTED_INT_VALUE, season.getGameId());
        Assert.assertEquals(EXPECTED_YEAR, season.getYear());
        Assert.assertEquals(EXPECTED_INT_VALUE, season.getDisplayOrder());

        Assert.assertEquals(START_DATE, season.getStartDate());
        Assert.assertEquals(END_DATE, season.getEndDate());

        Assert.assertTrue(season.getName().equalsIgnoreCase(EXPECTED_SEASON_NAME));
        Assert.assertTrue(season.getAbbreviation().equalsIgnoreCase(EXPECTED_SEASON_ABBREVIATION));
    }

    @Override
    protected String getResourceFileName() {
        return "season-information.json";
    }
}
