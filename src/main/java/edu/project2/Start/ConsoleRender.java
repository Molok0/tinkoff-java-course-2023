package edu.project2.Start;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.Renderer;
import java.util.List;

public class ConsoleRender implements Renderer {
    @Override
    public String render(Maze maze) {
        Cell[][] grid = maze.getGrid();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                stringBuffer.append(grid[i][j].type() == Cell.Type.PASSAGE ? " " : "#");
                stringBuffer.append(" ");
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        return null;
    }
}
