package es.rufflecol.lara.radiobuttons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DisplayImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayimage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("animalBundle");
        String animal = bundle.getString("animal");

        ImageView animalView = (ImageView) findViewById(R.id.imageView);
        switch (animal) {
            case "Cub":
                animalView.setImageResource(R.drawable.cub);
                animalView.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case "Duckling":
                animalView.setImageResource(R.drawable.duckling);
                animalView.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case "Fawn":
                animalView.setImageResource(R.drawable.fawn);
                animalView.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case "Kitten":
                animalView.setImageResource(R.drawable.kitten);
                animalView.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case "Lamb":
//              animalView.setImageResource(R.drawable.lamb);
//              animalView.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(this)
                        .load("http://lara.rufflecol.es/wp-content/uploads/lamb.jpg")
                        .fit().centerCrop()
                        .into(animalView);
                break;
            case "Puppy":
                //animalView.setImageResource(R.drawable.puppy);
                //animalView.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(this)
                        .load("http://lara.rufflecol.es/wp-content/uploads/puppy.jpg")
                        .fit().centerCrop()
                        .into(animalView);
                break;
        }
    }
//        Toast.makeText(this, animal, Toast.LENGTH_SHORT).show();









    // Want to re-factor, discuss with Sam
    // Code for the options in the Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();         // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_share:
                openShare();
                return true;
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Methods with no return type
    private void openShare() {
    }

    private void openSearch() {
    }

    private void openSettings() {
    }
}