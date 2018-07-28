package com.example.android.inventoryappstage1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.inventoryappstage1.data.ProductContract.ProductsEntry;
import com.example.android.inventoryappstage1.data.ProductDbHelper;

public class MainActivity extends AppCompatActivity {
    TextView displayText;
    ProductDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = findViewById(R.id.displayTableInfo);
        displayProducts();

        Button buttonClicker = findViewById(R.id.button);
        buttonClicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                displayProducts();
            }
        });
    }

    private void insertData() {
        //opens the database
        mDbHelper = new ProductDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //starts making the value-pair connections
        ContentValues values = new ContentValues();
        values.put(ProductsEntry.COLUMN_PRODUCT_NAME, "Yellow Submarines");
        values.put(ProductsEntry.COLUMN_PRODUCT_PRICE, 300);
        values.put(ProductsEntry.COLUMN_PRODUCT_QTY, 1);
        values.put(ProductsEntry.COLUMN_SUPPLIER_NAME, "Beatles");
        values.put(ProductsEntry.COLUMN_SUPPLIER_PHONE, "1-800-BEA-TLES");
        Log.i("MainActivity.java", " SQL QRY :" + values.toString());
        db.insert(ProductsEntry.TABLE_NAME, null, values);
        mDbHelper.close();
    }

    private void displayProducts() {
        mDbHelper = new ProductDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {ProductsEntry._ID, ProductsEntry.COLUMN_PRODUCT_NAME, ProductsEntry.COLUMN_PRODUCT_PRICE,
                ProductsEntry.COLUMN_PRODUCT_QTY, ProductsEntry.COLUMN_SUPPLIER_NAME, ProductsEntry.COLUMN_SUPPLIER_PHONE};
        Cursor cursor = db.query(ProductsEntry.TABLE_NAME, projection, null, null, null, null, null);
        TextView displayView = findViewById(R.id.displayTableInfo);
        displayView.setText("The Products table contains " + cursor.getCount() + " rows of data \n");
        displayView.append(ProductsEntry._ID + " | " + ProductsEntry.COLUMN_PRODUCT_NAME + " | " + ProductsEntry.COLUMN_PRODUCT_PRICE
                + " | " + ProductsEntry.COLUMN_PRODUCT_QTY + " | " + ProductsEntry.COLUMN_SUPPLIER_NAME + " | " + ProductsEntry.COLUMN_SUPPLIER_PHONE);

        // Determine the index# of each column
        int idColumnIndex = cursor.getColumnIndex(ProductsEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(ProductsEntry.COLUMN_PRODUCT_NAME);
        int priceColumnIndex = cursor.getColumnIndex(ProductsEntry.COLUMN_PRODUCT_PRICE);
        int qtyColumnIndex = cursor.getColumnIndex(ProductsEntry.COLUMN_PRODUCT_QTY);
        int supplierNameColumnIndex = cursor.getColumnIndex(ProductsEntry.COLUMN_SUPPLIER_NAME);
        int supplierPhoneColumnIndex = cursor.getColumnIndex(ProductsEntry.COLUMN_SUPPLIER_PHONE);

        while (cursor.moveToNext()) {
            // Use that index to extract the String or Int value of the word
            // at the current row the cursor is on.
            int currentID = cursor.getInt(idColumnIndex);
            String currentName = cursor.getString(nameColumnIndex);
            String currentPrice = cursor.getString(priceColumnIndex);
            int currentQTY = cursor.getInt(qtyColumnIndex);
            String currentSupplierName = cursor.getString(supplierNameColumnIndex);
            String currentSupplierPhone = cursor.getString(supplierPhoneColumnIndex);
            // Display the values from each column of the current row in the cursor in the TextView
            displayView.append(("\n" + currentID + " - " + currentName + " - " + currentPrice
                    + " - " + currentQTY + " - " + currentSupplierName + " - " + currentSupplierPhone));
        }
        cursor.close();
    }
}

