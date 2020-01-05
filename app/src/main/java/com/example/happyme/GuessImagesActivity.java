package com.example.happyme;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import static com.example.happyme.Helper.decodeSampledBitmapFromResource;

public class GuessImagesActivity extends AppCompatActivity {

    LayoutInflater inflater;    //Used to create individual pages
    ViewPager vp;               //Reference to class to swipe view
    PopupWindow popUp;


    int[] guessPicIds = {
            R.drawable.cat,
            R.drawable.tree,
            R.drawable.mango,
            R.drawable.cloud,
            R.drawable.planets,
            R.drawable.toffee,
            R.drawable.laptop,
            R.drawable.batnball,
            R.drawable.birds,
            R.drawable.grapes,
            R.drawable.fish,
            R.drawable.football,
            R.drawable.stars,
            R.drawable.bus,
            R.drawable.cards,
            R.drawable.pizza,
            R.drawable.plane,
            R.drawable.butterfly,
            R.drawable.elephant,
            R.drawable.flower,
            R.drawable.friends,
            R.drawable.rat,
            R.drawable.mug,
            R.drawable.scenery

    };

    String[] guessPicLabels = {
            "Cat",
            "Tree",
            "Mango",
            "Cloud",
            "Planets",
            "Toffee",
            "Laptop",
            "Bat and ball",
            "Birds",
            "Grapes",
            "Fish",
            "Football",
            "Stars",
            "Bus",
            "Cards",
            "Pizza",
            "Plane",
            "Butterfly",
            "Elephant",
            "Flower",
            "Friends",
            "Rat",
            "Mug",
            "Scenery"
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


    private View.OnClickListener cancel_button_click_listener = new View.OnClickListener() {
        public void onClick(View v) {
            popUp.dismiss();
        }
    };

    private void initiatePopupWindow(int position) {

        LayoutInflater inflater1 = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout1 = inflater.inflate(R.layout.popup,
                (ViewGroup) findViewById(R.id.popup_element));

        popUp = new PopupWindow(layout1, 500, 500, true);
        popUp.showAtLocation(layout1, Gravity.CENTER, 0, 0);

        Button btnClosePopup = (Button) layout1.findViewById(R.id.btn_close_popup);
        btnClosePopup.setOnClickListener(cancel_button_click_listener);

        TextView textView = (TextView) layout1.findViewById(R.id.txtView);
        textView.setText(guessPicLabels[position]);

    }

    //Implement PagerAdapter Class to handle individual page creation
    class MantrasPagesAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            //Return total pages, here one for each data item
            return guessPicIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View itemView = inflater.inflate(R.layout.image_and_text_pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            //imageView.setImageResource(guessPicIds[position]);
            imageView.setImageBitmap(decodeSampledBitmapFromResource(getResources(), guessPicIds[position], 100, 100));
            imageView.setClickable(true);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initiatePopupWindow(position);
                }
            });


            TextView textView = (TextView) itemView.findViewById(R.id.textView);
            textView.setText("");

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}
