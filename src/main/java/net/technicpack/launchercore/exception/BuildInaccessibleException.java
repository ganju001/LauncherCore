package net.technicpack.launchercore.exception;

import java.io.IOException;

public class BuildInaccessibleException extends IOException {
	private String packDisplayName;
	private String build;
	private Throwable cause;

	public BuildInaccessibleException(String displayName, String build) {
		this.packDisplayName = displayName;
		this.build = build;
	}

	public BuildInaccessibleException(String displayName, String build, Throwable cause) {
		this(displayName, build);
		this.cause = cause;
	}

	@Override
	public String getMessage() {
		if (this.cause == null) {
			return "An error was raised while attempting to read pack info for modpack "+packDisplayName+", build "+build+".  Try again in a few minutes, or contact the pack host if the problem persists.";
		} else {
			return "The pack host returned unrecognizable garbage while attempting to read pack info for modpack "+packDisplayName+", build "+build+".";
		}
	}

	@Override
	public Throwable getCause() {
		return cause;
	}
}
