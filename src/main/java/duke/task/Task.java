package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Abstract class Task is the parent of all types of Tasks
 */
public abstract class Task {

    protected String description;
    protected boolean isDone;

    // Formatters used to parse and print date and time
    protected static DateTimeFormatter printPattern = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mma");
    public static DateTimeFormatter storePattern = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    /**
     * Initialises the Task with its description sets its status as not done.
     *
     * @param description String describing the Task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Get a String describing the type of the Task.
     *
     * @return String describing the type of Task
     */
    public String getType() {
        return "task";
    }

    /**
     * Get a String describing the Task.
     *
     * @return String describing the Task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Check if the Task has been done.
     *
     * @return <code>true</code> if the Task is done, <code>false</code> otherwise
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Get a String describing status of the Task.
     *
     * @return "X" if the Task is done, " " otherwise
     */
    public String getStatus() {
        return (isDone() ? "X" : " ");
    }

    /**
     * Set the status of the Task based on the input.
     *
     * @param done Boolean describing the status of the task
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Given a date, determine if it occurs during the duration of the Task.
     *
     * @param date Date to be checked
     * @return <code>true</code> if there is overlap, <code>false</code> otherwise
     */
    public Boolean isOnDate(LocalDate date) {
        return false;
    }

    /**
     * Prints out the Task in desired format
     */
    @Override
    public String toString() {
        return description;
    }

}
