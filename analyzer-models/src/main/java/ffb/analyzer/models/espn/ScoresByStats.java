package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ffb.analyzer.models.espn.deserializers.ScoresByStatDeserializer;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = ScoresByStatDeserializer.class)
public class ScoresByStats extends EspnEntity<ScoresByStats> {
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
