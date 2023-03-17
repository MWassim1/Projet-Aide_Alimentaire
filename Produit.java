public abstract class Produit {
	protected String nom ;
	public  final int   points ;
	protected int stock ; 

	///// CONSTRUCTEURS \\\\\
	public Produit(String nom, int point,int stock){
			this.nom = nom ;
			this.points = point;
			this.stock = stock  ;
	} 

	///// METHODES  DIVERSES \\\\\

	public String toString(){
		return nom+": "+points+" points\nStock : "+stock;
	}

	public abstract void perime();
	
	///// ACCESSEUR \\\\\
	public abstract int getStock();
	public abstract void setStock(int s);
	public abstract String getNom();

}


