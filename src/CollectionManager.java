import Collection.Product;

import java.util.LinkedHashMap;
import java.util.Objects;

public class CollectionManager {
    private final LinkedHashMap<Integer, Product> products;

    public CollectionManager (){
        products = new LinkedHashMap<>();
    }

    public void addObj (Product obj){
        products.put(obj.getId(), obj);
    }


}
