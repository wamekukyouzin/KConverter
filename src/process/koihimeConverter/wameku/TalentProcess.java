package process.koihimeConverter.wameku;

import java.util.HashMap;
import java.util.LinkedHashMap;

import loader.koihimeConverter.wameku.CharaData;

public class TalentProcess extends Process{
	//入力された生データを対応する数値に変換するための対応表
	private HashMap<String, String> charaMap = new HashMap<>();
	private HashMap<String, String> growTypeMap = new HashMap<>();
	private HashMap<String, String> inmouMap = new HashMap<>();
	private HashMap<String, String> preferenceMap = new HashMap<>();
	private HashMap<String, String> tightnessMap = new HashMap<>();
	//入力された生データを対応する数値に変換するための対応表
	TalentProcess() {
		charaMap.put("", "0");
		charaMap.put("冷静＆清廉", "1");
		charaMap.put("豪気＆清廉", "2");
		charaMap.put("冷静＆利己", "3");
		charaMap.put("豪気＆利己", "4");
		growTypeMap.put("", "0");
		growTypeMap.put("万能", "0");
		growTypeMap.put("知将", "1");
		growTypeMap.put("学士", "2");
		growTypeMap.put("両道", "3");
		growTypeMap.put("武官", "4");
		growTypeMap.put("軍師", "5");
		growTypeMap.put("文官", "6");
		growTypeMap.put("芸能", "7");
		growTypeMap.put("料理", "8");
		growTypeMap.put("天才", "9");
		inmouMap.put("パイパン", "-1");
		inmouMap.put("つるつる", "0");
		inmouMap.put("うっすら", "1");
		inmouMap.put("柔毛", "2");
		inmouMap.put("ふんわり", "3");
		inmouMap.put("標準", "4");
		inmouMap.put("多め", "5");
		inmouMap.put("ふさふさ", "6");
		inmouMap.put("もっさり", "7");
		inmouMap.put("剛毛", "8");
		inmouMap.put("尻まで届く", "9");
		inmouMap.put("ハート型", "10");
		preferenceMap.put("愛撫（する）", "1");
		preferenceMap.put("奉仕（する）", "2");
		preferenceMap.put("性交（する）", "3");
		preferenceMap.put("道具（使う）", "4");
		preferenceMap.put("ＳＭ（する）", "5");
		preferenceMap.put("羞恥（する）", "6");
		preferenceMap.put("触手（する）", "7");
		preferenceMap.put("愛撫（される）", "8");
		preferenceMap.put("奉仕（される）", "9");
		preferenceMap.put("性交（される）", "10");
		preferenceMap.put("道具（使われる）", "11");
		preferenceMap.put("ＳＭ（される）", "12");
		preferenceMap.put("羞恥（される）", "13");
		preferenceMap.put("触手（される）", "14");
		tightnessMap.put("ぎちぎち", "950");
		tightnessMap.put("きつきつ", "850");
		tightnessMap.put("きゅっきゅっ", "750");
		tightnessMap.put("名器", "650");
		tightnessMap.put("普通", "550");
		tightnessMap.put("ゆるめ", "450");
		tightnessMap.put("ゆるゆる", "350");
		tightnessMap.put("ぽっかり", "250");
		tightnessMap.put("がばがば", "150");
		tightnessMap.put("崩壊", "50");

	}

	@Override
	public Process action(CharaData chara, HashMap<String,String> data) {
		LinkedHashMap<String,String> talentMap = chara.getTalentMap();

		String[] talents = data.get("素質").split(",");

		talentMap.put("成長型", growTypeMap.get(data.get("成長型")));
		talentMap.put("性格", charaMap.get((data.get("性格"))));
		talentMap.put("陰毛現在値", inmouMap.get(data.get("陰毛")));
		talentMap.put("陰毛目標値", inmouMap.get(data.get("陰毛")));
		talentMap.put("性的嗜好", preferenceMap.get(data.get("性的嗜好")));
		talentMap.put("Ｖ締まり", tightnessMap.get(data.get("Ｖ締まり")));
		talentMap.put("Ａ締まり", tightnessMap.get(data.get("Ａ締まり")));

		//髪色は0x表記で16進数を利用しているので、こちらであらかじめつけておく
		talentMap.put("髪色", "0x" + data.get("髪色"));
		talentMap.put("髪の長さ", data.get("髪の長さ"));

		//この時点でtalentsの各要素には不要な半角スペースがあるので、一応取っておく（問題ないとは思うが……）
		//あと全角も取っておく（これは明確に問題になる　なった）
		for (String talent:talents) {
			talent = talent.replaceAll(" ","");
			talent = talent.replaceAll("　", "");
			//「旧作キャラ」「特殊キャラ」はキャラ区分の値なので分岐で制御
			switch (talent) {
				case "旧作キャラ":
					talentMap.put("キャラ区分", "1");
					break;
				case "特殊キャラ":
					talentMap.put("キャラ区分", "2");
					break;
				default:
					talentMap.put(talent, "1");
					break;
			}
		}
		return new ExpProcess();

	}



}
