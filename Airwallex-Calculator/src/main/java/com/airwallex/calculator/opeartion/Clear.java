package com.airwallex.calculator.opeartion;

import java.math.BigDecimal;
import java.util.Stack;

import com.airwallex.calculator.CustomException;

/**
 * Clear
 * 
 *
 * @version $Rev$ $Date$
 */
public class Clear extends Operation {

    
    public Clear(Stack<BigDecimal> numberStack,
        Stack<UnDoOperation> undoStack) {
        super(numberStack, undoStack);
    }

    @Override
    public void calculate() throws CustomException {
        getNumberStack().clear();
        getUndoStack().clear();

    }
}