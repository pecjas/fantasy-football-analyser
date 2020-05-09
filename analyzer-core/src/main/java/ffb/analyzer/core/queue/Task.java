package ffb.analyzer.core.queue;

import java.util.function.Consumer;

public class Task<T> {
    public int id;

    private T objectToPerformTaskOn;
    private Consumer<T> actionToPerform;


    public Task(T object, Consumer<T> action) {
        objectToPerformTaskOn = object;
        actionToPerform = action;
    }

    public void performTask() {
        actionToPerform.accept(objectToPerformTaskOn);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getObjectToPerformTaskOn() {
        return objectToPerformTaskOn;
    }

    public Consumer<T> getActionToPerform() {
        return actionToPerform;
    }
}
