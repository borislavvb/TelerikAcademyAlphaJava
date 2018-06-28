package models.base;

import models.TicketPriority;

import java.util.Date;

public class Task extends Item {

    private Date dueDate;
    private TicketPriority priority;
    private Date plannedTime; //planned time in project management - This is the amount of time you have planned for the given task. Generally this will be displayed in hours and minutes. The format will be hours:minutes;
    private String assignee;

    public Task(String title, String description, Date dueDate, TicketPriority priority, Date plannedTime, String assignee) {
        super(title, description);
        this.dueDate = dueDate;
        this.priority = priority;
        this.plannedTime = plannedTime;
        this.assignee = assignee;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public Date getPlannedTime() {
        return this.plannedTime;
    }

    public String getAssignee() {
        return assignee;
    }

    @Override
    public void showDescription() {
        System.out.println();
        System.out.printf("Title: %s\n", this.getTitle());
        System.out.printf("Description: %s\n", this.getDescription());
        System.out.printf("Due Date: %s\n", this.getDueDate().toString());
        System.out.printf("Priority: %s\n", this.getPriority());
        System.out.printf("Planned Time: %s\n", this.getPlannedTime().toString());
        System.out.printf("Assignee: %s", this.getAssignee());
        System.out.println();
    }
}
