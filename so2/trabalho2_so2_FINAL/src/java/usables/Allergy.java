package usables;

public class Allergy {
    
    // ----- Usable vars -----
    private int allergyID;
    private String allergyType;

    // ----- Constructor -----
    public Allergy(String allergyType){
        this.allergyType = allergyType;
    }
    
    public Allergy(int allergyID, String allergyType){
        this.allergyID = allergyID;
        this.allergyType = allergyType;
    }
    
    // ----- Get Vars  -----
    public int getAllergyID(){
        return allergyID;
    }
    
    public String getAllergyType(){
        return allergyType;
    }
    
    // ----- Set Vars  -----
    public void setAllergyID(int allergyID){
        this.allergyID = allergyID;
    }
    
    public void setAllergyType(String allergyType){
        this.allergyType = allergyType;
    }
}
