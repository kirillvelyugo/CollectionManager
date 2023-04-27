package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;

import java.util.HashMap;
import java.util.Scanner;

public class CommandExecutor {
    private final CollectionManager collectionManager;
    private final HashMap<String, Command> commands;

    public CommandExecutor (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        this.commands = new HashMap<>();

        this.commands.put("show", new Show(this.collectionManager));
        this.commands.put("help", new Help(this.commands));
        this.commands.put("exit", new Exit());
        this.commands.put("clear", new Clear(this.collectionManager));
        this.commands.put("insert", new Insert(this.collectionManager));
        this.commands.put("update", new Update(this.collectionManager));
        this.commands.put("remove_key", new RemoveKey(this.collectionManager));
        this.commands.put("remove_any_by_price", new RemoveAnyByPrice(this.collectionManager));
        this.commands.put("replace_if_greater", new ReplaceIfGreater(this.collectionManager));
        this.commands.put("remove_greater_key", new RemoveGreaterKey(this.collectionManager));

    }

    public void interactiveMode (){
        while (true){
            Scanner console = new Scanner(System.in);
            String line = console.nextLine();

            String[] args = line.split(" ");
            args[0] = args[0].toLowerCase().strip();

            if (commands.containsKey(args[0])){
                try {
                    commands.get(args[0]).execute(args);
                }catch (WrongArguments e){
                    System.out.println("Incorrect arguments. Try again " + e.getMessage());
                }
            }else{
                System.out.println("Command not found. Try again or read help");
            }
        }
    }
}
