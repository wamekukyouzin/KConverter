package process.koihimeConverter.wameku;

import java.util.HashMap;
import java.util.LinkedHashMap;

import loader.koihimeConverter.wameku.CharaData;

public class NameProcess extends Process {

	@Override
	public Process action(CharaData chara, HashMap<String, String> data) {
		String firstName = data.get("名前");
		String familyName = data.get("名字");
		String firstNameK = data.get("名前カナ");
		String familyNameK = data.get("名字カナ");
		String adana = data.get("愛称");
		String specie = data.get("種族");
		chara.setName(firstName);
		chara.setCallName(firstName);
		LinkedHashMap<String,String> cstrMap = chara.getCstrMap();
		if (!familyName.equals(firstName)) {
			cstrMap.put("0", familyName);
		}
		cstrMap.put("1", firstName);
		// 字は不要なのでコメントアウト　cstrMap.put("2", firstName);
		cstrMap.put("3", firstNameK);
		cstrMap.put("4", firstNameK);
		if (!familyName.equals(firstName)) {
			cstrMap.put("5", familyNameK);
		}
		cstrMap.put("6", firstNameK);
		cstrMap.put("7", firstNameK);
		cstrMap.put("8", specie);
		if (!adana.equals("")) {
			cstrMap.put("98", adana);
		}
		cstrMap.put("99", firstName);
		return new BaseProcess();
	}

}
