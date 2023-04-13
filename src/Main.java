import Collection.Product;
import CollectionManager.CollectionManager;
import Commands.CommandExecutor;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.addObj(new Product());
        collectionManager.addObj(new Product());

        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        commandExecutor.interactiveMode();
    }
}
