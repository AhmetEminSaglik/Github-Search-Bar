package printable.concrete;

import org.fusesource.jansi.AnsiConsole;
import printable.abstracts.PrintableService;

import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.ansi;

public class PrintableServiceImplColorfulCMD implements PrintableService {
    public PrintableServiceImplColorfulCMD() {
    }

    @Override
    public void intialize() {
        AnsiConsole.systemInstall();
    }

    @Override
    public void destroy() {
        AnsiConsole.systemUninstall();
    }

    @Override
    public String getColorfulText(String msg) {
        return ansi().fg(GREEN).a(msg).reset() + "";
    }
}
