package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionDemo {
	
	public static void main(String[] args) {
		try {
//			Hashtable<String, String> ht = new Hashtable<String, String>();//线程安全
//			ht.put("a", null);//value不能为null
//			System.out.println(ht);
			HashMap<String, String> m = new HashMap<String, String>();////线程不安全
			m.put("a", null);//value可为null
			System.out.println(m);
//			ConcurrentHashMap<K, V>
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
