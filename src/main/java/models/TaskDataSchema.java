package models;

public class TaskDataSchema extends CommunSchema {
    private TaskSchema task;

    public TaskSchema getTask() {
        return task;
    }

    public void setTask(TaskSchema task) {
        this.task = task;
    }
}
