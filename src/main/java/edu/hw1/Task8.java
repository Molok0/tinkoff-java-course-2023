package edu.hw1;

public class Task8 {
    private static int horse = 1;
    private static int border = 8;
    private static final int[][] moves = {
        {2, 1},
        {2, -1},
        {1, 2},
        {1, -2},
        {-2, 1},
        {-2, -1},
        {1, -2},
        {-1, -2}
    };

    public static boolean knightBoardCapture(int[][] chessBoard) {
        int posI;
        int posJ;
        for (int i = 0; i < border; i++) {
            for (int j = 0; j < border; j++) {
                if (chessBoard[i][j] == horse) {
                    for (int a = 0; a < border; a++) {
                        posI = i + moves[a][0];
                        posJ = j + moves[a][1];
                        if (posI < border && posI >= 0 && posJ < border && posJ >= 0) {
                            if (chessBoard[posI][posJ] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
