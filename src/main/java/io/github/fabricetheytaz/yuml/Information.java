package io.github.fabricetheytaz.yuml;

public final class Information
	{
	private String digest;
	private String type;
	private String dsl;
	public String customisations;

	public String getDigest()
		{
		return digest;
		}

	public String getType()
		{
		return type;
		}

	public String getDSL()
		{
		return dsl;
		}
	}

/*

{
-"customisations": "scruffy",
-"type": "class",
-"dsl": "[Curl]->[Example]-.-[Nice{bg:wheat}]",
- "digest": "e3c59524",
"file_only": false,
"mime": "image/svg+xml",
"extension": "svg"
}

*/