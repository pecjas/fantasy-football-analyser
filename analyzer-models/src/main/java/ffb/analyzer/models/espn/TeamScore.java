package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class TeamScore {
    private CumulativeScore cumulativeScore;
    private int gamesPlayed;
    private int teamId;

    @JsonProperty("totalPoints")
    private float points;

    @JsonProperty("pointsByScoringPeriod")
    private Map<Integer, Float> scores;
}
