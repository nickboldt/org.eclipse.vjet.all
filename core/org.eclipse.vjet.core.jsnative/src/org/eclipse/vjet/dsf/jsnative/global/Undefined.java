package org.eclipse.vjet.dsf.jsnative.global;

import org.eclipse.vjet.dsf.jsnative.anno.Dynamic;
import org.eclipse.vjet.dsf.jsnative.anno.JsSupport;
import org.eclipse.vjet.dsf.jsnative.anno.JsVersion;

/**
 * 
 * Represents JavaScript native Number object
 *
 */
@JsSupport( {JsVersion.MOZILLA_ONE_DOT_ONE, JsVersion.JSCRIPT_ONE_DOT_ZERO})
@Dynamic
public interface Undefined extends Object {

}
