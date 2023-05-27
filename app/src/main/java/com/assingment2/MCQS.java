package com.assingment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Objects;

public class MCQS extends AppCompatActivity {

    TextView qes,count;

    String [] questions,option_a,option_b,option_c,option_d,correct;
    String ans;

    ImageButton b2;
    int index,score;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqs);

        index=0;

        qes=findViewById(R.id.qes);
        count=findViewById(R.id.num);
        b2=findViewById(R.id.imageButton2);
        r1=findViewById(R.id.radio1);
        r2=findViewById(R.id.radio2);
        r3=findViewById(R.id.radio3);
        r4=findViewById(R.id.radio4);



        questions=getResources().getStringArray(R.array.mcqs_Question);
        option_a=getResources().getStringArray(R.array.option_a);
        option_b=getResources().getStringArray(R.array.option_b);
        option_c=getResources().getStringArray(R.array.option_c);
        option_d=getResources().getStringArray(R.array.option_d);
        correct=getResources().getStringArray(R.array.correct);


        qes.setText(questions[index]);
        r1.setText(option_a[index]);
        r2.setText(option_b[index]);
        r3.setText(option_c[index]);
        r4.setText(option_d[index]);




        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<9) {
                    r1.setEnabled(true);
                    r2.setEnabled(true);
                    r3.setEnabled(true);
                    r4.setEnabled(true);
                    if (r1.isChecked()) {
                        ans = option_a[index];

                    }
                    else if (r2.isChecked()) {
                        ans = option_b[index];

                    }
                    else  if (r3.isChecked()) {
                        ans =option_c[index];

                    }
                    if (r4.isChecked()) {
                        ans = option_d[index];

                    }
                    if(Objects.equals(ans, correct[index])){
                        score++;
                        ans="";
                    }


                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                    r4.setChecked(false);


                    index++;
                    qes.setText(questions[index]);
                    r1.setText(option_a[index]);
                    r2.setText(option_b[index]);
                    r3.setText(option_c[index]);
                    r4.setText(option_d[index]);
                    count.setText(String.valueOf(index + 1));


                }
                else {

                    qes.setText("Your Correct answers are: "+score+" From 10");
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    r4.setEnabled(false);

                    r1.setText("");
                    r2.setText("");
                    r3.setText("");
                    r4.setText("");
                    b2.setEnabled(false);
                    }





                }



        });




    }
}