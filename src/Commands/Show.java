package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Expections.WrongArguments;

import java.util.Iterator;

public class Show implements Command{

    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        Iterator<Product> iter = collectionManager.getIterator();
        if (!iter.hasNext()){
            System.out.println("Collection empty");
            return;
        }

        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    @Override
    public String info() {
        return "output to the standard output stream all the elements of the collection in a string representation";
    }
}
