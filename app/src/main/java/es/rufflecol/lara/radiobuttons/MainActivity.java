package es.rufflecol.lara.radiobuttons;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initializing the RadioGroup and attaching attaching the click handler - the xml
        radioButtons = (RadioGroup) findViewById(R.id.radioButtonsGroup);
    }

    public void onClear(View v) {
        // Clears the selected radio button
        radioButtons.clearCheck();
    }

    public void onSubmit(View v) {
//        RadioButton rb = (RadioButton) radioButtons.findViewById(radioButtons.getCheckedRadioButtonId());
//        Toast.makeText(MainActivity.this, "You selected " + rb.getText(), Toast.LENGTH_SHORT).show();

        showDialog();
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(null);

        final RadioButton rb = (RadioButton) radioButtons.findViewById(radioButtons.getCheckedRadioButtonId());

        // NB that the positive/negative/neutral buttons don't mean anything per se, they are just a way to distinguish between the 3 allowed, and they have a specific ordering

        if (rb != null) {

            alertDialogBuilder
                    .setMessage("You selected " + rb.getText())
                    .setCancelable(true) // True allows you to use the back button to exit the dialog, false does not
                    .setPositiveButton("Show Image", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Adding an intent to the onClick method enables you to connect a button to a new activity

                            Intent intent = new Intent(MainActivity.this, DisplayImageActivity.class);

                            Bundle bundle = new Bundle();
                            bundle.putString("animal", rb.getText().toString());
                            intent.putExtra("animalBundle", bundle);

                            startActivity(intent);
                            // if this button is clicked, close current activity
                            // MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // If this button is clicked, just close the dialog box and do nothing
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else
            Toast.makeText(this, "Please select select an option", Toast.LENGTH_SHORT).show();
    }







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