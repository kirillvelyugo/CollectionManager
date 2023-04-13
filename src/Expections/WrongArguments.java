package Expections;

public class WrongArguments extends Exception{
    public WrongArguments (){}

    public WrongArguments (String message){
        super(message);
    }
}
