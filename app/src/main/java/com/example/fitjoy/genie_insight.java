package com.example.fitjoy;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link genie_insight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class genie_insight extends Fragment {
CardView illustrateAR;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public genie_insight() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment genie_insight.
     */
    // TODO: Rename and change types and number of parameters
    public static genie_insight newInstance(String param1, String param2) {
        genie_insight fragment = new genie_insight();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_genie_insight, container, false);
        illustrateAR = (CardView) v.findViewById(R.id.illustrateAR);
        illustrateAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.Test");
                if (launchIntent != null) {
                    Toast.makeText(getContext(), "Starting Please wait...", Toast.LENGTH_SHORT).show();
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
                else
                {
                    Toast.makeText(getContext(), "Null package name", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}