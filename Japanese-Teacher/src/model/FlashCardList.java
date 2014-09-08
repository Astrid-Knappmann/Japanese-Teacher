package model;

import java.util.ArrayList;

/**
 *
 * @author PK
 */
public class FlashCardList extends ArrayList<FlashCard> {

    private int nextCard = 0;

    public FlashCard getNextCard() {
        FlashCard f = null;
        try {
            f = get(nextCard);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No more pending cards");
            nextCard = 0;
            return f;
        }
        nextCard++;
        return f;
    }

}
