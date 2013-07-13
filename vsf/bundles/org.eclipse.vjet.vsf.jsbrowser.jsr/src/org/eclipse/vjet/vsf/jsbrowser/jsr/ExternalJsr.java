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
import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLFormElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ExternalJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("External", ExternalJsr.class, "External");

    public ExternalJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ExternalJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Boolean> frozen(){
        return getProp(Boolean.class, "frozen");
    }

    public IJsPropSetter frozen(boolean v) {
        return setProp("frozen", v);
    }

    public IJsPropSetter frozen(IValueBinding<Boolean> v) {
        return setProp("frozen", v);
    }

    public JsProp<Boolean> menuArguments(){
        return getProp(Boolean.class, "menuArguments");
    }

    public IJsPropSetter menuArguments(boolean v) {
        return setProp("menuArguments", v);
    }

    public IJsPropSetter menuArguments(IValueBinding<Boolean> v) {
        return setProp("menuArguments", v);
    }

    public JsProp<Object> onvisibilitychange(){
        return getProp(Object.class, "onvisibilitychange");
    }

    public IJsPropSetter onvisibilitychange(Object v) {
        return setProp("onvisibilitychange", v);
    }

    public IJsPropSetter onvisibilitychange(IValueBinding<Object> v) {
        return setProp("onvisibilitychange", v);
    }

    public JsProp<Boolean> scrollbar(){
        return getProp(Boolean.class, "scrollbar");
    }

    public IJsPropSetter scrollbar(boolean v) {
        return setProp("scrollbar", v);
    }

    public IJsPropSetter scrollbar(IValueBinding<Boolean> v) {
        return setProp("scrollbar", v);
    }

    public JsProp<Boolean> selectableContent(){
        return getProp(Boolean.class, "selectableContent");
    }

    public IJsPropSetter selectableContent(boolean v) {
        return setProp("selectableContent", v);
    }

    public IJsPropSetter selectableContent(IValueBinding<Boolean> v) {
        return setProp("selectableContent", v);
    }

    public JsProp<Boolean> version(){
        return getProp(Boolean.class, "version");
    }

    public IJsPropSetter version(boolean v) {
        return setProp("version", v);
    }

    public IJsPropSetter version(IValueBinding<Boolean> v) {
        return setProp("version", v);
    }

    public JsProp<Boolean> visibility(){
        return getProp(Boolean.class, "visibility");
    }

    public IJsPropSetter visibility(boolean v) {
        return setProp("visibility", v);
    }

    public IJsPropSetter visibility(IValueBinding<Boolean> v) {
        return setProp("visibility", v);
    }

    /**

 Obsolete. Presents a dialog box that enables the user to add the
 specified channel, or to change the channel URL, if it is already
 installed.
 @param elem
 
*/

public JsFunc<Void> AddChannel(String sURLToCDF){
        return call("AddChannel").with(sURLToCDF);
    }

    /**

 Obsolete. Presents a dialog box that enables the user to add the
 specified channel, or to change the channel URL, if it is already
 installed.
 @param elem
 
*/

