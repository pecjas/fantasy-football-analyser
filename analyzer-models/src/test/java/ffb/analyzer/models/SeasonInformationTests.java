package ffb.analyzer.models;

import ffb.analyzer.models.espn.ScoringPeriod;
import ffb.analyzer.models.espn.SeasonInformation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SeasonInformationTests {

    private static final String SEASON_INFORMATION_FILE = "season-information.json";
    private static final int EXPECTED_SEASON_COUNT = 17;
    private static final Date END_DATE = new Date();
    private static final Date START_DATE = new Date();
    private static final int ID = 2020;

    private static ObjectMapper mapper;

    @BeforeClass
    public static void prepareForTests() {
        mapper = new ObjectMapper();
    }

    /**
     * Verifies that a {@link SeasonInformation} can be serialized to JSON.
     *
     * @throws JsonProcessingException Thrown if serialization fails.
     */
    @Test
    public void testSeasonInformationSerialization() throws JsonProcessingException {
        ScoringPeriod scoringPeriod = new ScoringPeriod();
        scoringPeriod.setId(ID);

        SeasonInformation info = new SeasonInformation();
        info.setAbbreviation("AAA");
        info.setActiveStatus(true);
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
     * @throws IOException Thrown if serialization fails, or resource does not exist.
     */
    @Test
    public void testSeasonInformationDeserialization() throws IOException {
        File file = new File(Objects.requireNonNull(getClass()
            .getClassLoader()
            .getResource(SEASON_INFORMATION_FILE))
            .getFile());

        List<SeasonInformation> seasons = mapper.readValue(file,
            mapper.getTypeFactory().constructCollectionType(List.class, SeasonInformation.class));

        Assert.assertFalse(seasons.isEmpty());
        Assert.assertEquals(EXPECTED_SEASON_COUNT, seasons.size());
    }
}
