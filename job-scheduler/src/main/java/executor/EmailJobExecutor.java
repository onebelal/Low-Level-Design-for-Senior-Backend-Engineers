package executor;

public class EmailJobExecutor implements JobCommand{
    @Override
    public void command() {
        System.out.println("Sending an email");
    }
}
