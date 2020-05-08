package ffb.analyzer.core.queue;

import org.junit.Assert;
import org.junit.Test;

import java.lang.NullPointerException;

public class PrioritizedTaskTests {
    private static final int COMPARISON_MATCH_RETURN = 0;

    @Test
    public void testCompareToSamePriority() {
        PrioritizedTask taskOne = new PrioritizedTask(1, 2);
        PrioritizedTask taskTwo = new PrioritizedTask(2, 2);

        Assert.assertEquals(COMPARISON_MATCH_RETURN, taskOne.compareTo(taskTwo));
        Assert.assertEquals(COMPARISON_MATCH_RETURN, taskTwo.compareTo(taskOne));
    }

    @Test
    public void testCompareToDifferentPriority() {
        PrioritizedTask taskOne = new PrioritizedTask(3, 1);
        PrioritizedTask taskTwo = new PrioritizedTask(1, 2);

        Assert.assertNotEquals(COMPARISON_MATCH_RETURN, taskOne.compareTo(taskTwo));
        Assert.assertNotEquals(COMPARISON_MATCH_RETURN, taskTwo.compareTo(taskOne));
    }

    @Test
    public void testCompareToSelf() {
        PrioritizedTask task = new PrioritizedTask(0, 8);

        Assert.assertEquals(COMPARISON_MATCH_RETURN, task.compareTo(task));
    }

    @Test
    public void testCompareToNull() {
        PrioritizedTask taskOne = new PrioritizedTask(3, 2);

        Assert.assertThrows(NullPointerException.class, () -> {
            taskOne.compareTo(null);
        });
    }

    @Test
    public void testNegativeId() {
        PrioritizedTask task = new PrioritizedTask(1234567890, 999999999);
        task.setId(Integer.MIN_VALUE);
    }
}
