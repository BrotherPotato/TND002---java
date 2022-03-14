package complete5;
public abstract class Employee implements Comparable<Employee>
{
    protected String firstName;
    protected String lastName;

    public Employee(String first, String last)
    {
        firstName = first;
        lastName  = last;
    }

    abstract public double earnings();

    public int compareTo(Employee emp)
    {
        if (earnings() < emp.earnings())
        {
            return -1;
        }
        else if (earnings() > emp.earnings())
        {
            return +1;
        }
        else 
        {
            return 0;
        }
    }

    public String toString()
    {
        return String.format("%-8s%-12s", firstName, lastName);
    }
}
