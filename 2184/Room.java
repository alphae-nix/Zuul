 

public class Room
{
    private String aDescription = "Cette salle est une chambre ou réside notre héro, elle n'est pas très bien entretenu et il n'a qu'une seule pièce" ;
    public Room aNorthExit = null;
    public Room aEastExit = null;
    public Room aSouthExit = null;
    public Room aWestExit = null ;
 // Attributs   
    
public Room (final String pDescription){
    this.aDescription = pDescription ;

} // Constructeur naturel

public String getDescription() {
return this.aDescription;
} // Accesseur de Description

public void setExits (final Room pNorthExit , final Room pEastExit , final Room pSouthExit , final Room pWestExit) {
this.aNorthExit = pNorthExit ;
this.aEastExit = pEastExit ; 
this.aSouthExit = pSouthExit ; 
this.aWestExit = pWestExit ;
} //Procédure




} // Room
