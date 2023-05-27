package com.assingment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Objects;

public class True_False extends AppCompatActivity {
    TextView qes, count;

    String[] tf_ques, tf_ans;

    String ans;

    ImageButton  b2;

    int index, score;

    CheckBox c1, c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);

        qes = findViewById(R.id.qes);
        count = findViewById(R.id.num);

        b2 = findViewById(R.id.imageButton2);
        c1 = findViewById(R.id.check1);
        c2 = findViewById(R.id.check2);
        index=0;

        tf_ques = getResources().getStringArray(R.array.TF_Questions);
        tf_ans = getResources().getStringArray(R.array.TF_Answers);

        qes.setText(tf_ques[index]);





        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2.setChecked(false);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1.setChecked(false);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < 9) {

                    if (c1.isChecked()) {
                        ans = "True";

                    }
                    if (c2.isChecked()) {
                        ans = "False";
                    }

                    if (Objects.equals(ans, tf_ans[index])) {
                        score++;
                        ans="";
                    }

                    c1.setChecked(false);
                    c2.setChecked(false);

                    index++;
                    qes.setText(tf_ques[index]);
                    count.setText(String.valueOf(index+1));

                }

                else {

                    qes.setText("Your Correct answers are: "+score+" From 10");
                    c1.setEnabled(false);
                    c2.setEnabled(false);

                    b2.setEnabled(false);
                }

            }
        });



    }
}