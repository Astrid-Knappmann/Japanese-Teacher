package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PK
 */
public class FileHandler {

    private final String flashCardFolder = "flashcards";
    private final File flashCardList = new File(flashCardFolder + "/flashcards.data");

    public FileHandler() {
        makeFolders();
    }

    /**
     * Creates necesarry folders to store local files.
     */
    private void makeFolders() {
        File flashCardStorage = new File(flashCardFolder);
        flashCardStorage.mkdir();
    }

    public void saveFlashCards(ArrayList<FlashCard> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(flashCardList);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException | NullPointerException ex) {
            }
        }
    }

    public ArrayList<FlashCard> loadFlashCards() {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        ArrayList<FlashCard> flashCards = null;
        try {
            flashCards = new ArrayList<>();
            fis = new FileInputStream(flashCardList);
            ois = new ObjectInputStream(fis);
            flashCards = (ArrayList<FlashCard>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException | NullPointerException ex) {
            }
        }
        return flashCards;

    }

}
