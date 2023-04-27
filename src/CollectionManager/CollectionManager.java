package CollectionManager;

import Collection.Product;

import java.util.*;

public class CollectionManager {
    private final LinkedHashMap <String, Product> products;

    public CollectionManager (){
        products = new LinkedHashMap<>();
    }

    public void addObj (String key, Product obj){
        products.put(key, obj);
    }

    public boolean containsKey (String key){
        return products.containsKey(key);
    }

    public Iterator<Product> getIterator (){
        return this.products.values().iterator();
    }

    public void clear (){
        this.products.clear();
    }

}
