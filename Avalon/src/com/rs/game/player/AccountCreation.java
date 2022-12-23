package com.rs.game.player;

import java.io.File;

import com.rs.Settings;
import com.rs.json.GSONParser;


/**
* @author -Andreas 27 jan. 2020
* 
*/

public class AccountCreation {

	public static Player loadPlayer(String username) {
		return (Player) GSONParser.load(Settings.DATA_PATH + "data/characters/" + username + ".json", Player.class);
	}

	public static void savePlayer(Player player) {
		GSONParser.save(player, Settings.DATA_PATH + "data/characters/" + player.getDisplayName() + ".json", Player.class);
	}

	public static boolean exists(String username) {
		return new File(Settings.DATA_PATH + "data/characters/" + username + ".json").exists();
	}

}
