package custombank.project.accountsservice.exceptions;

public class InsufficientFundsException extends Exception{

    public InsufficientFundsException(){
        super("Insufficient funds in the account");
    }
}
