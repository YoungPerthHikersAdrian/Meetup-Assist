package com.journaldev.retrofitintro.TaskTable;

import android.provider.BaseColumns;

/**
 * Created by Ajess on 1/04/2017.
 */

public class TaskContract {
    public static final String DB_NAME = "com.ajess.MeetupRSVP.db";
    public static final int DB_VERSION = 1;

    public class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "AttendTable";
        public static final String COLUMN1_NAME = "MemeberID";
        public static final String COLUMN2_NAME = "MemeberName";
        public static final String COLUMN3_NAME = "MemeberPhotoLink";
        public static final String COLUMN4_NAME = "AttendStatus";
    }
}
