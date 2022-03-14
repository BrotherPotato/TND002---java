package complete5;
import javax.swing.*;     
public class Exercise
{
    
    public static void main(String[] args)
    {
        Payroll list = new Payroll();

        System.out.println(list.load());
        String response; String[] subdivided;
        
        do {
        	response=JOptionPane.showInputDialog(null,"Additional employees : ");
        	subdivided = response.split(" +");
        	if (subdivided[0].equals("Boss")) list.insert(new Boss(subdivided[1],subdivided[2],Double.valueOf(subdivided[3])));
        	else if (subdivided[0].equals("Clerk")) list.insert(new Clerk(subdivided[1],subdivided[2],Double.valueOf(subdivided[3]),Double.valueOf(subdivided[4])));
        	else if (subdivided[0].equals("Worker")) list.insert(new Clerk(subdivided[1],subdivided[2],Double.valueOf(subdivided[3]),Integer.valueOf(subdivided[4])));
        }while(!response.equals("end"));
        
        System.out.println("*** Employees unsorted:\n");
        list.print();

        System.out.println("*** Employees sorted by earnings:\n");
        list.sort();
        list.print();
    }
}
