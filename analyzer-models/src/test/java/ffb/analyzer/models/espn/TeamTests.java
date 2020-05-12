package ffb.analyzer.models.espn;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ffb.test.utilities.GenericTestUtils;

public class TeamTests extends BaseSerializationTests {
    private static final int EXPECTED_TEAM_COUNT = 2;

    private static ObjectMapper MAPPER;

    @BeforeClass
    public static void buildPrep() {
        MAPPER  = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    @Override
    public void testSerialization() throws JsonProcessingException, MalformedURLException {
        DraftStrategy strategy = new DraftStrategy();

        List<String> owners = List.of(
                "{E051BF6F-D9BD-46FA-91BF-6FD9BD86FA35}",
                "{34710321-F3A4-4E6E-B103-21F3A4BE6E7A}",
                "{52DA8CA9-8127-44FD-9A8C-A9812764FDE9}"
        );

        TeamRecord record = new TeamRecord();


        TransactionCounter transactionCounter = new TransactionCounter();

        Team team = new Team();
        team.setAbbreviation("PACK");
        team.setActive(true);
        team.setCurrentProjectedRank(2);
        team.setCurrentWaiverWireRank(9);
        team.setDivisionId(1);
        team.setDraftDayProjectedRank(10);
        team.setDraftStrategy(strategy);
        team.setId(3);
        team.setLocation("Tampa");
        team.setLogo(new URL("http://g.espncdn.com/s/ffllm/logos/SuperCrusher-JamesYang/SuperCrusher-16.svg"));
        team.setNickname("Bob's Temporary Tanning Salon");
        team.setOwners(owners);
        team.setPrimaryOwner("{52DA8CA9-8127-44FD-9A8C-A9812764FDE9}");
        team.setPlayoffSeed(2);
        team.setRecord(record);
        team.setRegularSeasonPoints(754);
        team.setTransactionCounter(transactionCounter);

        String json = MAPPER.writeValueAsString(team);

        Assert.assertFalse(json.isEmpty());
    }

    @Override
    public void testDeserialization() throws IOException {
        List<Team> teams = deserializeObjects(Team.class);

        Assert.assertEquals(EXPECTED_TEAM_COUNT, teams.size());
        GenericTestUtils.validateGetMethodsReturnNonNullValue(teams);
    }

    @Override
    protected String getResourceFileName() {
        return "teams.json";
    }

    @Override
    protected Class<?> getClassUnderTesting() {
        return Team.class;
    }
}
