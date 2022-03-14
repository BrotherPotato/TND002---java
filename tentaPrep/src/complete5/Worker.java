package complete5;
public class Worker extends Employee
{
    protected double  rate;
    protected int quantity;

    public Worker(String first, String last, double r, int q)
    {
        super(first, last);
        setRate(r);
        setQuantity(q);
    }

    public void setRate(double r)
    {
        rate = (r < 0.0) ? 0.0 : r;
    }

    public void setQuantity(int q)
    {
        quantity = (q < 0) ? 0 : q;
    }

    public double earnings()
    {
        return rate * quantity;
    }

    public String toString()
    {
        return String.format("%-8s%s", "Worker", super.toString());
    }
}
