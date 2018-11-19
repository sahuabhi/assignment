package com.saabhi.assignment;

public class Constants {

    //COLUMNS
    static final String ROW_ID="id";
    static final String NAME="name";
    static final String COMPANY="company";
    static final String LOCATION="location";
    static final String FEE="fee";
    static final String DESCRIPTION="description";

    //DB PROPS
    static final String DB_NAME="hh_DtB";
    static final String TB_NAME="hh_TB";
    static final int DB_VERSION=1;

    //CREATE_TB
    static final String CREATE_TB="CREATE TABLE hh_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + " name TEXT NOT NULL,"
            +" company TEXT NOT NULL,"
            +"location TEXT NOT NULL,"
            +"fee TEXT NOT NULL,"
            +"description TEXT NOT NULL);";

    //DROP_TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;

}
