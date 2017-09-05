package com.photo.getfilemtime;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;

public class FExternalStorage {

    public static final String SD_CARD = "sdCard";
    public static final String EXTERNAL_SD_CARD = "externalSdCard";

    public static List<String> getStoragePahtList(Context context){
    	StorageManager _sm = (StorageManager)context.getSystemService(context.STORAGE_SERVICE);
    	List<String> _sList = new ArrayList<String>();
    	try{
    		Object[] _storageVolumes = (Object[])_sm.getClass().getMethod("getVolumeList" ).invoke(_sm);
    		if(_storageVolumes!=null && _storageVolumes.length>0){
    			Method _methodGetPath =_storageVolumes[0].getClass().getDeclaredMethod("getPath");
    			Method _methodGetVolumeState = _sm.getClass().getMethod("getVolumeState",String.class);
    			for(Object _volume : _storageVolumes){
    				String _path00 = (String)_methodGetPath.invoke(_volume);
    				if(null!= _path00){
    					if(Environment.MEDIA_MOUNTED.equals(_methodGetVolumeState.invoke(_sm, _path00))){
    						_sList.add(_path00);
    					}
    				}
    			}
    		}
    		
    	}catch(Exception e){
    		
    	}
    	return _sList;
    }
    /**
     * @return True if the external storage is available. False otherwise.
     */
    public static boolean isAvailable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public static String getSdCardPath() {
        return Environment.getExternalStorageDirectory().getPath() + "/";
    }

    /**
     * @return True if the external storage is writable. False otherwise.
     */
    public static boolean isWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;

    }

    /**
     * @return A map of all storage locations available
     */
    public static Map<String, File> getAllStorageLocations() {
        Map<String, File> map = new HashMap<String, File>(10);

        List<String> mMounts = new ArrayList<String>(10);
        List<String> mVold = new ArrayList<String>(10);
        mMounts.add("/mnt/sdcard");
        mVold.add("/mnt/sdcard");

        try {
            File mountFile = new File("/proc/mounts");
            if(mountFile.exists()){
                Scanner scanner = new Scanner(mountFile);
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("/dev/block/vold/")) {
                        String[] lineElements = line.split(" ");
                        String element = lineElements[1];

                        // don't add the default mount path
                        // it's already in the list.
                        if (!element.equals("/mnt/sdcard"))
                            mMounts.add(element);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File voldFile = new File("/system/etc/vold.fstab");
            if(voldFile.exists()){
                Scanner scanner = new Scanner(voldFile);
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("dev_mount")) {
                        String[] lineElements = line.split(" ");
                        String element = lineElements[2];

                        if (element.contains(":"))
                            element = element.substring(0, element.indexOf(":"));
                        if (!element.equals("/mnt/sdcard"))
                            mVold.add(element);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < mMounts.size(); i++) {
            String mount = mMounts.get(i);
            if (!mVold.contains(mount))
                mMounts.remove(i--);
        }
        mVold.clear();

        List<String> mountHash = new ArrayList<String>(10);

        for(String mount : mMounts){
            File root = new File(mount);
            if (root.exists() && root.isDirectory() && root.canWrite()) {
                File[] list = root.listFiles();
                String hash = "[";
                if(list!=null){
                    for(File f : list){
                        hash += f.getName().hashCode()+":"+f.length()+", ";
                    }
                }
                hash += "]";
                if(!mountHash.contains(hash)){
                    String key = SD_CARD + "_" + map.size();
                    if (map.size() == 0) {
                        key = SD_CARD;
                    } else if (map.size() == 1) {
                        key = EXTERNAL_SD_CARD;
                    }
                    mountHash.add(hash);
                    map.put(key, root);
                }
            }
        }

        mMounts.clear();

        if(map.isEmpty()){
                 map.put(SD_CARD, Environment.getExternalStorageDirectory());
        }
        return map;
    }
}
