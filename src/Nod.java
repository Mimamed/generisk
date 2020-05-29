public class Nod<typ>
{

    private typ paket; // noden kan ha vilken data typ som hellst
    private Nod pekare;
    private static Nod förstaNod;

    Nod(typ data, Nod pekning) //för att skapa en nod ska man behöva sätta in ett
    {
        paket = data;
        pekare = pekning;

        //sätter in den som första nod om den är första noden för att veta var kedjan börjar
        if (förstaNod == null)
        {
            förstaNod = this;
        }
    }

    public void sättPaket(typ data) // en metod som låter oss ändra nodens data
    {
        paket = data;
    }

    public void sättPekare(Nod pekning) // en metod som låter oss ändra var noden pekar
    {
        pekare = pekning;
    }

    public typ visaData() // en metod som låter oss se nodens data
    {
        return paket;
    }

    public Nod visaPekare() // en metod som låter oss se var noden pekar
    {
        return pekare;
    }

    public Nod visaFörst() //en metod som låter oss se vilken nod som är först i kedjan
    {
        return förstaNod;
    }

    public Nod visaSist() // en metod som låter oss se vilken nod som är sist i kedian
    {
        Nod temp = this;
        while(temp.visaPekare() != null)
        {
            temp = temp.visaPekare();
        }
        return temp;
    }

    public <dataTyp> void läggTill(dataTyp data) // en metod som låter oss sätta lägga till en ny nod vid slutet av kedjan
    {
        visaSist().sättPekare(new Nod(data, null));
    }

    public void visaAllaData() // en metod som skriver ut datan på alla noder i kedjan i rätt ordning
    {
        Nod temp = förstaNod;
        while (temp.visaPekare() != null && temp.visaPekare() != förstaNod) // ser även till att den inte går för evigt om kedjan går i cirklar
        {
            System.out.println(temp.visaData());
            temp = temp.visaPekare();
        }
        System.out.println(temp.visaData());
    }
}
