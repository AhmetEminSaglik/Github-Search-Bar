package printable.concrete;

import printable.abstracts.PrintableService;
import utility.ConsoleColors;

public class PrintableServiceImplColorfulJava implements PrintableService {

    @Override
    public String getColorfulText(String msg) {
        return ConsoleColors.GREEN_BOLD_BRIGHT + msg ;
    }
}
