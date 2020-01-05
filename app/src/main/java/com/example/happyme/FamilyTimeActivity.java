package com.example.happyme;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import static com.example.happyme.Helper.decodeSampledBitmapFromResource;

public class FamilyTimeActivity extends AppCompatActivity {

    LayoutInflater inflater;    //Used to create individual pages
    ViewPager vp;               //Reference to class to swipe view

    int[] familyPicIds = {
            R.drawable.papa,
            R.drawable.mumma,
            R.drawable.bhai,
            R.drawable.bhabhi,
            R.drawable.me,
            R.drawable.wife
    };

    String[] familyNumer = {
            "Bestest Papa",
            "Bestest Mumma",
            "Bestest Bhai",
            "Bestest Bhabhi",
            "Bestest person in the universe",
            "Bestest partner"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_and_text_page);

        //get an inflater to be used to create single pages
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Reference ViewPager defined in activity
        vp=(ViewPager)findViewById(R.id.viewPagerImageAndText);
        //set the adapter that will create the individual pages
        vp.setAdapter(new MantrasPagesAdapter());
    }

    //Implement PagerAdapter Class to handle individual page creation
    class MantrasPagesAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            //Return total pages, here one for each data item
            return familyPicIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = inflater.inflate(R.layout.image_and_text_pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            //imageView.setImageResource(familyPicIds[position]);
            imageView.setImageBitmap(decodeSampledBitmapFromResource(getResources(), familyPicIds[position], 100, 100));
            TextView textView = (TextView) itemView.findViewById(R.id.textView);
            textView.setText(familyNumer[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}
