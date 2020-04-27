package ffb.analyzer.models.espn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ffb.analyzer.models.espn.Team;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.net.URL;

public class TeamTests {
    private static final String TEAMS = "teams.json";
    private static final int EXPECTED_TEAM_COUNT = 10;

    private static ObjectMapper MAPPER;

    @BeforeClass
    public static void buildPrep() {
        MAPPER  = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    @Test
    public void testTeamSerialization() throws JsonProcessingException, MalformedURLException {
        DraftStrategy strategy = new DraftStrategy();

        List<String> owners = new ArrayList<String>();
        owners.add("{E051BF6F-D9BD-46FA-91BF-6FD9BD86FA35}");
        owners.add("{34710321-F3A4-4E6E-B103-21F3A4BE6E7A}");
        owners.add("{52DA8CA9-8127-44FD-9A8C-A9812764FDE9}");

//        TeamRecordOverall overallRecord = (TeamRecordOverall) BASE_RECORD;
//        overallRecord.setPointsAgainst(657.2f);
//        overallRecord.setPointsFor(712);

        TeamRecord record = new TeamRecord();
//        record.setAwayRecord((TeamRecordAway) BASE_RECORD);
//        record.setDivisionRecord((TeamRecordDivision) BASE_RECORD);
//        record.setHomeRecord((TeamRecordHome) BASE_RECORD);
//        record.setOverallRecord(overallRecord);

        TransactionCounter transactionCounter = new TransactionCounter();
        transactionCounter.setAcquisitionBudgetSpent(13);
        transactionCounter.setCountOfTrades(13);
        transactionCounter.setCountPlayerMovesToActiveRoster(42);
        transactionCounter.setCountPlayerMovesToIR(2);
        transactionCounter.setDroppedPlayerCount(8);
        transactionCounter.setWaiverAcquisitions(11);

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

    @Test
    public void testTeamDeserialization() throws IOException {

        File file = new File(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource(TEAMS)
        ).getFile());

        List<Team> teams = MAPPER.readValue(file,
                MAPPER.getTypeFactory().constructCollectionType(List.class, Team.class));

        Assert.assertEquals(EXPECTED_TEAM_COUNT, teams.size());
    }
}
