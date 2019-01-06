package map;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, String> hashTable = new Hashtable<String,String>();
		hashTable.put("t1", "1");
		hashTable.put("t2", "2");
		hashTable.put("t3", "3");
		Enumeration<Map.Entry<String, String>> iterator1 =  (Enumeration<Entry<String, String>>) hashTable.entrySet().iterator();
		hashTable.remove(iterator1.nextElement().getKey());
		while(iterator1.hasMoreElements()) {
			System.out.println(iterator1.nextElement()+"	");
		}
		System.out.println("------------------");
		Map<String, String> hashMap = new HashMap<String,String>();
		hashMap.put("h1", "1");
		hashMap.put("h2", "2");
		hashMap.put("h3", "3");
		Iterator<Map.Entry<String,String>> iterator2 = hashMap.entrySet().iterator();
		hashMap.remove(iterator2.next().getKey());
		while(iterator2.hasNext()) {
			//报错：java.util.ConcurrentModificationException， 遍历时先删除，导致迭代器记录的数量与集合当前数量不一致，报错
			System.out.println(iterator2.next()+"	");
		}
		
	}
}
