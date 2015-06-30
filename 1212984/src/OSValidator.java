
public class OSValidator {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static String detectOS() {

		System.out.println(OS);

		if (isWindows()) {
			System.out.println("This is Windows");
			return "Windows";
		} else if (isMac()) {
			System.out.println("This is Mac");
			return "Mac";
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
			return "Linux";
		} else if (isSolaris()) {
			System.out.println("This is Solaris");
			return "Solaris";
		} else {
			System.out.println("Your OS is not support!!");
			return "Could not detect OS";
		}
	}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}

}