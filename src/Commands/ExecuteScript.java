package Commands;

import Expections.WrongArguments;
import javax.naming.NoPermissionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Execute script command. Takes one argument with script file path
 * This command uses collectionManager reference to call "add" method
 */
public class ExecuteScript implements Command{

    HashMap<String, Command> commands;
    private static final ArrayList<Integer> history = new ArrayList<>();

    public ExecuteScript(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        if(args.length < 2) throw new WrongArguments("Not enough arguments");
        Path path = Paths.get(args[1]);
        history.add(args[1].hashCode());
        try{
            if(!Files.exists(path)) throw new FileNotFoundException("File " + path + " not found");
            if(!Files.isReadable(path)) throw new NoPermissionException("Cannot read files");
            if(!Files.isWritable(path)) throw new NoPermissionException("Cannot write to file");
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            return;
        }
        catch (NoPermissionException e){
            System.out.print("No permissions " + e.getMessage());
            return;
        }

        try(InputStream inputStream = Files.newInputStream(path)){
            Scanner reader = new Scanner(inputStream);
            System.out.println("Running " + path);
            run(reader);
            history.clear();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Read line from file, parse command and argument and run a command.
     * @param scanner Scanner
     * @throws IOException when reader not available
     */
    private void run(Scanner scanner) throws IOException {

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line == null) return;

            String[] args = line.split(" ");
            args[0] = args[0].toLowerCase().strip();
            if (commands.containsKey(args[0])){
                try {
                   Command command = commands.get(args[0]);
                    if (command.getClass() == ExecuteScript.class) {
                        if (ExecuteScript.history.contains(args[1].hashCode())) {
                            System.out.println("Recursion! Command skipped!");
                            continue;
                        }
                        ExecuteScript.history.add(args[0].hashCode());
                    }
                    command.execute(args);
                }catch (WrongArguments e){
                    System.out.println("Error while running " + args[0] + " command.");
                    System.out.println("Wrong argument! " + e.getMessage() + " Command skipped");
                }
            }else{
                System.out.println(args[0] + " is not a command. Try again");
            }
        }
    }

    @Override
    public String info() {
        return "[file_path] Description: execute script in file";
    }
}
