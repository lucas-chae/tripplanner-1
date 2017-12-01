package cs465.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageButton yourTripsButton = findViewById(R.id.your_trips_button);
        yourTripsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, YourTripsActivity.class);
                startActivity(i);
            }
        });

        FloatingActionButton fab = findViewById(R.id.home_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, AddLocationActivity.class);
                startActivity(i);
            }
        });

        ArrayList<TripItem> trip_locs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            trip_locs.add(new TripItem("User " + i, "Location " + i, 100 * i, new String[]{"tag1", "tag2"}));
        }
//        trip_locs.add("Paris, France");
//        trip_locs.add("Brooklyn, NY");
//        trip_locs.add("Menlo Park, CA");
//        trip_locs.add("Loc 1");
//        trip_locs.add("Loc 2");

        TripListAdapter adapter = new TripListAdapter(trip_locs);
        RecyclerView trip_list_view = findViewById(R.id.trip_list);
        trip_list_view.setHasFixedSize(true);
        trip_list_view.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        trip_list_view.setLayoutManager(llm);
    }

}
