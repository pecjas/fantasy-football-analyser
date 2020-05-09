package ffb.analyzer.core.queue;

import java.util.function.Consumer;

public class Task<T> {
    public int id;

    private final T targetObject;
    private final Consumer<T> actionToPerform;


    public Task(T targetObject, Consumer<T> actionToPerform) {
        this.targetObject = targetObject;
        this.actionToPerform = actionToPerform;
    }

    public void performTask() {
        actionToPerform.accept(targetObject);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public Consumer<T> getActionToPerform() {
        return actionToPerform;
    }
}
