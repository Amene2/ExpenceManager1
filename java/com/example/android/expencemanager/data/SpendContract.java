package com.example.android.expencemanager.data;

import android.provider.BaseColumns;

/**
 * Created by Amy on 1/26/2018.
 */

public final class SpendContract {

    private SpendContract(){}

    public static class SpendEntry implements BaseColumns{
        public final static String TABLE_NAME = "spend";

        public final static String S_ID = "saveID";
        public final static String C_ID = "categoryID";
        public final static String COLUMN_AMOUNT = "amount";
        public final static String COLUMN_MONTH = "month";
        public final static String COLUMN_YEAR = "year";
        public final static String COLUMN_COMMENT = "comment";

    }
}
