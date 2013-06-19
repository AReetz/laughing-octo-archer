package net.hlw5a.TinMan.IDs;

public class ISBN13 extends ISBN {

    public ISBN13(String Number) throws Exception {
        if (Number.length() != 13) throw new Exception("Invalid ISBN length.");
        Integer control = 0;
        for (int i = 0; i < 12; i++) control += (Integer.getInteger(Number.substring(i, 1)) * ((i % 2 == 0) ? 1 : 3));
        control %= 10;
        if (Number.substring(12, 1) != ((control == 0) ? "0" : (control == 1) ? "X" : (10 - control))) throw new Exception("Invalid ISBN check digit.");
        this.isbn = Number;
    }
}
