package net.juhewe.julianskitchen;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;

public class ModServerTickListener {

    public static ServerWorld currentServerWorld;

    public static void registerModServerTickListener() {
        ServerTickEvents.StartWorldTick listener = new ServerTickEvents.StartWorldTick() {
            @Override
            public void onStartTick(ServerWorld serverWorld) {
                registerServerWorld(serverWorld);
            }
        };
        ServerTickEvents.START_WORLD_TICK.register(listener);
    }

    private static void registerServerWorld(ServerWorld world){
        if(world != null &&( currentServerWorld == null || !currentServerWorld.equals(world))){
            currentServerWorld = world;
        }
    }

}