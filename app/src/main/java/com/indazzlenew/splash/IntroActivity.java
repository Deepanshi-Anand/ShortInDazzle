package com.indazzlenew.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.indazzlenew.R;
import com.indazzlenew.main.NavDrawerMain;

/**
 * Created by user on 24-06-2016.
 */
public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    static final int TOTAL_PAGES = 4;
    private ViewPager viewPager;
    private MyViewPagerAdapter myviewPagerAdapter;
    private LinearLayout downBarLayout;
    //private RelativeLayout downBarLayout;
    private int[] layouts;
    private LinearLayout circlearray;
    private TextView[] dots;
    private Button btnSkip;
    private Button btnDone;
    private ImageButton imgNext;
    private AllPrefManager prefManager;
    public Intent in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        prefManager = new AllPrefManager(this);
     //if (!prefManager.isFirstTimeLaunch())
      //   launchHomeScreen();
      //    finish();
     // }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

       // setContentView(R.layout.welcome);
        setContentView(R.layout.welcome_splash);

        //initializeVariables()  :-
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        downBarLayout = (LinearLayout) findViewById(R.id.downlayout);
        //downBarLayout = (RelativeLayout) findViewById(R.id.downlayout);
        circlearray=(LinearLayout) findViewById(R.id.circles);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnDone = (Button) findViewById(R.id.btn_done);
        imgNext = (ImageButton) findViewById(R.id.btn_imgnext);


        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.intro,
                R.layout.intro2,
                R.layout.intro3,
                R.layout.intro4

        };

        // adding bottom dots
        addBottomDots(0);
     //buildCircles();

        // making notification bar transparent
        changeStatusBarColor();

        btnSkip.setOnClickListener(this);
        btnDone.setOnClickListener(this);
        imgNext.setOnClickListener(this);

        myviewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myviewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_skip:
                launchHomeScreen();
                break;

            case R.id.btn_done:  // checking for last page
                // if last page home screen will be launched
                launchHomeScreen();
               break;

            case R.id.btn_imgnext:
                int current = getItem(0+1);
                if (current < layouts.length-1) {
                    // move to next screen

                    viewPager.setCurrentItem(current, true);
                }
                else {
                    launchHomeScreen();
                }
                break;

        }
    }

        private void addBottomDots(int currentPage) {
            dots = new TextView[layouts.length];

           // int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
            //int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

            //BLACK AND WHITE
           int[] colorsActive = getResources().getIntArray(R.array.array_dot_active_white);
           int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive_black);

          circlearray.removeAllViews();
            for (int i = 0; i < dots.length; i++) {
                dots[i] = new TextView(this);
               // dots[i].setText(Html.fromHtml("&#8226;"));
                dots[i].setText(" • ");
                dots[i].setTextSize(35);
                dots[i].setTextColor(colorsInactive[currentPage]);
                circlearray.addView(dots[i]);
            }

            if (dots.length > 0)
                dots[currentPage].setTextColor(colorsActive[currentPage]);
        }
/*
    private void buildCircles() {
        circles = LinearLayout.class.cast(findViewById(R.id.circles));

        float scale = getResources().getDisplayMetrics().density;
        int padding = (int) (5 * scale + 0.5f);

        for (int i = 0; i < TOTAL_PAGES - 1; i++) {
            ImageView circle = new ImageView(this);
            circle.setImageResource(R.drawable.ic_checkbox_blank_circle_white_18dp);
            circle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            circle.setAdjustViewBounds(true);
            circle.setPadding(padding, 0, padding, 0);
            circles.addView(circle);
        }

        setIndicator(0);
    }

    private void setIndicator(int index) {
        if (index < TOTAL_PAGES) {
            for (int i = 0; i < TOTAL_PAGES - 1; i++) {
                ImageView circle = (ImageView) circles.getChildAt(i);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (i == index) {
                        circle.setColorFilter(ResourcesCompat.getColor(getResources(),R.color.text_selected,null));

                    } else {
                        circle.setColorFilter(ResourcesCompat.getColor(getResources(),R.color.transparent_bg, null));
                    }
                }
            }
        }
    }
    */

        private int getItem(int i) {
            return viewPager.getCurrentItem() + i;
        }

        private void launchHomeScreen() {
            prefManager.setFirstTimeLaunch(false);
            in=new Intent(IntroActivity.this, NavDrawerMain.class);
            startActivity(in);
            finish();
        }

        //  viewpager change listener
        ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                addBottomDots(position);
             //   downBarLayout.setBackgroundColor(

                // changing the next button text 'NEXT' / 'GOT IT'

                    if (position == layouts.length - 1) {
                        // last page. make button text to GET
                        //      btnNext.setText(getString(R.string.start));

                        //btnNext.setOnClickListener(new View.OnClickListener() {
                        //launchHomeScreen();
                        //});
                        //imgNext.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_done_white_24px,null)
                        imgNext.setImageResource(R.drawable.ic_done_white_16dp_2x);
                        imgNext.setVisibility(View.VISIBLE);
                        btnSkip.setVisibility(View.GONE);
                    } else {
                        // still pages are left
                        // btnNext.setText(getString(R.string.next));
                        btnDone.setVisibility(View.GONE);
                        imgNext.setImageResource(R.drawable.ic_navigate_next_white_24dp);
                        imgNext.setVisibility(View.VISIBLE);
                        btnSkip.setVisibility(View.VISIBLE);
                    }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        };

        /**
         * Making notification bar transparent
         */
        private void changeStatusBarColor() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }




    public class MyViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;

    public MyViewPagerAdapter() {
        //MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter();
    }

    public Object instantiateItem(ViewGroup container, int position) {

       layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layouts[position], container, false);
        container.addView(view);
        return view;

    }

    public void destroyItem(ViewGroup container, int position, Object obj) {

        View view = (View) obj;
        container.removeView(view);
    }

    public int getCount() {
        return layouts.length;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == object;

    }

 }

   /*
    private class ScreenSlideAdapter extends FragmentStatePagerAdapter {

        public ScreenSlideAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            WelcomeScreenFragment welcomeScreenFragment = null;
            switch (position) {
                case 0:
                    welcomeScreenFragment = WelcomeScreenFragment.newInstance(R.layout.fragment_screen1);
                    break;
                case 1:
                    welcomeScreenFragment = WelcomeScreenFragment.newInstance(R.layout.fragment_screen2);
                    break;
                case 2:
                    welcomeScreenFragment = WelcomeScreenFragment.newInstance(R.layout.fragment_screen3);
                    break;
                case 3:
                    welcomeScreenFragment = WelcomeScreenFragment.newInstance(R.layout.fragment_screen4);
                    break;
            }

            return welcomeScreenFragment;
        }
        */


    }
