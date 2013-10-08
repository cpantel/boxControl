package model;

public class Verifier {
	public static String verify(String code, boolean b) {
		if (!b ) {
			return "NO ACCESS";
		}
		return "HASH: " + code;
	}
}
