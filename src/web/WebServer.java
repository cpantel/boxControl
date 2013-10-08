package web;

import model.StateModel;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;

import controller.DefconController;

public class WebServer {

	public WebServer(String resourceBase, StateModel stateModel) {
		// Configure the http server 
		Server server = new Server();

		ServerConnector connector = new ServerConnector(server);
		connector.setPort(8080);
		server.addConnector(connector);

		// Resources 
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(true);
		resourceHandler.setWelcomeFiles(new String[] { 
				"index.html"
		}
				);

		resourceHandler.setResourceBase(resourceBase);
		ContextHandler resourceContext = new ContextHandler();
		resourceContext.setContextPath("/");
		resourceContext.setHandler(resourceHandler);


		// Post API
		PostHandler postHandler = new PostHandler(stateModel);
		ContextHandler postContext = new ContextHandler();
		postContext.setContextPath("/post");
		postContext.setHandler(postHandler);

		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[] { 
				resourceContext, postContext
			}
		);

		server.setHandler(contexts);


		// Start the server (finally)  

		try {
			server.start();
			//server.join();
		} 
		catch(Exception e) {
	//		println("Could not start http server. Reason: " + e.toString());
		};
	}
}