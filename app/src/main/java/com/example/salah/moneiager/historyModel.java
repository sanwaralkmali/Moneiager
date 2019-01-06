package com.example.salah.moneiager;

public class historyModel {
    public static final String TABLE_NAME = "history";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_PRICE = "price";

    private int id;
    private String description;
    private String timestamp;
    private int price;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_DESCRIPTION + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATE DEFAULT CURRENT_DATE,"
                    + COLUMN_PRICE + " INTEGER"
                    +")";

    public historyModel() {
    }

    public historyModel(int id, String description, String timestamp,int price) {
        this.id = id;
        this.description = description;
        this.timestamp = timestamp;
        this.price=price;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {
        this.description = description;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

}
