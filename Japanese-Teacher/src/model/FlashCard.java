/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Patrick
 */
public class FlashCard implements Serializable {

    private String hiragana;
    private String romaji;
    private String english;
    private String kanji;
    private String description;
    private HashMap<String, ArrayList<HashMap<String, ?>>> dataList;

    public FlashCard(String eWord, String romaji, String hiragana, String kanji, String description) {
        this.hiragana = hiragana;
        this.english = eWord;
        this.kanji = kanji;
        this.romaji = romaji;
        this.description = description;
        dataList = new HashMap<>();
    }

    public FlashCard(String hiragana, String romaji, String english, String kanji, String description, HashMap<String, ArrayList<HashMap<String, ?>>> dataList) {
        this.hiragana = hiragana;
        this.romaji = romaji;
        this.english = english;
        this.kanji = kanji;
        this.description = description;
        this.dataList = dataList;
    }

    public void newUser(String user) {
        ArrayList<HashMap<String, ?>> arrayList = new ArrayList<>();
        HashMap<String, String> bundleMap = new HashMap<>();
        HashMap<String, Long> timeAnsweredMap = new HashMap<>();
        arrayList.add(bundleMap);
        arrayList.add(timeAnsweredMap);
        dataList.put(user, arrayList);
    }

    public void firstTimeMode(String user, String mode) {
        ArrayList<HashMap<String, ?>> arrayList = dataList.get(user);
        HashMap<String, String> bundleMap = (HashMap<String, String>) arrayList.get(0);
        HashMap<String, Long> timeAnsweredMap = (HashMap<String, Long>) arrayList.get(1);
        bundleMap.put(mode, "Daily");
        timeAnsweredMap.put(mode, 0l);
    }

    /**
     * This method puts the FlashCard into the next level of bundle, while
     * setting the date answered to the current time.
     *
     * @param user
     * @param mode
     * @return New bundle.
     */
    public String correct(String user, String mode) {
        String bundle = getBundle(user, mode);
        getTimeAnsweredMap(user, mode).put(mode, new Date().getTime());
        if (bundle.equalsIgnoreCase("Daily")) {
            getBundleMap(user, mode).put(mode, "Weekly");
            return "Weekly";
        } else {
            getBundleMap(user, mode).put(mode, "Monthly");
            return "Monthly";
        }
    }

    /**
     * This method puts the FlashCard into the Daily bundle, while setting the
     * date answered to the current time.
     *
     * @param user
     * @param mode
     */
    public void wrong(String user, String mode) {
        getTimeAnsweredMap(user, mode).put(mode, new Date().getTime());
        getBundleMap(user, mode).put(mode, "Daily");
    }

    public void resetCard(String user) {
        dataList.remove(user);
    }

    public void resetCard() {
        dataList.clear();
    }

    public HashMap<String, String> getBundleMap(String user, String mode) {
        return (HashMap<String, String>) dataList.get(user).get(0);
    }

    public HashMap<String, Long> getTimeAnsweredMap(String user, String mode) {
        return (HashMap<String, Long>) dataList.get(user).get(1);
    }

    public String getBundle(String user, String mode) {
        return (String) dataList.get(user).get(0).get(mode);
    }

    public Long getTimeAnswered(String user, String mode) {
        return (Long) dataList.get(user).get(1).get(mode);
    }

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FlashCard{" + "hiragana=" + hiragana + ", romaji=" + romaji + ", english=" + english + ", kanji=" + kanji + ", description=" + description + '}';
    }

}
