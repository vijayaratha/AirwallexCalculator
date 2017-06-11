package com.airwallex.calculator;

import java.math.BigDecimal;
import java.util.Stack;

import com.airwallex.calculator.opeartion.Addition;
import com.airwallex.calculator.opeartion.Clear;
import com.airwallex.calculator.opeartion.Division;
import com.airwallex.calculator.opeartion.Multiplication;
import com.airwallex.calculator.opeartion.OperationContext;
import com.airwallex.calculator.opeartion.Squareroot;
import com.airwallex.calculator.opeartion.Substract;
import com.airwallex.calculator.opeartion.UnDoOperation;
import com.airwallex.calculator.opeartion.Undo;

/**
 * Class defines calculator operations
 * 
 *
 * @author ratha
 */

public class Calculator {

    private Stack<BigDecimal> numberStack = new Stack<>();
    private Stack<UnDoOperation> undoStack = new Stack<>(); // Stack to keep
                                                            // track of undo
                                                            // parameters

    private int index = 0; // hold the index of the input

    /**
     * Do calculation based on the input
     * 
     * @param input
     * @throws CustomException
     */
    public void doCalculation(String input) throws CustomException {
        if (input == null || "".equals(input)) {
            throw new CustomException("Input is null");
        }

        String[] inputs = input.split("\\s");

        for (int i = 0; i < inputs.length; i++) {
            index++;
            try {
                BigDecimal number = new BigDecimal(inputs[i]);
                numberStack.push(number);
            } catch (NumberFormatException ex) {
                applyOperator(inputs[i]);
            }
        }

    }

    private void applyOperator(String operator) throws CustomException {
        int lastIndex = numberStack.lastIndexOf(numberStack.peek());

        UnDoOperation uop = new UnDoOperation();
        uop.setOperation(operator);

        if (lastIndex > 1) {
            uop.setPriorElement(numberStack.get(lastIndex - 1));
        }else{
            uop.setPriorElement(numberStack.get(lastIndex));
        }
        
        if (!operator.equals(OperatorConstants.UNDO)) {
            undoStack.push(uop);
        }
        
        if (operator.equals(OperatorConstants.PLUS)) {
            OperationContext context =
                new OperationContext(new Addition(numberStack,index));
            context.doCalculation();
        } else if (operator.equals(OperatorConstants.MINUS)) {
            OperationContext context =
                new OperationContext(new Substract(numberStack,index));
            context.doCalculation();
        } else if (operator.equals(OperatorConstants.MULTIPLICATION)) {
            OperationContext context =
                new OperationContext(new Multiplication(numberStack,index));
            context.doCalculation();
        } else if (operator.equals(OperatorConstants.DIVIDE)) {
            OperationContext context =
                new OperationContext(new Division(numberStack,index));
            context.doCalculation();
        } else if (operator.equals(OperatorConstants.CLEAR)) {
            OperationContext context =
                new OperationContext(new Clear(numberStack, undoStack));
            context.doCalculation();
        } else if (operator.equals(OperatorConstants.SQRT)) {
            OperationContext context =
                new OperationContext(new Squareroot(numberStack,index));
            context.doCalculation();
        } else if (operator.equals(OperatorConstants.UNDO)) {
            OperationContext context =
                new OperationContext(new Undo(numberStack, undoStack));
            context.doCalculation();
        } else {
            throw new CustomException("Not supported operation " + operator);
        }
    }

    
    /**
     * List the number stack for the contents
     */

    public void list() {
        System.out.print("Stack : ");
        if (!numberStack.empty()) {
            for (int i = 0; i < numberStack.size(); i++) {
                System.out.print(numberStack.elementAt(i) + " ");
            }
        }

    }
}
