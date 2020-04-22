package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public abstract class EspnEntity<T extends BaseEspnEntity<?>> implements BaseEspnEntity<T> {
}
