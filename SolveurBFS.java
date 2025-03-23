import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

public class SolveurBFS {
    private Labyrinthe lab;
    private boolean[][] visite;
    private char[][] solution;
    private long executionTime;
    private int noeudsExplores = 0;

    public SolveurBFS(Labyrinthe lab) {
        this.lab = lab;
        int rows = lab.getLabyrinthe().length;
        int cols = lab.getLabyrinthe()[0].length;
        this.visite = new boolean[rows][cols];
        this.solution = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(lab.getLabyrinthe()[i], 0, solution[i], 0, cols);
        }
    }

    public boolean resoudre() {
        long startTime = System.nanoTime();
        boolean solved = bfs();
        executionTime = System.nanoTime() - startTime;
        return solved;
    }

    private boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        Map<String, int[]> parents = new HashMap<>();
        queue.add(new int[]{lab.getStartX(), lab.getStartY()});
        visite[lab.getStartX()][lab.getStartY()] = true;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[] endPos = null;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            if (x == lab.getEndX() && y == lab.getEndY()) {
                endPos = pos;
                break;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < lab.getLabyrinthe().length && newY < lab.getLabyrinthe()[0].length &&
                    lab.getLabyrinthe()[newX][newY] != '#' && !visite[newX][newY]) {
                    
                    queue.add(new int[]{newX, newY});
                    visite[newX][newY] = true;
                    solution[newX][newY] = '.';
                    parents.put(newX + "," + newY, pos);
                    noeudsExplores++;
                }
            }
        }

        if (endPos != null) {
            int[] current = endPos;
            while (current != null) {
                solution[current[0]][current[1]] = '+';
                current = parents.get(current[0] + "," + current[1]);
            }
            return true;
        }

        return false;
    }

    public char[][] getSolution() { return solution; }
    public long getExecutionTime() { return executionTime; }
    public int getNoeudsExplores() { return noeudsExplores; }
}


