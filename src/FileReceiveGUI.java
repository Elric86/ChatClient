import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Daniel on 2/29/2016.
 */
public class FileReceiveGUI extends JFrame implements ActionListener, WindowListener{

    JButton accept, deny;


    ChatClient client;
    final JFileChooser fc = new JFileChooser();

    FileReceiveGUI(ChatClient client){

        super("New File Transfer Request");

        this.client = client;

        accept = new JButton("Accept");
        accept.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == accept) {
            int returnVal = fc.showSaveDialog(this);
            return;
        }
        if (o == deny) {
            sendDeny();
            return;
        }

    }
    private void sendDeny(){
        //Send a deny message to the server

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Closing Sequence");
        sendDeny();
    }

    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e){}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        FileReceiveGUI window = new FileReceiveGUI(null);
    }
}
