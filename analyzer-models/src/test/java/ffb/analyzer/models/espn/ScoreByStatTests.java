package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ffb.analyzer.models.espn.ScoreByStat;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ScoreByStatTests {

    private static final String SCORE_BY_STATS_FILE = "score-by-stat.json";

    @Test
    public void testScoreByStatDeserialization() throws IOException {
        File file = new File(Objects.requireNonNull(getClass()
            .getClassLoader()
            .getResource(SCORE_BY_STATS_FILE))
            .getFile());

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        List<ScoreByStat> scores = mapper.readValue(file,
            mapper.getTypeFactory().constructCollectionType(List.class, ScoreByStat.class));

        Assert.assertEquals(1, scores.size());

    }
}
