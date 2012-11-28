/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.vsf.jsref;

import java.util.HashMap;
import java.util.Map;



import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.common.statistics.DarwinStatisticsCtxHelper;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.vsf.jsruntime.BoolWrapper;
import org.eclipse.vjet.vsf.jsruntime.JsObjectRefWrapper;
import org.eclipse.vjet.vsf.jsruntime.compregistry.JsComponentRegistry;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.dsf.spec.component.ISpecBasedComponent;
import org.eclipse.vjet.vsf.jsref.ctx.ResourceCtx;
import org.eclipse.vjet.vsf.jsref.internals.BV;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.internals.Params;

public class JsObj implements ISpecBasedComponent, IJsObjectRef,
        IValueBinding<Object> {
    private static final long serialVersionUID = 1L;
    private final JsCmpMeta m_cmpMeta;
    private final Params m_params;
    // private final boolean m_isPrototypical;
    private final boolean m_isInstance;
    // private String m_jsScopedVarRef = JsComponentRegistry.JSVAR_OREGISTRY;
    private String m_instanceId;
    private boolean m_genAsHandler;
    private boolean m_genned;

    private Map<String, JsPropSetter> m_instanceProps;

//    public JsObj(JsCmpMeta cmpMeta, Object... args) {
//        this(cmpMeta, false, args);
//    }

    public JsObj(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        m_cmpMeta = cmpMeta;
        m_isInstance = isInstance;
        // register component

        if (isInstance) {
            ResourceCtx.ctx().register(cmpMeta.getSpec());
            m_instanceId = JsRuntimeCtx.ctx().registerComponent(this);
        } else {
            // should I be registering static in instance registry?
            m_instanceId = null;
        }
        m_params = new Params(args);

        // V4 VI Javascript statistics (usage tracking)
        DarwinStatisticsCtxHelper.countJsStatistics(m_cmpMeta.getCmpName());
    }

    public static void addResourceSpec(IComponentSpec spec) {
        ResourceCtx.ctx().register(spec);
    }

    /**
     * 
     * @return
     */
    public String generate() {
        return generate(false);
    }

    public String generate(boolean withRegistry) {
        if (!m_isInstance) {
            return "";
        }
        // if (m_genned && !withRegistry) {
        // return getVariableRef();
        // }
        m_genned = true;

        if (!withRegistry) {
            return getInstantiationJs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getJsScopedVarRef()).append(".put('").append(getInstanceId())
                .append("', ").append(getInstantiationJs()).append(");");
        return sb.toString();
    }

    /**
     * @use getInstantiationJs
     * @return
     */

    @Deprecated
    public String getInstanceJsWithOutRegistration() {
        return getInstantiationJs();
    }

    public String getInstantiationJs() {
        m_genned = true;
        StringBuffer sb = new StringBuffer();
        sb.append("new ").append(m_cmpMeta.getCmpName()).append("(").append(
                m_params.genArgs()).append(")");
        return sb.toString();
    }

    /**
     * get Js object from registry,global variable object.get(id)
     * 
     * @return
     */
    public String getRefJs() {
        return getRefJs(getJsScopedVarRef());
    }

    /**
     * get Js object from registry,global variable object.get(id)
     * 
     * @return
     */
    public String getRefJs(String scopeVar) {
        if (scopeVar == null) {
            scopeVar = getJsScopedVarRef();
        }
        // if (m_cmpMeta.isStatic()) {
        // return m_cmpMeta.getCmpName();
        // }
        if (!m_isInstance) {
            return m_cmpMeta.getCmpName();
        }
        // if (m_isInstance) {
        // return m_cmpMeta.getCmpName() + ".prototype";
        // }
        String key = getInstanceId();
        StringBuilder sb = new StringBuilder();
        sb.append(scopeVar);
        if (JsComponentRegistry.isValidKey(key)) {
            // _ is being added to id in Registry.js. this must match
            sb.append("._").append(key);
        } else {
            sb.append(".get('").append(key).append("')");
        }

        return sb.toString();
    }

    public JsCmpMeta getCmpMeta() {
        return m_cmpMeta;
    }

    public Params getParams() {
        return m_params;
    }

    // public String getReservedName() {
    // return null;
    // }

    public Object getValue() {
        throw new DsfRuntimeException("Not supported");
    }

    public Class<Object> getValueType() {
        throw new DsfRuntimeException("Not supported");
    }

    public void setValue(Object value) {
        throw new DsfRuntimeException("Not supported");
    }

    public String getVariableRef() {
        return getRefJs();
    }

    public String getJsScopedVarRef() {
        return JsRuntimeCtx.ctx().getCompRegistry().getRegistryVar();
    }

    // public void setJsScopedVarRef(String jsScopedVarRef) {
    // m_jsScopedVarRef = jsScopedVarRef;
    // }

    public IComponentSpec getCompSpec() {
        return getCmpMeta().getSpec();
    }

    public String getInstanceId() {
        return m_instanceId;
    }

    protected void registerToOptimizer() {
        // JsRuntimeCtx.ctx().getOptimizer().add(this);
    }

    protected JsPropSetter addInstancePropSetter(JsPropSetter prop) {
        getInstancePropSetters().put(prop.getName(), prop);
        return prop;
    }

    public String setInstanceId(String instanceId) {
        // JsObj ref =
        // (JsObj)JsRuntimeCtx.ctx().getCompRegistry().getJsObject(this.m_instanceId);
        // if(ref!=null){
        // JsRuntimeCtx.ctx().getCompRegistry().remove(ref.getInstanceId());
        // JsRuntimeCtx.ctx().getCompRegistry().add(instanceId, this);
        // }
        // JsRuntimeCtx.ctx().getCompRegistry().renameRef(instanceId, this);
        m_instanceId = instanceId;
        return m_instanceId;
    }

    public String getInstancePropertySetters() {
        StringBuilder b = new StringBuilder();
        for (JsPropSetter s : getInstancePropSetters().values()) {
            b.append(s.generate());
        }
        return b.toString();
    }

    private Map<String, JsPropSetter> getInstancePropSetters() {
        if (m_instanceProps == null) {
            m_instanceProps = new HashMap<String, JsPropSetter>();
        }
        return m_instanceProps;
    }

    public boolean isInstance() {
        return m_isInstance;
    }

    // New from Oak2
    //
    // Set property
    //
    /**
     * Set the instance property based on the calling methods name with the
     * supplied value
     * 
     * @param value
     * @return
     */
    protected IJsPropSetter setProp(Object value) {
        return setProp(getCallingName(), value);
    }

    /**
     * Set the instance property based on the passed in name with the supplied
     * value
     * 
     * @param name
     * @param value
     * @return
     */
    @SuppressWarnings("unchecked")
    protected IJsPropSetter setProp(String name, Object value) {
        assertName(name, "Property name must not be empty or null");
        assertValue(value, "Property value must not be null");

        IValueBinding<?> vbValue;
        if (value instanceof IValueBinding<?>) {
            vbValue = (IValueBinding<?>) value;
        } else {
            Class clz = value.getClass();
            vbValue = BV.bind(clz, value);
        }
        return addInstancePropSetter(new JsPropSetter(this, name, vbValue));
    }

    /**
     * Set the static property based on the calling methods name with the
     * supplied value
     * 
     * @param info
     * @param value
     * @return
     */
    protected static IJsPropSetter setProp(JsObjData info, Object value) {
        return setProp(info, getCallingName(), value);
    }

    /**
     * Set the static property based on the passed in name with the supplied
     * value
     * 
     * @param info
     * @param name
     * @param value
     * @return
     */
    @SuppressWarnings("unchecked")
    protected static <T> IJsPropSetter setProp(JsObjData info, String name,
            Object value) {
        assertName(name, "Property name must not be empty or null");
        assertValue(value, "Property value must not be null");
        IValueBinding<?> vbValue;
        if (value instanceof IValueBinding<?>) {
            vbValue = (IValueBinding<?>) value;
        } else {
            Class clz = value.getClass();
            vbValue = BV.bind(clz, value);
        }
        return new JsPropSetter(info.getStaticAnchor(), name, vbValue);
    }

    //
    // Get property
    //
    /**
     * Answer the returnType typed instance property reference based on the
     * calling methods name
     * 
     * @param <T>
     * @param returnType
     * @return
     */
    protected <T> JsProp<T> getProp(Class<T> returnType) {
        return getProp(returnType, getCallingName());
    }

    /**
     * Answer the returnType typed instance property reference based on the
     * passed in name
     * 
     * @param <T>
     * @param returnType
     * @param name
     * @return
     */
    protected <T> JsProp<T> getProp(Class<T> returnType, String name) {
        assertName(name, "Property name must not be empty or null");
        return new JsProp<T>(this, name);
    }

    /**
     * Answer the returnType typed static property reference based on the
     * calling methods name
     * 
     * @param <T>
     * @param info
     * @param returnType
     * @return
     */
    protected static <T> JsProp<T> getProp(JsObjData info, Class<T> returnType) {
        return getProp(info, returnType, getCallingName());
    }

    /**
     * Answer the returnType typed static property reference based on the passed
     * in name
     * 
     * @param <T>
     * @param info
     * @param returnType
     * @param name
     * @return
     */
    protected static <T> JsProp<T> getProp(JsObjData info, Class<T> returnType,
            String name) {
        assertName(name, "Property name must not be empty or null");
        return new JsProp<T>(info.getStaticAnchor(), name);
    }

    //
    // Method API's
    //
    /**
     * Call the instance method based on the calling methods name
     * 
     * @return
     */
    public JsFunc<Void> call() {
        return _call(this, Void.class, getCallingName());
    }

    /**
     * Call the instance method based on the passed in method name
     * 
     * @param name
     * @return
     */
    public JsFunc<Void> call(final String name) {
        return _call(this, Void.class, name);
    }

    /**
     * 
     * @param <T>
     * @param returnType
     * @return
     */
    public <T> JsFunc<T> call(final Class<T> returnType) {
        return _call(this, returnType, getCallingName());
    }

    /**
     * 
     * @param <T>
     * @param returnType
     * @param name
     * @return
     */
    public <T> JsFunc<T> call(final Class<T> returnType, final String name) {
        return _call(this, returnType, name);
    }

    /**
     * 
     * @param data
     * @return
     */
    public static JsFunc<Void> call(final JsObjData data) {
        return _call(data, Void.class, getCallingName());
    }

    // public static JsFunc1<Void> call(final JsObjData data) {
    // return _call(data, Void.class, getCallingName()) ;
    // }
    // public static JsFunc2<Void> call(final JsObjData data) {
    // return _call(data, Void.class, getCallingName()) ;
    // }
    // public static JsFunc3<Void> call(final JsObjData data) {
    // return _call(data, Void.class, getCallingName()) ;
    // }
    // public static JsFunc4<Void> call(final JsObjData data) {
    // return _call(data, Void.class, getCallingName()) ;
    // }

    /**
     * 
     * @param data
     * @param name
     * @return
     */
    public static JsFunc<Void> call(final JsObjData data, final String name) {
        return _call(data, Void.class, name);
    }

    public static <T> JsFunc<T> call(final JsObjData data,
            final Class<T> returnType) {
        return _call(data, returnType, getCallingName());
    }

    /**
     * 
     * @param <T>
     * @param data
     * @param returnType
     * @param name
     * @return
     */
    public static <T> JsFunc<T> call(final JsObjData data,
            final Class<T> returnType, final String name) {
        return _call(data, returnType, name);
    }

    //
    // Private
    //
    private static <T> JsFunc<T> _call(JsObj env, // this for instance,
                                                    // getInstance() for static
            Class<T> type, String name) {
        // assertTypeNotNull(type) ;
        assertMethodName(name);
        return new JsFunc<T>(env, name, false, hasReturn(type));
    }

    // private static JsFunc1<T> _call(
    // JsObj env, // this for instance, getInstance() for static
    // Class<T> type,
    // String name)
    // {
    // assertTypeNotNull(type) ;
    // assertMethodName(name) ;
    // return new JsFunc1<T>(env, name, false, hasReturn(type)) ;
    // }
    // private static JsFunc2<T> _call(
    // JsObj env, // this for instance, getInstance() for static
    // Class<T> type,
    // String name)
    // {
    // assertTypeNotNull(type) ;
    // assertMethodName(name) ;
    // return new JsFunc2<T>(env, name, false, hasReturn(type)) ;
    // }
    // private static JsFunc3<T> _call(
    // JsObj env, // this for instance, getInstance() for static
    // Class<T> type,
    // String name)
    // {
    // assertTypeNotNull(type) ;
    // assertMethodName(name) ;
    // return new JsFunc3<T>(env, name, false, hasReturn(type)) ;
    // }
    // private static JsFunc4<T> _call(
    // JsObj env, // this for instance, getInstance() for static
    // Class<T> type,
    // String name)
    // {
    // assertTypeNotNull(type) ;
    // assertMethodName(name) ;
    // return new JsFunc4<T>(env, name, false, hasReturn(type)) ;
    // }

    private static void assertMethodName(String name) {
        if (name == null || name.trim().equals("")) {
            chuck("Method name must not be empty String or null");
        }
    }

//  private static void assertTypeNotNull(Class type) {
//      if (type == null) {
//          chuck("Type must not be null");
//      }
//  }

    // Call a static method
    private static <T> JsFunc<T> _call(JsObjData data, Class<T> type,
            String name) {
        assertName(name, "Property name must not be empty or null");

        return new JsFunc<T>(data.getStaticAnchor(), name, false,
                hasReturn(type));
    }

    public static boolean hasReturn(Class clz) {
        return Void.class != clz;
    }

    private static String getCallingName() {
        // back 2 for call(...)
        // back 3 for _call(...)
        // back 4 for the user method
        return Thread.currentThread().getStackTrace()[4].getMethodName();
    }

    private static void assertValue(Object value, String msg) {
        if (value == null) {
            chuck(msg);
        }
    }

    private static void assertName(String name, String msg) {
        if (name == null || name.trim().equals("")) {
            chuck(msg);
        }
    }

    private static void chuck(String msg) {
        throw new DsfRuntimeException(msg);
    }

    // New from Oak2

    public boolean isHandler() {
        return m_genAsHandler;
    }

    public void setIsHandler(boolean value) {
        m_genAsHandler = value;
    }

    public boolean isGenned() {
        return m_genned;
    }

    public String getClassName() {
        return m_cmpMeta.getCmpName();
    }

    /**
     * @see #wrap(Boolean)
     * @param arg
     * @return
     */
    protected static BoolWrapper wrapS(Boolean arg) {
        return new BoolWrapper(arg);
    }

    
    /**
     * keep the Boolean object to maintain the three states true, false, and null.
     * It is preferred that developer uses little boolean over Boolean. Since Boolean
     * object introduces another state as well as you can not reference Boolean like a literal when passed
     * as an argument.
     * @param arg
     * @return
     */
    protected BoolWrapper wrap(Boolean arg) {
        return new BoolWrapper(arg);
    }

    
    /**
     * check will determine if a null value is being passed into a boolean value binding when there should 
     * only be true and false states.
     * @param arg
     * @return
     */
    protected static IValueBinding<? extends Boolean> checkS(
            IValueBinding<? extends Boolean> arg) {
        if (arg == null && JsRuntimeCtx.ctx().runTimeTypeCheck()) {
            // TODO based on policy
            throw new DsfRuntimeException(
                    "argument can not be null for boolean");
        }
        return arg;
    }

    /**
     * check will determine if a null value is being passed into a boolean value binding when there should 
     * only be true and false states.
     * @param arg
     * @return
     */
    protected IValueBinding<? extends Boolean> check(
            IValueBinding<? extends Boolean> arg) {
        return JsObj.checkS(arg);
    }

    /**
     * Wrap an array of object references to prevent confusion between vararg.
     * 
     * @param psKey
     * @return
     */

    protected JsObjectRefWrapper wrap(IJsObjectRef[] psKey) {
        return wrapS(psKey);
    }

    /**
     * Wrap an array of object references to prevent confusion between vararg.
     * 
     * @param psKey
     * @return
     */
    protected static JsObjectRefWrapper wrapS(IJsObjectRef[] psKey) {
        return new JsObjectRefWrapper(psKey);
    }

    // public static IJsPropSetter addStaticPropSetter(JsPropSetter setter) {
    // JsRuntimeCtx.ctx().addStaticPropSetter(setter);
    // return setter;
    // }

}