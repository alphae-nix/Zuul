
public class Command
{
    private String aCommandWord = null ;
    private String aSecondWord = null ;
    // Attributs

    /**
     * Va initialiser les différents attributs de la classe
     * @param pCommandWord lis le premier mot
     * @param pSecondWord lis le deuxième mot
     */
    public Command (final String pCommandWord , final String pSecondWord){
        this.aCommandWord = pCommandWord ;
        this.aSecondWord = pSecondWord ;
    } // Constructeur naturel

    /**
     * Va créer un accesseur à l'attribut aCommandWord()
     */
    public String getCommandWord()
    {
        return this.aCommandWord ;
    } // Accesseur CommandWord

    /**
     * Va créer un accesseur à l'attribut aSecondWord()
     */
    public String getSecondWord(){
        return this.aSecondWord ;
    } // Accesseur SecondWord

    /**
     * Vérification qu'un second mot a bien été tapé
     * @return va retourner le deuxième mot
     */
    public boolean hasSecondWord(){
        boolean hasSecondWord = false ;
        if ( this.aSecondWord == null ){
            hasSecondWord = false ;
        }

        else hasSecondWord = true ;
        return hasSecondWord ;
    } // fin hasSecondWord()

    /**
     * Va vérifier qu'une méthode à bien été tapé
     */
    public boolean isUnknown() {
        boolean isUnknown = true ;
        if ( this.aCommandWord == null ){
            isUnknown = true ;
        }
        else isUnknown = false ;
        return isUnknown ;
    } // fin isUknown()

} // Command
