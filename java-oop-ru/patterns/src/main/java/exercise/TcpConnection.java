package exercise;
import exercise.connections.Connected;
import exercise.connections.Connection;

// BEGIN
public class TcpConnection implements Connection {
    private Connection state;

    public TcpConnection(String ipAddress, int port) {
        state = new Connected(this);
    }

    public void setState(Connection state) {
        this.state = state;
    }
    @Override
    public String getCurrentState() {
        return state.getCurrentState();
    }

    @Override
    public void connect() {
        state.connect();
    }

    @Override
    public void disconnect() {
        state.disconnect();
    }

    @Override
    public void write(String data) {
        System.out.println("Error!");
    }
}
// END
