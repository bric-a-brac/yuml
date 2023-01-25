package io.github.fabricetheytaz.yuml;

public class API
	{
	//private static final Gson GSON = new Gson();

	/*
	//private static final String URL = "https://yuml.me/diagram/%s/%s/%s.%s";
	private static final String URL = "https://yuml.me/";
	private static final String META_URL = "https://yuml.me/%s.json";
	private static final String POST_URL = "https://yuml.me/diagram/scruffy/class/";
	private static final String INPUT_NAME = "dsl_text";
	*/

	//private static final String JSON = "json";
	// final FailableConsumer<byte[], IOException> consumer

	/*
	public final Meta getMeta(final String digest) throws IOException, YUMLException
		{
		final String url = String.format(META_URL, notNull(digest));

		return parseMeta(execute(Request.Get(url)).asString());
		}
	*/

	/*
	protected final byte[] post(final String dsl) throws IOException, YUMLException
		{
		final Request request = Request.Post(POST_URL).bodyForm(new BasicNameValuePair(INPUT_NAME, notNull(dsl)));

		// FIXME: Format comment ??? pas toujours .svg ???
		final String filename = execute(request).asString();

		return getImage(URL + filename);

		//	curl -X POST -d "dsl_text=[Curl]->[Example]-.-[Nice{bg:wheat}]" https://yuml.me/diagram/scruffy/class/ 
		String response = Request.Post("https://yuml.me/diagram/scruffy/class/").userAgent(USER_AGENT)
			.bodyForm(new BasicNameValuePair("dsl_text", "[Curl]->[Example]-.-[Nice{bg:wheat}]"))
			.execute().returnContent().asString();

		//https://yuml.me/e3c59524.json

		System.out.println(response);
		}
	*/

	/*
	protected final Meta parseMeta(final String json) throws ErrorException
		{
		try
			{
			return GSON.fromJson(notNull(json), Meta.class);
			}
		catch (final JsonSyntaxException ex)
			{
			throw new ErrorException(ex);
			}
		}
	*/
	}
