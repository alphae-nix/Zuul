
import java.util.HashMap;
/**
 * Cette classe permet de gérer le jeu
 * @author DELATTE Laurent
 * @version 1.0
 */
public class Game { 
    private UserInterface gui;
    private GameEngine engine;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        engine = new GameEngine();
        gui = new UserInterface(engine);
        engine.setGUI(gui);
    } // Constructeur par Défaut

} // Game
