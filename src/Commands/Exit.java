package Commands;

import Expections.WrongArguments;

public class Exit implements Command{
    @Override
    public void execute(String[] args) throws WrongArguments {
        System.out.println("---STOP PROCESSING---");
        System.exit(0);
    }

    @Override
    public String info() {
        return "terminate the program (without saving to a file)";
    }
}
