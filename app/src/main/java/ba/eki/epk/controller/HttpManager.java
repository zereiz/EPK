package ba.eki.epk.controller;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HttpManager {

    private InputStream inputStream;
    private HttpClient httpClient;
    private HttpResponse httpResponse;
    private HttpPost httpPost;
    private HttpEntity httpEntity;
    private StringBuilder result;

    public HttpManager()
    {
        this.inputStream = null;
        this.httpClient = null;
        this.httpResponse = null;
        this.httpPost = null;
        this.httpEntity = null;
        this.result = null;
    }

    private static String buildString(InputStream paramInputStream)
    {
        StringBuilder localStringBuilder;
        try
        {
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"), 8);
            localStringBuilder = new StringBuilder();
            for (;;)
            {
                String str1 = localBufferedReader.readLine();
                if (str1 == null) {
                    break;
                }
                localStringBuilder.append(str1 + "\n");
            }
            paramInputStream.close();
        }
        catch (Exception localException)
        {
            Log.e("Buffering Error  ", localException.toString());
            return null;
        }
        String str = localStringBuilder.toString();
        return str;
    }

    public static String responseFromUrlGet(String paramString, NameValuePair... paramVarArgs)
    {
        try
        {
            ArrayList localArrayList = new ArrayList();
            int i = paramVarArgs.length;
            for (int j = 0; j < i; j++) {
                localArrayList.add(paramVarArgs[j]);
            }
            String str1 = paramString + "?" + URLEncodedUtils.format(localArrayList, "utf-8");

            Log.i("Poruka", "HTTP: " + str1);

            String str2 = buildString(new DefaultHttpClient().execute(new HttpGet(str1)).getEntity().getContent());
            Log.i("String", str2);
            return str2;
        }
        catch (Exception localException)
        {
            Log.e("Call to GET", localException.getMessage());
        }
        return null;
    }

    public static String getResponseFromUrl(String url, String key, String value){
        HttpClient httpclient = null;
        HttpPost httppost = null;
        //HttpResponse response = null;
        List<NameValuePair> nameValuePair; //= new BasicNameValuePair(key, value);

        try{
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost(url); // make sure the url is correct.
            //add your data
            nameValuePair = new ArrayList<NameValuePair>(1);
            nameValuePair.add(new BasicNameValuePair(key, value));
            // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar,
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePair));
            //Execute HTTP Post Request
            //HttpResponse response = httpclient.execute(httppost);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String rezultat = httpclient.execute(httppost, responseHandler);
            return rezultat;
        }
        catch(Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
        return null;
    }


    public static String responseFromUrlPost(String paramString, NameValuePair... paramVarArgs)
    {
        try
        {
            DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
            HttpPost localHttpPost = new HttpPost(paramString);
            if (paramVarArgs != null)
            {
                ArrayList localArrayList = new ArrayList();
                int i = paramVarArgs.length;
                for (int j = 0; j < i; j++) {
                    localArrayList.add(paramVarArgs[j]);
                }
                localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList));
            }
            HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
            StatusLine localStatusLine = localHttpResponse.getStatusLine();
            if (localStatusLine.getStatusCode() == 200) {
                return buildString(localHttpResponse.getEntity().getContent());
            }
            localHttpResponse.getEntity().getContent().close();
            throw new IOException(localStatusLine.getReasonPhrase());
        }
        catch (Exception localException)
        {
            Log.e("poziv POST", localException.getMessage());
        }
        return null;
    }
}
