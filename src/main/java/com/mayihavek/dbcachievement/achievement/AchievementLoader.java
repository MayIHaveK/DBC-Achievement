package com.mayihavek.dbcachievement.achievement;

import com.mayihavek.dbcachievement.Main;
import com.mayihavek.dbcachievement.item.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.AchievementPage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;


/**
 * 成就系统加载器，负责成就的创建、管理和注册
 *
 * @author MayIHaveK
 */
public class AchievementLoader {
    // 存储所有成就的映射表，key为成就ID，value为成就对象
    public ConcurrentHashMap<String, Achievement> achievements = new ConcurrentHashMap<>();
    // 存储所有成就页的列表
    private List<AchievementPage> achievementPages = new ArrayList<>();

    /**
     * 初始化成就系统，加载并注册所有成就
     */
    public void init() {
        loadAchievements();
        registerAchievements();
    }

    /**
     * 创建成就构建器
     *
     * @param id 成就唯一标识符
     * @return AchievementBuilder实例
     */
    public AchievementBuilder createAchievement(String id) {
        return new AchievementBuilder(id);
    }

    /**
     * 创建成就页构建器
     *
     * @param pageName 成就页显示名称
     * @return AchievementPageBuilder实例
     */
    public AchievementPageBuilder createAchievementPage(String pageName) {
        return new AchievementPageBuilder(pageName);
    }

