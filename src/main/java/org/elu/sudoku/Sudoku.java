package org.elu.sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by luhtonen on 25/03/15.
 */
public class Sudoku {

    public boolean validate(String filename) throws SudokuValidationException {
        return validateGrid(readPuzzleFile(filename));
    }

    private int[][] readPuzzleFile(String filename) throws SudokuValidationException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            int[][] grid = new int[9][9];
            String line;
            int rowCount = 0;
            while((line = br.readLine()) != null) {
                String[] row = line.split(",");
                for (int i = 0; i < row.length; i++) {
                    grid[rowCount][i] = new Integer(row[i]);
                }
                rowCount++;
            }
            return grid;
        } catch (FileNotFoundException e) {
            throw new SudokuValidationException(String.format("File [%s] was not found", filename), e);
        } catch (IOException e) {
            throw new SudokuValidationException(String.format("I/O exception [%s] caught while reading file [%s]", e.getLocalizedMessage(), filename), e);
        }
    }

    private boolean validateGrid(int[][] grid) throws SudokuValidationException {
        for (int i = 0; i < 9; i++) {

            int[] row = new int[9];
            int[] square = new int[9];
            int[] column = grid[i].clone();

            for (int j = 0; j < 9; j ++) {
                row[j] = grid[j][i];
                square[j] = grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if (!(doValidation(column) && doValidation(row) && doValidation(square)))
                return false;
        }
        return true;
    }

    private boolean doValidation(int[] check) throws SudokuValidationException {
        int i = 0;
        Arrays.sort(check);
        for (int number : check) {
            if (number != ++i) {
                throw new SudokuValidationException("validation failed", null);
            }
        }
        return true;
    }
}
