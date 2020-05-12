package ffb.analyzer.models.espn;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ffb.test.utilities.GenericTestUtils;

public class TeamRecordTests extends BaseSerializationTests {
    private static final int EXPECTED_TEAM_COUNT = 10;

    private static ObjectMapper MAPPER;

    @BeforeClass
    public static void buildPrep() {
        MAPPER  = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    @Override
    public void testSerialization() throws JsonProcessingException, MalformedURLException {
        TeamRecord record = new TeamRecord();

        record.setOverallRecord(new TeamRecordOverall());
        record.setHomeRecord(new TeamRecordHome());
        record.setAwayRecord(new TeamRecordAway());
        record.setDivisionRecord(new TeamRecordDivision());

        String json = MAPPER.writeValueAsString(record);

        Assert.assertFalse(json.isEmpty());
    }

    @Override
    public void testDeserialization() throws IOException {
        List<Team> teamRecords = deserializeObjects(Team.class);

        Assert.assertEquals(EXPECTED_TEAM_COUNT, teamRecords.size());
        GenericTestUtils.validateGetMethodsReturnNonNullValue(teamRecords);
    }

    @Override
    protected String getResourceFileName() {
        return "team-records.json";
    }

    @Override
    protected Class<?> getClassUnderTesting() {
        return TeamRecord.class;
    }
}