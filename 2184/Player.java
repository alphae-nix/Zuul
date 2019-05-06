import java.util.*;
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
    private HashMap<String, Item> aInventaire;

    /**
     * Constructeur pour la classe Player
     * @param pNom nom du player
     * @param pPoidMax poids total du joueur
     */
    public Player (final String pNom, final int pPoidMax){
        this.aNom = pNom;
        this.aPoidMax = pPoidMax;
        this.aInventaire = new HashMap<>();
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

    /**
     * Définit l'inventaire du player
     * @param pItem Item a associer au nom
     * @param pNom Nom de l'objet associé à l'item
     */
    public void setInventaire (final String pNom, final Item pItem)
    {
        aInventaire.put(pNom, pItem);
    }// initialisation de la hashmap

    /**
     * Cette méthode permet de connaitre tout les objets présent dans l'inventaire
     * @return vString Renvoi tout les Items présent dans cette pièce
     */
    public String getItemsNames()
    {
        String vString ="";
        for (String vS : aInventaire.keySet())
        {
            vString += " " + vS;
        }

        return vString;
    }// fin getItemsNames

    /**
     * Permet de supprimer un item de la hashmap aInventaire
     * @param pNom Nom de l'item à supprimé de la hashmap
     */
    public Item removeItemInventaire (final String pNom) {
        return aInventaire.remove(pNom);
    }

    /**
     * Permet de prendre des objets d'une pièce et de les mettre dans son inventaire
     * @param pNomItem Nom de l'item à mettre dans son inventaire
     */
    public boolean take(final String pNomItem) {
        Item itemFromRoom = aCurrentRoom.removeItem(pNomItem);
        if (itemFromRoom == null ) {
            return false ;
        }
        aInventaire.put(pNomItem, itemFromRoom );
        return true;

    }
    
    /**
     * Permet de retire un item de son inventaire dans la salle ou l on se trouve
     * @param pNomItemInventaire Nom de l item a retirer de l inventaire
     */
    public boolean drop (final String pNomItemInventaire){
        Item itemFromInventaire = this.removeItemInventaire(pNomItemInventaire);
        if (itemFromInventaire == null ) {
            return false ;
        }
        aCurrentRoom.aItems.put(pNomItemInventaire, itemFromInventaire );
        return true;

    }
}


