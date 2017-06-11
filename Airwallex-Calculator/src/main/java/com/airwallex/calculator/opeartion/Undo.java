package com.airwallex.calculator.opeartion;

import java.math.BigDecimal;
import java.util.Stack;

import com.airwallex.calculator.CustomException;

/**
 * Undo operation
 * 
 *
 * @version $Rev$ $Date$
 */
public class Undo extends Operation {

    public Undo(Stack<BigDecimal> numberStack, Stack<UnDoOperation> undoStack) {
        super(numberStack, undoStack);
    }

    @Override
    public void calculate() throws CustomException {
        if (getUndoStack().isEmpty()) {
            getNumberStack().pop();

        } else {
            UnDoOperation lastOperation = getUndoStack().pop();

            UnDoOperation udop = new UnDoOperation();

            udop.setOperation(lastOperation.getOperation());
            udop.setTopElement(getNumberStack().pop());
            udop.setPriorElement(lastOperation.getPriorElement());
            BigDecimal val = udop.undo();

            getNumberStack().push(val);
            if (lastOperation.getPriorElement() != null) {
                getNumberStack().push(lastOperation.getPriorElement());
            }
           
        }

    }

}
