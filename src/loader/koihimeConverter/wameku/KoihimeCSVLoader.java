package loader.koihimeConverter.wameku;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

import process.koihimeConverter.wameku.InitProcess;
import process.koihimeConverter.wameku.Process;

public class KoihimeCSVLoader {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("引数の数が異常です");
			System.exit(1);
		}
		KoihimeCSVLoader kcl = new KoihimeCSVLoader();
		kcl.doIt(args[0]);
	}

	public void doIt(String arg) {
		Scanner scanner;
		try {
			Path path = Paths.get(arg);
			scanner = new Scanner(new File(path.toString()));
			//インデックスと項目名の対応表
			HashMap<Integer,String> columnMap = new HashMap<>();
			//一行目のみアレする用の
			boolean first = true;
			//tsvの全行回す
			while (scanner.hasNextLine()) {
				//まずは読んできて分ける
				String read = scanner.nextLine();
				String data[] = read.split("\t", -1);

				//一行目では「インデックスと項目名」「項目名とCSVに吐き出される文言」の対応表を作成する
				if (first) {
					for (int i = 0; i< data.length; i++) {
						columnMap.put(i, data[i]);
					}
					first = false;
					continue;
				}

				//項目名と実際にtsvに書かれたデータの対応表
				HashMap<String,String> charaDataMap = new HashMap<>();

				//--------ここからdataの下準備--------
				for (int i = 0; i < data.length; i++) {
					charaDataMap.put(columnMap.get(i), data[i]);
				}
				//--------dataの下準備ここまで--------

				//--------ここからCharaData作成処理--------
				CharaData charaData = new CharaData();
				Process process = new InitProcess();
				while(process != null) {
					process = process.action(charaData,charaDataMap);
				}
				//--------CharaData作成処理ここまで--------

				//--------書き込み処理処理--------
				FileOutputStream fos = new FileOutputStream(new File(path.getParent().toString() +"/"+ charaData.createCSVFileName()));
				try {
					//emueraはBOMを必要とする
					fos.write(0xef);
					fos.write(0xbb);
					fos.write(0xbf);
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(fos));
				printWriter.write(charaData.createCSV());
				printWriter.close();
				//--------書き込み処理ここまで--------

			}
			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.print("そんなファイルない");
			System.exit(1);
		}
	}
}
