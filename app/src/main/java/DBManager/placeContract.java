package DBManager;

import android.provider.BaseColumns;

public final class placeContract {
    private placeContract(){}

    public static class placeEntry implements BaseColumns{
        public static final String TABLE_NAME = "place";
        public static final String COLUMN_IDENTIFIER= "identifier";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DEPARTMENT = "department";
        public static final String COLUMN_TOWNSHIP = "township";
        public static final String COLUMN_SITE_TYPE = "sitetype";
        public static final String COLUMN_LATITUDE = "latitude";
        public static final String COLUMN_LONGITUDE = "longitude";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_FIRST_PICTURE = "firstpicture";
        public static final String COLUMN_SECOND_PICTURE = "secondpicture";
        public static final String COLUMN_THIRD_PICTURE = "thirdpicture";
        public static final String COLUMN_PARKING_LOG = "parkinglot";
        public static final String COLUMN_HOTELS = "hotels";
        public static final String COLUMN_INTERNET = "internet";
    }
}
