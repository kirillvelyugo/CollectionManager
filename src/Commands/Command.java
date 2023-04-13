package Commands;

import Expections.WrongArguments;

public interface Command {
    public void execute (String[] args) throws WrongArguments;
    public String info ();
}
