package com.example.john_keels_it_project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.john_keels_it_project.R;
import com.example.john_keels_it_project.model.StudentModel;

import java.util.List;
import java.util.Random;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.RecyclerViewHolder> {
    private List<StudentModel> studentModelList;

    public StudentAdapter(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.student_card;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.stuNameId.setText("ID: "+studentModelList.get(position).getStuId());
        holder.stuName.setText("Name: "+studentModelList.get(position).getStuName());
        holder.stuNameAge.setText("Age: "+studentModelList.get(position).getStuAge());
        holder.stuNameCourse.setText("Course name: "+ studentModelList.get(position).getStuCourseName());
    }

    @Override
    public int getItemCount() {
        return studentModelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView stuNameId;
        private TextView stuName;
        private TextView stuNameAge;
        private TextView stuNameCourse;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            stuNameId = itemView.findViewById(R.id.stuNameId);
            stuName = itemView.findViewById(R.id.stuName);
            stuNameAge = itemView.findViewById(R.id.stuNameAge);
            stuNameCourse = itemView.findViewById(R.id.stuNameCourse);
        }
    }
}