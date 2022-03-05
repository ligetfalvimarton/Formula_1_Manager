package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainWindow extends JFrame{
    private final JFrame mainWindow;
    private Menu menuPanel;
    private HighScore highScorePanel;
    private NewGame newGamePanel;
    private Tutorial tutorialPanel;

    
    public MainWindow(){ 
        mainWindow = new JFrame("Formula 1 - Manager");
        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainWindow.setSize(1280,720);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
        menuPanel = new Menu(this);
        mainWindow.getContentPane().add(menuPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
        
        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                     null, "Are You Sure to Close Application?", 
                     "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                     JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    JPanel p = new JPanel();
                    try {
                        switchToExit(p);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        mainWindow.addWindowListener(exitListener);
        
    };
    
    public void switchToExit(JPanel p) throws IOException{
        System.exit(0);
    }
    
    public void switchToNewGame(JPanel p){
        mainWindow.remove(p);
        newGamePanel = new NewGame(this);
        mainWindow.getContentPane().add(newGamePanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToTutorial(JPanel p){
        mainWindow.remove(p);
        tutorialPanel = new Tutorial(this);
        mainWindow.getContentPane().add(tutorialPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToHighScore(JPanel p){
        mainWindow.remove(p);
        highScorePanel = new HighScore(this);
        mainWindow.getContentPane().add(highScorePanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToMain(JPanel p){
        mainWindow.remove(p);
        menuPanel = new Menu(this);
        mainWindow.getContentPane().add(menuPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
