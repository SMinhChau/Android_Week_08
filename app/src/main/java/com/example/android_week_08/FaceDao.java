package com.example.android_week_08;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FaceDao {
    @Query("SELECT * FROM face")
    List<Face> getAllFace();

    @Query("SELECT * FROM face WHERE id IN (:faceIds)")
    List<Face> loadAllByIds(int[] faceIds);

    @Query("SELECT * FROM face WHERE email LIKE :first LIMIT 1")
    Face findByName(String first, String last);

    @Insert
    void insertAll(Face faces);

    @Delete
    void delete(Face faces);

}
