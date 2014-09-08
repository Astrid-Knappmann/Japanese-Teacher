/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FlashCard;

/**
 *
 * @author Patrick
 */
public class FlashCardDAO {
//
//    private Connection dbConn;
//
//    public FlashCardDAO(Connection dbConn) {
//        this.dbConn = dbConn;
//    }
//
//    //unused
//    public FlashCard getFlashCard(String eWord, String user) {
//        try {
//            Statement st = dbConn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM FlashCard" + user + " WHERE eWord='" + eWord + "'");
//            rs.next();
//            String[] hiragana = rs.getString(3).split("-");
//            byte[] hiraganaArray = null;
//            for (int i = 1; i < hiragana.length; i++) {
//                if (hiraganaArray == null) {
//                    hiraganaArray = new byte[hiragana.length];
//                }
//                byte b = Byte.valueOf("-" + hiragana[i]);
//                hiraganaArray[i] = b;
//            }
//            String newHira = new String(hiraganaArray, "UTF-8");
//
//            String[] kanji = rs.getString(4).split("-");
//            byte[] kanjiArray = null;
//            for (int i = 1; i < kanji.length; i++) {
//                if (kanjiArray == null) {
//                    kanjiArray = new byte[kanji.length];
//                }
//                byte b = Byte.valueOf("-" + kanji[i]);
//                kanjiArray[i] = b;
//            }
//            String newKanji = new String(kanjiArray, "UTF-8");
//            FlashCard f = new FlashCard(rs.getString(1), rs.getString(2), newHira, newKanji, rs.getString(5), Long.parseLong(rs.getString(6)), rs.getString(7), Long.parseLong(rs.getString(8)), rs.getString(9), Long.parseLong(rs.getString(10)), rs.getString(11), Long.parseLong(rs.getString(12)));
//            return f;
//        } catch (SQLException ex) {
//            Logger.getLogger(FlashCardDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(FlashCardDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
//
//    public ArrayList<FlashCard> getAllFlashCards(String user) {
//        try {
//            Statement st = dbConn.createStatement();
//            ArrayList<FlashCard> list = new ArrayList<>();
//            ResultSet rs = st.executeQuery("SELECT * FROM FlashCard" + user);
//            while (rs.next()) {
//                String[] hiragana = rs.getString(3).split("-");
//                byte[] hiraganaArray = null;
//                for (int i = 1; i < hiragana.length; i++) {
//                    if (hiraganaArray == null) {
//                        hiraganaArray = new byte[hiragana.length];
//                    }
//                    byte b = Byte.valueOf("-" + hiragana[i]);
//                    hiraganaArray[i] = b;
//                }
//                String newHira = new String(hiraganaArray, "UTF-8");
//
//                String[] kanji = rs.getString(4).split("-");
//                byte[] kanjiArray = null;
//                for (int i = 1; i < kanji.length; i++) {
//                    if (kanjiArray == null) {
//                        kanjiArray = new byte[kanji.length];
//                    }
//                    byte b = Byte.valueOf("-" + kanji[i]);
//                    kanjiArray[i] = b;
//                }
//                String newKanji = new String(kanjiArray, "UTF-8");
//                FlashCard f = new FlashCard(rs.getString(1), rs.getString(2), newHira, newKanji, rs.getString(5), Long.parseLong(rs.getString(6)), rs.getString(7), Long.parseLong(rs.getString(8)), rs.getString(9), Long.parseLong(rs.getString(10)), rs.getString(11), Long.parseLong(rs.getString(12)));
//                list.add(f);
//            }
//            return list;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(FlashCardDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(FlashCardDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
//
//    public void createFlashCard(FlashCard f) {
//        try {
//            Statement st = dbConn.createStatement();
//            String hiragana = "";
//            byte[] hiraganaarray = f.getHiragana().getBytes("UTF-8");
//            for (byte b : hiraganaarray) {
//                hiragana += b;
//            }
//            String kanji = "";
//            byte[] kanjiarray = f.getKanji().getBytes("UTF-8");
//            for (byte b : kanjiarray) {
//                kanji += b;
//            }
//            st.execute("INSERT INTO FlashCardPatrick (eWord, romaji, hiragana, kanji, bundleEWord, dateAnsweredEWord, bundleRomaji, dateAnsweredRomaji, bundleHiragana, dateAnsweredHiragana, bundleKanji, dateAnsweredKanji) VALUES ('" + f.geteWord() + "', '" + f.getRomaji() + "', '" + hiragana + "', '" + kanji + "', '" + f.getBundleEWORD() + "', '" + f.getDateAnsweredEWORD().getTime() + "', '" + f.getBundleRomaji() + "', '" + f.getDateAnsweredRomaji().getTime() + "', '" + f.getBundleHiragana() + "', '" + f.getDateAnsweredHiragana().getTime() + "', '" + f.getBundleKanji() + "', '" + f.getDateAnsweredKanji().getTime() + "')");
//            st.execute("INSERT INTO FlashCardTrine (eWord, romaji, hiragana, kanji, bundleEWord, dateAnsweredEWord, bundleRomaji, dateAnsweredRomaji, bundleHiragana, dateAnsweredHiragana, bundleKanji, dateAnsweredKanji) VALUES ('" + f.geteWord() + "', '" + f.getRomaji() + "', '" + hiragana + "', '" + kanji + "', '" + f.getBundleEWORD() + "', '" + f.getDateAnsweredEWORD().getTime() + "', '" + f.getBundleRomaji() + "', '" + f.getDateAnsweredRomaji().getTime() + "', '" + f.getBundleHiragana() + "', '" + f.getDateAnsweredHiragana().getTime() + "', '" + f.getBundleKanji() + "', '" + f.getDateAnsweredKanji().getTime() + "')");
//        } catch (SQLException ex) {
//            Logger.getLogger(FlashCardDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(FlashCardDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void resetCard(FlashCard f, String user){
//        try {
//            Statement st = dbConn.createStatement();
//            st.execute("UPDATE FlashCard" + user + " SET bundleEWord='Daily',dateAnsweredEWord=0,bundleRomaji='Daily',dateAnsweredRomaji=0,bundleHiragana='Daily',dateAnsweredHiragana=0,bundleKanji='Daily',dateAnsweredKanji=0 WHERE eWord ='" + f.geteWord() + "'");
//        } catch (SQLException ex) {
//            Logger.getLogger(FlashCardDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//
//    public void correct(FlashCard f, int gameType, String user, String bundle) {
//        try {
//            Statement st = dbConn.createStatement();
//            Date date = new Date();
//            String type = null;
//            switch (gameType) {
//                case (0):
//                    type = "EWord";
//                    break;
//                case (1):
//                    type = "Romaji";
//                    break;
//                case (2):
//                    type = "Hiragana";
//                    break;
//                case (3):
//                    type = "Kanji";
//                    break;
//
//            }
//            st.execute("UPDATE FlashCard" + user + " SET bundle" + type + "='" + bundle + "',dateAnswered" + type + "=" + date.getTime() + " WHERE eWord='" + f.geteWord() + "'");
//        } catch (SQLException ex) {
//            Logger.getLogger(FlashCardDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    public void wrong(FlashCard f, int gameType, String user) {
//        try {
//            Statement st = dbConn.createStatement();
//            Date date = new Date();
//            String type = null;
//            switch (gameType) {
//                case (0):
//                    type = "EWord";
//                    break;
//                case (1):
//                    type = "Romaji";
//                    break;
//                case (2):
//                    type = "Hiragana";
//                    break;
//                case (3):
//                    type = "Kanji";
//                    break;
//
//            }
//            st.execute("UPDATE FlashCard" + user + " SET bundle" + type + "='Daily',dateAnswered" + type + "=" + date.getTime() + " WHERE eWord='" + f.geteWord() + "'");
//        } catch (SQLException ex) {
//            Logger.getLogger(FlashCardDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
