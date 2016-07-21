package wbs.nim;

// RETROANALYSE IS FUN
// 1. Schritt: ggf. ein Random-Feld zur Generierung von Zufallszahlen
// 2. Schritt: Konstruktor mit 2 int-Parametern implementieren
// 3. Schritt: ggf. Hilfsmethode zur binären Darstellung eines int mit 32 Stellen

public class NimDemo {
	public static void main(String[] args) {
//		Nim nim1 = new Nim(3, 8);
		UndoableNim nim2 = new UndoableNim(5, 10);
		while (nim2.isWinSituation()) {
			nim2 = new UndoableNim(5, 10);
		}
		// System.out.println(nim1);
		// System.out.println();

		System.out.println(nim2);
		System.out.println(nim2.isWinSituation() ? "Gewinnstellung\n"
				: "keine Gewinnstellung\n");
		// NimMove move = new NimMove(0,0);
		int player = 1;
		NimMove move;
		while (!nim2.isOver()) {
			if (player == 1) {
				move = nim2.randomMove();
			} else {
				move = nim2.randomMove();
			}
			System.out
					.println("Spieler " + player
							+ (nim2.isWinSituation() ? " (gewinnt)" : "")
							+ ": " + move);
			nim2.doMove(move);
			System.out.println();
			System.out.println(nim2);
			if(Math.random()>0.5) {
				nim2.undo();
				System.out.println();
				System.out.println("Zugrücknahme:\n" + nim2);
			} else {
			player = (player == 1) ? 2 : 1;
			}
		}
	}
}
