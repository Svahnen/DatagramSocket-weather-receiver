import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

public class DataReceiver {

    int minPort = 55555;
    DatagramSocket socket = new DatagramSocket(minPort);
    byte[] data = new byte[256];

    public DataReceiver() throws UnknownHostException, SocketException, IOException {
        while (true) {
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println("Message from " + packet.getAddress().getHostAddress() + " " + LocalDateTime.now());
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message);
        }
    }
}
