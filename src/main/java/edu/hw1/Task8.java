package edu.hw1;

public final class Task8 {
    private Task8() {
    }

    private static final int HORSE = 1;
    private static final int BORDER = 8;
    private static final int[][] MOVES = {
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
        for (int i = 0; i < BORDER; i++) {
            for (int j = 0; j < BORDER; j++) {
                if (chessBoard[i][j] == HORSE) {
                    for (int a = 0; a < BORDER; a++) {
                        posI = i + MOVES[a][0];
                        posJ = j + MOVES[a][1];
                        if (posI < BORDER && posI >= 0 && posJ < BORDER && posJ >= 0) {
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
