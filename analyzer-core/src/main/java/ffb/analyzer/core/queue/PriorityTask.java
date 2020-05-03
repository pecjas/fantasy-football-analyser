package ffb.analyzer.core.queue;



public class Task implements Comparable<Task> {

    public Long id;
    public int priority;


    @Override
    public int compareTo(Task otherTask) {
        return this.getId().compareTo(otherTask.getId());
    }


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
