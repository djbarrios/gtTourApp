package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import data.place;
import djbarrios.galileo.edu.gttourapp.R;

public class sitesAdapter extends ArrayAdapter<place>{
    private Context context;
    private int layout;
    private List<place> placesList;
    public sitesAdapter(@NonNull Context context, @NonNull List<place> objects){
        super(context, R.layout.siterow_layout,objects);
        this.context = context;
        this.layout = R.layout.siterow_layout;
        this.placesList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;
        if (v == null){
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = lf.inflate(layout,null);
        }


        if (placesList.get(position) != null){
            TextView titleTextView, departmentTextView, townshipTextView,descriptionTextView,typeSiteTextView,hasHotelsTextView,hasInternetTextView,hasParkingLotTextView;
            ImageView firstImage,secondImage,thirdImage;

            firstImage = v.findViewById(R.id.firstRowImageView);
            secondImage = v.findViewById(R.id.secondRowImageView);
            thirdImage = v.findViewById(R.id.thirdRowImageView);

            titleTextView =  v.findViewById(R.id.titleRowTextView);
            departmentTextView =  v.findViewById(R.id.departmentRowTextView);
            townshipTextView =  v.findViewById(R.id.townshipRowTextView);
            descriptionTextView =  v.findViewById(R.id.descriptionRowTextView);
            typeSiteTextView =  v.findViewById(R.id.siteTypeRowTextView);
            hasHotelsTextView =  v.findViewById(R.id.hasHotelsRowTextView);
            hasInternetTextView =  v.findViewById(R.id.hasIntenertRowTextView);
            hasParkingLotTextView =  v.findViewById(R.id.hasParkingLotRowTextView);

            titleTextView.setText(placesList.get(position).getTitle());
            departmentTextView.setText(placesList.get(position).getDepartmentName(Integer.parseInt(placesList.get(position).getDepartment())));
            townshipTextView.setText(placesList.get(position).getTownshipName(Integer.parseInt(placesList.get(position).getDepartment()),Integer.parseInt(placesList.get(position).getTownship())));
            descriptionTextView.setText(placesList.get(position).getDescription());
            typeSiteTextView.setText(placesList.get(position).getSiteTypeName(Integer.parseInt(placesList.get(position).getSiteType())));

            if (placesList.get(position).getHasHotels().equals("1") || placesList.get(position).getHasHotels().equals("true") ) {
                hasHotelsTextView.setText("Sí tiene hoteles");
            }else {
                hasHotelsTextView.setText("No tiene hoteles");
            }

            if (placesList.get(position).getHasInternet().equals("1") || placesList.get(position).getHasInternet().equals("true") ){
                hasInternetTextView.setText("Sí tiene internet");
            }else{
                hasInternetTextView.setText("No tiene internet");
            }

            if (placesList.get(position).getHasParkingLot().equals("1")  || placesList.get(position).getHasParkingLot().equals("true") ){
                hasParkingLotTextView.setText("Sí tiene parqueo");
            }else{
                hasParkingLotTextView.setText("No tiene parqueo");
            }


            firstImage.setImageBitmap(placesList.get(position).getBitmap(placesList.get(position).getPicture1()));
            secondImage.setImageBitmap(placesList.get(position).getBitmap(placesList.get(position).getPicture2()));
            thirdImage.setImageBitmap(placesList.get(position).getBitmap(placesList.get(position).getPicture3()));

        }
        return  v;
    }
}
