package com.rs.game.cityhandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.rs.Settings;
import com.rs.game.WorldObject;
import com.rs.game.item.Item;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;

public final class CityEventHandler {

    private static final Map<Integer, CityEvent> cityEvents = new HashMap<>();

    private static final Logger logger = Logger.getLogger(CityEventHandler.class.getCanonicalName());

    public static boolean registerCitys() {
        String path = Paths.get("").toAbsolutePath().normalize() + "/Avalon/src/com/rs/game/cityhandler/impl/";
        for (File file : Objects.requireNonNull(new File(path).listFiles())) {
            try {
				if (!((CityEvent) Class.forName("com.rs.game.cityhandler.impl."+ file.getName().replace(".java", "")).newInstance()).init()) {
				    return false;
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				//e.printStackTrace();
			}
        }
        logger.info("Loaded " + cityEvents.size() + " city events.");
        return true;
    }

    public static boolean reload() throws Throwable {
        cityEvents.clear();
        return registerCitys();
    }

    public static boolean handleNPCClick(Player player, NPC npc, int npcId) {
        CityEvent cityEvent = cityEvents.get(npcId);
        if (cityEvent == null)
            return false;
        return cityEvent.handleNPCClick(player, npc);
    }

    public static boolean handleNPCClick2(Player player, NPC npc, int npcId) {
        CityEvent cityEvent = cityEvents.get(npcId);
        if (cityEvent == null)
            return false;
        return cityEvent.handleNPCClick2(player, npc);
    }

    public static boolean handleNPCClick3(Player player, NPC npc, int npcId) {
        CityEvent cityEvent = cityEvents.get(npcId);
        if (cityEvent == null)
            return false;
        return cityEvent.handleNPCClick3(player, npc);
    }

    public static boolean handleNPCClick4(Player player, NPC npc, int npcId) {
        CityEvent cityEvent = cityEvents.get(npcId);
        if (cityEvent == null)
            return false;
        return cityEvent.handleNPCClick4(player, npc);
    }

    public static boolean handleObjectClick(Player player, WorldObject object, int objectId) {
        CityEvent cityEvent = cityEvents.get(objectId);
        if (cityEvent == null)
            return false;
        return cityEvent.handleObjectClick(player, object);
    }

    public static boolean handleObjectClick2(Player player,
    		WorldObject object, int objectId) {
        CityEvent cityEvent = cityEvents.get(objectId);
        if (cityEvent == null)
            return false;
        return cityEvent.handleObjectClick2(player, object);
    }

    public static boolean handleObjectClick3(Player player,
    		WorldObject object, int objectId) {
        CityEvent cityEvent = cityEvents.get(objectId);
        if (cityEvent == null)
            return false;
        return cityEvent.handleObjectClick3(player, object);
    }

    public static boolean handleObjectClick4(Player player,
    		WorldObject object, int objectId) {
        CityEvent cityEvent = cityEvents.get(objectId);
        if (cityEvent == null)
            return false;
        return cityEvent.handleObjectClick4(player, object);
    }

    public static boolean handleObjectClick5(Player player,
    		WorldObject object, int objectId) {
        CityEvent cityEvent = cityEvents.get(objectId);
        if (cityEvent == null)
            return false;
        return cityEvent.handleObjectClick5(player, object);
    }

    public static boolean registerNPCs(int npcId, CityEvent cityEvent) {
        if (cityEvents.containsKey(npcId)) {
            logger.info("City: " + cityEvent.getClass().getCanonicalName()
                    + " Id => " + npcId+ ", already registered with "
                    + cityEvents.get(npcId).getClass().getCanonicalName() + ".");
            return false;
        }
        cityEvents.put(npcId, cityEvent);
        return true;
    }

    public static boolean registerObjects(int objectId, CityEvent cityEvent) {
        if (cityEvents.containsKey(objectId)) {
            logger.info("City: " + cityEvent.getClass().getCanonicalName()
                    + " Id => " + objectId + " already registered with "
                    + cityEvents.get(objectId).getClass().getCanonicalName()
                    + ".");
            return false;
        }
        cityEvents.put(objectId, cityEvent);
        return true;
    }

	public static boolean handleItemOnObject(Player player, WorldObject object, Item item) {
		 CityEvent cityEvent = cityEvents.get(object.getId());
	        if (cityEvent == null)
	            return false;
	        return cityEvent.handleItemOnObject(player, object, item);
	}
}