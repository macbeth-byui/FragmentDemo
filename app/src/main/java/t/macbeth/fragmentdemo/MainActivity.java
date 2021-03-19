package t.macbeth.fragmentdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;  // Note, the "2" refers to the 2nd version of the ViewPager made for androidx.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Setup the ViewPager to manage the fragments using a customized Pager Adapter for Fragments. */
        viewPager = findViewById(R.id.view_pager);
        DemoPagerAdapter demoPagerAdapter = new DemoPagerAdapter(this);
        viewPager.setAdapter(demoPagerAdapter);

        /* Listen for clicks on the BottomNavigationView. */
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                loadFragment(item.getItemId());
                return true;
            }
        });
    }

    private void loadFragment(int menuID) {
        /* Load the fragment from the ViewPager based on the Menu ID.  This mapping is the
           same as what is found in the DemoPagerAdapter. */
       if (menuID == R.id.dog_page) {
           viewPager.setCurrentItem(0);
           Log.d("FragmentDemo","Loading Dog Fragment");
       } else if (menuID == R.id.cat_page) {
           viewPager.setCurrentItem(1);
           Log.d("FragmentDemo","Loading Cat Fragment");
       } else if (menuID == R.id.bird_page) {
           viewPager.setCurrentItem(2);
           Log.d("FragmentDemo","Loading Bird Fragment");
       }
    }

    public void displayToast(String message) {
        /* This function exists to demonstrate how fragments can call functions in the parent activity. */
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}