package ffb.analyzer.core.queue;

import java.util.concurrent.PriorityBlockingQueue;

import org.junit.*;

public class PriorityQueueManagerTests {
    private static final int EXPECTED_QUEUE_DEPTH = 3;
    private static final int STARTING_VALUE = 5;

    PriorityQueueManager manager = new PriorityQueueManager();

    protected static class ExampleObject {
        int value = 5;

        protected ExampleObject(int value) {
            this.value = value;
        }

        protected void addOne() {
            value += 1;
        }
    }

    @After
    public void tearDown() {
        manager.getQueue().clear();
    }

    @Test
    public void addToQueue() {
        manager.add(new PrioritizedTask(5, 15));
        manager.add(new PrioritizedTask(99999, 999999));
        manager.add(new PrioritizedTask(0, 0));

        PriorityBlockingQueue queue = manager.getQueue();
        Assert.assertEquals(EXPECTED_QUEUE_DEPTH, queue.size());
    }

    @Test
    public void performOneTask() {
        ExampleObject object = new ExampleObject(STARTING_VALUE);
        PrioritizedTask<ExampleObject> task = getExampleTask(3, object);
        Assert.assertEquals(object.value, STARTING_VALUE);

        task.performTask();
        Assert.assertEquals(object.value, STARTING_VALUE + 1);
    }

    public PrioritizedTask<ExampleObject> getExampleTask(int priority, ExampleObject object) {
        PrioritizedTask<ExampleObject> task = new PrioritizedTask<ExampleObject>(
                manager.getAndIncrementNextAvailableId(), priority);

        task.setObjectToPerformTaskOn(object);
        task.setActionToPerform(ExampleObject::addOne);

        return task;
    }

    @Test
    public void performInPriorityOrder() {
        ExampleObject objectOne = new ExampleObject(STARTING_VALUE);
        PrioritizedTask<ExampleObject> taskOne = getExampleTask(1, objectOne);

        ExampleObject objectTwo = new ExampleObject(STARTING_VALUE);
        PrioritizedTask<ExampleObject> taskTwo = getExampleTask(2, objectTwo);

        ExampleObject objectThree = new ExampleObject(STARTING_VALUE);
        PrioritizedTask<ExampleObject> taskThree = getExampleTask(3, objectThree);

        manager.add(taskTwo);
        manager.add(taskOne);
        manager.add(taskThree);

        PrioritizedTask<ExampleObject> taskToExecute;

        taskToExecute = (PrioritizedTask<ExampleObject>) manager.getQueue().poll();
        taskToExecute.performTask();

        Assert.assertEquals(objectOne.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectTwo.value, STARTING_VALUE);
        Assert.assertEquals(objectThree.value, STARTING_VALUE);;

        taskToExecute = (PrioritizedTask<ExampleObject>) manager.getQueue().poll();
        taskToExecute.performTask();

        Assert.assertEquals(objectOne.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectTwo.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectThree.value, STARTING_VALUE);;

        taskToExecute = (PrioritizedTask<ExampleObject>) manager.getQueue().poll();
        taskToExecute.performTask();

        Assert.assertEquals(objectOne.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectTwo.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectThree.value, STARTING_VALUE + 1);;
    }
}