public JsFunc<Void> AddChannel(IValueBinding<String> sURLToCDF){
        return call("AddChannel").with(sURLToCDF);
    }

    public JsFunc<Void> AddDesktopComponent(String sURL, String sType, int iLeft){
        return call("AddDesktopComponent").with(sURL, sType, iLeft);
    }

    public JsFunc<Void> AddDesktopComponent(IValueBinding<String> sURL, IValueBinding<String> sType, IValueBinding<Integer> iLeft){
        return call("AddDesktopComponent").with(sURL, sType, iLeft);
    }

    public JsFunc<Void> AddDesktopComponent(String sURL, String sType, int iLeft, int iTop){
        return call("AddDesktopComponent").with(sURL, sType, iLeft, iTop);
    }

    public JsFunc<Void> AddDesktopComponent(IValueBinding<String> sURL, IValueBinding<String> sType, IValueBinding<Integer> iLeft, IValueBinding<Integer> iTop){
        return call("AddDesktopComponent").with(sURL, sType, iLeft, iTop);
    }

    public JsFunc<Void> AddDesktopComponent(String sURL, String sType, int iLeft, int iTop, int iWidth){
        return call("AddDesktopComponent").with(sURL, sType, iLeft, iTop, iWidth);
    }

    public JsFunc<Void> AddDesktopComponent(IValueBinding<String> sURL, IValueBinding<String> sType, IValueBinding<Integer> iLeft, IValueBinding<Integer> iTop, IValueBinding<Integer> iWidth){
        return call("AddDesktopComponent").with(sURL, sType, iLeft, iTop, iWidth);
    }

    public JsFunc<Void> AddDesktopComponent(String sURL, String sType, int iLeft, int iTop, int iWidth, int iHeight){
        return call("AddDesktopComponent").with(sURL, sType, iLeft, iTop, iWidth, iHeight);
    }

    public JsFunc<Void> AddDesktopComponent(IValueBinding<String> sURL, IValueBinding<String> sType, IValueBinding<Integer> iLeft, IValueBinding<Integer> iTop, IValueBinding<Integer> iWidth, IValueBinding<Integer> iHeight){
        return call("AddDesktopComponent").with(sURL, sType, iLeft, iTop, iWidth, iHeight);
    }

    public JsFunc<Void> AddDesktopComponent(String sURL, String sType){
        return call("AddDesktopComponent").with(sURL, sType);
    }

    public JsFunc<Void> AddDesktopComponent(IValueBinding<String> sURL, IValueBinding<String> sType){
        return call("AddDesktopComponent").with(sURL, sType);
    }

    public JsFunc<Void> AddFavorite(String sURL, String sTitle){
        return call("AddFavorite").with(sURL, sTitle);
    }

    public JsFunc<Void> AddFavorite(IValueBinding<String> sURL, IValueBinding<String> sTitle){
        return call("AddFavorite").with(sURL, sTitle);
    }

    public JsFunc<Void> AddFavorite(String sURL){
        return call("AddFavorite").with(sURL);
    }

    public JsFunc<Void> AddFavorite(IValueBinding<String> sURL){
        return call("AddFavorite").with(sURL);
    }

    public JsFunc<Void> AddToFavoritesBar(String URL, String Title, String Type){
        return call("AddToFavoritesBar").with(URL, Title, Type);
    }

    public JsFunc<Void> AddToFavoritesBar(IValueBinding<String> URL, IValueBinding<String> Title, IValueBinding<String> Type){
        return call("AddToFavoritesBar").with(URL, Title, Type);
    }

    public JsFunc<Void> AddToFavoritesBar(String URL, String Title){
        return call("AddToFavoritesBar").with(URL, Title);
    }

    public JsFunc<Void> AddToFavoritesBar(IValueBinding<String> URL, IValueBinding<String> Title){
        return call("AddToFavoritesBar").with(URL, Title);
    }

    public JsFunc<Void> AddSearchProvider(String sURL){
        return call("AddSearchProvider").with(sURL);
    }

    public JsFunc<Void> AddSearchProvider(IValueBinding<String> sURL){
        return call("AddSearchProvider").with(sURL);
    }

    public JsFunc<Void> AddService(String sURL){
        return call("AddService").with(sURL);
    }

    public JsFunc<Void> AddService(IValueBinding<String> sURL){
        return call("AddService").with(sURL);
    }

    /**

 Saves the specified form in the AutoComplete data store.
 @param oFormRequired. Object that specifies a reference to a form element.
 
*/

public JsFunc<Void> AutoCompleteSaveForm(HTMLFormElementJsr oForm){
        return call("AutoCompleteSaveForm").with(oForm);
    }

    /**

 Saves the specified form in the AutoComplete data store.
 @param oFormRequired. Object that specifies a reference to a form element.
 
*/

public JsFunc<Void> AutoCompleteSaveForm(IValueBinding<? extends HTMLFormElementJsr> oForm){
        return call("AutoCompleteSaveForm").with(oForm);
    }

    public JsFunc<Void> AutoScan(String sUserQuery, String sURL, String sTarget){
        return call("AutoScan").with(sUserQuery, sURL, sTarget);
    }

    public JsFunc<Void> AutoScan(IValueBinding<String> sUserQuery, IValueBinding<String> sURL, IValueBinding<String> sTarget){
        return call("AutoScan").with(sUserQuery, sURL, sTarget);
    }

    public JsFunc<Void> AutoScan(String sUserQuery, String sURL){
        return call("AutoScan").with(sUserQuery, sURL);
    }

    public JsFunc<Void> AutoScan(IValueBinding<String> sUserQuery, IValueBinding<String> sURL){
        return call("AutoScan").with(sUserQuery, sURL);
    }

    /**

 Not supported. Retrieves the Uniform Resource Identifier (URI) of an
 alternate product image.
 
*/

