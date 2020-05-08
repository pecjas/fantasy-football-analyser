package ffb.analyzer.core.queue;

public class PriorityTaskHandlerTests {
    private enum HandlerSelection {
        ExampleHandler1,
        ExampleHandler2
    }

    private class ExampleHandler1 extends PriorityTaskHandler {
        public ExampleHandler1(PriorityTaskHandler handler) {
            super(handler);
        }

        /***
         * For testing, returns class name to indicate which handler processed the task.
         * @param task
         * @returns String name of the class
         */
//        TODO: finish this
//         public void handleTask(PriorityTask task) {
//            if (task)
//        }
    }

    private class ExampleHandler2 extends PriorityTaskHandler {
        public ExampleHandler2(PriorityTaskHandler handler) {
            super(handler);
        }

        public void handleTask(PrioritizedTask task) {

        }
    }

}
