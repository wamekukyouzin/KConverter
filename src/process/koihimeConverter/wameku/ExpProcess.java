package process.koihimeConverter.wameku;

import java.util.HashMap;
import java.util.LinkedHashMap;

import loader.koihimeConverter.wameku.CharaData;

public class ExpProcess extends Process {

	@Override
	public Process action(CharaData chara, HashMap<String, String> data) {
		LinkedHashMap<String, String> expMap = chara.getExpMap();

		if (!data.get("絶頂経験").equals(""))
			expMap.put("絶頂経験", data.get("絶頂経験"));

		if (!data.get("苦痛快楽経験").equals(""))
			expMap.put("苦痛快楽経験", data.get("苦痛快楽経験"));

		if (!data.get("Ｖ拡張経験").equals(""))
			expMap.put("Ｖ拡張経験", data.get("Ｖ拡張経験"));

		if (!data.get("Ａ拡張経験").equals(""))
			expMap.put("Ａ拡張経験", data.get("Ａ拡張経験"));

		if (!data.get("緊縛経験").equals(""))
			expMap.put("緊縛経験", data.get("緊縛経験"));

		if (!data.get("キス経験").equals(""))
			expMap.put("キス経験", data.get("キス経験"));

		if (!data.get("口淫経験").equals(""))
			expMap.put("口淫経験", data.get("口淫経験"));

		if (!data.get("膣内射精経験").equals(""))
			expMap.put("膣内射精経験", data.get("膣内射精経験"));

		if (!data.get("口内射精経験").equals(""))
			expMap.put("口内射精経験", data.get("口内射精経験"));

		if (!data.get("Ｖ性交経験").equals(""))
			expMap.put("Ｖ性交経験", data.get("Ｖ性交経験"));

		if (!data.get("異常経験").equals(""))
			expMap.put("異常経験", data.get("異常経験"));

		if (!data.get("出産経験").equals(""))
			expMap.put("出産経験", data.get("出産経験"));
		return new RelationProcess();
	}

}
