import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println(" Bienvenue dans le Labyrinthe !");
            System.out.println("1- Jouer avec un labyrinthe aléatoire");
            System.out.println("2- Jouer avec un labyrinthe depuis un fichier");
            System.out.println("3- Quitter");
            System.out.print("          Faites votre choix :        ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne

            Labyrinthe lab;
            if (choix == 1) {
                // Générer un labyrinthe aléatoire
                char[][] labGenere = LabyrintheGenerateur.genererLabyrinthe(15, 10);
                lab = new Labyrinthe(labGenere);
            } else if (choix == 2) {
                // Charger un labyrinthe depuis un fichier
                System.out.print("Entrez le nom du fichier (ex: labyrinthe.txt) : ");
                String fichier = scanner.nextLine();
                lab = new Labyrinthe(fichier);
            } else {
                System.out.println("Au revoir\n Merci d'avoir joué !");
                break;
            }

            // Instanciation des solveurs
            SolveurDFS dfs = new SolveurDFS(lab);
            SolveurBFS bfs = new SolveurBFS(lab);

            // Lancer l'interface graphique avec le labyrinthe
            LabyrintheGUI.afficherLabyrinthe(lab.getLabyrinthe(), dfs, bfs);

            // Demander si on veut rejouer
            System.out.print("\nVoulez-vous jouer à nouveau ? (oui/non) : ");
            String reponse = scanner.nextLine();
            if (!reponse.equalsIgnoreCase("oui")) {
                continuer = false;
                System.out.println("👋 Au revoir et à bientôt !");
            }
        }

        scanner.close();
    }
}
