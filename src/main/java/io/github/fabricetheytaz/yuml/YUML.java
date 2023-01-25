package io.github.fabricetheytaz.yuml;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class YUML extends API
	{
	/*
	private static final Parser PARSER = new Parser();

	public final byte[] draw(final Path path) throws IOException, YUMLException
		{
		return draw(PARSER.parse(path));
		}

	public final void draw(final Path path, final FailableConsumer<byte[], IOException> imageConsumer) throws IOException, YUMLException
		{
		throw new UnsupportedOperationException();
		}

	public final void draw(final Path path, final FailableConsumer<Meta, IOException> metaConsumer, final FailableConsumer<byte[], IOException> imageConsumer) throws IOException, YUMLException
		{
		throw new UnsupportedOperationException();
		}

	public final void draw(final Path yuml, final Path image) throws IOException, YUMLException
		{
		throw new UnsupportedOperationException();
		}

	public final byte[] draw(final Diagram diagram) throws IOException, YUMLException
		{
		return post(String.join(",", notNull(diagram).getLines()));
		}
	*/

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

	/*
	public final byte[] draw(final Path path, final Format format) throws IOException
		{
		return get(PARSER.parse(path), format);
		}

	public final void draw(final Path path, final Format format, final FailableConsumer<byte[], IOException> consumer) throws IOException
		{
		notNull(consumer).accept(draw(path, format));
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
