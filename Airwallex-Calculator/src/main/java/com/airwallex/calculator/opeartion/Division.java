package com.airwallex.calculator.opeartion;

import java.math.BigDecimal;
import java.util.Stack;

import com.airwallex.calculator.CustomException;

public class Division extends Operation {

    private int index;

    public Division(Stack<BigDecimal> numberStack, int index) {
        super(numberStack);
        this.index = index;
    }

    @Override
    public void calculate() throws CustomException {
        if (getNumberStack().size() < 2) {
            throw new CustomException("operator / (position: " + index
                + " : insufficient parameters");
        }
        BigDecimal firstArg = getNumberStack().pop();
        BigDecimal secondArg = getNumberStack().pop();
        getNumberStack().push(secondArg.divide(firstArg));
    }

}
