package ffb.analyzer.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class MatchupDataFrameTests {

    private static final List<String> LABELS = List.of(
        "Week",
        "Home Team",
        "Home Team Score",
        "Away Team",
        "Away Team Score"
    );

    private static final Map<Integer, String> LABELS_BY_COLUMN = Map.of(
        0, "Week",
        1, "Home Team",
        2, "Home Team Score",
        3, "Away Team",
        4, "Away Team Score"
    );

    private MatchupDataFrame df;

    @Before
    public void setup() {
        df = new MatchupDataFrame();
    }

    @Test
    public void testMatchUpDataFrameLabels() {
        Assert.assertEquals(LABELS, df.getLabels());
    }

    @Test
    public void testMatchUpDataFrameLabelsByColumn() {
        Assert.assertEquals(LABELS_BY_COLUMN, df.getLabelsByColumn());
    }
}
