package com.mayihavek.dbcachievement.event;

import com.mayihavek.dbcachievement.Main;
import com.mayihavek.dbcachievement.achievement.AchievementLoader;
import com.mayihavek.dbcachievement.achievement.AchievementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

/**
 * @author MayIHaveK
 * @date 2025/05/03 18:06
 **/
public class AchievementCheck {

    /**
     * 用于自动获取成就
     */
    @SubscribeEvent
    public void checkAchievement(LivingEvent.LivingUpdateEvent event) {
        Entity entity = event.entity;
        if (!(entity instanceof EntityPlayerMP)) {
            return;
        }
        EntityPlayerMP player = (EntityPlayerMP) entity;
        if (!player.worldObj.isRemote) {
            AchievementLoader achievementLoader = Main.achievementLoader;
            achievementLoader.achievements.forEach((s, achievement) -> {
                //检测没有获得这个成就，并且获得了前一个成就
                Achievement parentAchievement = achievement.parentAchievement;
                if (!achievementLoader.hasAchievement(player, s) && (parentAchievement != null && achievementLoader.hasAchievement(player, parentAchievement.statId.replaceAll("achievement.dbc.", "")))) {
                    //如果有前一个成就，并且已经获得了，则触发当前成就
                    try {
                        AchievementType.valueOf(s.toUpperCase()).checkCondition(player, s, achievementLoader);
                    } catch (IllegalArgumentException ignored) {
                    }
                }
            });
        }
    }


    @SubscribeEvent
    public void onPlayerJoin(EntityJoinWorldEvent event) {
        Entity entity = event.entity;
        if (!(entity instanceof EntityPlayerMP)) {
            return;
        }
        EntityPlayerMP player = (EntityPlayerMP) entity;
        if (!player.worldObj.isRemote) {
            Main.achievementLoader.grantAchievement(player, "dragon_super");
        }
    }

}