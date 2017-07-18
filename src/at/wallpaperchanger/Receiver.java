package at.wallpaperchanger;

import java.io.File;
import java.io.IOException;

import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Receiver extends BroadcastReceiver {
	FileSaver map = new FileSaver();
	final String path = "/storage/emulated/0/DCIM/Camera";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		changeWallpaper(context);
	}
	
	private void changeWallpaper(Context context) {
        WallpaperManager myWallpaperManager = WallpaperManager.getInstance(context);
        getPicsFromPath(context);
        String fileName = map.randomFile();
        Bitmap bMap = BitmapFactory.decodeFile(fileName);
        try {
            myWallpaperManager.setBitmap(bMap);
        } catch (IOException e) {
            e.printStackTrace();	
        }
	}

	private void getPicsFromPath(Context context) {
		Log.d("Files", "Path: " + path);
		File f = new File(path);        
		File file[] = f.listFiles();
		Log.d("Files", "Size: "+ file.length);
		for (int i=0; i < file.length; i++)
		{
			if(file[i].getName().endsWith("jpg"))
				//Log.d("Files", "FileName:" + file[i].getName());
				//Toast.makeText(context, "Filename: " + file[i].getName(), Toast.LENGTH_LONG).show();
				storeToDic(file[i].toString());
		}
	}

	private void storeToDic(String name) {
		map.putToTreeMap(name);
	}
}
