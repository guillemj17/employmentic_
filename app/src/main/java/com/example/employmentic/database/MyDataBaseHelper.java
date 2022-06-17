package com.example.employmentic.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.os.IResultReceiver;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "bbdd1.db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_NAME = "vacante";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "nombre";
    private static final String COLUMN_NAME_EMPRESA = "nombreEmpresa";
    private static final String COLUMN_UBICACION = "ubicacion";
    private static final String COLUMN_ESTUDIOS = "estudios";
    private static final String COLUMN_MODALIDAD = "modalidad";
    private static final String COLUMN_SALARIO = "salario";
    private static final String COLUMN_JORNADA = "jornada";
    private static final String COLUMN_CONOCIMIENTOS = "conocimientos";



    public MyDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_NAME_EMPRESA + " TEXT, " +
                COLUMN_UBICACION + " TEXT, " +
                COLUMN_ESTUDIOS + " TEXT, " +
                COLUMN_MODALIDAD + " TEXT, " +
                COLUMN_SALARIO + " TEXT, " +
                COLUMN_JORNADA + " TEXT, " +
                COLUMN_CONOCIMIENTOS + " TEXT);";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public Cursor consultar(){

        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void guardar(String nombre, String nombreEmpresa,String ubicacion, String estudios, String modalidad, String salario, String jornada, String conocimientos) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMN_NAME, nombre);
        valores.put(COLUMN_NAME_EMPRESA, nombreEmpresa);
        valores.put(COLUMN_UBICACION, ubicacion);
        valores.put(COLUMN_ESTUDIOS, estudios);
        valores.put(COLUMN_MODALIDAD, modalidad);
        valores.put(COLUMN_SALARIO, salario);
        valores.put(COLUMN_JORNADA, jornada);
        valores.put(COLUMN_CONOCIMIENTOS, conocimientos);

        db.insert(TABLE_NAME, null, valores);

        db.close();
        Toast.makeText(context, "Registro insertado correctamente", Toast.LENGTH_SHORT).show();
    }
}
