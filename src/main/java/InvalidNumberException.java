public class InvalidNumberException extends Exception {
    public InvalidNumberException(int number) {
        super("Invalid Number: \"" + number + "\"");
    }
}
