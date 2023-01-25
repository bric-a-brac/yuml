package io.github.fabricetheytaz.yuml;

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
	public static final <T extends Enum<T>> T getOrDefault(final String name, final Class<T> classOfT, final T defaultValue)
		{
		try
			{
			// Rechercher avec son nom
			return Enum.valueOf(notNull(classOfT), notNull(name).toUpperCase());
			}
		catch (final IllegalArgumentException ex)
			{
			// Pas trouvé
			}

		// Rechercher avec toString()
		for (final T t : classOfT.getEnumConstants())
			{
			if (t.toString().equalsIgnoreCase(name))
				{
				return t;
				}
			}

		// Pas trouvé
		return defaultValue;
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
	}
