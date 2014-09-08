/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;


import model.FlashCard;
import model.FlashCardCatalog;

/**
 *
 * @author Patrick
 */
public class FCHandler {
    
    private FlashCardCatalog fCC;

    public FCHandler(FlashCardCatalog fCC) {
        this.fCC = fCC;
    }
    
    public void create(String eWord, String romaji, String hiragana, String kanji) {
        fCC.create(eWord, romaji, hiragana, kanji);
    }
    
    public void remove(String eWord){
        fCC.remove(eWord);
    }
    
    public FlashCard nextCardEWORD(){
        return fCC.nextCardEWORD();
    }
    
    public FlashCard getFlashCard(String eWord){
        return fCC.getFlashCard(eWord);
    }
    
    public void loadFlashCards(String user){
        fCC.loadFlashCards(user);
    }
    
    public void correct(FlashCard f, int gameType, String user){
        fCC.correct(f, gameType, user);
    }
    
    public void wrong(FlashCard f, int gameType, String user){
        fCC.wrong(f, gameType, user);
    }
    
    public void resetAllCards(String user){
        fCC.resetAllCards(user);
    }
    
}
