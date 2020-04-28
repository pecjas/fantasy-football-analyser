package ffb.analyzer.models.espn;

import org.junit.BeforeClass;
import java.io.IOException;

public class PlayerPoolEntryTests extends DeserializingResourceLoader {

    @Override
    public void testDeserialization() throws IOException {
        PlayerPoolEntry ppe = deserializeSingleObject(PlayerPoolEntry.class);
    }

    @Override
    protected String getResourceFileName() {
        return "player-pool-entry.json";
    }
}
