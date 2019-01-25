 

public class Command
{
  private String aCommandWord = null ;
  private String aSecondWord = null ;
  // Attributs
  
  public Command (final String pCommandWord , final String pSecondWord){
    this.aCommandWord = pCommandWord ;
    this.aSecondWord = pSecondWord ;
    } // Constructeur naturel
    
   public String getCommandWord()
   {
       return this.aCommandWord ;
    } // Accesseur CommandWord
    
    public String getSecondWord(){
    return this.aSecondWord ;
    } // Accesseur SecondWord
 
    public boolean hasSecondWord(){
    boolean hasSecondWord = false ;
        if ( this.aSecondWord == null ){
    hasSecondWord = false ;
    }
    
    else hasSecondWord = true ;
    return hasSecondWord ;
    } // Vérification qu'un second mot a bien été tapé
    
    public boolean isUnknown() {
    boolean isUnknown = true ;
    if ( this.aCommandWord == null ){
    isUnknown = true ;
    }
    else isUnknown = false ;
   return isUnknown ;
    } // méthode qui vérifie si la commande tapé existe
    
    

} // Command
