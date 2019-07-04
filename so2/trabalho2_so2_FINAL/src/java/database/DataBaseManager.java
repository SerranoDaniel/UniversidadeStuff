package database;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import usables.Allergy;
import usables.Entry;
import usables.User;
import usables.User_allergy;

public class DataBaseManager implements DataBaseLogic {

    Connection con = null;
    Statement stmt = null;

    // deve existir um construtor
    public DataBaseManager(String PG_HOST, String PG_DB, String USER, String PWD) {
        try {
            Class.forName("org.postgresql.Driver");

            // url = "jdbc:postgresql://host:port/database
            con = DriverManager.getConnection("jdbc:postgresql://" + PG_HOST + ":5432/" + PG_DB, USER, PWD);

            stmt = con.createStatement();

            if (stmt != null) {
                System.out.println("Connection Sucess");
            }
        } catch (Exception e) {
            System.err.println("Problems setting the connection!" + e);
        }
    }

    //////////////////////////////////////////////////////////////////
    /////////////////////////     CHECK's    /////////////////////////
    //////////////////////////////////////////////////////////////////
    @Override
    public User checkUser(String username, String password) {
        User user = null;
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM usera WHERE username ='" + username + "' AND password ='" + password + "'");

            if (rs.next() == false) {
                rs.close();
                return user;
            } else {
                user = new User(rs.getString("username"), rs.getString("password"));
                int userID = rs.getInt("userid");
                user.setUserID(userID);
                ArrayList<Allergy> allergies = new ArrayList();
                rs = stmt.executeQuery("SELECT user_allergy.allergyid, allergyType FROM allergy INNER JOIN user_allergy ON (userID ='" + userID + "' AND allergy.allergyID = user_allergy.allergyid)");
                while (rs.next()) {
                    Allergy allergy = new Allergy(rs.getString("allergyType"));
                    allergies.add(allergy);
                }

                user.setAllergies(allergies);

                rs.close();
                return user;
            }
        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - checkUser(username, password): " + e.getMessage());
            return user;
        }
    }
    
    @Override
    public User checkUserName(String username) {
        User user = null;
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM usera WHERE username ='" + username + "'");

            if (rs.next() == false) {
                rs.close();
                return user;
            } else {
                user = new User(rs.getString("username"), rs.getString("password"));
                
                rs.close();
                return user;
            }
        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - checkUser(username, password): " + e.getMessage());
            return user;
        }
    }

    //////////////////////////////////////////////////////////////////
    /////////////////////////     ADD's     //////////////////////////
    //////////////////////////////////////////////////////////////////
    @Override
    public User addUser(User user, ArrayList<Allergy> allergies) {

        try {

            String username = user.getUsername();
            String password = user.getPassword();

            ResultSet rs = stmt.executeQuery("INSERT INTO usera VALUES(DEFAULT, '" + username + "','"
                    + password + "') RETURNING userID");

            rs.next();

            int userID = rs.getInt("userID");

            for (int i = 0; i < allergies.size(); i++) {
                if (allergies.get(i) != null) {

                    stmt.executeUpdate("insert into user_allergy values('" + userID + "', (select allergyid from allergy where allergytype = '" + allergies.get(i).getAllergyType() + "' ));");
                }
            }

            user.setAllergies(allergies);
            rs.close();

            user.setUserID(userID);

            return user;
        } catch (SQLException e) {
            System.err.println("ERRO ao escrever na BD - addUser(user): " + e.getMessage());
        }

        return null;
    }

    @Override
    public Entry addEntry(Entry entry) {

        try {

            float latitude = entry.getLatitude();
            float longitude = entry.getLongitude();
            java.sql.Timestamp entrydate = entry.getEntrydate();
            int allergyID = entry.getAllergyID();
            int userID = entry.getUserID();

            ResultSet rs = stmt.executeQuery("INSERT INTO entries VALUES(DEFAULT, " + latitude + ","
                    + longitude + ",'"
                    + entrydate + "',"
                    + allergyID + ","
                    + userID + ",'') RETURNING entryid");

            rs.next();

            int entryID = rs.getInt("entryID");

            String uniqueCode = "" + entryID + "" + entrydate + "" + userID + "";

            uniqueCode = String.format("%040x", new BigInteger(1, uniqueCode.getBytes()));
            entry.setUniqueCode(uniqueCode);

            stmt.executeUpdate("UPDATE entries SET uniqueCode ='" + uniqueCode + "'WHERE entryID = '" + entryID + "'");

            rs.close();

            entry.setUniqueCode(uniqueCode);

            return entry;
        } catch (SQLException e) {
            System.err.println("ERRO ao escrever na BD - addCoordinates(entry): " + e.getMessage());
        }

        return null;
    }

    @Override
    public Allergy addAllergy(Allergy allergy) {

        try {

            String allergyType = allergy.getAllergyType();

            ResultSet rs = stmt.executeQuery("INSERT INTO allergy VALUES(DEFAULT, '" + allergyType + "') RETURNING allergyID");

            rs.next();

            int allergyID = rs.getInt("allergyID");

            rs.close();

            allergy.setAllergyID(allergyID);

            return allergy;
        } catch (SQLException e) {
            System.err.println("ERRO ao escrever na BD - addAllergy(allergy): " + e.getMessage());
        }

        return null;
    }

    @Override
    public User_allergy addUser_allergy(User_allergy user_allergy) {

        try {

            int userID = user_allergy.getUserID();
            ArrayList<Integer> allergyIDs = user_allergy.getAllergyIDs();

            ResultSet rs = stmt.executeQuery("INSERT INTO user_allergy VALUES(" + userID + ",  ARRAY[" + allergyIDs.get(0) + "," + allergyIDs.get(1) + "," + allergyIDs.get(2) + "," + allergyIDs.get(3) + "])");

            rs.next();

            rs.close();

            return user_allergy;
        } catch (SQLException e) {
            System.err.println("ERRO ao escrever na BD - addUser_Allergy(user_allergy): " + e.getMessage());
        }

        return null;
    }

    //////////////////////////////////////////////////////////////////
    /////////////////////////     GET's     //////////////////////////
    //////////////////////////////////////////////////////////////////
    @Override
    public ArrayList<Allergy> getAllAllergy() {

        try {

            ArrayList<Allergy> allergyList = new ArrayList();

            ResultSet rs = stmt.executeQuery("SELECT * FROM allergy ORDER BY allergyID");

            if (rs.next() == false) {

                rs.close();
                return allergyList;

            } else {

                Allergy allergy1 = new Allergy(rs.getInt("allergyId"), rs.getString("allergyType"));
                allergyList.add(allergy1);

                while (rs.next()) {

                    Allergy allergy2 = new Allergy(rs.getInt("allergyId"), rs.getString("allergyType"));
                    allergyList.add(allergy2);
                }

                rs.close();
                return allergyList;
            }
        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - getAllAllergy(): " + e.getMessage());
        }

        return null;
    }

    @Override
    public ArrayList<Entry> getEntryByAllergyID(int allergyID) {
        try {

            ArrayList<Entry> entryList = new ArrayList();

            ResultSet rs = stmt.executeQuery("SELECT * FROM entries WHERE allergyID = " + allergyID + " ORDER BY entryID");

            if (rs.next() == false) {

                rs.close();
                return entryList;

            } else {

                Entry entry1 = new Entry(rs.getInt("entryID"), rs.getFloat("latitude"), rs.getFloat("longitude"), rs.getTimestamp("entrydate"), rs.getInt("allergyID"));
                entryList.add(entry1);

                while (rs.next()) {

                    Entry entry2 = new Entry(rs.getInt("entryID"), rs.getFloat("latitude"), rs.getFloat("longitude"), rs.getTimestamp("entrydate"), rs.getInt("allergyID"));
                    entryList.add(entry2);
                }

                rs.close();
                return entryList;
            }
        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - getEntryByAllergyID(allergyID): " + e.getMessage());
        }

        return null;
    }

    @Override
    public ArrayList<Entry> getEntryByUserID(int userID) {
        try {

            ArrayList<Entry> entryList = new ArrayList();

            ResultSet rs = stmt.executeQuery("SELECT * FROM entries WHERE userID = " + userID + " ORDER BY entryID");

            if (rs.next() == false) {

                rs.close();
                return entryList;

            } else {

                Entry entry1 = new Entry(rs.getInt("entryID"), rs.getFloat("latitude"), rs.getFloat("longitude"), rs.getTimestamp("entrydate"), rs.getInt("allergyID"), rs.getInt("userID"));
                entry1.setUniqueCode(rs.getString("uniquecode"));
                entryList.add(entry1);

                while (rs.next()) {

                    Entry entry2 = new Entry(rs.getInt("entryID"), rs.getFloat("latitude"), rs.getFloat("longitude"), rs.getTimestamp("entrydate"), rs.getInt("allergyID"), rs.getInt("userID"));
                    entry2.setUniqueCode(rs.getString("uniquecode"));
                    entryList.add(entry2);
                }

                rs.close();
                return entryList;
            }
        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - getEntryByUserID(userID): " + e.getMessage());
        }

        return null;
    }

    @Override
    public int getAllergyId(String allergy) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM allergy WHERE allergytype = '" + allergy + "'");
            rs.next();
            int toReturn = rs.getInt("allergyId");
            rs.close();
            return toReturn;
        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - getAllergyId(allergyId): " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public ArrayList<Integer> getUserAllergies(int userid){
        try {
            ArrayList<Integer> toReturn = new ArrayList();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_allergy WHERE userid = " + userid + "");
            while(rs.next()){
                toReturn.add(rs.getInt("AllergyId"));
            }
            
            rs.close();
            return toReturn;
        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - getAllergyId(allergyId): " + e.getMessage());
            return null;
        }
    }

    @Override
    public String getAllergyType(int id) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM allergy WHERE allergyid = " + id + "");
            rs.next();
            String toReturn = rs.getString("allergytype");
            rs.close();
            return toReturn;
        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - getAllergyType(allergyId): " + e.getMessage());
            return "";
        }
    }

    @Override
    public User editUser(User user) {
        try {
            stmt.executeUpdate("DELETE FROM user_allergy WHERE userid = " + user.getUserID());

            for (int i = 0; i < user.getAllergies().size(); i++) {
                if (user.getAllergies().get(i) != null) {

                    stmt.executeUpdate("insert into user_allergy values('" + user.getUserID() + "', (select allergyid from allergy where allergytype = '" + user.getAllergies().get(i).getAllergyType() + "' ));");
                }
            }

        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - getEditUser(user): " + e.getMessage());
            return null;
        }

        return user;
    }

    @Override
    public void deleteEntries(ArrayList<Integer> entries) {
        try {
            for (int i = 0; i < entries.size(); i++) {
                stmt.executeUpdate("DELETE FROM entries WHERE entryid = " + entries.get(i));
            }

        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - getEditUser(user): " + e.getMessage());
        }
    }
    
    @Override
    public void deleteEntryByID(int entryId) {

        try {

            stmt.executeUpdate("DELETE FROM entries WHERE entryid = " + entryId);

        } catch (SQLException e) {
            System.err.println("ERRO ao ler da BD - deleteEntryByID(entry): " + e.getMessage());
        }
    }

    public void Fechar_BD() throws SQLException {
        if (stmt != null && con != null) {
            stmt.close();
            con.close();
        }
    }

}
