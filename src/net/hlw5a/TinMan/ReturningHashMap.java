package net.hlw5a.TinMan;

import java.util.HashMap;

public class ReturningHashMap<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = 6045147653858547821L;

	@Override
	public V put(K key, V value) {
		if (super.containsKey(key)) {
			return super.get(key);
		}
		else {
			super.put(key,  value);
			return value;
		}
	}
}
