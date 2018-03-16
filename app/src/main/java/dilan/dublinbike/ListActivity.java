//DILAN TOLLEN    16357
package dilan.dublinbike;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dilan.dublinbike.adapter.StationsAdapter;
import dilan.dublinbike.classes.DublinBikeService;
import dilan.dublinbike.classes.Station;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListActivity extends AppCompatActivity {

    private static final String TAG = "ListActivity";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jcdecaux.com/vls/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
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
        protected void onPostExecute(final List<Station> stations) {
            super.onPostExecute(stations);
            StationsAdapter adapter = new StationsAdapter(getApplicationContext(), stations);
            ListView listView = (ListView)findViewById(R.id.list_stations);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ListActivity.this, StationInformationActivity.class);
                    intent.putExtra("Data", stations.get(i));
                    startActivity(intent);
                }
            });
        }
    }

}
