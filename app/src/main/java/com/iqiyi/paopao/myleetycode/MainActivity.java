package com.iqiyi.paopao.myleetycode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.iqiyi.paopao.myleetycode.num.Solution.twoSum;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] nums = {2,7,11,15};
        int target = 9;
        twoSum(nums, 9);
    }
}
