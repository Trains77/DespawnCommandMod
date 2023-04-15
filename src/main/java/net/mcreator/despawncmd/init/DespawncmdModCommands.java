
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.despawncmd.init;

import net.mcreator.despawncmd.command.DespawnCommand;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class DespawncmdModCommands {
	public static void load() {
		CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, dedicated) -> {
			DespawnCommand.register(dispatcher, commandBuildContext);
		});
	}
}
