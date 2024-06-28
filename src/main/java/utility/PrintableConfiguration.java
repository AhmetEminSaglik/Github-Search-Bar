package utility;

import printable.abstracts.PrintableService;
import printable.concrete.PrintableServiceImplColorfulCMD;
import printable.concrete.PrintableServiceImplColorfulJava;
import printable.concrete.PrintableServiceImplStandart;

public class PrintableConfiguration implements PrintableService {
    private static PrintableService printableService = new PrintableServiceImplColorfulJava();

    public static void updatePrintableService(int id) {
        switch (id) {
            case 1:
                updatePrintableService(new PrintableServiceImplColorfulJava());
                break;
            case 2:
                updatePrintableService(new PrintableServiceImplColorfulCMD());
                break;
            case 3:
                updatePrintableService(new PrintableServiceImplStandart());
                break;
            default:
                System.out.println("Invalid input. Proccessing with " + printableService.getClass().getSimpleName());
        }
    }

    @Override
    public String getColorfulText(String msg) {
        return printableService.getColorfulText(msg);
    }

    private static void updatePrintableService(PrintableService newPrintableService) {
        printableService.destroy();
        printableService = newPrintableService;
        printableService.intialize();
    }

}
