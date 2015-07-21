import static java.lang.System.out;

import java.io.*;
import org.apache.commons.lang3.*;

public class Main {
	public static void main(String[] args) throws IOException {
		String str, fileNotFound;
		int numfilter;
		boolean filter1, filter2; 
		/*
		out.print("Укажите путь к файлу: ");
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		File file = new File(reader.readLine());
		*/
		File file = new File("./first.txt");
		fileNotFound = String.format(file.exists() ? "Абсолютный путь: " + file.getAbsolutePath(): "Файл не найден"); 
		out.println(fileNotFound);
		
		out.println("Номер фильтра:");
		out.println("1 - на экране печатаются только те строки файла где нету слова Путин");
		out.println("2 - на экране печатаются только те строки файла где есть слова Путин, но нет слома Медведев");
		out.println("Нет номер - на экране печатаются все строки файла");
		out.println("Ваш выбор:");
		
		BufferedReader readfilter = new BufferedReader( new InputStreamReader(System.in));
		numfilter = System.in.read();
		
		try (BufferedReader fileread = new BufferedReader(new FileReader(file))) {
			do {
					str = fileread.readLine();
					filter1 = StringUtils.contains(str, "Путин");
					filter2 = StringUtils.contains(str, "Медведев");
					switch(numfilter) {
					case '1': 
						if(!filter1 && (str != null)) out.println(str);
						break;
					case '2':
						if(filter1 && !filter2 && (str != null)) out.println(str);
						break;
					default:
						if(str != null) out.println(str);
					}					
			}
			while(str != null);
		}
	}
}
