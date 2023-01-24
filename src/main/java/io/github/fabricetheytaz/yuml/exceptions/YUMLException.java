package io.github.fabricetheytaz.yuml.exceptions;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class YUMLException extends Exception
	{
	/**
	 * @since 0.1.0
	 */
	public YUMLException()
		{
		super();
		}

	/**
	 * @since 0.1.0
	 */
	public YUMLException(final Throwable throwable)
		{
		super(throwable);
		}
	}
