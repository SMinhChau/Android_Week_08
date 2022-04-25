package com.example.android_week_08;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Face.class}, version = 1)
public abstract class FaceDataBaseHandler  extends RoomDatabase {
    public abstract FaceDao userDAO();

}
