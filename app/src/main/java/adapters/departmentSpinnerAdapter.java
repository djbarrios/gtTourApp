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

import data.department;
import djbarrios.galileo.edu.gttourapp.R;

public class departmentSpinnerAdapter extends ArrayAdapter<department>{
    private Context context;
    private int layout;
    private List<department> departmentsList;
    public departmentSpinnerAdapter(@NonNull Context context, @NonNull List<department> objects){
        super(context, R.layout.departmen_layout,objects);
        this.context = context;
        this.layout = R.layout.departmen_layout;
        this.departmentsList = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;
        if (v == null){
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = lf.inflate(layout,null);
        }


        if (departmentsList.get(position) != null){
            TextView departmentTextView;
            departmentTextView = v.findViewById(R.id.departmentRowtextView);
            departmentTextView.setText(departmentsList.get(position).getName());
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

        if (departmentsList.get(position) != null){
            TextView departmentTextView;
            departmentTextView = v.findViewById(R.id.departmentRowtextView);
            departmentTextView.setText(departmentsList.get(position).getName());
        }

        return  v;
    }

}
