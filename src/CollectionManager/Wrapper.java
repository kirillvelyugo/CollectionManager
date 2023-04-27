package CollectionManager;

import Collection.Product;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.LinkedHashMap;

@XmlRootElement
class Wrapper {

    private LinkedHashMap<String, Product> hashtable;

    public LinkedHashMap<String, Product> getHashtable() {
        return hashtable;
    }

    public void setHashtable(LinkedHashMap<String, Product> hashtable) {
        this.hashtable = hashtable;
    }

}