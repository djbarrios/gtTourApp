package DBManager;

import android.provider.BaseColumns;

public final class generalInfoContract {
    private generalInfoContract() {}


    public static class departmentEntry implements BaseColumns {
        public static final String TABLE_NAME = "department";
        public static final String COLUMN_IDENTIFIER = "identifier";
        public static final String COLUMN_NAME = "name";
    }

    public static class townshipEntry implements BaseColumns {
        public static final String TABLE_NAME = "township";
        public static final String COLUMN_IDENTIFIER = "identifier";
        public static final String COLUMN_DEPARTMENT_IDENTIFIER = "identifier";
        public static final String COLUMN_NAME = "name";
    }

    public static class siteTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "sitetype";
        public static final String COLUMN_IDENTIFIER = "identifier";
        public static final String COLUMN_NAME = "name";
    }
}
