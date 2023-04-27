package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;
import Utils.CLIManager;

public class Insert implements Command{

    private final CollectionManager collectionManager;

    public Insert (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        CLIManager cliManager = new CLIManager();

        if (args.length < 2) throw new WrongArguments("Not enough arguments");
        if (collectionManager.containsKey(args[1])) throw new WrongArguments("Key already exist");
        collectionManager.addObj(args[1], cliManager.requestProduct());
    }

    @Override
    public String info() {
        return "add a new element with the specified key";
    }
}
