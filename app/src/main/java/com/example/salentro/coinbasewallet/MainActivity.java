package com.example.salentro.coinbasewallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.coinbase.android.sdk.OAuth;
import com.coinbase.api.Coinbase;
import com.coinbase.api.CoinbaseBuilder;
import com.coinbase.api.entity.OAuthTokensResponse;
import com.coinbase.api.exception.CoinbaseException;


public class MainActivity extends AppCompatActivity {
    private static final String CLIENT_ID = "5c9df3d9ac69af05fc03be0c25e8b75bc578c883f65cd3cb329201f29e29e5d5";
    private static final String CLIENT_SECRET = "7676804342763d9be5a84296839db19a3117161df4ad22be3a838234a7bc9e51";
    private static final String REDIRECT_URI = "coinbase-android-example://coinbase-oauth";

    @Override
    protected void onNewIntent(final Intent intent) {
        if (intent != null && intent.getAction() != null && intent.getAction().equals("android.intent.action.VIEW")) {
            //new CompleteAuthorizationTask(intent).execute();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            OAuth.beginAuthorization(this, CLIENT_ID, "user", REDIRECT_URI, null);
        } catch (CoinbaseException ex) {
        }
    }


   /* public class DisplayEmailTask extends RoboAsyncTask<String> {
        private OAuthTokensResponse mTokens;

        public DisplayEmailTask(OAuthTokensResponse tokens) {
            super(MainActivity.this);
            mTokens = tokens;
        }

        public String call() throws Exception {
            Coinbase coinbase = new CoinbaseBuilder().withAccessToken(mTokens.getAccessToken()).build();
            return coinbase.getUser().getEmail();
        }

        @Override
        public void onException(Exception ex) {
        }

        @Override
        public void onSuccess(String email) {
        }
    }
    public class CompleteAuthorizationTask extends RoboAsyncTask<OAuthTokensResponse> {
        private Intent mIntent;

        public CompleteAuthorizationTask(Intent intent) {
            super(MainActivity.this);
            mIntent = intent;
        }

        @Override
        public OAuthTokensResponse call() throws Exception {
            return OAuth.completeAuthorization(MainActivity.this, CLIENT_ID, CLIENT_SECRET, mIntent.getData());
        }

        @Override
        public void onSuccess(OAuthTokensResponse tokens) {
            new DisplayEmailTask(tokens).execute();
        }

        @Override
        public void onException(Exception ex) {
           // mTextView.setText("There was an error fetching access tokens using the auth code: " + ex.getMessage());
        } }*/

}
