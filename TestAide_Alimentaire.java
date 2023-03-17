import java.util.ArrayList;
public class TestAide_Alimentaire {
	public static void main(String[] args ){
		///// 1ere Aide Alimentaire \\\\\

		///// CREATION DE NOS PRODUITS \\\\\
		   Produit h = new Hygiene("Gel douche",100);
		   Produit b = new Produit_bebe("Couches",200);
		   Aliment p_s = new Plat_Sec("pain" ,100,24);
		   Aliment l = new Produit_Laitier("Lait",300,72);
		   Aliment f = new Fruits_Legumes("Pommes & Carottes",250,48);
		   Aliment v = new Viande("Boeuf" , 150 , 48 );


		///// CREATION DE NOTRE TABLEAU DE BENEFICIAIRES + LISTE D'ATTENTE \\\\\
		   ArrayList<Beneficiaire> tab_b = new ArrayList<Beneficiaire>();
		   ArrayList<Beneficiaire> l_attente = new ArrayList<Beneficiaire>();

		///// BENEFICIAIRES \\\\\
		   Seule b_s1=new Seule(11.00, 0,"Joe");
		   Seule b_s2 = new Seule (11.30 , 300 , "Paul"); // passe à 11H 
		   Couple b_c = new Couple (14.00 , 500, "Chris & Sandrine");
		   Famille b_f = new Famille(17.45 , 800 , "Les Cervi",2,1);
		   Famille b_f2 = new Famille(b_f); // Utilisation du constructeur par recopie
			b_f.ajouter_bebe(1);
	
		///// CREATION DE L'AIDE ALIMENTAIRE  \\\\\

		  Aide_Alimentaire aide = new Aide_Alimentaire("Secours Populaire",6,2,tab_b, l_attente);
			aide.ajouter_produit(h);
			aide.ajouter_produit(b);
			aide.ajouter_produit(p_s);
			aide.ajouter_produit(l);
			aide.ajouter_produit(f);
			aide.ajouter_produit(v);

			Accueil a=Accueil.getInstance();
			System.out.println(a);

			System.out.println("--------------- "+aide.getNom()+" : Aide Alimentaire "+aide.getRef()+" ---------------\n");
		    
			try{
				aide.ajouter_beneficiaire(b_s1);
				aide.ajouter_beneficiaire(b_s2);
				aide.ajouter_beneficiaire(b_c);
				aide.ajouter_beneficiaire(b_f);
			}catch(TabBeneficiairesPleinException e){ 
				System.out.println(e.toString());
			}		

			for(int i=0;tab_b.size()!=0;i++){// condition: tab_b.size()!=0 si on veut une que ca s'arrete jusqu'a que tout le monde ait recuperer leur course
				System.out.println("\n");
				System.out.println("Tour "+(i+1));
				System.out.println("BENEFICIAIRES ET PRODUITS\n");
		    	System.out.println(aide.toString());

		   		aide.diminuePoint();

				System.out.println("\n");

				aide.duree_validite(); // decrementation de 1 de la duree du produit a chaque appel
			}

			// a la fin de la boucle, il n'y a plus de beneficiaire dans la liste tab_b
			
			System.out.println("\n");
		    aide.restock();
			aide.affiche_tab();// affiche le tableau de produit apres le restockage

		///// 2eme Aide Alimentaire \\\\\
		
		///// CREATION DE NOS PRODUITS \\\\\
		Produit h1 = new Hygiene("Dentifrice",230);
		Produit b1 = new Produit_bebe("Petit Pot",50);
		Aliment p_s1 = new Plat_Sec("Pâte" ,300,168);
		Aliment l1 = new Produit_Laitier("Yaourt",200,48);
		Aliment f1 = new Fruits_Legumes("Asperge & Tomate",150,48);
		Aliment f2 = new Fruits_Legumes("Fraise & Pomme",178,24);
		Aliment v1 = new Viande("Poulet" , 35 , 24 );
		Aliment v2 = new Viande("Agneau" , 5 , 24 );


	 ///// CREATION DE NOTRE TABLEAU DE BENEFICIAIRES + LISTE D'ATTENTE \\\\\
		ArrayList<Beneficiaire> tab_b1 = new ArrayList<Beneficiaire>();
		ArrayList<Beneficiaire> l_attente1 = new ArrayList<Beneficiaire>();

	 ///// BENEFICIAIRES \\\\\
		Seule b_s3=new Seule(10.00, 50,"Lili");
		Seule b_s4 = new Seule (15.00 , 100 , "Eric"); // passe à 11H 
		Couple b_c1 = new Couple (9.37 , 200, "Nathalie & Bob");
		Couple b_c2 = new Couple (17.43 , 150, "Melanie & Thomas");
		Famille b_f1 = new Famille(16.26 , 400 , "Les LeBlanc",2,1);

		///// CREATION DE L'AIDE ALIMENTAIRE  \\\\\

		Aide_Alimentaire aide1 = new Aide_Alimentaire("La Croix Rouge",8,5,tab_b1, l_attente1);
		aide1.ajouter_produit(h1);
		aide1.ajouter_produit(b1);
		aide1.ajouter_produit(p_s1);
		aide1.ajouter_produit(l1);
		aide1.ajouter_produit(f1);
		aide1.ajouter_produit(v1);
		aide1.ajouter_produit(f2);
		aide1.ajouter_produit(v2);

		System.out.println(a);

		System.out.println("--------------- "+aide1.getNom()+" : Aide Alimentaire "+aide1.getRef()+" ---------------\n");
		
		try{
			aide1.ajouter_beneficiaire(b_s3);
			aide1.ajouter_beneficiaire(b_s4);
			aide1.ajouter_beneficiaire(b_c1);
			aide1.ajouter_beneficiaire(b_f1);
			aide1.ajouter_beneficiaire(b_f2);// Utilisation de l'instance obtenue par copie
			aide1.ajouter_beneficiaire(b_c2);
		}catch(TabBeneficiairesPleinException e){
			System.out.println(e.toString());
		}		

		for(int i=0;tab_b1.size()!=0;i++){// condition: tab_b1.size()!=0 si on veut une que ca s'arrete jusqu'a que tout le monde ait 	recuperer leur course
			System.out.println("\n");
			System.out.println("Tour "+(i+1));
			System.out.println("BENEFICIAIRES ET PRODUITS\n");
			System.out.println(aide1.toString());

			   aide1.diminuePoint();

			System.out.println("\n");

			aide1.duree_validite(); // decrementation de 1 de la duree du produit a chaque appel
		}
		// a la fin de la boucle, il n'y a plus de beneficiaire dans la liste tab_b1
		
		System.out.println("\n");
		aide1.restock();
		aide1.affiche_tab(); // affiche le tableau de produit apres le restockage

		System.out.println(Aide_Alimentaire.getCpt()+" Aide Alimentaire ");
	}
}
		   
		
