package com.example.salah.moneiager;

public class historyModel {
    public static final String TABLE_NAME = "history";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTE = "description";
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
                    + COLUMN_NOTE + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + COLUMN_PRICE + " INTEGER"
                    +")";

    public historyModel() {
    }

    public historyModel(int id, String note, String timestamp,int price) {
        this.id = id;
        this.description = note;
        this.timestamp = timestamp;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return description;
    }

    public void setNote(String note) {
        this.description = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int id) {
        this.price = id;
    }

}
