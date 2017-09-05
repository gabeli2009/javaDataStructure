package com.data.j2novice.search;


public class DataItem  implements Comparable<DataItem>{
	private int mKeyId;
	public String mName;

	private static int S_ID = 0;

	public DataItem(String aName) {
		synchronized (DataItem.class) {
			mKeyId = S_ID;
			S_ID++;
		}
		mName = aName;
	}

	public int getmKeyId() {
		return mKeyId;
	}
	
	@Override
	public int compareTo(DataItem aTarget) {
		if (mKeyId < aTarget.getmKeyId()) // ����Ƚϵ���ʲô sort����ʵ�ֵľ��ǰ��մ˱ȽϵĶ�����С��������
			return -1;
		if (mKeyId > aTarget.getmKeyId())
			return 1;
		return 0;
	}
}
