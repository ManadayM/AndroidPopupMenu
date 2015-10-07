package com.example.android.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void openPopupMenu(View anchorView) {

        PopupMenu popup = new PopupMenu(this, anchorView);

        // inflate popup with filter menu
        popup.getMenuInflater().inflate(R.menu.popup_menu_filter, popup.getMenu());

        // Set 2nd item in popup as checked item,
        // TODO You can use permanent storage like Shared pref to store the checked item and retrieve it later..
        popup.getMenu().getItem(1).setChecked(true);

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "Duration set to " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.action_filter:
                openPopupMenu(findViewById(R.id.action_filter));
                return true;

            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
