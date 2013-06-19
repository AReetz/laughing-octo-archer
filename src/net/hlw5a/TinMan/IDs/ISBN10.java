package net.hlw5a.TinMan.IDs;

public class ISBN10 extends ISBN {
	
    public ISBN10(String Number) throws Exception {
        if (Number.length() != 10) throw new Exception("Invalid ISBN length.");
        Integer control = 0;
        for (int i = 0; i < 9; i++) control += (Integer.getInteger(Number.substring(i, 1)) * (10 - i));
        control %= 11;
        if (Number.substring(9, 1) != ((control == 0) ? "0" : (control == 1) ? "X" : (11 - control))) throw new Exception("Invalid ISBN check digit.");
        this.isbn = Number;
    }
}
