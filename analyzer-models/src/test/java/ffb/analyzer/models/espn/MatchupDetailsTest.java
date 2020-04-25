package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MatchupDetailsTest extends DeserializingResourceLoader {
    private static final String SCHEDULE_FILE = "schedule.json";

    @Test
    public void testDeserialization() throws IOException {
        File file = getResourceFile(SCHEDULE_FILE);

        ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<MatchupDetails> matchups = mapper.readValue(
            file, mapper.getTypeFactory().constructCollectionType(List.class, MatchupDetails.class)
        );

        Assert.assertEquals(1, matchups.size());
    }
}
