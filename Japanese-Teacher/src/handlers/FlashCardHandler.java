/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.util.ArrayList;
import model.FlashCard;
import model.FlashCardCatalog;
import model.FlashCardList;

/**
 *
 * @author Patrick
 */
public class FlashCardHandler {

    private final FlashCardCatalog flashCardCatalog;

    public FlashCardHandler(FlashCardCatalog flashCardCatalog) {
        this.flashCardCatalog = flashCardCatalog;
    }

    public void create(String english, String romaji, String hiragana, String kanji, String description) {
        flashCardCatalog.create(english, romaji, hiragana, kanji, description);
    }

    public void remove(String english) {
        flashCardCatalog.remove(english);
    }

    public FlashCardList getPendingFlashCards(String user, String mode) {
        return flashCardCatalog.getPendingFlashCards(user, mode);
    }

    public FlashCard getFlashCard(String english) {
        return flashCardCatalog.getFlashCard(english);
    }

    public ArrayList<FlashCard> getFlashCards() {
        return flashCardCatalog.getFlashCards();
    }

    public void correct(FlashCard f, String user, String mode) {
        flashCardCatalog.correct(f, user, mode);
    }

    public void wrong(FlashCard f, String user, String mode) {
        flashCardCatalog.wrong(f, user, mode);
    }

    public void resetCardsForUser(String user) {
        flashCardCatalog.resetCardsForUser(user);
    }

    public void resetCardsForAllUsers() {
        flashCardCatalog.resetCardsForAllUsers();
    }

}
