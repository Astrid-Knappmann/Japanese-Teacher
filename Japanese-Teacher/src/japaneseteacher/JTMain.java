/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package japaneseteacher;

import DAO.FlashCardDAO;
import GUI.AddFlashCardGUI;
import GUI.FlashCardGUI;
import GUI.FlashCards;
import GUI.ResetCardGUI;
import Util.DBUtil;
import handlers.FCHandler;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FlashCard;
import model.FlashCardCatalog;

/**
 *
 * @author Patrick
 */
public class JTMain {

    private FlashCardGUI fCGUI;
    private FlashCards flashCards;
    private AddFlashCardGUI addGUI;
    private FCHandler fCHandler;
    private FlashCardCatalog fCC;
    private FlashCardDAO fCDAO;
    private ResetCardGUI resetGUI;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JTMain jt = new JTMain();
        jt.fCGUI.setVisible(true);

    }

    public JTMain() { 
            Connection dbConn = DBUtil.getInstance();
            fCDAO = new FlashCardDAO(dbConn);
            fCC = new FlashCardCatalog(fCDAO);
            fCHandler = new FCHandler(fCC);
            flashCards = new FlashCards(fCGUI, true, fCHandler);
            addGUI = new AddFlashCardGUI(fCGUI, true, fCHandler);
            resetGUI = new ResetCardGUI(fCGUI, true, fCHandler);
            fCGUI = new FlashCardGUI(flashCards, fCHandler, addGUI, resetGUI);
//            fCC.create("yes", "hai", "はい", "犬");
//            fCC.create("no", "iie", "いいえ", "猫");
//            fCC.create("Friend", "tomodachi", "ともだち", "友達");
//            fCC.add(fCDAO.getFlashCard("yes", "Patrick"));
//            fCC.add(fCDAO.getFlashCard("no", "Patrick"));
//            fCC.add(fCDAO.getFlashCard("friend", "Patrick"));
//            System.out.println(fCC.getFlashCard("yes").getHiragana());
        
    }
}
