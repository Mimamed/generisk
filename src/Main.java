import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{

    static Timer tidtagaren = new Timer(1000, new räknaren()); // här sätter jag upp en timer på en sekund
    static Nod<Integer> nod = new Nod<Integer>(1, null);//skapar första noden ur min nod klass
    static Nod temp;
    static JFrame fön = new JFrame();

    public static void main(String[] args)
    {
        //skapar en kedia av noder och ger varje en sin värde
        nod.läggTill(2);
        nod.läggTill(3);
        nod.läggTill(4);
        nod.läggTill(5);
        nod.läggTill("börjar om...");

        //här gör jag så att sista nodens pekare pekar mot första noden och på detta sättet skapar en kedja som går i cirklar
        nod.visaSist().sättPekare(nod.visaFörst());

        //sätter upp timern
        temp = nod.visaFörst();//sätter in noden timern ska börja med
        tidtagaren.start();//startar timern

        //skapar en osynlig fönster för att hindra avstängning
        fön.dispose();
        fön.setUndecorated(true);
        fön.setVisible(true);
    }


    public static class räknaren implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            System.out.println(temp.visaData());//timern räknar
            temp = temp.visaPekare();//noden går ett steg framåt i kedian

            tidtagaren.start();//startar timern igen
        }
    }
}
