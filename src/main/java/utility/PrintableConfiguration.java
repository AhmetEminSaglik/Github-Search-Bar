package utility;

import printable.abstracts.PrintableService;
import printable.concrete.PrintableServiceImplColorfulJava;

public class PrintableConfiguration implements PrintableService {
    private static PrintableService printableService = new PrintableServiceImplColorfulJava();

    public static void updatePrintableService(PrintableService service) {
        printableService = service;
    }

    @Override
    public String getColorfulText(String msg) {
        return printableService.getColorfulText(msg);
    }

}
