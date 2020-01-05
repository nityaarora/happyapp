package com.example.happyme;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoostUpTimeActivity extends AppCompatActivity {

    LayoutInflater inflater;    //Used to create individual pages
    ViewPager vp;               //Reference to class to swipe view
    static Map<String, Class> map = new HashMap();

   String[] boostUpTimeItems = {
           "Revise Mantras",
           "Again Revise mantras",
           "Smile acha wala",
           "Imagine someone copying you",
           "Enjoy images",
           "Play Rock Paper Scissor",
           "Go for a Walk",
           "Play thumb game",
           "Watch tom and jerry",
           "Again Revise mantras",
           "Watch yo yo khalsa",
           "Watch babies or puppies videos",
           "Guess images",
           "Watch aloo kachalu",
           "Write down your feelings",
           "Smile",
           "Do what you love...."

    };

   List itemsAsButtons = Arrays.asList("Revise Mantras",
           "Again Revise mantras",
           "Enjoy images",
           "Guess images");

   static {
       map.put("Revise Mantras", MantrasActivity.class);
       map.put("Again Revise mantras", MantrasActivity.class);
       map.put("Enjoy images", EnjoyImagesActivity.class);
       map.put("Guess images", GuessImagesActivity.class);
   }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_and_button_pager);

        //get an inflater to be used to create single pages
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Reference ViewPager defined in activity
        vp=(ViewPager)findViewById(R.id.textAndButtonPager);
        //set the adapter that will create the individual pages
        vp.setAdapter(new MantrasPagesAdapter());
    }

    //Implement PagerAdapter Class to handle individual page creation
    class MantrasPagesAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            //Return total boostUpTimeItems, here one for each data item
            return boostUpTimeItems.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View itemView = inflater.inflate(R.layout.text_and_button_pager_item, container, false);

            TextView textView = (TextView) itemView.findViewById(R.id.textView);
            Button button = (Button) itemView.findViewById(R.id.button);
            if (itemsAsButtons.contains(boostUpTimeItems[position])) {
                textView.setText("");
                button.setText(boostUpTimeItems[position]);
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openActivity(map.get(boostUpTimeItems[position]));
                    }
                });
                textView.setVisibility(View.GONE);
            } else {
                textView.setText(boostUpTimeItems[position]);
                if (position % 2 != 0) {
                    textView.setTextColor(Color.parseColor("#CF3BDC"));
                } else {
                    textView.setTextColor(Color.parseColor("#2538C1"));
                }
                textView.setVisibility(View.VISIBLE);
                button.setVisibility(View.GONE);
            }


            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }

    private void openActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
