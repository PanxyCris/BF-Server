package serviceImpl;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import service.IOService;

public class IOServiceImpl implements IOService{
	
	
	
	@Override
	public boolean writeFile(String file, String userId, String code) {
	
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("E:\\软件工程与计算Ⅰ\\大作业\\BF\\"+file+"_"+userId));
			fw.write(code);
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return true;
	}

	@Override
	public String readFile(String userId, String fileName) {
		// TODO Auto-generated method stub
	     File path=new File(userId+"_"+fileName);
	     try {
			FileReader rw=new FileReader(path);
			try {
				rw.read();
				rw.close();
				return rw.toString();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileName;
	
	}

	@Override
	public String readFileList(String userId) {
		// TODO Auto-generated method stub
		StringBuffer str=new StringBuffer();
		try{

		FileReader fileReader=new FileReader(userId);
		
		BufferedReader reader=new BufferedReader(fileReader);
		
		String line=null;
		
		while((line=reader.readLine())!=null){
				str.append(line);
				str.append("\n");
		}
		reader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return str.toString();
	}

	
}
