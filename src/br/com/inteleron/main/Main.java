package br.com.inteleron.main;

import static spark.Spark.*;

import br.com.inteleron.transformer.JsonTransformer;

public class Main {

	public static void main(String[] args) {
		port(Constants.PORT);

		filters();
		register();
	}

	private static void filters() {
		before("/protected/*", (request, response) -> {
			boolean authenticated = false;

			/*
			 * Implement validation
			 */
			
			if (!authenticated) {
				halt(401, "Sorry this method cam be used. Only by a official application");
			}
		});
	}

	private static void register() {
		get("/login", (request, response) -> {
			return "root";
		}, new JsonTransformer());
	}

}
