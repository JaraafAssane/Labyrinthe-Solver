import java.util.Random;

public class LabyrintheGenerateur {
    public static char[][] genererLabyrinthe(int largeur, int hauteur) {
        char[][] lab = new char[hauteur][largeur];
        Random rand = new Random();

        // Générer un labyrinthe vide
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                lab[i][j] = (rand.nextDouble() > 0.7) ? '#' : '='; // 70% chemin, 30% murs
            }
        }

        // Définir un point de départ et une sortie
        lab[1][1] = 'S';
        lab[hauteur - 2][largeur - 2] = 'E';

        return lab;
    }
}
