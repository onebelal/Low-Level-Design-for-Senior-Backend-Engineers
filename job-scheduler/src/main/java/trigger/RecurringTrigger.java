package trigger;

import entity.JobTrigger;

import java.time.Duration;
import java.time.LocalDateTime;

public class RecurringTrigger extends JobTrigger {

    private final Duration interval;
    private LocalDateTime nextExecutionTime;

    public RecurringTrigger(Duration interval) {
        this.interval = interval;
        this.nextExecutionTime = LocalDateTime.now().plus(interval);
    }

    @Override
    public LocalDateTime nextExecutionTime() {
        return nextExecutionTime;
    }

    @Override
    public void onExecution() {
        updateNextExecutionTime();
    }

    public void updateNextExecutionTime() {
        nextExecutionTime = nextExecutionTime.plus(interval);
    }


}