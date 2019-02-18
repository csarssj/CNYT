package Aplicacion;

public class ComplexMath{
	public ComplexMath(){
	}
	public static Complex suma (Complex c1, Complex c2) {
		double x= c1.getReal() + c2.getReal();
		double y= c1.getImg() + c2.getImg();
		return new Complex(x, y);
	} 
	public  static Complex producto(Complex c1, Complex c2) {
		double x= c1.getReal()*c2.getReal() - c1.getImg()* c2.getImg();
		double y= c1.getReal()*c2.getImg() + c2.getReal()* c1.getImg();
		return new Complex(x,y);	
	}
	public static Complex division(Complex c1, Complex c2) {
		double aux,x ,y;
		aux= c2.getReal()*c2.getReal() + c2.getImg()*c2.getImg();
		x= (c1.getReal()*c2.getReal() + c1.getImg()* c2.getImg())/aux;
		y= (c1.getImg()*c2.getReal() - c1.getReal()* c2.getImg())/aux;
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
	public static ComplexMatriz sumaM(Complex[][] m1, Complex[][] m2){
		Complex r [][] = new Complex [m1.length][m1[0].length];
		for (int i=0; i< m1.length; i++){
			for (int j=0; j<m1[0].length; j++) {
                r[i][j] = suma(m1[i][j], m2[i][j]);
            }
        }
        return  new ComplexMatriz(r);
    }
	public static ComplexMatriz restaM(Complex[][] m1, Complex[][] m2){
		Complex r [][] = new Complex [m1.length][m1[0].length];
		for (int i=0; i< m1.length; i++){
			for (int j=0; j<m1[0].length; j++) {
                r[i][j] = resta(m1[i][j], m2[i][j]);
            }
        }
        return  new ComplexMatriz(r);
    }
	public static ComplexMatriz productoScalar(Complex c1, Complex[][] m1){
		Complex r [][] = new Complex [m1.length][m1[0].length];
		for (int i=0; i< m1.length; i++){
			for (int j=0; j<m1[0].length; j++) {               
				r[i][j] = producto(c1, m1[i][j]);
            }
		}
		return new ComplexMatriz(r);
	}
	
	public static ComplexMatriz productoM(Complex[][] m1, Complex[][] m2) {
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
        return new ComplexMatriz(r);
    }
	public Double distancia(Complex[][] m1, Complex[][] m2) {
		ComplexMatriz r  = new ComplexMatriz(new Complex [m1.length][m1[0].length]);
		Double r2= 0.0;
		r = restaM(m1,m2);
		r2 = r.moduloM();
		return  r2;
	}
	
	
}
