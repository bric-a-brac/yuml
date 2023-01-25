package io.github.fabricetheytaz.yuml;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.github.fabricetheytaz.yuml.client.Direction;
import io.github.fabricetheytaz.yuml.client.Format;
import io.github.fabricetheytaz.yuml.client.Style;
import io.github.fabricetheytaz.yuml.client.exceptions.YUMLException;

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
		yuml.draw(testYuml, testPng, Format.PNG);

		final ClassDiagram classDiagram = new ClassDiagram();

		YUML.draw(classDiagram, null, null, null, null);

		YUML.draw(classDiagram, null, Style.SCRUFFY, Direction.TOP_DOWN, Format.PDF);

		YUML.draw(classDiagram, Style.SCRUFFY, Direction.TOP_DOWN, Format.PDF);

		final ClassDiagram diagram = new ClassDiagram();

		diagram.setStyle(Style.SCRUFFY);
		//diagram.setType(null);

		//YUML.draw(diagram);
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