public JsFunc<String> BrandImageUri(){
        return call(String.class, "BrandImageUri");
    }

    /**

 Propagates an event up its containment hierarchy.
 
*/

public JsFunc<Void> bubbleEvent(){
        return call("bubbleEvent");
    }

    /**

 Resets the list of feeds, search providers, and Web Slices associated
 with the page.
 
*/

public JsFunc<Void> ContentDiscoveryReset(){
        return call("ContentDiscoveryReset");
    }

    /**

 Not supported. Sets a registry value to turn ClearType on or off.
 @param fSetOne of the following required values: true Always use
 ClearType for HTML. false Do not use ClearType for HTML.
 
*/

public JsFunc<Void> CustomizeClearType(boolean fSet){
        return call("CustomizeClearType").with(fSet);
    }

    /**

 Not supported. Sets a registry value to turn ClearType on or off.
 @param fSetOne of the following required values: true Always use
 ClearType for HTML. false Do not use ClearType for HTML.
 
*/

public JsFunc<Void> CustomizeClearType(IValueBinding<Boolean> fSet){
        return call("CustomizeClearType").with(fSet);
    }

    /**

 Not supported. Saves the user settings from a "first run" page.
 @param fSQMRequired. Boolean that specifies true to enable Software
 Quality Monitoring (SQM), or false to opt out.
 @param fPhishingRequired. Boolean that specifies true to turn on Microsoft
 Phishing Filter, or false to turn it off.
 @param sLocaleRequired. String that specifies the default region and
 language setting for the browser.
 
*/

public JsFunc<Void> CustomizeSettings(boolean fSQM, boolean fPhishing, String sLocale){
        return call("CustomizeSettings").with(fSQM, fPhishing, sLocale);
    }

    /**

 Not supported. Saves the user settings from a "first run" page.
 @param fSQMRequired. Boolean that specifies true to enable Software
 Quality Monitoring (SQM), or false to opt out.
 @param fPhishingRequired. Boolean that specifies true to turn on Microsoft
 Phishing Filter, or false to turn it off.
 @param sLocaleRequired. String that specifies the default region and
 language setting for the browser.
 
*/

public JsFunc<Void> CustomizeSettings(IValueBinding<Boolean> fSQM, IValueBinding<Boolean> fPhishing, IValueBinding<String> sLocale){
        return call("CustomizeSettings").with(fSQM, fPhishing, sLocale);
    }

    /**

 Not supported. Retrieves the name of the user's default search provider.
 @return String that contains the default search provider name.
 
*/

public JsFunc<String> DefaultSearchProvider(){
        return call(String.class, "DefaultSearchProvider");
    }

    /**

 Not supported. Attempts to diagnose problems with the network connection.
 @return String that contains the default search provider name.
 
*/

public JsFunc<Void> DiagnoseConnection(){
        return call("DiagnoseConnection");
    }

    /**

 Deprecated. Handles the import and export of Windows Internet Explorer
 favorites.
 Microsoft Internet Explorer 6 for Windows XP Service Pack 2 (SP2) and
 later. This method is no longer available.
 @param bImportExportRequired. A Boolean that specifies one of the following
 possible values.
 true Import is requested. false Export is requested.
 @param sImportExportPathRequired. A String that specifies the location (URL) to import
 or export, depending on bImportExport. If a value is an empty
 string, a file dialog box is displayed.
 
*/

public JsFunc<Void> ImportExportFavorites(boolean bImportExport, String sImportExportPath){
        return call("ImportExportFavorites").with(bImportExport, sImportExportPath);
    }

    /**

 Deprecated. Handles the import and export of Windows Internet Explorer
 favorites.
 Microsoft Internet Explorer 6 for Windows XP Service Pack 2 (SP2) and
 later. This method is no longer available.
 @param bImportExportRequired. A Boolean that specifies one of the following
 possible values.
 true Import is requested. false Export is requested.
 @param sImportExportPathRequired. A String that specifies the location (URL) to import
 or export, depending on bImportExport. If a value is an empty
 string, a file dialog box is displayed.
 
*/

