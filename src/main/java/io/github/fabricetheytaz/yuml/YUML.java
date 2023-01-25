package io.github.fabricetheytaz.yuml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.lang3.function.FailableConsumer;
import io.github.fabricetheytaz.yuml.client.Client;
import io.github.fabricetheytaz.yuml.client.Diagram;
import io.github.fabricetheytaz.yuml.client.Direction;
import io.github.fabricetheytaz.yuml.client.FileInput;
import io.github.fabricetheytaz.yuml.client.FileOutput;
import io.github.fabricetheytaz.yuml.client.Format;
import io.github.fabricetheytaz.yuml.client.StandardInput;
import io.github.fabricetheytaz.yuml.client.StandardOutput;
import io.github.fabricetheytaz.yuml.client.Style;
import io.github.fabricetheytaz.yuml.client.Type;

import static io.github.fabricetheytaz.util.Argument.notNull;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class YUML extends Client
	{
	private static final YUML INSTANCE = new YUML();

	/**
	 * @since 0.1.0
	 */
	public final void draw() throws IOException
		{
		draw(new StandardInput(), new StandardOutput());
		}

	/**
	 * @since 0.1.0
	 */
	public final void draw(final Path input, final Path output, final Format format) throws IOException
		{
		draw(new FileInput(input), new FileOutput(output), format);
		}

	/**
	 * @since 0.1.0
	 */
	public final void draw(final Path input, final Path output) throws IOException
		{
		draw(input, output, DEFAULT_FORMAT);
		}

	/**
	 * @since 0.1.0
	 */
	public final void draw(final File input, final File output) throws IOException
		{
		draw(new FileInput(input), new FileOutput(output));
		}

	/**
	 * @since 0.1.0
	 */
	public final void draw(final String input, final String output) throws IOException
		{
		draw(new FileInput(input), new FileOutput(output));
		}

	/**
	 * @since 0.1.0
	 */
	public final void draw(final Path input, final FailableConsumer<byte[], IOException> outputConsumer) throws IOException
		{
		draw(new FileInput(input), bytes -> outputConsumer.accept(bytes));
		}

	/**
	 * @since 0.1.0
	 */
	public final void draw(final File input, final FailableConsumer<byte[], IOException> outputConsumer) throws IOException
		{
		draw(new FileInput(input), bytes -> outputConsumer.accept(bytes));
		}

	/**
	 * @since 0.1.0
	 */
	public final void draw(final String input, final FailableConsumer<byte[], IOException> outputConsumer) throws IOException
		{
		draw(new FileInput(input), bytes -> outputConsumer.accept(bytes));
		}

	/**
	 * @since 0.1.0
	 */
	public static final byte[] draw(final Diagram diagram, final Type type, final Style style, final Direction direction, final Format format) throws IOException
		{
		//INSTANCE.draw(null, null);
		throw new UnsupportedOperationException();
		}

	/**
	 * @since 0.1.0
	 */
	public static final byte[] draw(final Diagram diagram, final Style style, final Direction direction, final Format format) throws IOException
		{
		notNull(diagram);

		return draw(diagram, diagram.getType(), style, direction, format);
		}

	/*

	public final byte[] draw(final Diagram diagram) throws IOException, YUMLException
		{
		return post(String.join(",", notNull(diagram).getLines()));
		}
	*/

	/*
	private static final byte[] get(final Diagram diagram, final Format format) throws IOException
		{
		notNull(diagram);
		notNull(format);

		Type type = diagram.getType();

		if (type == null)
			{
			//type = def
			}

		Style style = diagram.getStyle();

		if (style == null)
			{
			style = DEFAULT_STYLE;
			}

		final String dsl = URLEncoder.encode(String.join(",", diagram.getLines()), StandardCharsets.UTF_8);

		//final String url = "https://yuml.me/diagram/nofunky;scale:150/class/%s.svg";
		final String url = String.format(URL, Style.NOFUNKY.name().toLowerCase(),  Type.CLASS.name().toLowerCase(), dsl, format.name().toLowerCase());

		//return get(url);
		return null;
		}
	*/
	}
