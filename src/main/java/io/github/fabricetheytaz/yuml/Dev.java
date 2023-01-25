package io.github.fabricetheytaz.yuml;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.github.fabricetheytaz.yuml.client.exceptions.YUMLException;

//@SuppressWarnings("unused")
public class Dev
	{
	public static final YUML yuml = new YUML();

	public static final String DSL_ONE_LINE = "[Curl]->[Example]-.-[Nice{bg:wheat}]";

	// Fail 500
	//public static final String DSL_TWO_LINES = "[Curl]->[Example]-.-[Nice{bg:wheat}]\n[YUML]^[API]";
	// Même pour POST il faut joindre avec , ça ne fonctionne pas avec \n
	//final byte[] bytes = yuml.draw(DSL_TWO_LINES);
	// OK
	public static final String DSL_TWO_LINES = "[Curl]->[Example]-.-[Nice{bg:wheat}],[YUML]^[API]";

	public static final Path testYuml = Paths.get(".", "tests", "test.yuml");
	public static final Path testPng = Paths.get(".", "tests", "test.png");
	public static final Path testSvg = Paths.get(".", "tests", "test.svg");

	public static void devDraw() throws Exception
		{
		//final byte[] bytes = yuml.draw(testYuml);
		//Files.write(testSvg, bytes);

		//yuml.draw(testYuml, bytes -> Files.write(testSvg, bytes));
		//yuml.draw(testYuml, meta -> System.out.println(meta.getDigest()), bytes -> Files.write(testSvg, bytes));
		//yuml.draw(testYuml, testSvg);

		//final Client client = new Client();
		//client.draw(null, null);
		//client.draw(new FileInput(null), new FileOutput(null));
		//client.draw(new StandardInput(), new StandardOutput());
		}

	/*
	public static void devEnum() throws Exception
		{
		final Direction nullDirection = Util.getOrDefault("sdd", Direction.class, null);
		System.out.println(nullDirection);

		final Direction defaultDirection = Util.getOrDefault("sdd", Direction.class, Direction.TOP_DOWN);
		System.out.println(defaultDirection);

		final Direction topDownDirectionName = Util.getOrDefault("TOP_DOWN", Direction.class, null);
		System.out.println(topDownDirectionName);

		final Direction topDownDirectionToString = Util.getOrDefault("topDown", Direction.class, null);
		System.out.println(topDownDirectionToString);
		}
	*/

	public static void dev()
		{
		try
			{
			//devNotFound();
			devDraw();
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

	public static void main(String[] args)
		{
		dev();
		}
	}
