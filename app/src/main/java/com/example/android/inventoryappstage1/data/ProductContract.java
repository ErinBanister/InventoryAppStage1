package com.example.android.inventoryappstage1.data;

import android.provider.BaseColumns;

public class ProductContract {
    /**
     * Inner class which  defines the table contents of the products table
     */
    public static final class ProductsEntry implements BaseColumns {

        public static final String TABLE_NAME = "products";

        //Strings to send to the Inventory app as the columns of the product query
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "ProductName";
        public static final String COLUMN_PRODUCT_PRICE = "ProductPrice";
        public static final String COLUMN_PRODUCT_QTY = "QTY";
        public static final String COLUMN_SUPPLIER_NAME = "SupplierName";
        public static final String COLUMN_SUPPLIER_PHONE = "SupplierPhone";
    }
}

