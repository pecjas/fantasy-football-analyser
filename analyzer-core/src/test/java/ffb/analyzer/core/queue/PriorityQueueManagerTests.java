package ffb.analyzer.core.queue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ffb.analyzer.core.queue.PrioritizedTask.Priority;

public class PriorityQueueManagerTests {
    private static final int EXPECTED_QUEUE_DEPTH = 3;
    private static final int STARTING_VALUE = 5;
    private static final int ENDING_VALUE = STARTING_VALUE + 1;

    PriorityQueueManager manager = new PriorityQueueManager();
    Utils.ExampleObject exampleObject;

    @Before
    public void setUp() {
        exampleObject = Utils.getExampleObject(STARTING_VALUE);
    }

    @After
    public void tearDown() {
        manager.getQueue().clear();
    }

    @Test
    public void testAddToQueue() {
        Assert.assertTrue(manager.addEntry(Utils.getExampleTask(Priority.HIGHER, exampleObject)));
        Assert.assertTrue(manager.addEntry(Utils.getExampleTask(Priority.LOW, exampleObject)));
        Assert.assertTrue(manager.addEntry(Utils.getExampleTask(Priority.HIGHER, exampleObject)));

        Assert.assertEquals(EXPECTED_QUEUE_DEPTH, manager.getQueue().size());
    }

    @Test
    public void testPerformOneTask() {
        Task<?> task = Utils.getExampleTask(Priority.MEDIUM, exampleObject);
        Assert.assertEquals(exampleObject.value, STARTING_VALUE);

        task.performTask();
        Assert.assertEquals(exampleObject.value, ENDING_VALUE);
    }

    @Test
    public void testPerformInPriorityOrder() {
        Utils.ExampleObject objectOne = new Utils.ExampleObject(STARTING_VALUE);
        PrioritizedTask<Utils.ExampleObject> taskOne = Utils.getExampleTask(Priority.HIGHER, objectOne);

        Utils.ExampleObject objectTwo = new Utils.ExampleObject(STARTING_VALUE);
        PrioritizedTask<Utils.ExampleObject> taskTwo = Utils.getExampleTask(Priority.MEDIUM, objectTwo);

        Utils.ExampleObject objectThree = new Utils.ExampleObject(STARTING_VALUE);
        PrioritizedTask<Utils.ExampleObject> taskThree = Utils.getExampleTask(Priority.LOW, objectThree);

        manager.addEntry(taskTwo);
        manager.addEntry(taskOne);
        manager.addEntry(taskThree);

        manager.executeNextTask();

        Assert.assertEquals(objectOne.value, ENDING_VALUE);
        Assert.assertEquals(objectTwo.value, STARTING_VALUE);
        Assert.assertEquals(objectThree.value, STARTING_VALUE);

        manager.executeNextTask();

        Assert.assertEquals(objectOne.value, ENDING_VALUE);
        Assert.assertEquals(objectTwo.value, ENDING_VALUE);
        Assert.assertEquals(objectThree.value, STARTING_VALUE);

        manager.executeNextTask();

        Assert.assertEquals(objectOne.value, ENDING_VALUE);
        Assert.assertEquals(objectTwo.value, ENDING_VALUE);
        Assert.assertEquals(objectThree.value, ENDING_VALUE);
    }
}
