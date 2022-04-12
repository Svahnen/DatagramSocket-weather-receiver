import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class GUI extends JFrame {
    DataReceiver receiver;
    List<JLabel> messageLabels = new ArrayList<JLabel>();
    JPanel panel1 = new JPanel();

    public GUI(DataReceiver receiver) throws UnknownHostException, SocketException, IOException {
        this.receiver = receiver;

        panel1.setLayout(new GridLayout(20, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        add(panel1);
        panel1.add(new JLabel("test"));

        while (true) {
            messageLabels.add(new JLabel(receiver.getData()));
            panel1.add(messageLabels.get(messageLabels.size() - 1));
            revalidate();
            repaint();
        }
    }
}