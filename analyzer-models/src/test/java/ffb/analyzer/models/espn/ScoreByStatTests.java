package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScoreByStatTests extends DeserializingResourceLoader {

    @Test
    public void testDeserialization() throws IOException {

        List<ScoreByStat> scores = deserializeObjects(ScoreByStat.class);
        Assert.assertEquals(1, scores.size());
    }

    @Override
    protected String getResourceFileName() {
        return "score-by-stat.json";
    }
}
