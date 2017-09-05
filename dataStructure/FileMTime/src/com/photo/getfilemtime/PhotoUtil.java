package com.photo.getfilemtime;

import java.io.File;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

 

import android.media.ExifInterface;
import android.nfc.Tag;
import android.provider.ContactsContract.Directory;
import android.util.Log;

public class PhotoUtil {
String XX =ExifInterface.TAG_DATETIME;
	
	public static long getExifDateTime(String path){
		
//		 File jpegFile = new File(path);
//	     Metadata metadata;
//		try {
//			metadata = JpegMetadataReader.readMetadata(jpegFile);
////		     Iterable<Directory> exifx = metadata.getDirectories();//(ExifDirectory.class);
//		     Iterable<com.drew.metadata.Directory> tags =   metadata.getDirectories();//exifx.getTagIterator();
//		     for (com.drew.metadata.Directory s : tags) {
//		         System.out.println(s);
//		         Log.i("gabeli_img","info:"+s);
//		     }
//		} catch (JpegProcessingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

 
	  
	 
		ExifInterface exif = null;
		try {
			exif = new ExifInterface(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.i("gabeli_img","getExifDateTime 111111111111");
			e.printStackTrace();
		}
		if(null!=exif){
			return exifDateTime(exif);
		}
		return 0 ;
	}
	public static final TimeZone CURRENT_TIME_ZONE = TimeZone.getDefault();
	private static long exifDateTime(ExifInterface exif){

		try{
 
//			exif.TAG_MAKE
			String dateTimeString = exif.getAttribute(ExifInterface.TAG_DATETIME);//TAG_DATETIME);TAG_DATETIME
			if(null == dateTimeString){
				Log.i("gabeli_img","getExifDateTime XXXXXXXXXXXX");
				return 0;
			}
			ParsePosition pos = new ParsePosition(0);
			SimpleDateFormat _sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
			_sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date dateTime = _sdf.parse(dateTimeString,pos);
			if(null==dateTime){
				return 0;
			}
			long result = dateTime.getTime();
			long offset = CURRENT_TIME_ZONE.getOffset(result);
			result -= offset;
			return offset;
		}catch(Exception e){
			Log.i("gabeli_img","getExifDateTime 22222222222");
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String getFormatTime(long aTime){
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		Date dateTime = new Date(aTime);
		return _sdf.format(dateTime);
	}
}
