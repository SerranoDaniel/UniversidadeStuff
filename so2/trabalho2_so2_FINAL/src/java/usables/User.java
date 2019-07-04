package usables;

import java.util.ArrayList;

public class User {

    // ----- Usable vars -----
    private int userID;
    private String username;
    private String password;
    private ArrayList<Allergy> allergies = new ArrayList();

    // ----- Constructor -----
    public User(String username, String password, ArrayList<Allergy> allergies){
        this.username = username;
        this.password = password;
        for(int i =0; i<allergies.size(); i++){
            allergies.add(allergies.get(i));
        }
    }
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    // ----- Get Vars  -----
    public int getUserID(){
        return userID;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }


    public ArrayList<Allergy> getAllergies(){
        return allergies;
    }

    // ----- Set Vars  -----
    public void setUserID(int userID){
        this.userID = userID;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }


    public void setAllergies(ArrayList<Allergy> allergies){
        this.allergies.clear();
        for(int i =0; i<allergies.size(); i++){
            this.allergies.add(allergies.get(i));
        };
    }
}