import java.util.Stack;
import java.util.Scanner;
import java.io.*;
/**
 * Cette classe fait partie de l'application "World of Zuul".
 * "World of Zuul" est un jeu d'aventure très simple, basé sur du texte.
 *
 * Cette classe crée toutes les salles, crée l'analyseur et commence
 *  le jeu. Il évalue et exécute également les commandes qui
 * l'analyseur revient.
 *
 * @author DELATTE Laurent
 * @version 1.0
 */
public class GameEngine
{
    private Parser aParser;
    private Player aPlayer;
    private UserInterface aGui;
    private Stack<Room> aRoomStack;

    /**
     * Constructeur pour la classe GameEngine
     */
    public GameEngine()
    {
        aPlayer = new Player("Watson", 100);
        aParser = new Parser();
        this.aRoomStack = new Stack<Room>();
        createRooms();
    }

    /**
     * Définit le GUI
     * @param pUserInterface pUserInterface
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        aGui = pUserInterface;
        this.printWelcome();
    }

    /**
     * Va afficher un message de bienvenue au début du jeu pour le joueur
     */
    private void printWelcome() {
        aGui.print("\n");
        aGui.println("Welcome to London in 2184! ");
        aGui.println("You must find a combination of numbers corresponding to the geographical coordinates of a rebel base that is fighting against the \"party\"");
        aGui.println("You will need to follow the instructions in your book to avoid being arrested.");
        aGui.println("Type 'help' if you need help.");
        aGui.print("\n");
        aGui.println(aPlayer.getCurrentRoom().getLongDescription());
        aGui.showImage(aPlayer.getCurrentRoom().getImageName());

    } //Affichage du message au début du jeu 

    /**
     * Va créer toutes les rooms nécessaires
     */
    private void createRooms(){ //Modifier pour l'exercice 7.8
        Room vHome, vStreet1, vFactory, vStreet2, vStreet3, vPark, vBridge, vCafe, vStreet4, vCinema, vCellar;

        vHome = new Room("at home", "images/home.jpg");    
        vStreet1 = new Room("in the First Street", "images/Street1.png");
        vFactory = new Room ("in the party of truth", "images/Factory.jpg") ;
        vStreet2 = new Room ("in the Second Street","images/Street2.jpg") ;
        vStreet3 = new Room ("in the Third Street","images/Street3.jpg") ;
        vPark = new Room ("in Hyde Park","images/HydePark.png") ;
        vBridge = new Room ("in Tower Bridge", "images/TowerBridge.jpg");
        vCafe = new Room ("in the Café du Chataigner","images/CoffeShop.jpg");
        vStreet4 = new Room ("in the Fourth Street", "images/Street4.jpg") ;
        vCinema = new Room ("in the Cinema", "images/Cinema.jpg");
        vCellar = new Room ("in a secret place", "images/Cellar.jpg") ;
        // Déclaration des lieux de ma map (10)*/

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
        aPlayer.setCurrentRoom(vHome);
        // Déclaration du lieu courant

        Item vTorch, vKey1, vKey2, vChest, vBook;
        vTorch = new Item("Torch", 10,"Thanks to this torch you can illuminate dark areas");
        vKey1 = new Item ("Key1", 10, "Thanks to this Key you can cross Tower Bridge");
        vKey2 = new Item ("Key2", 20, "Thanks to this key you can go in a secret place");
        vChest = new Item ("Chest", 0,"Thanks to this chest you can clean up your stuff");
        vBook = new Item ("Book", 5, "All informations you need are in this book");
        // Déclaration de mes items

        vStreet3.setItems("Torch",vTorch);
        vFactory.setItems("Key1", vKey1);
        vPark.setItems("Key2", vKey2);
        vHome.setItems("Chest", vChest);
        vHome.setItems("Book", vBook);

    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * @param pCommandLine Ligne de Commande
     */
    public void interpretCommand(String pCommandLine) 
    {
        aGui.println("---------------------------------------------------------------------");
        aGui.println(pCommandLine);
        Command command = aParser.getCommand(pCommandLine);

        if(command.isUnknown()) {
            aGui.println("I don't know what you mean...");
            return;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit")) {
            if(command.hasSecondWord())
                aGui.println("Quit what?");
            else
                endGame();
        }
        else if (commandWord.equals("look")){
            this.look();
        }
        else if (commandWord.equals("eat")){
            this.eat();
        }
        else if (commandWord.equals("back")){
            if(command.hasSecondWord())
                aGui.println("Back where?");
            else 
                this.back();
        }
        else if (commandWord.equals("test"))
        {
            if (command.hasSecondWord()){
                test(command.getSecondWord());
            }
            else aGui.println("no file select");
        }
        else if (commandWord.equals("take")){
            if (!command.hasSecondWord() ){
                aGui.println("take what");
            } else if (!this.aPlayer.take(command.getSecondWord())){
                aGui.println("you can't take this item");
            }
        }
        else if (commandWord.equals("drop")){
           if (!command.hasSecondWord() ){
               aGui.println("drop what");
           }else if (!this.aPlayer.drop(command.getSecondWord())){
                aGui.println("you can't drop this item");
            }
        }
    }

    /**
     * Va afficher un message lorsqu'on tapera "help"
     */
    private void printHelp(){
        aGui.println("You are lost. You are alone.\n" +
            " Your command words are:\n" );
        aGui.println(aParser.showCommands());
    } // fin méthode printHelp

    /**
     * Va nous permettre de revenir dans la salle précédente
     */
    public void back()
    {
        if (aRoomStack.empty()){
            aGui.println("Any rooms visited yet");
        }
        else {aPlayer.setCurrentRoom(aRoomStack.pop());
            aGui.println(aPlayer.getCurrentRoom().getLongDescription());
            if(aPlayer.getCurrentRoom().getImageName() != null)
                aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());}
    }

