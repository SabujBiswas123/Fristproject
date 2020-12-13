package com.english.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.util.function.Function;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation meo;
    private ViewPager2 viewPager2;


    private final static int Id_home=1;
    private final static int Id_sound=2;
    private final static int Id_about=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meo=findViewById(R.id.bottom);


        meo.show(2,true);
        meo.add(new MeowBottomNavigation.Model(1,R.drawable.ic1));
        meo.add(new MeowBottomNavigation.Model(2,R.drawable.ic));
        meo.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_error_24));


       getSupportFragmentManager().beginTransaction().replace(R.id.ssss, new Fragment_sound()).commit();

        meo.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(getApplicationContext(), "Click item"+item.getId(),Toast.LENGTH_SHORT).show();


            }
        });




        meo.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                Fragment select_fragment=null;
                switch (item.getId()){
                    case Id_home:
                        select_fragment=new Fragment_home();
                        break;

                    case Id_sound:
                        select_fragment=new Fragment_sound();
                        break;

                    case Id_about:
                        select_fragment=new Fragment_about();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.ssss,select_fragment).commit();

            }
        });


        meo.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });
        

    }


}