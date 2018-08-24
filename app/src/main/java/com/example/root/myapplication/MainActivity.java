package com.example.root.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    RadioGroup group;
    RadioButton dev, lab, devs;

    private String url = "http://dev.openthos.org/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showAlert();

//        group = (RadioGroup) findViewById(R.id.group);
//        dev = (RadioButton) findViewById(R.id.dev);
//        lab = (RadioButton) findViewById(R.id.lab);
//        devs = (RadioButton) findViewById(R.id.devs);
//
//        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                Log.d("nnnnn", "------------------check-");
//                if (i == dev.getId()) {
//                    Log.d("nnnnn", "------------------dev-" + dev.getText().toString());
//                } else if (i == lab.getId()) {
//                    Log.d("nnnnn", "------------------lab-" + lab.getText().toString());
//
//                } else if (i == devs.getId()) {
//                    Log.d("nnnnn", "------------------devs-" + devs.getText().toString());
//
//                }
//            }
//        });
    }

    private void showAlert() {
        LayoutInflater layoutInflater = getLayoutInflater();
        final View changeUrlDialog = layoutInflater
                .inflate(R.layout.dialog_change_url, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change Url");
        builder.setView(changeUrlDialog);
        builder.setCancelable(true);

        RadioGroup group = (RadioGroup) changeUrlDialog.findViewById(R.id.group);
        final RadioButton rbDev = (RadioButton) changeUrlDialog.findViewById(R.id.dev);
        final RadioButton rbLab = (RadioButton) changeUrlDialog.findViewById(R.id.lab);
        final RadioButton rbDevs = (RadioButton) changeUrlDialog.findViewById(R.id.devs);

        if (url.equals(rbDev.getText().toString())) {
            rbDev.setChecked(true);
            Log.d("aaaaa", "---------------------check-dev-");
        } else if (url.equals(rbLab.getText().toString())) {
            rbLab.setChecked(true);
            Log.d("aaaaa", "---------------------check-158-");
        } else if (url.equals(rbDevs.getText().toString())) {
            rbDevs.setChecked(true);
            Log.d("aaaaa", "---------------------check-235-");
        }
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("aaaaa", "--------------------alert-checkedChanged-");
                if (checkedId == rbDev.getId()) {
                    Log.d("aaaaa", "--------------------alert-checkedChanged-dev-" + rbDev.isChecked());
                    rbDev.setChecked(true);
                } else if (checkedId == rbLab.getId()) {
                    Log.d("aaaaa", "--------------------alert-checkedChanged-158-" + rbLab.isChecked());
                    rbLab.setChecked(true);
                } else if (checkedId == rbDevs.getId()) {
                    Log.d("aaaaa", "--------------------alert-checkedChanged-235-" + rbDevs.isChecked());
                    rbDevs.setChecked(true);
                }
            }
        });
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                Log.d("aaaaa", "--------------------alert-confirm-" + rbDev.isChecked() + rbLab.isChecked() + rbDevs.isChecked());
                String tempUrl = "";
                if (rbDev.isChecked()) {
                    Log.d("aaaaa", "--------------------alert-confirm-dev-" + rbDev.getText().toString());
                    tempUrl = rbDev.getText().toString();
                } else if (rbLab.isChecked()) {
                    Log.d("aaaaa", "--------------------alert-confirm-158-" + rbLab.getText().toString());
                    tempUrl = rbLab.getText().toString();
                } else if (rbDevs.isChecked()) {
                    Log.d("aaaaa", "--------------------alert-confirm-235-" + rbDevs.getText().toString());
                    tempUrl = rbDevs.getText().toString();
                }
//                if (!tempUrl.equals(mAccount.mOpenthosUrl)) {
//                    updateOpenthosUrl(tempUrl);
//                }
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
            }
        });
        builder.create().show();
    }
}
