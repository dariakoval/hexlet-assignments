package exercise.connections;

import exercise.TcpConnection;
import lombok.AllArgsConstructor;

@AllArgsConstructor
// BEGIN
public class Connected implements Connection {
    private TcpConnection context;

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error!");
    }

    @Override
    public void disconnect() {
        context.setState(new Disconnected(context));
    }

    @Override
    public void write(String data) {
        System.out.println(data);
    }
}
// END
