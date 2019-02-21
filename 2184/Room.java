 

public class Room
{
    private String aDescription = "Cette salle est une chambre ou réside notre héro, elle n'est pas très bien entretenu et il n'a qu'une seule pièce" ;
    public Room aNorthExit ;
    public Room aEastExit ;
    public Room aSouthExit ;
    public Room aWestExit ;
    // Attributs   
 /**
  * Va initialiser les attributs de la classe
  * @param pDescription la nouvelle description de la room
  */
 public Room (final String pDescription){
    this.aDescription = pDescription ;

 } // Constructeur naturel
 
 /**
  * Va créer un accesseur de aDescription
  * @return renvoi la description de l'objet
  */
 public String getDescription() {
    return this.aDescription;
  } // Accesseur de Description
 
 /**
  * Va initialiser les différentes sorties possibles pour une pièce
  * @param pNorthExit initialise une sortie au Nord de la pièce
  * @param pEastExit initialise une sortie à l'Est de la pièce
  * @param pSouthExit initialise une sortie au Sud de la pièce
  * @param pWestExit initialise une sortie à l'Ouest de la pièce
  */
 public void setExits (final Room pNorthExit , final Room pEastExit , final Room pSouthExit , final Room pWestExit) {
    this.aNorthExit = pNorthExit ;
    this.aEastExit = pEastExit ; 
    this.aSouthExit = pSouthExit ; 
    this.aWestExit = pWestExit ;
  } //Procédure
 
  /**
   * Permet de comparer pDirection avec les différentes directions initialisés
   * @param pDirection Chaine de charachtère tapé par l'utilisateur qui va lui affecter une direction
   * @return les différentes direction
   */
 public Room getExit(final String pDirection){
     if (pDirection.equals("north")){
         return aNorthExit;
     }
     if (pDirection.equals("east")){
         return aEastExit;
     }
     if (pDirection.equals("south")){
         return aSouthExit;
     }
     if (pDirection.equals("west")){
         return aWestExit;
     }
     return null;
 }
} // Room
