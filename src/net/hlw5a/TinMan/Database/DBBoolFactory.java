package net.hlw5a.TinMan.Database;

public class DBBoolFactory {
	
	public static DBBool Create(String Value) {
		if (Value == "" || Value == null) return DBBool.Unknown;
		else return DBBool.valueOf(Value.substring(0, 1).toUpperCase() + Value.substring(1).toLowerCase());
	}
}
