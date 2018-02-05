package spms.vo;


public class Script {
	public static String scriptOut(String alert, String url) {
		 return "<script language='javascript'>" 
				 + "alert('" + alert  + "');"  
				 + "location.replace('" + url + "');"
				 + "</script>";
	}
}
