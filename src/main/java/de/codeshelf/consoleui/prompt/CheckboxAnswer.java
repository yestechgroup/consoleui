package de.codeshelf.consoleui.prompt;

import java.util.HashSet;

/**
 * Result of a checkbox choice. CheckboxResult contains a {@link java.util.Set}
 * with the IDs of the selected checkbox items.
 * <p>
 * User: Andreas Wegmann Date: 03.02.16
 */
public class CheckboxAnswer implements Answer {
	HashSet<String> selectedIds;

	/**
	 * Default Constructor.
	 * 
	 * @param selectedIds
	 *            Selected IDs.
	 */
	public CheckboxAnswer(HashSet<String> selectedIds) {
		this.selectedIds = selectedIds;
	}

	/**
	 * Returns the set with the IDs of selected checkbox items.
	 *
	 * @return set with IDs
	 */
	public HashSet<String> getSelectedIds() {
		return selectedIds;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public HashSet<String> getList() {
		return this.selectedIds;
	}

	@Override
	public String toString() {
		return "CheckboxResult{" + "selectedIds=" + selectedIds + '}';
	}

}
