
public class Complex {
	private double real;
	private double img;
	public Complex() {
		real=0.0;
		img=0.0;
	}
	public Complex(double real, double img) {
		this.real= real;
		this.img = img;
		
	}
	public static Complex conjugado(Complex c){
     return new Complex(c.real, -c.img);
	}
	public static double modulo(Complex c) {
		return Math.sqrt(c.real*c.real + c.img*c.img);
	}
	public static Complex suma (Complex c1, Complex c2) {
		double x= c1.real + c2.real;
		double y= c1.img + c2.img;
		return new Complex(x,y);
	} 
	public  static Complex producto(Complex c1, Complex c2) {
		double x= c1.real*c2.real - c1.img* c2.img;
		double y= c1.real*c2.real + c1.img* c2.img;
		return new Complex(x,y);	
	}
	public static Complex division(Complex c1, Complex c2) {
		double aux,x ,y;
		aux= c2.real*c2.real + c2.img*c2.img;
		x= (c1.real*c2.real + c1.img* c2.img)/aux;
		y= (c1.real*c2.real - c1.img* c2.img)/aux;
		return new Complex(x,y);
	}
	public static Complex resta (Complex c1, Complex c2) {
		double x= c1.real - c2.real;
		double y= c1.img - c2.img;
		return new Complex(x,y);
	} 
	public static Complex cartesianoPolar(Complex c) {
		double angulo = Math.atan((c.img/c.real));
		double p = Math.sqrt(Math.pow(c.real,2)+Math.pow(c.img,2));
		return new Complex(p , angulo);
	}
	
	public static Complex polarCartesiano(Complex c) {
		double x = c.real*Math.cos(c.img);
		double y = c.real*Math.sin(c.img);
		return new Complex(x , y);
	}
	
	public static double fase(Complex c) {
		double angulo = Math.atan((c.img/c.real));
		return angulo;
	}
	
	public static void main(String[] args)
		   {
		      Complex a = new Complex(40,56);
		      Complex b = new Complex(10,-10);
		      Complex c = division(a,b);
		      Double d = modulo(a);
		      System.out.println(c.real);
		      System.out.println(c.img);
		      System.out.println(d);
		   }
		
	    
}
