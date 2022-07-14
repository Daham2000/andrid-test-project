package com.example.john_keels_it_project.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.john_keels_it_project.R;
import com.example.john_keels_it_project.adapter.StudentAdapter;
import com.example.john_keels_it_project.api.local.DBHandler;
import com.example.john_keels_it_project.model.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {
    private DBHandler dbHandler;
    List<StudentModel> students = new ArrayList<StudentModel>();
    View rootView;
    public StudentFragment() {
    }

    public static StudentFragment newInstance() {
        StudentFragment fragment = new StudentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        students = dbHandler.getStudents();
        // Add the following lines to create RecyclerView
        if(rootView!=null){
            RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewId);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
            recyclerView.setAdapter(new StudentAdapter(students));
        }
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbHandler = new DBHandler(getContext());
        students = dbHandler.getStudents();
        rootView = inflater.inflate(R.layout.fragment_student, container, false);

        // Add the following lines to create RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(new StudentAdapter(students));

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}