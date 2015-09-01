package bitset;

import java.util.ArrayList;
import java.util.List;

public class DataItem {
	
	private int id;
	private String name;
	
	private List<Integer> areaList = new ArrayList<Integer>();
	private List<Integer> timeList = new ArrayList<Integer>();
	private List<Integer> chanelList = new ArrayList<Integer>();
	
	public DataItem(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Integer> areaList) {
		this.areaList = areaList;
	}

	public List<Integer> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Integer> timeList) {
		this.timeList = timeList;
	}

	public List<Integer> getChanelList() {
		return chanelList;
	}

	public void setChanelList(List<Integer> chanelList) {
		this.chanelList = chanelList;
	}
	
}
