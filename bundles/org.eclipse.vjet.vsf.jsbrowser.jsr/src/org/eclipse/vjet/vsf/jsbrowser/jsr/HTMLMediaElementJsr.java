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
package org.eclipse.vjet.vsf.jsbrowser.jsr;
import java.util.Date;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.vsf.jsbrowser.jsr.ExclusiveTrackListJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.MediaControllerJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.MediaErrorJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.MultipleTrackListJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.MutableTextTrackJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.TextTrackJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.TimeRangesJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLMediaElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLMediaElement", HTMLMediaElementJsr.class, "HTMLMediaElement");

    public HTMLMediaElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLMediaElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<MediaErrorJsr> error(){
        return getProp(MediaErrorJsr.class, "error");
    }

    public IJsPropSetter error(MediaErrorJsr v) {
        return setProp("error", v);
    }

    public IJsPropSetter error(IValueBinding<? extends MediaErrorJsr> v) {
        return setProp("error", v);
    }

    public JsProp<String> src(){
        return getProp(String.class, "src");
    }

    public IJsPropSetter src(String v) {
        return setProp("src", v);
    }

    public IJsPropSetter src(IValueBinding<String> v) {
        return setProp("src", v);
    }

    public JsProp<String> currentSrc(){
        return getProp(String.class, "currentSrc");
    }

    public IJsPropSetter currentSrc(String v) {
        return setProp("currentSrc", v);
    }

    public IJsPropSetter currentSrc(IValueBinding<String> v) {
        return setProp("currentSrc", v);
    }

    public JsProp<Short> readyState(){
        return getProp(Short.class, "readyState");
    }

    public IJsPropSetter readyState(short v) {
        return setProp("readyState", v);
    }

    public IJsPropSetter readyState(IValueBinding<Short> v) {
        return setProp("readyState", v);
    }

    public JsProp<Short> networkState(){
        return getProp(Short.class, "networkState");
    }

    public IJsPropSetter networkState(short v) {
        return setProp("networkState", v);
    }

    public IJsPropSetter networkState(IValueBinding<Short> v) {
        return setProp("networkState", v);
    }

    public JsProp<String> preload(){
        return getProp(String.class, "preload");
    }

    public IJsPropSetter preload(String v) {
        return setProp("preload", v);
    }

    public IJsPropSetter preload(IValueBinding<String> v) {
        return setProp("preload", v);
    }

    public JsProp<TimeRangesJsr> buffered(){
        return getProp(TimeRangesJsr.class, "buffered");
    }

    public IJsPropSetter buffered(TimeRangesJsr v) {
        return setProp("buffered", v);
    }

    public IJsPropSetter buffered(IValueBinding<? extends TimeRangesJsr> v) {
        return setProp("buffered", v);
    }

    public JsProp<Boolean> seeking(){
        return getProp(Boolean.class, "seeking");
    }

    public IJsPropSetter seeking(boolean v) {
        return setProp("seeking", v);
    }

    public IJsPropSetter seeking(IValueBinding<Boolean> v) {
        return setProp("seeking", v);
    }

    public JsProp<Double> currentTime(){
        return getProp(Double.class, "currentTime");
    }

    public IJsPropSetter currentTime(double v) {
        return setProp("currentTime", v);
    }

    public IJsPropSetter currentTime(IValueBinding<Double> v) {
        return setProp("currentTime", v);
    }

    public JsProp<Double> initialTime(){
        return getProp(Double.class, "initialTime");
    }

    public IJsPropSetter initialTime(double v) {
        return setProp("initialTime", v);
    }

    public IJsPropSetter initialTime(IValueBinding<Double> v) {
        return setProp("initialTime", v);
    }

    public JsProp<Double> duration(){
        return getProp(Double.class, "duration");
    }

    public IJsPropSetter duration(double v) {
        return setProp("duration", v);
    }

    public IJsPropSetter duration(IValueBinding<Double> v) {
        return setProp("duration", v);
    }

    public JsProp<Date> startOffsetTime(){
        return getProp(Date.class, "startOffsetTime");
    }

    public IJsPropSetter startOffsetTime(Date v) {
        return setProp("startOffsetTime", v);
    }

    public IJsPropSetter startOffsetTime(IValueBinding<? extends Date> v) {
        return setProp("startOffsetTime", v);
    }

    public JsProp<Boolean> paused(){
        return getProp(Boolean.class, "paused");
    }

    public IJsPropSetter paused(boolean v) {
        return setProp("paused", v);
    }

    public IJsPropSetter paused(IValueBinding<Boolean> v) {
        return setProp("paused", v);
    }

    public JsProp<Double> defaultPlaybackRate(){
        return getProp(Double.class, "defaultPlaybackRate");
    }

    public IJsPropSetter defaultPlaybackRate(double v) {
        return setProp("defaultPlaybackRate", v);
    }

    public IJsPropSetter defaultPlaybackRate(IValueBinding<Double> v) {
        return setProp("defaultPlaybackRate", v);
    }

    public JsProp<Double> playbackRate(){
        return getProp(Double.class, "playbackRate");
    }

    public IJsPropSetter playbackRate(double v) {
        return setProp("playbackRate", v);
    }

    public IJsPropSetter playbackRate(IValueBinding<Double> v) {
        return setProp("playbackRate", v);
    }

    public JsProp<TimeRangesJsr> played(){
        return getProp(TimeRangesJsr.class, "played");
    }

    public IJsPropSetter played(TimeRangesJsr v) {
        return setProp("played", v);
    }

    public IJsPropSetter played(IValueBinding<? extends TimeRangesJsr> v) {
        return setProp("played", v);
    }

    public JsProp<TimeRangesJsr> seekable(){
        return getProp(TimeRangesJsr.class, "seekable");
    }

    public IJsPropSetter seekable(TimeRangesJsr v) {
        return setProp("seekable", v);
    }

    public IJsPropSetter seekable(IValueBinding<? extends TimeRangesJsr> v) {
        return setProp("seekable", v);
    }

    public JsProp<Boolean> ended(){
        return getProp(Boolean.class, "ended");
    }

    public IJsPropSetter ended(boolean v) {
        return setProp("ended", v);
    }

    public IJsPropSetter ended(IValueBinding<Boolean> v) {
        return setProp("ended", v);
    }

    public JsProp<Boolean> autoplay(){
        return getProp(Boolean.class, "autoplay");
    }

    public IJsPropSetter autoplay(boolean v) {
        return setProp("autoplay", v);
    }

    public IJsPropSetter autoplay(IValueBinding<Boolean> v) {
        return setProp("autoplay", v);
    }

    public JsProp<String> mediaGroup(){
        return getProp(String.class, "mediaGroup");
    }

    public IJsPropSetter mediaGroup(String v) {
        return setProp("mediaGroup", v);
    }

    public IJsPropSetter mediaGroup(IValueBinding<String> v) {
        return setProp("mediaGroup", v);
    }

    public JsProp<MediaControllerJsr> controller(){
        return getProp(MediaControllerJsr.class, "controller");
    }

    public IJsPropSetter controller(MediaControllerJsr v) {
        return setProp("controller", v);
    }

    public IJsPropSetter controller(IValueBinding<? extends MediaControllerJsr> v) {
        return setProp("controller", v);
    }

    public JsProp<Double> volume(){
        return getProp(Double.class, "volume");
    }

    public IJsPropSetter volume(double v) {
        return setProp("volume", v);
    }

    public IJsPropSetter volume(IValueBinding<Double> v) {
        return setProp("volume", v);
    }

    public JsProp<Boolean> muted(){
        return getProp(Boolean.class, "muted");
    }

    public IJsPropSetter muted(boolean v) {
        return setProp("muted", v);
    }

    public IJsPropSetter muted(IValueBinding<Boolean> v) {
        return setProp("muted", v);
    }

    public JsProp<Boolean> defaultMuted(){
        return getProp(Boolean.class, "defaultMuted");
    }

    public IJsPropSetter defaultMuted(boolean v) {
        return setProp("defaultMuted", v);
    }

    public IJsPropSetter defaultMuted(IValueBinding<Boolean> v) {
        return setProp("defaultMuted", v);
    }

    public JsProp<Boolean> controls(){
        return getProp(Boolean.class, "controls");
    }

    public IJsPropSetter controls(boolean v) {
        return setProp("controls", v);
    }

    public IJsPropSetter controls(IValueBinding<Boolean> v) {
        return setProp("controls", v);
    }

    public JsProp<MultipleTrackListJsr> audioTracks(){
        return getProp(MultipleTrackListJsr.class, "audioTracks");
    }

    public IJsPropSetter audioTracks(MultipleTrackListJsr v) {
        return setProp("audioTracks", v);
    }

    public IJsPropSetter audioTracks(IValueBinding<? extends MultipleTrackListJsr> v) {
        return setProp("audioTracks", v);
    }

    public JsProp<ExclusiveTrackListJsr> videoTracks(){
        return getProp(ExclusiveTrackListJsr.class, "videoTracks");
    }

    public IJsPropSetter videoTracks(ExclusiveTrackListJsr v) {
        return setProp("videoTracks", v);
    }

    public IJsPropSetter videoTracks(IValueBinding<? extends ExclusiveTrackListJsr> v) {
        return setProp("videoTracks", v);
    }

    public JsProp<TextTrackJsr[]> textTracks(){
        return getProp(TextTrackJsr[].class, "textTracks");
    }

    public IJsPropSetter textTracks(TextTrackJsr[] v) {
        return setProp("textTracks", v);
    }

    public IJsPropSetter textTracks(IValueBinding<TextTrackJsr[]> v) {
        return setProp("textTracks", v);
    }

    public JsFunc<Void> load(){
        return call("load");
    }

    public JsFunc<String> canPlayType(String type){
        return call(String.class, "canPlayType").with(type);
    }

    public JsFunc<String> canPlayType(IValueBinding<String> type){
        return call(String.class, "canPlayType").with(type);
    }

    public JsFunc<Void> play(){
        return call("play");
    }

    public JsFunc<Void> pause(){
        return call("pause");
    }

    public JsFunc<? extends MutableTextTrackJsr> addTextTrack(String kind, String label){
        return call(MutableTextTrackJsr.class, "addTextTrack").with(kind, label);
    }

    public JsFunc<? extends MutableTextTrackJsr> addTextTrack(IValueBinding<String> kind, IValueBinding<String> label){
        return call(MutableTextTrackJsr.class, "addTextTrack").with(kind, label);
    }

    public JsFunc<? extends MutableTextTrackJsr> addTextTrack(String kind){
        return call(MutableTextTrackJsr.class, "addTextTrack").with(kind);
    }

    public JsFunc<? extends MutableTextTrackJsr> addTextTrack(IValueBinding<String> kind){
        return call(MutableTextTrackJsr.class, "addTextTrack").with(kind);
    }

    public JsFunc<? extends MutableTextTrackJsr> addTextTrack(String kind, String label, String language){
        return call(MutableTextTrackJsr.class, "addTextTrack").with(kind, label, language);
    }

    public JsFunc<? extends MutableTextTrackJsr> addTextTrack(IValueBinding<String> kind, IValueBinding<String> label, IValueBinding<String> language){
        return call(MutableTextTrackJsr.class, "addTextTrack").with(kind, label, language);
    }
    
    public static JsTypeRef<HTMLMediaElementJsr> prototype = new JsTypeRef<HTMLMediaElementJsr>(S);
}