package de.codeshelf.consoleui.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import jline.console.completer.Completer;

/**
 * User: Andreas Wegmann Date: 06.01.16
 */
public class InputValue extends AbstractPromptableElement {
	private String value;
	private String defaultValue;
	private List<Completer> completer;
	private Character mask;
	private Function<String, Object> validator;

	public InputValue(String name, String message) {
		super(message, name);
		this.value = null;
		this.defaultValue = null;
	}

	public InputValue(String name, String message, String value, String defaultValue) {
		super(message, name);
		// this.value = value;
		if (value != null)
			throw new IllegalStateException("pre filled values for InputValue are not supported at the moment.");
		this.defaultValue = defaultValue;
	}

	public String getValue() {
		return value;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public List<Completer> getCompleter() {
		return completer;
	}

	public void setCompleter(List<Completer> completer) {
		this.completer = completer;
	}

	public void addCompleter(Completer completer) {
		if (this.completer == null) {
			this.completer = new ArrayList<Completer>();
		}
		this.completer.add(completer);
	}

	public void setMask(Character mask) {
		this.mask = mask;
	}

	public Character getMask() {
		return mask;
	}

	public Function<String, Object> getValidator() {
		return validator;
	}

	public void setValidator(Function<String, Object> validator) {
		this.validator = validator;
	}

}
