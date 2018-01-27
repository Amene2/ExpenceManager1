package com.example.android.expencemanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.example.android.expencemanager.data.MoneyDbHelper;
import com.example.android.expencemanager.data.SaveContract;
import com.example.android.expencemanager.data.SpendContract;
import com.example.android.expencemanager.data.SpendContract.SpendEntry;


/**
 * Created by Amy on 1/26/2018.
 */

public class PlusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        displayDatabaseInfo();

        Button button1 = (Button) findViewById(R.id.savep);
        final EditText button3 = (EditText) findViewById(R.id.cat);
        final String sUsername = button3.getText().toString();
        EditText button4= (EditText) findViewById(R.id.edt);


        // Capture button clicks
        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                insertSpend();
                displayDatabaseInfo();


                    // Start NewActivity.class
                   Intent myIntent = new Intent(PlusActivity.this,
                            MainActivity.class);
                    startActivity(myIntent);

            }
        });
    }
    MoneyDbHelper mDbHelper = new MoneyDbHelper(this);


    /**
     * Helper method to insert hardcoded pet data into the database. For debugging purposes only.
     */
     private void insertSpend() {
            // Gets the database in write mode
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            // Create a ContentValues object where column names are the keys,
            // and Toto's pet attributes are the values.
            ContentValues values = new ContentValues();
                    values.put(SpendEntry.S_ID, 1);
                    values.put(SpendEntry.C_ID, 1);
                    values.put(SpendEntry.COLUMN_AMOUNT, 100000);
                    values.put(SpendEntry.COLUMN_MONTH, 1);
                    values.put(SpendEntry.COLUMN_YEAR, 2018);

            // Insert a new row for Toto in the database, returning the ID of that new row.
            // The first argument for db.insert() is the pets table name.
            // The second argument provides the name of a column in which the framework
            // can insert NULL in the event that the ContentValues is empty (if
            // this is set to "null", then the framework will not insert a row when
            // there are no values)
            // The third argument is the ContentValues object containing the info for Toto.
            long newRowId = db.insert(SpendEntry.TABLE_NAME, null, values);
     }



    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        MoneyDbHelper mDbHelper = new MoneyDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        Cursor cursor = db.rawQuery("SELECT * FROM " + SaveContract.SaveEntry.STABLE_NAME, null);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
            TextView displayView = (TextView) findViewById(R.id.text_view_pet);
            displayView.setText("Number of rows in spend database table: " + cursor.getCount());
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid
            cursor.close();
        }

    }
}
