package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class EspnEntity<T extends BaseEspnEntity<T>> implements BaseEspnEntity<T> {
}
