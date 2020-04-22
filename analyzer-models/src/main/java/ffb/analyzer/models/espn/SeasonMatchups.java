package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SeasonMatchups {

    private DraftDetail draftDetails;
    private int gameId;
    private int id;
    private int segmentId;
    private LeagueInformation leagueInformation;

    @JsonProperty("seasonId")
    private int season;

    @JsonProperty("scoringPeriodId")
    private int year;

    @JsonProperty("schedule")
    private List<MatchupDetails> matchupDetails;

    @JsonProperty("matchupPeriodId")
    private int weekId;

    public DraftDetail getDraftDetails() {
        return draftDetails;
    }

    public void setDraftDetails(DraftDetail draftDetails) {
        this.draftDetails = draftDetails;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }
}
