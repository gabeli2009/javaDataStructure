package com.data.j2novice.sort.select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.data.j2novice.sort.SortItem;

/***
 * 选择排序（Selection sort）是一种简单直观的排序算法。它的工作原理如下。首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * 选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，则它不会被移动。选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，
 * 因此对n个元素的表进行排序总共进行至多n-1次交换。在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
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
			min = i;// 未排序序列中最小数据数组下标
			for (j = i + 1; j < len; j++)// 在未排序元素中继续寻找最小元素，并保存其下标
				if (arr.get(min).getmValue() > arr.get(j).getmValue()) {
					min = j;
				}
			_tempItem = arr.get(min); // 将最小元素放到已排序序列的末尾
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
