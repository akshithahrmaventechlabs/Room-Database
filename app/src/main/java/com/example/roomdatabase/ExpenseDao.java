package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Insert
    void insertExpense(Expense expense);

    @Query("SELECT * FROM expense")
    List<Expense> getAllExpenses();

}

//for every entity a DAO interface is needed that contains function for accessing the database
//@Dao: Indicates that this interface is a DAO.(DAO are the main classes where you define your database interactions)
//@Insert: Specifies the insert operation for adding expenses to the database.
//@Query("SELECT * FROM expense"): Specifies a query to retrieve all expenses from the "expense"
// table.(The value of the annotation includes the query that will be run when this method is called)