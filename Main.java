package singletonpattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("[System] Welcome to Pag-IBIG Centralized Queuing System (Singleton Pattern)\n");

        // Get Singleton instance
        QueueSystem queueSystem = QueueSystem.getInstance();

        // Create monitoring display and register it
        MonitoringDisplay display = new MonitoringDisplay();
        queueSystem.registerDisplay(display);

        // Create help desks
        HelpDesk desk1 = new HelpDesk(1);
        HelpDesk desk2 = new HelpDesk(2);
        HelpDesk desk3 = new HelpDesk(3);

        queueSystem.registerHelpDesk(desk1);
        queueSystem.registerHelpDesk(desk2);
        queueSystem.registerHelpDesk(desk3);

        // Simulate operations
        System.out.println("\n[Visitor] Taking queue number...");
        int visitor1 = queueSystem.getNextNumber();
        System.out.println("[Visitor] Your queue number: " + visitor1);

        desk1.serveNext();
        desk2.serveNext();
        desk3.serveNext();

        // Demonstrate reset functionality
        System.out.println("\n[Admin Action] Resetting queue...");
        desk1.resetQueue(50);

        desk2.serveNext();
        desk3.serveNext();
    }
}
