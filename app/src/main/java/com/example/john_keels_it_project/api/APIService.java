package com.example.john_keels_it_project.api;
import com.example.john_keels_it_project.model.StudentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @GET("student/")
    Call<List<StudentModel>> getStudentList();

    @POST("student/")
    Call<StudentModel> addStudent(StudentModel studentModel);
}
