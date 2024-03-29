package com.example.finalyear;

import static com.example.finalyear.Network.getRequest;

import android.os.Build;

import androidx.annotation.RequiresApi;

//import com.example.mpesastkpush.settings.SandBox;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

//import static com.example.mpesastkpush.okhttp.Network.getRequest;

public class StkPush {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void stkpush(String businessShortCode, String password, String timestamp, String transactionType, String amount, String phoneNumber, String partyA, String partyB, String callBackURL, String accountReference, String transactionDesc) throws IOException,JSONException {

        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("BusinessShortCode", businessShortCode);
        jsonObject.put("Password", password);
        jsonObject.put("Timestamp", timestamp);
        jsonObject.put("TransactionType", transactionType);
        jsonObject.put("Amount",amount);
        jsonObject.put("PhoneNumber", phoneNumber);
        jsonObject.put("PartyA", partyA);
        jsonObject.put("PartyB", partyB);
        jsonObject.put("CallBackURL", callBackURL);
        jsonObject.put("AccountReference", accountReference);
        jsonObject.put("TransactionDesc", transactionDesc);

        jsonArray.put(jsonObject);
        String requestJson=jsonArray.toString().replaceAll("[\\[\\]]","");

        getRequest(requestJson, Sandbox.getStk_push_url());

    }


}

