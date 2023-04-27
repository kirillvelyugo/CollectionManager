package CollectionManager;

import Collection.Product;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.naming.NoPermissionException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CollectionManager {
    private LinkedHashMap <String, Product> products;

    private Path default_path;

    public CollectionManager (Path path){
        default_path = path;
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

    public Path getDefault_path(){
        return default_path;
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

    public void save(Path path) throws JAXBException {
        try (FileWriter fileWriter = new FileWriter(path.toFile())) {
            JAXBContext jc = JAXBContext.newInstance(Wrapper.class);
            Wrapper wrapper = new Wrapper();
            wrapper.setHashtable(products);
            fileWriter.write(objectToXml(jc, wrapper));
            System.out.println("Saved successfully");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String objectToXml(JAXBContext jaxbContext, Object object) throws JAXBException
    {
        StringWriter writerTo = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, writerTo);
        return writerTo.toString();
    }

    public void load(Path path){
        if (path == null){
            return;
        }
        try{
            if(!path.isAbsolute()) path = path.toAbsolutePath();
            if(!Files.exists(path)) throw new FileNotFoundException("File " + path + " not found");
            if(!Files.isReadable(path)) throw new NoPermissionException("Cannot read file.");
            if(!Files.isWritable(path)) throw new NoPermissionException("Cannot write to file.");
        }
        catch (InvalidPathException e){
            System.out.println("Argument must be a correct file path. Data not loaded.");
            return;
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage() + ". Data not loaded."); // file does not exist
            return;
        }
        catch (NoPermissionException e){
            System.out.print("No enough permissions to " + path + " - " + e.getMessage() + " Data not loaded."); // permissions deny
            return;
        }

       try (InputStream inputStream = Files.newInputStream(path)) {
           JAXBContext jaxbContext = JAXBContext.newInstance(Wrapper.class);
           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

           Wrapper wrapper = (Wrapper) jaxbUnmarshaller.unmarshal(inputStream);
           LinkedHashMap <String, Product> products = wrapper.getHashtable();
           System.out.println(products.size() + " element(s) loaded from file");

           this.products = products;
       }
       catch (IOException | JAXBException e) {
           System.out.println("Error while reading. Data not loaded.");
       }
    }


}



