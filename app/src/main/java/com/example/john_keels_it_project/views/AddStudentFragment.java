package com.example.john_keels_it_project.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.john_keels_it_project.MainActivity;
import com.example.john_keels_it_project.R;
import com.example.john_keels_it_project.api.local.DBHandler;
import com.example.john_keels_it_project.model.StudentModel;

import org.jetbrains.annotations.NotNull;

public class AddStudentFragment extends Fragment {

    public AddStudentFragment() {
    }

    public static AddStudentFragment newInstance() {
        AddStudentFragment fragment = new AddStudentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private EditText idText, nameText, ageText, courseText;
    private Button addStudentBtn;
    private DBHandler dbHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHandler = new DBHandler(getContext());

        idText = view.findViewById(R.id.stuId);
        nameText = view.findViewById(R.id.stuName);
        ageText = view.findViewById(R.id.stuAge);
        courseText = view.findViewById(R.id.courseName);
        addStudentBtn = view.findViewById(R.id.idStuAddBtn);


        addStudentBtn.setOnClickListener(v -> {
            StudentModel studentModel = new StudentModel();
            studentModel.setStuId(idText.getText().toString());
            studentModel.setStuName(nameText.getText().toString());
            studentModel.setStuAge(ageText.getText().toString());
            studentModel.setStuCourseName(courseText.getText().toString());

            if (idText.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "All fields can't be empty", Toast.LENGTH_SHORT).show();
            } else {
                dbHandler.addStudent(studentModel);
                Toast.makeText(getContext(), "Student added.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}