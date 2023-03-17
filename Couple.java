public class Couple extends Beneficiaire {
	private final  int nb_pers = 2  ; 
	
	///// CONSTRUCTEURS \\\\\
	public Couple(double h , int p , String nom ){	
		super(h,p,nom,16.30);
	
	}
	///// METHODES DIVERSES \\\\\
	public void ajouter_points(){
		this.setPoints(this.getPoints()+150*nb_pers);
	}
	public String toString(){
		return "Couple -> "+super.toString();
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