    /**
     * Procédure goHome exécuté quand on tape la commande "go" et qui permet de changer de pièce
     * @param pCommand la commande passé en paramètre pour connaitre la direction
     */
    private void goRoom (final Command pCommand)
    { 
        if ( ! pCommand.hasSecondWord() ){
            aGui.println("Go where");
            return ;
        }//Vérification de l'insertion d'un deuxième caractère et affichage message d'erreur

        String vDirection = pCommand.getSecondWord() ;

        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit(vDirection) ; // initialisation de NextRoom à null

        aRoomStack.push(this.aPlayer.getCurrentRoom());
        if (vNextRoom==null){
            aGui.println("There is no door !") ;
        }

        else{
            aPlayer.setCurrentRoom(vNextRoom);
            aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
            if(this.aPlayer.getCurrentRoom().getImageName() != null)
                aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
        }
    } //fin goRoom

    /**
     * Va nous permettre de quitter le jeu
     */
    private void endGame()
    {
        aGui.println("Thank you for playing.  Good bye.");
        aGui.enable(false);

    }

    /**
     * Va afficher ce message lorsqu'on execute la commande
     */
    private void eat(){
        aGui.println("You have eaten now and you are not hungry any more");
    }

    /**
     * Va permettre d'afficher les informations relatives au lieu ou on se trouve
     */
    private void look(){ //modifier pour l'exo 7.14
        aGui.println(this.aPlayer.getCurrentRoom().getLongDescription() + "\n" + " You have in your inventory :" + aPlayer.getItemsNames());
    }

    /**
     * Va permettre d'afficher les informations relatives au lieu ou on se trouve
     */
    private void printLocationInfo(){
        aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
    }

    /**
     * Pemet de faire un test en lisant des commandes dans un fichier 
     * @param pNomFichier Nom du fichier que l'on veut lire
     */
    public void test(final String pNomFichier)  
    {
        try {
            Scanner vSc = new Scanner ( new File( pNomFichier ) );
            while (vSc.hasNextLine()){
                this.interpretCommand(vSc.nextLine());
            } //while qui test si il y a une ligne après 
        }//essai du code

        catch ( final Exception pE){
            this.aGui.println("file error");
        }
    }//permet de lire un 

}
