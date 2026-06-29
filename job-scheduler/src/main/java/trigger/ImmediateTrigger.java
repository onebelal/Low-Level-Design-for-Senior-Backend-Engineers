package trigger;

import entity.JobTrigger;

import java.time.LocalDateTime;

public class ImmediateTrigger extends JobTrigger {

    private final LocalDateTime scheduledAt;

    public ImmediateTrigger() {
        this.scheduledAt = LocalDateTime.now();
    }

    @Override
    public LocalDateTime nextExecutionTime() {
        return scheduledAt;
    }

    @Override
    public void onExecution() {
        completed=true;
    }
}