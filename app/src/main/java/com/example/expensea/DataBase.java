package com.example.expensea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class DataBase extends SQLiteOpenHelper {

    public static final String column_T = "typ";
    public static final String column_AMT = "amt";
    public static final String TABLE_EX = "EXPTAB";
    public static final String column_N = "Name";
    public static final String column_AMT1 = "amt";
    public static final String TABLE_TRP = "TRPTAB";
    public static final String column_D = "DAY";
    public static final String column_DN = "DAYNO";
    public static final String column_MD = "MONTH";
    public static final String column_YM = "YEAR";
    public static final String column_AMNT1 = "Person1";
    public static final String column_AMNT2 = "Person2";
    public static final String column_AMNT3 = "Person3";
    public static final String column_AMNT4 = "Person4";
    public static final String column_AMNT5 = "Person5";
    public static final String column_PPL = "People";
    public static final String column_EACH = "Eachperson";


    public static final String TABLE_BL = "BILL";

    Calendar calendar = Calendar.getInstance();
    String date = DateFormat.getDateInstance().format(calendar.getTime());
    MonthDay md = MonthDay.now();
    YearMonth nd = YearMonth.now();
    LocalDate date2 = LocalDate.now();
    String day = String.valueOf(date2.getDayOfWeek());
    String monthday = String.valueOf(md);
    String yearmonth = String.valueOf(nd);
    String dayno1 = monthday.substring(monthday.length()-2,monthday.length());
    String month1 = monthday.substring(2,4);
    String year1 = yearmonth.substring(0,4);
    int dayno = Integer.parseInt(dayno1);
    int month = Integer.parseInt(month1);
    int year = Integer.parseInt(year1);




    public DataBase(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ex = " create table " + TABLE_EX + "  (  " + column_T + " string , " + column_AMT + " int ," + column_D + " string , " + column_DN + " int , " + column_MD + " int , " + column_YM + " int )";
        db.execSQL(ex);
        String ex1 = " create table " + TABLE_TRP + "  (  " + column_N + " string , " + column_AMT1 + " int )";
        db.execSQL(ex1);
        String ex2 = " create table " + TABLE_BL + "  (  " + column_N + " string , " + column_PPL + " int ," + column_EACH + " int , " + column_AMNT1 + " string , " + column_AMNT2 + " string ," + column_AMNT3 + " string  ," + column_AMNT4 + " string  ," + column_AMNT5 + " string ) ";
        db.execSQL(ex2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EX);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BL);
        onCreate(db);

    }

    //expense

    public boolean addOne(expensemodel ex1) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_T, ex1.getType());
        cv.put(column_AMT, ex1.getAmt());
        cv.put(column_D,ex1.getDay());
        cv.put(column_DN,ex1.getDayno());
        cv.put(column_MD,ex1.getMonthday());
        cv.put(column_YM,ex1.getYearday());
        long insert = db.insert(TABLE_EX, null, cv);
        boolean b = insert != -1;
        return b;

    }
    public boolean baddOne(billmodel ex1) {



        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_N, ex1.getName());
        cv.put(column_PPL,ex1.getPpl());
        cv.put(column_EACH,ex1.getEach());
        cv.put(column_AMNT1, ex1.getPerson1_name());
        cv.put(column_AMNT2, ex1.getPerson2_name());
        cv.put(column_AMNT3, ex1.getPerson3_name());
        cv.put(column_AMNT4, ex1.getPerson4_name());
        cv.put(column_AMNT5, ex1.getPerson5_name());

        long insert = db.insert(TABLE_BL, null, cv);
        boolean b = insert != -1;
        return b;
    }
    public boolean tadd(tripmodel ex1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_N, ex1.getType());
        cv.put(column_AMT1, ex1.getAmt());
        long insert = db.insert(TABLE_TRP, null, cv);
        boolean b = insert != -1;
        return b;
    }


    public boolean deleteall(MainActivity ex1) {
        SQLiteDatabase db = getWritableDatabase();
        String del = "DELETE FROM " + TABLE_EX;
        String del1 = "DELETE FROM " + TABLE_TRP;
        String del2 = "DELETE FROM " + TABLE_BL;
        Cursor cur = db.rawQuery(del, null);
        Cursor cur1 = db.rawQuery(del1, null);
        Cursor cur2 = db.rawQuery(del2, null);
        if (cur.moveToFirst() && cur1.moveToFirst() && cur2.moveToFirst()) {
            return true;
        } else
            return false;

    }

    public int getfood()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + " = 'Food' and " + column_DN + " = " + dayno ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst())
            do {
            c += crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int gettrans()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + " = 'Transport' and " + column_DN + " = " + dayno ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getgross()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + " = 'Groceries'and " + column_DN + " = " + dayno ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getcloth()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + " = 'Clothing'and " + column_DN + " = " + dayno ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getenter()
    {   int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + " = 'Entertainment'and " + column_DN + " = " + dayno ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getother()
    {   int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + " ='Other'and " + column_DN + " = " + dayno ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
                c+= crs.getInt(1);
            }
            while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getmon()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " = " + (dayno-6) + " and " + column_MD + "=" + month + " and " + column_YM + "=" + year  ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int gettue()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " = " + (dayno-5) + "  and " + column_MD + "=" + month + " and " + column_YM + "=" + year   ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getwed()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " = " + (dayno-4) + " and " + column_MD + "=" + month + " and " + column_YM + "=" + year  ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getthur()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " = " + (dayno-3) + " and " + column_MD + "=" + month + " and " + column_YM + "=" + year ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getfri()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " = " + (dayno-2) + " and " + column_MD + "=" + month + " and " + column_YM + "=" + year   ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getsat()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " = " + (dayno-1) + " and " + column_MD + "=" + month + " and " + column_YM + "=" + year   ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getsun()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal' and " + column_DN + " = " + dayno + " and " + column_MD + "=" + month + " and " + column_YM + "=" + year   ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getall()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal' and " + column_DN + "=" + dayno +  " and " + column_MD + "=" + month + " and " + column_YM + "=" + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c += crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }

    public int getfoodweek()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Food' and " + column_DN + " between " + (dayno-7) + " and "+ (dayno+1) + " and " + column_MD + "=" + month + " and " + column_YM + "=" +year ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int gettransweek()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Transport' and " + column_DN + " between " + (dayno-7) + " and "+ (dayno+1) + " and " + column_MD + "=" + month + " and " + column_YM + "=" +year ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getgrossweek()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Groceries' and " + column_DN + " between " + (dayno-7) + " and "+ (dayno+1) + " and " + column_MD + "=" + month + " and " + column_YM + "=" +year ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getclothweek()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Clothing' and " + column_DN + " between " + (dayno-7) + " and "+ (dayno+1) + " and " + column_MD + "=" + month + " and " + column_YM + "=" +year ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getenterweek()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Entertainment' and " + column_DN + " between " + (dayno-7) + " and "+ (dayno+1) + " and " + column_MD + "=" + month + " and " + column_YM + "=" +year ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getotherweek()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Other' and " + column_DN + " between " + (dayno-7) + " and "+ (dayno+1) + " and " + column_MD + "=" + month + " and " + column_YM + "=" +year ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }

    public int getfoodmonth()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Food' and "  + column_MD + "=" + month + " and " + column_YM + "=" + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int gettransmonth()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Transport' and "  + column_MD + "=" + month + " and " + column_YM + "=" + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getgrossmonth()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Groceries' and "  + column_MD + "=" + month + " and " + column_YM + "=" + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getclothmonth()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Clothing' and "  + column_MD + "=" + month + " and " + column_YM + "=" + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getentermonth()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Entertainment' and "  + column_MD + "=" + month + " and " + column_YM + "=" + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }public int getothermonth()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "='Other' and "  + column_MD + "=" + month + " and " + column_YM + "=" + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getgoal()
    {   int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + " ='Goal' and " + column_DN + "=" + dayno +  " and " + column_MD + "=" + month + " and " + column_YM + "=" + year  ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }

    public int getmonth1()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " between 1 and 7 and "  + column_MD + " = " + month + " and " + column_YM + " = " + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }

    public int getmonth2()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " between 8 and 14 and "  + column_MD + " = " + month + " and " + column_YM + " = " + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getmonth3()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " between 15 and 21 and "  + column_MD + " = " + month + " and " + column_YM + " = " + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }
    public int getmonth4()
    {
        int c=0;
        String gs = " SELECT * FROM " + TABLE_EX + " WHERE " + column_T + "!='Goal'and " + column_DN + " between 22 and 31 and "  + column_MD + " = " + month + " and " + column_YM + " = " + year  ;;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            c+= crs.getInt(1);
        }
        while (crs.moveToNext());
        else {c=0;}
        crs.close();
        db.close();
        return c;
    }

    // tripp



    public List<tripmodel> tgetall()
    {
        List<tripmodel> returnlist = new ArrayList<>();
        int c=0;
        String gs = " SELECT * FROM " + TABLE_TRP  ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            String tripname = crs.getString(0);
            c= crs.getInt(1);
            tripmodel newtrip = new tripmodel(tripname,c);
            returnlist.add(newtrip);
        }
        while (crs.moveToNext());
        else {c=0; }
        crs.close();
        db.close();
        return returnlist;
    }


    // bill


    public List<billreturn> bgetall()
    {
        List<billreturn> returnlist = new ArrayList<>();
        int c0=0,c1=0;
        String gs = " SELECT * FROM " + TABLE_BL  ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery(gs,null);
        if(crs.moveToFirst()) do {
            String billname = crs.getString(0);
            c1= crs.getInt(2);
            String c2= crs.getString(3);
            String c3= crs.getString(4);
            String c4 = crs.getString(5);
            String c5 = crs.getString(6);
            String c6 = crs.getString(7);
            billreturn newbill = new billreturn(billname,c1,c2,c3,c4,c5,c6);
            returnlist.add(newbill);
        }
        while (crs.moveToNext());
        else {}
        crs.close();
        db.close();
        return returnlist;
    }


}