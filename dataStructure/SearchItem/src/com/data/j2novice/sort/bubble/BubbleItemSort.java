package com.data.j2novice.sort.bubble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.data.j2novice.sort.SortItem;

public class BubbleItemSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		System.out.println("......***......");
		BubbleItemSort _BubbleItemSort = new BubbleItemSort();
		_BubbleItemSort.bubbleSort(_testData);
		for(SortItem _item :_testData){
			System.out.print( _item.getmValue()+"\t");
		}
		
		System.out.println("......***......");
		Collections.sort(_testData2);
		for(SortItem _item :_testData2){
			System.out.print( _item.getmValue()+"\t");
		}
		System.out.println("......***......");
		boolean _result = true;
		for (int j = 0; j < 200; j++) {
			if(_testData2.get(j).getmValue()!= _testData.get(j).getmValue()){
				_result = false;
				break;
			}
		}
		System.out.println(" result :: "+_result);
	}
	
	public void bubbleSort(List<SortItem> aList) {
		int _listCnt = aList.size();
		int _indexMax = _listCnt - 1;
		for (int i = 0; i < _listCnt; i++) {
			for (int j = 0; j < _indexMax; j++) {
				SortItem _probeItem = aList.get(j);
				SortItem _nextItem = aList.get(j + 1);
				if (_probeItem.getmValue() > _nextItem.getmValue()) {
					aList.set(j, _nextItem);
					aList.set(j + 1, _probeItem);
				}
			}
		}
	}

}