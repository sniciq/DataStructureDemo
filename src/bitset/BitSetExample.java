package bitset;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BitSetExample {

	private static final int ara_北京 = 0;
	private static final int ara_上海 = 1;
	
	private static final int time_01 = 2;
	private static final int time_02 = 3;
	
	private static final int ch_01 = 4;
	private static final int ch_02 = 5;
	
	private static final String[] dimName = {"ara_北京", "ara_上海", "time_01", "time_02", "ch_01", "ch_02"};
	
	public static void main(String[] args) {
		List<DataItem> dataList = new ArrayList<DataItem>();
		
		DataItem item = new DataItem(1, "1");
		item.getAreaList().add(ara_北京);
		item.getChanelList().add(ch_01);
		item.getTimeList().add(time_01);
		dataList.add(item);
		
		item = new DataItem(2, "2");
		item.getAreaList().add(ara_北京);
		item.getAreaList().add(ara_上海);
		item.getChanelList().add(ch_01);
		item.getChanelList().add(ch_02);
		item.getTimeList().add(time_01);
		item.getTimeList().add(time_02);
		dataList.add(item);
		
		item = new DataItem(3, "3");
		item.getAreaList().add(ara_上海);
		item.getChanelList().add(ch_02);
		item.getTimeList().add(time_01);
		item.getTimeList().add(time_02);
		dataList.add(item);
		
		List<BitSet> dimIndex = createDataIndex(dataList);
		
		item = new DataItem(4, "4");
		item.getAreaList().add(ara_上海);
		item.getChanelList().add(ch_01);
		item.getTimeList().add(time_01);
		item.getTimeList().add(time_02);
		dataList.add(item);
		updateDataIndex(dimIndex, item, dataList.size() - 1);
		
		System.out.println("索引数据如下：");
		for(int i = 0 ; i < dimIndex.size(); i++) {
			BitSet bs = dimIndex.get(i);
			System.out.println(dimName[i] + "\t\t" + bs);
		}
		System.out.println();
		
		//查询ara_北京和ara_上海、chanel_01的数据
		System.out.println("查询结果：");
		BitSet b1 = dimIndex.get(ara_上海);
		BitSet b2 = dimIndex.get(ara_北京);
		BitSet b3 = dimIndex.get(ch_02);
		BitSet b4 = dimIndex.get(time_01);
//		b1.and(b2);
//		b1.and(b3);
		b1.and(b4);
		System.out.println(b1);
	}

	/**
	 * 更新索引
	 * @param dimIndex
	 * @param item
	 */
	private static void updateDataIndex(List<BitSet> dimIndex, DataItem item, int index) {
		for(Integer area : item.getAreaList()) {
			BitSet bs = dimIndex.get(area);
			bs.set(index);
		}
		for(Integer channel : item.getChanelList()) {
			BitSet bs = dimIndex.get(channel);
			bs.set(index);
		}
		for(Integer time : item.getTimeList()) {
			BitSet bs = dimIndex.get(time);
			bs.set(index);
		}
	}

	/**
	 * 建立索引
	 */
	private static List<BitSet> createDataIndex(List<DataItem> dataList) {
		List<BitSet> dimIndex = new ArrayList<>();
		for(int i = 0; i < dimName.length; i++) {//假设有100个维度
			BitSet bs = new BitSet();
			dimIndex.add(bs);
		}
		
		for(int i = 0 ; i < dataList.size(); i++) {
			DataItem item = dataList.get(i);
			for(Integer area : item.getAreaList()) {
				BitSet bs = dimIndex.get(area);
				bs.set(i);
			}
			for(Integer channel : item.getChanelList()) {
				BitSet bs = dimIndex.get(channel);
				bs.set(i);
			}
			for(Integer time : item.getTimeList()) {
				BitSet bs = dimIndex.get(time);
				bs.set(i);
			}
		}
		
		return dimIndex;
	}
	
}
