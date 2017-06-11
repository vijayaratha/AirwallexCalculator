package com.airwallex.calculator.opeartion;

import java.math.BigDecimal;
import java.util.Stack;

import com.airwallex.calculator.CustomException;

/**
 * Substarct
 * 
 * 
 * 
 * 
 *
 * @version $Rev$ $Date$
 */
public class Substract extends Operation {

    private int index;

    public Substract(Stack<BigDecimal> numberStack, int index) {
        super(numberStack);
        this.index = index;
    }

    @Override
    public void calculate() throws CustomException {
        if (getNumberStack().size() < 2) {
            throw new CustomException("operator - (position: " + index
                + " : insufficient parameters");
        }
        BigDecimal firstArg = getNumberStack().pop();
        BigDecimal secondArg = getNumberStack().pop();
        getNumberStack().push(secondArg.subtract(firstArg));
    }

}
