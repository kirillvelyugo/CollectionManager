package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;
import java.util.HashSet;
import java.util.Set;

/**
 * Class remove from the collection all items whose key exceeds the specified one
 */
public class RemoveGreaterKey implements Command{

    private final CollectionManager collectionManager;

    public RemoveGreaterKey(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        int counter = 0;
        Set<String> keyset = collectionManager.getKeySet();
        Set<String> toRemove = new HashSet<>();
        for(String key : keyset){
            if (key.compareTo(args[1]) > 0){
                toRemove.add(key);
                counter += 1;
            }
        }
        collectionManager.getKeySet().removeAll(toRemove);
        System.out.println("--Removed " + counter + " elements--");

    }

    @Override
    public String info() {
        return "[key] Description: remove from the collection all items whose key exceeds the specified one";
    }
}
