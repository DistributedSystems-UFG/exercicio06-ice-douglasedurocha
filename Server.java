import com.zeroc.Ice.*;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints(
                "SimplePrinter", "default -p 5678"
            );

            adapter.add(new PrinterI(), Util.stringToIdentity("SimplePrinter"));
            adapter.activate();

            System.out.println("Server running on port 5678. Waiting for requests...");
            communicator.waitForShutdown();

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
