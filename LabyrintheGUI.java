import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabyrintheGUI extends JPanel {
    private char[][] labyrinthe;
    private JFrame frame;

    public LabyrintheGUI(char[][] labyrinthe) {
        this.labyrinthe = labyrinthe;
        setPreferredSize(new Dimension(labyrinthe[0].length * 40, labyrinthe.length * 40)); // Augmenter la taille
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = 40; // Augmenter la taille des cases

        for (int i = 0; i < labyrinthe.length; i++) {
            for (int j = 0; j < labyrinthe[i].length; j++) {
                switch (labyrinthe[i][j]) {
                    case '#': g.setColor(Color.BLACK); break;  // Mur
                    case '=': g.setColor(Color.WHITE); break;  // Chemin
                    case 'S': g.setColor(Color.BLUE); break;   // Départ
                    case 'E': g.setColor(Color.RED); break;    // Sortie
                    case '+': g.setColor(Color.YELLOW); break; // Solution trouvée
                    default: g.setColor(Color.GRAY); break;
                }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

   
    public static void afficherLabyrinthe(char[][] lab, SolveurDFS dfs, SolveurBFS bfs) {
        JFrame frame = new JFrame("Labyrinthe Interactif");
        LabyrintheGUI panel = new LabyrintheGUI(lab);
        
        JPanel buttonPanel = new JPanel();
        JButton btnDFS = new JButton("Résoudre avec DFS");
        JButton btnBFS = new JButton("Résoudre avec BFS");
        JLabel lblPerformance = new JLabel("Performances : ");
    
        btnDFS.addActionListener(e -> {
            dfs.resoudre();
            panel.labyrinthe = dfs.getSolution();
            panel.repaint();
            lblPerformance.setText("DFS : " + dfs.getExecutionTime() / 1_000_000.0 + " ms");
        });
    
        btnBFS.addActionListener(e -> {
            bfs.resoudre();
            panel.labyrinthe = bfs.getSolution();
            panel.repaint();
            lblPerformance.setText("BFS : " + bfs.getExecutionTime() / 1_000_000.0 + " ms");
        });
    
        buttonPanel.add(btnDFS);
        buttonPanel.add(btnBFS);
        buttonPanel.add(lblPerformance);
    
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
}
