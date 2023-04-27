package CollectionManager;

import Collection.Product;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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

    public String getInfo(){
        String info = "";
        info += "Information about collection:\n";
        ZonedDateTime creationDate = null;

        Set<String> keyset = this.getKeySet();


        for(String key : keyset){
            if (creationDate == null) creationDate = this.getByKey(key).getCreationDate();
            if(this.getByKey(key).getCreationDate().compareTo(creationDate) < 0){
                creationDate = this.getByKey(key).getCreationDate();
            }
        }

        info += "Created at " + creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) + '\n';
        info += "Collection type is " + this.products.getClass().getName() + '\n';
        info += "Amount of items stored in - " + this.products.size() + '\n';

        return info;
    }

}
