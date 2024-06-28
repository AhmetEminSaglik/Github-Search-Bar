package printable.concrete;

import printable.abstracts.PrintableService;

public class PrintableServiceImplStandart implements PrintableService {
    @Override
    public String getColorfulText(String msg) {
        return msg;
    }
}
