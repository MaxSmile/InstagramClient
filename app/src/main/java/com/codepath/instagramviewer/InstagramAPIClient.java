package com.codepath.instagramviewer; /**
 * Created by ccoria on 1/26/15.
 */

import com.loopj.android.http.*;

public class InstagramAPIClient {
    private static final String BASE_URL = "https://api.instagram.com/v1";
    private static final String CLIENT_ID = "client_id=fff0ebf2d62d40efa3e2b2a01d201dd4";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl + "?" + CLIENT_ID;
    }
}