public JsFunc<Void> ImportExportFavorites(IValueBinding<Boolean> bImportExport, IValueBinding<String> sImportExportPath){
        return call("ImportExportFavorites").with(bImportExport, sImportExportPath);
    }

    /**

 Detects whether the user has enabled InPrivate Filtering.
 @return Returns true if the user has enabled InPrivate Filtering; false
 otherwise.
 
*/

public JsFunc<Boolean> InPrivateFilteringEnabled(){
        return call(Boolean.class, "InPrivateFilteringEnabled");
    }

    /**

 Not supported. Determines whether autosearch settings were migrated from
 a previous version of Microsoft Internet Explorer.
 @return Returns one of the following values: true Search provider
 settings were migrated. false Search provider settings were not
 migrated.
 
*/

public JsFunc<Boolean> IsSearchMigrated(){
        return call(Boolean.class, "IsSearchMigrated");
    }

    /**

 Determines if a search provider has been installed for the current user
 and whether it is set as default.
 @param sUrlRequired. String that specifies a prefix to the URL for the
 search provider.
 @return Pointer to an unsigned long integer value that contains return
 value. 0 The specified search provider is not installed for the
 current user. 1 The specified search provider is installed for
 the current user. 2 The specified search provider is installed
 and is set as the default search provider.
 
*/

public JsFunc<Long> IsSearchProviderInstalled(String url){
        return call(Long.class, "IsSearchProviderInstalled").with(url);
    }

    /**

 Determines if a search provider has been installed for the current user
 and whether it is set as default.
 @param sUrlRequired. String that specifies a prefix to the URL for the
 search provider.
 @return Pointer to an unsigned long integer value that contains return
 value. 0 The specified search provider is not installed for the
 current user. 1 The specified search provider is installed for
 the current user. 2 The specified search provider is installed
 and is set as the default search provider.
 
*/

public JsFunc<Long> IsSearchProviderInstalled(IValueBinding<String> url){
        return call(Long.class, "IsSearchProviderInstalled").with(url);
    }

    /**

 Determines if a search provider has been installed for the current user
 and whether it is set as default.
 @param URLRequired. The main document of the activity that you want to
 query for.
 @param VerbRequired. The type of action that this activity performs.
 Case-insensitive.
 @return One of the following values: 0 The service is not yet installed.
 1 The service is installed. 2 The service is installed and it is
 the default for its verb type.
 
*/

public JsFunc<Long> IsServiceInstalled(String URL, String Verb){
        return call(Long.class, "IsServiceInstalled").with(URL, Verb);
    }

    /**

 Determines if a search provider has been installed for the current user
 and whether it is set as default.
 @param URLRequired. The main document of the activity that you want to
 query for.
 @param VerbRequired. The type of action that this activity performs.
 Case-insensitive.
 @return One of the following values: 0 The service is not yet installed.
 1 The service is installed. 2 The service is installed and it is
 the default for its verb type.
 
*/

public JsFunc<Long> IsServiceInstalled(IValueBinding<String> URL, IValueBinding<String> Verb){
        return call(Long.class, "IsServiceInstalled").with(URL, Verb);
    }

    /**

 Obsolete. Retrieves a value indicating whether the client subscribes to
 the given channel.
 @param sURLToCDFRequired. A String that specifies the URL of a Channel
 Definition Format (CDF) file to check for a subscription.
 @return Boolean that receives one of the following possible values. true
 The client subscribes to the channel. false No subscription
 exists for the CDF file.
 
*/

public JsFunc<Boolean> IsSubscribed(String sURLToCDF){
        return call(Boolean.class, "IsSubscribed").with(sURLToCDF);
    }

    /**

 Obsolete. Retrieves a value indicating whether the client subscribes to
 the given channel.
 @param sURLToCDFRequired. A String that specifies the URL of a Channel
 Definition Format (CDF) file to check for a subscription.
 @return Boolean that receives one of the following possible values. true
 The client subscribes to the channel. false No subscription
 exists for the CDF file.
 
*/

