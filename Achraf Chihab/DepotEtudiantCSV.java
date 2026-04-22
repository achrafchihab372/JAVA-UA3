import java.io.*;
import java.util.*;

/**
 * Implémentation technique pour le format CSV.
 */
public class DepotEtudiantCSV implements DepotEtudiant {

    @Override
    public List<Etudiant> charger(String chemin) {
        List<Etudiant> liste = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            br.readLine(); // Ignore l'en-tête (Nom,ID,Notes...)

            while ((ligne = br.readLine()) != null) {
                String[] colonnes = ligne.split(",");
                String nom = colonnes[0];
                String id = colonnes[1];

                List<Double> notes = new ArrayList<>();
                for (int i = 2; i < colonnes.length; i++) {
                    notes.add(Double.parseDouble(colonnes[i].trim()));
                }
                liste.add(new Etudiant(nom, id, notes));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erreur de lecture : " + e.getMessage());
        }
        return liste;
    }

    @Override
    public void sauvegarder(List<Etudiant> etudiants, String destination) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(destination))) {
            // En-tête du fichier de sortie
            pw.println("Rang,Nom,ID,Moyenne");

            for (int i = 0; i < etudiants.size(); i++) {
                Etudiant e = etudiants.get(i);
                pw.printf(Locale.US,"%d,%s,%s,%.2f%n", (i + 1), e.getNom(), e.getId(), e.getMoyenne());
            }
        } catch (IOException e) {
            System.err.println("Erreur d'écriture : " + e.getMessage());
        }
    }
}
