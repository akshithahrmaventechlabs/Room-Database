package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtTitle,edtAmount;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTitle=findViewById(R.id.edtName);
        edtAmount=findViewById(R.id.edtAmount);
        btnAdd=findViewById(R.id.btnAdd);

        DatabaseHelper databaseHelper=DatabaseHelper.getDB(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String amount = edtAmount.getText().toString();

                Log.d("MainActivity", "Inserting expense: Title=" + title + ", Amount=" + amount);

                databaseHelper.expenseDao().insertExpense(
                        new Expense(title, amount)                );

                List<Expense> arrExpenses = databaseHelper.expenseDao().getAllExpenses();
                for (int i = 0; i < arrExpenses.size(); i++) {
                    Log.d("MainActivity", "Title: " + arrExpenses.get(i).getTitle() + " Amount: " + arrExpenses.get(i).getAmount());
                }
                // Display a message after inserting the expense
                Toast.makeText(MainActivity.this, "Expense added successfully", Toast.LENGTH_SHORT).show();

            }        });
    }
}



//29line-Creates an instance of your Room database using the singleton pattern.
//String title = edtTitle.getText().toString();: Retrieves the text entered in the title EditText.
//String amount = edtAmount.getText().toString();: Retrieves the text entered in the amount EditText.
//databaseHelper.expenseDao().insertExpense(new Expense(title, amount));: Inserts a new Expense object into the database.
//ArrayList<Expense> arrExpenses = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpenses();: Retrieves all expenses from the database.
//for (int i = 0; i < arrExpenses.size(); i++) {...}: Iterates through the list of expenses and logs their title and amount.