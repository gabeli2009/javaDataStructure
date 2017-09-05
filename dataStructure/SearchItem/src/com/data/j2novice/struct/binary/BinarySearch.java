package com.data.j2novice.struct.binary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class BinarySearch {
	public static final int N = 50000;

	public static void main(String[] args) {
		
		HashMap<String,Item> valMaps = new HashMap<String,Item>();
		
		ArrayList<Item> vals = new ArrayList<Item>();
		Item _tItem;
		Random r = new Random();
		int currval = 0;
		for (int i = 0; i < N; i++) {
			_tItem = new Item();
			_tItem.name = "" + currval;
			// ���������������Ϳ���ȷ��������������
			currval += r.nextInt(10) + 1;
			vals.add(_tItem);
			valMaps.put("xcd"+Integer.toString(i), _tItem);
		}

		// ��õ�ǰʱ��
		long start = System.currentTimeMillis();
		for (int j = 0; j < 10000; j++) {
		for (int i = 0; i < N; i++) {
			 //���ֲ��ң����index,�˷���Ҫ��listΪ�������û�ж��б�������������ǲ�ȷ����
			 int index=BinarySearch.find(vals, vals.get(i));
			 //�ж��ҳ�����λ���Ƿ�Ϊ��Ӧ��λ�ã�
			 if(index!=i){
			 System.out.println(vals.get( i-1).getId()+"** **"+vals.get(i).getId()+ " index ::"+i);
			 }
//			 else{
//				 System.out.println( vals.get(i).getId()+ " index ::"+i+" value: "+vals.get(i).name);
//			 }
		 
		}}
//		for (int j = 0; j < 100; j++) {
//		for (int i = 0; i < N; i++) {
//			int _rid = r.nextInt(N);
//			 //���ֲ��ң����index,�˷���Ҫ��listΪ�������û�ж��б�������������ǲ�ȷ����
//			 int index=BinarySearch.find(vals, vals.get(_rid));
//			 //�ж��ҳ�����λ���Ƿ�Ϊ��Ӧ��λ�ã�
//			 if(index!=_rid){
//			 System.out.println(vals.get( _rid-1).getId()+"** **"+vals.get(_rid).getId()+ " index ::"+_rid);
//			 }
////			 else{
////				 System.out.println( vals.get(i).getId()+ " index ::"+i+" value: "+vals.get(i).name);
////			 }
//		 
//		}
//		}
		// �������ʱ��
		long _costTime = System.currentTimeMillis() - start;

		System.out.println("cost time :: " + _costTime);
		
		start = System.currentTimeMillis();
		for (int j = 0; j < 10000; j++) {
		for (int i = 0; i < N; i++) {
			 //���ֲ��ң����index,�˷���Ҫ��listΪ�������û�ж��б�������������ǲ�ȷ����
			Item _item = valMaps.get("xcd"+vals.get(i).getId());

			int index = _item.getId();// BinarySearch.find(vals, vals.get(i));
			// �ж��ҳ�����λ���Ƿ�Ϊ��Ӧ��λ�ã�
			if (index != i) {
				System.out.println(vals.get(i - 1).getId() + "** **" + vals.get(i).getId() + " index ::" + i);
			}
//			 else{
//				 System.out.println( vals.get(i).getId()+ " index ::"+i+" value: "+vals.get(i).name);
//			 }
		 
		}
		}
//		for (int j = 0; j < 100; j++) {
//			for (int i = 0; i < N; i++) {
//				int _rid = r.nextInt(N);
//				 //���ֲ��ң����index,�˷���Ҫ��listΪ�������û�ж��б�������������ǲ�ȷ����
//				Item _item = valMaps.get("xcd"+vals.get(_rid).getId());
//
//				int index = _item.getId();// BinarySearch.find(vals, vals.get(i));
//				// �ж��ҳ�����λ���Ƿ�Ϊ��Ӧ��λ�ã�
//				if (index != _rid) {
//					System.out.println(vals.get(_rid - 1).getId() + "** **" + vals.get(_rid).getId() + " index ::" + _rid);
//				}
////				 else{
////					 System.out.println( vals.get(i).getId()+ " index ::"+i+" value: "+vals.get(i).name);
////				 }
//			 
//			}
//		 
//		}

		// �������ʱ��
		  _costTime = System.currentTimeMillis() - start;

		System.out.println("cost time :: " + _costTime);
	}

	
	public static int find(ArrayList<Item> keys, Item target) {
		int high = keys.size();
		int low = -1;
		while (high - low > 1) {
			int probe = (low + high) >>> 1;
			if (keys.get(probe).compareTo(target) > 0)
				high = probe;
			else
				low = probe;
		}
		if (low == -1 || keys.get(low).compareTo(target) != 0)
			return -1;
		else
			return low;
	}
}
