package ffb.analyzer.models;

import ffb.analyzer.models.espn.Matchup;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatchupDataFrame extends DataFrame<Matchup> {

    private static final List<String> LABELS = List.of(
        "Week",
        "Home Team",
        "Home Team Score",
        "Away Team",
        "Away Team Score"
    );

    private static final Map<Integer, String> LABELS_BY_COLUMN;

    static {
        LABELS_BY_COLUMN = IntStream.range(0 , LABELS.size())
            .boxed()
            .collect(Collectors.toMap(i -> i, LABELS::get));
    }

    private Map<Integer, List<Matchup>> matchupsByWeek;
    private Map<Integer, List<Matchup>> matchupsByHomeTeam;
    private Map<Integer, List<Matchup>> matchupsByAwayTeam;

    @Override
    public void add(Matchup element) {
        super.add(element);
        resetCache();
    }

    @Override
    public void remove(Matchup element) {
        super.remove(element);
        resetCache();
    }

    private void resetCache() {
        matchupsByWeek.clear();
        matchupsByHomeTeam.clear();
        matchupsByAwayTeam.clear();
    }

    @Override
    public List<String> getLabels() {
        return LABELS;
    }

    @Override
    public Map<Integer, String> getLabelsByColumn() {
        return LABELS_BY_COLUMN;
    }

    public Map<Integer, List<Matchup>> getMatchupsByWeek() {
        if (matchupsByWeek == null || matchupsByWeek.size() == 0) {
            matchupsByWeek = getData().stream()
                .collect(Collectors.groupingBy(Matchup::getWeekId, Collectors.toList()));
        }

        return matchupsByWeek;
    }

    public Map<Integer, List<Matchup>> getMatchupsByHomeTeam() {
        if (matchupsByHomeTeam == null || matchupsByHomeTeam.size() == 0) {
            matchupsByHomeTeam =
                getData().stream().collect(Collectors.groupingBy(Matchup::getHomeTeamId, Collectors.toList()));
        }

        return matchupsByHomeTeam;
    }

    public Map<Integer, List<Matchup>> getMatchupsByAwayTeam() {
        if (matchupsByAwayTeam == null || matchupsByAwayTeam.size() == 0) {
            matchupsByAwayTeam =
                getData().stream().collect(Collectors.groupingBy(Matchup::getAwayTeamId, Collectors.toList()));
        }

        return matchupsByAwayTeam;
    }

}
