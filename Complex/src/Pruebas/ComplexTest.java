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
	

}
