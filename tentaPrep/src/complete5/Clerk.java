package complete5;
public class Clerk extends Employee
{
    protected double wage;
    protected double hours;

    public Clerk(String first, String last, double w, double h)
    {
        super(first, last);
        setWage(w);
        setHours(h);
    }

    public void setWage(double w)
    {
    	wage = 0; 
    	if (w>0) wage = w;
    }

    public void setHours(double h)
    {
        hours = 0; 
        if (h>0) hours = h;
    }

    public double earnings()
    {
        return wage * hours;
    }

    public String toString()
    {
        return String.format("%-8s%s", "Clerk", super.toString());
    }
}
