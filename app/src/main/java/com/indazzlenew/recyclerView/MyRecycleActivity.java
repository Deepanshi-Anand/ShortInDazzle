package com.indazzlenew.recyclerView;

/**
 * Created by user on 04-07-2016.
 */

/*
public class MyRecycleActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener,ImageLoader.ImageListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

 //   List<TrendCategories> categories;
 //   List<TrendServices> services;
   // CarouselView carouselView;
    ProgressDialog pd;
    ArrayList<String> url;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
    // */

/*

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.recycle_activity);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            pd=new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
            pd.setMessage("Getting Your Things Ready....");
            pd.show();
           // String trendresponse=getIntent().getStringExtra("trend");
            //String carouselresponse=getIntent().getStringExtra("carousel");

            //Checks the trend servics
         // Connection connection=new Connection(getString(R.string.check),this);
         //   connection.connect();
            //Calls the trend service
            //ConnectionTrend connectionTrend = new ConnectionTrend(url, MainActivityExpandable.this, this);
        //   carouselView = (CarouselView) findViewById(R.id.carouselView);
            //  ConnectionCarousel connectionCarousel=new ConnectionCarousel("http://facilitydoor.com/api/carousel.php",MainActivityExpandable.this,this);
            //connectionCarousel.connect();

            // carouselView.setImageListener(imageListener);


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);
            // connectionTrend.connect();
      //      parsejson(trendresponse);
        //    parsejsoncarousel(carouselresponse);
            findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
      //              Intent intent=new Intent(this,BookServices.class);
      //              startActivity(intent);
                }
            });
            //mAdapter = new MyAdapterMain(str, MainActivityExpandable.this);
            // mRecyclerView.setAdapter(mAdapter);
            //  mRecyclerView.setAdapter(mAdapter);
        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.nav_drawer, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            //if (id == R.id.action_settings) {
            //    return true;
            //}

            return super.onOptionsItemSelected(item);
        }


    @Override
    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}

*/