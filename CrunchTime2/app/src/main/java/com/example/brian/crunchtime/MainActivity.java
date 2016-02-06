package com.example.brian.crunchtime;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText[] array = new EditText[12];
    Map<Integer, TextView> exercises = new HashMap<Integer, TextView>();
    Map<TextView, Integer> conversions = new HashMap<TextView, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1 = (EditText)findViewById(R.id.editText);
        EditText e2 = (EditText)findViewById(R.id.editText2);
        EditText e3 = (EditText)findViewById(R.id.editText3);
        EditText e4 = (EditText)findViewById(R.id.editText4);
        EditText e5 = (EditText)findViewById(R.id.editText5);
        EditText e6 = (EditText)findViewById(R.id.editText6);
        EditText e7 = (EditText)findViewById(R.id.editText7);
        EditText e8 = (EditText)findViewById(R.id.editText8);
        EditText e9 = (EditText)findViewById(R.id.editText9);
        EditText e10 = (EditText)findViewById(R.id.editText10);
        EditText e11 = (EditText)findViewById(R.id.editText11);
        EditText e12 = (EditText)findViewById(R.id.editText12);
        TextView t1 = (TextView)findViewById(R.id.textView);
        TextView t2 = (TextView)findViewById(R.id.textView2);
        TextView t3 = (TextView)findViewById(R.id.textView3);
        TextView t4 = (TextView)findViewById(R.id.textView4);
        TextView t5 = (TextView)findViewById(R.id.textView5);
        TextView t6 = (TextView)findViewById(R.id.textView6);
        TextView t7 = (TextView)findViewById(R.id.textView7);
        TextView t8 = (TextView)findViewById(R.id.textView8);
        TextView t9 = (TextView)findViewById(R.id.textView9);
        TextView t10 = (TextView)findViewById(R.id.textView10);
        TextView t11 = (TextView)findViewById(R.id.textView11);
        TextView t12 = (TextView)findViewById(R.id.textView12);
        array[0] = e1; array[1] = e2; array[2] = e3; array[3] = e4;
        array[4] = e5; array[5] = e6; array[6] = e7; array[7] = e8;
        array[8] = e9; array[9] = e10; array[10] = e11; array[11] = e12;
        exercises.put(1, t1);
        exercises.put(2, t2);
        exercises.put(3, t3);
        exercises.put(4, t4);
        exercises.put(5, t5);
        exercises.put(6, t6);
        exercises.put(7, t7);
        exercises.put(8, t8);
        exercises.put(9, t9);
        exercises.put(10, t10);
        exercises.put(11, t11);
        exercises.put(12, t12);
        conversions.put(t1, 350);
        conversions.put(t2, 200);
        conversions.put(t3, 225);
        conversions.put(t4, 25);
        conversions.put(t5, 25);
        conversions.put(t6, 10);
        conversions.put(t7, 100);
        conversions.put(t8, 12);
        conversions.put(t9, 20);
        conversions.put(t10, 12);
        conversions.put(t11, 13);
        conversions.put(t12, 15);
    }

    public TextView getExercise(int n, Map<Integer, TextView> exercises) {
        return exercises.get(n);
    }

    public double getConversion(double user_input, TextView exercise, Map<TextView, Integer> conversions) {
        double reps_or_min = conversions.get(exercise);
        return (user_input * 100) / reps_or_min;
    }

    public HashMap<TextView, Double> allConversions(double calories, Map<TextView, Integer> conversions) {
        HashMap<TextView, Double> all_conversions = new HashMap<TextView, Double>();
        for (TextView exercise: conversions.keySet()) {
            double reps_or_min = conversions.get(exercise);
            double converted = (reps_or_min * calories) / 100;
            all_conversions.put(exercise, converted);
        }
        return all_conversions;
    }

    public void onClickButton(View v) {
        EditText e13 = (EditText)findViewById(R.id.editText13);
        try {
            int input = Integer.parseInt(((EditText) e13).getText().toString());
            for (int i=0; i<12; i++) {
                TextView exercise = exercises.get(i+1);
                double reps_or_mins = conversions.get(exercise);
                ((EditText) array[i]).setText(Double.toString((reps_or_mins / 100) * input));
            }
            e13.setText(Double.toString((double) input));
        }
        catch (NumberFormatException e1) {
            for (int i = 0; i < 12; i++) {
                try {
                    int input = Integer.parseInt(((EditText) array[i]).getText().toString());
                    TextView exercise = getExercise(i + 1, exercises);
                    double calories = getConversion(input, exercise, conversions);
                    HashMap<TextView, Double> all_calories = allConversions(calories, conversions);
                    for (int k = 0; k < 12; k++) {
                        ((EditText) array[k]).setText(Double.toString(all_calories.get(getExercise(k + 1, exercises))));
                    }
                    e13.setText(Double.toString(calories));
                    break;
                } catch (NumberFormatException e2) {
                }
            }
        }
    }


    public void onClickButton2(View v) {
        EditText e13 = (EditText)findViewById(R.id.editText13);
        for (int i=0; i<12; i++) {
            ((EditText) array[i]).setText("");
        }
        e13.setText("");
    }


}
