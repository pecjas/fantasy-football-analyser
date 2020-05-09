package ffb.analyzer.core.queue;

import java.util.function.Consumer;

public class PrioritizedTask<T> extends Task<T> implements Comparable<PrioritizedTask<T>> {
    private Integer priority;

    @Override
    public int compareTo(PrioritizedTask<T> otherTask) {
        return (this.getPriority() - otherTask.getPriority());
    }

    public PrioritizedTask(int id, int priority, T object, Consumer<T> action) {
        super(object, action);
        this.id = id;
        this.priority = priority;
    }

    public PrioritizedTask(int priority, T object, Consumer<T> action) {
        super(object, action);
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }
}
