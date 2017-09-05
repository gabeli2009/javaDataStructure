package com.photo.getfilemtime;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;

import android.util.Log;

public class ListSdFiles {
Queue mPathQueue;

	public void listByQueue(String aPath) {

		String _logfile = FExternalStorage.getSdCardPath() + File.separator + "sd_file.txt";
		// final int FILE_QUEUE_SIZE = 10;// 阻塞队列大小
		// final int SEARCH_THREADS = 100;// 关键字搜索线程个数
		//
		// // 基于ArrayBlockingQueue的阻塞队列
		// BlockingQueue<File> queue = new ArrayBlockingQueue<File>(
		// FILE_QUEUE_SIZE);
		// mPathQueue = new Queue<String>();
		// File _rFile = new File(aPath);
		// if(_rFile.isDirectory()){
		// File[] _f = _rFile.listFiles();
		// if(null!=_f){
		// int _fileCnt = _f.length;
		// for(int i = 0;i<_fileCnt;i++){
		// if(_f[i].isDirectory()){
		// Log.i("gabeliPath", "folder:"+_f[i].getAbsolutePath());
		// mPathQueue.add(_f[i].getAbsolutePath());
		// }else{
		// Log.i("gabeliPath", "file:"+_f[i].getAbsolutePath());
		//
		// }
		//
		// }
		// }
		// }

		StringBuffer _sb = new StringBuffer();
		mPathQueue = new ArrayDeque<String>();
		String _folderPath = aPath;
		File _fpath = new File(aPath);
		
		 
		while (null != _folderPath) {
			_fpath = new File(_folderPath);
			File[] _fs = _fpath.listFiles();
			if (null != _fs) {
				int _fcnt = _fs.length;
				for (int i = 0; i < _fcnt; i++) {
					if (_fs[i].isDirectory()) {
						Log.i("gabeliPath", "folder:" + _fs[i].getAbsolutePath());
						mPathQueue.add( _fs[i].getAbsolutePath());
						_sb.append( "folder:" + _fs[i].getAbsolutePath() + " " + formateTime(_fs[i].lastModified()));
						_sb.append("\n");
					} else {
						Log.i("gabeliPath", "file:" + _fs[i].getAbsolutePath() + " " + _fs[i].lastModified());
						_sb.append( "file:" + _fs[i].getAbsolutePath() + " " + _fs[i].lastModified() + " "
								+ formateTime(_fs[i].lastModified()));
						_sb.append("\n");
					}
				}
			}else{
				_sb.append( "file:" + _fpath.getAbsolutePath() + " " + _fpath.lastModified() + " "
						+ formateTime(_fpath.lastModified()));
				_sb.append("\n");
			}
			if(_sb.length()>102400){
				write2File(_logfile,_sb.toString());
				_sb.setLength(0);
			}
			_folderPath = (String) mPathQueue.poll();
		 
		}
	
		
		
		
		if (_fpath.isDirectory()) {} else {
			_sb.append("file:" + _fpath.getAbsolutePath() + " " + _fpath.lastModified() + " "
					+ formateTime(_fpath.lastModified()));
			_sb.append("\n");
		}
		if (_sb.length() > 0) {
			_sb.setLength(0);
		}
		write2File(_logfile, _sb.toString());

		
		
		_folderPath = aPath;// (String) mPathQueue.peek();


	}

	public static String formateTime(long aTime) {
		SimpleDateFormat dateFormater = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		Date date = new Date(aTime);
		System.out.print(dateFormater.format(date));
		return dateFormater.format(date);
	}


	public static void write2File(String aFilePath, String aFileContent) {
		FileWriter _fw = null;
		try{
			File _f = new File(aFilePath);
			if(!_f.exists()){
				_f.createNewFile();
			}
			_fw= new FileWriter(_f,true);
			_fw.write(aFileContent+"\n");
			_fw.flush();
		}catch(Exception e){
			
		}
	}
}
