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

    public void removeKey (String key){
        products.remove(key);
    }

    public boolean containsKey (String key){
        return products.containsKey(key);
    }

    public Product findById (int id){
        Iterator<Product> iter = getIterator();
        while (iter.hasNext()){
            Product product = iter.next();
            if (product.getId() == id) return product;
        }
        return null;
    }

    public Iterator<Product> getIterator (){
        return products.values().iterator();
    }

    public void clear (){
        this.products.clear();
    }

    public Set<String> getKeySet(){
        return products.keySet();
    }

    public Product getByKey(String key){
        return products.get(key);
    }

}
