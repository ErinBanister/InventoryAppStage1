package com.example.android.inventoryappstage1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.inventoryappstage1.data.ProductContract.ProductsEntry;

public class ProductDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "products.db";
    private static final int DATABASE_VERSION = 1;

    public ProductDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    //create the database for the first time
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PRODUCTS_TABLE = "CREATE TABLE " + ProductsEntry.TABLE_NAME + " ("
                + ProductsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductsEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + ProductsEntry.COLUMN_PRODUCT_PRICE + " INTEGER NOT NULL, "
                + ProductsEntry.COLUMN_PRODUCT_QTY + " INTEGER NOT NULL DEFAULT 0, "
                + ProductsEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL, "
                + ProductsEntry.COLUMN_SUPPLIER_PHONE + " TEXT NOT NULL);";
        Log.v("LOG_TAG", SQL_CREATE_PRODUCTS_TABLE);
        db.execSQL(SQL_CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // nothing here, just one version thus far
    }
}

