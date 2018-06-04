package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import data.site;
import djbarrios.galileo.edu.gttourapp.R;

public class siteSpinnerAdapter extends ArrayAdapter<site> {
    private Context context;
    private int layout;
    private List<site> sitesList;
    public siteSpinnerAdapter(@NonNull Context context, @NonNull List<site> objects){
        super(context, R.layout.site_layout,objects);
        this.context = context;
        this.layout = R.layout.site_layout;
        this.sitesList = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;
        if (v == null){
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = lf.inflate(layout,null);
        }


        if (sitesList.get(position) != null){
            TextView siteTextView;
            siteTextView = v.findViewById(R.id.siteRowtextView);
            siteTextView.setText(sitesList.get(position).getName());
        }
        return  v;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;
        if (v == null){
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = lf.inflate(layout,null);
        }

        if (sitesList.get(position) != null){
            TextView siteTextView;
            siteTextView = v.findViewById(R.id.siteRowtextView);
            siteTextView.setText(sitesList.get(position).getName());
        }

        return  v;
    }
}
