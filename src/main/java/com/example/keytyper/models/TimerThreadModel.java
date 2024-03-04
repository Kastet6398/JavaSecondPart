package com.example.keytyper.models;

public class TimerThreadModel extends BaseModel {

    private boolean isRunning = true;
    @Override
    public void execute() {
        while (isRunning) {
            ((BaseModel)getParameters().get("timerModel")).execute();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ignored) {
            }
        }
    }

    public void interrupt() {
        isRunning = false;
    }
}
