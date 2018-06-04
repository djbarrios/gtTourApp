package DBManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import data.place;

public class dbOperations {
    private placeDBHelper mDbHelper;

    public dbOperations(Context context){
        mDbHelper = new placeDBHelper(context);
    }

    public long savePlace(place place) {
        if(validateFields(place)) {
            // Gets the data repository in write mode
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            // Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(placeContract.placeEntry.COLUMN_DEPARTMENT, place.getDepartment());
            values.put(placeContract.placeEntry.COLUMN_TOWNSHIP, place.getTownship());
            values.put(placeContract.placeEntry.COLUMN_TITLE, place.getTitle());
            values.put(placeContract.placeEntry.COLUMN_DESCRIPTION, place.getDescription());
            values.put(placeContract.placeEntry.COLUMN_LATITUDE, place.getLatitude());
            values.put(placeContract.placeEntry.COLUMN_LONGITUDE, place.getLongitude());
            values.put(placeContract.placeEntry.COLUMN_SITE_TYPE, place.getSiteType());
            values.put(placeContract.placeEntry.COLUMN_HOTELS,place.getHasHotels());
            values.put(placeContract.placeEntry.COLUMN_INTERNET, place.getHasInternet());
            values.put(placeContract.placeEntry.COLUMN_PARKING_LOG, place.getHasParkingLot());
            values.put(placeContract.placeEntry.COLUMN_FIRST_PICTURE, place.getPicture1());
            values.put(placeContract.placeEntry.COLUMN_SECOND_PICTURE, place.getPicture2());
            values.put(placeContract.placeEntry.COLUMN_THIRD_PICTURE, place.getPicture3());


            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(placeContract.placeEntry.TABLE_NAME, null, values);
            return newRowId;
        }else{
            return 0;
        }

    }

    public List<place> getPlaces() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        place newPlace;

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                placeContract.placeEntry.COLUMN_IDENTIFIER,
                placeContract.placeEntry.COLUMN_TITLE,
                placeContract.placeEntry.COLUMN_DEPARTMENT,
                placeContract.placeEntry.COLUMN_TOWNSHIP,
                placeContract.placeEntry.COLUMN_LATITUDE,
                placeContract.placeEntry.COLUMN_LONGITUDE,
                placeContract.placeEntry.COLUMN_HOTELS,
                placeContract.placeEntry.COLUMN_INTERNET,
                placeContract.placeEntry.COLUMN_PARKING_LOG,
                placeContract.placeEntry.COLUMN_FIRST_PICTURE,
                placeContract.placeEntry.COLUMN_SECOND_PICTURE,
                placeContract.placeEntry.COLUMN_THIRD_PICTURE,
                placeContract.placeEntry.COLUMN_SITE_TYPE,
                placeContract.placeEntry.COLUMN_DESCRIPTION
        };


        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                placeContract.placeEntry.COLUMN_DEPARTMENT + " DESC";


        Cursor cursor = db.query(
                placeContract.placeEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );



        List placesList = new ArrayList<place>();
        while(cursor.moveToNext()) {
            String department = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_DEPARTMENT));
            String township = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_TOWNSHIP));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_TITLE));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_DESCRIPTION));
            String hasHotels = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_HOTELS));
            String hasInternet = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_INTERNET));
            String hasParkingLot = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_PARKING_LOG));
            String siteType = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_SITE_TYPE));
            String latitude = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_LATITUDE));
            String longitude = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_LONGITUDE));
            String firstPicture = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_FIRST_PICTURE));
            String secondPicture = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_SECOND_PICTURE));
            String thirdPicture = cursor.getString(cursor.getColumnIndexOrThrow(placeContract.placeEntry.COLUMN_THIRD_PICTURE));

            newPlace = new place(department,township,siteType,hasParkingLot,hasInternet,hasHotels,title,latitude,longitude,description,firstPicture,secondPicture,thirdPicture);
            placesList.add(newPlace);
        }
        cursor.close();

        return  placesList;
    }


    private boolean validateFields(place place){
        boolean valid = true;

        if (TextUtils.isEmpty(place.getDescription()) || TextUtils.isEmpty(place.getTitle())){
            valid = false;
        }

        return valid;
    }

}
