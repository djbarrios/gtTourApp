package DBManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class placeDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ContactReader.db";

    public placeDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_PLACE =
            "CREATE TABLE " + placeContract.placeEntry.TABLE_NAME + " (" +
                    placeContract.placeEntry._ID + " INTEGER PRIMARY KEY," +
                    placeContract.placeEntry.COLUMN_IDENTIFIER + " TEXT," +
                    placeContract.placeEntry.COLUMN_TITLE + " TEXT," +
                    placeContract.placeEntry.COLUMN_DEPARTMENT + " TEXT," +
                    placeContract.placeEntry.COLUMN_TOWNSHIP + " TEXT," +
                    placeContract.placeEntry.COLUMN_LATITUDE + " TEXT," +
                    placeContract.placeEntry.COLUMN_LONGITUDE + " TEXT," +
                    placeContract.placeEntry.COLUMN_HOTELS + " TEXT," +
                    placeContract.placeEntry.COLUMN_INTERNET + " TEXT," +
                    placeContract.placeEntry.COLUMN_PARKING_LOG + " TEXT," +
                    placeContract.placeEntry.COLUMN_FIRST_PICTURE + " TEXT," +
                    placeContract.placeEntry.COLUMN_SECOND_PICTURE + " TEXT," +
                    placeContract.placeEntry.COLUMN_THIRD_PICTURE + " TEXT," +
                    placeContract.placeEntry.COLUMN_SITE_TYPE + " TEXT," +
                    placeContract.placeEntry.COLUMN_DESCRIPTION + " TEXT)";

    private static final String SQL_DELETE_PLACE =
            "DROP TABLE IF EXISTS " + placeContract.placeEntry.TABLE_NAME;

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_PLACE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        //db.execSQL(SQL_DELETE_CONTACTS);
        //onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade(db, oldVersion, newVersion);
    }
}