    /**
     * 加载所有成就定义
     */
    public void loadAchievements() {
        ConcurrentHashMap<String, ItemBase> items = Main.itemLoader.items;

        // 独立高级形态成就 (放在龙珠Super上方)
        createAchievement("kaioken")
                .withPosition(-2, -2)
                .withIcon(items.get("界王拳"))
                .setSpecial()
                .register();

        createAchievement("mystic")
                .withPosition(-4, -2)
                .withIcon(items.get("老界王的仪式"))
                .setSpecial()
                .register();

        createAchievement("ultra_instinct")
                .withPosition(2, -2)
                .withIcon(items.get("自在极意"))
                .setSpecial()
                .register();

        createAchievement("ultra_ego")
                .withPosition(4, -2)
                .withIcon(items.get("自我极意"))
                .setSpecial()
                .register();

        //进入服务器自动获得，龙珠 Super 成就 (放在中心顶部位置)
        createAchievement("dragon_super")
                .withPosition(0, 0)
                .withIcon(items.get("龙珠super"))
                .register();

        // 种族成就 (横向排列在龙珠Super下方，间隔4格)
        createAchievement("saiyan_race")
                .withPosition(-10, 2)
                .withIcon(items.get("赛亚人"))
                .withParent("dragon_super")
                .register();

        //混血赛亚人
        createAchievement("hybrid_saiyan_race")
                .withPosition(-6, 2)
                .withIcon(items.get("混血赛亚人"))
                .withParent("dragon_super")
                .register();

        //人类
        createAchievement("human_race")
                .withPosition(-2, 2)
                .withIcon(items.get("人类"))
                .withParent("dragon_super")
                .register();

        //那美克
        createAchievement("namekian_race")
                .withPosition(2, 2)
                .withIcon(items.get("那美克星人"))
                .withParent("dragon_super")
                .register();

        //弗利萨
        createAchievement("frieza_race")
                .withPosition(6, 2)
                .withIcon(items.get("冰冻恶魔"))
                .withParent("dragon_super")
                .register();


        //魔人
        createAchievement("majin_race")
                .withPosition(10, 2)
                .withIcon(items.get("魔人"))
                .withParent("dragon_super")
                .register();

        // 赛亚人形态成就链
        //巨猿
        createAchievement("great_ape")
                .withPosition(-14, 4)
                .withIcon(items.get("赛亚巨猿"))
                .withParent("saiyan_race")
                .register();

        //黄金巨猿
        createAchievement("golden_ape")
                .withPosition(-14, 6)
                .withIcon(items.get("黄金巨猿"))
                .withParent("great_ape")
                .register();

        //超级赛亚人
        createAchievement("saiyan_ssj")
                .withPosition(-12, 4)
                .withIcon(items.get("超级赛亚人"))
                .withParent("saiyan_race")
                .register();

        //超级赛亚人 1:2
        createAchievement("saiyan_ssj2")
                .withPosition(-12, 6)
                .withIcon(items.get("超级赛亚人1:2"))
                .withParent("saiyan_ssj")
                .register();

        //超级赛亚人 1:3
        createAchievement("saiyan_ssj3")
                .withPosition(-12, 8)
                .withIcon(items.get("超级赛亚人1:3"))
                .withParent("saiyan_ssj2")
                .register();

        //超级赛亚人全功率
        createAchievement("saiyan_ssj_full_power")
                .withPosition(-12, 10)
                .withIcon(items.get("超级赛亚人全功率"))
                .withParent("saiyan_ssj3")
                .register();

        //超级赛亚人2
        createAchievement("saiyan_ssj2_real")
                .withPosition(-12, 12)
                .withIcon(items.get("超级赛亚人2"))
                .withParent("saiyan_ssj_full_power")
                .register();

        //超级赛亚人3
        createAchievement("saiyan_ssj3_real")
                .withPosition(-12, 14)
                .withIcon(items.get("超级赛亚人3"))
                .withParent("saiyan_ssj2_real")
                .register();

        //超级赛亚人4
        createAchievement("saiyan_ssj4")
                .withPosition(-12, 16)
                .withIcon(items.get("超级赛亚人4"))
                .withParent("saiyan_ssj3_real")
                .register();

        //超级赛亚人之神
        createAchievement("saiyan_ssg")
                .withPosition(-12, 18)
                .withIcon(items.get("超级赛亚人之神"))
                .withParent("hybrid_ssj3_real")
                .register();

        //超级赛亚人蓝
        createAchievement("saiyan_ssb")
                .withPosition(-12, 20)
                .withIcon(items.get("超级赛亚人蓝"))
                .withParent("saiyan_ssg")
                .register();

        //超级赛亚人深蓝
        createAchievement("saiyan_ssb_evolved")
                .withPosition(-12, 22)
                .withIcon(items.get("超级赛亚人深蓝"))
                .withParent("saiyan_ssb")
                .register();


        // 混血赛亚人形态成就链
        //巨猿
        createAchievement("hybrid_great_ape")
                .withPosition(-8, 4)
                .withIcon(items.get("赛亚巨猿"))
                .withParent("hybrid_saiyan_race")
                .register();

        //黄金巨猿
        createAchievement("hybrid_golden_ape")
                .withPosition(-8, 6)
                .withIcon(items.get("黄金巨猿"))
                .withParent("hybrid_great_ape")
                .register();

        //超级赛亚人
        createAchievement("hybrid_ssj")
                .withPosition(-6, 4)
                .withIcon(items.get("超级赛亚人"))
                .withParent("hybrid_saiyan_race")
                .register();

        //超级赛亚人 1:2
        createAchievement("hybrid_ssj2")
                .withPosition(-6, 6)
                .withIcon(items.get("超级赛亚人1:2"))
                .withParent("hybrid_ssj")
                .register();

        //超级赛亚人 1:3
        createAchievement("hybrid_ssj3")
                .withPosition(-6, 8)
                .withIcon(items.get("超级赛亚人1:3"))
                .withParent("hybrid_ssj2")
                .register();

        //超级赛亚人全功率
        createAchievement("hybrid_ssj_full_power")
                .withPosition(-6, 10)
                .withIcon(items.get("超级赛亚人全功率"))
                .withParent("hybrid_ssj3")
                .register();

        //超级赛亚人2
        createAchievement("hybrid_ssj2_real")
                .withPosition(-6, 12)
                .withIcon(items.get("超级赛亚人2"))
                .withParent("hybrid_ssj_full_power")
                .register();

        //超级赛亚人3
        createAchievement("hybrid_ssj3_real")
                .withPosition(-6, 14)
                .withIcon(items.get("超级赛亚人3"))
                .withParent("hybrid_ssj2_real")
                .register();

        //超级赛亚人4
        createAchievement("hybrid_ssj4")
                .withPosition(-6, 16)
                .withIcon(items.get("超级赛亚人4"))
                .withParent("hybrid_ssj3_real")
                .register();

        //超级赛亚人之神
        createAchievement("hybrid_ssg")
                .withPosition(-6, 18)
                .withIcon(items.get("超级赛亚人之神"))
                .withParent("hybrid_ssj3_real")
                .register();

        //超级赛亚人蓝
        createAchievement("hybrid_ssb")
                .withPosition(-6, 20)
                .withIcon(items.get("超级赛亚人蓝"))
                .withParent("hybrid_ssg")
                .register();

        //超级赛亚人深蓝
        createAchievement("hybrid_ssb_evolved")
                .withPosition(-6, 22)
                .withIcon(items.get("超级赛亚人深蓝"))
                .withParent("hybrid_ssb")
                .register();


        // 人类形态成就链
        //人类的潜力
        createAchievement("human_potential")
                .withPosition(-2, 4)
                .withIcon(items.get("人类潜力释放"))
                .withParent("human_race")
                .register();

        //人类的爆发
        createAchievement("human_muscle")
                .withPosition(-2, 6)
                .withIcon(items.get("肌肉强化"))
                .withParent("human_potential")
                .register();

        //神明的力量
        createAchievement("human_god")
                .withPosition(-2, 8)
                .withIcon(items.get("人类神形态"))
                .withParent("human_muscle")
                .register();


        // 那美克星人形态成就链
        //巨大化
        createAchievement("namekian_giant")
                .withPosition(2, 4)
                .withIcon(items.get("巨人"))
                .withParent("namekian_race")
                .register();

        //潜力释放
        createAchievement("namekian_potential")
                .withPosition(2, 6)
                .withIcon(items.get("那美克星人潜力释放"))
                .withParent("namekian_giant")
                .register();

        //那美克星之神
        createAchievement("namekian_god")
                .withPosition(2, 8)
                .withIcon(items.get("那美克星之神"))
                .withParent("namekian_potential")
                .register();

        // 弗利萨形态成就链
        //最终姿态
        createAchievement("frieza_super")
                .withPosition(6, 4)
                .withIcon(items.get("超级形态"))
                .withParent("frieza_race")
                .register();

        //黄金形态
        createAchievement("frieza_gold")
                .withPosition(6, 6)
                .withIcon(items.get("最终形态"))
                .withParent("frieza_super")
                .register();

        //冰冻恶魔之神
        createAchievement("frieza_god")
                .withPosition(6, 8)
                .withIcon(items.get("冰冻恶魔神形态"))
                .withParent("frieza_gold")
                .register();

        // 魔人形态成就链
        //邪恶魔人
        createAchievement("majin_evil")
                .withPosition(10, 4)
                .withIcon(items.get("邪恶魔人"))
                .withParent("majin_race")
                .register();

        //魔人全功率
        createAchievement("majin_full_power")
                .withPosition(10, 6)
                .withIcon(items.get("魔人全功率"))
                .withParent("majin_evil")
                .register();

        //纯粹魔人
        createAchievement("majin_pure")
                .withPosition(10, 8)
                .withIcon(items.get("纯粹魔人"))
                .withParent("majin_full_power")
                .register();

        //魔人之神
        createAchievement("majin_god")
                .withPosition(10, 10)
                .withIcon(items.get("魔人神形态"))
                .withParent("majin_pure")
                .register();

        // 创建单个成就页"龙珠Super"
        AchievementPageBuilder pageBuilder = createAchievementPage("龙珠Super");

        // 添加所有成就到同一个页面
        achievements.keySet().forEach(pageBuilder::addAchievement);

        pageBuilder.register();
    }

