package com.example.roomdatabase;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Expense.class, exportSchema = false, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DB_Name = "expensedb";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getDB(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, DatabaseHelper.class, DB_Name)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
            Log.d("DatabaseHelper", "Database created successfully");

        }
        return instance;
    }

    public abstract ExpenseDao expenseDao();
}



//should have @database,abstract class,extends roomdatabase,includes list of entities,
//should contain an abstract method that has 0 arguments

//@Database(entities = Expense.class, exportSchema = false, version = 1):
// Specifies that the database includes the Expense entity, sets schema export to false, and defines the version as 1.
//private static final String DB_Name = "expensedb";: Defines the name of the database.
//private static DatabaseHelper instance;: Holds a singleton instance of the database.
//public static synchronized DatabaseHelper getDB(Context context) {...}:
//
//if (instance == null) {...}: Creates a new database instance using the Room database builder if it doesn't exist.
//.fallbackToDestructiveMigration(): Allows Room to recreate the database tables if the version is incremented.
//.allowMainThreadQueries(): Allows executing database queries on the main thread (not recommended for production).
//public abstract ExpenseDao expenseDao();: Provides an abstract method to get the ExpenseDao interface.