package xxx.joker.apps.tagmod.console.main;

import xxx.joker.apps.tagmod.console.args.TmcArgType;
import xxx.joker.apps.tagmod.console.args.TmcArgs;
import xxx.joker.apps.tagmod.console.args.TmcCmd;
import xxx.joker.apps.tagmod.console.common.TmcConfig;
import xxx.joker.libs.argsparser.InputParserImpl;
import xxx.joker.libs.argsparser.exception.InputParserException;
import xxx.joker.libs.argsparser.exception.InputValueException;
import xxx.joker.libs.javalibs.utils.JkFiles;
import xxx.joker.libs.javalibs.utils.JkStreams;
import xxx.joker.libs.javalibs.utils.JkStrings;

import java.util.Arrays;

import static xxx.joker.libs.javalibs.utils.JkConsole.display;

public class TmcMain {

	public static void main(String[] args) {

		try {
			// Parse console input
			TmcArgs tmArgs = new TmcArgs();
			InputParserImpl parser = new InputParserImpl(tmArgs, TmcArgType.class, TmcCmd.class, JkFiles.getLauncherPath(TmcMain.class));
			parser.parse(args);

			// Execute command
			TmcEngine.execute(tmArgs);

		} catch (Exception e) {
			display(e.getMessage());
			display("User input:  tagmod %s", JkStreams.join(Arrays.asList(args), " ", s -> s.contains(" ") ? "\""+s+"\"" : s));
			display("Test cmd -> [%s]", JkStreams.join(Arrays.asList(args), ";"));
			System.exit(1);
		}
	}
}
