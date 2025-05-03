package com.mayihavek.dbcachievement.achievement;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;

/**
 * @author MayIHaveK
 * @date 2025/05/03 20:20
 **/
public enum AchievementType {
    // 赛亚人种族成就
    SAIYAN_RACE("saiyan_race", (player, achievementId, achievementLoader) -> {
        if (isSaiyanRace(player)) {
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SAIYAN_RACE("hybrid_saiyan_race", (player, achievementId, achievementLoader) -> {
        if (isHalfSaiyanRace(player)) {
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HUMAN_RACE("human_race", (player, achievementId, achievementLoader) -> {
        if (isHumanRace(player)) {
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    NAMEKIAN_RACE("namekian_race", (player, achievementId, achievementLoader) -> {
        if (isNamekianRace(player)) {
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    FRIEZA_RACE("frieza_race", (player, achievementId, achievementLoader) -> {
        if (isFriezaRace(player)) {
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    MAJIN_RACE("majin_race", (player, achievementId, achievementLoader) -> {
        if(isMajinRace(player)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),

    // 赛亚人形态
    GREAT_APE("great_ape", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,7)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    GOLDEN_APE("golden_ape", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,8)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSJ("saiyan_ssj", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,1)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSJ2("saiyan_ssj2", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,2)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSJ3("saiyan_ssj3", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,3)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSJ_FULL_POWER("saiyan_ssj_full_power", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,4)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSJ2_REAL("saiyan_ssj2_real", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,5)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSJ3_REAL("saiyan_ssj3_real", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,6)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSJ4("saiyan_ssj4", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,14)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSG("saiyan_ssg", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,9)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSB("saiyan_ssb", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,10)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    SAIYAN_SSB_EVOLVED("saiyan_ssb_evolved", (player, achievementId, achievementLoader) -> {
        if(isSaiyanRace(player) && isState(player,15)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),

    // 混血赛亚人形态
    HYBRID_GREAT_APE("hybrid_great_ape", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,7)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_GOLDEN_APE("hybrid_golden_ape", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,8)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSJ("hybrid_ssj", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,1)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSJ2("hybrid_ssj2", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,2)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSJ3("hybrid_ssj3", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,3)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSJ_FULL_POWER("hybrid_ssj_full_power", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,4)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSJ2_REAL("hybrid_ssj2_real", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,5)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSJ3_REAL("hybrid_ssj3_real", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,6)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSJ4("hybrid_ssj4", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,14)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSG("hybrid_ssg", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,9)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSB("hybrid_ssb", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,10)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HYBRID_SSB_EVOLVED("hybrid_ssb_evolved", (player, achievementId, achievementLoader) -> {
        if(isHalfSaiyanRace(player) && isState(player,15)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),

    // 人类形态
    HUMAN_POTENTIAL("human_potential", (player, achievementId, achievementLoader) -> {
        if(isHumanRace(player) && isState(player,1)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HUMAN_MUSCLE("human_muscle", (player, achievementId, achievementLoader) -> {
        if(isHumanRace(player) && isState(player,2)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    HUMAN_GOD("human_god", (player, achievementId, achievementLoader) -> {
        if(isHumanRace(player) && isState(player,3)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),

    // 那美克星人形态
    NAMEKIAN_GIANT("namekian_giant", (player, achievementId, achievementLoader) -> {
        if(isNamekianRace(player) && isState(player,1)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    NAMEKIAN_POTENTIAL("namekian_potential", (player, achievementId, achievementLoader) -> {
        if(isNamekianRace(player) && isState(player,2)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    NAMEKIAN_GOD("namekian_god", (player, achievementId, achievementLoader) -> {
        if(isNamekianRace(player) && isState(player,3)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),

    // 弗利萨形态
    FRIEZA_SUPER("frieza_super", (player, achievementId, achievementLoader) -> {
        if(isFriezaRace(player) && isState(player,5)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    FRIEZA_GOLD("frieza_gold", (player, achievementId, achievementLoader) -> {
        if(isFriezaRace(player) && isState(player,6)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    FRIEZA_GOD("frieza_god", (player, achievementId, achievementLoader) -> {
        if(isFriezaRace(player) && isState(player,7)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),

    // 魔人形态
    MAJIN_EVIL("majin_evil", (player, achievementId, achievementLoader) -> {
        if(isMajinRace(player) && isState(player,1)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    MAJIN_FULL_POWER("majin_full_power", (player, achievementId, achievementLoader) -> {
        if(isMajinRace(player) && isState(player,2)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    MAJIN_PURE("majin_pure", (player, achievementId, achievementLoader) -> {
        if(isMajinRace(player) && isState(player,3)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    MAJIN_GOD("majin_god", (player, achievementId, achievementLoader) -> {
        if(isMajinRace(player) && isState(player,4)){
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    KAIOKEN("kaioken", (player, achievementId, achievementLoader) -> {
        if(isAccept(player) && getDBCEntityData(player).getInteger("jrmcState2") > 0){
            if(!isContains(player,"jmcStatusEff","N")) {
                achievementLoader.grantAchievement(player, achievementId);
            }
        }
    }),
    MYSTIC("mystic", (player, achievementId, achievementLoader) -> {
        if(isAccept(player) && isContains(player,"jmcStatusEff","C")) {
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    ULTRA_INSTINCT("ultra_instinct", (player, achievementId, achievementLoader) -> {
        if(isAccept(player) && isContains(player,"jmcStatusEff","N") && getDBCEntityData(player).getInteger("jrmcState2") == 2) {
            achievementLoader.grantAchievement(player, achievementId);
        }
    }),
    ULTRA_EGO("ultra_ego", (player, achievementId, achievementLoader) -> {
        if(isAccept(player) && isContains(player,"jmcStatusEff","NN")&& getDBCEntityData(player).getInteger("jrmcState2") == 3) {
            achievementLoader.grantAchievement(player, achievementId);
        }
    });


    private static boolean isHumanRace(EntityPlayerMP player) {
        return isEqualValue(player, "jrmcRace", 0) && isAccept(player);
    }


    private static boolean isSaiyanRace(EntityPlayerMP player) {
        return isEqualValue(player, "jrmcRace", 1) && isAccept(player);
    }

    private static boolean isHalfSaiyanRace(EntityPlayerMP player) {
        return isEqualValue(player, "jrmcRace", 2) && isAccept(player);
    }

    private static boolean isNamekianRace(EntityPlayerMP player) {
        return isEqualValue(player, "jrmcRace", 3) && isAccept(player);
    }

    private static boolean isFriezaRace(EntityPlayerMP player) {
        return isEqualValue(player, "jrmcRace", 4) && isAccept(player);
    }

    private static boolean isMajinRace(EntityPlayerMP player) {
        return isEqualValue(player, "jrmcRace", 5) && isAccept(player);
    }

    private static boolean isState(EntityPlayerMP player,int value){
        return isEqualValue(player, "jrmcState", value) && isAccept(player);
    }

    public static boolean isAccept(EntityPlayerMP player){
        return isEqualValue(player, "jrmcAccept", 1);
    }

    /**
     * 是否包含某个字符串
     * @param player
     * @param value
     * @return
     */
    private static boolean isContains(EntityPlayerMP player,String key,String value){
        NBTTagCompound data = getDBCEntityData(player);
        return data.getString(key).contains(value);
    }


    private final String achievementId;
    private final AchievementCondition condition;

    AchievementType(String achievementId, AchievementCondition condition) {
        this.achievementId = achievementId;
        this.condition = condition;
    }


    public String getAchievementId() {
        return achievementId;
    }

    public void checkCondition(EntityPlayerMP player, String achievementId, AchievementLoader achievementLoader) {
        condition.check(player, achievementId, achievementLoader);
    }

    @FunctionalInterface
    public interface AchievementCondition {
        void check(EntityPlayerMP player, String achievementId, AchievementLoader achievementLoader);
    }

    public static NBTTagCompound getDBCEntityData(EntityPlayerMP player) {
        NBTTagCompound entityData = player.getEntityData();
        return entityData.getCompoundTag("PlayerPersisted");
    }

    /**
     * 泛型方法检查玩家数据是否匹配
     *
     * @param player 玩家对象
     * @param key    数据键名
     * @param value  要比较的值
     * @param <T>    数据类型(支持Integer, Float, Double, String, Boolean)
     * @return 是否匹配
     */
    public static <T> boolean isEqualValue(EntityPlayerMP player, String key, T value) {
        NBTTagCompound data = getDBCEntityData(player);
        if (value instanceof Integer) {
            return data.getInteger(key) == (Integer) value;
        } else if (value instanceof Float) {
            return data.getFloat(key) == (Float) value;
        } else if (value instanceof Double) {
            return data.getDouble(key) == (Double) value;
        } else if (value instanceof String) {
            return data.getString(key).equals(value);
        } else if (value instanceof Boolean) {
            return data.getBoolean(key) == (Boolean) value;
        }
        return false;
    }

}
