package djbarrios.galileo.edu.gttourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class about_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
