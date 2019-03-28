import java.util.HashMap;
import java.util.Set;
/**
 * Cette classe représente une salle, elle référence des liens vers des salles voisines
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits;
    // Attributs   
    /**
     * Va initialiser les attributs de la classe
     * @param pDescription la nouvelle description de la room
     */
    public Room (final String pDescription){ //Modifier pour l'exercice 7.8
        this.aDescription = pDescription ;
        aExits = new HashMap<>();
    } // Constructeur naturel

    /**
     * Va créer un accesseur de aDescription
     * @return renvoi la description de l'objet 
     */
    public String getDescription() { //Modifier pour l'exercice 7.8
        return this.aDescription;
    } // Accesseur de Description

    /**
     * Définit les sorties de cette pièce. Chaque direction soit conduit à une autre pièce, soit est null (il n'y a pas de sortie dans cette direction)
     * @param pDirection direction de la salle voisine à ajouter 
     * @param pNeighbor salle voisine à ajouter
     */
    public void setExits (final String pDirection, final Room pNeighbor) { //Modifier pour l'exercice 7.8
        aExits.put(pDirection, pNeighbor);
    } //Procédure, hashmap

    /**
     * Cette méthode retourne la salle dans la direction donné en argument, si il n'y a pas de salle dans la direction donnée en argument alors renvoi null
     * @param pDirection Chaine de charactère tapé par l'utilisateur qui va lui affecter une direction
     * @return les différentes direction
     */
    public Room getExit(final String pDirection){ //Modifier pour l'exercice 7.8
        return aExits.get(pDirection);
    }

    /**
     * Donne la liste des sortis possibles pour cette pièce
     * @return renvoi la liste des sortis possibles
     */
    public String getExitString(){ //Modifié pour l'exercice 7.9
        String listOfExits = "";
        Set<String> exitsKeys = this.aExits.keySet();
        for (String exitKey: exitsKeys){ // : signnifie pour chaques
            listOfExits += exitKey + " ";
        }
        return listOfExits;
    } //fin getExitString

    /**
     * Renvoie une description détaillée de cette pièce sous la forme:
     *      Vous etes dans la cuisine.
     *      Sorties: nord ouest
     *@return Une description de la pièce, avec les sorties possibles
     */
    public String getLongDescription(){
        return " You are " + this.aDescription + "\n" + "Exits: "+getExitString();
    }


    
    
} // Room
