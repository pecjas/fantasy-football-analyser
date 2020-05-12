package ffb.analyzer.models.espn;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ffb.test.utilities.GenericTestUtils;

public class TeamRecordOverallTests extends BaseSerializationTests {

    private static ObjectMapper MAPPER;

    @BeforeClass
    public static void buildPrep() {
        MAPPER  = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    @Override
    public void testSerialization() throws JsonProcessingException {
        TeamRecordOverall record = new TeamRecordOverall();

        record.setPointsFor(3);
        record.setPointsAgainst(1000.3f);
        record.setGamesBack(2);
        record.setLosses(2);
        record.setStreakLength(2);
        record.setStreakType(TeamRecordBase.StreakType.LOSS);
        record.setWinPercentage(6);
        record.setTies(2);
        record.setWinPercentage(0.2f);

        String json = MAPPER.writeValueAsString(record);

        Assert.assertFalse(json.isEmpty());
    }

    @Override
    public void testDeserialization() throws IOException {
        List<Team> teamRecord = deserializeObjects(Team.class);

        GenericTestUtils.validateGetMethodsReturnNonNullValue(teamRecord);
    }

    @Override
    protected String getResourceFileName() {
        return "team-record.json";
    }

    @Override
    protected Class<?> getClassUnderTesting() {
        return TeamRecordOverall.class;
    }
}