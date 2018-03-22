package com.example.android.tourguideapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.com.example.android.tourguideapp.adapter.GridAdapter;
import com.example.android.tourguideapp.com.example.android.tourguideapp.model.Places;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /* Declare global variable */
    String[] categories;
    TextView title;
    ImageView photo, icon;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initialize variable */
        title = findViewById(R.id.title);
        icon = findViewById(R.id.icon);
        photo = findViewById(R.id.image);

        // get the categories string names
        Resources res = getResources();
        categories = res.getStringArray(R.array.categories_title);

        /* Create an {@link ArrayList} from Places Class (constructor) */
        final ArrayList<Places> Places = new ArrayList<>();
        int n = 6;
        int i;
        for(i = 0; i < n; i++) {
            // get the categories drawables
            int drawableId = getResources().getIdentifier("cat" + (i+1) , "drawable", getPackageName());
            Places.add(new Places(categories[i], drawableId, R.drawable.ic_navigate_next));
        }

        /*
         Create {@link Places} a gridView
         the data source is a list of object from the ArrayList.
        */
        GridAdapter adapter = new GridAdapter(this, Places);
        gridView = findViewById(R.id.grid_container);
        gridView.setAdapter(adapter);

        /* Create an intent to handle onItemClick position and send it to PagerActivity */
        final Intent intent = new Intent(MainActivity.this, PagerActivity.class);

        // Bind the abstract method to the gridView and gives parameters to its interface
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent.putExtra("category",0); // InfoFragment
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("category",1); // HotelFragment
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("category", 2); // FoodFragment
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("category", 3); // BarFragment
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("category", 4); // EventsFragment
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("category", 5); // PlacesFragment
                        startActivity(intent);
                        break;
                        default:
                            intent.putExtra("category", 0); // InfoFragment
                            startActivity(intent);
                            break;
                }
            }
        });

    }
}
