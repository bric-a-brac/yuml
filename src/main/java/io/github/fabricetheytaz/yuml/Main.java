package io.github.fabricetheytaz.yuml;

import java.io.IOException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import io.github.fabricetheytaz.yuml.client.FileInput;
import io.github.fabricetheytaz.yuml.client.FileOutput;
import io.github.fabricetheytaz.yuml.client.Format;
import io.github.fabricetheytaz.yuml.client.Input;
import io.github.fabricetheytaz.yuml.client.Output;
import io.github.fabricetheytaz.yuml.client.StandardInput;
import io.github.fabricetheytaz.yuml.client.StandardOutput;

public final class Main
	{
	private Main()
		{
		throw new UnsupportedOperationException();
		}

	public static void main(final String[] args)
		{
		// yuml --input test.yuml --output = test.png --type class --format png
		// yuml -i test.yuml -o = test.png --png
		// cat test.yuml | yuml --png > test.png
		// yuml - --png

		final Options options = new Options();

		final Option inputOption = new Option("i", "input", true, "YUML input file");
		//inputOption.setRequired(true);

		final Option outputOption = new Option("o", "output", true, "Diagram image output file");

		final Option formatOption = new Option("f", "format", true, "Output image format");

		options.addOption(inputOption);
		options.addOption(outputOption);
		options.addOption(formatOption);

		//options.addOption("jpg", false, "JPEG");
		//options.addOption("jpeg", false, "JPEG");
		//options.addOption("png", false, "PNG");
		//options.addOption("svg", false, "SVG");

		try
			{
			final CommandLine arguments = new DefaultParser().parse(options, args);

			final String inputArgument = arguments.getOptionValue(inputOption, "-");
			final String outputArgument = arguments.getOptionValue(outputOption, "-");
			final String formatArgument = arguments.getOptionValue(formatOption, "svg");

			Input input;

			if (inputArgument.equals("-"))
				{
				input = new StandardInput();
				}
			else
				{
				input = new FileInput(inputArgument);
				}

			Output output;

			if (outputArgument.equals("-"))
				{
				output = new StandardOutput();
				}
			else
				{
				output = new FileOutput(outputArgument);
				}

			final Format format = Format.valueOf(formatArgument.toUpperCase());

			final YUML yuml = new YUML();

			yuml.draw(input, output, format);
			}
		catch (final ParseException | IOException ex)
			{
			ex.printStackTrace();
			}
		}
	}
