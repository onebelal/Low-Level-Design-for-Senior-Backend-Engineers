package trigger;

import entity.JobTrigger;

import java.time.Duration;
import java.time.LocalDateTime;

public class DelayedTrigger extends JobTrigger {

    private final LocalDateTime executionTime;

    public DelayedTrigger(Duration delay) {
        this.executionTime = LocalDateTime.now().plus(delay);
    }

    @Override
    public LocalDateTime nextExecutionTime() {
        return executionTime;
    }

    @Override
    public void onExecution() {
        completed=true;
    }
}