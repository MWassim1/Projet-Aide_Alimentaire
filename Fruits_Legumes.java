public class Fruits_Legumes extends Aliment {
	
	///// CONSTRUCTEURS \\\\\
	public Fruits_Legumes (String nom,int stock,int d ){
		super(nom,5,stock,d);
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
