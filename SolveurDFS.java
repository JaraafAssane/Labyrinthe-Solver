import java.util.ArrayList;
import java.util.List;

public class SolveurDFS {
    private Labyrinthe lab;
    private boolean[][] visite;
    private char[][] solution;
    private List<int[]> cheminOptimal = new ArrayList<>();
    private long executionTime;
    private int noeudsExplores = 0;

    public SolveurDFS(Labyrinthe lab) {
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
        boolean solved = dfs(lab.getStartX(), lab.getStartY(), new ArrayList<>());
        executionTime = System.nanoTime() - startTime;
        if (solved) {
            for (int[] pos : cheminOptimal) {
                solution[pos[0]][pos[1]] = '+';
            }
        }
        return solved;
    }

    private boolean dfs(int x, int y, List<int[]> chemin) {
        if (x < 0 || y < 0 || x >= lab.getLabyrinthe().length || y >= lab.getLabyrinthe()[0].length || 
            lab.getLabyrinthe()[x][y] == '#' || visite[x][y]) {
            return false;
        }

        visite[x][y] = true;
        solution[x][y] = '.'; // Marquer les chemins explorés
        chemin.add(new int[]{x, y});
        noeudsExplores++;

        if (x == lab.getEndX() && y == lab.getEndY()) {
            cheminOptimal = new ArrayList<>(chemin);
            return true;
        }

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int[] dir : directions) {
            if (dfs(x + dir[0], y + dir[1], chemin)) {
                return true;
            }
        }

        chemin.remove(chemin.size() - 1);
        return false;
    }

    public char[][] getSolution() { return solution; }
    public long getExecutionTime() { return executionTime; }
    public int getNoeudsExplores() { return noeudsExplores; }
}
