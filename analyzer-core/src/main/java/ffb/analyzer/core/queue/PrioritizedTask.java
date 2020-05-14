package ffb.analyzer.core.queue;

import java.util.function.Consumer;

/***
 * A prioritized task to be added to a queue via PriorityQueueManager and performed asynchronously.
 * The order of task execution is determined by the priority assigned to the PrioritizedTask
 * @param <T> The type of object that the task's action will be performed on.
 */
public class PrioritizedTask<T> extends Task<T> implements Comparable<PrioritizedTask<T>> {
    public PrioritizedTask(int id, Priority priority, T object, Consumer<T> action) {
        super(object, action);
        this.id = id;
        this.priority = priority;
    }

    public PrioritizedTask(Priority priority, T object, Consumer<T> action) {
        super(object, action);
        this.priority = priority;
    }

    public enum Priority {
        LOWER(10),
        LOW(20),
        MEDIUM(30),
        HIGH(40),
        HIGHER(50);

        private final int value;

        Priority(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    private final Priority priority;

    @Override
    public int compareTo(PrioritizedTask<T> otherTask) {
        return (otherTask.getPriority().getValue() - getPriority().getValue());
    }

    public Priority getPriority() {
        return priority;
    }
}
