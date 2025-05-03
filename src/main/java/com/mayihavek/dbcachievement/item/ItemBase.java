package com.mayihavek.dbcachievement.item;

import com.mayihavek.dbcachievement.Main;
import net.minecraft.item.Item;

/**
 * @author MayIHaveK
 * @date 2025/05/03 17:30
 **/
public class ItemBase extends Item {

    public ItemBase(String name,String iconName) {
        super();
        setUnlocalizedName(name);
        setTextureName(Main.MODID + ":" + iconName);
    }


}