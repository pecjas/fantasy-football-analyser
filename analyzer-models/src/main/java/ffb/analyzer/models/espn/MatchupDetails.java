package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MatchupDetails {

    public enum Winner {
        HOME("HOME"),
        AWAY("AWAY");

        Winner(String winner) {
        }
    }

    private int id;
    private int weekId;
    private Winner winner;

    @JsonProperty("away")
    private List<TeamScore> awayTeamScores;

    @JsonProperty("home")
    private List<TeamScore> homeTeamScores;
}
