package com.iqiyi.paopao.myleetycode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.iqiyi.paopao.myleetycode.num.Solution.binarySearch;
import static com.iqiyi.paopao.myleetycode.num.Solution.majorityElement;
import static com.iqiyi.paopao.myleetycode.num.Solution.reversePairs;
import static com.iqiyi.paopao.myleetycode.num.Solution.singleNumbers;
import static com.iqiyi.paopao.myleetycode.num.Solution.twoSum;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] nums = {7,5,6,4};
        int target = 9;
        reversePairs(nums);
    }
}
