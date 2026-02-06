package mycontacts.exceptions;

public class ContatoDuplicadoException extends Exception {
    public ContatoDuplicadoException() {
    }

    public ContatoDuplicadoException(String message) {
        super(message);
    }
}
