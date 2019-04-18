/**
 * Cette classe va représenter les commandes tapées par le joueur dans la console
 * @author DELATTE Laurent
 * @version 1.0
 */
public class Command
{
    private String aCommandWord = null ;
    private String aSecondWord = null ;
    // Attributs

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     * Va initialiser les différents attributs de la classe
     * @param pFirstWord lis le premier mot
     * @param pSecondWord lis le deuxième mot
     */
    public Command (final String pFirstWord, final String pSecondWord)
    {
        aCommandWord = pFirstWord;
        this.aSecondWord = pSecondWord;
    }// Constructeur naturel

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * Va créer un accesseur à l'attribut aCommandWord()
     * @return aCommandWord
     */
    public String getCommandWord()
    {
        return this.aCommandWord ;
    } // Accesseur CommandWord

    /**
     * Return the second word of this command. Returns null if there was no
     * second word.
     *Va créer un accesseur à l'attribut aSecondWord()
     * @return aSecondWord
     */
    public String getSecondWord(){
        return this.aSecondWord ;
    } // Accesseur SecondWord
    
        
    /**
     * Return true if this command was not understood.
     * Va vérifier qu'une méthode à bien été tapé
     * @return si la commande est connue ou pas
     */
    public boolean isUnknown() {
        return (this.aCommandWord == null ) ;
    } // fin isUknown()

    /**
     * Vérification qu'un second mot a bien été tapé
     * @return va retourner le deuxième mot
     */
    public boolean hasSecondWord(){
        return (aSecondWord != null);
    } // fin hasSecondWord()

} // Command
