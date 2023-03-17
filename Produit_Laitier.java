public class Produit_Laitier extends Aliment {

	 /////CONSTRUCTEURS \\\\\
	public Produit_Laitier (String nom,int stock,int d ){
		super(nom,8,stock,d);
	}
	///// METHODES DIVERSES \\\\\
	
	public String toString(){
		return super.toString();
	}
	///// ACCESSEURS \\\\\
	public int getPoints(){
		return points;
	}
	public  int getStock(){
		return super.stock;
	}

	public void setStock(int s ){
		super.stock=s; 
	}

	public String getNom(){
		return super.nom;
	}
}
