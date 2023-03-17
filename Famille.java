public class Famille extends Beneficiaire implements Avec_Bebe {
	private int nb_adultes ;
	private int nb_enfants ;
	private int nb_pers ;
	///// CONSTRUCTEURS \\\\\
	public Famille(double h , int p , String nom ,int nb_adultes, int nb_enfants) {
		super(h,p,nom,18.15);
		this.nb_adultes = nb_adultes ; 
		this.nb_enfants = nb_enfants ; 
		nb_pers = nb_adultes+nb_enfants;
	}

	public Famille (Famille f){
			this(f.getHeure(),f.getPoints(),f.getNom(),f.nb_adultes,f.nb_enfants);
	}
	///// METHODES DIVERSES \\\\\
	public void ajouter_points(){
		this.setPoints(this.getPoints()+nb_adultes*150+nb_enfants*50);
	}
	public void ajouter_bebe(int nb_bebe){
		this.setPoints(this.getPoints()+100*nb_bebe);
		this.nb_pers += nb_bebe; 
		//System.out.println("Il y a "+nb_bebe+" bebe(s) dans la famille "+getNom()+"\n");
	}
	public String toString(){
		return "Famille ("+nb_pers+" membres) -> "+super.toString();
	}
	///// ACCESSEURS \\\\\
	public  void setPoints(int p){
		points=p;
	}
	public  int getPoints(){
		return points;
	}
	public double getHeure(){
		return horaire ; 
	}
	public String getNom(){
		return nom ;
	}
	public void setHeure(double h){
		horaire = h ;
	}
	
}
