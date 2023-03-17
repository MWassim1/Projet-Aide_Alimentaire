public class TabBeneficiairesPleinException extends Exception{
    public TabBeneficiairesPleinException(){
                super("Nombre de beneficiaire dans le magasin atteint -> mise en attente du beneficiaire \n");
    }
    public TabBeneficiairesPleinException(String msg){
        super(msg);
    }
}