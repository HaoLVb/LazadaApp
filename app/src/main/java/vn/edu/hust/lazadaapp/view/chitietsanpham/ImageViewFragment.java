package vn.edu.hust.lazadaapp.view.chitietsanpham;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import vn.edu.hust.lazadaapp.ApplicationData;
import vn.edu.hust.lazadaapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "param";
    private String mParam;


    public ImageViewFragment() {
        // Required empty public constructor
    }

    public static ImageViewFragment newInstance(String param) {
        ImageViewFragment fragment = new ImageViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_view, container, false);
        // Inflate the layout for this fragment
        imageView = view.findViewById(R.id.imageView);
        Glide.with(container.getContext()).load(ApplicationData.DOMAIN + mParam).into(imageView);
        return view;
    }

    private ImageView imageView;

}
