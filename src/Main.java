import CollectionManager.CollectionManager;
import Commands.CommandExecutor;
import Expections.InvalidValue;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // get file path_str
        Path path = null;
        String path_str = System.getenv("path");
        if(path_str == null){
            System.out.println("No path specified. Data not loaded. To save collection to file use \"save\" command with file path as argument");
        }
        else {
            path = Paths.get(path_str);
        }

        CollectionManager collectionManager = new CollectionManager(path);
        collectionManager.load(path);

        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        commandExecutor.interactiveMode();
    }
}
