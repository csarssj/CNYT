
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
	public static Complex suma (Complex c1, Complex c2) {
		double x= c1.real + c2.real;
		double y= c1.img + c2.img;
		return new Complex(x,y);
	} 
	public  static Complex producto(Complex c1, Complex c2) {
		double x= c1.real*c2.real - c1.img* c2.img;
		double y= c1.real*c2.real + c2.img* c1.img;
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
	public static Complex[][] sumaM(Complex[][] m1, Complex[][] m2){
		Complex r[][];
		int i,j,fila,columna;
		fila = m1.length;
        columna = m1[0].length;
        r = new Complex [fila][columna];

        for (i = 0; i < fila; i++) {
            for (j = 0; j < columna; j++) {
                r[i][j] = suma(m1[i][j], m2[i][j]);
            }
        }
        return r;
    }
	public static Complex[][] restaM(Complex[][] m1, Complex[][] m2){
		Complex r[][];
		int i,j,fila,columna;
		fila = m1.length;
        columna = m1[0].length;
        r = new Complex [fila][columna];

        for (i = 0; i < fila; i++) {
            for (j = 0; j < columna; j++) {
                r[i][j] = resta(m1[i][j], m2[i][j]);
            }
        }
        return r;
    }
	public static Complex[][] productoScalar(Complex c1, Complex[][] m1){
		Complex r[][];
		int i,j,fila,columna;
		fila = m1.length;
        columna = m1[0].length;
		r = new Complex [fila][columna];
		for (i = 0; i < fila; i++) {
            for (j = 0; j < columna; j++) {
                r[i][j] = producto(c1, m1[i][j]);
            }
		}
		return r;
	}
	
	public static Complex[][] productoM(Complex[][] m1, Complex[][] m2) {
        Complex sum; 
        Complex r [][] = new Complex [m1.length][m1[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                sum = new Complex(0,0);
                for(int k=0;k < m1[0].length;k++){
                    sum = suma(sum,producto(m1[i][k],m2[k][j]));
                }
                r[i][j]=sum;
            }
        }
        return r;
        }
	public static Complex[][] traspuesta(Complex[][] m1){ 
		int i,j,fila,columna;
		fila = m1.length;
		columna = m1[0].length;
	    Complex r [][] = new Complex [m1.length][m1[0].length];
		for (i=0; i<fila; i++){
			for (j=0; j<columna; j++) {
				r[j][i] = m1[i][j];
			}				
		}
		return r;
	} 
	public static Complex[][] conjugadoM(Complex[][] m1){
		int i,j,fila,columna;
		fila = m1.length;
		columna = m1[0].length;
		Complex r [][] = new Complex [m1.length][m1[0].length];
		for (i=0; i<fila; i++){
			for (j=0; j<columna; j++) {
				r[j][j] = conjugado(m1[i][j]);	
			}
		}
		return r;
		
	}
	
	public static void main(String[] args){
			Complex[][] p = {{new Complex(5,-1),new Complex(5,-1)},{new Complex(5,-1),new Complex(5,-1)}};
		    Complex a = new Complex(5,-1);
		    Complex b = new Complex(4,-3);
		    Complex c = producto(a,b);
		    Complex[][] r = productoScalar(b,p);
		    Double d = modulo(a);
		    System.out.println(c.real);
		    System.out.println(c.img);
		    System.out.println(d);
		    System.out.println(r[0][0].real);
		    System.out.println(r[0][0].img);
	}
		
	    
}
