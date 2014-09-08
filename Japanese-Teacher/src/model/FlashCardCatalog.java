/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.FlashCardDAO;
import handlers.FCHandler;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Patrick
 */
public class FlashCardCatalog {

    private ArrayList<FlashCard> FCC;
    private FlashCardDAO fCDAO;

    public FlashCardCatalog(FlashCardDAO fCDAO) {
        FCC = new ArrayList<>();
        this.fCDAO = fCDAO;
    }

    public void create(String eWord, String romaji, String hiragana, String kanji) {
        FlashCard f = new FlashCard(eWord, romaji, hiragana, kanji);
        fCDAO.createFlashCard(f);
    }

    public void add(FlashCard f) {
        FCC.add(f);
    }

    public void remove(String eWord) {
        for (FlashCard f : FCC) {
            if (f.geteWord().equalsIgnoreCase(eWord)) {
                FCC.remove(f);
                break;
            }
        }
    }

    public FlashCard nextCardEWORD() {
        Date currentDate = new Date();
        Date dateAnswered;
        for (FlashCard f : FCC) {
            dateAnswered = f.getDateAnsweredEWORD();
            switch (f.getBundleEWORD()) {
                case "Daily":
                    if (currentDate.getTime() - dateAnswered.getTime() > 43200000L) {
                        return f;
                    }
                    break;
                case "Weekly":
                    if (currentDate.getTime() - dateAnswered.getTime() > 561600000L) {
                        return f;
                    }
                    break;
                case "Monthly":
                    if (currentDate.getTime() - dateAnswered.getTime() > 2548800000L) {
                        return f;
                    }
                    break;
            }
        }

        return null;
    }

    public FlashCard getFlashCard(String eWord) {
        for (FlashCard f : FCC) {
            if (f.geteWord().equalsIgnoreCase(eWord)) {
                return f;
            }

        }
        return null;
    }

    public void loadFlashCards(String user) {
        FCC = fCDAO.getAllFlashCards(user);
    }

    public void correct(FlashCard f, int gametype, String user) {
        fCDAO.correct(f, gametype, user, f.correct(gametype));
    }

    public void wrong(FlashCard f, int gametype, String user) {
        fCDAO.wrong(f, gametype, user);
        f.wrong(gametype);
    }
    
    public void resetAllCards(String user){
        ArrayList<FlashCard> list = fCDAO.getAllFlashCards(user);
        for(FlashCard f : list){
            fCDAO.resetCard(f, user);
        }
    }
}
