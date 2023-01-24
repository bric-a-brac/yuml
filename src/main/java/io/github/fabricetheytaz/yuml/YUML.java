package io.github.fabricetheytaz.yuml;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicNameValuePair;

import static io.github.fabricetheytaz.util.Argument.notNull;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class YUML extends API
	{
	public static final Direction DEFAULT_DIRECTION = Direction.LEFT_TO_RIGHT;
	public static final Style DEFAULT_STYLE = Style.SCRUFFY;

	//private static final String URL = "https://yuml.me/diagram";
	//private static final String FORMAT = "%s/%s/%s/%s.%s";
	private static final String URL = "https://yuml.me/diagram/%s/%s/%s.%s";

	private static final Parser PARSER = new Parser();

	/*
	public static final byte[] draw(final Diagram diagram, final Format format)
		{
		throw new UnsupportedOperationException();
		}

	public static final byte[] draw(final Diagram diagram, final Style style, final Format format)
		{
		throw new UnsupportedOperationException();
		}
	*/

	/**
	 * @since 0.1.0
	 */
	public static final byte[] draw(final Path path, final Format format) throws IOException
		{
		return get(PARSER.parse(path), format);
		}

	/**
	 * @since 0.1.0
	 */
	public static final void draw(final Path path, final Format format, final FailableConsumer<byte[], IOException> consumer) throws IOException
		{
		notNull(consumer).accept(draw(path, format));
		}

	public static final void post() throws IOException
		{
		
		}

	/**
	 * @since 0.1.0
	 */
	private static final byte[] get(final Diagram diagram, final Format format) throws IOException
		{
		notNull(diagram);
		notNull(format);

		/*
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
		*/

		final String dsl = URLEncoder.encode(String.join(",", diagram.getLines()), StandardCharsets.UTF_8);

		//final String url = "https://yuml.me/diagram/nofunky;scale:150/class/%s.svg";
		final String url = String.format(URL, Style.NOFUNKY.name().toLowerCase(),  Type.CLASS.name().toLowerCase(), dsl, format.name().toLowerCase());

		//return get(url);
		return null;
		}
	}
