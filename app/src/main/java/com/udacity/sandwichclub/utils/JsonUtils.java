package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich;
        JSONObject name;
        String mainName = null;
        List<String> alsoKnownAs = null;
        String placeOfOrigin = null;
        String description = null;
        String image = null;
        List<String> ingredients = null;

        try {
            JSONObject contact = new JSONObject(json);
            name = contact.getJSONObject("name");
            mainName = name.getString("mainName");

            JSONArray alsoKnownAs_Array = name.getJSONArray("alsoKnownAs");
            alsoKnownAs = new ArrayList<>();

            if (alsoKnownAs_Array.length() != 0){
                for (int i = 0; i < alsoKnownAs_Array.length(); i++) {
                    alsoKnownAs.add(alsoKnownAs_Array.getString(i));
                }
            }

            placeOfOrigin = contact.getString("placeOfOrigin");
            description = contact.getString("description");
            image = contact.getString("image");

            JSONArray ingredients_Array = contact.getJSONArray("ingredients");
            ingredients = new ArrayList<>();

            if (ingredients_Array.length() != 0) {
                for (int i = 0; i < ingredients_Array.length(); i++) {
                    ingredients.add(ingredients_Array.getString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        return sandwich;
    }
}
