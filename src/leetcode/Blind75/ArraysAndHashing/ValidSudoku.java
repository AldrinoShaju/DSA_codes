package leetcode.Blind75.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        boolean status = isSudokuValid(new char[][]{{'5','3','.','.','7','.','.','.','.'}
                                                    ,{'6','.','.','1','9','5','.','.','.'}
                                                    ,{'.','9','8','.','.','.','.','6','.'}
                                                    ,{'8','.','.','.','6','.','.','.','3'}
                                                    ,{'4','.','.','8','.','3','.','.','1'}
                                                    ,{'7','.','.','.','2','.','.','.','6'}
                                                    ,{'.','6','.','.','.','.','2','8','.'}
                                                    ,{'.','.','.','4','1','9','.','.','5'}
                                                    ,{'.','.','.','.','8','.','.','7','9'}});
        System.out.println(status);
    }

    public static boolean isSudokuValid(char[][] board){
        Set<String> record = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!record.add("row"+i+board[i][j])
                            || !record.add("col"+j+board[i][j])
                            || !record.add("box"+(i/3)+(j/3)+board[i][j])){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
