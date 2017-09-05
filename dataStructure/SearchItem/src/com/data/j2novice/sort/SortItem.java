package com.data.j2novice.sort;


public class SortItem implements Comparable<SortItem>{
	private int mKeyId;
	public String mName;
	private int mValue;


	private static int S_ID = 0;

	public SortItem(String aName,int aValue) {
		synchronized (SortItem.class) {
			mKeyId = S_ID;
			S_ID++;
		}
		mName = aName;
		mValue = aValue;
	}

	public int getmKeyId() {
		return mKeyId;
	}
	
	public int getmValue() {
		return mValue;
	}
	@Override
	public int compareTo(SortItem aTarget) {
		if (mValue < aTarget.getmValue()) // ����Ƚϵ���ʲô sort����ʵ�ֵľ��ǰ��մ˱ȽϵĶ�����С��������
			return -1;
		if (mValue > aTarget.getmValue())
			return 1;
		return 0;
	}
}