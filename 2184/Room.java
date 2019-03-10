
public class Room
{
    private String aDescription = "Cette salle est une chambre ou réside notre héro, elle n'est pas très bien entretenu et il n'a qu'une seule pièce" ;
    private Room aNorthExit ;
    private Room aEastExit ;
    private Room aSouthExit ;
    private Room aWestExit ;
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
     * Cette méthode retourne la salle dans la direction donné en argument, si il n'y a pas de salle dans la direction donnée en argument alors renvoi null
     * @param pDirection Chaine de charactère tapé par l'utilisateur qui va lui affecter une direction
     * @return les différentes direction
     */
    public Room getExit(final String pDirection){
        if (pDirection == null ) {
            return null ;
        }
        
        switch (pDirection) {
            case "north" : 
                return aNorthExit;
            case "east" :
                return aEastExit;
            case "south" :
                return aSouthExit;
            case "west" :
                return aWestExit;
            default : 
            return null ;
        }

    }
    /**
     * Donne la liste des sortis possibles pour cette pièce
     */
    public String getExitString(){ //Modifié pour l'exercice 7.7
        String listOfExits = "";
        if(this.getExit("north") != null){
            listOfExits = "north ";
        }
        if(this.getExit("east") != null){
            listOfExits = listOfExits + "east ";
        }
        if(this.getExit("south") != null){
            listOfExits = listOfExits + "south ";
        }
        if(this.getExit("west") != null){
            listOfExits = listOfExits + "west ";
        } 
        return listOfExits;
    } //fin getExitString
} // Room
