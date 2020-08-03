package com.example.calculator.ModelUnitTest;

import com.example.calculator.Model.CalculatorModel;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModelUnitTest {


    /**
     * Initialize Model Object
     */
    private CalculatorModel model;
    public ModelUnitTest(){
         model = new CalculatorModel();
    }

    /**
     * Test add Method
     */
    @Test
    public void addDoubleAndDouble_isTrue(){
        assertEquals(Double.valueOf(5.0), model.add(2.0, 3.0));
    }
    @Test
    public void addDoubleAndDouble_isFalse(){
        assertNotSame(6.0, model.add(2.0, 3.0));
    }
    @Test
    public void addNegativeAndPositive_isTrue(){
        assertEquals(Double.valueOf(-1), model.add(2.0, -3.0));
    }
    @Test
    public void addNegativeAndPositive_isFalse(){
        assertNotSame(1.0, model.add(2.0, -3.0));
    }

    /**
     * Test subtract method
     */
    @Test
    public void subtractDoubleAndDouble_isTrue(){
        assertEquals(Double.valueOf(5), model.subtract(6.0, 1.0));
    }
    @Test
    public void subtractDoubleAndDouble_isFalse(){
        assertNotSame(5.0, model.add(6.0, 2.0));
    }
    @Test
    public void subtractNegativeAndNegative_isTrue(){
        assertEquals(Double.valueOf(-4), model.subtract(-6.0, -2.0));
    }
    @Test
    public void subtractNegativeAndNegative_isFalse(){
        assertNotSame( 4.0, model.subtract(-6.0, -2.0));
    }
    @Test
    public void subtractNegativeAndPositive_isTrue(){
        assertEquals(Double.valueOf(-12), model.subtract(-10.0, 2.0));
    }
    @Test
    public void subtractNegativeAndPositive_isFalse(){
        assertNotSame( -8.0, model.subtract(-10.0, 2.0));
    }

    /**
     * Test multiply method
     */
    @Test
    public void multiplyDoubleAndDouble_isTrue(){
        assertEquals(Double.valueOf(12), model.multiply(6.0, 2.0));
    }
    @Test
    public void multiplyDoubleAndDouble_isFalse(){
        assertNotSame(10.0, model.multiply(6.0, 2.0));
    }
    @Test
    public void multiplyDoubleAndOne_isTrue(){
        assertEquals(Double.valueOf(6), model.multiply(6.0, 1.0));
    }
    @Test
    public void multiplyDoubleAndOne_isFalse(){
        assertNotSame(5.0, model.multiply(6.0, 1.0));
    }
    @Test
    public void multiplyDoubleAndZero_isTrue(){
        assertEquals(Double.valueOf(0), model.multiply(6.0, 0.0));
    }
    @Test
    public void multiplyDoubleAndZero_isFalse(){
        assertNotSame(6.0, model.multiply(6.0, 0.0));
    }
    @Test
    public void multiplyPositiveAndNegative_isTrue(){
        assertEquals(Double.valueOf(-12), model.multiply(-6.0, 2.0));
    }
    @Test
    public void multiplyPositiveAndNegative_isFalse(){
        assertNotSame(12.0, model.multiply(-6.0, 2.0));
    }

    /**
     * Test divide method
     */
    @Test
    public void divideDoubleAndDouble_isTrue(){
        assertEquals(Double.valueOf(3), model.divide(6.0, 2.0));
    }
    @Test
    public void divideDoubleAndDouble_isFalse(){
        assertNotSame(4.0, model.divide(6.0, 2.0));
    }
    @Test
    public void dividePositiveAndNegative_isTrue(){
        assertEquals(Double.valueOf(-3), model.divide(-6.0, 2.0));
    }
    @Test
    public void dividePositiveAndNegative_isFalse(){
        assertNotSame(3.0, model.divide(-6.0, 2.0));
    }
    @Test
    public void dividePositiveAndZero_isTrue(){
        assertNull(model.divide(-6.0, 0.0));
    }
    @Test
    public void dividePositiveAndZero_isFalse(){
        assertNotSame(3.0, model.divide(-6.0, 0.0));
    }

    /**
     * Test calculate method
     */
    @Test
    public void calculateOperandIsNull_isTrue(){
        assertNull(model.calculate(null, 1.0, 2.0));
    }
    @Test
    public void calculateFirstNumberIsNull_isTrue(){
        assertNull(model.calculate("+", null, 2.0));
    }
    @Test
    public void calculateSecondNumberIsNull_isTrue(){
        assertNull(model.calculate("+", 1.0, null));
    }
    @Test
    public void calculateNotValidOperand_isTrue(){
        assertNull(model.calculate("@", 1.0, 2.0));
    }
    @Test
    public void calculateOperandIsAddition_isTrue(){
        assertEquals(Double.valueOf(3.0), model.calculate("+", 1.0, 2.0));
    }
    @Test
    public void calculateOperandIsSubtract_isTrue(){
        assertEquals(Double.valueOf(-1.0), model.calculate("-", 1.0, 2.0));
    }
    @Test
    public void calculateOperandIsMultiply_isTrue(){
        assertEquals(Double.valueOf(2.0), model.calculate("*", 1.0, 2.0));
    }
    @Test
    public void calculateOperandIsDivide_isTrue(){
        assertEquals(Double.valueOf(0.5), model.calculate("/", 1.0, 2.0));
    }


}
