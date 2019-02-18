package Aplicacion;

public class Complex {
	private double real;
	private double img;	
	public Complex(double real, double img) {
		this.real= real;
		this.img = img;
		
	}
	public double getReal() {
		return real;
	}
	public double getImg() {
		return img;
	}
	public  Complex conjugado(){
     return new Complex(real, img*(-1));
	}
	public  Complex inverso() {
		return new Complex(real*(-1),img*(-1));
	}
	public  double modulo( ) {
		return Math.sqrt(real*real + img*img);
	}
	
	public  double fase() {
		double angulo = Math.atan((img/real));
		return angulo;
	}	
	public boolean equals(Complex c){
        return real == c.getReal() && img == c.getImg();
    }
	public static void main(String[] args){
			Complex[][] p = {{new Complex(5,-1),new Complex(5,-1)},{new Complex(5,-1),new Complex(5,-1)}};
			Complex[][] p1 = {{new Complex(5,-1),new Complex(1,0)},{new Complex(0,1),new Complex(5,-1)}};
		    Complex a = new Complex(5,-1);
		    Complex b = new Complex(4,-3);
		    Complex c = ComplexMath.producto(a,b);
		    Complex m = a.conjugado();
		    ComplexMatriz r = ComplexMath.productoScalar(b,p);
		    Double d = a.modulo();
		    System.out.println(c.real);
		    System.out.println(c.img);
		    System.out.println(d);
		    System.out.println(m.real);
		    System.out.println(m.img);
		    System.out.println(r.getMatriz()[0][0].real);
		    System.out.println(r.getMatriz()[0][0].img);
	}
		
	    
}
