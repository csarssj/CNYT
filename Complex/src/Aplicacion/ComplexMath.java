package Aplicacion;

public class ComplexMath{
	private Complex c1;
	private Complex c2;
	public ComplexMath(){
	}
public static Complex suma (Complex c1, Complex c2) {
		double x= c1.getReal() + c2.getReal();
		double y= c1.getImg() + c2.getImg();
		return new Complex(x,y);
	} 
public  static Complex producto(Complex c1, Complex c2) {
		double x= c1.getReal()*c2.getReal() - c1.getImg()* c2.getImg();
		double y= c1.getReal()*c2.getReal() + c2.getImg()* c1.getImg();
		return new Complex(x,y);	
	}
public static Complex division(Complex c1, Complex c2) {
		double aux,x ,y;
		aux= c2.getReal()*c2.getReal() + c2.getImg()*c2.getImg();
		x= (c1.getReal()*c2.getReal() + c1.getImg()* c2.getImg())/aux;
		y= (c1.getReal()*c2.getReal() - c1.getImg()* c2.getImg())/aux;
		return new Complex(x,y);
	}
public static Complex resta (Complex c1, Complex c2) {
		double x= c1.getReal() - c2.getReal();
		double y= c1.getImg() - c2.getImg();
		return new Complex(x,y);
	} 
public static Complex cartesianoPolar(Complex c) {
		double angulo = Math.atan((c.getImg()/c.getReal()));
		double p = Math.sqrt(Math.pow(c.getReal(),2)+Math.pow(c.getImg(),2));
		return new Complex(p , angulo);
	}
	
public static Complex polarCartesiano(Complex c) {
		double x = c.getReal()*Math.cos(c.getImg());
		double y = c.getReal()*Math.sin(c.getImg());
		return new Complex(x , y);
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
		Complex c = new Complex();
		int i,j,fila,columna;
		fila = m1.length;
		columna = m1[0].length;
		Complex r [][] = new Complex [m1.length][m1[0].length];
		for (i=0; i<fila; i++){
			for (j=0; j<columna; j++) {
				r[j][j] = c.conjugado(m1[i][j]);	
			}
		}
		return r;
		
	}
}
