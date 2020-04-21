package ffb.analyzer.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class DataFrame<T> {

    private final List<T> data;

    public DataFrame() {
        this.data = new ArrayList<T>();
    }

    public DataFrame(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public T get(int index) {
        return data.get(index);
    }

    public void add(T element) {
        data.add(element);
    }

    public void remove(T element) {
        data.remove(element);
    }

    public List<T> find(Predicate<T> filterCriteria) {
        return data.stream().filter(filterCriteria).collect(Collectors.toList());
    }

    public abstract List<String> getLabels();

    public abstract Map<Integer, String> getLabelsByColumn();
}
