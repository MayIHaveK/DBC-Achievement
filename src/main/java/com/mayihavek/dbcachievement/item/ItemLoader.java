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
        //种族和龙珠super图标
        items.put("龙珠super",new ItemBase("龙珠super","icon0"));
        items.put("赛亚人",new ItemBase("赛亚人","icon1"));
        items.put("混血赛亚人",new ItemBase("混血赛亚人","icon2"));
        items.put("人类",new ItemBase("人类","icon3"));
        items.put("冰冻恶魔",new ItemBase("冰冻恶魔","icon4"));
        items.put("那美克星人",new ItemBase("那美克星人","icon5"));
        items.put("魔人",new ItemBase("魔人","icon6"));
        //赛亚人/混血赛亚人形态图标
        items.put("赛亚巨猿",new ItemBase("赛亚巨猿","icon7"));
        items.put("黄金巨猿",new ItemBase("黄金巨猿","icon8"));
        items.put("超级赛亚人",new ItemBase("超级赛亚人","icon9"));
        items.put("超级赛亚人1:2",new ItemBase("超级赛亚人1:2","icon10"));
        items.put("超级赛亚人1:3",new ItemBase("超级赛亚人1:3","icon11"));
        items.put("超级赛亚人2",new ItemBase("超级赛亚人2","icon12"));
        items.put("超级赛亚人3",new ItemBase("超级赛亚人3","icon13"));
        items.put("超级赛亚人4",new ItemBase("超级赛亚人4","icon14"));
        items.put("超级赛亚人之神",new ItemBase("超级赛亚人之神","icon15"));
        items.put("超级赛亚人蓝",new ItemBase("超级赛亚人蓝","icon16"));
        items.put("超级赛亚人深蓝",new ItemBase("超级赛亚人深蓝","icon17"));
        items.put("超级赛亚人全功率",new ItemBase("超级赛亚人全功率","icon18"));
        //人类形态
        items.put("人类潜力释放",new ItemBase("人类潜力释放","icon19"));
        items.put("肌肉强化",new ItemBase("肌肉强化","icon20"));
        items.put("人类神形态",new ItemBase("人类神模式","icon21"));
        //魔人形态
        items.put("邪恶魔人",new ItemBase("邪恶魔人","icon22"));
        items.put("魔人全功率",new ItemBase("魔人全功率","icon23"));
        items.put("纯粹魔人",new ItemBase("纯粹魔人","icon24"));
        items.put("魔人神形态",new ItemBase("魔人神形态","icon25"));
        //那美克星人
        items.put("巨人",new ItemBase("巨人","icon26"));
        items.put("那美克星人潜力释放",new ItemBase("那美克星人潜力释放","icon27"));
        items.put("那美克星之神",new ItemBase("那美克星之神","icon28"));
        //冰冻恶魔
        items.put("超级形态",new ItemBase("超级形态","icon29"));
        items.put("最终形态",new ItemBase("最终形态","icon30"));
        items.put("冰冻恶魔神形态",new ItemBase("冰冻恶魔神形态","icon31"));
        //通用形态
        items.put("界王拳",new ItemBase("混血赛亚人","icon32"));
        items.put("老界王的仪式",new ItemBase("混血赛亚人","icon33"));
        items.put("自在极意",new ItemBase("混血赛亚人","icon34"));
        items.put("自我极意",new ItemBase("混血赛亚人","icon35"));
    }

    public void registerItems() {
        items.forEach((k,v) -> {
            GameRegistry.registerItem(v, k);
        });
    }

}
