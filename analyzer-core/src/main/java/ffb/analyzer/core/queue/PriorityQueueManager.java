package ffb.analyzer.core.queue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityQueueManager {
    private enum QueueState {
        STOPPED,
        RUNNING
    }

    private static final int MAX_CAPACITY = 1000;
    private static final AtomicInteger STARTING_TASK_ID = new AtomicInteger(1);

    private PriorityBlockingQueue<PrioritizedTask<?>> queue;
    private final AtomicInteger nextAvailableId;
    private QueueState state;

    /**
     * Adds entry to queue and updates tracking information within PriorityQueueHandler.
     * @param entry Task object to be added to the queue.
     * @return True if the entry was successfully added, otherwise False.
     */
    public boolean addEntry(PrioritizedTask<?> entry) {
        entry.setId(getAndIncrementNextAvailableId());

        return queue.add(entry);
    }

    private int getAndIncrementNextAvailableId() {
        return nextAvailableId.getAndIncrement();
    }

    /***
     * Executes the next task on the queue, lowest priority first.
     */
    public void executeNextTask() {
        PrioritizedTask<?> taskToExecute;

        try {
            taskToExecute = (PrioritizedTask<?>) getQueue().poll();
            taskToExecute.performTask();
        } catch (Exception e) {
            //TODO: Log error
        }
    }

    public PriorityQueueManager() {
        setQueue();
        nextAvailableId = STARTING_TASK_ID;
        state = QueueState.STOPPED;
    }


    public PriorityBlockingQueue<?> getQueue() {
        if (queue == null) {
            setQueue();
        }

        return queue;
    }

    private void setQueue() {
        if (queue == null) {
            queue = new PriorityBlockingQueue<>(MAX_CAPACITY);
        }
    }

    public AtomicInteger getNextAvailableId() {
        return nextAvailableId;
    }

    public QueueState getState() {
        return state;
    }

    public void setState(QueueState state) {
        this.state = state;
    }
}
