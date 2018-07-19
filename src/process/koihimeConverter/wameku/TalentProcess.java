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
	private HashMap<String, String> armpitMap = new HashMap<>();
	private HashMap<String, String> bodySizeMap = new HashMap<>();
	private HashMap<String, String> bodyTypeMap = new HashMap<>();
	private HashMap<String, String> bustSizeMap = new HashMap<>();
	private HashMap<String, String> hipSizeMap = new HashMap<>();
	private HashMap<String, String> hairMap = new HashMap<>();

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
		armpitMap.put("脱毛済み", "-1");
		armpitMap.put("つるつる", "0");
		armpitMap.put("手入れ済み", "1");
		armpitMap.put("うっすら", "2");
		armpitMap.put("ふんわり", "3");
		armpitMap.put("普通", "4");
		armpitMap.put("多め", "5");
		armpitMap.put("ふさふさ", "6");
		armpitMap.put("もっさり", "7");
		armpitMap.put("剛毛", "8");
		armpitMap.put("密林", "9");

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

		bodySizeMap.put("子供", "-2");
		bodySizeMap.put("小柄", "-1");
		bodySizeMap.put("普通", "0");
		bodySizeMap.put("長身", "1");
		bodySizeMap.put("大柄", "2");
		bodySizeMap.put("巨大", "3");

		bodyTypeMap.put("痩せすぎ", "-3");
		bodyTypeMap.put("細身", "-2");
		bodyTypeMap.put("スレンダー", "-1");
		bodyTypeMap.put("普通", "0");
		bodyTypeMap.put("グラマー", "1");
		bodyTypeMap.put("豊満", "2");
		bodyTypeMap.put("肥満", "3");

		bustSizeMap.put("絶壁", "-2");
		bustSizeMap.put("貧乳", "-1");
		bustSizeMap.put("普乳", "0");
		bustSizeMap.put("巨乳", "1");
		bustSizeMap.put("爆乳", "2");

		hipSizeMap.put("壁尻", "-2");
		hipSizeMap.put("薄尻", "-1");
		hipSizeMap.put("普尻", "0");
		hipSizeMap.put("巨尻", "1");
		hipSizeMap.put("爆尻", "2");

		hairMap.put("不明", "0");
		hairMap.put("スキンヘッド", "1");
		hairMap.put("超ショート", "2");
		hairMap.put("ショート", "3");
		hairMap.put("ミドル", "4");
		hairMap.put("ロング", "5");
		hairMap.put("超ロング", "6");
	}

	@Override
	public Process action(CharaData chara, HashMap<String,String> data) {
		LinkedHashMap<String,String> talentMap = chara.getTalentMap();

		String[] talents = data.get("素質").split(",");

		talentMap.put("成長型", growTypeMap.get(data.get("成長型")));
		talentMap.put("陰毛現在値", inmouMap.get(data.get("陰毛")));
		talentMap.put("陰毛目標値", inmouMap.get(data.get("陰毛")));
		talentMap.put("腋毛現在値", armpitMap.get(data.get("腋毛")));
		talentMap.put("腋毛目標値", armpitMap.get(data.get("腋毛")));

		talentMap.put("性的嗜好", preferenceMap.get(data.get("性的嗜好")));
		talentMap.put("Ｖ締まり", tightnessMap.get(data.get("Ｖ締まり")));
		talentMap.put("Ａ締まり", tightnessMap.get(data.get("Ａ締まり")));

		//髪色は0x表記で16進数を利用しているので、こちらであらかじめつけておく
		talentMap.put("髪色", "0x" + data.get("髪色"));
		talentMap.put("髪の長さ", hairMap.get(data.get("髪の長さ")));

		talentMap.put("体格", bodySizeMap.get(data.get("体格")));
		talentMap.put("体型", bodyTypeMap.get(data.get("体型")));
		talentMap.put("バストサイズ", bustSizeMap.get(data.get("バストサイズ")));
		talentMap.put("ヒップサイズ", hipSizeMap.get(data.get("ヒップサイズ")));

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
				case "絶壁":
					talentMap.put("バストサイズ", "-2");
					break;
				case "貧乳":
					talentMap.put("バストサイズ", "-1");
					break;
				case "巨乳":
					talentMap.put("バストサイズ", "1");
					break;
				case "爆乳":
					talentMap.put("バストサイズ", "2");
					break;
				default:
					talentMap.put(talent, "1");
					break;
			}
		}
		return new ExpProcess();

	}



}
