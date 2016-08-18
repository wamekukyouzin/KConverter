package process.koihimeConverter.wameku;

import java.util.HashMap;

import loader.koihimeConverter.wameku.CharaData;

public abstract class Process {
	public abstract Process action(CharaData chara, HashMap<String,String> data);
}
