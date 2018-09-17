package iseries.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

//novo teste jenkis
	public static void salvarImagem(String path, MultipartFile imagem){
		File file = new File(path);
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
			System.out.println("Salvo em: "+ file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
