package complete4;
public class Complex {
	private double real, imag;
	public Complex(double inR, double inI){
		real = inR; imag = inI;
	}
	Complex add(Complex arg){
		return new Complex(real+arg.real, imag+arg.imag);
	}
	Complex subtract(Complex arg){
		return new Complex(real-arg.real, imag-arg.imag);
	}
	Complex mult(Complex arg){
		return new Complex(real*arg.real-imag*arg.imag,real*arg.imag+imag*arg.real);
	}
	Complex conjugate(){
		return new Complex(real, -imag);
	}
	Complex div(Complex arg){
		double c = arg.real*arg.real+arg.imag*arg.imag;
		Complex dummy = new Complex(real/c, imag/c);
		return dummy.mult(arg.conjugate());
	}
	public String toString(){
		return real + " + i * " + imag;
	}
}
