package Aplicacion;

public class ComplexMatriz {
	private Complex[][] matriz;
	private int i,j;
	public ComplexMatriz(int i, int j) {
		this.i=i;
		this.j=j;
		this.matriz= new Complex [i][j];
	}
	public ComplexMatriz(Complex[][] r) {
		this.matriz = r;
	}
	
	public  ComplexMatriz traspuesta(){ 
	    Complex r [][] = new Complex [matriz[0].length][matriz.length];
		for (int i=0; i< matriz[0].length; i++){
			for (int j=0; j<matriz.length; j++) {
				r[j][i] = matriz[i][j];
			}				
		}
		
		return new ComplexMatriz(r);
	} 
	public  ComplexMatriz conjugadoM(){
		Complex r [][] = new Complex [matriz.length][matriz[0].length];
		for (int i=0; i< matriz.length; i++){
			for (int j=0; j<matriz[0].length; j++) {
				r[i][j] = matriz[i][j].conjugado();	
			}
		}
		return new ComplexMatriz(r);
		
	}	
	public ComplexMatriz adjunta(){
		return this.traspuesta().conjugadoM();
	}
	public ComplexMatriz inversaM() {
		Complex r [][] = new Complex [matriz.length][matriz[0].length];
		for (int i=0; i< matriz.length; i++){
			for (int j=0; j<matriz[0].length; j++) {
				r[i][j] = matriz[i][j].inverso();	
			}
		}
		return new ComplexMatriz(r);
	}
	public Double moduloM() {
		Double r = 0.0;
		for (int i=0; i< matriz.length; i++){
			for (int j=0; j<matriz[0].length; j++) {
				r += Math.pow(matriz[i][j].modulo(),2);
	
			}
		}
		return Math.sqrt(r);
	}

	public Complex[][] getMatriz(){
		return matriz;
	}
	public boolean equals(ComplexMatriz complexMatrix){
        if(matriz.length != complexMatrix.getMatriz().length || matriz[0].length != complexMatrix.getMatriz()[0].length){
            return false;
        }
        boolean bandera = true;
        for(int i = 0; i< matriz.length && bandera; i++){
            for(int j = 0; j< matriz[0].length && bandera; j++){
                if(!matriz[i][j].equals(complexMatrix.getMatriz()[i][j])) bandera = false;
            }
        }
        return bandera;

    }
}
