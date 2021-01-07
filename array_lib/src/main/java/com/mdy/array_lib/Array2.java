package com.mdy.array_lib;

/**
 * User: maodayu
 * Date: 2020/7/30
 * Time: 下午6:09
 */
public class Array2 {

    public static void main(String[] args) {

    }

    public static String tictactoe(String[] board) {
        int length = board.length;
        int line, vertical;
        int left = 0;
        int right = 0;
        boolean flag = false;

        for (int i = 0; i < board.length; i++) {
            line = 0;
            vertical = 0;
            left = left + board[i].charAt(i);
            right = right + board[i].charAt(length - i - 1);
            for (int j = 0; j < length; j++) {
                line = line + board[i].charAt(j);
                vertical = vertical + board[j].charAt(i);

                if (board[i].charAt(j) == ' ') {
                    flag = true;
                }

                if (line == 'O' * length || vertical == 'O' * length) return "O";
                if (line == 'X' * length || vertical == 'X' * length) return "X";
            }
        }

        if (left == 'O' * length || right == 'O' * length) return "O";
        if (left == 'X' * length || right == 'X' * length) return "X";

        return flag ? "Pending" : "Draw";
    }

}
