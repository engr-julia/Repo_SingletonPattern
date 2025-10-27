package singletonpattern;

import java.util.ArrayList;
import java.util.List;

public class QueueSystem {
    private static QueueSystem instance;
    private int currentNumber;
    private int nextNumber;
    private List<MonitoringDisplay> observers;

    // Private constructor to prevent direct instantiation
    private QueueSystem() {
        this.currentNumber = 0;
        this.nextNumber = 1;
        this.observers = new ArrayList<>();
    }

    // Singleton instance retrieval
    public static QueueSystem getInstance() {
        if (instance == null) {
            instance = new QueueSystem();
        }
        return instance;
    }

    // Generate the next number in queue
    public int getNextNumber() {
        int number = nextNumber;
        nextNumber++;
        System.out.println("[System] Issued Queue Number: " + number);
        notifyDisplays();
        return number;
    }

    // Serve next number
    public void serveNext() {
        currentNumber++;
        System.out.println("[System] Now serving number: " + currentNumber);
        notifyDisplays();
    }

    // Reset the queue
    public void resetQueue(int num) {
        this.currentNumber = num;
        this.nextNumber = num + 1;
        System.out.println("[System] Queue has been reset to: " + num);
        notifyDisplays();
    }

    // Register a help desk
    public void registerHelpDesk(HelpDesk desk) {
        System.out.println("[System] Help Desk " + desk.getId() + " registered.");
    }

    // Register display for monitoring
    public void registerDisplay(MonitoringDisplay display) {
        observers.add(display);
    }

    // Notify all displays of updates
    private void notifyDisplays() {
        for (MonitoringDisplay display : observers) {
            display.update(currentNumber);
        }
    }

    public int getCurrentNumber() {
        return currentNumber;
    }
}
