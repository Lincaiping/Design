package com.filter.charater;

import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@SuppressWarnings("rawtypes")
public class CharacterRequest extends HttpServletRequestWrapper {
    private Map params;

    public CharacterRequest(HttpServletRequest request, Map newParams) {
             super(request);
             this.params = newParams;
   }

    @SuppressWarnings("unchecked")
    public Map getParameterMap() {
             return params ;
   }

    @SuppressWarnings("unchecked")
    public Enumeration getParameterNames() {
             Vector vector = new Vector( params.keySet());
             return vector.elements();
   }

    public String[] getParameterValues(String name) {
            Object object = params.get(name);
             if (object == null ) {
                       return null ;
            } else if (object instanceof String[]) {
                      String[] value = (String[]) object;
                       for (int i = 0; i < value.length; i++) {
                               value[i] = value[i].replaceAll( "<", "&lt;" );
                               value[i] = value[i].replaceAll( ">", "&gt;" );
                      }
                       return (String[]) value;
            } else if (object instanceof String) {
                      String value = (String) object;
                      value = value.replaceAll( "<", "&lt;" );
                      value = value.replaceAll( ">", "&gt;" );
                       return new String[] { (String) value };
            } else {
                       return new String[] { object.toString() };
            }
   }

    public String getParameter(String name) {
            Object object = params.get(name);
             if (object == null ) {
                       return null ;
            } else if (object instanceof String[]) {
                      String[] strArr = (String[]) object;
                       if (strArr.length > 0) {
                               String value = strArr[0];
                               value = value.replaceAll( "<", "&lt;" );
                               value = value.replaceAll( "<", "&gt;" );
                                return value;
                      } else {
                                return null ;
                      }
            } else if (object instanceof String) {
                      String value = (String) object;
                      value = value.replaceAll( "<", "&lt;" );
                      value = value.replaceAll( ">", "&gt;" );
                       return (String) value;
            } else {
                       return object.toString();
            }
   }
}