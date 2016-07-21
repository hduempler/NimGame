package wbs.nim;

import java.util.Stack;

public class UndoableNim extends Nim {

	// bietet die Möglichkeit, Züge zurückzunehmen
	private Stack<NimMove> undoStack = new Stack<>();
	public UndoableNim(int rowCount, int maxTokenCount) {
		super(rowCount, maxTokenCount);
	}
	public Nim doMove(NimMove move) throws NimException {
		int row = move.getRow();
		int count = rows[row];
		Nim result = super.doMove(move);
		undoStack.add(new NimMove(row, count));
		return result;
	}

	public Nim undo() {
		// nimmt den letzten Zug zurück
		NimMove move = undoStack.pop();
		int row = move.getRow();
		int oldCount = rows[row];
		int newCount = move.getCount();

		if (oldCount == 0) {
			notEmptyRows++;
		}

		xorOverAllRows ^= oldCount;
		xorOverAllRows ^= newCount;

		rows[row] = newCount;
		return this;
	}

	public Nim undo(int nMoves) {
		// nimmt die letzten n Züge zurück
		if (nMoves > undoStack.size()) {
			throw new NimException("Illegal undo count");
		}
		for (int i = 0; i < nMoves; i++) {
			undo();
		}
		return this;
	}

	public Nim reset() {
		// stellt die Ausgangssituation wieder her
		while (!undoStack.empty()) {
			undo(undoStack.size());
		}
		return this;
	}
}
