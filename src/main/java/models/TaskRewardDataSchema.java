package models;

public class TaskRewardDataSchema extends CommunSchema {
    private TaskRewardSchema reward;

    public TaskRewardSchema getReward() {
        return reward;
    }

    public void setReward(TaskRewardSchema reward) {
        this.reward = reward;
    }
    
}
