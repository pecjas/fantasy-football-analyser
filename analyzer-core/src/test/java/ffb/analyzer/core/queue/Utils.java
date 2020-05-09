package ffb.analyzer.core.queue;

public abstract class Utils {
    public static class ExampleObject {
        int value = 5;

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

    public static PrioritizedTask<ExampleObject> getExampleTask(int priority,
                                                                ExampleObject object) {

        return new PrioritizedTask<>(
                priority,
                object,
                ExampleObject::addOne);
    }
}
