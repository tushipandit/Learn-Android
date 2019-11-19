package com.example.demo_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.xml.parsers.DocumentBuilder;

public class ContactDB {

        public static final String KEY_ROWID="_id";
        public static final String KEY_NAME="person_name";
        public static final String KEY_CELL="_cell";

        private final String DATABASE_NAME="ContactsDB";
        private final String DATABASE_TABLE="ContactsTable";
        private final int DATABASE_VERSION = 1;

        private DBHelper ourHelper;
        private final Context ourContext;
        private SQLiteDatabase ourDatabase;

        public ContactDB(Context context){
            ourContext=context;
        }

        private class DBHelper extends SQLiteOpenHelper
        {

            //constructor constructs the new database
            public DBHelper(Context context){

                super(context,DATABASE_NAME,null,DATABASE_VERSION);

            }


            @Override
            public void onCreate(SQLiteDatabase db) {
                /*
                CREATE TABLE ContactsTable (_id INTEGER PRIMARY KEY AUTOINCREMENTED ,
                            person_name TEXT NOT NULL,_cell TEXT NOT NULL );


                 */

                String sqlCode="CREATE TABLE "+DATABASE_TABLE+"("+
                        KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        KEY_NAME + " TEXT NOT NULL, "+
                        KEY_CELL+ " TEXT NOT NULL );" ;

                db.execSQL(sqlCode);

            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int i, int i1) {

                db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
                onCreate(db);

            }


        }





        public ContactDB open() throws SQLException
        {
            ourHelper = new DBHelper(ourContext);
            ourDatabase=ourHelper.getWritableDatabase();
            return this;
        }

        public void close(){
            ourHelper.close();
        }

        public long createEntry( String name , String cell){

            ContentValues cv =new ContentValues();
            cv.put(KEY_NAME,name);
            cv.put(KEY_CELL,cell);
            return ourDatabase.insert(DATABASE_TABLE,null,cv);
        }

        public String getData(){

            String [] columns=new String[]{KEY_ROWID,KEY_NAME,KEY_CELL};
            Cursor c=ourDatabase.query(DATABASE_TABLE,columns,null,null,null,null,null);
            String results="";

            int irowid =c.getColumnIndex(KEY_ROWID);
            int iname=c.getColumnIndex(KEY_NAME);
            int icell=c.getColumnIndex(KEY_CELL);

            for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
            {
                results=results+c.getString(irowid) +":"+c.getString(iname)+":"+c.getString(icell)+"\n";
            }

            c.close();

            return  results;


        }

        public long deleteEntry(String rowID)
        {
            return ourDatabase.delete(DATABASE_TABLE,KEY_ROWID+"=?",new String[]{rowID});

        }

        public long updateEntry(String rowID,String name , String cell)
        {
            ContentValues cv=new ContentValues();
            cv.put(KEY_NAME,name);
            cv.put(KEY_CELL,cell);

            return ourDatabase.update(DATABASE_TABLE,cv,KEY_ROWID+"=?",new String[]{rowID});

        }

}
