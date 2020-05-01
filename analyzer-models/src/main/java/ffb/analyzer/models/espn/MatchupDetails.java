package ffb.analyzer.models.espn;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entity representing matchup details.
 */
public class MatchupDetails extends EspnEntity<MatchupDetails> {

    public enum Winner {
        HOME,
        AWAY
    }

    private int id;
    private int weekId;
    private Winner winner;

    @JsonProperty("away")
    private List<TeamScore> awayTeamScores;

    @JsonProperty("home")
    private List<TeamScore> homeTeamScores;

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
