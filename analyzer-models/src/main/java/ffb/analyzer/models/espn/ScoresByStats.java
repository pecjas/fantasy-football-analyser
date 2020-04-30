package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ffb.analyzer.models.espn.serialization.ScoresByStatDeserializer;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = ScoresByStatDeserializer.class)
public class ScoresByStats {
    List<ScoreByStat> scores;

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
