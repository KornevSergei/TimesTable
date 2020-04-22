package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //создаем ссылки
    private ListView listViewNumbers;
    private SeekBar seekBar;

    //создаем массив с числами
    private ArrayList<Integer> numbers;
    //создаем максимум и минимум для сикбара
    private int max = 20;
    private int min = 1;
    //сощдаем количество элементов в таблице
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNumbers = findViewById(R.id.listViewNumbers);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(max);

        numbers = new ArrayList<>();
        //заполняем лист аррей адаптером
        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
        //устанавливаем данные для листВью
        listViewNumbers.setAdapter(arrayAdapter);

        //создаем слушатель события для сикбара
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numbers.clear();
                if (progress < min) {
                    seekBar.setProgress(min);
                }
                for (int i = min; i <= count; i++) {
                    numbers.add(seekBar.getProgress() * i);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(10);
    }
}
