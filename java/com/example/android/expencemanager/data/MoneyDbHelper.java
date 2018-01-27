package com.example.android.expencemanager.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.expencemanager.data.SpendContract.SpendEntry;
import com.example.android.expencemanager.data.SaveContract.SaveEntry;
import com.example.android.expencemanager.data.CategoryContract.CategoryEntry;

import static android.R.attr.key;
import static android.os.FileObserver.CREATE;
import static android.provider.Contacts.SettingsColumns.KEY;

/**
 * Created by Amy on 1/26/2018.
 */

public class MoneyDbHelper extends SQLiteOpenHelper {

    //name of database
    private static final String DATABASE_NAME = "bank.db";

    //DB version:to change columns later
    private static final int DATABASE_VERSION = 1;

    public MoneyDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db){
   /*      //CREATE TABLE spend(S_id foreign key,C_id FOREIGN KEY,amount INTEGER,month INTEGER,year INTEGER)
        String SQL_CREATE_SPEND_TABLE = "CREATE TABLE " + SpendEntry.TABLE_NAME + "( "
                + " FOREIGN KEY (" + SaveEntry.S_ID + ") REFERENCES " + SaveEntry.STABLE_NAME + "(" +SaveEntry.S_ID + "), "
                + " FOREIGN KEY (" + CategoryEntry.C_ID + ") REFERENCES " + CategoryEntry.CTABLE_NAME + "(" +CategoryEntry.C_ID + "), "
                +  SpendEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, "
                +  SpendEntry.COLUMN_MONTH + " INTEGER NOT NULL, "
                +  SpendEntry.COLUMN_YEAR + " INTEGER NOT NULL, "
                +  SpendEntry.COLUMN_COMMENT +"TEXT );";
*/
        db.execSQL("CREATE TABLE spend(S_id INTEGER REFERENCES save(S_id),C_id INTEGER REFERENCES category(C_id),amount INTEGER,month INTEGER,year INTEGER)");

  /*        //CREATE TABLE save(S_id INTEGER PRIMARY KEY,accountName TEXT,amount INTEGER,imageResourceID INTEGER)
        String SQL_CREATE_SAVE_TABLE = "CREATE TABLE " + SaveEntry.STABLE_NAME + "("
                + SaveEntry.S_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SaveEntry.COLUMN_ACCOUNT + " TEXT NOT NULL, "
                + SaveEntry.COLUMN_SAMOUNT + " INTEGER NOT NULL, "
                + SaveEntry.COLUMN_SIID + " INTEGER DEFAULT 00);";
*/
        db.execSQL("CREATE TABLE save(S_id INTEGER PRIMARY KEY,accountName TEXT,amount INTEGER,imageResourceID INTEGER)");

   /*     //CREATE TABLE category(C_id INTEGER PRIMARY KEY,name TEXT,imageResourceID INTEGER)
        String SQL_CREATE_CATEGORY_TABLE = "CREATE TABLE " + CategoryEntry.CTABLE_NAME + "("
                + CategoryEntry.C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CategoryEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + CategoryEntry.COLUMN_CIID + " INTEGER DEFAULT 11);";
 */
        db.execSQL("CREATE TABLE category(C_id INTEGER PRIMARY KEY,name TEXT,imageResourceID INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1){
        //it's have just one version
    }
}
