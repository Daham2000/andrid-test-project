package com.example.john_keels_it_project.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.john_keels_it_project.api.APIService;
import com.example.john_keels_it_project.api.RetroInstance;
import com.example.john_keels_it_project.model.StudentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentCtrl {
    List<StudentModel> studentList;

    private static StudentCtrl studentCtrl;

    private StudentCtrl() {
    }

    public static StudentCtrl getInstance() {
        if (studentCtrl == null) {
            studentCtrl = new StudentCtrl();
        }
        return studentCtrl;
    }

    public List<StudentModel> getStudentList() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<StudentModel>> call = apiService.getStudentList();
        call.enqueue(new Callback<List<StudentModel>>() {
            @Override
            public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                studentList = response.body();
            }

            @Override
            public void onFailure(@NonNull Call<List<StudentModel>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
        return studentList;
    }

    public void addStudent(StudentModel studentModel) {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<StudentModel> call = apiService.addStudent(studentModel);
        call.enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {

            }
        });
    }

    public void addAllStudent(List<StudentModel> studentModel) {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<StudentModel> call = apiService.addStudentList(studentModel);
        call.enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {

            }
        });
    }
}
