import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI extends JFrame {
    DataReceiver receiver;
    String message = "";
    JTextArea textArea = new JTextArea(50, 25);
    JPanel panel1 = new JPanel();
    JScrollPane scrollPane = new JScrollPane(textArea);

    public GUI(DataReceiver receiver) throws UnknownHostException, SocketException, IOException {
        this.receiver = receiver;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        add(panel1);
        panel1.add(scrollPane);

        while (true) {
            textArea.append(receiver.getData() + "\n");
            revalidate();
            repaint();
        }
    }
}