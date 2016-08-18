package process.koihimeConverter.wameku;

import java.util.HashMap;

import loader.koihimeConverter.wameku.CharaData;

public class InitProcess extends Process {

	@Override
	public Process action(CharaData chara, HashMap<String, String> data) {
		chara.setNumber(data.get("番号"));
		//霖之助と妖忌に「オトコ」を、それ以外に女を設定する。
		//もう名前で振り分けたんでいいや。
		String firstName = data.get("名前");
		if (firstName.equals("霖之助") || firstName.equals("妖忌") || firstName.equals("雲山") || firstName.equals("玄爺") || firstName.equals("月の門番") || firstName.equals("易者"))
			chara.getTalentMap().put("性別", "0");
		else {
			chara.getTalentMap().put("性別", "1");
		}
		return new NameProcess();
	}

}
