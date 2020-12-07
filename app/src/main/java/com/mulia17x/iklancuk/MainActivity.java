package com.mulia17x.iklancuk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        setTitle("Bantuan");
        interstitial = new InterstitialAd(MainActivity.this);
        interstitial.setAdUnitId("ca-app-pub-9458157331625046/1361018410");

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9458157331625046~5227576810");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("14C4478FF6BA8D617DA5D9FDA42472ED")
                .build();
        mAdView.loadAd(adRequest);



        interstitial.loadAd(adRequest);
        interstitial.setAdListener(new AdListener() {

            public void onAdLoaded() {
                displayInterstitial();

            }

        });

    }
    public void displayInterstitial() {
        if (interstitial.isLoaded()) {

            interstitial.show();

        }
}}