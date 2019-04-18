// Reste à attribuer aPrix
/**
 * Classe Item permettant de réprésenter tous les objets du jeu
 * @author DELATTE Laurent
 * @version 1.0
 */
public class Item
{
    private String aNom;
    private int aPoids;
    private String aDescription;
    private int aPrix;
    /**
     * Initialise les attributs d'un item
     * @param pNom nom de l'objet
     * @param pPoids poids de l'objet
     * @param pDescription description de l'objet
     */
    public Item (final String pNom, final int pPoids, final String pDescription)
    {
        this.aNom = pNom;
        this.aPoids = pPoids;
        this.aDescription = pDescription;

    } // Constructeur naturel
    
    /**
     * Retourne la description de l'objet et son poids
     * @return description et le poids de l'objet
     */
    public String getItemInformations()
    {
        return this.aDescription + " qui a un poids de " + this.aPoids;
    }//accesseur pour obtenir les informations relative
    
    /**
     * Retourn le prix de l'objet
     * @return prix de l'objet
     */
    public int getaPrix()
    {
        return this.aPrix;
    }//accesseur pour obtenir le prix d'un objet
    
    /**
     * Retourne le nom de l'objet
     * @return nom de l'objet 
     */
    public String getaNom()
    {
        return this.aNom;
    }//accesseur pour aNom
    
    /**
     * Retourne le poids de l'objet
     * @return poids de l'objet
     */
    public int getaPoids()
    {
        return this.aPoids;
    }//accesseur pour aPoids
    
    /**
     * Retourne la description de l'objet
     * @return description de l'objet
     */
    public String getaDescription()
    {
        return this.aDescription;
    }//accesseur pour aDescription
    
}
