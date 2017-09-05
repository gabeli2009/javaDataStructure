package com.data.j2novice.sort.select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.data.j2novice.sort.SortItem;

/***
 * ѡ������Selection sort����һ�ּ�ֱ�۵������㷨�����Ĺ���ԭ�����¡�������δ�����������ҵ���С����Ԫ�أ���ŵ��������е���ʼλ�ã�Ȼ��
 * �ٴ�ʣ��δ����Ԫ���м���Ѱ����С����Ԫ�أ�Ȼ��ŵ����������е�ĩβ���Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�
 * ѡ���������Ҫ�ŵ��������ƶ��йء����ĳ��Ԫ��λ����ȷ������λ���ϣ��������ᱻ�ƶ���ѡ������ÿ�ν���һ��Ԫ�أ����ǵ���������һ�������Ƶ�������λ���ϣ�
 * ��˶�n��Ԫ�صı���������ܹ���������n-1�ν����������е���ȫ��������ȥ�ƶ�Ԫ�ص����򷽷��У�ѡ���������ڷǳ��õ�һ�֡�
 * 
 * @author gabeli
 *
 */
public class SelectItemSort {

	public static void main(String[] args) {
		ArrayList<SortItem> _testData = new ArrayList<SortItem>();
		ArrayList<SortItem> _testData2 = new ArrayList<SortItem>();
		Random _r = new Random();
		for (int j = 0; j < 200; j++) {
			SortItem _aItem = new SortItem(j + "asdfa", _r.nextInt(300));
			_testData.add(_aItem);
			_testData2.add(_aItem);
		}
		
		for(SortItem _item :_testData){
			System.out.print( _item.getmValue()+"\t");
		}
		System.out.println(" .");
		System.out.println("************************");
		
		SelectItemSort _qs = new SelectItemSort( );
		_qs.selection_sort(_testData);//_qs.selectSort(_testData);
		for(SortItem _item :_testData){
			System.out.print( _item.getmValue()+"\t");
		}
		System.out.println(" .");
		System.out.println("************************");
		Collections.sort(_testData2);
		for(SortItem _item :_testData2){
			System.out.print( _item.getmValue()+"\t");
		}
		System.out.println(" .");
		
		boolean _result = true;
		for (int j = 0; j < 200; j++) {
			if(_testData2.get(j).getmValue()!= _testData.get(j).getmValue()){
				_result = false;
				break;
			}
		}
		System.out.println(" result :: "+_result);
		
	}
	
	public void selection_sort(List<SortItem> arr) {
		int i, j, min, len = arr.size();
		SortItem _tempItem;
		for (i = 0; i < len - 1; i++) {
			min = i;// δ������������С���������±�
			for (j = i + 1; j < len; j++)// ��δ����Ԫ���м���Ѱ����СԪ�أ����������±�
				if (arr.get(min).getmValue() > arr.get(j).getmValue()) {
					min = j;
				}
			_tempItem = arr.get(min); // ����СԪ�طŵ����������е�ĩβ
			arr.set(min, arr.get(i));
			arr.set(i, _tempItem);
		}
	}
	
	public void selectSort(List<SortItem> aListItem) {
		SortItem _smallItem = null;
		int _listSize = aListItem.size();
		int _smallIndex = 0;
		_smallItem = aListItem.get(_smallIndex);
		int _loop = 1;
		while (_loop < _listSize) {
			for (int i = _loop; i < _listSize; i++) {
				if (_smallItem.getmValue() > aListItem.get(i).getmValue()) {
					_smallItem = aListItem.get(i);
					_smallIndex = i;
				}
			}
			if (_smallIndex > _loop - 1) {
				SortItem _swapItem = aListItem.get(_loop - 1);
				aListItem.set(_loop - 1, _smallItem);
				aListItem.set(_smallIndex, _swapItem);
			}
			_smallItem = aListItem.get(_loop);
			_smallIndex = _loop;
			_loop++;
		}
	}

}
