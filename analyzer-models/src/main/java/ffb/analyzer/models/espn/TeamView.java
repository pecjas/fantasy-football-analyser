package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Class representing the overall information for a league's teams for a given season.
 */
public class TeamView extends EspnEntity<TeamView> {
    private DraftDetail draftDetail;
    //TODO: gameId - what's this?

    @JsonProperty("id")
    private int leagueId;

    private List<Member> members;

    @JsonProperty("scoringPeriodId")
    private int scoringPeriod;

    @JsonProperty("seasonId")
    private int year;

    @JsonProperty("status")
    private LeagueInformation leagueInformation;

    private List<Team> teams;

    public DraftDetail getDraftDetail() { return draftDetail; }
    public void setDraftDetail(DraftDetail draftDetail) { this.draftDetail = draftDetail; }

    public int getLeagueId() { return leagueId; }
    public void setLeagueId(int leagueId) { this.leagueId = leagueId; }

    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }

    public int getScoringPeriod() { return scoringPeriod; }
    public void setScoringPeriod(int scoringPeriod) {
        this.scoringPeriod = scoringPeriod;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        this.year = year;
    }

    public LeagueInformation getLeagueInformation() { return leagueInformation; }
    public void setLeagueInformation(LeagueInformation leagueInformation) {
        this.leagueInformation = leagueInformation;
    }

    public List<Team> getTeams() { return teams; }
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
