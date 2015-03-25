package org.elu.sudoku;

/**
 * Created by luhtonen on 25/03/15.
 */
public class SudokuValidationException extends Exception {
    public SudokuValidationException(String message) {
        super(message);
    }
    public SudokuValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
