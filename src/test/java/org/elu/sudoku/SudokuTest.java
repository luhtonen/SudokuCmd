package org.elu.sudoku;

import junit.framework.TestCase;

/**
 * Created by luhtonen on 25/03/15.
 */
public class SudokuTest extends TestCase {

    private Sudoku sudoku = new Sudoku();

    public void testFileNotFound() throws Exception {
        String filename = "nonexistingfilename.txt";
        try {
            sudoku.validate(filename);
            System.out.println("TEST ERROR: validation should failed");
            assertTrue(false); // should not get here
        } catch (SudokuValidationException ex) {
            assertNotNull(ex.getCause());
            assertEquals(String.format("File [%s] was not found", filename), ex.getLocalizedMessage());
        }
    }

    public void testValidationFailure() {
        String filename = "puzzleSample.txt";
        try {
            sudoku.validate(filename);
            System.out.println("TEST ERROR: validation should failed");
            assertTrue(false); // should not get here
        } catch (SudokuValidationException ex) {
            assertNull(ex.getCause());
            assertEquals(String.format("validation failed", filename), ex.getLocalizedMessage());
        }
    }

    public void testValidation() {
        String filename = "validPuzzle.txt";
        try {
            assertTrue(sudoku.validate(filename));
        } catch (SudokuValidationException ex) {
            System.out.println("TEST ERROR: validation should pass");
            assertTrue(false);
        }
    }
}