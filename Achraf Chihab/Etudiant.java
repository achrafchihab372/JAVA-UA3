import java.util.List;
/**
 * Modèle de données : représente un étudiant.
 * SRP : Responsable uniquement de l'entité Etudiant.
 */
public class Etudiant {
    private final String nom;
    private final String id;
    private final List<Double> notes;
    private final double moyenne;

    public Etudiant(String nom, String id, List<Double> notes) {
        this.nom = nom;
        this.id = id;
        this.notes = notes;
        this.moyenne = calculerMoyenneSimple();
    }

    /**
     * Calcul simple : Somme des notes divisée par leur nombre.
     */
    private double calculerMoyenneSimple() {
        if (notes == null || notes.isEmpty()) return 0.0;
        double somme = 0;
        for (double n : notes) {
            somme += n;
        }
        return somme / notes.size();
    }

    public String getNom() { return nom; }
    public String getId() { return id; }
    public double getMoyenne() { return moyenne; }
}
