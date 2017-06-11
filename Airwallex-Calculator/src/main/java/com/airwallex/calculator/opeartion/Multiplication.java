package com.airwallex.calculator.opeartion;

import java.math.BigDecimal;
import java.util.Stack;

import com.airwallex.calculator.CustomException;

public class Multiplication extends Operation {

    private int index;

    public Multiplication(Stack<BigDecimal> numberStack, int index) {
        super(numberStack);
        this.index = index;
    }

    @Override
    public void calculate() throws CustomException {
        if (getNumberStack().size() < 2) {
            throw new CustomException("operator  * (position: " + index
                + " : insufficient parameters");
        }
        BigDecimal db1 = getNumberStack().pop();
        BigDecimal db2 = getNumberStack().pop();
        getNumberStack().push(db1.multiply(db2));

    }

}