public JsFunc<Boolean> IsSubscribed(IValueBinding<String> sURLToCDF){
        return call(Boolean.class, "IsSubscribed").with(sURLToCDF);
    }

    /**

 Determines whether Microsoft ActiveX Filtering is enabled by the user.
 @return Returns true if ActiveX controls are disallowed, false otherwise.
 
*/

public JsFunc<Boolean> msActiveXFilteringEnabled(){
        return call(Boolean.class, "msActiveXFilteringEnabled");
    }

    /**

 Creates a pinned site shortcut to the current webpage on the Windows
 Start menu.
 @return Boolean that receives one of the following possible values. true
 The client subscribes to the channel. false No subscription
 exists for the CDF file.
 
*/

public JsFunc<Boolean> msAddSiteMode(){
        return call(Boolean.class, "msAddSiteMode");
    }

    /**

 @param URLRequired. The address of the Tracking Protection list.
 @param bstrFilterNameRequired. The display name.
 @return void
 
*/

public JsFunc<Void> msAddTrackingProtectionList(String URL, String bstrFilterName){
        return call("msAddTrackingProtectionList").with(URL, bstrFilterName);
    }

    /**

 @param URLRequired. The address of the Tracking Protection list.
 @param bstrFilterNameRequired. The display name.
 @return void
 
*/

public JsFunc<Void> msAddTrackingProtectionList(IValueBinding<String> URL, IValueBinding<String> bstrFilterName){
        return call("msAddTrackingProtectionList").with(URL, bstrFilterName);
    }

    /**

 Determines whether the current page was launched as a pinned site.
 @param Returnstrue if the current page was launched as a pinned site; false
 otherwise.
 
*/

public JsFunc<Boolean> msIsSiteMode(){
        return call(Boolean.class, "msIsSiteMode");
    }

    /**

 Determines whether a pinned site was launched for the first time.
 @param fPreserveStateOne of the following required values:false Read and clear the
 first-run state. true Only read the state, do not clear it.
 
*/

public JsFunc<Boolean> msIsSiteModeFirstRun(boolean fPreserveState){
        return call(Boolean.class, "msIsSiteModeFirstRun").with(fPreserveState);
    }

    /**

 Determines whether a pinned site was launched for the first time.
 @param fPreserveStateOne of the following required values:false Read and clear the
 first-run state. true Only read the state, do not clear it.
 
*/

public JsFunc<Boolean> msIsSiteModeFirstRun(IValueBinding<Boolean> fPreserveState){
        return call(Boolean.class, "msIsSiteModeFirstRun").with(fPreserveState);
    }

    /**

 Flashes the pinned site taskbar button.
 
*/

public JsFunc<Void> msSiteModeActivate(){
        return call("msSiteModeActivate");
    }

    public JsFunc<Void> msSiteModeAddButtonStyle(String uiButtonID, String bstrIconUrl){
        return call("msSiteModeAddButtonStyle").with(uiButtonID, bstrIconUrl);
    }

    public JsFunc<Void> msSiteModeAddButtonStyle(IValueBinding<String> uiButtonID, IValueBinding<String> bstrIconUrl){
        return call("msSiteModeAddButtonStyle").with(uiButtonID, bstrIconUrl);
    }

    public JsFunc<Void> msSiteModeAddButtonStyle(String uiButtonID, String bstrIconUrl, String pvarTooltip){
        return call("msSiteModeAddButtonStyle").with(uiButtonID, bstrIconUrl, pvarTooltip);
    }

    public JsFunc<Void> msSiteModeAddButtonStyle(IValueBinding<String> uiButtonID, IValueBinding<String> bstrIconUrl, IValueBinding<String> pvarTooltip){
        return call("msSiteModeAddButtonStyle").with(uiButtonID, bstrIconUrl, pvarTooltip);
    }

    public JsFunc<Void> msSiteModeAddJumpListItem(String bstrName, String bstrActionUri, String bstrIconUri){
        return call("msSiteModeAddJumpListItem").with(bstrName, bstrActionUri, bstrIconUri);
    }

    public JsFunc<Void> msSiteModeAddJumpListItem(IValueBinding<String> bstrName, IValueBinding<String> bstrActionUri, IValueBinding<String> bstrIconUri){
        return call("msSiteModeAddJumpListItem").with(bstrName, bstrActionUri, bstrIconUri);
    }

    public JsFunc<Void> msSiteModeAddJumpListItem(String bstrName, String bstrActionUri, String bstrIconUri, String bstrWindowType){
        return call("msSiteModeAddJumpListItem").with(bstrName, bstrActionUri, bstrIconUri, bstrWindowType);
    }

    public JsFunc<Void> msSiteModeAddJumpListItem(IValueBinding<String> bstrName, IValueBinding<String> bstrActionUri, IValueBinding<String> bstrIconUri, IValueBinding<String> bstrWindowType){
        return call("msSiteModeAddJumpListItem").with(bstrName, bstrActionUri, bstrIconUri, bstrWindowType);
    }

    /**

 Adds a button to the Thumbnail Toolbar.
 @param bstrIconURLRequired. Absolute or relative URL of an icon resource file.
 @param bstrTooltipRequired. The button name, which is displayed as a tooltip on
 hover.
 
*/

