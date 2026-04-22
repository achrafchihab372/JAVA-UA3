
    import java.util.List;

    /**
     * Interface de stockage (Abstraction).
     * DIP : Permet de ne pas dépendre du format de fichier.
     */
    public interface DepotEtudiant {
        List<Etudiant> charger(String source);
        void sauvegarder(List<Etudiant> etudiants, String destination);
    }

