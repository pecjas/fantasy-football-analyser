package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SeasonMatchups {

    private DraftDetail draftDetails;
    private int gameId;
    private int id;
    private int segmentId;

    @JsonProperty("status")
    private LeagueInformation leagueInformation;

    @JsonProperty("seasonId")
    private int season;

    @JsonProperty("scoringPeriodId")
    private int year;

    @JsonProperty("schedule")
    private List<MatchupDetails> matchupDetails;

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

    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    public LeagueInformation getLeagueInformation() {
        return leagueInformation;
    }

    public void setLeagueInformation(LeagueInformation leagueInformation) {
        this.leagueInformation = leagueInformation;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<MatchupDetails> getMatchupDetails() {
        return matchupDetails;
    }

    public void setMatchupDetails(List<MatchupDetails> matchupDetails) {
        this.matchupDetails = matchupDetails;
    }


}
