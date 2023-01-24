package io.github.fabricetheytaz.yuml;

import java.io.IOException;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class Diagram
	{
	protected Type type;
	protected Style style;

	//public List<String> x;

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

	/**
	 * @since 0.1.0
	 */
	public final byte[] draw(final Format format) throws IOException
		{
		return YUML.draw(this, format);
		}
	}