    /**
     * 注册所有已加载的成就
     */
    public void registerAchievements() {
        achievements.forEach((name, achievement) -> achievement.registerStat());
    }

    /**
     * 成就构建器，用于链式配置成就属性
     */
    public class AchievementBuilder {
        private final String id;
        private String nameKey; // 改为存储语言文件键名
        private String descKey; // 改为存储描述键名
        private int x, y;
        private ItemBase icon;
        private String parentId;
        private boolean isSpecial;

        public AchievementBuilder(String id) {
            this.id = id;
            //自动设置名字
            withName("dbc." + id);
            //自动设置描述
            withDescription("dbc." + id + ".desc");
        }

        /**
         * 设置成就显示名称键
         *
         * @param nameKey 语言文件中的名称键
         */
        public AchievementBuilder withName(String nameKey) {
            this.nameKey = nameKey;
            return this;
        }

        /**
         * 设置成就描述键
         *
         * @param descKey 语言文件中的描述键
         */
        public AchievementBuilder withDescription(String descKey) {
            this.descKey = descKey;
            return this;
        }

        /**
         * 设置成就在成就界面中的坐标位置
         *
         * @param x X坐标
         * @param y Y坐标
         */
        public AchievementBuilder withPosition(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        /**
         * 设置成就图标物品
         *
         * @param icon 用作图标的物品
         */
        public AchievementBuilder withIcon(ItemBase icon) {
            this.icon = icon;
            return this;
        }

        /**
         * 设置前置成就
         *
         * @param parentId 前置成就ID
         */
        public AchievementBuilder withParent(String parentId) {
            this.parentId = parentId;
            return this;
        }

        /**
         * 标记为特殊成就(隐藏成就)
         */
        public AchievementBuilder setSpecial() {
            this.isSpecial = true;
            return this;
        }

        /**
         * 完成配置并注册成就
         */
        public void register() {
            Achievement achievement = new Achievement(
                    "achievement.dbc." + id,
                    nameKey, // 直接使用键名
                    x, y,
                    icon,
                    parentId != null ? achievements.get(parentId) : null
            );


            // 设置描述格式化器
            achievement.setStatStringFormatter((stat) ->
                    StatCollector.translateToLocal("achievement." + descKey)
            );

            if (isSpecial) {
                achievement.setSpecial();
            }

            achievements.put(id, achievement);
        }
    }

