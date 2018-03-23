package com.org.curesoft.fragmentexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity implements TestFragment.frag_interface {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.frame1)!=null){
            if(savedInstanceState!=null){
                return;
            }
            Fragment fragment=new TestFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame1,fragment,null).commit();
        }








    }


    @Override
    public void sendData(String s) {
        Fragment fragmentMessage=new MessageFragment();
        Bundle b=new Bundle();
        b.putString("message",s);
        fragmentMessage.setArguments(b);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1,fragmentMessage,null).addToBackStack(null).commit();

    }
}
