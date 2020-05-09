package ffb.analyzer.core.queue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueManagerTests {
    private static final int EXPECTED_QUEUE_DEPTH = 3;
    private static final int STARTING_VALUE = 5;

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
    public void addToQueue() {
        Assert.assertTrue(manager.addEntry(Utils.getExampleTask(15, exampleObject)));
        Assert.assertTrue(manager.addEntry(Utils.getExampleTask(99999, exampleObject)));
        Assert.assertTrue(manager.addEntry(Utils.getExampleTask(0, exampleObject)));

        Assert.assertEquals(EXPECTED_QUEUE_DEPTH, manager.getQueue().size());
    }

    @Test
    public void performOneTask() {
        Task<?> task = Utils.getExampleTask(5, exampleObject);
        Assert.assertEquals(exampleObject.value, STARTING_VALUE);

        task.performTask();
        Assert.assertEquals(exampleObject.value, STARTING_VALUE + 1);
    }

    @Test
    public void performInPriorityOrder() {
        Utils.ExampleObject objectOne = new Utils.ExampleObject(STARTING_VALUE);
        PrioritizedTask<Utils.ExampleObject> taskOne = Utils.getExampleTask(1, objectOne);

        Utils.ExampleObject objectTwo = new Utils.ExampleObject(STARTING_VALUE);
        PrioritizedTask<Utils.ExampleObject> taskTwo = Utils.getExampleTask(2, objectTwo);

        Utils.ExampleObject objectThree = new Utils.ExampleObject(STARTING_VALUE);
        PrioritizedTask<Utils.ExampleObject> taskThree = Utils.getExampleTask(3, objectThree);

        manager.addEntry(taskTwo);
        manager.addEntry(taskOne);
        manager.addEntry(taskThree);

        manager.executeNextTask();

        Assert.assertEquals(objectOne.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectTwo.value, STARTING_VALUE);
        Assert.assertEquals(objectThree.value, STARTING_VALUE);

        manager.executeNextTask();

        Assert.assertEquals(objectOne.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectTwo.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectThree.value, STARTING_VALUE);

        manager.executeNextTask();

        Assert.assertEquals(objectOne.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectTwo.value, STARTING_VALUE + 1);
        Assert.assertEquals(objectThree.value, STARTING_VALUE + 1);
    }
}