    /**
     * 成就页构建器，用于组织相关成就到同一页面
     */
    public class AchievementPageBuilder {
        private final String pageName;
        private final List<Achievement> pageAchievements = new ArrayList<>();

        public AchievementPageBuilder(String pageName) {
            this.pageName = pageName;
        }

        /**
         * 向成就页添加成就
         *
         * @param achievementId 要添加的成就ID
         */
        public AchievementPageBuilder addAchievement(String achievementId) {
            Achievement achievement = achievements.get(achievementId);
            if (achievement != null) {
                pageAchievements.add(achievement);
            }
            return this;
        }

        /**
         * 完成配置并注册成就页
         */
        public void register() {
            AchievementPage page = new AchievementPage(
                    pageName,
                    pageAchievements.toArray(new Achievement[0])
            );
            achievementPages.add(page);
            AchievementPage.registerAchievementPage(page);
        }
    }

    /**
     * 检查玩家是否获得了指定成就
     * @param player 要检查的玩家
     * @param achievementId 成就ID
     * @return 是否已获得该成就
     */
    public boolean hasAchievement(EntityPlayerMP player, String achievementId) {
        Achievement achievement = achievements.get(achievementId);
        if (achievement == null) {
            return false;
        }
        return player.func_147099_x().hasAchievementUnlocked(achievement);
    }


    /**
     * 授予玩家指定成就
     * @param player 玩家对象
     * @param achievementId 成就ID
     */
    public void grantAchievement(EntityPlayerMP player, String achievementId) {
        if (!player.worldObj.isRemote) { // 确保在服务端执行
            Achievement achievement = achievements.get(achievementId);
            if (achievement != null && !hasAchievement(player, achievementId)) {
                player.addStat(achievement, 1); // 授予成就
            }
        }
    }


}

