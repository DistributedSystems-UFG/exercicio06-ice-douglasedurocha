import com.zeroc.Ice.*;

public class Client {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            String host = args.length > 0 ? args[0] : "98.90.53.6";
            ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -h " + host + " -p 5678");
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);

            if (printer == null) {
                throw new Error("Invalid proxy");
            }

            System.out.println("printString:  " + printer.printString("Hello from Goiania!"));
            System.out.println("toUpperCase:  " + printer.toUpperCase("hello from goiania"));
            System.out.println("reverse:      " + printer.reverse("Hello from Goiania!"));
            System.out.println("getInfo:      " + printer.getInfo());

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
