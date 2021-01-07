package com.mdy.array_lib;

import java.util.*;

public class MyClass {


    public static void main(String[] args) {


        String json ="{\"建行纸黄金\":[1187,1188,1189,1190,1191,1192,1193,1194,1195,1196],\"中行纸黄金\":[12503,12504,12505,12506,12507,12508,12509,12510],\"农行纸黄金\":[12511,12512,12513,12514,12515,12516,12517,12518],\"工行纸黄金\":[1016,1017,1018,1019,1020,1021,1022,1023,12356,12357,12358,12359,12360,12361]}";

        try {
            JSONObject jsonObject = new JSONObject(bankJson);
            Iterator<String> iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String bankName = iterator.next();
                JSONArray jsonArray = jsonObject.getJSONArray(bankName);
                List<Integer> bankList = new LinkedList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    bankList.add((Integer) jsonArray.get(i));
                }
                bankMap.put(bankName, bankList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}