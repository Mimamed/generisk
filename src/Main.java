import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{

    static Timer tidtagaren = new Timer(1000, new räknaren());
    static Nod<Integer> nod = new Nod<Integer>(1, null);
    static Nod temp;
    static JFrame fön = new JFrame();

    public static void main(String[] args)
    {
        nod.läggTill(2);
        nod.läggTill(3);
        nod.läggTill(4);
        nod.läggTill(5);
        nod.läggTill("börjar om...");
        nod.visaSist().sättPekare(nod.visaFörst());
        nod.visaAllaData();
        System.out.println("----------------------------------");

        temp = nod.visaFörst();
        tidtagaren.start();
        fön.dispose();
        fön.setUndecorated(true);
        fön.setVisible(true);
    }


    public static class räknaren implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            System.out.println(temp.visaData());
            temp = temp.visaPekare();

            tidtagaren.start();
        }
    }
}
