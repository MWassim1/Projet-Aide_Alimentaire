public class Accueil{
    private static final Accueil INSTANCE=new Accueil();
    
    private Accueil(){
        System.out.println("Instanciation du Singleton\n"); //dès creation de l'unique singleton, le message s'affiche 
    }

    public static Accueil getInstance(){
        return INSTANCE;
    }

    public String toString(){
        return "Bonjour !\n";
    }

}