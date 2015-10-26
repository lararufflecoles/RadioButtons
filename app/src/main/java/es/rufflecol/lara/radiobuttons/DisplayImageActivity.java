package es.rufflecol.lara.radiobuttons;

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
    }




//        //Initialize ImageView
//        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//
//        //Loading image from below url into imageView
//        Picasso.with(this)
//                .load("http://lara.rufflecol.es/wp-content/uploads/2015-10-23.png")
//                .placeholder(R.drawable.ic_placeholder)
//                        //.resize(600, 480)
//                .into(imageView);
//    }





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
