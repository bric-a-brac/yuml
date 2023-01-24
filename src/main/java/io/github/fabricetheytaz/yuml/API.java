package io.github.fabricetheytaz.yuml;

import java.io.IOException;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import com.google.gson.Gson;
import io.github.fabricetheytaz.yuml.exceptions.ErrorException;
import io.github.fabricetheytaz.yuml.exceptions.NotFoundException;
import io.github.fabricetheytaz.yuml.exceptions.YUMLException;

import static io.github.fabricetheytaz.util.Argument.notNull;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class API
	{
	private static final Gson GSON = new Gson();

	private static final String USER_AGENT = "Bric-à-Brac yUML/0.1.0 (https://github.com/bric-a-brac/yuml)";

	private static final String URL = "https://yuml.me/diagram/%s/%s/%s.%s";

	private static final String INFORMATION_URL = "https://yuml.me/%s.json";

	private static final String INPUT_NAME = "dsl_text";

	/**
	 * @throws IOException
	 * @throws YUMLException
	 * 
	 * @since 0.1.0
	 */
	public final Information getInformation(final String digest) throws IOException, YUMLException
		{
		final String url = String.format(INFORMATION_URL, notNull(digest));

		final String json = execute(Request.Get(url)).asString();

		return GSON.fromJson(json, Information.class);
		}

	/*
	protected static final void getString(final FailableConsumer<String, IOException> consumer) throws IOException
		{
		}

	protected static final void getBytes(final FailableConsumer<byte[], IOException> consumer) throws IOException
		{
		}
	*/

	/**
	 * @since 0.1.0
	 */
	protected final void post(final String dsl, final FailableConsumer<byte[], IOException> consumer) throws IOException
		{
		final Request request = Request.Post("").bodyForm(new BasicNameValuePair(INPUT_NAME, notNull(dsl)));

		final String json = execute(request).asString();

		notNull(consumer).accept(execute(request).asBytes());

		//post("dsdd", bytes -> {});

		//	curl -X POST -d "dsl_text=[Curl]->[Example]-.-[Nice{bg:wheat}]" https://yuml.me/diagram/scruffy/class/ 
		/*
		String response = Request.Post("https://yuml.me/diagram/scruffy/class/").userAgent(USER_AGENT)
			.bodyForm(new BasicNameValuePair("dsl_text", "[Curl]->[Example]-.-[Nice{bg:wheat}]"))
			.execute().returnContent().asString();

		//https://yuml.me/e3c59524.json

		System.out.println(response);
		*/
		}

	/*
	protected final void put(final FailableConsumer<byte[], IOException> consumer) throws IOException
		{
		}
	*/

	/**
	 * Exécute une requête vers yUML. Ajoute simplement User-Agent et gère (huuummmm) réponse 500.
	 * 
	 * @throws IOException
	 * @throws YUMLException
	 * 
	 * @since 0.1.0
	 */
	private final Content execute(final Request request) throws IOException, YUMLException
		{
		try
			{
			return notNull(request).userAgent(USER_AGENT).execute().returnContent();
			}
		catch (final HttpResponseException ex)
			{
			final int code = ex.getStatusCode();

			switch (code)
				{
				case HttpStatus.SC_NOT_FOUND:
					throw new NotFoundException(ex);
				case HttpStatus.SC_INTERNAL_SERVER_ERROR:
					throw new ErrorException(ex);
				}

			throw ex;
			}
		}
	}
