package Aplicacion;

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
	public double getReal() {
		return this.real;
	}
	public double getImg() {
		return this.img;
	}
	public static Complex conjugado(Complex c){
     return new Complex(c.real, -c.img);
	}
	public static double modulo(Complex c) {
		return Math.sqrt(c.real*c.real + c.img*c.img);
	}
	
	public static double fase(Complex c) {
		double angulo = Math.atan((c.img/c.real));
		return angulo;
	}	
	public static void main(String[] args){
			ComplexMath complex = new ComplexMath();

			Complex[][] p = {{new Complex(5,-1),new Complex(5,-1)},{new Complex(5,-1),new Complex(5,-1)}};
		    Complex a = new Complex(5,-1);
		    Complex b = new Complex(4,-3);
		    Complex c = complex.producto(a,b);
		    Complex[][] r = complex.productoScalar(b,p);
		    Double d = modulo(a);
		    System.out.println(c.real);
		    System.out.println(c.img);
		    System.out.println(d);
		    System.out.println(r[0][0].real);
		    System.out.println(r[0][0].img);
	}
		
	    
}
