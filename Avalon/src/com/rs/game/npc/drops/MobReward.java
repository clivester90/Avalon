package com.rs.game.npc.drops;

import com.rs.game.item.Item;
import com.rs.utils.Utils;

/**
 * Contains the reward to be generated by the {@link MobRewardGenerator}.
 *
 * @author Ady | Scratch attempt adhering Apollo - github.com/apollo-rsps/apollo/
 * @version 1.0
 * @since 10/07/2018
 */
public final class MobReward {
	
	/**
	 * The item id;
	 */
	private final int id;
	
	/**
	 * The min amount of the reward.
	 */
	private final int min;
	
	/**
	 * The max amount of the reward.
	 */
	private final int max;
	
	/**
	 * Construct a reward.
	 * 
	 * @param id The item id.
	 * @param amount The amount of the item.
	 */
	public MobReward(int id, int amount) {
		this(id, amount, -1);
	}

	/**
	 * Construct a reward.
	 * 
	 * @param id The item id.
	 * @param min The min amount of the reward.
	 * @param max The max amount of the reward.
	 */
	public MobReward(int id, int min, int max) {
		this.id = id;
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Generate an item from this reward instance.
	 * 
	 * @return an {@link Item} varient.
	 */
	public Item generateItem() {
		return new Item(id, max == -1 ? min : Utils.random(min, max));
	}

}