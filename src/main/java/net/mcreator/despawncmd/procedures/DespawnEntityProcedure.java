package net.mcreator.despawncmd.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.despawncmd.DespawncmdMod;

import java.util.Map;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class DespawnEntityProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				DespawncmdMod.LOGGER.warn("Failed to load dependency arguments for procedure DespawnEntity!");
			return;
		}
		CommandContext<CommandSourceStack> arguments = (CommandContext<CommandSourceStack>) dependencies.get("arguments");
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "target")) {
				if (!entityiterator.level.isClientSide())
					entityiterator.discard();
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
