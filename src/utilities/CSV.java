package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {

	// 從CSV檔案讀取資料，並返回一個list
	public static List<String[]> read(String file) {
		List<String[]> data = new LinkedList<String[]>();
		// 因為要一直讀一直讀所以dataRaw放外面
		String dataRaw;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			while ((dataRaw = br.readLine()) != null) {
				String[] dataRecords = dataRaw.split(",");
				data.add(dataRecords);
			}
		} catch (FileNotFoundException e) {
			System.out.println("沒檔案啦～");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("無法讀檔案啦～");
			e.printStackTrace();
		}

		// 不過這樣就會變成讀完所有資料才處理，這樣不行，若是幾百萬筆資料不是吃記憶體就是當掉囉
		return data;

	}

}
