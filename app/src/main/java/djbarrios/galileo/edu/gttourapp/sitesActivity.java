package djbarrios.galileo.edu.gttourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import DBManager.dbOperations;
import adapters.sitesAdapter;
import data.place;

public class sitesActivity extends AppCompatActivity {
    private List<place> placesList;
    private ListView placesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sites_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        placesListView = findViewById(R.id.placesListView);

        dbOperations dbOperations = new dbOperations(getApplicationContext());

        placesList = dbOperations.getPlaces();

        placesListView.setAdapter(new sitesAdapter(this, placesList));
    }
}
