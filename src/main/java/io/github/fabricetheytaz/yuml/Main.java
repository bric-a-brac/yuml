package io.github.fabricetheytaz.yuml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import io.github.fabricetheytaz.yuml.exceptions.YUMLException;

public final class Main
	{
	private Main()
		{
		throw new UnsupportedOperationException();
		}

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
	}
