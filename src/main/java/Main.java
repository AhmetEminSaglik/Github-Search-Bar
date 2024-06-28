import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

public class Main {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        SearchBar searchBar = new SearchBar();
        searchBar.start();
//        System.out.println(ansi().fg(RED).a("Hello World").reset());
//        AnsiConsole.systemUninstall();
    }
}
