package duke;

import duke.command.Command;
import duke.task.TaskList;

import java.io.IOException;
import java.rmi.UnexpectedException;

/**
 * Main class for running Duke.
 */
public class Duke {

    // test commit
    public static final String FILE_PATH = "save.txt";
    private static Storage storage;
    private static TaskList tasks;
    private static Ui ui;

    /**
     * Initialises Ui, Storage, and TaskList.
     *
     * @param filePath Location of the local save file.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load(ui));
            storage.update(tasks);
            ui.printWelcomeMessage();
        } catch (IOException e) {
            ui.printErrorForIO();
        }
    }

    /**
     * Reads, executes, and prints outputs of user commands continually.
     * Stops after ExitCommand is called.
     *
     * @throws UnexpectedException If command cannot be executed for an unexpected reason.
     */
    public void run() throws UnexpectedException {
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            ui.showLine();
            Command c = Parser.getCommand(fullCommand, ui, tasks.getSize());
            if (c != null) {
                c.execute(tasks, ui, storage);
                isExit = c.isExit;
            }
            ui.showLine();
        }
    }

    /**
     * Initialises and runs Duke.
     */
    public static void main(String[] args) {
        try {
            new Duke(FILE_PATH).run();
        } catch (UnexpectedException exception) {
            ui.printUnexpectedException(exception);
        }
        System.exit(0);
    }

}
