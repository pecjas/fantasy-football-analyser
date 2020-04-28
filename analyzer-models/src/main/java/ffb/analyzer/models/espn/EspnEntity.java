package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Base class to serialize JSON from the ESPN APIs.
 * @param <T> Type of ESPN Entity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class EspnEntity<T extends BaseEspnEntity<T>> implements BaseEspnEntity<T> {
}
