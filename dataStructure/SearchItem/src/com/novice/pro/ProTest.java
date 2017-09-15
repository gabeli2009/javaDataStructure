package com.novice.pro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ProTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File _xx = new File("d:\\gabeli\\west\\lzz.txt ");
		if(_xx.exists())
			_xx.delete();
		File _p = _xx.getParentFile();
		if(_p.isDirectory() && _p.list().length ==0){
			System.out.println("delete");
//			_p.delete();
		}
//Properties _p = new Properties();
//_p.setProperty("key1", "111");
//_p.setProperty("key2", "222");
//_p.setProperty("key3", "333");
//_p.setProperty("key4", "444");
//File _f = new File("d:\\pro_gabeli.txt");
//
//try {
//	
//	Properties _p2 = new Properties();
//	FileOutputStream out = new FileOutputStream("d:\\pro_gabeli.txt");
//	_p.store(out, "gabeli commit");
//	FileInputStream inStream = new FileInputStream("d:\\pro_gabeli.txt");
//	_p2.load(inStream);
//	
//	for(String key : _p2.stringPropertyNames()) {
//		  String value = _p2.getProperty(key);
//		  System.out.println(key + " => " + value);
//		}
//	System.out.println(  "===============> "  );
//	FileOutputStream outxml = new FileOutputStream("d:\\pro_gabelixml.txt");
//	_p.storeToXML( outxml, "xml commit");
//	
//	
//	  inStream = new FileInputStream("d:\\pro_gabelixml.txt");
//	  _p2.loadFromXML( inStream);
//	
//	for(String key : _p2.stringPropertyNames()) {
//		  String value = _p2.getProperty(key);
//		  System.out.println(key + " => " + value);
//		}
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//ByteArrayOutputStream bos = new ByteArrayOutputStream();
//_p.store(_f., comments);
//ByteArrayOutputStream bos = new ByteArrayOutputStream();
	}

}