public JsFunc<Integer> msSiteModeAddThumbBarButton(String bstrIconURL, String bstrTooltip){
        return call(Integer.class, "msSiteModeAddThumbBarButton").with(bstrIconURL, bstrTooltip);
    }

    /**

 Adds a button to the Thumbnail Toolbar.
 @param bstrIconURLRequired. Absolute or relative URL of an icon resource file.
 @param bstrTooltipRequired. The button name, which is displayed as a tooltip on
 hover.
 
*/

public JsFunc<Integer> msSiteModeAddThumbBarButton(IValueBinding<String> bstrIconURL, IValueBinding<String> bstrTooltip){
        return call(Integer.class, "msSiteModeAddThumbBarButton").with(bstrIconURL, bstrTooltip);
    }

    /**

 Removes the icon overlay from the taskbar button.
 
*/

public JsFunc<Void> msSiteModeClearIconOverlay(){
        return call("msSiteModeClearIconOverlay");
    }

    /**

 Deletes the Jump List.
 
*/

public JsFunc<Void> msSiteModeClearJumpList(){
        return call("msSiteModeClearJumpList");
    }

    /**

 Creates a new group of items on the Jump List.
 
*/

public JsFunc<Void> msSiteModeCreateJumpList(String bstrHeader){
        return call("msSiteModeCreateJumpList").with(bstrHeader);
    }

    /**

 Creates a new group of items on the Jump List.
 
*/

public JsFunc<Void> msSiteModeCreateJumpList(IValueBinding<String> bstrHeader){
        return call("msSiteModeCreateJumpList").with(bstrHeader);
    }

    /**

 Adds an icon overlay to the pinned site taskbar button.
 @param bstrIconUrlRequired. Absolute URL of an icon resource file.
 @param bstrDescriptionOptional. A String that provides an accessible description of
 the icon overlay.
 
*/

public JsFunc<Void> msSiteModeSetIconOverlay(String bstrIconUrl, String bstrDescription){
        return call("msSiteModeSetIconOverlay").with(bstrIconUrl, bstrDescription);
    }

    /**

 Adds an icon overlay to the pinned site taskbar button.
 @param bstrIconUrlRequired. Absolute URL of an icon resource file.
 @param bstrDescriptionOptional. A String that provides an accessible description of
 the icon overlay.
 
*/

public JsFunc<Void> msSiteModeSetIconOverlay(IValueBinding<String> bstrIconUrl, IValueBinding<String> bstrDescription){
        return call("msSiteModeSetIconOverlay").with(bstrIconUrl, bstrDescription);
    }

    /**

 @param uiButtonIDRequired. The ID of a button that is previously installed with
 msSiteModeAddThumbBarButton.
 @param uiStyleIDRequired. The style ID that msSiteModeAddButtonStyle returns.
 
*/

public JsFunc<Void> msSiteModeShowButtonStyle(String uiButtonID, String uiStyleID){
        return call("msSiteModeShowButtonStyle").with(uiButtonID, uiStyleID);
    }

    /**

 @param uiButtonIDRequired. The ID of a button that is previously installed with
 msSiteModeAddThumbBarButton.
 @param uiStyleIDRequired. The style ID that msSiteModeAddButtonStyle returns.
 
*/

