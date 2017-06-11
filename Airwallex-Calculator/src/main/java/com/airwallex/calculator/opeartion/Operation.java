package com.airwallex.calculator.opeartion;

import java.math.BigDecimal;
import java.util.Stack;

import com.airwallex.calculator.CustomException;

/**
 * Operation interface
 * 
 *
 * @version $Rev$ $Date$
 */
public abstract class Operation {

    private Stack<BigDecimal> numberStack;
    private Stack<UnDoOperation> undoStack; // Stack to keep
                                            // track of undo

    public Operation(Stack<BigDecimal> numberStack,
        Stack<UnDoOperation> undoStack) {
        this.numberStack = numberStack;
        this.undoStack = undoStack;
    }

    public Operation(Stack<BigDecimal> numberStack) {
        this.numberStack = numberStack;
    }

    public abstract void calculate() throws CustomException;

    public Stack<BigDecimal> getNumberStack() {
        return numberStack;
    }

    public void setNumberStack(Stack<BigDecimal> numberStack) {
        this.numberStack = numberStack;
    }

    public Stack<UnDoOperation> getUndoStack() {
        return undoStack;
    }

    public void setUndoStack(Stack<UnDoOperation> undoStack) {
        this.undoStack = undoStack;
    }

}
