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
	public static Complex[] productoMV(Complex[][] m1, Complex[] v) {
        Complex sum; 
        Complex r [] = new Complex [v.length];
        for (int i = 0; i < m1.length; i++) {
        	sum = new Complex(0,0);
			for (int j = 0; j < v.length; j++) {
                sum = suma(sum,producto(m1[i][j],v[j]));
                }
			
            r[i] = sum;
            }
       return r;
       
    }  
	public static Double distancia(Complex[][] m1, Complex[][] m2) {
		ComplexMatriz r  = new ComplexMatriz(new Complex [m1.length][m1[0].length]);
		Double r2= 0.0;
		r = restaM(m1,m2);
		r2 = r.moduloM();
		return  r2;
	}
	public static ComplexMatriz productoTensor(Complex[][] m1, Complex[][] m2){
        Complex[][] r = new Complex [m1.length*m2.length][m1[0].length*m2[0].length];
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[0].length;j++){
                for(int k=0;k<m2.length;k++){
                    for(int l=0;l<m2[0].length;l++){
                            r[i*m2.length+k][j*m2[0].length+l]=producto(m1[i][j],m2[k][l]);
                        }

                    }
                }

            }
        	return new ComplexMatriz(r);
		}
	public static Complex[] canicasExperimento(Complex[][] m1, Complex[] v, int clics) {
		Complex[] r = v;
		for (int i = 0; i < clics; i++) {
			r = productoMV(m1, r);
		}
		return r;
	}
		
	public static ComplexMatriz rendijasExperimento(int slits, int targets) {
        Complex[][] r  = new Complex [1+slits+targets][1+slits+targets];
        for(int i=0;i<r.length;i++){
            for(int j=0;j<r[0].length;j++){
            	r[i][j] = new Complex(0,0);
            }
        }
		return new ComplexMatriz(r);		
	}
}
