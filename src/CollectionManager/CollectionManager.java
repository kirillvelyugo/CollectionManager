package CollectionManager;

import Collection.Product;

import java.util.*;

public class CollectionManager {
    private final LinkedHashMap <Integer, Product> products;

    public CollectionManager (){
        products = new LinkedHashMap<>();
    }

    public void addObj (Product obj){
        products.put(obj.getId(), obj);
    }

    public Iterator<Product> getIterator (){
        return this.products.values().iterator();
    }

    public void clear (){
        this.products.clear();
    }

}
