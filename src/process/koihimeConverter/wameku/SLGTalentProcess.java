package process.koihimeConverter.wameku;

import loader.koihimeConverter.wameku.CharaData;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by WamekuKyouzin on 2016/05/03.
 */
public class SLGTalentProcess extends Process{
    private HashMap<String, Integer> slgMap = new HashMap<>();
    SLGTalentProcess(){
        slgMap.put("治療", (int)Math.pow(2,0));
        slgMap.put("超成長力", (int)Math.pow(2, 1));
        slgMap.put("努力家", (int)Math.pow(2, 2));
        slgMap.put("策士", (int)Math.pow(2, 3));
        slgMap.put("明察", (int)Math.pow(2, 4));
        slgMap.put("ステゴロ", (int)Math.pow(2, 5));
        slgMap.put("威圧", (int)Math.pow(2, 6));
        slgMap.put("下克上等", (int)Math.pow(2, 7));
        slgMap.put("魔力転換", (int)Math.pow(2, 8));
        slgMap.put("突貫", (int)Math.pow(2,9));
        slgMap.put("バンドガール", (int)Math.pow(2, 10));
        slgMap.put("哨戒", (int)Math.pow(2, 11));
        slgMap.put("防衛戦術", (int)Math.pow(2, 12));
        slgMap.put("暗殺", (int)Math.pow(2, 13));
        slgMap.put("弁舌", (int)Math.pow(2, 14));
        slgMap.put("早足", (int)Math.pow(2, 15));
        slgMap.put("風説流布", (int)Math.pow(2, 16));
        slgMap.put("手練手管", (int)Math.pow(2, 17));
        slgMap.put("疾風迅雷", (int)Math.pow(2, 18));
        slgMap.put("統率力", (int)Math.pow(2, 19));
        slgMap.put("封魔", (int)Math.pow(2, 20));
        slgMap.put("遅滞戦術", (int)Math.pow(2, 21));
        slgMap.put("斉射", (int)Math.pow(2, 22));

    };
    @Override
    public Process action(CharaData chara, HashMap<String, String> data) {
        int value = 0;
        String[] slgTalents = data.get("ＳＬＧ素質").split(",");
        for (String slgTalent:slgTalents) {
            slgTalent = slgTalent.replaceAll(" ", "");
            slgTalent = slgTalent.replaceAll("　", "");
            if (slgMap.get(slgTalent) != null) {
                value += slgMap.get(slgTalent);
            } else if (slgMap.get(slgTalent) == null && !slgTalent.equals("")){
                System.out.println(chara.getName() + "のＳＬＧ素質設定ミス");
            }
        }
        chara.setSlgTalentValue(value);


        return new ExpProcess();
    }
}
