import java.util.ArrayList;
public class Aide_Alimentaire {
	private Produit[] tab_produits ; 
	private ArrayList<Beneficiaire> tab_beneficiaires ;
	private ArrayList<Beneficiaire> liste_attente; 
	private static int cpt = 0 ;
	private final int ref;
	private final String nom; 
	private final int TAILLEMAX; // taille maximum du tableau de produit 
	private int nb_aliment=0; // compteur pour le tableau de produit lors de l'ajout
	private final int NBMAX_BENEFICIAIRE; // nombre de bénéficiaire maximum autorisé dans le magasin
	
	///// CONSTRUCTEURS \\\\\
	public Aide_Alimentaire(String n,int taille_p,int nb_max , ArrayList<Beneficiaire> b, ArrayList<Beneficiaire> l) {
		NBMAX_BENEFICIAIRE=nb_max;
		TAILLEMAX=taille_p;
		tab_produits = new Produit[TAILLEMAX];
		tab_beneficiaires = b ; 
		liste_attente=l;
		cpt++ ; 
		ref=cpt;
		nom=n;
	}
	
	///// METHODES DIVERSES \\\\\
	public void  diminuePoint() {
		System.out.println("----- SERVEZ-VOUS -----\n");
		try{// exception try catch si le nombre de beneficiaire est inferieur au nombre maximum donc la boucle va acceder a une memoire non initialisé d'ou l'exception
			for(int i=0;i<NBMAX_BENEFICIAIRE;i++){
				System.out.println("Beneficiaire "+(i+1)+" : "+tab_beneficiaires.get(0).getNom()+"\n");
				if (tab_beneficiaires.get(0).A_l_heure()){
					try{ // exception pour si on accede a une memoire vide dans tab_produit
						if(tab_beneficiaires.get(0).getPoints() == 0){
							System.out.println(tab_beneficiaires.get(0).getNom()+" n'a pas assez de points\n");
						}else{
							for (int j=0;j<tab_produits.length;j++){
								if (tab_produits[j].getStock() > 0 ){
									// si une famille a un bebe -> plus de chance de prendre un produit bebe (les produits bebe sont réservés aux famille avec bébé)
									if (tab_produits[j] instanceof Produit_bebe){
										if(tab_beneficiaires.get(0) instanceof Avec_Bebe){
											if(((boolean)(Math.random()<0.90) && (tab_beneficiaires.get(0).getPoints() >= tab_produits[j].points)) ){
												tab_beneficiaires.get(0).setPoints(tab_beneficiaires.get(0).getPoints()-tab_produits[j].points);
												tab_produits[j].setStock(tab_produits[j].getStock()-1);
												System.out.println(tab_beneficiaires.get(0).getNom()+" ont pris 1 "+tab_produits[j].getNom()+" ");
											}else{
												System.out.println(tab_beneficiaires.get(0).getNom()+" n'a pas assez de points pour le produit : "+tab_produits[j].getNom()+"\n");
											}
										}
									}
								}else{
									if(((boolean)(Math.random()<0.5) && (tab_beneficiaires.get(0).getPoints() >= tab_produits[j].points)) ){
										tab_beneficiaires.get(0).setPoints(tab_beneficiaires.get(0).getPoints()-tab_produits[j].points);
										tab_produits[j].setStock(tab_produits[j].getStock()-1);
										if((tab_beneficiaires.get(0) instanceof Famille) || (tab_beneficiaires.get(0) instanceof Couple )){
											System.out.println(tab_beneficiaires.get(0).getNom()+" ont pris 1 "+tab_produits[j].getNom()+" ");
										}
										else {
											System.out.println(tab_beneficiaires.get(0).getNom()+" a pris 1 "+tab_produits[j].getNom()+" ");
										}
									}else{
										System.out.println(tab_beneficiaires.get(0).getNom()+" n'a pas assez de points pour le produit : "+tab_produits[j].getNom()+"\n");
									}
								}
							}
						}
						System.out.println("\n");
						System.out.println("Au revoir : "+tab_beneficiaires.get(0).getNom()+"\n");
						tab_beneficiaires.remove(0); // on enleve le beneficiaire de la liste si il a recupéré ses produits 
						System.out.println("Liste d'attente \n");
						affiche(liste_attente);
						for(int k=0;k<NBMAX_BENEFICIAIRE;k++){ // on rajoute les beneficiaire en attente jusqu'a le nombre maximum atteint (si la liste d'attente n'est pas vide)
							if((liste_attente.size()!=0) && (tab_beneficiaires.size()!=NBMAX_BENEFICIAIRE)){
								System.out.println("Bienvenue "+liste_attente.get(0).getNom()+" !\n");
								System.out.println("--------------------\n");
								tab_beneficiaires.add(liste_attente.get(0));
								liste_attente.remove(0);
							}
						}
					}catch(NullPointerException e){
						System.out.println("Fonction diminuerPoint : L'espace memoire allouee dans tab_produits non initialise ");
					}
				}else{
					System.out.println("En attente : "+tab_beneficiaires.get(0).getNom()+"\n");// si le bénéficiaire n'arrive pas a l'heure il est rediriger vers la liste d'attente et son horaire est modifié
					liste_attente.add(tab_beneficiaires.get(0));
					tab_beneficiaires.remove(0);
					System.out.println("Liste d'attente \n");
					affiche(liste_attente);
				}
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("Plus de beneficiaire\n");
		}
		for(int k=0;k<NBMAX_BENEFICIAIRE;k++){ // a la fin du parcours de la liste des beneficiaire, si la liste d'attente n'est pas vide, on fait rentrer les beneficiaires tant que le nombre maximum n'est pas atteint
			if((liste_attente.size()!=0) && (tab_beneficiaires.size()!=NBMAX_BENEFICIAIRE)){
				System.out.println("Bienvenue "+liste_attente.get(0).getNom()+" !\n");
				System.out.println("--------------------\n");
				tab_beneficiaires.add(liste_attente.get(0));
				liste_attente.remove(0);
			}
		}
	}
	
	public void restock() {
			for (Produit p : tab_produits){
					p.setStock(p.getStock()+(int)(Math.random()*101));
			}
			System.out.println("----- Restock done -----\n");
	}


	public void ajouter_beneficiaire(Beneficiaire b ) throws TabBeneficiairesPleinException{
		if(tab_beneficiaires.size()>=NBMAX_BENEFICIAIRE){
			liste_attente.add(b);
			System.out.println(b.getNom()+" est en attente \n");
			//throw new TabBeneficiairesPleinException(); -> si on veut qu'il y est un seul ajout seulement dans la liste d'attente (bloque le code)

		}else{
			tab_beneficiaires.add(b);
			System.out.println("Bienvenue "+b.getNom()+" !\n");
			System.out.println("--------------------\n");
		}
	}

	public void ajouter_produit(Produit p){
		try{
			tab_produits[nb_aliment]=p;
			nb_aliment++;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Le tableau de produit est complet");
		}
	}

	public String toString(){
		String s = "\n";
		for( Beneficiaire f : tab_beneficiaires ) {
			s+=f.toString();
		}
		s+="\n";
		try{
			for (Produit e : tab_produits ){
				s+=e.toString();
			}
		}catch(NullPointerException e){
			System.out.println("Fonction toString : L'espace memoire allouee dans tab_produits non initialise ");
		}
		return s ;
	}

	public void affiche(ArrayList<Beneficiaire> a){
		for(Beneficiaire b:a){
			System.out.println(b+"\n");
		}
	}

	public void affiche_tab(){
		for(Produit b:tab_produits){
			System.out.println(b+"\n");
		}
	}

	public void duree_validite(){
		System.out.println("---------- Validite des Produits ----------\n");
		try{
			for(Produit p:tab_produits){
				p.perime();
			}
		}catch(NullPointerException e){
			System.out.println("Fonction duree_validite : L'espace memoire allouee dans tab_produits non initialise ");
		}
	}

	///// ACCESSEURS \\\\\
	public static  int getCpt(){ return cpt ; }
	public int getRef(){return ref;}
	public String getNom(){return nom;}
	public int getNBMAX_BENEFICIAIRE(){return NBMAX_BENEFICIAIRE;}
}
	
					
							
							
