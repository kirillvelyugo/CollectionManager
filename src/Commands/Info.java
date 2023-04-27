package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;

import java.util.HashMap;

public class Info implements Command{

    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        System.out.println(collectionManager.getInfo());
    }

    @Override
    public String info() {
        return "show information about collection";
    }
}
