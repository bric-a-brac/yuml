package io.github.fabricetheytaz.yuml;

import java.util.ArrayList;
import java.util.List;

import static io.github.fabricetheytaz.util.Argument.notNull;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class Diagram
	{
	protected final List<String> lines;

	protected Type type;
	protected Style style;

	public Diagram(final List<String> lines)
		{
		super();

		this.lines = notNull(lines);
		}

	public Diagram()
		{
		this(new ArrayList<>());
		}

	/**
	 * @since 0.1.0
	 */
	public final List<String> getLines()
		{
		return lines;
		}

	/**
	 * @since 0.1.0
	 */
	public final Type getType()
		{
		return type;
		}

	/**
	 * @since 0.1.0
	 */
	public final void setType(final Type type)
		{
		this.type = type;
		}

	/**
	 * @since 0.1.0
	 */
	public final Style getStyle()
		{
		return style;
		}

	/**
	 * @since 0.1.0
	 */
	public final void setStyle(final Style style)
		{
		this.style = style;
		}
	}
