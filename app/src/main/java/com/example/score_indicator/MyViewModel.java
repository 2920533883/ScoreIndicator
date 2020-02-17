// 创建ViewModel类来存放数据以及方法


package com.example.score_indicator;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    // 创建需要的LiveDate类型的数据
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private int[] undoa = new int[100];
    private int[] undob = new int[100];
    private int atimes = 0, btimes = 0;

    public MutableLiveData<Integer> getaTeamScore() {
        // 判空很必要！
        if (aTeamScore == null)
        {
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
            undoa[++atimes] = 0;
        }
        return aTeamScore;
    }
    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore == null)
        {
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
            undob[++atimes] = 0;
        }
        return bTeamScore;
    }


    // 创建需要的方法
    public void aTeamAdd(int num) {
        aTeamScore.setValue(aTeamScore.getValue() + num);
        undoa[++atimes] = aTeamScore.getValue();
    }
    public void bTeamAdd(int num) {
        bTeamScore.setValue(bTeamScore.getValue() + num);
        undob[++btimes] = bTeamScore.getValue();
    }
    public void reset(){
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
        undoa[++atimes] = 0;
        undob[++btimes] = 0;
    }
    public void undoa(){
        if (atimes != 0) aTeamScore.setValue(undoa[--atimes]);
    }
    public void undob(){
        if (btimes != 0) bTeamScore.setValue(undob[--btimes]);
    }
}
