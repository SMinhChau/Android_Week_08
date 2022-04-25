package com.example.android_week_08;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "face")
public class Face {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "happy")
    public int happy;

    @ColumnInfo(name = "lost")
    public int lost;

    @ColumnInfo(name = "error")
    public int error;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Face() {
    }

    public Face(@NonNull String email, int happy, int lost, int error) {
        this.email = email;
        this.happy = happy;
        this.lost = lost;
        this.error = error;
    }
}
