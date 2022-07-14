package com.example.john_keels_it_project.api.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.john_keels_it_project.model.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "studentDb";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "students";

    private static final String StuId = "id";

    private static final String StuName = "name";

    private static final String StuAge = "age";

    private static final String StuCourse = "course";

    private static final String TAG = "DBHandler";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + StuId + " TEXT PRIMARY KEY, "
                + StuName + " TEXT,"
                + StuAge + " INTEGER,"
                + StuCourse + " TEXT)";
        db.execSQL(query);
    }

    public void addStudent(StudentModel studentModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(StuId, studentModel.getStuId());
        values.put(StuName, studentModel.getStuName());
        values.put(StuAge, studentModel.getStuAge());
        values.put(StuCourse, studentModel.getStuCourseName());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public List<StudentModel> getStudents() {
        List<StudentModel> studentModelList = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            Cursor resultSet = db.rawQuery("Select * from " + TABLE_NAME, null);
            if (resultSet.moveToFirst()) {
                do {
                    studentModelList.add(new StudentModel(resultSet.getString(0),
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)));
                } while (resultSet.moveToNext());
            }
        } catch (Exception e) {
            Log.e(TAG, "getStudents: ", e);
        }
        return studentModelList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}