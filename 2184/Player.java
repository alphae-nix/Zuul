import java.util.*;
/**
 * Classe définissant le(s) joueur(s) du jeu
 *
 * @author DELATTE Laurent
 * @version 1.0
 */
public class Player
{
    private Room aCurrentRoom;
    private String aNom;
    private int aPoidMax;
    private ItemList aItemList;
    private UserInterface aGui;
    public Stack<Room> aRoomStack;

    /**
     * Constructeur pour la classe Player
     * @param pNom nom du player
     * @param pPoidMax poids total du joueur
     */
    public Player (final String pNom, final int pPoidMax){
        this.aNom = pNom;
        this.aPoidMax = pPoidMax;
        this.aRoomStack = new Stack<Room>();
        this.aItemList = new ItemList();
    }

    /**
     * Définit le GUI
     * @param pUserInterface pUserInterface
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        aGui = pUserInterface;
    }

    /**
     * Va afficher un message de bienvenue au début du jeu pour le joueur
     */
    public void printWelcome() {
        aGui.print("\n");
        aGui.println("Welcome to London in 2184! ");
        aGui.println("You must find a combination of numbers corresponding to the geographical coordinates of a rebel base that is fighting against the \"party\"");
        aGui.println("You will need to follow the instructions in your book to avoid being arrested.");
        aGui.println("Type 'help' if you need help.");
        aGui.print("\n");
        aGui.println(this.getCurrentRoom().getLongDescription());
        aGui.showImage(this.getCurrentRoom().getImageName());

    } //Affichage du message au début du jeu 

    /**
     * Retourne la piece actuelle
     * @return piece actuelle
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;

    }//getCurrentRoom

    /**
     * Va nous permettre de revenir dans la salle précédente
     */
    public void back()
    {
        if (aRoomStack.empty()){
            aGui.println("Any rooms visited yet");
        }
        else {this.setCurrentRoom(aRoomStack.pop());
            aGui.println(this.getCurrentRoom().getLongDescription());
            if(this.getCurrentRoom().getImageName() != null)
                aGui.showImage(this.getCurrentRoom().getImageName());}
    }

    /**
     * Initialise la room dans laquelle se trouve le player
     * @param pNouvelleRoom Nouvelle Room
     */
    public void setCurrentRoom( final Room pNouvelleRoom)
    {
        this.aCurrentRoom = pNouvelleRoom;
    }

    /**
     * Permet de prendre des objets d'une pièce et de les mettre dans son inventaire
     * @param pNomItem Nom de l'item à mettre dans son inventaire
     */
    public boolean take(final String pNomItem) {

        Item itemFromRoom = aCurrentRoom.removeItem(pNomItem);
        if (itemFromRoom == null ) {
            return false ;
        }
        if ( itemFromRoom.getaPoids() < this.aPoidMax){

            aItemList.aInventaire.put(pNomItem, itemFromRoom );
            aGui.println("You have in your inventory: " + this.aItemList.getItemsNames());
            this.aItemList.addPoid(itemFromRoom.getaPoids());
            return true;
        }
        else {
            this.aCurrentRoom.aItems.put(pNomItem, itemFromRoom );
            aGui.println("Your inventory is full ");
            return false;
        }
    }

    /**
     * Va afficher ce message lorsqu'on execute la commande
     * @param pCommand Correspond au magic Cookie
     */
    public void eat( final Command pCommand){
        String vString = pCommand.getSecondWord();
        Item vItem = this.aItemList.aInventaire.get(vString);
        if (vString.equals("Cookie") && this.aItemList.aInventaire.containsValue(vItem)){
            this.aPoidMax = this.aPoidMax * 2;
            aGui.println("your inventory size has been doubled");
            this.aItemList.aInventaire.remove(vString, vItem);
            this.aItemList.rmPoid(vItem.getaPoids());
        }
        else {
            aGui.println("You can't eat this item");
            return ;
        }
        aGui.println("You have eaten now and you are not hungry any more");
    }

    /**
     * Va permettre d'afficher les informations relatives au lieu ou on se trouve
     */
    public void look(){ //modifier pour l'exo 7.14
        aGui.println(this.getCurrentRoom().getLongDescription());
    }

    /**
     * Va nous permettre d'afficher tout les objets présent dans l'inventaire ainsi que le poids de chacun et sa description 
     * 
     */
    public void inventaire(){
        for (  String itemName : this.aItemList.aInventaire.keySet()){
            Item item = this.aItemList.aInventaire.get(itemName);
            aGui.println(item.getItemInformations());
        }
        if ( aItemList.aInventaire.isEmpty()){
            aGui.println("You have anything in your inventory");
        }
    }

    /**
     * Permet de retire un item de son inventaire dans la salle ou l on se trouve
     * @param pNomItemInventaire Nom de l item a retirer de l inventaire
     */
    public boolean drop (final String pNomItemInventaire){
        Item itemFromInventaire = this.aItemList.removeItemInventaire(pNomItemInventaire);
        if (itemFromInventaire == null ) {
            return false ;
        }
        this.aCurrentRoom.aItems.put(pNomItemInventaire, itemFromInventaire );
        aGui.println( " You have in your inventory :" + this.aItemList.getItemsNames());
        this.aItemList.rmPoid(itemFromInventaire.getaPoids());
        return true;

    }
}

