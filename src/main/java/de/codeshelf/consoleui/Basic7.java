package de.codeshelf.consoleui;

import static org.fusesource.jansi.Ansi.ansi;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.fusesource.jansi.AnsiConsole;

import de.codeshelf.consoleui.elements.ConfirmChoice;
import de.codeshelf.consoleui.prompt.Answer;
import de.codeshelf.consoleui.prompt.ConfirmAnswer;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;
import jline.TerminalFactory;
import jline.console.completer.StringsCompleter;

/**
 * User: Andreas Wegmann Date: 29.11.15
 */
public class Basic7 {

	public static void main(String[] args) throws InterruptedException {
		AnsiConsole.systemInstall();
		System.out.println(ansi().eraseScreen().render("@|red,italic Hello|@ @|green World|@\n@|reset "
				+ "This is a demonstration of ConsoleUI java library. It provides a simple console interface\n"
				+ "for querying information from the user. ConsoleUI is inspired by Inquirer.js which is written\n" + "in JavaScrpt.|@"));

		try {
			ConsolePrompt prompt = new ConsolePrompt();
			PromptBuilder promptBuilder = prompt.getPromptBuilder();

			//// @formatter:off
			promptBuilder.createInputPrompt()
	              .name("name")
	              .message(anwer -> "Digite o nome")
	              //.mask('*')
	              .addCompleter(new StringsCompleter("Jim", "Jack", "John"))
	              .build();
			// @formatter:on

			//// @formatter:off
		    promptBuilder.createListPrompt()
	              .name("pizzatype")
	              .message(anwers -> "Escolha a pizza "+anwers.get("name").value())
	              .choices("Cheese", "Bacon", "Açai")
 	              .build();
		    // @formatter:on

		    //// @formatter:off
            promptBuilder.createCheckboxPrompt()
            
	              .name("topping")
	              .message(answers -> "Please select additional toppings: "+answers.get("pizzatype").value())
	              .choices(anwers -> new HashSet<>(Arrays.asList("A", "B", "C")))
	              .build();
	         // @formatter:on


			HashMap<String, ? extends Answer> result = prompt.prompt(promptBuilder.build());
			System.out.println("result = " + result);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				TerminalFactory.get().restore();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}