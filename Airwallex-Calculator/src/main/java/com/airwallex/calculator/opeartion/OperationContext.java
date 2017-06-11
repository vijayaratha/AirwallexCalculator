package com.airwallex.calculator.opeartion;

import com.airwallex.calculator.CustomException;

/**
 * Operation Context
 * 
 *
 * @version $Rev$ $Date$
 */
public class OperationContext {
    private Operation operation;

    public OperationContext(Operation operation){
       this.operation = operation;
    }

    public void doCalculation() throws CustomException{
     operation.calculate();
    }
}
