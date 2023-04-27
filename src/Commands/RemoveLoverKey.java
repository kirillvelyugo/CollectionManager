package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Expections.WrongArguments;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveLoverKey implements Command{

    private final CollectionManager collectionManager;

    public RemoveLoverKey(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        int counter = 0;
        Set<String> keyset = collectionManager.getKeySet();
        Set<String> toRemove = new HashSet<>();
        for(String key : keyset){
            if (key.compareTo(args[1]) < 0){
                toRemove.add(key);
                counter += 1;
            }
        }
        collectionManager.getKeySet().removeAll(toRemove);
        System.out.println("Removed " + counter + " elements");

    }

    @Override
    public String info() {
        return "remove all items from the collection whose key is less than the specified one";
    }
}
