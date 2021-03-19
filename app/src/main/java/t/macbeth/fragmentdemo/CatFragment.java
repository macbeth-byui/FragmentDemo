package t.macbeth.fragmentdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CatFragment extends Fragment {

    private View rootView;

    public CatFragment() {
        rootView = null;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* If we are returning to this fragment view, we don't need to re-inflate every time.
           If the rootView is not null, then we have already done this before.
         */
        if (rootView == null) {
            Log.d("FragmentDemo", "Creating Layout for Cat Fragment.");

            /* Display (inflate) the layout xml for this fragment */
            rootView = inflater.inflate(R.layout.fragment_cat, container, false);

            /* Populate Picture */
            ImageView imageView = rootView.findViewById(R.id.cat_image);
            imageView.setImageResource(R.drawable.cat);

            /* If user clicks picture then display toast (via Activity) with animal sound. */
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) getActivity()).displayToast("Meow Meow");
                }
            });
        }
        return rootView;
    }
}