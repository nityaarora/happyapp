package com.example.happyme;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MeTimeActivity extends AppCompatActivity {

    LayoutInflater inflater;    //Used to create individual pages
    ViewPager vp;               //Reference to class to swipe view

   String[] meTimeItems = {
           "Meditate",
           "Play Flute",
           "Kick boxing",
           "Listen to English Songs",
           "Learn magic",
           "Learn cards",
           "Learn about universe",
           "Exercise",
           "Study",
           "Dive into stocks",
           "Sing a song",
           "Enjoy Humming",
           "Do what you love...."

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_only_pager);

        //get an inflater to be used to create single pages
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Reference ViewPager defined in activity
        vp=(ViewPager)findViewById(R.id.textPager);
        //set the adapter that will create the individual pages
        vp.setAdapter(new MantrasPagesAdapter());
    }

    //Implement PagerAdapter Class to handle individual page creation
    class MantrasPagesAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            //Return total boostUpTimeItems, here one for each data item
            return meTimeItems.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = inflater.inflate(R.layout.text_only_pager_item, container, false);

            TextView textView = (TextView) itemView.findViewById(R.id.textView);
            textView.setText(meTimeItems[position]);
            if (position % 2 != 0) {
                textView.setTextColor(Color.parseColor("#CF3BDC"));
            } else {
                textView.setTextColor(Color.parseColor("#2538C1"));
            }

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }
}
