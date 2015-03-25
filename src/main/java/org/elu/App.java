package org.elu;

import org.elu.sudoku.Sudoku;
import org.elu.sudoku.SudokuValidationException;

/**
 * Main Class to run Sudoku validation
 * Expect to receive one argument: solution file name
 *
 */
public class App 
{
    public static void main( String[] args ) {
        if (args.length < 1) {
            System.out.println("ERROR: must provide file name with Sudoku solution");
        } else {
            Sudoku sudoku = new Sudoku();
            try {
                if (sudoku.validate(args[0])) {
                    System.out.println("VALID");
                } else {
                    System.out.println("INVALID");
                }
            } catch (SudokuValidationException e) {
                System.out.println("INVALID: " + e.getLocalizedMessage());
            }
        }
    }
}
