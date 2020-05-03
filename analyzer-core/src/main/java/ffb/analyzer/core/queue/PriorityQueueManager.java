package ffb.analyzer.core.queue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueHandler{
    private enum QueueState {
        STOPPED,
        RUNNING
    }

    private static final int MAX_CAPACITY = 1000;
    private static final int STARTING_TASK_ID = 1;

    private PriorityBlockingQueue<PriorityTask> queue;
    private int nextAvailableId;
    private QueueState state;

    /**
     * Adds entry to queue and updates tracking information within PriorityQueueHandler.
     * @param entry Task object to be added to the queue.
     * @return True if the entry was successfully added, otherwise False.
     */
    public boolean add(PriorityTask entry) {
        incrementNextAvailableId();

        return queue.add(entry);
    }

    public void incrementNextAvailableId() {
        if (nextAvailableId == Integer.MAX_VALUE) {
            nextAvailableId = STARTING_TASK_ID;
        }
        else {
            nextAvailableId += 1;
        }
    }


    public PriorityQueueHandler() {
        setQueue();
        nextAvailableId = STARTING_TASK_ID;
        state = QueueState.STOPPED;
    }


    public PriorityBlockingQueue getQueue() {
        if (queue == null) {
            setQueue();
        }

        return queue;
    }

    public void setQueue() {
        if (queue == null) {
            queue = new PriorityBlockingQueue<PriorityTask>(MAX_CAPACITY);
        }
    }

    public int getNextAvailableId() {
        return nextAvailableId;
    }

    public QueueState getState() {
        return state;
    }

    public void setState(QueueState state) {
        this.state = state;
    }
}
