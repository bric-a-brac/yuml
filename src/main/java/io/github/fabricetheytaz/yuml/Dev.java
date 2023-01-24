package io.github.fabricetheytaz.yuml;

import java.io.IOException;

import io.github.fabricetheytaz.yuml.exceptions.YUMLException;

public class Dev
	{
	public static void devNotFound() throws Exception
		{
		//final Information information = new YUML().getInformation("e3c59524"); // OK
		//final Information information = new YUML().getInformation("e3c59524aaa"); // OK 404
		final Information information = new YUML().getInformation(""); // OK 404

		//System.out.println(information.getType());
		}

	public static void main(String[] args)
		{
		//final String dsl = "[Application]->[AbstractApplication],[ConsoleApplication]->[Application],[WebSite]->[Application]";
		//Util.getOrDefault("sdsd", Direction.class, DEFAULT_DIRECTION);
		//Util.getOrDefault("sdsd", Style.class, DEFAULT_STYLE);

		/*
		final Path input = Paths.get(".", "test.yuml");
		final Path output = Paths.get(".", "test.png");

		YUML.draw(input, Format.PNG, bytes ->
			{
			System.out.println(bytes.length);
			//Files.write(output, bytes);
			});
		*/

		try
			{
			devNotFound();
			}
		catch (final IOException ex)
			{
			System.out.println("IO: " + ex.getMessage());
			}
		catch (final YUMLException ex)
			{
			System.out.println("yUML: " + ex.getMessage());
			}
		catch (final Exception ex)
			{
			ex.printStackTrace();
			}
		}
	}
