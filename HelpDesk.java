package singletonpattern;

public class HelpDesk {
    private int id;
    private QueueSystem queueSystem;

    public HelpDesk(int id) {
        this.id = id;
        this.queueSystem = QueueSystem.getInstance(); // Use Singleton instance
    }

    public int getId() {
        return id;
    }

    public void serveNext() {
        System.out.println("[Help Desk " + id + "] Now serving: " + (queueSystem.getCurrentNumber() + 1));
        queueSystem.serveNext();
    }

    public void resetQueue(int num) {
        System.out.println("[Help Desk " + id + "] Resetting queue to: " + num);
        queueSystem.resetQueue(num);
    }
}
