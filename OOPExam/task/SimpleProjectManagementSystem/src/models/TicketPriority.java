package models;

public enum TicketPriority {
    HIGH_PRIORITY, LOW_PRIORITY;

    private static final String TICKET_PRIORITY_HIGH = "HIGH PRIORITY";
    private static final String TICKET_PRIORITY_LOW = "LOW PRIORITY";

    public static TicketPriority fromName(String name) {
        switch (name) {
            case TICKET_PRIORITY_HIGH:
                return HIGH_PRIORITY;
            case TICKET_PRIORITY_LOW:
                return LOW_PRIORITY;
            default:
                return null;
        }
    }
}
