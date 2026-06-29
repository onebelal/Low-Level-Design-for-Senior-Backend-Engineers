package entity;

import java.time.LocalDateTime;

public abstract class JobTrigger {

    public boolean completed;

    public abstract LocalDateTime nextExecutionTime();

    public abstract void onExecution();

    public boolean shouldTrigger() {
        return !completed && !LocalDateTime.now().isBefore(nextExecutionTime());
    }

}
