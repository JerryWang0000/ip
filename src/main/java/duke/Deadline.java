package duke;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a deadline
 */
public class Deadline extends Task {
    private final LocalDateTime deadline;

    /**
     * Constructs a new Deadline.
     *
     * @param name     The content of the task
     * @param deadline A string representing the deadline
     * @throws DukeException if the time parsing is unsuccessful
     */
    public Deadline(String name, String deadline) throws DukeException {
        super(name);
        this.deadline = Task.parse(deadline);
    }

    /**
     * {@inheritDoc}
     * Specifies the type of the task.
     */
    @Override
    String taskToLine() {
        return "D | " + super.taskToLine() + " | " + deadline.format(DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * Checks if the deadline is on the same date as the searching date.
     *
     * @param localDate The given date that the user wishes to check
     * @return True if the searching date is the same as the date of the deadline
     */
    @Override
    boolean matchDate(LocalDate localDate) {
        return deadline.toLocalDate().equals(localDate);
    }

    /**
     * {@inheritDoc}
     * Specifies the type of the task and the deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + String.format(" (by: %s) ", deadline
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}
