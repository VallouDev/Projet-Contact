package com.example.projetcontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "contacts.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "contact";

    // below for all columns
    private static final String ID_COL = " id";
    private static final String NOM_COL = " nom";
    private static final String PRENOM_COL = " prenom";
    private static final String CP_COL = " codepostal";
    private static final String ADRESSE_COL = " adresse";
    private static final String MAIL_COL = " mail";
    private static final String TELF_COL = " telfix";
    private static final String TELP_COL = " telportable";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOM_COL + " TEXT,"
                + PRENOM_COL + " TEXT,"
                + MAIL_COL + " TEXT,"
                + CP_COL + " TEXT,"
                + ADRESSE_COL + " TEXT,"
                + TELF_COL + " TEXT,"
                + TELP_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // we have created a new method for reading all the courses.
    public ArrayList<ContactModal> readContacts() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorContacts = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<ContactModal> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorContacts.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new ContactModal(cursorContacts.getString(0),
                        cursorContacts.getString(1),
                        cursorContacts.getString(2),
                        cursorContacts.getString(3),
                        cursorContacts.getString(4),
                        cursorContacts.getString(5),
                        cursorContacts.getString(6)));
            } while (cursorContacts.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorContacts.close();
        return courseModalArrayList;
    }



    public void addNewContact(String nom, String prenom, String mail, String cp, String adresse, String telf, String telp) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(NOM_COL, nom);
            values.put(PRENOM_COL, prenom);
            values.put(MAIL_COL, mail);
            values.put(CP_COL, cp);
            values.put(ADRESSE_COL, adresse);
            values.put(TELF_COL, telf);
            values.put(TELP_COL, telp);
            db.insert(TABLE_NAME, null, values);
            db.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}


