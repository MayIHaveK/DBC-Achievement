package com.mayihavek.dbcachievement.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author MayIHaveK
 * @date 2025/05/03 17:15
 **/
public class ItemLoader {

    public ConcurrentHashMap<String, ItemBase> items = new ConcurrentHashMap<>();

    public void init(){
        loadItems();
        registerItems();
    }

    public void loadItems() {
        items.put("赛亚人",new ItemBase("赛亚人","icon1"));
    }

    public void registerItems() {
        items.forEach((k,v) -> {
            GameRegistry.registerItem(v, k);
        });
    }

}