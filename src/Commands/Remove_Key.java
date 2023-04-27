package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Expections.WrongArguments;
import Utils.CLIManager;

public class Remove_Key implements Command {
    private final CollectionManager collectionManager;

    public Remove_Key (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        if (!collectionManager.containsKey(args[1])) throw new WrongArguments("Key is not exist");

        collectionManager.removeKey(args[1]);

        System.out.println("--Remove successfully--");
    }

    @Override
    public String info() {
        return "update the value of a collection item whose id is equal to the specified one";
    }
}
