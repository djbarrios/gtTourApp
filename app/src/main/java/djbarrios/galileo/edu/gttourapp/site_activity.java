package djbarrios.galileo.edu.gttourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

import Utilities.requestManager;
import adapters.sitesAdapter;
import data.place;

public class site_activity extends AppCompatActivity implements View.OnClickListener{
    ListView placesListView;
    EditText idPlaceEditView;
    private List<place> placeList;
    Button findButton;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitesearch_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findButton = findViewById(R.id.findButton);
        findButton.setOnClickListener(this);

        idPlaceEditView = findViewById(R.id.idEditText);

        placesListView = findViewById(R.id.siteListView);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.findButton:
                id = idPlaceEditView.getText().toString();
                if (!TextUtils.isEmpty(id)) {
                    StringRequest request = new StringRequest(Request.Method.GET, "http://186.151.140.61/galileo/sitio-turistico/" + id,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    JSONArray json = null;
                                    try {
                                        json = new JSONArray(response);
                                        placeList = place.getListFromJSON(json);
                                        placesListView.setAdapter(new sitesAdapter(site_activity.this, placeList));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    requestManager.getInstance(this).addToRequestQueue(request);
                    //((ContactoApp)getApplication()).getQueue().add(request);
                }
                break;
        }
    }
}
