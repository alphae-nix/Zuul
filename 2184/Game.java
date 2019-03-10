/**
 * Cette classe permet de gérer le jeu
 */
public class Game { 

    private Room aCurrentRoom;
    private Parser aParser;
    /**
     * Va créer toutes les rooms nécessaires
     */
    private void createRooms(){ //Modifier pour l'exercice 7.8
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
        Room vCellar = new Room (" You are in a secret place") ;
        // Déclaration des lieux de ma map (10)

        vHome.setExits("north",vStreet1);
        vHome.setExits("east",vStreet3);
        vStreet1.setExits ("north", vFactory);
        vStreet1.setExits ("south", vHome);
        vFactory.setExits ("east", vStreet2);
        vFactory.setExits ("south", vStreet1);
        vStreet2.setExits ("east", vPark);
        vStreet2.setExits ("west", vFactory);
        vStreet3.setExits ("north", vPark);
        vStreet3.setExits ("west", vHome);
        vPark.setExits ("north", vBridge);
        vPark.setExits ("east", vStreet4);
        vPark.setExits ("south", vStreet3);
        vPark.setExits ("west", vStreet2);
        vBridge.setExits ("north", vCafe);
        vBridge.setExits ("south", vPark);
        vCafe.setExits ("south", vBridge);
        vCafe.setExits ("below", vCellar);
        vStreet4.setExits ("south", vCinema);
        vStreet4.setExits ("west", vPark);
        vCinema.setExits ("north", vStreet4) ;
        vCellar.setExits ("above", vCafe);
        // Déclaration du réseau des salles entrent elles

        this.aCurrentRoom = vHome ;
        // Déclaration du lieu courant

    }

    /**
     * Va afficher un message de bienvenu au début du jeu
     */
    private void printWelcome() {
        System.out.println("Welcome to the World of Zuul! ") ;
        System.out.println("You must find a combination of numbers corresponding to the geographical coordinates of a rebel base that is fighting against the \"party\"");
        System.out.println("You will need to follow the instructions in your book to avoid being arrested.");

        System.out.println("Type 'help' if you need help.");
        System.out.println('\n');
        printLocationInfo();
    } //Affichage du message au début du jeu 

    /**
     * Va nous permettre de lancer le jeu 
     */
    public void play() {
        printWelcome() ;
        boolean vFinished = false ;
        while( vFinished == false){
            Command vCommand = this.aParser.getCommand();
            vFinished = this.processCommand( vCommand ) ;
        }
        System.out.println( "Thank you for playing. Good bye." );

    } //play() 

    /**
     * Va permettre d'initialiser les attributs de la classe
     */
    public Game () {
        this.createRooms() ;
        aParser = new Parser();
    } // Constructeur par Défaut

    /**
     * Procédure goHome exécuté quand on tape la commande "go" et qui permet de changer de pièce
     * @param pCommand la commande passé en paramètre pour connaitre la direction
     */
    private void goRoom (final Command pCommand)
    { 
        if ( ! pCommand.hasSecondWord() ){
            System.out.println("Go where");
            return ;
        }//Vérification de l'insertion d'un deuxième caractère et affichage message d'erreur

        String vDirection = pCommand.getSecondWord() ;

        Room vNextRoom = aCurrentRoom.getExit(vDirection) ; // initialisation de NextRoom à null

        if (vNextRoom==null){
            System.out.println("There is no door !") ;
        }

        else{
            this.aCurrentRoom=vNextRoom ;
            /*System.out.println(vNextRoom.getDescription()) ;*/
            printLocationInfo();
        }
    } //fin goRoom

    /**
     * Va afficher un message lorsqu'on tapera "help"
     */
    private void printHelp(){
        System.out.println("You are lost. You are alone.\n" +
            " Your command words are:\n" + "   go quit help ") ;
    } // fin méthode printHelp

    /**
     * Va initialiser la fonction Boolean qui se lance quand on marquera "quit"
     * @param pCommand est la commande tapé au clavier
     * @return la valeur de quit
     */
    private boolean quit(final Command pCommand){
        if ( pCommand.hasSecondWord()){
            System.out.println("Quit what ?") ;
            return false ;
        }
        return true ; 

    } // fin méthode quit

    /**
     * Va lister des commandes qui seront validées lorsqu'on les écrits dans le jeu
     * @param pCommand commande tapé
     * @return la valeure de processCommand
     */
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

    /**
     * Va permettre d'afficher les informations relatives au lieu ou on se trouve
     */
    private void printLocationInfo(){
        System.out.println(aCurrentRoom.getDescription());
        System.out.print("List of exits :");
        System.out.println(aCurrentRoom.getExitString());

    }

} // Game
