
/**
 * Classe définissant le(s) joueur(s) du jeu
 *
 * @author DELATTE Laurent
 * @version 1.0
 */
public class Player
{
    private Room aCurrentRoom;
    private String aNom;
    private int aPoidMax;

    /**
     * Constructeur pour la classe Player
     * @param pNom nom du player
     * @param pPoidMax poids total du joueur
     */
    public Player (final String pNom, final int pPoidMax){
        this.aNom = pNom;
        this.aPoidMax = pPoidMax; 
    }

    /**
     * Retourne la piece actuelle
     * @return piece actuelle
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;

    }//getCurrentRoom
    
    /**
     * Initialise la room dans laquelle se trouve le player
     * @param pNouvelleRoom Nouvelle Room
     */
    public void setCurrentRoom( final Room pNouvelleRoom)
    {
        this.aCurrentRoom = pNouvelleRoom;
    }
}
