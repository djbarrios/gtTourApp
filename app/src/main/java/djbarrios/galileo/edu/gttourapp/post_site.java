package djbarrios.galileo.edu.gttourapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DBManager.dbOperations;
import Utilities.requestManager;
import adapters.departmentSpinnerAdapter;
import adapters.siteSpinnerAdapter;
import adapters.townshipSpinnerAdapter;
import data.department;
import data.generalInfo;
import data.place;
import data.site;

public class post_site extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    EditText titleEditText,descriptionEditText;
    Switch parkingLotSwitch,hotelsSwitch,internetSwitch;
    Spinner departmenSpinner,townshipSpinner, siteTypeSpinner;
    ImageView firstImageView, secondImageView, thirdImageView;
    List<department> departmentsList = new ArrayList<>();
    List<site> siteList = new ArrayList<>();
    generalInfo _generalInfo = new generalInfo();
    private Integer departmentPosition,departmentId,townshipId,siteTypeId,imageFrameId;
    private  String hasHotels,hasParkingLot,hasInternet;
    Long newPlaceId;
    private Uri imageUri;
    private Bitmap image, image1,image2,image3,defaultImage;
    private dbOperations dbOperations;
    Button saveButton,cancelButton;
    private place _place;
    private String encodedPicture1,encodedPicture2,encodedPicture3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_site_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        departmentsList = _generalInfo.getDepartments();
        siteList = _generalInfo.getStieTypes();

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        parkingLotSwitch = findViewById(R.id.parkingLotSwitch);
        hotelsSwitch = findViewById(R.id.hotelsSwitch);
        internetSwitch = findViewById(R.id.internetSwitch);
        departmenSpinner = findViewById(R.id.departmentSpinner);
        townshipSpinner = findViewById(R.id.townshipSpinner);
        siteTypeSpinner = findViewById(R.id.siteTypeSpinner);
        firstImageView = findViewById(R.id.firstImageView);
        secondImageView = findViewById(R.id.secondImageView);
        thirdImageView = findViewById(R.id.thirdImageView);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);


        firstImageView.setOnClickListener(this);
        secondImageView.setOnClickListener(this);
        thirdImageView.setOnClickListener(this);
        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        departmenSpinner.setAdapter(new departmentSpinnerAdapter(this,departmentsList));
        departmenSpinner.setOnItemSelectedListener(this);
        departmentPosition = 0;

        townshipSpinner.setAdapter(new townshipSpinnerAdapter(this,departmentsList.get(departmentPosition).getTownships()));
        townshipSpinner.setOnItemSelectedListener(this);
        townshipId = 1;

        siteTypeSpinner.setAdapter(new siteSpinnerAdapter(this,siteList));
        siteTypeSpinner.setOnItemSelectedListener(this);
        siteTypeId = 1;

        hasInternet = "false";
        hasHotels = "false";
        hasParkingLot = "false";

        hotelsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hasHotels = "true";
                } else {
                    hasHotels ="false";
                }
            }
        });

        parkingLotSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hasParkingLot = "true";
                } else {
                    hasParkingLot ="false";
                }
            }
        });

        internetSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hasInternet = "true";
                } else {
                    hasInternet ="false";
                }
            }
        });

        imageFrameId = 1;

        dbOperations = new dbOperations(getApplicationContext());

        defaultImage = ((BitmapDrawable)firstImageView.getDrawable()).getBitmap();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0]== PackageManager.PERMISSION_GRANTED && grantResults[1]== PackageManager.PERMISSION_GRANTED && requestCode == 1) {
            takePicture();
        } else {
            Toast.makeText(this, "No se otorgo permiso para tomar fotos", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            image = BitmapFactory.decodeFile(imageUri.getPath());
            switch (imageFrameId) {
                case 1:
                    firstImageView.setImageBitmap(image);
                    break;
                case 2:
                    secondImageView.setImageBitmap(image);
                    break;
                case 3:
                    thirdImageView.setImageBitmap(image);
                    break;
            }
        }

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.firstImageView:
                imageFrameId = 1;
                isStoragePermissionGranted();
                break;
            case R.id.secondImageView:
                imageFrameId = 2;
                isStoragePermissionGranted();
                break;
            case R.id.thirdImageView:
                imageFrameId = 3;
                isStoragePermissionGranted();
                break;
            case R.id.saveButton:
                savePlace(v);
                break;
            case R.id.cancelButton:
                clearControls();
                break;
        }
    }

    public void  savePlace(View view){

        image1 = ((BitmapDrawable) firstImageView.getDrawable()).getBitmap();
        image2 = ((BitmapDrawable) secondImageView.getDrawable()).getBitmap();
        image3 = ((BitmapDrawable) thirdImageView.getDrawable()).getBitmap();

        encodedPicture1 = encodeFileImage(image1);
        encodedPicture2 = encodeFileImage(image2);
        encodedPicture3 = encodeFileImage(image3);

        _place = new place(Integer.toString(departmentId), Integer.toString(townshipId), Integer.toString(siteTypeId), hasParkingLot, hasInternet, hasHotels, titleEditText.getText().toString(), "0.0", "0.0", descriptionEditText.getText().toString(), encodedPicture1, encodedPicture2, encodedPicture3);

        if (validateFields(_place)) {
            newPlaceId = dbOperations.savePlace(_place);
            if (newPlaceId > 0) {
                Snackbar.make(view, "Se creó el nuevo sitio turistico en base de datos con ID: " + newPlaceId.toString(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                clearControls();
            } else {
                Snackbar.make(view, "No se creo el nuevo sitio turístico, valide la información.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
            savePlaceOnAPI();
        }else{
            Snackbar.make(view, "No se creo el nuevo sitio turístico, valide la información.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }

    private void  savePlaceOnAPI(){

        RequestQueue mRequestQueue = requestManager.getInstance(this.getApplicationContext()).getRequestQueue();
        //Start the queue
        mRequestQueue.start();
        StringRequest request = new StringRequest(Request.Method.POST, "http://186.151.140.61/galileo/sitio-turistico", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject json = null;
                try {
                    json = new JSONObject(response);
                    //Toast.makeText(MainActivity.this, json.getString("mensaje"), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String error1 = error.getMessage();
            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                JSONObject json = new JSONObject();
                try {
                    json.put("departamento", _place.getDepartment());
                    json.put("municipio",_place.getTownship());
                    json.put("titulo",_place.getTitle());
                    json.put("latitud",_place.getLatitude());
                    json.put("longitud",_place.getLongitude());
                    json.put("descripcion",_place.getDescription());
                    json.put("tipo",_place.getSiteType());
                    json.put("foto1",_place.getPicture1());
                    json.put("foto2",_place.getPicture2());
                    json.put("foto3",_place.getPicture3());
                    json.put("parqueo",_place.getHasParkingLot());
                    json.put("internet",_place.getHasInternet());
                    json.put("hoteles",_place.getHasHotels());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String httpPostBody = json.toString();

                // usually you'd have a field with some values you'd want to escape, you need to do it yourself if overriding getBody. here's how you do it
                return httpPostBody.getBytes();
            }
        };
        requestManager.getInstance(this).addToRequestQueue(request);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {
        // TODO Auto-generated method stub
        Integer viewId  = parent.getId();
        switch (viewId)
        {
            case R.id.departmentSpinner:
                departmentPosition = position;
                departmentId = departmentsList.get(position).getDepartmentId();
                townshipSpinner.setAdapter(new townshipSpinnerAdapter(this,departmentsList.get(departmentPosition).getTownships()));
                townshipId = departmentsList.get(position).getTownships().get(0).getTownshipId();
                break;
            case R.id.townshipSpinner:
                townshipId = departmentsList.get(departmentPosition).getTownships().get(position).getTownshipId();
                break;
            case R.id.siteTypeSpinner:
                siteTypeId = siteList.get(position).getSiteType();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if ((checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) && (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)) {
                takePicture();
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("Test","Permission is granted");
            takePicture();
            return true;
        }
    }

    public void takePicture () {
        imageUri = getOutputMediaFileUri();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 101);
        }
    }

    private Uri getOutputMediaFileUri()
    {
        //Valida si tenemos posibilidad de escribir en la storage
        if(isExternalStorageAvaiable())
        {
            String mediaStorageDir = Environment.getExternalStorageDirectory() + File.separator + "gttourapp";
            File mediaStorageDirFile = new File(mediaStorageDir);
            if (!mediaStorageDirFile.exists()) {
                mediaStorageDirFile.mkdir();
            }

            String fileName = "";
            String fileType = "";
            String timeStamp = Calendar.getInstance().getTimeInMillis() + "";

            fileName = "IMG_"+timeStamp;
            fileType = ".jpg";

            File mediaFile;
            try
            {
                mediaFile = File.createTempFile(fileName,fileType,mediaStorageDirFile);
                Log.i("st","File: "+Uri.fromFile(mediaFile));
            }
            catch (IOException e)
            {
                e.printStackTrace();
                Log.i("St","Error creating file: " + mediaStorageDir +fileName +fileType);
                return null;
            }
            return Uri.fromFile(mediaFile);
        }
        return null;

    }

    private boolean isExternalStorageAvaiable()
    {
        String state = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(state))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Codificar archivo en base64 para almacenar en la foto
    private String encodeFileImage(Bitmap image) {//String filePath){
        Bitmap bm = null;//BitmapFactory.decodeFile(filePath);
        bm = getResizedBitmap(image, 200);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        // Recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bm,  (int)(newHeight * ((float)width/height)), newHeight, false);
        return resizedBitmap;
    }

    private void clearControls(){
        firstImageView.setImageBitmap(defaultImage);
        secondImageView.setImageBitmap(defaultImage);
        thirdImageView.setImageBitmap(defaultImage);
        titleEditText.setText("");
        descriptionEditText.setText("");
        internetSwitch.setChecked(false);
        hotelsSwitch.setChecked(false);
        parkingLotSwitch.setChecked(false);
        hasHotels = "false";
        hasInternet = "false";
        hasParkingLot = "false";
        departmenSpinner.setAdapter(new departmentSpinnerAdapter(this,departmentsList));
        departmentPosition = 0;
        departmentId = 1;
        siteTypeSpinner.setAdapter(new siteSpinnerAdapter(this,siteList));
        siteTypeId = 1;
    }

    private boolean validateFields(place place){
        boolean valid = true;

        if (TextUtils.isEmpty(place.getDescription()) || TextUtils.isEmpty(place.getTitle())){
            valid = false;
        }

        return valid;
    }
}
