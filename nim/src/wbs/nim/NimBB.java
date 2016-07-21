package wbs.nim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NimBB {

	private static final int MAX_TOKENS_PER_ROW = 10;
	private static final int MAXROWS = 5;
	private static Random RND = new Random();

	List<Integer> rows = new ArrayList<>();

	NimBB() {
		int rowcount = RND.nextInt(MAXROWS - 1) + 2;
		for (int i = 2; i <= rowcount; i++) {
			rows.add(RND.nextInt(MAX_TOKENS_PER_ROW) + 1);
		}
	}

	NimMove suggestMove() throws NimException {
		NimMove move = null;
		return move;
	}

	NimBB doMove(NimMove move) throws NimException {
		if (isOver()) {
			throw new NimException("Game is over");
		} else if (!isLegalMove(move)) {
			throw new NimException("Illegal move");
		}
		int row = move.getRow();
		int count = move.getCount();
		int aktCount = rows.get(row - 1);
		if (count == aktCount) {
			rows.remove(row - 1);
		} else {
			rows.set(row - 1, aktCount - count);
		}

		return this;
	}

	boolean isOver() {
		if (rows.size() > 0)
			return false;
		else
			return true;
	}

	boolean isLegalMove(NimMove move) {
		int row = move.getRow();
		int count = move.getCount();
		if (row < 0 || row >= rows.size()) {
			return false;
		} else {
			int cnt = rows.get(row);
			if (cnt <= 0 || cnt > count) {
				return false;
			}
		}
		return true;
	}

	boolean isWinSituation() {
		return false;
	}

}
