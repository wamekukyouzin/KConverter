package loader.koihimeConverter.wameku;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CharaData {
	private String number;
	private String name;
	private String callName;
	private LinkedHashMap<String,String> baseMap = new LinkedHashMap<>();
	private LinkedHashMap<String,String> ablMap = new LinkedHashMap<>();
	private LinkedHashMap<String,String> talentMap = new LinkedHashMap<>();
	private LinkedHashMap<String,String> expMap = new LinkedHashMap<>();
	private LinkedHashMap<String,String> relationMap = new LinkedHashMap<>();
	private LinkedHashMap<String,String> cstrMap = new LinkedHashMap<>();
	private int slgTalentValue = 0;
	//EntrySet使ってぶん回すの前提 getでアクセスとかは考えてない
	private LinkedHashMap<String,LinkedHashMap<String,String>> mapMap = new LinkedHashMap<>();

	CharaData() {
		mapMap.put("CSTR",cstrMap);
		mapMap.put("基礎",baseMap);
		mapMap.put("素質",talentMap);
		mapMap.put("能力",ablMap);
		mapMap.put("経験",expMap);
		mapMap.put("相性", relationMap);
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCallName() {
		return callName;
	}
	public void setCallName(String callName) {
		this.callName = callName;
	}
	public LinkedHashMap<String, String> getBaseMap() {
		return baseMap;
	}
	public void setBaseMap(LinkedHashMap<String, String> baseMap) {
		this.baseMap = baseMap;
	}
	public LinkedHashMap<String, String> getAblMap() {
		return ablMap;
	}
	public void setAblMap(LinkedHashMap<String, String> ablMap) {
		this.ablMap = ablMap;
	}
	public LinkedHashMap<String, String> getTalentMap() {
		return talentMap;
	}
	public void setTalentMap(LinkedHashMap<String, String> talentMap) {
		this.talentMap = talentMap;
	}
	public LinkedHashMap<String, String> getExpMap() {
		return expMap;
	}
	public void setExpMap(LinkedHashMap<String, String> expMap) {
		this.expMap = expMap;
	}
	public LinkedHashMap<String, String> getRelationMap() {
		return relationMap;
	}
	public void setRelationMap(LinkedHashMap<String, String> relationMap) {
		this.relationMap = relationMap;
	}
	public LinkedHashMap<String, String> getCstrMap() {
		return cstrMap;
	}
	public void setCstrMap(LinkedHashMap<String, String> cstrMap) {
		this.cstrMap = cstrMap;
	}
	public int getSlgTalentValue() {return slgTalentValue;}
	public void setSlgTalentValue(int slgTalentValue) {this.slgTalentValue = slgTalentValue;}

	public String createCSVFileName() {
		return "Chara" + number + " " + name + ".csv";
	}

	public String createCSV() {
		String sep = System.getProperty("line.separator");
		WritingStringBuffer sb = new WritingStringBuffer();
		sb.append("番号," + number);
		sb.append("名前," + name);
		sb.append("呼び名," + callName);
		//外側ループ。mapMapのエントリーセットを取得し、key項目名value対応マップでぶん回す
		Set<Entry<String, LinkedHashMap<String, String>>> outerSet = mapMap.entrySet();
		Iterator<Entry<String, LinkedHashMap<String, String>>> outerIt = outerSet.iterator();
		while (outerIt.hasNext()) {
			sb.append("");
			//Key = 素質とかの大まかな分類（書き込み時の「能力」とかにも利用）	Value = 対応するマップ
			Entry<String, LinkedHashMap<String, String>> clauseAndMap = outerIt.next();
			String clause = (String) clauseAndMap.getKey();
			//内側ループ。各対応マップのEntrySetを取得してぶん回し、clause,key,valueの形で書き込む
			LinkedHashMap<String, String> clauseMap = (LinkedHashMap<String,String>) clauseAndMap.getValue();
			Set<Entry<String,String>> innerSet = clauseMap.entrySet();
			Iterator<Entry<String,String>> innerIt = innerSet.iterator();
			while(innerIt.hasNext()) {
				Entry<String,String> keyValue = innerIt.next();
				String key = keyValue.getKey();
				String value = keyValue.getValue();
				sb.append(clause + "," + key + "," + value);
			}
		}
		return sb.toString();
	}



}
