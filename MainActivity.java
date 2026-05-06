package com.example.filemenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
 * MAD Lab Program
 * ───────────────────────────────────────────────────────────────────
 * Aim    : Demonstrate a Menu "File" with sub-items New and Open.
 *          Show a Toast message on click of each menu item.
 * ───────────────────────────────────────────────────────────────────
 */
public class MainActivity extends AppCompatActivity {

    // TextView to display the last selected menu action on screen
    private TextView tvLastAction;

    // ─── onCreate ────────────────────────────────────────────────────────────
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set ActionBar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("File Menu Demo");
        }

        // Bind view
        tvLastAction = findViewById(R.id.tvLastAction);
    }

    // ─── Step 1: Inflate the Options Menu ────────────────────────────────────
    /*
     * onCreateOptionsMenu() is called automatically by Android
     * when the Activity is created. We inflate our menu XML here.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);  // Links to res/menu/menu_file.xml
        return true;  // Must return true to display the menu
    }

    // ─── Step 2: Handle Menu Item Clicks ─────────────────────────────────────
    /*
     * onOptionsItemSelected() is called when any menu item is tapped.
     * We use item ID to identify which item was clicked.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // ── File → New ───────────────────────────────────────────────────────
        if (id == R.id.menu_new) {

            // Show Toast message
            Toast.makeText(
                this,
                "New File Created!",
                Toast.LENGTH_SHORT
            ).show();

            // Update status text on screen
            tvLastAction.setText("File → New selected");

            return true;  // Event consumed

        }
        // ── File → Open ──────────────────────────────────────────────────────
        else if (id == R.id.menu_open) {

            // Show Toast message
            Toast.makeText(
                this,
                "Open File Selected!",
                Toast.LENGTH_SHORT
            ).show();

            // Update status text on screen
            tvLastAction.setText("File → Open selected");

            return true;  // Event consumed

        }
        // ── Default: pass unhandled items to super ────────────────────────────
        else {
            return super.onOptionsItemSelected(item);
        }
    }
}
