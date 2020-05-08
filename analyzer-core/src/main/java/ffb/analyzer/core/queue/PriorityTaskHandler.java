package ffb.analyzer.core.queue;

abstract class PriorityTaskHandler {
    private PriorityTaskHandler handler;

    public PriorityTaskHandler(PriorityTaskHandler handler) {
        this.handler = handler;
    }

    public void handleTask(PrioritizedTask task) {
        if (handler != null) {
            handler.handleTask(task);
        }
    }
}
