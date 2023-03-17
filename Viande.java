public class Viande extends Aliment {
	
	///// CONSTRUCTEURS \\\\\
	public Viande (String nom,int stock,int d ){
		super(nom,15,stock,d);
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
