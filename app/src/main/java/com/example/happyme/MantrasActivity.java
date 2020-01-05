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

public class MantrasActivity extends AppCompatActivity {

    LayoutInflater inflater;    //Used to create individual pages
    ViewPager vp;               //Reference to class to swipe view

    int[] mantrasPicIds = {
            R.drawable.mantra1,
            R.drawable.mantra2,
            R.drawable.mantra3,
            R.drawable.mantra4
    };

    String[] mantrasNumer = {
            "Mantra No. 1",
            "Mantra No. 2",
            "Mantra No. 3",
            "Mantra No. 4"
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
            return mantrasPicIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = inflater.inflate(R.layout.image_and_text_pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            //imageView.setImageResource(mantrasPicIds[position]);
            imageView.setImageBitmap(decodeSampledBitmapFromResource(getResources(), mantrasPicIds[position], 100, 100));

            TextView textView = (TextView) itemView.findViewById(R.id.textView);
            textView.setText(mantrasNumer[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}
