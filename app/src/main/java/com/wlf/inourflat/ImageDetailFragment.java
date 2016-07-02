package com.wlf.inourflat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageDetailFragment extends Fragment {

    private static final String IMAGE_DATA_EXTRA = "resId";
    private int imageNum;
    private ImageView imageView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param imageNum Number of Image to show.
     * @return A new instance of fragment ImageDetailFragment.
     */
    public static ImageDetailFragment newInstance(int imageNum) {
        ImageDetailFragment fragment = new ImageDetailFragment();
        Bundle args = new Bundle();
        args.putInt(IMAGE_DATA_EXTRA, imageNum);
        fragment.setArguments(args);
        return fragment;
    }

    public ImageDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.imageNum = getArguments().getInt(IMAGE_DATA_EXTRA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_image_detail, container, false);
        imageView = (ImageView)view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final int resId = PointOfInterestActivity.imageResIds[imageNum];
        imageView.setImageResource(resId);
    }
}
