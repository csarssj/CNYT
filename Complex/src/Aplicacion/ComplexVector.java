package Aplicacion;

public class ComplexVector {
	private Complex[] vector;
	
	public ComplexVector(Complex[] vector) {
		this.vector = vector;
	}

	public Complex[] getVector() {
		return vector;
	} 
	public  ComplexVector conjugadoV(){
		Complex r [] = new Complex [vector.length];
		for (int i=0; i< vector.length; i++){
				r[i] = vector[i].conjugado();	
			}
		return new ComplexVector(r);
		
	}	
	public ComplexVector adjunta(){
		return this.conjugadoV();
	}
	public ComplexVector inversaM() {
		Complex r [] = new Complex [vector.length];
		for (int i=0; i< vector.length; i++){
				r[i] = vector[i].inverso();	
			}
		return new ComplexVector(r);
		
	}
	public Double moduloM() {
		Double r = 0.0;
		for (int i=0; i< vector.length; i++){
				r += Math.pow(vector[i].modulo(),2);
	
			}
		return Math.sqrt(r);
	}
	public boolean equals(ComplexVector v1){
        if(vector.length != v1.getVector().length ){
            return false;
        }
        boolean bandera = true;
        for(int i = 0; i< vector.length && bandera; i++){
                if(!vector[i].equals(v1.getVector()[i])) bandera = false;
        }
        return bandera;

    }
}
