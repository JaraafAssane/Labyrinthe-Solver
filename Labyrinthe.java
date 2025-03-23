import java.io.*;
import java.util.*;

public class Labyrinthe {
    private char[][] labyrinthe;
    private int startX, startY, endX, endY;

    // Constructeur pour charger un labyrinthe depuis un fichier
    public Labyrinthe(String fichier) throws IOException {
        chargerLabyrinthe(fichier);
    }

    // Constructeur pour un labyrinthe généré aléatoirement
    public Labyrinthe(char[][] labGenere) {
        this.labyrinthe = labGenere;
        trouverPoints();
    }

    // Lire un labyrinthe depuis un fichier .txt
    private void chargerLabyrinthe(String fichier) throws IOException {
        List<String> lignes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String ligne;
        while ((ligne = br.readLine()) != null) {
            lignes.add(ligne);
        }
        br.close();

        int hauteur = lignes.size();
        int largeur = lignes.get(0).length();
        labyrinthe = new char[hauteur][largeur];

        for (int i = 0; i < hauteur; i++) {
            labyrinthe[i] = lignes.get(i).toCharArray();
        }
        trouverPoints();
    }

    // Trouver les positions de départ (S) et d’arrivée (E)
    private void trouverPoints() {
        for (int i = 0; i < labyrinthe.length; i++) {
            for (int j = 0; j < labyrinthe[i].length; j++) {
                if (labyrinthe[i][j] == 'S') { startX = i; startY = j; }
                else if (labyrinthe[i][j] == 'E') { endX = i; endY = j; }
            }
        }
    }

    // Afficher le labyrinthe dans la console
    public void afficher() {
        for (char[] ligne : labyrinthe) {
            System.out.println(ligne);
        }
    }

    // Getters pour accéder aux données
    public char[][] getLabyrinthe() { return labyrinthe; }
    public int getStartX() { return startX; }
    public int getStartY() { return startY; }
    public int getEndX() { return endX; }
    public int getEndY() { return endY; }
}
