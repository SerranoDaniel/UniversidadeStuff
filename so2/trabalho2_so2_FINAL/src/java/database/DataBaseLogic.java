package database;

import java.util.ArrayList;
import usables.Allergy;
import usables.Entry;
import usables.User;
import usables.User_allergy;

public interface DataBaseLogic {
    
    //////////////////////////////////////////////////////////////////
    /////////////////////////     CHECK's    /////////////////////////
    //////////////////////////////////////////////////////////////////
    
    public User checkUser(String username, String password);
    public User checkUserName(String username);
    
    //////////////////////////////////////////////////////////////////
    /////////////////////////     ADD's     //////////////////////////
    //////////////////////////////////////////////////////////////////
    
    public Entry addEntry(Entry entry);
    public User addUser(User user, ArrayList<Allergy> allergies);
    public Allergy addAllergy(Allergy allergy);
    public User_allergy addUser_allergy(User_allergy user_allergy);
    
    //////////////////////////////////////////////////////////////////
    /////////////////////////     GET's     //////////////////////////
    //////////////////////////////////////////////////////////////////
    
    public ArrayList<Allergy> getAllAllergy();
    public ArrayList<Entry> getEntryByAllergyID(int allergyID); 
    public ArrayList<Entry> getEntryByUserID(int userID); 
    public int getAllergyId(String allergy);
    public String getAllergyType(int id);
    public ArrayList<Integer> getUserAllergies(int userid);
    
    //////////////////////////////////////////////////////////////////
    /////////////////////////     EDIT's     //////////////////////////
    //////////////////////////////////////////////////////////////////
    
    public User editUser(User user);
    
    //////////////////////////////////////////////////////////////////
    /////////////////////////     DELETE's     //////////////////////////
    //////////////////////////////////////////////////////////////////
    
    public void deleteEntries(ArrayList<Integer> entries);
    public void deleteEntryByID(int entryId);
}
