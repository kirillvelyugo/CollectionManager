package Commands;

import CollectionManager.CollectionManager;
import Commands.Command;

import java.util.HashMap;
import java.util.Scanner;

public class CommandExecutor {
    private final CollectionManager collectionManager;
    private final HashMap<String, Command> commands;

    public CommandExecutor (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        this.commands = new HashMap<>();

        this.commands.put("show", new Show(collectionManager));
    }

    public void interactiveMode (){
        while (true){
            Scanner console = new Scanner(System.in);
            String line = console.nextLine();

            String[] args = line.split(" ");
            args[0] = args[0].toLowerCase();

            if (commands.containsKey(args[0])){
                commands.get(args[0]).execute(args);
            }else{
                System.out.println("Command not found. Try again or read help");
            }
        }
    }
}
