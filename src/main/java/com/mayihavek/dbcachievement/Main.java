package com.mayihavek.dbcachievement;

import com.mayihavek.dbcachievement.achievement.AchievementLoader;
import com.mayihavek.dbcachievement.event.AchievementCheck;
import com.mayihavek.dbcachievement.item.ItemLoader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author MayIHaveK
 */
@Mod(modid = Main.MODID, version = Main.VERSION,name = Main.NAME)
public class Main
{
    public static final String NAME = "DBC-Achievement";
    public static final String MODID = "dbcachievement";
    public static final String VERSION = "1.0";
    public static ItemLoader itemLoader;
    public static AchievementLoader achievementLoader;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        itemLoader = new ItemLoader();
        itemLoader.init();
        achievementLoader = new AchievementLoader();
        achievementLoader.init();
        MinecraftForge.EVENT_BUS.register(new AchievementCheck());
    }
}
