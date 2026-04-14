package net.juhewe.julianskitchen;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

public class ModServerTickListener {

    public static ServerLevel currentServerWorld;

    public static void registerModServerTickListener() {
        ServerTickEvents.StartTick listener = new ServerTickEvents.StartTick() {
            @Override
            public void onStartTick(MinecraftServer minecraftServer) {
                registerServerWorld(minecraftServer);
            }

        };
        ServerTickEvents.START_SERVER_TICK.register(listener);
    }

    private static void registerServerWorld(MinecraftServer minecraftServer){
        if(minecraftServer != null &&( currentServerWorld == null || !currentServerWorld.equals(minecraftServer))){
            currentServerWorld = minecraftServer.getLevel(((ResourceKey<Level>)minecraftServer.levelKeys().toArray()[0]));
        }
    }

}