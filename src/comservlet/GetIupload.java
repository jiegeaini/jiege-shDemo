package comservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fly.music.util.Upload;

/**
 * Servlet implementation class GetIupload
 */
@WebServlet("/GetIupload")
public class GetIupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIupload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("haha");
		ServletInputStream sin = request.getInputStream();
			String path = request.getRealPath("/") + "../";
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd-HH-mm-ss");
			String as = format.format(date).toString();
				try {
					System.out.println(Upload.upload(as, path, sin));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}


}
