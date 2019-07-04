package usables;

import java.util.ArrayList;

public class User_allergy {
        
    // ----- Usable vars -----
    private int userID;
    private ArrayList<Integer> allergyIDs;

    // ----- Constructor -----
    public User_allergy(int userID, ArrayList allergyIDs){
        this.userID = userID;
        this.allergyIDs = (ArrayList<Integer>) allergyIDs.clone();
    }
    
    // ----- Get Vars  -----
    public int getUserID(){
        return userID;
    }
    
    public ArrayList<Integer> getAllergyIDs(){
        return allergyIDs;
    }
    
    // ----- Set Vars  -----
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public void setAllergyIDs( ArrayList<Integer> allergyIDs){
        this.allergyIDs = (ArrayList<Integer>) allergyIDs.clone();
    }
}
