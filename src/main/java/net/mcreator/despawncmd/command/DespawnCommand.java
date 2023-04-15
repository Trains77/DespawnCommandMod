
package net.mcreator.despawncmd.command;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandBuildContext;

import net.mcreator.despawncmd.procedures.DespawnEntityProcedure;

import com.mojang.brigadier.CommandDispatcher;

public class DespawnCommand {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext commandBuildContext) {
		dispatcher.register(Commands.literal("despawn").requires(s -> s.hasPermission(3)).then(Commands.argument("target", EntityArgument.entities()).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			Direction direction = entity.getDirection();

			DespawnEntityProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("arguments", arguments).build());
			return 0;
		})));
	}
}
