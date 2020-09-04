package com.iqiyi.paopao.myleetycode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.iqiyi.paopao.myleetycode.num.NumSolution.findContinuousSequence;
import static com.iqiyi.paopao.myleetycode.num.NumSolution.hammingWeight;
import static com.iqiyi.paopao.myleetycode.num.NumSolution.reverseWords;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String ssss = "a good      example";
        reverseWords(ssss);
        findContinuousSequence(5);
        hammingWeight(00000000000000000000000010000000);
    }
}
