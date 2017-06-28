//璇蜂笉瑕佷慨鏀规湰鏂囦欢鍚�
package serviceImpl;
import java.rmi.RemoteException;
import service.ExecuteService;
import service.UserService;
import java.util.ArrayList;

public class ExecuteServiceImpl implements ExecuteService {

	/**
	 * 璇峰疄鐜拌鏂规硶
	 */
	@Override
	public String execute(String code, String param) throws RemoteException {
		// TODO Auto-generated method stub
		 String result=null;
			StringBuffer str=new StringBuffer();
			char[] data=null;
			if(param!=null)
				data=param.toCharArray();
			
			char[] bf=new char[code.length()];
				for(int i=0;i<bf.length;i++)
					bf[i]=0;
			   
				int sign=0;//下标
				int index=0;//记录data下标
				ArrayList<Integer> numOfBracket=new ArrayList<>();//[]的个数中的值
				
	        if(code.substring(0,1).equals("O")){
	        	StringBuffer removeSpace=new StringBuffer();
	        	for(int i=0;i<code.length();i++)
	        		if(!code.substring(i,i+1).equals(" "))
	        			removeSpace.append(code.substring(i,i+1));
	        	String Ook=removeSpace.toString();
	        	String[] transfer=new String[Ook.length()/8];
	        	for(int i=0;i<transfer.length;i++)
	        		transfer[i]=Ook.substring(i*8, (i+1)*8);
	        	
	        	StringBuffer transferResult=new StringBuffer();
	        	for(int i=0;i<transfer.length;i++)
	        		switch(transfer[i]){
	        		case "Ook.Ook?":{transferResult.append(">");break;}
	        		case "Ook?Ook.":{transferResult.append("<");break;}
	        		case "Ook.Ook.":{transferResult.append("+");break;}
	        		case "Ook!Ook!":{transferResult.append("-");break;}
	        		case "Ook!Ook.":{transferResult.append(".");break;}
	        		case "Ook.Ook!":{transferResult.append(",");break;}
	        		case "Ook!Ook?":{transferResult.append("[");break;}
	        		case "Ook?Ook!":{transferResult.append("]");break;}
	        		}
	        	code=transferResult.toString();
	        }
				
			for(int count=0;count<code.length();count++){
				switch(code.substring(count,count+1)){
				case " ":{break;}
				case "+":{bf[sign]++;break;}
				case "-":{bf[sign]--;break;}
				case ">":{sign++;break;}
				case "<":{sign--;break;}
				case "[":{numOfBracket.add(count);break;}
				case "]":{
					      if(bf[sign]!=0){
					         count=numOfBracket.get(numOfBracket.size()-1);  
					      }
					      else 
					    	  numOfBracket.remove(numOfBracket.size()-1);    
					                       break;
				         }      
				case ".":{
					      if(bf[sign]>0)	
					         str.append(String.valueOf(bf[sign]));
					                     break;	
				         } 
				case ",":{
					       bf[sign]=data[index];
					       index++;
					                     break;
				         }
				     }
				
			}
			
			result=str.toString();
			return result;
		         
	}
}
