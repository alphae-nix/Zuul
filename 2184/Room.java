import java.util.*;
/**
 *Cette classe représente une salle, elle référence des liens vers des salles voisines
 * @author DELATTE Laurent
 * @version 1.0
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits;
    public HashMap<String, Item> aItems;
    private String imageName;
    private Stack<Room> aRooms;
    // Attributs   
    /**
     * Va initialiser les attributs de la classe
     * @param pDescription la nouvelle description de la room
     * @param pImage lien de l'image
     */
    public Room (final String pDescription, final String pImage){ //Modifier pour l'exercice 7.8
        this.aDescription = pDescription ;
        aExits = new HashMap<String,Room>();
        aItems = new HashMap<String, Item>();
        imageName = pImage;
        aRooms = new Stack<Room>();

    } // Constructeur naturel

    /**
     * Définit les sorties de cette pièce. Chaque direction soit conduit à une autre pièce, soit est null (il n'y a pas de sortie dans cette direction)
     * @param pDirection direction de la salle voisine à ajouter 
     * @param pNeighbor salle voisine à ajouter
     */
    public void setExits (final String pDirection, final Room pNeighbor) { //Modifier pour l'exercice 7.8
        aExits.put(pDirection, pNeighbor);
    } //Procédure, hashmap

    /**
     * Définit les items présents dans chaques pièces
     * @param pItem Item a associer a la salle
     * @param pNom Nom de la salle associé à l'item
     */
    public void setItems (final String pNom, final Item pItem)
    {
        aItems.put(pNom, pItem);
    }//Hashmap permettant d'associer chaques items à une room

    /**
     * Permet de supprimer un item de la hashmap aItems
     * @param pNom Nom de l'item à supprimer de la hashmap
     */
    public Item removeItem (final String pNom) {
        return aItems.remove(pNom);
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     * @return aDescription 
     */
    public String getShortDescription()
    {
        return this.aDescription;
    }

    /**
     * Cette méthode permet de connaitre tout les objets présent dans une pièce
     * @return vString Renvoi tout les Items présent dans cette pièce
     */
    public String getItemsNames()
    {
        String vString ="";
        for (String vS : aItems.keySet())
        {
            vString += " " + vS;
        }

        return vString;
    }

    /**
     * Return a long description of this room
     * @return Description longue 
     */
    public String getLongDescription()
    {
        return " You are " + this.aDescription + "\n" + getExitString() + "\n" + "Free Items in this Room are:" + this.getItemsNames() ;
    }

    /**
     * Donne la liste des sortis possibles pour cette pièce
     * @return renvoi la liste des sortis possibles
     */
    public String getExitString(){ //Modifié pour l'exercice 7.9
        StringBuilder returnString = new StringBuilder( "Exits:" );
        for ( String vS : aExits.keySet() )
            returnString.append( " " + vS );
        return returnString.toString();
    }//fin getExitString

    /**
     * Cette méthode retourne la salle dans la direction donné en argument, si il n'y a pas de salle dans la direction donnée en argument alors renvoi null
     * @param pDirection Chaine de charactère tapé par l'utilisateur qui va lui affecter une direction
     * @return les différentes direction
     */
    public Room getExit(final String pDirection){ //Modifier pour l'exercice 7.8
        return aExits.get(pDirection);
    }

    /**
     * Return a string describing the room's image name
     * @return imageName
     */
    public String getImageName()
    {
        return imageName;
    }
}  // Room

