package com.example.syncadaptlab;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by nat on 3/2/16.
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {
    private static final String TAG = SyncAdapter.class.getCanonicalName();
    //the most basic sync adapter has contructor and on perform synch

    //for constructor, best practices requires two constructors, one with more parameters (which lets you synch more than one a time for multiple account)
    //its a flag to let it happen

    ContentResolver mContentResolver ;//not really used in this sample, but here for future reference
    public SyncAdapter(Context context, boolean autoInitialize){
        super(context,autoInitialize);
        mContentResolver = context.getContentResolver();
    }
    public SyncAdapter(Context context, boolean autoInitialize,boolean allowParallelSyncs){
        super(context,autoInitialize,allowParallelSyncs);
        mContentResolver = context.getContentResolver();
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        //when its our turn in the queue, it calls onPerformSync
        String data ="";
        try {
            URL url = new URL("http://api.nytimes.com/svc/news/v3/content/all/all/2.json?limit=20&api-key=dee1efe817032e856101456f7b475755%3A17%3A74605161");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inStream = connection.getInputStream();
            data = getInputData(inStream);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        //Gson gson = new Gson();
        /*SearchResult searchResult = gson.fromJson(data, SearchResult.class);

        int counter=0;
        while(counter<5){
            String title = searchResult.getResults().get(counter).getTitle();
            Log.d(TAG, title);
            counter++;
        }
        ;*/

    }
    private String getInputData(InputStream inStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

        String data = null;

        while ((data = reader.readLine()) != null){
            builder.append(data);
        }

        reader.close();

        return builder.toString();
    }
}