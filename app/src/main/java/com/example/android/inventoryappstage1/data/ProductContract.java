package com.example.android.inventoryappstage1.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class ProductContract {
    /**
     *Content Authority is the name for the entire content provider, like the relationship between
     * a domain and its website. best practice is using the package name for the app,
     * which should be unique on a device
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.inventoryappstage1.data";

    /**
     * CONTENT_AUTHORITY is used to create the base of all URIs which this app to communicate with its
     * content provider
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible paths for data. Should point to the tables housed in the data package.
     */
    public static final String PATH_PRODUCTS = "products";

    /**
     * Define database names and version
     */



    /**
     * Inner class which  defines the table contents of the pets table
     */
    public static final class ProductsEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_PRODUCTS).build();

/*
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;
*/


        /**
         * Table Name
         */
        public static final String TABLE_NAME = "products";
        /**
         * Strings to send to the Pet app as the columns of the pet query
         */
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "ProductName";
        public static final String COLUMN_PRODUCT_PRICE = "ProductPrice";
        public static final String COLUMN_PRODUCT_QTY = "QTY";
        public static final String COLUMN_SUPPLIER_NAME = "SupplierName";
        public static final String COLUMN_SUPPLIER_PHONE = "SupplierPhone";

        public static Uri buildProductsURI(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }


}
