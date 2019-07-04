package usables;

public class Entry {
    
    // ----- Usable vars -----
    private int EntryID;
    private float latitude;
    private float longitude;
    private java.sql.Timestamp entrydate;
    private int allergyID;
    private int userID;
    private String uniqueCode;
    
    // ----- Constructor -----
    public Entry(float latitude, float longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Entry(float latitude, float longitude, java.sql.Timestamp entrydate, int allergyID, int userID){
        this.latitude = latitude;
        this.longitude = longitude;
        this.entrydate = entrydate;
        this.allergyID = allergyID;
        this.userID = userID;
    }
    
    public Entry(int EntryID, float latitude, float longitude, java.sql.Timestamp entrydate, int allergyID){
        this.EntryID = EntryID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.entrydate = entrydate;
        this.allergyID = allergyID;
    }
    
    public Entry(int EntryID, float latitude, float longitude, java.sql.Timestamp entrydate, int allergyID, int userID){
        this.EntryID = EntryID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.entrydate = entrydate;
        this.allergyID = allergyID;
        this.userID = userID;
    }
    
    // ----- Get Vars  -----
    public int getEntryID(){
        return EntryID;
    }
    
    public float getLatitude(){
        return latitude;
    }
    
    public float getLongitude(){
        return longitude;
    }
    
    public java.sql.Timestamp getEntrydate(){
        return entrydate;
    }
    
    public int getAllergyID(){
        return allergyID;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public String getUniqueCode(){
        return uniqueCode;
    }
    
    // ----- Set Vars  -----
    public void setEntryID(int EntryID){
        this.EntryID = EntryID;
    }
    
    public void setLatitude(float latitude){
        this.latitude = latitude;
    }
    
    public void setLongitude(float longitude){
        this.longitude = longitude;
    }
    
    public void setEntrydate(java.sql.Timestamp entrydate){
        this.entrydate = entrydate;
    }
    
    public void setAllergyID(int allergyID){
        this.allergyID = allergyID;
    }
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public void setUniqueCode(String uniqueCode){
        this.uniqueCode = uniqueCode;
    }
}
