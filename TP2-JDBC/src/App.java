public class App {
    public static void main(String[] args) throws Exception {
        Joueur joueur1 = new Joueur("ABALO", "Kossi", "ABKO123", 12);
        Joueur joueur2 = new Joueur("DOSSOU", "Germaine", "DOGE456", 5);

        JoueurJDBC jjdc = new JoueurJDBC();

        jjdc.add(joueur1);
        jjdc.add(joueur2);

        jjdc.findAll();
    }
}
