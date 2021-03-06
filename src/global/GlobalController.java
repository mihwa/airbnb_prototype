package global;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/global.do")
public class GlobalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request, response);
		
		switch (Separator.command.getAction()) {
			case "helpcenter":
				DispatcherServlet.send(request, response, Separator.command);
				return;
		}
		DispatcherServlet.send2(request, response, Separator.command);
	}
}
