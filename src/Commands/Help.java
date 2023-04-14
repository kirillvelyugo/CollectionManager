package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;

import java.util.HashMap;
import java.util.Set;

public class Help implements Command{

    private final HashMap<String, Command> commands;

    public Help (HashMap<String, Command> commands){
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        for (String command : commands.keySet()){
            System.out.println(command + " -- " + commands.get(command).info());
        }
    }

    @Override
    public String info() {
        return "output help for available commands";
    }
}
