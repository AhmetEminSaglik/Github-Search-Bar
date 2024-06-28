package printable.abstracts;

public interface PrintableService {


    default void intialize() {
    }

    default void destroy() {
    }

    String getColorfulText(String msg);
}
