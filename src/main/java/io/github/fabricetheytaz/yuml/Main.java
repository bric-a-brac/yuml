package io.github.fabricetheytaz.yuml;

import java.io.IOException;

import io.github.fabricetheytaz.yuml.client.Client;
import io.github.fabricetheytaz.yuml.client.StandardInput;
import io.github.fabricetheytaz.yuml.client.StandardOutput;

public final class Main
	{
	private Main()
		{
		throw new UnsupportedOperationException();
		}

	public static void main(String[] args)
		{
		// yuml --input test.yuml --output = test.png --type class --format png
		// yuml -i test.yuml -o = test.png --png
		// cat test.yuml | yuml --png > test.png

		// Essai stdin/stdout
		final Client client = new Client();

		try
			{
			client.draw(new StandardInput(), new StandardOutput());
			}
		catch (final IOException ex)
			{
			System.err.println(ex.getMessage());
			}
		}

	/*
	public static void main(final String[] args)
		{
		// yuml --input=test.yuml --output=test.png --format=png
		// yuml --input=test.yuml --output=test.png -f png
		// yuml --input=test.yuml --output=test.png --png

		// yuml - --png

		final Options options = new Options();

		final Option inputOption = new Option("i", "input", true, "YUML input file");

		inputOption.setRequired(true);

		options.addOption(inputOption);

		//options.addOption("jpg", false, "JPEG");
		//options.addOption("jpeg", false, "JPEG");
		//options.addOption("png", false, "PNG");
		//options.addOption("svg", false, "SVG");

		try
			{
			final CommandLine command = new DefaultParser().parse(options, args);

			final String input = command.getParsedOptionValue(inputOption).toString();
			System.out.println(input);

			Information info = YUML.draw("DSL / Path");
			Diagram diagram = YUML.getDiagram(info);

			YUML.draw(Paths.get("test.yuml"), Format.PNG, bytes ->
				{
				Files.write(Paths.get("test.png"), bytes);
				});
			}
		catch (final ParseException ex)
			{
			ex.printStackTrace();
			}
		catch (final YUMLException ex)
			{
			System.err.println(ex.getMessage());
			}
		catch (final IOException ex)
			{
			ex.printStackTrace();
			}
		}
	*/
	}
