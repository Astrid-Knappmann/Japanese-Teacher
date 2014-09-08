/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.FlashCardDAO;
import handlers.FlashCardHandler;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Patrick
 */
public class FlashCardCatalog {

    private ArrayList<FlashCard> flashCards;
    private final FileHandler fileHandler;

    public FlashCardCatalog(FileHandler fileHandler) {
        flashCards = new ArrayList<>();
        this.fileHandler = fileHandler;
        flashCards = fileHandler.loadFlashCards();
    }

    public void create(String english, String romaji, String hiragana, String kanji, String description) {
        if (getFlashCard(english) == null) {
            FlashCard f = new FlashCard(english, romaji, hiragana, kanji, description);
            flashCards.add(f);
            saveFlashCards();
        }
    }

    public void add(FlashCard f) {
        if (getFlashCard(f.getEnglish()) == null) {
            flashCards.add(f);
            saveFlashCards();
        }
    }

    public void remove(String english) {
        for (FlashCard f : flashCards) {
            if (f.getEnglish().equalsIgnoreCase(english)) {
                flashCards.remove(f);
                break;
            }
        }
        saveFlashCards();
    }

    public FlashCardList getPendingFlashCards(String user, String mode) {
        FlashCardList list = new FlashCardList();
        long currentTime = new Date().getTime();
        for (FlashCard f : flashCards) {
            String bundle = f.getBundle(user, mode);
            switch (bundle) {
                case "Daily":
                    if (currentTime - f.getTimeAnswered(user, mode) > 43200000l) {
                        list.add(f);
                    }
                    break;
                case "Weekly":
                    if (currentTime - f.getTimeAnswered(user, mode) > 561600000l) {
                        list.add(f);
                    }
                    break;
                case "Monthly":
                    if (currentTime - f.getTimeAnswered(user, mode) > 2548800000l) {
                        list.add(f);
                    }
                    break;
                default:
                    System.out.println("Bundle data corrupt");
                    break;
            }
        }
        return list;
    }

    public void saveFlashCards() {
        fileHandler.saveFlashCards(flashCards);
    }

    public FlashCard getFlashCard(String english) {
        for (FlashCard f : flashCards) {
            if (f.getEnglish().equalsIgnoreCase(english)) {
                return f;
            }
        }
        return null;
    }

    public void loadFlashCards() {
        flashCards = fileHandler.loadFlashCards();
    }

    public void correct(FlashCard f, String user, String mode) {
        f.correct(user, mode);
        saveFlashCards();
    }

    public void wrong(FlashCard f, String user, String mode) {
        f.wrong(user, mode);
        saveFlashCards();
    }

    public void resetCardsForUser(String user) {
        for (FlashCard f : flashCards) {
            f.resetCard(user);
        }
        saveFlashCards();
    }

    public void resetCardsForAllUsers() {
        for (FlashCard f : flashCards) {
            f.resetCard();
        }
        saveFlashCards();
    }

    public ArrayList<FlashCard> getFlashCards() {
        return flashCards;
    }

}
