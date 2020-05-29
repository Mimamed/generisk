public class Nod<typ>
{

    private typ paket;
    private Nod pekare;
    private static Nod förstaNod;

    Nod(typ data, Nod pekning)
    {
        paket = data;
        pekare = pekning;
        if (förstaNod == null)
        {
            förstaNod = this;
        }
    }

    public void sättPaket(typ data)
    {
        paket = data;
    }

    public void sättPekare(Nod pekning)
    {
        pekare = pekning;
    }

    public typ visaData()
    {
        return paket;
    }

    public Nod visaPekare()
    {
        return pekare;
    }

    public Nod visaFörst()
    {
        return förstaNod;
    }

    public Nod visaSist()
    {
        Nod temp = this;
        while(temp.visaPekare() != null)
        {
            temp = temp.visaPekare();
        }
        return temp;
    }

    public <dataTyp> void läggTill(dataTyp data)
    {
        visaSist().sättPekare(new Nod(data, null));
    }

    public void visaAllaData()
    {
        Nod temp = förstaNod;
        while (temp.visaPekare() != null && temp.visaPekare() != förstaNod)
        {
            System.out.println(temp.visaData());
            temp = temp.visaPekare();
        }
        System.out.println(temp.visaData());
    }
}
