import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
public class OperationTest {

    @Test
    public void testAddition() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.getPolynomial().put(4, 3.0);
        p1.getPolynomial().put(3, 2.0);
        p1.getPolynomial().put(2, 5.0);
        p2.getPolynomial().put(4, 2.0);
        assertEquals(Operations.addition(p1,p2).toString(), "5x^4 + 2x^3 + 5x^2");

        Polynomial p3 = new Polynomial();
        Polynomial p4 = new Polynomial();
        p3.getPolynomial().put(3, 4.0);
        p3.getPolynomial().put(2, 3.0);
        p3.getPolynomial().put(1, 2.0);
        p4.getPolynomial().put(4, 1.0);
        p4.getPolynomial().put(2, 2.0);
        assertEquals(Operations.addition(p3, p4).toString(), "x^4 + 4x^3 + 5x^2 + 2x");

        Polynomial p5 = new Polynomial();
        Polynomial p6 = new Polynomial();
        p5.getPolynomial().put(4, -2.0);
        p5.getPolynomial().put(2, 3.0);
        p5.getPolynomial().put(1, -1.0);
        p6.getPolynomial().put(3, -1.0);
        p6.getPolynomial().put(2, -2.0);
        assertEquals(Operations.addition(p5, p6).toString(), "-2x^4 - x^3 + x^2 - x");


    }

    @Test
    public void testSubtraction() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.getPolynomial().put(4, 3.0);
        p1.getPolynomial().put(3, 2.0);
        p1.getPolynomial().put(2, 5.0);
        p2.getPolynomial().put(4, 2.0);
        assertEquals(Operations.subtraction(p1,p2).toString(), "x^4 + 2x^3 + 5x^2");

        Polynomial p3 = new Polynomial();
        Polynomial p4 = new Polynomial();
        p3.getPolynomial().put(3, 4.0);
        p3.getPolynomial().put(2, 3.0);
        p3.getPolynomial().put(1, 2.0);
        p4.getPolynomial().put(4, 1.0);
        p4.getPolynomial().put(2, 2.0);
        assertEquals(Operations.subtraction(p3, p4).toString(), "-x^4 + 4x^3 + x^2 + 2x");

        Polynomial p5 = new Polynomial();
        Polynomial p6 = new Polynomial();
        p5.getPolynomial().put(4, -2.0);
        p5.getPolynomial().put(2, 3.0);
        p5.getPolynomial().put(1, -1.0);
        p6.getPolynomial().put(3, -1.0);
        p6.getPolynomial().put(2, -2.0);
        assertEquals(Operations.subtraction(p5, p6).toString(), "-2x^4 + x^3 + 5x^2 - x");
    }

    @Test
    public void testMultiplication() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.getPolynomial().put(4, 3.0);
        p1.getPolynomial().put(3, 2.0);
        p1.getPolynomial().put(2, 5.0);
        p2.getPolynomial().put(4, 2.0);
        assertEquals(Operations.multiplication(p1,p2).toString(), "6x^8 + 4x^7 + 10x^6");

        Polynomial p3 = new Polynomial();
        Polynomial p4 = new Polynomial();
        p3.getPolynomial().put(3, 4.0);
        p3.getPolynomial().put(2, 3.0);
        p3.getPolynomial().put(1, 2.0);
        p4.getPolynomial().put(4, 1.0);
        p4.getPolynomial().put(2, 2.0);
        assertEquals(Operations.multiplication(p3, p4).toString(), "4x^7 + 3x^6 + 10x^5 + 6x^4 + 4x^3");

        Polynomial p5 = new Polynomial();
        Polynomial p6 = new Polynomial();
        p5.getPolynomial().put(4, -2.0);
        p5.getPolynomial().put(2, 3.0);
        p5.getPolynomial().put(1, -1.0);
        p6.getPolynomial().put(3, -1.0);
        p6.getPolynomial().put(2, -2.0);
        assertEquals(Operations.multiplication(p5, p6).toString(), "2x^7 + 4x^6 - 3x^5 - 5x^4 + 2x^3");
    }

    @Test
    public void testDerivative() {
        Polynomial p1 = new Polynomial();
        p1.getPolynomial().put(4, 3.0);
        p1.getPolynomial().put(3, 2.0);
        p1.getPolynomial().put(2, 5.0);
        assertEquals(Operations.derivative(p1).toString(), "12x^3 + 6x^2 + 10x");

        Polynomial p2 = new Polynomial();
        p2.getPolynomial().put(4, 2.0);
        assertEquals(Operations.derivative(p2).toString(), "8x^3");

        Polynomial p3 = new Polynomial();
        p3.getPolynomial().put(3, 4.0);
        p3.getPolynomial().put(2, 3.0);
        p3.getPolynomial().put(1, 2.0);
        assertEquals(Operations.derivative(p3).toString(), "12x^2 + 6x + 2");

        Polynomial p4 = new Polynomial();
        p4.getPolynomial().put(4, 1.0);
        p4.getPolynomial().put(2, 2.0);
        assertEquals(Operations.derivative(p4).toString(), "4x^3 + 4x");

        Polynomial p5 = new Polynomial();
        p5.getPolynomial().put(4, -2.0);
        p5.getPolynomial().put(2, 3.0);
        p5.getPolynomial().put(1, -1.0);
        assertEquals(Operations.derivative(p5).toString(), "-8x^3 + 6x - 1") ;

        Polynomial p6 = new Polynomial();
        p6.getPolynomial().put(3, -1.0);
        p6.getPolynomial().put(2, -2.0);
        assertEquals(Operations.derivative(p6).toString(), "-3x^2 - 4x");
    }

    @Test
    public void testIntegration() {
        Polynomial p1 = new Polynomial();
        p1.getPolynomial().put(4, 3.0);
        p1.getPolynomial().put(3, 2.0);
        p1.getPolynomial().put(2, 5.0);
        assertEquals(Operations.integration(p1).toString(), "0.6x^5 + 0.5x^4 + 1.6666666666666667x^3");

        Polynomial p2 = new Polynomial();
        p2.getPolynomial().put(4, 2.0);
        assertEquals(Operations.integration(p2).toString(), "0.4x^5");

        Polynomial p3 = new Polynomial();
        p3.getPolynomial().put(3, 4.0);
        p3.getPolynomial().put(2, 3.0);
        p3.getPolynomial().put(1, 2.0);
        assertEquals(Operations.integration(p3).toString(), "x^4 + x^3 + x^2");

        Polynomial p4 = new Polynomial();
        p4.getPolynomial().put(4, 1.0);
        p4.getPolynomial().put(2, 2.0);
        assertEquals(Operations.integration(p4).toString(), "0.2x^5 + 0.6666666666666666x^3");

        Polynomial p5 = new Polynomial();
        p5.getPolynomial().put(4, -2.0);
        p5.getPolynomial().put(2, 3.0);
        p5.getPolynomial().put(1, -1.0);
        assertEquals(Operations.integration(p5).toString(), "-0.4x^5 + x^3 - 0.5x^2" );

        Polynomial p6 = new Polynomial();
        p6.getPolynomial().put(3, -1.0);
        p6.getPolynomial().put(2, -2.0);
        assertEquals(Operations.integration(p6).toString(), "-0.25x^4 - 0.6666666666666666x^3" );
    }

    @Test
    public void testDivision() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.getPolynomial().put(2, 1.0);
        p1.getPolynomial().put(1, -2.0);
        p1.getPolynomial().put(0, 1.0);
        p2.getPolynomial().put(1, 1.0);
        p2.getPolynomial().put(0, -1.0);

        assertEquals(Operations.division(p1,p2)[0].toString(),"x - 1");
        assertEquals(Operations.division(p1,p2)[1].toString(),"");

        Polynomial p3 = new Polynomial();
        Polynomial p4 = new Polynomial();
        p3.getPolynomial().put(3, 1.0);
        p3.getPolynomial().put(2, -2.0);
        p3.getPolynomial().put(1, 6.0);
        p3.getPolynomial().put(0, -5.0);
        p4.getPolynomial().put(2, 1.0);
        p4.getPolynomial().put(0, -1.0);

        assertEquals(Operations.division(p3,p4)[0].toString(),"x - 2");
        assertEquals(Operations.division(p3,p4)[1].toString(),"7x - 7");

    }


}
