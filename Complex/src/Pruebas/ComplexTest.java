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
	    assertEquals(r.getReal(),9.0);
	    assertEquals(r.getImg(),-4.0);
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
	void productoScalarTest() {
		Complex[][] a = {{new Complex(5,-1),new Complex(5,-1)},{new Complex(5,-1),new Complex(5,-1)}};
	    Complex c1 = new Complex(4,-3);
	    Complex[][] r = ComplexMath.productoScalar(c1,a);
	    assertEquals(r[0][0].getReal(),17.0);
	    assertEquals(r[0][0].getImg(),-19.0);
	}
	@Test
	void traspuestaCojungadoTest() {
		Complex[][] a = {{new Complex(5,-1),new Complex(1,0)},{new Complex(0,1),new Complex(5,-1)}};
		Complex[][] b = {{new Complex(5,1),new Complex(0,-1)},{new Complex(1,0),new Complex(5,1)}};
		Complex[][] r = ComplexMath.conjugadoM(ComplexMath.traspuesta(a));
	    assertEquals(r,b);
	}


}
