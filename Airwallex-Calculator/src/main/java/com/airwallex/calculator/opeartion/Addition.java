package com.airwallex.calculator.opeartion;

import java.math.BigDecimal;
import java.util.Stack;

import com.airwallex.calculator.CustomException;

/**
 * Addition
 * 
 *
 * @version $Rev$ $Date$
 */
public class Addition extends Operation {

    private int index;

    public Addition(Stack<BigDecimal> numberStack, int index) {
        super(numberStack);
        this.index = index;
    }

    public void calculate() throws CustomException {
        if (getNumberStack().size() < 2) {
            throw new CustomException("operator + (position: " + index
                + " : insufficient parameters");
        }
        BigDecimal db1 = getNumberStack().pop();
        BigDecimal db2 = getNumberStack().pop();

        getNumberStack().push(db1.add(db2));
    }

}
