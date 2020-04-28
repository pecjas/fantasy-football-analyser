package ffb.analyzer.models.espn;

import ffb.analyzer.models.espn.deserializers.ScoresByStatDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = ScoresByStatDeserializer.class)
public class ScoresByStats extends EspnEntity<ScoresByStats> {
    private List<ScoreByStat> scores;

    public ScoresByStats() {
        this.scores = new ArrayList<>();
    }

    public List<ScoreByStat> getScores() {
        return scores;
    }

    public void setScores(List<ScoreByStat> score) {
        this.scores = score;
    }
}
