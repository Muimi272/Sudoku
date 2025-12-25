package sudoku;

import java.util.*;

public class Sudoku {

    private Random random;
    private int[][] sudoku;
    private int[][] answer;

    public Sudoku() {
        random = new Random();
    }

    public int[][] getSudoku() {
        return sudoku;
    }

    public void createSudoku(String difficulty) {
        int[][] fullSudoku = generateFullSudoku();

        answer = deepCopy2DArray(fullSudoku);
        digHoles(fullSudoku, difficulty);
        sudoku = fullSudoku;
    }

    private int[][] deepCopy2DArray(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }

    private int[][] generateFullSudoku() {
        int[][] sudoku = new int[9][9];
        backtrackFill(sudoku, 0, 0);
        return sudoku;
    }

    private boolean backtrackFill(int[][] sudoku, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return backtrackFill(sudoku, row + 1, 0);
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        for (int num : numbers) {
            if (isValid(sudoku, row, col, num)) {
                sudoku[row][col] = num;
                if (backtrackFill(sudoku, row, col + 1)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int[][] sudoku, int row, int col, int num) {
        for (int c = 0; c < 9; c++) {
            if (sudoku[row][c] == num) {
                return false;
            }
        }
        for (int r = 0; r < 9; r++) {
            if (sudoku[r][col] == num) {
                return false;
            }
        }
        int blockRow = (row / 3) * 3;
        int blockCol = (col / 3) * 3;
        for (int r = blockRow; r < blockRow + 3; r++) {
            for (int c = blockCol; c < blockCol + 3; c++) {
                if (sudoku[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private void digHoles(int[][] sudoku, String difficulty) {
        int holeCount;
        switch (difficulty.toLowerCase()) {
            case "easy":
                holeCount = 20;
                break;
            case "medium":
                holeCount = 35;
                break;
            case "hard":
                holeCount = 45;
                break;
            default:
                holeCount = 20;
                break;
        }

        int count = 0;
        while (count < holeCount) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (sudoku[row][col] != 0) {
                sudoku[row][col] = 0;
                count++;
            }
        }
    }

    private static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
                if ((j + 1) % 3 == 0 && j != 8) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i != 8) {
                System.out.println("---------------------");
            }
        }
    }

    public boolean checkAnswer(int[][] solution) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (solution[i][j] != answer[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}