package ffb.analyzer.models.espn;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SeasonMatchupTests extends DeserializingResourceLoader {

    private static final String SEASON_MATCHUP_FILE = "season-matchups.json";

    @Test
    public void testDeserialization() throws IOException {
        File file = getResourceFile(SEASON_MATCHUP_FILE);

        SeasonMatchups seasonMatchups = mapper.readValue(
            file,
            new TypeReference<>() {}
        );
    }
}
