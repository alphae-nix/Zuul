 

public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    
    private void createRooms(){
        Room vHome= new Room ("You are home") ;
        Room vStreet1 = new Room ("You are in the First street") ;
        Room vFactory = new Room ("You are in the party of truth") ;
        Room vStreet2 = new Room ("You are in the Second Street") ;
        Room vStreet3 = new Room ("You are in are in the Third Street") ;
        Room vPark = new Room ("You are in Hyde Park") ;
        Room vBridge = new Room ("You are in Tower Bridge");
        Room vCafe = new Room ("You are in the Café du Chataigner");
        Room vStreet4 = new Room ("You are in the Fourth Street") ;
        Room vCinema = new Room ("You are in the Cinema");
        Room vCave = new Room (" You are in a secret place") ;
        // Déclaration des lieux de ma map (10)
    
        vHome.setExits(vStreet1, vStreet3, null, null ) ;
        vStreet1.setExits ( vFactory, null , vHome , null ) ;
        vFactory.setExits ( null , vStreet2 , vStreet1 , null ) ;
        vStreet2.setExits ( null , vPark , null , vFactory ) ;
        vStreet3.setExits ( vPark , null , null , vHome) ;
        vPark.setExits ( vBridge , vStreet4 , vStreet3 , vStreet2 ) ;
        vBridge.setExits ( vCafe , null , vPark , null ) ;
        vCafe.setExits ( null , null , vBridge , null ) ;
        vStreet4.setExits ( null , null , vCinema , vPark ) ;
        vCinema.setExits ( vStreet4 , null , null , null ) ;
        vCave.setExits ( null , null , null , null ) ;
        // Déclaration du réseau des salles entrent elles
    
        this.aCurrentRoom = vHome ;
        // Déclaration du lieu courant
        
    }
    
    private void printWelcome() {
        System.out.println("Welcome to the World of Zuul! ") ;
        System.out.println("You must find a combination of numbers corresponding to the geographical coordinates of a rebel base that is fighting against the \"party\"");
        System.out.println("You will need to follow the instructions in your book to avoid being arrested.");
        
        System.out.println("Type 'help' if you need help.");
        System.out.println('\n');
        printLocationInfo();
    } //Affichage du message au début du jeu 
  
    public void play() {
        printWelcome() ;
        boolean vFinished = false ;
        while( vFinished == false){
            Command vCommand = this.aParser.getCommand();
            vFinished = this.processCommand( vCommand ) ;
        }
        System.out.println( "Thank you for playing. Good bye." );
        
    } //play() 
    
    public Game () {
        this.createRooms() ;
        aParser = new Parser();
    } // Constructeur par Défaut
    
    private void goRoom (final Command pDirection )
    { 
        if ( ! pDirection.hasSecondWord() ){
            System.out.println("Go where");
            return ;
        }//Vérification de l'insertion d'un deuxième caractère et affichage message d'erreur
    
        Room vNextRoom = null ; // initialisation de NextRoom à null
    
        String vDirection = pDirection.getSecondWord() ; // récupération du second mot dans une variable
    
        if (vDirection.equals("north")){
            vNextRoom = this.aCurrentRoom.aNorthExit ;
        }
    
        if (vDirection.equals("east")){
            vNextRoom = this.aCurrentRoom.aEastExit ;
        }
    
        if (vDirection.equals("south")){
            vNextRoom = this.aCurrentRoom.aSouthExit;
        }
    
        if (vDirection.equals("west")){
            vNextRoom=this.aCurrentRoom.aWestExit ; 
        }
    
        else{
            System.out.println("Unknown direction !") ;
    
        }
    
        if (vNextRoom==null){
            System.out.println("There is no door !") ;
        }
    
        else{
            this.aCurrentRoom=vNextRoom ;
            /*System.out.println(vNextRoom.getDescription()) ;*/
            printLocationInfo();
        }
    } //Procédure goHome exécuté quand on tape la commande "go" et qui permet de changer de pièce
        
  
    
    private void printHelp(){
        System.out.println("You are lost. You are alone.\n" + " You wander around at the university.\n\n" +
        " Your command words are:\n" + "   go quit help ") ;
    } // Méthode println qui sera afficher quand on tapera "help"
        
    private boolean quit(final Command pCommand){
        if ( pCommand.hasSecondWord()){
            System.out.println("Quit what ?") ;
            return false ;
        }
        else return true ; 
    
    } // Fonction Boolean qui se lance quand on marquera "quit"

    private boolean processCommand( final Command pCommand){
        String vCommandWord = pCommand.getCommandWord() ;
        if (pCommand.isUnknown()==true){
            System.out.println("I don't know what you mean...") ;
            return false ;
        }
       
        if (vCommandWord.equals("quit")){
            return quit(pCommand) ;
        }
            
        if (vCommandWord.equals("go")){
            goRoom(pCommand) ;
            return false ;
        }
            
        if (vCommandWord.equals("help")){
            printHelp() ;
            return false ;
        }
    
        return false ;
    }
    
    private void printLocationInfo(){
        System.out.println("You are " + aCurrentRoom.getDescription());
        System.out.print("The out :");
        if(aCurrentRoom.aNorthExit != null){
        System.out.print("north ") ;
        }
        if(aCurrentRoom.aEastExit != null){
        System.out.print("east ") ;
        }
        if(aCurrentRoom.aSouthExit != null){
        System.out.print("south ") ;
        }
        if(aCurrentRoom.aWestExit != null){
        System.out.print("west ") ;
        }
        System.out.println();
    }
    
} // Game
