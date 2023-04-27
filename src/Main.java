import Collection.Product;
import CollectionManager.CollectionManager;
import Commands.CommandExecutor;
import Expections.InvalidValue;

public class Main {
    public static void main(String[] args) throws InvalidValue {
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.addObj("100", new Product());
        collectionManager.getByKey("100").setPartNumber("100");
        collectionManager.addObj("200", new Product());
        collectionManager.getByKey("200").setPartNumber("100");

        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        commandExecutor.interactiveMode();
    }
}
