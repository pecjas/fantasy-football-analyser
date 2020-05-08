package ffb.analyzer.core.queue;

public class PrioritizedTask<T> extends Task<T> implements Comparable<PrioritizedTask<T>> {
    private Integer priority;

    @Override
    public int compareTo(PrioritizedTask<T> otherTask) {
        return (this.getPriority() - otherTask.getPriority());
    }

    public PrioritizedTask(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public PrioritizedTask(int id, Integer priority) {
        this.id = id;
        this.priority = priority.intValue();
    }

    public Integer getPriority() {
        return priority;
    }
}
