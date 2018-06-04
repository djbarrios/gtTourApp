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
import data.township;
import djbarrios.galileo.edu.gttourapp.R;

public class townshipSpinnerAdapter extends ArrayAdapter<township> {
    private Context context;
    private int layout;
    private List<township> townshipList;
    public townshipSpinnerAdapter(@NonNull Context context, @NonNull List<township> objects){
        super(context, R.layout.township_layout,objects);
        this.context = context;
        this.layout = R.layout.township_layout;
        this.townshipList = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;
        if (v == null){
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = lf.inflate(layout,null);
        }


        if (townshipList.get(position) != null){
            TextView townshipTextView;
            townshipTextView = v.findViewById(R.id.townshipRowtextView);
            townshipTextView.setText(townshipList.get(position).getName());
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

        if (townshipList.get(position) != null){
            TextView townshipTextView;
            townshipTextView = v.findViewById(R.id.townshipRowtextView);
            townshipTextView.setText(townshipList.get(position).getName());
        }

        return  v;
    }
}
