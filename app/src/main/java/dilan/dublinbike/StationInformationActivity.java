//DILAN TOLLEN 16357
package dilan.dublinbike;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import dilan.dublinbike.classes.Station;



public class StationInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_information);
        TextView stationInfo = (TextView)findViewById(R.id.stationsInfo);

        Station station = getIntent().getParcelableExtra("Data");

        if(station != null){
            stationInfo.setText("Station Name:"+station.getName()+"\n"+
                    "Station Address:"+station.getAddress()+"\n"
                    +"Station Status:"+station.getStatus()+"\n"
                    +"Bikes Stand:"+station.getBike_stands()+"\n"
                    +"Bikes Available:"+station.getAvailable_bike_stands()+"\n"
                    +"Contract:"+station.getContract_name()+"\n"
            );
        }

    }

}
