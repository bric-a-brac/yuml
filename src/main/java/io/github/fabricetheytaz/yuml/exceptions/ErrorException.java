package io.github.fabricetheytaz.yuml.exceptions;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public final class ErrorException extends YUMLException
	{
	/**
	 * @since 0.1.0
	 */
	public ErrorException()
		{
		super();
		}

	/**
	 * @since 0.1.0
	 */
	public ErrorException(final Throwable throwable)
		{
		super(throwable);
		}
	}
