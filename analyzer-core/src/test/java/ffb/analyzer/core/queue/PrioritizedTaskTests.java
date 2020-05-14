package ffb.analyzer.core.queue;

import java.lang.NullPointerException;

import org.junit.Assert;
import org.junit.Test;

import ffb.analyzer.core.queue.Utils.ExampleObject;
import ffb.analyzer.core.queue.PrioritizedTask.Priority;

public class PrioritizedTaskTests {
    private static final int COMPARISON_MATCH_RETURN = 0;
    private static final ExampleObject exampleObject = Utils.getExampleObject(9999);

    @Test
    public void testCompareToSamePriority() {
        PrioritizedTask<ExampleObject> taskOne = new PrioritizedTask<>(1, Priority.HIGHER, exampleObject, ExampleObject::addOne);
        PrioritizedTask<ExampleObject> taskTwo = new PrioritizedTask<>(2, Priority.HIGHER, exampleObject, ExampleObject::addOne);

        Assert.assertEquals(COMPARISON_MATCH_RETURN, taskOne.compareTo(taskTwo));
        Assert.assertEquals(COMPARISON_MATCH_RETURN, taskTwo.compareTo(taskOne));
    }

    @Test
    public void testCompareToDifferentPriority() {
        PrioritizedTask<ExampleObject> taskOne = new PrioritizedTask<>(3, Priority.LOW, exampleObject, ExampleObject::addOne);
        PrioritizedTask<ExampleObject> taskTwo = new PrioritizedTask<>(1, Priority.HIGH, exampleObject, ExampleObject::addOne);

        Assert.assertNotEquals(COMPARISON_MATCH_RETURN, taskOne.compareTo(taskTwo));
        Assert.assertNotEquals(COMPARISON_MATCH_RETURN, taskTwo.compareTo(taskOne));
    }

    @Test
    public void testCompareToSelf() {
        PrioritizedTask<ExampleObject> task = new PrioritizedTask<>(0, Priority.LOWER, exampleObject, ExampleObject::addOne);

        Assert.assertEquals(COMPARISON_MATCH_RETURN, task.compareTo(task));
    }

    @Test
    public void testCompareToNull() {
        PrioritizedTask<ExampleObject> task = new PrioritizedTask<>(9999, Priority.MEDIUM, exampleObject, ExampleObject::addOne);

        Assert.assertThrows(NullPointerException.class, () -> {
            task.compareTo(null);
        });
    }

    @Test
    public void testNegativeId() {
        PrioritizedTask<ExampleObject> task = new PrioritizedTask<>(-1234567890,
                Priority.LOW,
                exampleObject,
                ExampleObject::addOne);

        task.setId(Integer.MIN_VALUE);
    }
}
