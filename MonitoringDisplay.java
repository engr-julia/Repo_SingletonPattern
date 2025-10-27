package singletonpattern;

public class MonitoringDisplay {
    private int currentNumber;

    public void update(int current) {
        this.currentNumber = current;
        showDisplay();
    }

    public void showDisplay() {
        System.out.println("[Monitoring Display] Current number: " + currentNumber);
    }
}
