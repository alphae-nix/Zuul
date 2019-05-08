import java.util.*;
/**
 * Permet de gérer une liste d'item 
 *
 * @author Laurent Delatte
 * @version 1.0
 */
public class ItemList
{
    public final HashMap<String, Item> aInventaire;  
    private int aPoidActuel ;
    public ItemList(){
        this.aInventaire = new HashMap<>();
        this.aPoidActuel = 0;
    }

    /**
     * accesseur de la hashmap
     */
    public HashMap getItemList(){
        return this.aInventaire ;
    }

    public int getPoidActuel(){
        return this.aPoidActuel;
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
     * Permet de supprimer un item de la hashmap aInventaire
     * @param pNom Nom de l'item à supprimé de la hashmap
     */
    public Item removeItemInventaire (final String pNom) {
        return aInventaire.remove(pNom);
    }

    /**
     * Permet de supprimer un poid dans son inventaire
     */
    public void rmPoid (final int pPoidARetirer){
        this.aPoidActuel -= pPoidARetirer;
    }

    /**
     * 
     */
    public void addPoid (final int pPoidAAjouter){
        this.aPoidActuel += pPoidAAjouter;
    }

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
}
