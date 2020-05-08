package ffb.analyzer.core.queue;

import java.util.function.Consumer;

public class Task<T> {
    public int id;

    private T objectToPerformTaskOn;
    private Consumer<T> actionToPerform;


    public void performTask() {
        try {
            actionToPerform.accept(objectToPerformTaskOn);
        } catch (Exception e) {
            throw new RuntimeException(); //TODO: Add error logging instead of throwing exception
        }
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

    public void setObjectToPerformTaskOn(T objectToPerformTaskOn) {
        this.objectToPerformTaskOn = objectToPerformTaskOn;
    }

    public Consumer<T> getActionToPerform() {
        return actionToPerform;
    }

    public void setActionToPerform(Consumer<T> actionToPerform) {
        this.actionToPerform = actionToPerform;
    }
}
