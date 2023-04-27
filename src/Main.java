import Collection.Product;
import CollectionManager.CollectionManager;
import Commands.CommandExecutor;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.addObj("ABIBA", new Product());
        collectionManager.addObj("KITIK NE PRIGAY", new Product());

        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        commandExecutor.interactiveMode();
    }
}
