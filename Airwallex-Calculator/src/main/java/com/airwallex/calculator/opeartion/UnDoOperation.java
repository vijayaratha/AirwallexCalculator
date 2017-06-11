package com.airwallex.calculator.opeartion;

import java.math.BigDecimal;

import com.airwallex.calculator.OperatorConstants;

/**
 * process UNDO operation 
 * 
 * @author ratha
 * @version $Rev$ $Date$
 */
public class UnDoOperation {

    private String operation;
    private BigDecimal topElement;
    private BigDecimal priorElement;

 
    public BigDecimal undo() {
        
        BigDecimal val = null;
        
        if (operation.equals(OperatorConstants.PLUS)) {
           val= undoAdd();
        }
        if (operation.equals(OperatorConstants.MINUS)) {
            val=undoSubstract();
        }
        if (operation.equals(OperatorConstants.MULTIPLICATION)) {
           val= undoMultiply();
        }
        if (operation.equals(OperatorConstants.DIVIDE)) {
           val= undoDivide();
        }
        if (operation.equals(OperatorConstants.SQRT)) {
            val= undoSqrt();
         }
        return val;
    }

    private BigDecimal undoAdd() {
        BigDecimal val = topElement.subtract(priorElement);
        return val; 
    }

    private BigDecimal undoSubstract() {
        BigDecimal val = topElement.add(priorElement);
      
        return val;
    }

    private BigDecimal undoMultiply() {
        BigDecimal val = topElement.divide(priorElement);
        return val;
    }

    private BigDecimal undoDivide() {
        BigDecimal val = topElement.multiply(priorElement);
        return val;
    }

    private BigDecimal undoSqrt() {
        BigDecimal val = topElement;
      
        return val.pow(2);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getTopElement() {
        return topElement;
    }

    public void setTopElement(BigDecimal topElement) {
        this.topElement = topElement;
    }

    public BigDecimal getPriorElement() {
        return priorElement;
    }

    public void setPriorElement(BigDecimal priorElement) {
        this.priorElement = priorElement;
    }

}
