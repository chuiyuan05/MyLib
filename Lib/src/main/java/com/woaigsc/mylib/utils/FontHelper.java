package com.woaigsc.mylib.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chuiyuan on 16-5-21.
 */
public class FontHelper {
    public static String FONT_FIRST = "zhongqichenweixin.ttf";
    public static String FONT_SECEOND = "zhongqiliqiang.ttf";

    private String DEFAULT_FONT= FONT_FIRST;//Default font.

    private static Map<String, Typeface> FONT_MAP = new HashMap<>();
    private static FontHelper instance ;

    private AssetManager mAssetManager ;

    private Context context ;

    private FontHelper(Context context){
        this.context = context;
        mAssetManager = context.getAssets();
    }

    public static FontHelper getInstance(Context context){
        if(instance == null){
            synchronized (FontHelper.class){
                if(instance == null){
                    instance = new FontHelper(context);
                }
            }
        }
        return instance;
    }

    /**
     * This is time consuming, so you can init it in AppStart in a single
     * Thread.
     * @param fontName The font you want to init.
     */
    public void initFont(String fontName){
        Typeface typeface = Typeface.createFromAsset(mAssetManager,"fonts/"+fontName);
        FONT_MAP.put(fontName,typeface);
    }

    /**
     * Init the default font.
     */
    public void initDefaultFont(){
        initFont(FONT_FIRST);
    }

    /**
     * Get font by fontName. If the no font was initiated, it will initiates
     * the font and return FONT_FIRST by default. If the font you want to use
     * was not initiated, init it now, and return.
     * @param fontName The font you want to use for this time.
     * @return
     */
    public Typeface getFont(String fontName){
        if(FONT_MAP.isEmpty()){
            initFont(FONT_FIRST);
            return FONT_MAP.get(FONT_FIRST);
        }
        if(FONT_MAP.get(fontName) == null){
            initFont(fontName);
        }
        return FONT_MAP.get(fontName);
    }

    /**
     * Set font for a TextView.
     * @param textView
     * @param fontName
     */
    public void setFont(TextView textView, String fontName){
        textView.setTypeface(getFont(fontName));
    }

    /**
     * Set FONT_FIRST by default.
     * @param textView
     */
    public void setDefaultFont(TextView textView){
        setFont(textView, FONT_FIRST);
    }

    /**
     * Set font for ViewGroup recursively.
     * @param viewGroup
     * @param fontName
     */
    public void setFont(ViewGroup viewGroup, String fontName){
        int count = viewGroup.getChildCount();
        for(int i=0; i<count; i++){
            View view = viewGroup.getChildAt(i);
            if(view instanceof TextView){
                setFont((TextView)view, fontName);//for textview
            }else if(view instanceof ViewGroup){
                setFont((ViewGroup)view, fontName);//for ViewGroup
            }
        }
    }

    /**
     * Set FONT_FIRST by default.
     * @param viewGroup
     */
    public void setDefaultFont(ViewGroup viewGroup){
        setFont(viewGroup, FONT_FIRST);
    }

    /**
     * The fonts in use should be as less as possible.
     * @param fontName
     */
    public void removeFont(String fontName){
        FONT_MAP.remove(fontName);
    }

    public void clearFonts(){
        FONT_MAP.clear();
    }

}
