package exercise.connections;

import exercise.TcpConnection;
import lombok.AllArgsConstructor;

@AllArgsConstructor
// BEGIN
public class Disconnected implements Connection {
    private TcpConnection context;
    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        context.setState(new Connected(this.context));
    }

    @Override
    public void disconnect() {
        System.out.println("Error!");
    }

    @Override
    public void write(String data) {
        System.out.println("Error!");
    }
}
// END
