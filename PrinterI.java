import com.zeroc.Ice.Current;

public class PrinterI implements Demo.Printer {

    @Override
    public String printString(String s, Current current) {
        System.out.println("[printString] " + s);
        return "Printed: " + s;
    }

    @Override
    public String toUpperCase(String s, Current current) {
        System.out.println("[toUpperCase] " + s);
        return s.toUpperCase();
    }

    @Override
    public String reverse(String s, Current current) {
        System.out.println("[reverse] " + s);
        return new StringBuilder(s).reverse().toString();
    }

    @Override
    public String getInfo(Current current) {
        return "PrinterServer v1.0 — Java ICE " + com.zeroc.Ice.Util.stringVersion();
    }
}
