package de.codeshelf.consoleui.prompt.builder;

import de.codeshelf.consoleui.elements.*;

import java.util.ArrayList;
import java.util.List;

/**
 * PromptBuilder is the builder class which creates
 *
 * Created by Andreas Wegmann on 20.01.16.
 */
public class PromptBuilder {
	List<PromptableElementIF> promptList = new ArrayList<PromptableElementIF>();

	public List<PromptableElementIF> build() {
		return promptList;
	}

	public void addPrompt(PromptableElementIF promptableElement) {
		promptList.add(promptableElement);
	}

	public InputValueBuilder inputPrompt(String name) {
		return new InputValueBuilder(this, name);
	}

	public ListPromptBuilder listPrompt(String name) {
		return new ListPromptBuilder(this, name);
	}
	
	/*
	public ExpandableChoicePromptBuilder createChoicePrompt() {
		return new ExpandableChoicePromptBuilder(this);
	}*/

	public CheckboxPromptBuilder checkboxPrompt(String name) {
		return new CheckboxPromptBuilder(this, name);
	}

	public ConfirmPromptBuilder confirmPrompt() {
		return new ConfirmPromptBuilder(this);
	}
}
