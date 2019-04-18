import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author DELATTE Laurent
 * @version 1.0
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private JButton    aButtonNorth;
    private JButton    aButtonEast;
    private JButton    aButtonSouth;
    private JButton    aButtonWest;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param pGameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();

    } // UserInterface(.)
    
    /**
     * Print out some text into the text area.
     * @param pText texte à afficher
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     * @param pText texte à afficher
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Show an image file in the interface.
     * @param pImageName "lien" de l'image
     */
    public void showImage( final String pImageName )
    {
        URL vImageURL = this.getClass().getClassLoader().getResource( pImageName );
        if ( vImageURL == null )
            System.out.println( "image not found" );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the input field.
     * @param pOnOff bolleen pour activer ou non
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff );
        if ( ! pOnOff )
            this.aEntryField.getCaret().setBlinkRate( 0 );
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "2184" );
        this.aEntryField = new JTextField( 34 );

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        JPanel vPanel = new JPanel();
        JPanel vPanelDirection = new JPanel();//initialisation du panel de direction

        this.aImage = new JLabel();

        //initialisation des buttons de déplacement

        this.aButtonNorth = new JButton ("north");
        this.aButtonEast = new JButton ("east");
        this.aButtonSouth = new JButton ("south");
        this.aButtonWest = new JButton ("west");

        //panel principale
        vPanel.setLayout( new BorderLayout() );
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add(vPanelDirection, BorderLayout.WEST);

        //Panel gauche
        vPanelDirection.setLayout(new BorderLayout());
        vPanelDirection.add( aButtonNorth, BorderLayout.NORTH);
        vPanelDirection.add( aButtonEast, BorderLayout.EAST);
        vPanelDirection.add( aButtonSouth, BorderLayout.SOUTH);
        vPanelDirection.add( aButtonWest, BorderLayout.WEST);

        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aMyFrame.addWindowListener( new WindowAdapter() {
                public void windowClosing(WindowEvent e) { System.exit(0); }
            } );
         //ajoute le action listener (qui permet de savoir si il se passe quelque chose quand est ce qu'on a appuyé sur le bouton)
        this.aEntryField.addActionListener( this );
        this.aButtonNorth.addActionListener ( this );
        this.aButtonEast.addActionListener ( this );
        this.aButtonSouth.addActionListener ( this );
        this.aButtonWest.addActionListener ( this );

        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     * @param pE Action récupérée par les listener
     */
    public void actionPerformed( final ActionEvent pE ) 
    {
        Object vSource = pE.getSource();
        if (vSource == aEntryField){
            this.processCommand();
        }

        if ( vSource == aButtonNorth ){
            aEngine.interpretCommand("go north");
        }

        if ( vSource == aButtonEast ){
            aEngine.interpretCommand("go east");
        }

        if ( vSource == aButtonSouth ){
            aEngine.interpretCommand("go south");
        }

        if ( vSource == aButtonWest ){
            aEngine.interpretCommand("go west");
        }
    } // actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
} // UserInterface 
