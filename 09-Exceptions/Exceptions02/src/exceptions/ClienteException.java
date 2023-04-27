package exceptions;

public class ClienteException extends Exception {

    public ClienteException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
