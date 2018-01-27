package com.example.android.expencemanager.data;

import android.provider.BaseColumns;

/**
 * Created by Amy on 1/26/2018.
 */

public final class CategoryContract {

    private CategoryContract(){}

    public static class CategoryEntry implements BaseColumns {

            public final static String CTABLE_NAME = "category";

            public final static String C_ID = "categoryID";
            public final static String COLUMN_NAME = "name";
            public final static String COLUMN_CIID = "cImageResourceId";


    }
}
