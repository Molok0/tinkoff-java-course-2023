package edu.hw1;

public class Task8 {
    private static int horse = 1;

    public static boolean knightBoardCapture(int[][] chessBoard) {
        int[][] moves = {
            {2, 1},
            {2, -1},
            {1, 2},
            {1, -2},
            {-2, 1},
            {-2, -1},
            {1, -2},
            {-1, -2}
        };
        int posI;
        int posJ;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] == horse) {
                    for (int a = 0; a < 8; a++) {
                        posI = i + moves[a][0];
                        posJ = j + moves[a][1];
                        if (posI < 8 && posI >= 0 && posJ < 8 && posJ >= 0) {
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
