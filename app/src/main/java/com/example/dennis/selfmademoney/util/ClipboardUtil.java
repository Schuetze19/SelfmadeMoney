package com.example.dennis.selfmademoney.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardUtil {

    public static void copyToClipboard(Activity activity, String key, String text){
        ClipboardManager clipboard = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(key, text);
        clipboard.setPrimaryClip(clip);
    }

}
