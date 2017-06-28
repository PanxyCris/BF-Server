package serviceImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;


import service.UserService;

public class UserServiceImpl implements UserService{
  
	
	@Override
	public boolean login(String username, String password) throws RemoteException {
		String name = username+"_"+password;
	    File file = new File("E:\\软件工程与计算Ⅰ\\大作业\\userinformation\\list.txt");
	    try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = null;
			
			while((line =reader.readLine())!=null)
				if(line.equals(name)){
					reader.close();
					return true;
				}
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;

   
		
	}
	
	@Override
	public boolean register(String username, String password) throws RemoteException{
		StringBuffer str = new StringBuffer();
		String name = username+"_"+password;
		try{
	   File file = new File("E:\\软件工程与计算Ⅰ\\大作业\\userinformation\\list.txt");
	   FileReader fileReader = new FileReader(file);
	   BufferedReader reader = new BufferedReader(fileReader);
	   
	   String line =null;
	   while((line = reader.readLine())!=null){
		   if(line.equals(name)){
			   reader.close();
			   return false;
		   }
		   str.append(line);
		   str.append("\n");
	   }
	      reader.close();
	      BufferedWriter rw = new BufferedWriter(new FileWriter(file));
	      rw.write(str.toString());
	      rw.write(name);
	      rw.write("\n");
	      rw.close();
	      
		}catch(IOException e){
			e.printStackTrace();
		}
		
			return true;
		
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		File file = new File("E:\\软件工程与计算Ⅰ\\大作业\\userinformation\\store.txt");
		file.delete();
		return true;
	}

	@Override
	public void store(String username) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			BufferedWriter rw = new BufferedWriter(new FileWriter("E:\\软件工程与计算Ⅰ\\大作业\\userinformation\\store.txt"));
			rw.write(username);
			rw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void storedocument(String information) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			BufferedWriter rw = new BufferedWriter(new FileWriter("E:\\软件工程与计算Ⅰ\\大作业\\userinformation\\name.txt"));
			rw.write(information);
			rw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
