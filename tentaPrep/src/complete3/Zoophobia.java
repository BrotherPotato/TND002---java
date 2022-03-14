package complete3;


public class Zoophobia implements Comparable<Zoophobia>
{
    // instansvariabler

    private String phobia;
    private String animal;

    // konstruktorer

    public Zoophobia(String thePhobia, String theAnimal)
    {
        phobia = thePhobia;
        animal = theAnimal;
    }

    // instansmetoder

    public void setPhobia(String thePhobia)
    {
        phobia = thePhobia;
    }

    public void setAnimal(String theAnimal)
    {
        animal = theAnimal;
    }

    public String getPhobia()
    {
        return phobia;
    }

    public String getAnimal()
    {
        return animal;
    }

    public int compareTo(Zoophobia zp)
    {
        return phobia.compareTo(zp.phobia);
    }
    
    public String toString()
    {
        return phobia + " - fear of " + animal;
    }
}
