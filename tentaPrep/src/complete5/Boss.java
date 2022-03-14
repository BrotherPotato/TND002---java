package complete5;
public class Boss extends Employee
{

    protected double salary;
    public Boss(String first, String last, double s)
    {
        super(first, last);
        setSalary(s);
    }

    public void setSalary(double s)
    {  
    	salary = 0; if (s>0.0) salary = s;
    }

    public double earnings()
    {
        return salary;
    }

    public String toString()
    {
        return String.format("%-8s%s", "Boss", super.toString());
    }
}
