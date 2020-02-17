package com.example.score_indicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.score_indicator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // 创建ViewModel引用以及DataBinding引用
    MyViewModel myViewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联需要被控制的activity_main.xml
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // 关联你提供的ViewModel类
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);


        // 设置需要被操作数据的对象
        binding.setData(myViewModel);
        // 设置生命周期的对象
        binding.setLifecycleOwner(this);

    }
}
