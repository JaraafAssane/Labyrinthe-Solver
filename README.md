Résolution de Labyrinthes en Java avec DFS et BFS  

Implémentation en Java d’un solveur de labyrinthe utilisant DFS (Depth-First Search) et BFS (Breadth-First Search).  
Comparez ces deux algorithmes pour analyser leurs performances et leur efficacité dans la recherche de chemin optimal.  

---

Fonctionnalités  
 Génération et affichage d’un labyrinthe (aléatoire ou chargé depuis un fichier)  
 Résolution avec DFS et BFS
 Interface graphique (Swing) pour visualiser la solution 
 Affichage des performances (temps d’exécution et nœuds explorés)

---

 Structure du projet  

 Labyrinthe-Solver
├── 📁 src
│   ├── Labyrinthe.java         # Gestion du labyrinthe
│   ├── LabyrintheGUI.java      # Interface graphique en Swing
│   ├── SolveurDFS.java         # Algorithme DFS
│   ├── SolveurBFS.java         # Algorithme BFS
│   ├── LabyrintheGenerateur.java # Génération dynamique de labyrinthes
│   ├── Main.java               # Programme principal
├── 📁 ressources
│   ├── labyrinthe.txt          # Exemple de labyrinthe en format texte
├── README.md                   # Documentation du projet
