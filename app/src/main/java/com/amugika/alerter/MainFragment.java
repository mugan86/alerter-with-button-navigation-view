package com.amugika.alerter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tapadoo.alerter.Alerter;

/**************************************************************************************************
 * Created by anartzmugika on 18/2/17.
 **************************************************************************************************/

public class MainFragment extends Fragment {

    private Button default_alerterButton, coloured_alerterButton, custom_icon_alerterButton,
            text_only_alerterButton, onclick_alerterButton, verbose_alerterButton;

    private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment

        rootView = inflater.inflate(
                R.layout.fragment_main, container, false);

        default_alerterButton = (Button) rootView.findViewById(R.id.default_alerterButton);
        coloured_alerterButton = (Button) rootView.findViewById(R.id.coloured_alerterButton);
        custom_icon_alerterButton = (Button) rootView.findViewById(R.id.custom_icon_alerterButton);
        text_only_alerterButton = (Button) rootView.findViewById(R.id.text_only_alerterButton);
        onclick_alerterButton = (Button) rootView.findViewById(R.id.onclick_alerterButton);
        verbose_alerterButton = (Button) rootView.findViewById(R.id.verbose_alerterButton);

        addActions();

        return rootView;
    }

    private void addActions()
    {
        default_alerterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(getActivity())
                        .setTitle("Alert Title")
                        .setText("Alert text...")
                        .show();
            }
        });

        coloured_alerterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(getActivity())
                        .setTitle("Alert Title")
                        .setText("Alert text...")
                        .setBackgroundColor(R.color.colorAccent)
                        .show();
            }
        });

        custom_icon_alerterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(getActivity())
                        .setTitle("Alert Title")
                        .setText("Alert text...")
                        .setDuration(3000)
                        .setIcon(R.drawable.ic_dashboard_black_24dp)
                        .show();
            }
        });

        text_only_alerterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(getActivity())
                        .setText("Alert text...")
                        .show();
            }
        });
    }
}
