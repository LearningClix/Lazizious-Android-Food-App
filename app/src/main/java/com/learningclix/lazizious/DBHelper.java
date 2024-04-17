package com.learningclix.lazizious;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.learningclix.lazizious.Models.CartOrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "lazizious.db";
    final static int DBVERSION = 3;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table food_order " +
                "(id INTEGER primary key autoincrement," +
                "customer_name text, " +
                "customer_phone text, " +
                "food_name text, " +
                "quantity int, " +
                "price int, " +
                "image int, " +
                "description text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists food_order");
        onCreate(sqLiteDatabase);
    }

    public boolean addOrder(String customer_name, String customer_phone, String food_name,int quantity, int price, int image, String description){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("customer_name", customer_name);
        values.put("customer_phone", customer_phone);
        values.put("food_name", food_name);
        values.put("quantity", quantity);
        values.put("price", price);
        values.put("image", image);
        values.put("description", description);
        long id = database.insert("food_order", null, values);
        if (id <= 0){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<CartOrderModel> getOrderDetails(){
        ArrayList<CartOrderModel> list = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select id, food_name, image, price  from food_order",null);
        if (cursor.moveToFirst()){
            do{
                CartOrderModel model = new CartOrderModel(cursor.getInt(0),cursor.getString(1),cursor.getLong(2),cursor.getInt(3)+"");
//                model.setSoldProductNumber(cursor.getInt(0));
//                model.setSoldProductName(cursor.getString(1));
//                model.setOrderImage(cursor.getInt(2));
//                model.setSoldProductPrice(cursor.getInt(3));
                list.add(model);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return list;
    }



}
