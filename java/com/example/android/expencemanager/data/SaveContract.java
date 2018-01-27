package com.example.android.expencemanager.data;

import android.provider.BaseColumns;

/**
 * Created by Amy on 1/26/2018.
 */

public final class SaveContract {

    private SaveContract(){}

    public static class SaveEntry implements BaseColumns {
        public final static String STABLE_NAME = "save";

        public final static String S_ID = "saveID";
        public final static String COLUMN_ACCOUNT = "accountName";
        public final static String COLUMN_SAMOUNT = "amount";
        public final static String COLUMN_SIID = "imageResourceId";

    }
}
