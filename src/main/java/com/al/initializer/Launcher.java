package com.al.initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {
	private static final Logger logger = LoggerFactory.getLogger(Launcher.class);
	private static final int DEFAULT_PORT = 8000;

	public static void main(String[] args) {
		try {
			new Launcher().start(getPortFromArgs(args));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int getPortFromArgs(String[] args) {
		if (args.length > 0) {
			try {
				return Integer.valueOf(args[0]);
			} catch (NumberFormatException ignore) {
				ignore.printStackTrace();
			}
		}
		logger.info("No server port configured, falling back to default port: {}", DEFAULT_PORT);
		return DEFAULT_PORT;
	}

	public void start(int port) throws Exception {
		logger.debug("Starting server at port {}", port);
		JettyServer jServer = new JettyServer(port);
		jServer.start();
		logger.info("Server started at port {}", port);
		jServer.join();
	}
}
