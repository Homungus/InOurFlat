package com.wlf.inourflat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.customlbs.coordinates.GeoCoordinate;
import com.customlbs.library.IndoorsException;
import com.customlbs.library.IndoorsFactory;
import com.customlbs.library.IndoorsLocationListener;
import com.customlbs.library.callbacks.LoadingBuildingStatus;
import com.customlbs.library.model.Building;
import com.customlbs.library.model.Zone;
import com.customlbs.shared.Coordinate;
import com.customlbs.surface.library.IndoorsSurfaceFactory;
import com.customlbs.surface.library.IndoorsSurfaceFragment;

import java.util.List;


public class IndoorsActivity extends AppCompatActivity implements IndoorsLocationListener {

    private IndoorsSurfaceFragment indoorsFragment;

    @Override
    public void buildingLoadingCanceled() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IndoorsFactory.Builder indoorsBuilder           = new IndoorsFactory.Builder();
        IndoorsSurfaceFactory.Builder surfaceBuilder    = new IndoorsSurfaceFactory.Builder();
        indoorsBuilder.setContext(this);

        //your API-key and
        //id of the building you uploaded to our cloud using the MMT
        indoorsBuilder.setApiKey("fe1ad46e-1121-4f45-afd1-3e5d07e39535");
        indoorsBuilder.setBuildingId((long) 509535402);

        // callback for indoo.rs-events
        indoorsBuilder.setUserInteractionListener(this);
        surfaceBuilder.setIndoorsBuilder(indoorsBuilder);

        //ToDo: Build indoors-Fragment in own thread - Slow operation!
        indoorsFragment                 = surfaceBuilder.build();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.indoors_layout, indoorsFragment, "indoors");
        transaction.commit();

        setContentView(R.layout.activity_indoors);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_indoors, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadingBuilding(LoadingBuildingStatus loadingBuildingStatus) {
        // indoo.rs is still downloading or parsing the requested building
        Toast.makeText(
                this,
                "Building is loading " + loadingBuildingStatus.getProgress(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void buildingLoaded(Building building) {

    }

    @Override
    public void leftBuilding(Building building) {

    }

    @Override
    public void positionUpdated(Coordinate coordinate, int i) {

    }

    @Override
    public void orientationUpdated(float v) {

    }

    @Override
    public void changedFloor(int i, String s) {

    }

    @Override
    public void enteredZones(List<Zone> list) {

    }

    @Override
    public void onError(IndoorsException e) {

    }
}
