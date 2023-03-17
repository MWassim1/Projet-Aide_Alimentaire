public abstract  class Aliment extends Produit {
	protected int duree; 
	
	///// CONSTRUCTEURS \\\\\ 
	public Aliment(String nom, int point,int stock,int d ){
		super(nom,point,stock);
		duree = d ; 
	}
	
	///// METHODES DIVERSES \\\\\
	public void perime(){
		if (duree==0){
			System.out.println(nom+" est perime ") ;

		}else{
			duree--; 
			System.out.println("Duree de validite du produit "+nom+" : "+duree);
		}
	}

	public String toString(){
		return super.toString()+"\nDuree avant peremption : "+duree+"\n";

	}
		
}			
	
