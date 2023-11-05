package edu.project2;

public class RecursiveBacktrackerGenerator implements Generator {
    private static int height;
    private static int width;

    @Override
    public Maze generate(int height, int width) {
        this.height = height;
        this.width = width;
        Cell[][] grid = new Cell[height][width];
        boolean[][] visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                visited[i][j] = false;
            }
        }
        visited[0][0] = true;



        return new Maze(height, width, grid);

    }
    private static Maze creatingMaze(boolean[][] visited, Cell[][] grid, int x, int y){
        return new Maze(height, width, grid);
    }

    private boolean isWall(boolean[][] visited, int x, int y){
        if ( 0 <= x && x < width && 0 <= y && y <= height){
            return true;
        }
        return false;
    }
}
