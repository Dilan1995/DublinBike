//DILAN TOLLEN    16357
package dilan.dublinbike;

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dilan.dublinbike.classes.DublinBikeService;
import dilan.dublinbike.classes.Station;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jcdecaux.com/vls/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        new DownloadTask().execute();
    }

    public class DownloadTask extends AsyncTask<Void, Void, List<Station>> {
        @Override
        protected List<Station> doInBackground(Void... voids) {
            DublinBikeService service = retrofit.create(DublinBikeService.class);
            List<Station> stations =  new ArrayList<>();
            try {
                stations  = service.getStations().execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stations;
        }

        @Override
        protected void onPostExecute(List<Station> stations) {
            super.onPostExecute(stations);
            for(Station station : stations){
                LatLng dublin = new LatLng(station.getPosition().getLat(), station.getPosition().getLng());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dublin, 15));
                mMap.addMarker(new MarkerOptions().position(dublin).title(station.getName()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(dublin));
            }
        }
    }
}
