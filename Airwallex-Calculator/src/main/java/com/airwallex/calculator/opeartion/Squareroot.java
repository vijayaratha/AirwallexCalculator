package com.airwallex.calculator.opeartion;

import java.math.BigDecimal;
import java.util.Stack;

import com.airwallex.calculator.CustomException;

/**
 * Square root
 * 
 *
 * @version $Rev$ $Date$
 */
public class Squareroot extends Operation {

    private int index;

    public Squareroot(Stack<BigDecimal> numberStack, int index) {
        super(numberStack);
        this.index = index;
    }

    @Override
    public void calculate() throws CustomException {
        if (getNumberStack().size() < 1) {
            throw new CustomException("operator sqrt (position: " + index
                + " : insufficient parameters");
        }
        BigDecimal bd1 = getNumberStack().pop();
        BigDecimal bd2 =
            BigDecimal.valueOf(java.lang.Math.sqrt(bd1.doubleValue()));
        getNumberStack().push(bd2);
    }

}
