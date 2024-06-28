package printable.concrete;

import org.fusesource.jansi.AnsiConsole;
import printable.abstracts.PrintableService;

import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.ansi;

public class PrintableServiceImplColorfulCMD implements PrintableService {
    private void install() {
        if (!AnsiConsole.isInstalled()) {
            AnsiConsole.systemInstall();
        }
    }

    private void uninstall() {
        if (AnsiConsole.isInstalled()) {
            AnsiConsole.systemUninstall();
        }
    }
/*

    @Override
    public String start() {
        install();
        return "";
    }


    @Override
    public String reset() {
        uninstall();
        return "";
    }
*/

    @Override
    public String getColorfulText(String msg) {
        return ansi().fg(GREEN).a("").reset() + "";
    }
}
