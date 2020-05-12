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

public class TeamRecordOverallTests {
    private static final String TEAM_RECORDS = "team-record.json";

    private static ObjectMapper MAPPER;

    @BeforeClass
    public static void buildPrep() {
        MAPPER  = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    @Test
    public void testTeamSerialization() throws JsonProcessingException, MalformedURLException {
        TeamRecordOverall record = new TeamRecordOverall();

        record.setPointsFor(3);
        record.setPointsAgainst(1000.3f);
        record.setGamesBack(2);
        record.setLosses(2);
        record.setStreakLength(2);
        record.setStreakType(TeamRecordBase.StreakType.LOSS);
        record.setTies(2);

        String json = MAPPER.writeValueAsString(record);

        Assert.assertFalse(json.isEmpty());
    }

    @Test
    public void testTeamDeserialization() throws IOException, InvocationTargetException, IllegalAccessException {

        File file = new File(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource(TEAM_RECORDS)
        ).getFile());

        List<TeamRecordOverall> teamRecords = MAPPER.readValue(file,
                MAPPER.getTypeFactory().constructCollectionType(List.class, TeamRecordOverall.class));

        GenericTestUtils.validateGetMethodsReturnNonNullValue(teamRecords);
    }
}