public class Seule extends Beneficiaire {
	private final  int _nb_pers = 1  ; 

	///// CONSTRUCTEURS \\\\\
	public Seule(double h , int p , String nom ){	
		super(h,p,nom,11.0);
	}
	///// METHODES DIVERSES \\\\\

	public void ajouter_points(){
		this.setPoints(this.getPoints()+150);
	}
	public String toString(){
		return "Seul(e) -> " +super.toString();
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

