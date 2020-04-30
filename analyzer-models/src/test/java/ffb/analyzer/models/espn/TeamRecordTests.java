package ffb.analyzer.models.espn;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ffb.test.utilities.GenericTestUtils;

public class TeamRecordTests {
    private static final String TEAM_RECORDS = "team-records.json";
    private static final int EXPECTED_TEAM_COUNT = 10;

    private static ObjectMapper MAPPER;

    @BeforeClass
    public static void buildPrep() {
        MAPPER  = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    @Test
    public void testTeamSerialization() throws JsonProcessingException, MalformedURLException {
        TeamRecord record = new TeamRecord();

        record.setOverallRecord(new TeamRecordOverall());
        record.setHomeRecord(new TeamRecordHome());
        record.setAwayRecord(new TeamRecordAway());
        record.setDivisionRecord(new TeamRecordDivision());

        String json = MAPPER.writeValueAsString(record);

        Assert.assertFalse(json.isEmpty());
    }

    @Test
    public void testTeamDeserialization() throws IOException, InvocationTargetException, IllegalAccessException {

        File file = new File(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource(TEAM_RECORDS)
        ).getFile());

        List<TeamRecord> teamRecords = MAPPER.readValue(file,
                MAPPER.getTypeFactory().constructCollectionType(List.class, TeamRecord.class));

        Assert.assertEquals(EXPECTED_TEAM_COUNT, teamRecords.size());

        GenericTestUtils.validateGetMethodsReturnNonNullValue(teamRecords);
    }
}