package process.koihimeConverter.wameku;

import java.util.HashMap;
import java.util.LinkedHashMap;

import loader.koihimeConverter.wameku.CharaData;

public class BaseProcess extends Process {

	@Override
	public Process action(CharaData chara, HashMap<String, String> data) {
		String physical = data.get("体力");
		String willPower = data.get("気力");
		String mental = data.get("精神力");
		LinkedHashMap<String, String> baseMap = chara.getBaseMap();
		baseMap.put("体力", physical);
		baseMap.put("気力", willPower);
		baseMap.put("精神力", mental);

		return new AblProcess();
	}

}
