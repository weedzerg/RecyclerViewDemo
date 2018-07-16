package com.lx.ltuddd.demorecyclerview.utils;

import android.content.Context;
import android.util.Log;

import com.lx.ltuddd.demorecyclerview.R;
import com.lx.ltuddd.demorecyclerview.objects.HeroObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DaiPhongPC on 7/16/2018.
 */

public class AssetsReader {
    public static final String TAG = "AssetsReader";

    public static ArrayList<HeroObject> readArrHerro(Context context) {
        ArrayList<HeroObject> arrHero = new ArrayList<>();
        try {
            String[] arrImage = context.getAssets().list(Contants.FOLDER_IMAGE_HERO);
            for (String name : arrImage) {
                arrHero.add(new HeroObject(Utils.formatString(Contants.PATH_FOLDER_IMAGE_HERO, name),
                        name));
            }
            return arrHero;
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, context.getResources().getString(R.string.existfolder));
            return null;
        }
    }
}
