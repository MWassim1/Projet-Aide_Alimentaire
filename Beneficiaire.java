public abstract class Beneficiaire {
	protected double horaire ; // L'heure à laquelle nos beneficiaires doivent passer pour pouvoir recuperer les produits 
	protected int points ;
	protected String nom ;
	private double horaire_de_passage ;  // L'heure à laquelle nos beneficiaires  passent
	private double h_p ; 
	private double h_m ; 

	///// CONSTRUCTEURS \\\\\
	public Beneficiaire (double h , int p , String nom,double horaire_p) {
		horaire = h ; 
		points = p  ; 
		this.nom = nom ; 
		horaire_de_passage = horaire_p ; 
	}
	///// METHODES DIVERSES \\\\\
	public boolean A_l_heure(){
		h_p = horaire; h_m = horaire;// defini comme un intervalle [h_m,horaire,h_p]
		if(setInteHoraireP(30) <= horaire_de_passage-0.41){
				horaire_de_passage = ((int)(Math.random()*(19)))+(((double)(Math.random()*60))/100);
				horaire_de_passage = (double) Math.round(horaire_de_passage* 100) / 100;
				if(( this instanceof Famille) || (this instanceof Couple)){
					System.out.println(nom+" sont arrives en retard . Impossible de recuperer le produit . \nHoraire de passage passage attribue : "+horaire_de_passage+"\n");
				}
				else {
					System.out.println(nom+" est arrive(e) en retard . Impossible de recuperer le produit . \nHoraire de passage passage attribue : "+horaire_de_passage+"\n");
				}
				return false ;
		}
		if (horaire_de_passage < setInteHoraireM(30) ){
				horaire_de_passage=(double) Math.round(setInteHorairePassageAvance()*100)/100;
					if(( this instanceof Famille) || (this instanceof Couple)){
					System.out.println(nom+" sont arrives en avance . Impossible de recuperer le produit .\nHoraire de passage passage attribue : "+horaire_de_passage+"\n");
				}
				else {
					System.out.println(nom+" est arrive(e) en avance . Impossible de recuperer le produit .\nHoraire de passage passage attribue : "+horaire_de_passage+"\n");
				}
				return false ; 
		}
		else{
			System.out.println(nom+" -> horaire respectee \n" );
		}
		return true ;
	}

	public double setInteHoraireP(int h){
		for (int i = 0 ; i < h ; i++){
			if (h_p-(int)h_p  >= 0.60){   
				h_p=Math.round(h_p);            // Permet de garder le format de 60 min 

			}
			if (h_p >= 24 ){
				h_p=(0+(h_p-(int)h_p));         // Permet de garder le format 24H  ( evite de se retrouver avec une heure = 25.17 )
			}
			else {
				if (h_p-(int)h_p  >= 0.50 ) {                            
						h_p=Math.round(h_p)-1+((h_p-(int)h_p)+0.01);     // Math.round arrondi au superieur si la partie décimale du double est supérieure ou égale à 0.50 . ---> Donc il faut  adapter le code 
				}
				else{
					h_p= Math.round(h_p)+((h_p-(int)h_p)+0.01);         // Incrementation classique <=>  Incremente de 0.01 --> 1 min 
				}
			}
		}
		return h_p;
	}
	public double setInteHoraireM(int h){
		for (int i = 0 ; i < h ; i++){
			if (h_m-(int)h_m  == 0){   
				h_m=((Math.round(h_m)-1)+0.59);      // Permet de garder le format de 60 min

			}
			if (Math.round(h_m) <= 0 ){
				h_m=(23+0.59);                                   // Permet de garder le format 24H  ( evite de se retrouver avec une heure = -1.30 )
			}
			else {
				if (h_m-(int)h_m  >= 0.50 ){
					h_m=Math.round(h_m)-1+((h_m-(int)h_m)-0.01); // Math.round arrondi au superieur si la partie décimale du double est supérieure ou égale à 0.50 . ---> Donc il  faut adapter le code 
				}
				else{
					h_m=Math.round(h_m)+((h_m-(int)h_m)-0.01);          // Décrementation classique <=>  Décremente de 0.01 --> 1 min
				}
			}
		}
		return h_m;
	}

	public double setInteHorairePassageAvance(){
		for (int i = 0 ; i < 30 ; i++){
			if (horaire_de_passage-(int)horaire_de_passage  >= 0.60){   
				horaire_de_passage=Math.round(horaire_de_passage);            // Permet de garder le format de 60 min 

			}
			if (horaire_de_passage >= 24 ){
				horaire_de_passage=(0+(horaire_de_passage-(int)horaire_de_passage));         // Permet de garder le format 24H  ( evite de se retrouver avec une heure = 25.17 )
			}
			else {
				if (horaire_de_passage-(int)horaire_de_passage  >= 0.50 ) {                            
						horaire_de_passage=Math.round(horaire_de_passage)-1+((horaire_de_passage-(int)horaire_de_passage)+0.01);     // Math.round arrondi au superieur si la partie décimale du double est supérieure ou égale à 0.50 . ---> Donc il faut  adapter le code 
				}
				else{
					horaire_de_passage= Math.round(horaire_de_passage)+((horaire_de_passage-(int)horaire_de_passage)+0.01);         // Incrementation classique <=>  Incremente de 0.01 --> 1 min 
				}
			}
		}
		return horaire_de_passage;
	}
	public String toString(){
		return nom+" "+points+" points restants\n"+"horaire de passage : "+horaire_de_passage+"\n";
	}

	///// ACCESSEURS \\\\\
	public abstract void setPoints(int p);
	public abstract int getPoints();
	public abstract double getHeure();
	public abstract String getNom();
	public abstract void setHeure(double h);
}
	
