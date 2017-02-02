package de.codeshelf.consoleui;

import static org.fusesource.jansi.Ansi.ansi;

import java.io.IOException;
import java.util.HashMap;

import org.fusesource.jansi.AnsiConsole;

import de.codeshelf.consoleui.elements.ConfirmChoice;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.answer.Answer;
import de.codeshelf.consoleui.prompt.answer.ConfirmAnswer;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;
import jline.TerminalFactory;
import jline.console.completer.StringsCompleter;

/**
 * User: Andreas Wegmann Date: 29.11.15
 */
public class Basic5 {

	public static void main(String[] args) throws InterruptedException {
		AnsiConsole.systemInstall();
		System.out.println(ansi().eraseScreen().render("@|red,italic Hello|@ @|green World|@\n@|reset "
				+ "This is a demonstration of ConsoleUI java library. It provides a simple console interface\n"
				+ "for querying information from the user. ConsoleUI is inspired by Inquirer.js which is written\n" + "in JavaScrpt.|@"));

		try {
			ConsolePrompt prompt = new ConsolePrompt();
			PromptBuilder promptBuilder = prompt.getPromptBuilder();

			//// @formatter:off
			promptBuilder.inputPrompt("name")
	              .message(anwer -> "Digite o nome")
	              //.mask('*')
	              .addCompleter(new StringsCompleter("Jim", "Jack", "John"))
	              .build();
			// @formatter:on

			//// @formatter:off
		    promptBuilder.listPrompt("pizzatype")
	              .message(anwers -> "Escolha a pizza "+anwers.get("name").value())
	              .choices("Margherita", "Veneziana", "Hawai", "Quattro Stagioni")
	              .build();
		    // @formatter:on

		    //// @formatter:off
            promptBuilder.checkboxPrompt("topping")
	              .message(answers -> "Please select additional toppings: "+answers.get("pizzatype").value())
	              .choices("Cheese", "Bacon", "Açai")
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
