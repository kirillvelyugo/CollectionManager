import Collection.Product;
import CollectionManager.CollectionManager;
import Commands.CommandExecutor;
import Expections.InvalidValue;

public class Main {
    public static void main(String[] args) throws InvalidValue {
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.addObj("ABIBA", new Product());
        collectionManager.getByKey("ABIBA").setPrice(100D);
        collectionManager.addObj("KITIK NE PRIGAY", new Product());
        collectionManager.getByKey("KITIK NE PRIGAY").setPrice(100D);

        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        commandExecutor.interactiveMode();
    }
}
