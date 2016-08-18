package process.koihimeConverter.wameku;

import java.util.HashMap;
import java.util.LinkedHashMap;

import loader.koihimeConverter.wameku.CharaData;

public class RelationProcess extends Process {

	@Override
	public Process action(CharaData chara, HashMap<String, String> data) {
		LinkedHashMap<String,String> relationMap = chara.getRelationMap();
		String[] relations = data.get("相性").split("/");
		for(String relation:relations) {
			String[] keyValue = relation.split("=");
			if (keyValue.length != 2) {
				System.out.println(chara.getName() + "のrelation設定ミス(relationが空でも出ます)");
				continue;
			}
			relationMap.put(keyValue[0], keyValue[1]);
		}
		return null;
	}

}
