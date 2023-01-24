package io.github.fabricetheytaz.yuml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import static io.github.fabricetheytaz.util.Argument.notNull;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class Util
	{
	/**
	 * @since 0.1.0
	 */
	public static final <T extends Enum<?>> T getOrDefault(final String name, final Class<T> classOfT, final T defaultValue)
		{
			notNull(classOfT);
		//	System.out.println(classOfT.getCanonicalName());
		throw new UnsupportedOperationException();
		}

	/*
	public static final Direction getOrDefault(final String name, final Direction defaultValue)
		{
		return getOrDefault(Direction.class, defaultValue);
		}

	public static final Type getOrDefault(final String name, final Type defaultValue)
		{
		return getOrDefault(Type.class, defaultValue);
		}
	*/

	/**
	 * @since 0.1.0
	 */
	public static final String readFromStandardInput() throws IOException
		{
		try (final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
			{
			try (final StringWriter writer = new StringWriter())
				{
				reader.transferTo(writer);

				return writer.toString();
				}
			}
		}
	}
