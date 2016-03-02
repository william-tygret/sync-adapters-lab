package com.example.syncadaptlab;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();


    private static final String AUTHORITY = "com.example.syncadaptlab.StubProvider";
    private static final String ACCOUNT_TYPE = "example.com";
    private static final String ACCOUNT= "default_account";

    Account mAccount;

    // Global variables
    // A content resolver for accessing the provider
    ContentResolver mResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates our sync account
        mAccount = createSyncAccount(this);



        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle settingsBundle = new Bundle();
                settingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL,true);
                settingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED,true);

                //request to sync, puts in queue. when it gets to ours it calls onPerformSync from syncAdapter Class
                ContentResolver.requestSync(mAccount,AUTHORITY,settingsBundle);
            }
        });

        Button button60 = (Button)findViewById(R.id.button60);
        button60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver.setSyncAutomatically(mAccount, AUTHORITY, true);
                ContentResolver.addPeriodicSync(
                        mAccount,
                        AUTHORITY,
                        Bundle.EMPTY,
                        60);
            }
        });

        Button button300 = (Button)findViewById(R.id.button60);
        button300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver.setSyncAutomatically(mAccount, AUTHORITY, true);
                ContentResolver.addPeriodicSync(
                        mAccount,
                        AUTHORITY,
                        Bundle.EMPTY,
                        300);
            }
        });
    }

    public static Account createSyncAccount(Context context){
        Account newAccount = new Account(ACCOUNT,ACCOUNT_TYPE);

        //use this if you want to authenticate account
        AccountManager accountManager = (AccountManager) context.getSystemService(ACCOUNT_SERVICE);
        if(accountManager.addAccountExplicitly(newAccount,null,null)){
        }else{

        }
        return newAccount;
    }
}
