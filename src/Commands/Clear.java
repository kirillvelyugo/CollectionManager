package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;

import java.util.LinkedHashMap;

public class Clear implements Command {

    private CollectionManager collectionManager;

    public Clear (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        collectionManager.clear();
        System.out.println("The collection has been cleared");
    }

    @Override
    public String info() {
        return "clear the collection";
    }
}
