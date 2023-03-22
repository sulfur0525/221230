package controller.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Api1
 */
@WebServlet("/api1")
public class Api1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Api1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=VAjbISBzhA5OmOUrnx%2BqeksQLAiZxxCLBVh%2FruRkyG8Hzbt9xDhy7GPtvhcv229EijQ6LopwdnZTD3XMF01jQw%3D%3D");
		
		InputStreamReader reader = new InputStreamReader(url.openStream(),"UTF-8");
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		
			char[] array = new char[100000];
		
		reader.read(array);
		String result = bf.readLine();
		
		System.out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
