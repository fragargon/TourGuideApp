package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /* Declare a private variable to set maximum value of imageIndex */
    private final int INDEX_IMAGES;
    {
        INDEX_IMAGES = 7;
    }

    /* Declare global variable */
    String hotels, events, drink, info;
    TextView title;
    ImageView image, icon;
    ListView listView;

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
        drink = getResources().getString(R.string.drink);
        info = getResources().getString(R.string.info);

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
        itemListModel.add(new ItemListModel(drink, R.drawable.cat3, R.drawable.ic_navigate_next));
        itemListModel.add(new ItemListModel(info, R.drawable.cat4, R.drawable.ic_navigate_next));

        /*
         Create {@link ItemListModel} a listView
         the data source is a list of object from the ArrayList.
        */
        ListAdapter adapter = new ListAdapter(this, itemListModel);
        listView = findViewById(R.id.list_container_main);
        listView.setAdapter(adapter);

        /* Create an intent to handle onItemClick position and send it to ViewPagerActivity */
        final Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);

        // Bind the abstract method to the ListView and gives parameters to its interface
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                        intent.putExtra("category", 3); // DrinkFragment
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("category", 4); // InfoFragment
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
