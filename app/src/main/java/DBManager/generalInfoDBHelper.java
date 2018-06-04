package DBManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class generalInfoDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "generalInfoReader.db";

    public generalInfoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_DEPARTMENT =
            "CREATE TABLE " + generalInfoContract.departmentEntry.TABLE_NAME + " (" +
                    generalInfoContract.departmentEntry._ID + " INTEGER PRIMARY KEY," +
                    generalInfoContract.departmentEntry.COLUMN_IDENTIFIER + " TEXT," +
                    generalInfoContract.departmentEntry.COLUMN_NAME + " TEXT)";

    private static final String SQL_CREATE_TOWNSHIP =
            "CREATE TABLE " + generalInfoContract.townshipEntry.TABLE_NAME + " (" +
                    generalInfoContract.townshipEntry._ID + " INTEGER PRIMARY KEY," +
                    generalInfoContract.townshipEntry.COLUMN_IDENTIFIER + " TEXT," +
                    generalInfoContract.townshipEntry.COLUMN_DEPARTMENT_IDENTIFIER + " TEXT," +
                    generalInfoContract.townshipEntry.COLUMN_NAME + " TEXT)";

    private static final String SQL_CREATE_SITE_TYPE =
            "CREATE TABLE " + generalInfoContract.siteTypeEntry.TABLE_NAME + " (" +
                    generalInfoContract.siteTypeEntry._ID + " INTEGER PRIMARY KEY," +
                    generalInfoContract.siteTypeEntry.COLUMN_IDENTIFIER + " TEXT," +
                    generalInfoContract.siteTypeEntry.COLUMN_NAME + " TEXT)";

    private static final String SQL_DELETE_DEPARTMENT =
            "DROP TABLE IF EXISTS " + generalInfoContract.departmentEntry.TABLE_NAME;

    private static final String SQL_DELETE_TOWNSHIP =
            "DROP TABLE IF EXISTS " + generalInfoContract.departmentEntry.TABLE_NAME;

    private static final String SQL_DELETE_SITE_TYPE =
            "DROP TABLE IF EXISTS " + generalInfoContract.departmentEntry.TABLE_NAME;

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_DEPARTMENT);
        db.execSQL(SQL_CREATE_TOWNSHIP);
        db.execSQL(SQL_CREATE_SITE_TYPE);
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
