package lab1;

public class Vector {
	double x;
	double y;
	double z;
	static Vector vdef = new Vector(0.0, 0.0, 0.0);
		
	public Vector() {
		//vdef = new Vector();
		setToDefault();
	}
	// sets the values of x,y,z to those in the argument list:x=d1, y=d2 and z=d3.
	// constructor =/= method
	public Vector(double d1, double d2, double d3) {
		this.x = d1;
		this.y = d2;
		this.z = d3;
	}
	// The method setDefault(v) sets vdef to v
	public static void setDefault(Vector v) {
		vdef = v;
	}
	// setToDefault() sets the values of x,y,z to those of vdef.
	public void setToDefault() {
		this.x = vdef.x;
		this.y = vdef.y;
		this.z = vdef.z;
		
	}
	// plus(arg1,arg2) takes  in  two vectors, adds up their components and returns the result vector.
	public static Vector plus(Vector arg1, Vector arg2) {
		Vector result = new Vector();
		
		result.x = arg1.x + arg2.x;
		result.y = arg1.y + arg2.y;
		result.z = arg1.z + arg2.z;

		return result;
	}
	// minus(arg) subtracts the coordinate values of arg from the calling in-stance of Vector.
	public Vector minus(Vector arg) {
		Vector result = new Vector();
		
		result.x = this.x - arg.x;
		result.y = this.y - arg.y;
		result.z = this.z - arg.z;
		
		return result;
	}
	// mult(double arg) multiplies arg to  the coordinates  of  the  calling  vector  and  re-turns the result.
	public Vector mult(double arg) {
		Vector result = new Vector();
		
		result.x = this.x * arg;
		result.y = this.y * arg;
		result.z = this.z * arg;
		
		return result;
	}
	/*
	vector3x = vectorx.mult(3);
	*/
	
	// the second method with the same name mult(Vector arg) calculates the scalar product between the calling vector and arg and returns the result.
	public double mult(Vector arg) {
		double sum = 0;
		
		sum += this.x * arg.x;
		sum += this.y * arg.y;
		sum += this.z * arg.z;
		
		return sum;
	}
	// length()returns the length of the calling vector
	public double length() {
		double length = 0;
		
		//length = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
		length = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
		return length;
	}
	
	// matrixMult(arg) takes  the  3  by  3  matrix arg,  multiplies  it  to  the  calling  vector  and returns  the  result.   
	// It  should  return  the  calling  vector  if arg is  not  a  3  by  3  matrix.
	public Vector matrixMult(double[][] arg) {
		if(arg.length != 3 || arg[0].length != 3) {
			return this;
		}
		
		Vector r1 =  new Vector(arg[0][0], arg[0][1], arg[0][2]);
		Vector r2 =  new Vector(arg[1][0], arg[1][1], arg[1][2]);
		Vector r3 =  new Vector(arg[2][0], arg[2][1], arg[2][2]);
		
		Vector result =  new Vector(this.mult(r1), this.mult(r2), this.mult(r3));
		
		return result;
	}
	
	// norm() normalizes the calling vector  to  this  length  (The  method norm() uses length() to  avoid  duplicating  code)
	public void norm() {
		double length = this.length();
		this.x = this.x / length;
		this.y = this.y / length;
		this.z = this.z / length;
	}
	// compareTo(arg) compares the lengths of the calling vector and arg.  
	// It returns 0 if both lengths are equal, it returns 1 if the calling vector is longer than arg and -1 otherwise.
	public int compareTo(Vector arg) {
		double length1 = this.length();
		double length2 = arg.length();
		
		
		if(length1 == length2) {
			return 0;
		} else if(length1 > length2) {
			return 1;
		} else {
			return -1;
		}
		
		/*
		double delta = 0.00001; 
		if(Math.abs(length1 - length2) < delta) {
			return 0;
		} else if(length1 > length2) {
			return 1;
		} else {
			return -1;
		}
		*/
	}
	// toString() returns a formatted string that equals the one in printVector() in Lab1a.
	public String toString() {
		//String s;
		
		//s = "Vector = (" + this.x + ", " + this.y + ", " + this.z + ")";
		
		//return s;
		
		return String.format("Vector = (%4.1f, %4.1f, %4.1f)", this.x, this.y, this.z);
		
	}
}
