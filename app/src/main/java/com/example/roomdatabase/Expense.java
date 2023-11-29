package com.example.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense")
public class Expense {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "amount")
    private String amount;

    Expense(int id, String title, String amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    @Ignore
    Expense(String title, String amount) {
        this.title = title;
        this.amount = amount;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

//@Entity(tableName = "expense"): Indicates that this class represents an entity (table) in the Room database, and the table name is "expense".
//@PrimaryKey(autoGenerate = true): Specifies that the id field is the primary key and should be auto-generated.
//@ColumnInfo(name = "title"): Specifies the column name for the title field in the database.
//@ColumnInfo(name = "amount"): Specifies the column name for the amount field in the database.
//then generate constructor and getters and setters