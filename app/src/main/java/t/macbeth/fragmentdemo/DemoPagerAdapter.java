package t.macbeth.fragmentdemo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class DemoPagerAdapter extends FragmentStateAdapter {

    public DemoPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;

        /* Create the fragment based on the position provided. */
        if (position == 0) {
            fragment = new DogFragment();
            Log.d("FragmentDemo","Creating Dog Fragment.");
        } else if (position == 1) {
            fragment = new CatFragment();
            Log.d("FragmentDemo","Creating Cat Fragment.");
        } else if (position == 2) {
            fragment = new BirdFragment();
            Log.d("FragmentDemo","Creating Bird Fragment.");
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        /* The number of fragments managed by the adapter */
        return 3;
    }
}