public JsFunc<Void> msSiteModeShowButtonStyle(IValueBinding<String> uiButtonID, IValueBinding<String> uiStyleID){
        return call("msSiteModeShowButtonStyle").with(uiButtonID, uiStyleID);
    }

    /**

 Shows updates to the list of items in a Jump List.
 
*/

public JsFunc<Void> msSiteModeShowJumpList(){
        return call("msSiteModeShowJumpList");
    }

    /**

 Enables the Thumbnail Toolbar in the thumbnail preview of a pinned site.
 
*/

public JsFunc<Void> msSiteModeShowThumbBar(){
        return call("msSiteModeShowThumbBar");
    }

    public JsFunc<Void> msSiteModeUpdateThumbBarButton(int uiButtonID, boolean fEnabled){
        return call("msSiteModeUpdateThumbBarButton").with(uiButtonID, fEnabled);
    }

    public JsFunc<Void> msSiteModeUpdateThumbBarButton(IValueBinding<Integer> uiButtonID, IValueBinding<Boolean> fEnabled){
        return call("msSiteModeUpdateThumbBarButton").with(uiButtonID, fEnabled);
    }

    public JsFunc<Void> msSiteModeUpdateThumbBarButton(int uiButtonID, boolean fEnabled, boolean fVisible){
        return call("msSiteModeUpdateThumbBarButton").with(uiButtonID, fEnabled, fVisible);
    }

    public JsFunc<Void> msSiteModeUpdateThumbBarButton(IValueBinding<Integer> uiButtonID, IValueBinding<Boolean> fEnabled, IValueBinding<Boolean> fVisible){
        return call("msSiteModeUpdateThumbBarButton").with(uiButtonID, fEnabled, fVisible);
    }

    /**

 Determines whether any Tracking Protection lists are enabled by the user.
 
*/

public JsFunc<Boolean> msTrackingProtectionEnabled(){
        return call(Boolean.class, "msTrackingProtectionEnabled");
    }

    /**

 @param sLocationRequired. A String that specifies the URL of a Web page.
 @param sQueryRequired. A String that specifies the text to highlight on the
 Web page specified by sLocation.
 @param sTargetFrameRequired. String that specifies the name of the target frame
 to query.
 
*/

public JsFunc<Void> NavigateAndFind(String sLocation, String sQuery, String sTargetFrame){
        return call("NavigateAndFind").with(sLocation, sQuery, sTargetFrame);
    }

    /**

 @param sLocationRequired. A String that specifies the URL of a Web page.
 @param sQueryRequired. A String that specifies the text to highlight on the
 Web page specified by sLocation.
 @param sTargetFrameRequired. String that specifies the name of the target frame
 to query.
 
*/

public JsFunc<Void> NavigateAndFind(IValueBinding<String> sLocation, IValueBinding<String> sQuery, IValueBinding<String> sTargetFrame){
        return call("NavigateAndFind").with(sLocation, sQuery, sTargetFrame);
    }

    /**

 Not supported. Determines whether Microsoft Phishing Filter is enabled.
 @return Returns one of the following possible values: true Phishing
 Filter is enabled. false Phishing Filter is disabled.
 
*/

public JsFunc<Boolean> PhishingEnabled(){
        return call(Boolean.class, "PhishingEnabled");
    }

    /**

 Triggers an event, as specified.
 @param nameRequired. Specifies a valid event name as a string.
 @param eventDataRequired. Specifies event data.
 @see fireEvent use this instead
 
*/

public JsFunc<Void> raiseEvent(String name, Object eventData){
        return call("raiseEvent").with(name, eventData);
    }

    /**

 Triggers an event, as specified.
 @param nameRequired. Specifies a valid event name as a string.
 @param eventDataRequired. Specifies event data.
 @see fireEvent use this instead
 
*/

public JsFunc<Void> raiseEvent(IValueBinding<String> name, IValueBinding<Object> eventData){
        return call("raiseEvent").with(name, eventData);
    }

    /**

 Not supported. Determines whether the "first run" page has been shown.
 @return Returns one of the following values:true The "first run" page has
 been shown at least once. false The "first run" page has not been
 shown.
 
*/

