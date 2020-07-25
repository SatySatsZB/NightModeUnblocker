package project.vivid.installer.hex.plugin.night;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.widget.Toast;

public class CustomNightModeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableNightMode();
    }

    @SuppressLint("InlinedApi")
    public void enableNightMode() {
        ContentResolver contentResolver = getContentResolver();
        try {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("name", "current_theme_support_night_mode");
            contentValues.put("value", "1");
            contentResolver.insert(Uri.parse("content://settings/system"), contentValues);
            startActivity(new Intent("android.settings.NIGHT_THEME_SETTINGS"));
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Failed to enable Night Mode", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            finish();
        }
    }

}
