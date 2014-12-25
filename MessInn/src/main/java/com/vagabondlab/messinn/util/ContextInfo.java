package com.vagabondlab.messinn.util;

import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class provide Context Information. Also the class contains some of common functionality for manage the application
 * @author Shaiful Islam palash | <kuvic16@gmail.com>
 * @since version 0.0.1
 */
public class ContextInfo {

    public static String contextPath;
    public static String contextReqPath;
    public static String contextRealPath;
    protected FacesContext facesContext = null;
    public static final String jstlBundleParam = "javax.servlet.jsp.jstl.fmt.localizationContext";

    public ContextInfo() {
    }

    public String getContextReqPath() {
        if (contextPath == null) {
            contextPath = this.getFacesContext().getExternalContext().getRequestContextPath();
        }
        return contextPath;
    }

    public static String getContextPath() {
        return contextPath;
    }

    public static void setContextPath(String contextPath) {
        ContextInfo.contextPath = contextPath;
    }

    /**
     * @return the contextRealPath
     */
    public static String getContextRealPath() {
        return contextRealPath;
    }

    /**
     * @param contextRealPath the contextRealPath to set
     */
    public static void setContextRealPath(String path) {
        contextRealPath = path;
    }

    /**
     * Set the face context to the class scope.
     * 
     * @param facesContext
     */
    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    /**
     * Return the face context
     * 
     * @return
     */
    public FacesContext getFacesContext() {
        if (facesContext != null) {
            return facesContext;
        }
        return FacesContext.getCurrentInstance();
    }

    /**
     * The the parameter value for HttpRequest
     * 
     * @param name
     * @return the parameter
     */
    public String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * Get name of resource bundle from JSTL settings
     * 
     * @return
     */
    public String getBundleName() {
        return getServletContext().getInitParameter(jstlBundleParam);
    }

    /**
     * Return resource bundles contain locale-specific objects. When program needs
     * a locale-specific resource.
     * 
     * @return
     */
    public ResourceBundle getBundle() {
        return ResourceBundle.getBundle(getBundleName(), getRequest().getLocale());
    }

    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }

    protected HttpSession getSession() {
        return getRequest().getSession();
    }

    protected HttpServletResponse getResponse() {
        return (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
    }

    public ServletContext getServletContext() {
        return (ServletContext) getFacesContext().getExternalContext().getContext();
    }
}
