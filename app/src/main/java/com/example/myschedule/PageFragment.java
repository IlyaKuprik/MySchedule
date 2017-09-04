package com.example.myschedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Пользователь on 31.08.2017.
 */

public class PageFragment extends Fragment {

    ArrayList<String> mdLessons;
    ArrayList<String> twLessons;
    ArrayList<String> wnLessons;
    ArrayList<String> thLessons;
    ArrayList<String> frLessons;
    ArrayList<String> stLessons;
    ArrayAdapter<String> adapter;
    ListView lessons;
    private int pageNumber;

    public PageFragment() {
    }

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 0;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_page, container, false);
        Log.e("TAG", String.valueOf(pageNumber));
        initializeListView(result);
        if (pageNumber > 5){
            pageNumber = 0;
        }
        else pageNumber++;
        return result;
    }

    public ArrayList<String> getLessonsArr(int pageNumber) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Выход за пределы");
        if (pageNumber == 0) return mdLessons;
        else if (pageNumber == 1) return twLessons;
        else if (pageNumber == 2) return wnLessons;
        else if (pageNumber == 3) return thLessons;
        else if (pageNumber == 4) return frLessons;
        else if (pageNumber == 5) return stLessons;
        else return arr;
    }

    public void initializeLessonsArr(){
        mdLessons = new ArrayList<>();
        twLessons = new ArrayList<>();
        wnLessons = new ArrayList<>();
        thLessons = new ArrayList<>();
        frLessons = new ArrayList<>();
        stLessons = new ArrayList<>();

        mdLessons.add("1. 8:45 Информатика");
        mdLessons.add("2. 9:30 Физика");
        mdLessons.add("3. Литература");
        mdLessons.add("4. География");
        mdLessons.add("5. Алгебра");
        mdLessons.add("6. Английский");

        twLessons.add("1. 8:45 Алгебра");
        twLessons.add("2. 9:30 Информатика");
        twLessons.add("3. Электив");
        twLessons.add("4. История");
        twLessons.add("5. Русский язык");
        twLessons.add("6. Литература");
        twLessons.add("7. Физкультура");

        wnLessons.add("1. 8:45 Астрономия");
        wnLessons.add("2. 9:30 Алгебра");
        wnLessons.add("3. Русский язык");
        wnLessons.add("4. Физика");
        wnLessons.add("5. Геометрия");
        wnLessons.add("6. Английский язык");

        thLessons.add("1. 8:45 Физика");
        thLessons.add("2. 9:30 Химия");
        thLessons.add("3. Физика");
        thLessons.add("4. Информатика");
        thLessons.add("5. Русский язык");
        thLessons.add("6. Обществознание");

        frLessons.add("1. 8:45 Физкультура");
        frLessons.add("2. 9:30 Информатика");
        frLessons.add("3. Биология");
        frLessons.add("4. История");
        frLessons.add("5. Геометрия");
        frLessons.add("6. Английский язык");

        stLessons.add("1. Алгебра");
        stLessons.add("2. Литература");
        stLessons.add("3. Электив");
        stLessons.add("4. ОБЖ");
        stLessons.add("5. Обществознание");
    }

    public void initializeListView(View view){
        lessons=(ListView) view.findViewById(R.id.lv);
        initializeLessonsArr();
        adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, getLessonsArr(pageNumber));
        lessons.setAdapter(adapter);
    }
}
