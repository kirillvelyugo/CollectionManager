package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;
import jakarta.xml.bind.JAXBException;

import javax.naming.NoPermissionException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Save implements Command{

    private final CollectionManager collectionManager;

    public Save(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {

        Path path = null;
        try{
            if(args.length > 1) {
                path = Paths.get(args[1]);
                if (!path.isAbsolute()) path = path.toAbsolutePath();
                System.out.println(path);

                if (!Files.isRegularFile(path)) throw new WrongArguments("Path should be a regular file.");
                if (!Files.exists(path)) Files.createFile(path);
                if (!Files.isReadable(path)) throw new NoPermissionException("Cannot read file.");
                if (!Files.isWritable(path)) throw new NoPermissionException("Cannot write to file.");
            }
            else {
                path = collectionManager.getDefault_path();
            }

            if(path == null) throw  new WrongArguments("Incorrect path!");
            collectionManager.save(path);
            System.out.println("Collection saved to file " + path + " successfully");
        }
        catch (InvalidPathException e){
            throw  new WrongArguments("Argument must be a correct file path.");
        }
        catch (NoPermissionException e){
            System.out.println("No enough permissions to " + path + " - " + e.getMessage()); // permissions deny
        }
        catch (IOException | JAXBException e){
            e.printStackTrace();
        }
    }

    @Override
    public String info() {
        return "save collection to file";
    }
}
