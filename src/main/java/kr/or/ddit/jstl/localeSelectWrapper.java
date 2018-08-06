package kr.or.ddit.jstl;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class localeSelectWrapper extends HttpServletRequestWrapper {

	private Map<String, String[]> map;
	
	public localeSelectWrapper(HttpServletRequest request) {
		super(request);
		
		map = new HashMap<String, String[]>(request.getParameterMap());
		
		String[] relocales = map.get("locale");
		
		if (relocales == null || relocales[0].equals("")) {
			map.put("locale", new String[]{"en"});
		}
		
	}

	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(values != null){
			return values[0];
		}else{
			return null;
		}
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return map;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(map.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return map.get(name);
	}

}
