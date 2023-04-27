package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;

import java.util.HashSet;
import java.util.Set;

public class MaxByName implements Command{

    private final CollectionManager collectionManager;

    public MaxByName(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        // get max by name
        Set<String> keyset = collectionManager.getKeySet();
        String maxName = null;
        String keyToShow = null;
        for(String key : keyset){
            if(maxName == null) {
                maxName = collectionManager.getByKey(key).getName();
                keyToShow = key;
            }
            if(collectionManager.getByKey(key).getName().compareTo(maxName) > 0){
                maxName = collectionManager.getByKey(key).getName();
                keyToShow = key;
            }
        }
        System.out.println(collectionManager.getByKey(keyToShow));
    }

    @Override
    public String info() {
        return "output any object from the collection whose name field value is the maximum";
    }
}