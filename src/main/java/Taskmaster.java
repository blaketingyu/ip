import taskmaster.userinterface.UserInterface;

/**
 * This class encapsulates the main program, Taskmaster.
 */

public class Taskmaster {
    /** The user interface that allows the user to communicate with Taskmaster. **/
    protected UserInterface ui;

    /**
     * Constructor for Taskmaster the chatbot.
     */

    private Taskmaster () {
        this.ui = new UserInterface();
    }

    public static void main(String[] args) {
        Taskmaster taskMaster = new Taskmaster();
        taskMaster.ui.runChatBot();
    }

}