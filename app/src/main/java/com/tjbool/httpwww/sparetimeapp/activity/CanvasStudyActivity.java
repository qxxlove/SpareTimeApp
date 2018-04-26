package com.tjbool.httpwww.sparetimeapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.custom.TemperatureView;
import com.tjbool.httpwww.sparetimeapp.entity.StudentBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CanvasStudyActivity extends AppCompatActivity {

    @BindView(R.id.temp_one)
    TemperatureView tempOne;


    private List<StudentBean>  list ;
    private  List<StudentBean>  studentBeanListOne;
    private List<StudentBean>  studentBeanListTwo;
    private List<StudentBean>  studentBeanListThree;
    private List<StudentBean>  studentBeanListFour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_study);
        ButterKnife.bind(this);
        tempOne.start(10);


        initData();


    }

    private void initData() {
        list =  new ArrayList<>();
        studentBeanListOne =  new ArrayList<>();
        studentBeanListTwo =  new ArrayList<>();
        studentBeanListThree =  new ArrayList<>();
        studentBeanListFour =  new ArrayList<>();
        list.add(new StudentBean(1,"sdjfhj"));
        list.add(new StudentBean(2,"sdjfhj"));
        list.add(new StudentBean(4,"sdjfhj"));
        list.add(new StudentBean(7,"sdjfhj"));
        list.add(new StudentBean(8,"sdjfhj"));
        list.add(new StudentBean(0,"sdjfhj"));
        list.add(new StudentBean(77,"sdjfhj"));
        list.add(new StudentBean(44,"sdjfhj"));
        list.add(new StudentBean(47,"sdjfhj"));
        list.add(new StudentBean(25,"sdjfhj"));
        list.add(new StudentBean(20,"sdjfhj"));
        list.add(new StudentBean(365,"sdjfhj"));
        list.add(new StudentBean(58,"sdjfhj"));
        list.add(new StudentBean(77,"sdjfhj"));
        list.add(new StudentBean(89,"sdjfhj"));
        list.add(new StudentBean(1285,"sdjfhj"));


        for (int i = 0; i < list.size(); i++) {
             if (list.get(i).getsId() / 5 == 0){
                 studentBeanListOne.add(list.get(i));
             }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getsId() / 1 == 0){
                studentBeanListTwo.add(list.get(i));
            }
        }


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getsId() / 2 == 0){
                studentBeanListThree.add(list.get(i));
            }
        }


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getsId() / 3 == 0){
                studentBeanListFour.add(list.get(i));
            }
        }

        Log.d("大小",studentBeanListOne.size()+"");
        Log.d("大小",studentBeanListTwo.size()+"");
        Log.d("大小",studentBeanListThree.size()+"");
        Log.d("大小",studentBeanListFour.size()+"");
        tempOne.setListOne(studentBeanListOne);
        tempOne.setListTwo(studentBeanListTwo);
        tempOne.setListThree(studentBeanListThree);
        tempOne.setListFour(studentBeanListFour);



    }
}
