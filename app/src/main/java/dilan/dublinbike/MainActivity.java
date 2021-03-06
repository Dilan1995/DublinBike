// DILAN TOLLEN    16357
package dilan.dublinbike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Button for the listview from the main screen(when click, bring you to listactivity)
    public void listStations(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        Log.d("MainActivity", "Go to list ");
    }

     // button for the mapview from the main screen.(when click bring to mapactivity)
    public void goToMap(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
