import java.util.List;
        public static void main(String[] args) {
            // Initialisation de l'outil de stockage
            DepotEtudiant depot = new DepotEtudiantCSV();

            // 1. Lire les données depuis le fichier CSV
            List<Etudiant> etudiants = depot.charger("notes.csv");

            if (etudiants.isEmpty()) {
                System.out.println("Aucune donnée chargée.");
                return;
            }

            // 2. Classer les étudiants par moyenne (Ordre décroissant)
            etudiants.sort((e1, e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()));

            // 3. Sauvegarder les résultats dans un autre fichier
            depot.sauvegarder(etudiants, "classement.csv");

            System.out.println("Fichier 'resultats.csv' généré avec succès.");
        }


