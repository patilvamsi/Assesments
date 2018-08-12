package org.monsanto.recipemanager.configuration;

public class RecipeManagerInitializer /*implements WebApplicationInitializer */{

	/*@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RecipeManagerConfiguration.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));

		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(RecipeManagerConfiguration.class);

		ServletRegistration.Dynamic resourceDispatcher = servletContext.addServlet("default","org.apache.catalina.servlets.DefaultServlet");
		resourceDispatcher.setLoadOnStartup(1);
		resourceDispatcher.addMapping("/resources/**");

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(2);
		dispatcher.addMapping("/*");

	}*/

}
