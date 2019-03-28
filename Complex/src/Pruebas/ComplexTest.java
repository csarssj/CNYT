 	package Pruebas;
import  Aplicacion.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComplexTest {

	@Test
	void sumaTest() {
		Complex a = new Complex(5,-1);
	    Complex b = new Complex(4,-3);
	    Complex r = ComplexMath.suma(a,b);
	    Complex r2 = new Complex(9,-4);
	    assertEquals(r.getReal(),9.0);
	    assertEquals(r.getImg(),-4.0);
	    assertTrue(r.equals(r2));
	}
	@Test
	void productoTest() {
		Complex a = new Complex(5,-1);
	    Complex b = new Complex(4,-3);
	    Complex r = ComplexMath.producto(a,b);
	    assertEquals(r.getReal(),17.0);
	    assertEquals(r.getImg(),-19.0);
	}
	@Test
	void conjugadoTest() {
		Complex a = new Complex(5,-1);
		Complex r = a.conjugado();
		assertTrue(r.equals(new Complex (5,1)));
	}
	@Test
	void unitariaTest() {
		ComplexMatriz r = new ComplexMatriz(new Complex[][]{{new Complex(1,1),new Complex(1,-1)},{new Complex(1,-1),new Complex(1,1)}});
        assertTrue(r.unitaria());
	}    
	@Test
	void hermitianaTest() {
		ComplexMatriz r = new ComplexMatriz(new Complex[][]{{new Complex(2,0),new Complex(1,1)},{new Complex(1,-1),new Complex(1,0)}});
		assertTrue(r.hermitiana());
	}
	@Test
	void moduloTest() {
		Complex c = new Complex(5,-1);
		assertEquals(c.modulo(),5.0990195135927845);
	}
	@Test
	void productoScalarTest() {
		Complex[][] a = {{new Complex(5,-1),new Complex(5,-1)},{new Complex(5,-1),new Complex(5,-1)}};
	    Complex c1 = new Complex(4,-3);
	    ComplexMatriz r = ComplexMath.productoScalar(c1,a);
	    assertEquals(r.getMatriz()[0][0].getReal(),17.0);
	    assertEquals(r.getMatriz()[0][0].getImg(),-19.0);
	}
	@Test
	void traspuestaTest() {
		ComplexMatriz a = new ComplexMatriz(new Complex[][]	{{new Complex(5,-1),new Complex(1,0)},{new Complex(0,1),new Complex(5,-1)}});
		ComplexMatriz b = new ComplexMatriz(new Complex[][]{{new Complex(5,-1),new Complex(0,1)},{new Complex(1,0),new Complex(5,-1)}});
		ComplexMatriz r = a.traspuesta();
		assertTrue(r.equals(b));
	}
	@Test
	void conjugadoMTest() {
		ComplexMatriz a = new ComplexMatriz(new Complex[][]	{{new Complex(5,-1),new Complex(1,0)},{new Complex(0,1),new Complex(5,-1)}});
		ComplexMatriz b = new ComplexMatriz(new Complex[][] {{new Complex(5,1),new Complex(1,0)},{new Complex(0,-1),new Complex(5,1)}});
		ComplexMatriz r = a.conjugadoM();
		assertTrue(r.equals(b));
	}
	@Test
	void adjuntaTest() {
		ComplexMatriz a = new ComplexMatriz(new Complex[][]	{{new Complex(5,-1),new Complex(1,0)},{new Complex(0,1),new Complex(5,-1)}});
		ComplexMatriz b = new ComplexMatriz(new Complex[][]{{new Complex(5,1),new Complex(0,-1)},{new Complex(1,0),new Complex(5,1)}});
		ComplexMatriz r = a.adjunta();
		assertTrue(r.equals(b));
	}
	@Test
	void distanciaTest() {
		Complex[][] a = {{new Complex(-4,0),new Complex(-3,0)}};
		Complex[][] b = {{new Complex(2,0),new Complex(5,0)}};
		Double r = ComplexMath.distancia(a, b);	
		assertEquals(r+1,11.0);
	}
	@Test
	void productomTest() {
		Complex[][] a = {{new Complex(2,0),new Complex(0,0)},{new Complex(1,0),new Complex(3,0)}};
		Complex[][] b = {{new Complex(-1,0),new Complex(-1,0)},{new Complex(5,0),new Complex(6,0)}};
		ComplexMatriz r = new ComplexMatriz(new Complex[][]	{{new Complex(-2,0),new Complex(-2,0)},{new Complex(14,0),new Complex(17,0)}});
		assertTrue(ComplexMath.productoM(a, b).equals(r));
	}
	@Test
	void tensorTest() {
		Complex[][] a = {{new Complex(1,0),new Complex(2,0)},{new Complex(3,0),new Complex(1,0)}};
		Complex[][] b = {{new Complex(0,0),new Complex(3,0)},{new Complex(2,0),new Complex(1,0)}};
		ComplexMatriz r = new ComplexMatriz(new Complex[][]	{{new Complex(0,0),new Complex(3,0),new Complex(0,0),new Complex(6,0)},{new Complex(2,0),new Complex(1,0),new Complex(4,0),new Complex(2,0)},{new Complex(0,0),new Complex(9,0),new Complex(0,0),new Complex(3,0)},{new Complex(6,0),new Complex(3,0),new Complex(2,0),new Complex(1,0)}});
		assertTrue(ComplexMath.productoTensor(a, b).equals(r));
	}
		
	/***@Test
	void canicasTest() {
		Complex[] a = {new Complex(6,0),new Complex(2,0),new Complex(1,0),new Complex(5,0),new Complex(3,0),new Complex(10,0)};
		Complex[][] b = new Complex[6][6];
		Complex[] r2 = {new Complex(0,0),new Complex(0,0),new Complex(12,0),new Complex(5,0),new Complex(1,0),new Complex(9,0)};
		for(int i=0;i<6;i++){
	            for(int j=0;j<6;j++){
	            	b[i][j] = new Complex(0,0);
            }
        }
		b[2][1] = new Complex(1,0);
		b[2][5] = new Complex(1,0);
		b[3][3] = new Complex(1,0);
		b[4][2] = new Complex(1,0);
		b[5][0] = new Complex(1,0);
		b[5][4] = new Complex(1,0);
		

		Complex[] r = ComplexMath.canicasExperimento(b, a, 1);
		for(int i=0;i<r.length;i++){
				assertTrue(r[i].equals(r2[i]));
		}
	}***/
	@Test 
	void probabilidadEnXTest() {
		Complex[] a = {new Complex(-3,-1),new Complex(0,-2),new Complex(0,1),new Complex(2,0)};
		assertEquals(ComplexMath.probaPos(a,2),0.05263157894736841);
	}
	@Test
	void amplitudTest() {
		Complex[] a = {new Complex(1,0),new Complex(0,-1)};
		Complex[] b = {new Complex(0,1),new Complex(1,0)};
		assertTrue(ComplexMath.amplitudT(b, a).equals(new Complex(0,-0.9999999999999998)));	


	}
	@Test
	void valorMTest() {
		Complex[] ket = {new Complex(Math.sqrt(2)/2,0),new Complex(0,Math.sqrt(2)/2)};
		Complex[][] observable = {{new Complex(1,0),new Complex(0,-1)},{new Complex(0,1),new Complex(2,0)}};
		assertTrue(ComplexMath.mean(observable, ket).equals(new Complex(2.5000000000000004,0)));
		
	}
	@Test	
	void varianzaTest() {
		Complex[][] observable = {{new Complex(1,0),new Complex(0,-1)},{new Complex(0,1),new Complex(2,0)}};
		Complex[] ket = {new Complex(Math.sqrt(2)/2,0),new Complex(0,Math.sqrt(2)/2)};
		assertTrue(ComplexMath.varianza(observable, ket).equals(new Complex(0.25,0.0)));
	}
	
}