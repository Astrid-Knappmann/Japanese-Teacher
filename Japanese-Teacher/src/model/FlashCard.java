/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Patrick
 */
public class FlashCard {

    private String hiragana;
    private String romaji;
    private String eWord;
    private String kanji;
    private String bundleEWORD;
    private Date dateAnsweredEWORD;
    private String bundleRomaji;
    private Date dateAnsweredRomaji;
    private String bundleHiragana;
    private Date dateAnsweredHiragana;
    private String bundleKanji;
    private Date dateAnsweredKanji;

    public FlashCard(String eWord, String romaji, String hiragana, String kanji) {
        this.hiragana = hiragana;
        this.eWord = eWord;
        this.kanji = kanji;
        this.romaji = romaji;
        bundleEWORD = "Daily";
        dateAnsweredEWORD = new Date(0);
        bundleRomaji = "Daily";
        dateAnsweredRomaji = new Date(0);
        bundleHiragana = "Daily";
        dateAnsweredHiragana = new Date(0);
        bundleKanji = "Daily";
        dateAnsweredKanji = new Date(0);
    }

    public FlashCard(String eWord, String romaji, String hiragana, String kanji, String bundleEWORD, long dateEWORD) {
        this.hiragana = hiragana;
        this.eWord = eWord;
        this.kanji = kanji;
        this.bundleEWORD = bundleEWORD;
        this.dateAnsweredEWORD = new Date(dateEWORD);
    }

    public FlashCard(String eWord, String romaji, String hiragana, String kanji, String bundleEWORD, long dateAnsweredEWORD, String bundleRomaji, long dateAnsweredRomaji, String bundleHiragana, long dateAnsweredHiragana, String bundleKanji, long dateAnsweredKanji) {
        this.hiragana = hiragana;
        this.romaji = romaji;
        this.eWord = eWord;
        this.kanji = kanji;
        this.bundleEWORD = bundleEWORD;
        this.dateAnsweredEWORD = new Date(dateAnsweredEWORD);
        this.bundleRomaji = bundleRomaji;
        this.dateAnsweredRomaji = new Date(dateAnsweredRomaji);
        this.bundleHiragana = bundleHiragana;
        this.dateAnsweredHiragana = new Date(dateAnsweredHiragana);
        this.bundleKanji = bundleKanji;
        this.dateAnsweredKanji = new Date(dateAnsweredKanji);
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    /**
     * This method puts the FlashCard into the next level of bundle, while
     * setting the date answered to the current time. Parameter is an int,
     * depending on what gametype is currently being played. 0 for English. 1
     * for Romaji. 2 for Hiragana. 3 for Kanji
     */
    public String correct(int currentGameType) {
        switch (currentGameType) {

            case (0):
                if (bundleEWORD.equalsIgnoreCase("Daily")) {
                    bundleEWORD = "Weekly";
                } else {
                    bundleEWORD = "Monthly";
                }
                dateAnsweredEWORD = new Date();
                return bundleEWORD;

            case (1):
                if (bundleRomaji.equalsIgnoreCase("Daily")) {
                    bundleRomaji = "Weekly";
                } else {
                    bundleRomaji = "Monthly";
                }
                dateAnsweredRomaji = new Date();
                return bundleEWORD;

            case (2):
                if (bundleHiragana.equalsIgnoreCase("Daily")) {
                    bundleHiragana = "Weekly";
                } else {
                    bundleHiragana = "Monthly";
                }
                dateAnsweredHiragana = new Date();
                return bundleEWORD;

            case (3):
                if (bundleKanji.equalsIgnoreCase("Daily")) {
                    bundleKanji = "Weekly";
                } else {
                    bundleKanji = "Monthly";
                }
                dateAnsweredKanji = new Date();
                return bundleEWORD;
        }
        return null;
    }

    /**
     * This method puts the FlashCard into the Daily bundle, while setting the
     * date answered to the current time. Parameter is an int, depending on what
     * gametype is currently being played. 0 for English. 1 for Romaji. 2 for
     * Hiragana. 3 for Kanji
     */
    public void wrong(int currentGameType) {
        switch (currentGameType) {
            case (0):
                bundleEWORD = "Daily";
                dateAnsweredEWORD = new Date();
                break;

            case (1):
                bundleRomaji = "Daily";
                dateAnsweredRomaji = new Date();
                break;

            case (2):
                bundleHiragana = "Daily";
                dateAnsweredHiragana = new Date();
                break;

            case (3):
                bundleKanji = "Daily";
                dateAnsweredKanji = new Date();
                break;
        }
    }

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String geteWord() {
        return eWord;
    }

    public void seteWord(String eWord) {
        this.eWord = eWord;
    }

    public String getBundleEWORD() {
        return bundleEWORD;
    }

    public void setBundleEWORD(String bundleEWORD) {
        this.bundleEWORD = bundleEWORD;
    }

    public Date getDateAnsweredEWORD() {
        return dateAnsweredEWORD;
    }

    public void setDateAnsweredEWORD(Date dateAnsweredEWORD) {
        this.dateAnsweredEWORD = dateAnsweredEWORD;
    }

    public String getBundleRomaji() {
        return bundleRomaji;
    }

    public void setBundleRomaji(String bundleRomaji) {
        this.bundleRomaji = bundleRomaji;
    }

    public Date getDateAnsweredRomaji() {
        return dateAnsweredRomaji;
    }

    public void setDateAnsweredRomaji(Date dateAnsweredRomaji) {
        this.dateAnsweredRomaji = dateAnsweredRomaji;
    }

    public String getBundleHiragana() {
        return bundleHiragana;
    }

    public void setBundleHiragana(String bundleHiragana) {
        this.bundleHiragana = bundleHiragana;
    }

    public Date getDateAnsweredHiragana() {
        return dateAnsweredHiragana;
    }

    public void setDateAnsweredHiragana(Date dateAnsweredHiragana) {
        this.dateAnsweredHiragana = dateAnsweredHiragana;
    }

    public String getBundleKanji() {
        return bundleKanji;
    }

    public void setBundleKanji(String bundleKanji) {
        this.bundleKanji = bundleKanji;
    }

    public Date getDateAnsweredKanji() {
        return dateAnsweredKanji;
    }

    public void setDateAnsweredKanji(Date dateAnsweredKanji) {
        this.dateAnsweredKanji = dateAnsweredKanji;
    }
    
    
}
