public  class Produit_bebe extends Produit {
	
	///// CONSTRUCTEURS \\\\\
	public Produit_bebe (String nom,int stock){
		super(nom,20,stock);
	}
	///// METHODES DIVERSES \\\\\
	public String toString(){
			return super.nom+": "+points+" points\nStock : "+super.stock+"\n";
	}

	public void perime(){
		System.out.println("Pas de duree de validite pour le produit : "+getNom());
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
