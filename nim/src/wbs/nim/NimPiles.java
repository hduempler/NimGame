package wbs.nim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NimPiles implements Iterable<Integer>{
	
	private List<Integer> piles = new ArrayList<>();
	private static final int MAXCOUNT_PER_PILE = 10;
	private static final int MAXPILES = 4;

	@Override
	public Iterator<Integer> iterator() {
		return piles.iterator();
	}

	public NimPiles() {
	}

	public NimPiles(int... anzahl) {
		if (anzahl.length > MAXPILES) {
			throw new IllegalArgumentException("Haufenanzahl ist zu groß");
		}

		for (int anz : anzahl) {
			if (anz > MAXCOUNT_PER_PILE) {
				piles.clear();
				throw new IllegalArgumentException("Anzahl ist zu groß");
			}
			piles.add(anz);
		}
	}

	public int pileCount() {
		return piles.size();
	}

	public int tokenCount(int pileNumber) {
		validatePile(pileNumber);
		return piles.get(pileNumber);
	}
	private void validatePile(int pileNumber) {
		if (pileNumber < 0 || pileNumber >= piles.size()) {
			throw new IllegalArgumentException("Ungültige Haufennummer");
		}
	}

	@SuppressWarnings("unused")
	private void validateTokenCount(int pileNumber, int count) {
		validatePile(pileNumber);
		int tokensInPile = tokenCount(pileNumber);
		if (count > tokensInPile) {
			throw new IllegalArgumentException("Anzahl ist zu groß");
		} else if (count <= 0) {
			throw new IllegalArgumentException("Anzahl ist zu klein");
		}
	}

}
