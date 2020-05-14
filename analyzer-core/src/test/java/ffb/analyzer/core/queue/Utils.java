package ffb.analyzer.core.queue;

import ffb.analyzer.core.queue.PrioritizedTask.Priority;

public abstract class Utils {
    public static class ExampleObject {
        int value;

        public ExampleObject(int value) {
            this.value = value;
        }

        public void addOne() {
            value += 1;
        }
    }

    public static ExampleObject getExampleObject(int value) {
        return new ExampleObject(value);
    }

    public static PrioritizedTask<ExampleObject> getExampleTask(Priority priority,
                                                                ExampleObject object) {

        return new PrioritizedTask<>(
                priority,
                object,
                ExampleObject::addOne);
    }
}
