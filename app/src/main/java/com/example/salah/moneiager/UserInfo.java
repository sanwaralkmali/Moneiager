package com.example.salah.moneiager;

public class UserInfo {
    public static final String TABLE_NAME = "UserInfo";

    public static final String COLUMN_UserName = "UserName";
    public static final String COLUMN_UserEmail = "UserEmail";
    public static final String COLUMN_UserIncome = "UserIncome";
    public static final String COLUMN_UserMax = "UserMax";
    public static final String COLUMN_ItemMax = "ItemMax";
    public static final String COLUMN_ToKeep = "ToKeep";

    private String UserName;
    private String UserEmail;
    private int UserIncome;
    private int UserMax;
    private int ItemMax;
    private int ToKeep;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_UserName + " TEXT PRIMARY KEY,"
                    + COLUMN_UserEmail + " TEXT,"
                    + COLUMN_UserIncome + " INTEGER,"
                    + COLUMN_UserMax + " INTEGER,"
                    + COLUMN_ItemMax + " INTEGER,"
                    + COLUMN_ToKeep + " INTEGER"
                    +")";

    public UserInfo() {
    }

    public UserInfo(String UserName, String UserEmail, int UserIncome,
                    int UserMax, int ItemMax, int ToKeep) {
       this.UserName=UserName;
       this.UserEmail=UserEmail;
       this.UserIncome=UserIncome;
       this.UserMax=UserMax;
       this.ItemMax=ItemMax;
       this.ToKeep=ToKeep;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        this.UserEmail = userEmail;
    }

    public int getUserIncome(){
        return UserIncome;

    }
    public void setUserIncome(int userIncome){
        this.UserIncome=userIncome;
    }
    public int getUserMax(){
        return UserMax;

    }
    public void setUserMax(int UserMax){
        this.UserIncome=UserMax;
    }
    public int getItemMax(){
        return ItemMax;

    }
    public void setItemMax(int itemMax){
        this.ItemMax=itemMax;
    }
    public int getToKeep(){
        return ToKeep;

    }
    public void setToKeep(int toKeep){
        this.ToKeep=toKeep;
    }

}
