package models.base;

import models.TicketPriority;

import java.util.Date;

public class Ticket extends Item {

    private Date dueDate;
    private TicketPriority priority;
    private String sender;
    private String owner;

    public Ticket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner) {
        super(title, description);
        this.dueDate = dueDate;
        this.priority = priority;
        this.sender = sender;
        this.owner = owner;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public String getSender() {
        return sender;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void showDescription() {
        System.out.println();
        System.out.printf("Title: %s\n", this.getTitle());
        System.out.printf("Description: %s\n", this.getDescription());
        System.out.printf("Due Date: %s\n", this.getDueDate().toString());
        System.out.printf("Priority: %s\n", this.getPriority());
        System.out.printf("Sender: %s\n", this.getSender());
        System.out.printf("Owner: %s\n", this.getOwner());
        System.out.println();
    }


}