public JsFunc<Boolean> RunOnceHasShown(){
        return call(Boolean.class, "RunOnceHasShown");
    }

    /**

 Not supported. Sets a registry value to indicate whether the "first run"
 page completed successfully.
 @param fCompleteOne of the following required values:true The settings are
 complete., false The settings are not complete.
 
*/

public JsFunc<Void> RunOnceRequiredSettingsComplete(boolean fComplete){
        return call("RunOnceRequiredSettingsComplete").with(fComplete);
    }

    /**

 Not supported. Sets a registry value to indicate whether the "first run"
 page completed successfully.
 @param fCompleteOne of the following required values:true The settings are
 complete., false The settings are not complete.
 
*/

public JsFunc<Void> RunOnceRequiredSettingsComplete(IValueBinding<Boolean> fComplete){
        return call("RunOnceRequiredSettingsComplete").with(fComplete);
    }

    /**

 Not supported. Sets a registry value to indicate that the "first run"
 page has been shown.
 
*/

public JsFunc<Void> RunOnceShown(){
        return call("RunOnceShown");
    }

    /**

 Not supported. Retrieves the URL of a page that can be used to install
 additional search providers.
 @return String that contains the alternate URL from the registry, or the
 default URL if an alternate has not been set.
 
*/

public JsFunc<String> SearchGuideUrl(){
        return call(String.class, "SearchGuideUrl");
    }

    /**

 Constructs a context menu, as specified.
 @param menuItemPairsRequired. Specifies menu item pairs, which are command text
 and commands contained within the context menu.
 
*/

public JsFunc<Void> setContextMenu(Object menuItemPairs){
        return call("setContextMenu").with(menuItemPairs);
    }

    /**

 @param sUIRequired. A String that specifies a browser dialog box, using
 one of the following values. LanguageDialog Opens the Language
 Preference dialog box. OrganizeFavorites Opens the Organize
 Favorites dialog box. PrivacySettings Microsoft Internet
 Explorer 6 and later. Opens the Privacy Preferences dialog
 box. ProgramAccessAndDefaults Windows XP Service Pack 1 (SP1)
 and later. Opens the Set Program Access and Defaults dialog
 box.
 @param null Required. Null value.
 @return Variant Return value is determined by the dialog box. 
 
*/

public JsFunc<Object> ShowBrowserUI(String sUI, Object nullValue){
        return call(Object.class, "ShowBrowserUI").with(sUI, nullValue);
    }

    /**

 @param sUIRequired. A String that specifies a browser dialog box, using
 one of the following values. LanguageDialog Opens the Language
 Preference dialog box. OrganizeFavorites Opens the Organize
 Favorites dialog box. PrivacySettings Microsoft Internet
 Explorer 6 and later. Opens the Privacy Preferences dialog
 box. ProgramAccessAndDefaults Windows XP Service Pack 1 (SP1)
 and later. Opens the Set Program Access and Defaults dialog
 box.
 @param null Required. Null value.
 @return Variant Return value is determined by the dialog box. 
 
*/

public JsFunc<Object> ShowBrowserUI(IValueBinding<String> sUI, IValueBinding<Object> nullValue){
        return call(Object.class, "ShowBrowserUI").with(sUI, nullValue);
    }

    /**

 Not supported. Enables the user to select "first run" settings at a later time.
 
*/

public JsFunc<Void> SkipRunOnce(){
        return call("SkipRunOnce");
    }

    /**

 Not supported. Disables the welcome screen that appears when opening a new tab in Internet Explorer 7.
 
*/

public JsFunc<Void> SkipTabsWelcome(){
        return call("SkipTabsWelcome");
    }

    /**

 Not supported. Determines whether Software Quality Monitoring (SQM) is enabled.
 
*/

public JsFunc<Boolean> SqmEnabled(){
        return call(Boolean.class, "SqmEnabled");
    }

    /**

 Only for Rhino support
 @param type
 @return
 
*/

public JsFunc<Object> valueOf(String type){
        return call(Object.class, "valueOf").with(type);
    }

    /**

 Only for Rhino support
 @param type
 @return
 
*/

public JsFunc<Object> valueOf(IValueBinding<String> type){
        return call(Object.class, "valueOf").with(type);
    }
    
    public static JsTypeRef<ExternalJsr> prototype = new JsTypeRef<ExternalJsr>(S);
}