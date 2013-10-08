package web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Verifier;
import model.StateModel;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;


import model.Verifier;

public class PostHandler extends AbstractHandler {
	StateModel stateModel;
	public PostHandler(StateModel defcon) {
		this.stateModel = defcon;
		// TODO Auto-generated constructor stub
	}

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");

		String stringParameter = request.getParameter("string");

		/* Check if the string parameter is there and not empty */
		if (stringParameter != null && !stringParameter.trim().equals("")) {

			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			
			response.getWriter().println(Verifier.verify(stringParameter, stateModel.isRunning() ));

			//  println("Received a string via /post: " + stringParameter);

			//printCard(stringParameter);
		} 
		else {
			// Parameter is missing
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST );
			baseRequest.setHandled(true);
			response.getWriter().println("<h1>Error: Missing string parameter</h1>");

			//   println("Missing string via /post.");
		}
	}
}
