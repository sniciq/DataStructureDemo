package hash;

import java.util.Arrays;

public class SimpleHash {

	private int capacity;
	private int size;
	private Item[] values;
	
	public SimpleHash(int capacity) {
		this.capacity = capacity;
		values = new Item[capacity];
		size = 0;
	}
	
	public void put(String key, String value) {
		int hashCode = getHashCode(key);
		boolean isCover = false;
		while(values[hashCode] != null) {
			if(values[hashCode].getKey().equals(key)) {//已存在，替换，且size不加
				isCover = true;
				break;
			}
			hashCode = (hashCode + 1) % capacity;
		}
		values[hashCode] = new Item(key, value);
		
		if(!isCover) {
			size ++;
		}
		
		System.out.println(size + ", " + capacity);
		if(size >= capacity) {//需要扩容
			rehash();
		}
	}
	
	public String get(String key) {
		int hashCode = getHashCode(key);
		while(values[hashCode] != null && !values[hashCode].getKey().equals(key)) {
			hashCode ++;
		}
		return values[hashCode].getValue();
	}
	
	public void remove(String key) {
		int hashCode = getHashCode(key);
		while(values[hashCode] != null && !values[hashCode].getKey().equals(key)) {
			hashCode ++;
		}
		
		values[hashCode] = null;
		size --;
	}
	
	private int getHashCode(String key) {
		return key.hashCode() % capacity;
	}
	
	private void rehash() {
		Item[] old = Arrays.copyOf(values, values.length);
		this.capacity = this.capacity * 2 + 1;
		this.values = new Item[this.capacity];
		this.size = 0;
		for(int i = 0; i < old.length; i++) {
			if(old[i] != null) {
				int hashCode = getHashCode(old[i].getKey());
				boolean isCover = false;
				while(values[hashCode] != null) {
					if(values[hashCode].getKey().equals(old[i].getKey())) {
						isCover = true;
						break;
					}
					hashCode = (hashCode + 1) % capacity;
				}
				values[hashCode] = new Item(old[i].getKey(), old[i].getValue());
				
				if(!isCover) {
					size ++;
				}
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				sb.append(values[i]).append(",");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SimpleHash sh = new SimpleHash(2);
		sh.put("1", "aaa");
		sh.put("2", "b");
		sh.put("3", "c");
		sh.put("4", "d");
		System.out.println(sh.toString());
		System.out.println(sh.get("4"));

		sh.put("4", "E");
		System.out.println(sh.get("4"));
		
		sh.put("4", "G");
		System.out.println(sh.get("4"));
		
		sh.remove("4");
		System.out.println(sh.toString());
		
		sh.put("4", "d");
		sh.put("5", "d");
		sh.put("6", "d");
		sh.put("7", "d");
		sh.put("8", "d");
		sh.put("9", "d");
		sh.put("10", "d");
		
		System.out.println(sh.capacity);
		System.out.println(sh.size);
		System.out.println(sh.toString());
	}
}

class Item {
	private String key;
	private String value;
	
	public Item(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString() {
		return "[" + key + "|" + value + "]";
	}
}
