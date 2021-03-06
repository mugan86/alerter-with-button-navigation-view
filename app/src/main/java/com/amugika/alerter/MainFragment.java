package com.amugika.alerter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

/**************************************************************************************************
 * Created by anartzmugika on 18/2/17.
 **************************************************************************************************/

public class MainFragment extends Fragment {

    private Button default_alerterButton, coloured_alerterButton, custom_icon_alerterButton,
            text_only_alerterButton, onclick_alerterButton, verbose_alerterButton;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment

        View rootView = inflater.inflate(
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

    private void addActions() {
        default_alerterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(getActivity())
                        .setTitle("Alert Title")
                        .setText("Alert text...")
                        .setBackgroundColor(R.color.colorPrimary)
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
                        .setTitle("Data Send Correct!!")
                        .setText("Alert text...")
                        .setDuration(5000)
                        .setBackgroundColor(R.color.GreenCorrectText)
                        .setIcon(R.drawable.ic_dashboard_black_24dp)
                        .show();
            }
        });

        text_only_alerterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(getActivity())
                        .setText("Error text...")
                        .setBackgroundColor(R.color.Crimson)
                        .show();
            }
        });

        onclick_alerterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(getActivity())
                        .setTitle("Alert Title")
                        .setText("Alert text...")
                        .setDuration(10000)
                        .setBackgroundColor(R.color.colorPrimary)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getActivity(), "OnClick Called", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

        verbose_alerterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "The alert scales to accommodate larger bodies of text. \nThe alert scales to accommodate larger bodies of text.";
                Alerter.create(getActivity())
                        .setTitle("Alert Title")
                        .setIcon(R.drawable.ic_dashboard_black_24dp)
                        .setBackgroundColor(R.color.colorPrimary)
                        .setDuration(10000)
                        .setText(text)
                        .show();
            }
        });

    }

    private Spanned getHtmlTextToTextView(String html)
    {
        // get our html content
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) return Html.fromHtml(html,0);
        return Html.fromHtml(html);

    }


}
