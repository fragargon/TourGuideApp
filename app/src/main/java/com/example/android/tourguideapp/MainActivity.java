package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /* Declare a private constant variable to set maximum value of INDEX_IMAGES */
    private final int INDEX_IMAGES;
    {
        INDEX_IMAGES = 7;
    }

    /* Declare global variable */
    String hotels, events, food, info, bar, places;
    TextView title;
    ImageView image, icon;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initialize variable */
        title = findViewById(R.id.title);
        icon = findViewById(R.id.icon);
        image = findViewById(R.id.image);
        hotels = getResources().getString(R.string.hotels);
        events = getResources().getString(R.string.events);
        food = getResources().getString(R.string.food);
        info = getResources().getString(R.string.info);
        bar = getResources().getString(R.string.bar);
        places = getResources().getString(R.string.places);

        /* Display a random image background */
        int imageIndex = (int) (Math.random()* INDEX_IMAGES) +1;
        String imageIndexToString = String.format(Locale.getDefault(),"%1d", imageIndex);
        int imageId = getResources().getIdentifier("bckg" + imageIndexToString, "drawable", getPackageName());
        ImageView image = findViewById(R.id.header_image);
        image.setImageDrawable(getResources().getDrawable(imageId));

        /* Create an {@link ArrayList} from ItemListModel Class (constructor) */
        final ArrayList<ItemListModel>itemListModel = new ArrayList<>();
        itemListModel.add(new ItemListModel(hotels, R.drawable.cat1, R.drawable.ic_navigate_next));
        itemListModel.add(new ItemListModel(events, R.drawable.cat2, R.drawable.ic_navigate_next));
        itemListModel.add(new ItemListModel(food, R.drawable.cat3, R.drawable.ic_navigate_next));
        itemListModel.add(new ItemListModel(info, R.drawable.cat4, R.drawable.ic_navigate_next));
        itemListModel.add(new ItemListModel(bar, R.drawable.cat5, R.drawable.ic_navigate_next));
        itemListModel.add(new ItemListModel(places,R.drawable.cat6, R.drawable.ic_navigate_next));

        /*
         Create {@link ItemListModel} a gridView
         the data source is a list of object from the ArrayList.
        */
        ListAdapter adapter = new ListAdapter(this, itemListModel);
        gridView = findViewById(R.id.grid_container);
        gridView.setAdapter(adapter);

        /* Create an intent to handle onItemClick position and send it to ViewPagerActivity */
        final Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);

        // Bind the abstract method to the gridView and gives parameters to its interface
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent.putExtra("category",1); // HotelFragment
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("category",2); // EventsFragment
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("category", 3); // FoodFragment
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("category", 4); // InfoFragment
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("category", 5); // BarFragment
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("category", 6); // PlacesFragment
                        startActivity(intent);
                        break;
                        default:
                            intent.putExtra("category", 1); // HotelFragment
                            startActivity(intent);
                            break;
                }
            }
        });

    }
}
