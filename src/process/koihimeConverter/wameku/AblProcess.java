package process.koihimeConverter.wameku;

import java.util.HashMap;
import java.util.LinkedHashMap;

import loader.koihimeConverter.wameku.CharaData;

public class AblProcess extends Process {

	@Override
	public Process action(CharaData chara, HashMap<String, String> data) {
		LinkedHashMap<String, String> ablMap = chara.getAblMap();
		ablMap.put("武闘", data.get("武闘"));
		ablMap.put("知略", data.get("知略"));
		ablMap.put("政治", data.get("政治"));
		ablMap.put("歌唱", data.get("歌唱"));
		if (!data.get("妖術").equals(""))
			ablMap.put("妖術", data.get("妖術"));
		ablMap.put("料理", data.get("料理"));
		ablMap.put("野心", data.get("野心"));
		if (!data.get("能力 [性知識]").equals(""))
			ablMap.put("性知識", data.get("能力 [性知識]"));

		if (!data.get("能力 [Ｃ感]").equals(""))
			ablMap.put("Ｃ感", data.get("能力 [Ｃ感]"));

		if (!data.get("能力 [Ｖ感]").equals(""))
			ablMap.put("Ｖ感", data.get("能力 [Ｖ感]"));

		if (!data.get("能力 [Ａ感]").equals(""))
			ablMap.put("Ａ感", data.get("能力 [Ａ感]"));

		if (!data.get("能力 [Ｂ感]").equals(""))
			ablMap.put("Ｂ感", data.get("能力 [Ｂ感]"));

		if (!data.get("能力 [Ｍ感]").equals(""))
			ablMap.put("Ｍ感", data.get("能力 [Ｍ感]"));

		if (!data.get("能力 [欲望]").equals(""))
			ablMap.put("欲望", data.get("能力 [欲望]"));

		if (!data.get("能力 [性技]").equals(""))
			ablMap.put("性技", data.get("能力 [性技]"));

		if (!data.get("能力 [奉仕]").equals(""))
			ablMap.put("奉仕", data.get("能力 [奉仕]"));

		if (!data.get("能力 [性交]").equals(""))
			ablMap.put("性交", data.get("能力 [性交]"));

		if (!data.get("能力 [レズ]").equals(""))
			ablMap.put("レズ", data.get("能力 [レズ]"));

		if (!data.get("能力 [ＢＬ]").equals(""))
			ablMap.put("ＢＬ", data.get("能力 [ＢＬ]"));

		if (!data.get("能力 [露出]").equals(""))
			ablMap.put("露出", data.get("能力 [露出]"));

		if (!data.get("能力 [自慰]").equals(""))
			ablMap.put("自慰", data.get("能力 [自慰]"));

		if (!data.get("能力 [精愛]").equals(""))
			ablMap.put("精愛", data.get("能力 [精愛]"));

		if (!data.get("能力 [射精]").equals(""))
			ablMap.put("射精", data.get("能力 [射精]"));

		if (!data.get("能力 [噴乳]").equals(""))
			ablMap.put("噴乳", data.get("能力 [噴乳]"));

		if (!data.get("能力 [排泄]").equals(""))
			ablMap.put("排泄", data.get("能力 [排泄]"));

		if (!data.get("能力 [触手]").equals(""))
			ablMap.put("触手", data.get("能力 [触手]"));

		if (!data.get("能力 [肝臓]").equals(""))
			ablMap.put("肝臓", data.get("能力 [肝臓]"));
		return new TalentProcess();
	}

}
