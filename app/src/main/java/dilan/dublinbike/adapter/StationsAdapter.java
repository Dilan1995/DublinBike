package dilan.dublinbike.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import dilan.dublinbike.R;
import dilan.dublinbike.classes.Station;

//DILAN TOLLEN  16357

public class StationsAdapter extends ArrayAdapter<Station> {

    public StationsAdapter(Context context, List<Station> stations) {
        super(context, 0, stations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Station station = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_view, parent, false);
        }

        TextView stationInfo = (TextView) convertView.findViewById(R.id.stationsInfo);


        stationInfo.setText(station.getName()+"\n"+station.getAddress()+"\n"+station.getStatus());


        return convertView;
    }
}
