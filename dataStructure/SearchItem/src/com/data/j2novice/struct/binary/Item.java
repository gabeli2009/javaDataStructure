package com.data.j2novice.struct.binary;

public class Item implements Comparable<Item>{
	private static int S_ID = 0;
	private int mId;
	public String name;

	public Item() {
		synchronized (Item.class) {
			mId = S_ID;
			S_ID++;
		}
	}

	public int getId() {
		return mId;
	}
 
	@Override
	public int compareTo(Item arg0) {
		if (mId < arg0.getId()) // ����Ƚϵ���ʲô sort����ʵ�ֵľ��ǰ��մ˱ȽϵĶ�����С��������
			return -1;
		if (mId > arg0.getId())
			return 1;
		return 0;
	}

}