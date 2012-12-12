package org.eclipse.vjet.vsf.dervlet.dap;

public class PropertyBasedVldCmdGrouping {

	public static enum Category {
		//categories for properties
		general, position, tag,
		//categories for styles
		background, border, box, 
		text, list, misc
	};

	public static enum HtmlElementProperty {
		//general properties
		className, dir, id, innerHTML, innerText, lang, nodeName, nodeType, nodeValue, tagName, title,
		//position related properties
		clientHeight, clientLeft, clientTop, clientWidth,
		offsetHeight, offsetLeft, offsetTop, offsetWidth,
		scrollHeight, scrollLeft, scrollTop, scrollWidth,
		//tag specified properties
		object, alt, noHref, pubDate, controls, coords, shape, href, target, hreflang, rel, rev, charset,
		volume, balance, background, vLink, link, aLink, clear, disabled, span, _char, charoff, radioGroup,
		icon, checked, label, open, pluginsPage, units, hidden, face, color, enctype, acceptCharset,
		action, method, length, noResize, marginHeight, marginWidth, scrolling, frameBorder, longDesc,
		profile, noShade, size, align, width, version, lowsrc, isMap, accept, defaultChecked, maxLength,
		keyType, challenge, autoFocus, htmlFor, accessKey, bgcolor, behavior, scrollamount, truespeed,
		direction, scrolldelay, vspace, hspace, height, loop, compact, content, httpEquiv, scheme, min,
		low, high, optimum, cite, dateTime, declare, data, standby, codeType, codeBase, archive, code,
		useMap, border, start, selected, index, defaultSelected, form, _for, name, value, max, defer,
		multiple, selectedIndex, type, media, cellPadding, frame, cellSpacing, summary, rules, ch, chOff,
		vAlign, rowSpan, cellIndex, noWrap, colSpan, abbr, scope, headers, axis, bgColor, rows, cols,
		readOnly, defaultValue, rowspan, nowrap, colspan, text, rowIndex, sectionRowIndex, poster, autoPlay,
		autoBuffer, src, contentEditable, tabIndex, language, atomicSelection, unselectable, hideFocus;
		
		public String toString() {
			if(this.name().startsWith("_"))
				return this.name().substring(1);
			else
				return this.name();
		}
	};

	public static enum HtmlStyleProperty {
		//background related
		background, backgroundAttachment, backgroundColor, backgroundImage, backgroundPosition,
		backgroundPositionX, backgroundPositionY, backgroundRepeat, mozOpacity, opacity,
		//border related
		border, borderBottom, borderBottomColor, borderBottomStyle, borderBottomWidth, 
		borderColor, borderLeft, borderLeftColor, borderLeftStyle, borderLeftWidth,
		borderRight, borderRightColor, borderRightStyle, borderRightWidth, borderStyle,
		borderTop, borderTopColor, borderTopStyle, borderTopWidth, borderWidth,
		//outline related
		outline, outlineColor, outlineStyle, outlineWidth,
		//box related
		margin, marginBottom, marginLeft, marginRight, marginTop, 
		padding, paddingBottom, paddingLeft, paddingRight, paddingTop,
		//font related
		font, fontFamily, fontSize, fontSizeAdjust, 
		fontStretch, fontStyle, fontVariant, fontWeight,
		//placement related
		clip, height, left, overflow, position, top, visibility, width, zIndex,
		maxHeight, maxWidth, minHeight, minWidth, cssFloat, clear,
		//list related
		listStyle, listStyleImage, listStylePosition, listStyleType, counterIncrement, markerOffset,
		//text related
		textAlign, textDecoration, textIndent, textShadow, textTransform,
		letterSpacing, lineBreak, lineHeight, verticalAlign, whiteSpace, wordSpacing,
		color, direction, quotes, unicodeBidi,
		//layout related
		layoutFlow, layoutGrid, layoutGridChar, layoutGridLine, layoutGridMode, layoutGridType,
		//miscellaneous
		accelerator, behavior, content, cursor, display, filter, imeMode, marks, zoom;
		
		
		public String toString() {
			return PropertyBasedStyleVldCommand.prefix + this.name();
		}

	};

	public static Object[] grouping = new Object[] {
		new HtmlElementProperty[]{
			HtmlElementProperty.className, HtmlElementProperty.dir, HtmlElementProperty.id, 
			HtmlElementProperty.innerHTML, HtmlElementProperty.innerText, HtmlElementProperty.lang, 
			HtmlElementProperty.nodeName, HtmlElementProperty.nodeType, HtmlElementProperty.nodeValue, 
			HtmlElementProperty.tagName, HtmlElementProperty.title,
		}, Category.general,
		new HtmlElementProperty[]{
			HtmlElementProperty.clientHeight, HtmlElementProperty.clientLeft, HtmlElementProperty.clientTop,
			HtmlElementProperty.clientWidth, HtmlElementProperty.offsetHeight, HtmlElementProperty.offsetLeft,
			HtmlElementProperty.offsetTop, HtmlElementProperty.offsetWidth, HtmlElementProperty.scrollHeight,
			HtmlElementProperty.scrollLeft, HtmlElementProperty.scrollTop, HtmlElementProperty.scrollWidth,
        }, Category.position,
        new HtmlElementProperty[]{
			HtmlElementProperty.object, HtmlElementProperty.alt, HtmlElementProperty.noHref,
			HtmlElementProperty.pubDate, HtmlElementProperty.controls, HtmlElementProperty.coords,
			HtmlElementProperty.shape, HtmlElementProperty.href, HtmlElementProperty.target,
			HtmlElementProperty.hreflang, HtmlElementProperty.rel, HtmlElementProperty.rev,
			HtmlElementProperty.charset, HtmlElementProperty.volume, HtmlElementProperty.balance,
			HtmlElementProperty.background, HtmlElementProperty.vLink, HtmlElementProperty.link,
			HtmlElementProperty.aLink, HtmlElementProperty.clear, HtmlElementProperty.disabled,
			HtmlElementProperty.span, HtmlElementProperty._char, HtmlElementProperty.charoff,
			HtmlElementProperty.radioGroup, HtmlElementProperty.icon, HtmlElementProperty.checked,
			HtmlElementProperty.label, HtmlElementProperty.open, HtmlElementProperty.pluginsPage,
			HtmlElementProperty.units, HtmlElementProperty.hidden, HtmlElementProperty.face,
			HtmlElementProperty.color, HtmlElementProperty.enctype, HtmlElementProperty.acceptCharset,
			HtmlElementProperty.action, HtmlElementProperty.method, HtmlElementProperty.length,
			HtmlElementProperty.noResize, HtmlElementProperty.marginHeight, HtmlElementProperty.marginWidth,
			HtmlElementProperty.scrolling, HtmlElementProperty.frameBorder, HtmlElementProperty.longDesc,
			HtmlElementProperty.profile, HtmlElementProperty.noShade, HtmlElementProperty.size,
			HtmlElementProperty.align, HtmlElementProperty.width, HtmlElementProperty.version,
			HtmlElementProperty.lowsrc, HtmlElementProperty.isMap, HtmlElementProperty.accept,
			HtmlElementProperty.defaultChecked, HtmlElementProperty.maxLength, HtmlElementProperty.keyType,
			HtmlElementProperty.challenge, HtmlElementProperty.autoFocus, HtmlElementProperty.htmlFor,
			HtmlElementProperty.accessKey, HtmlElementProperty.bgcolor, HtmlElementProperty.behavior,
			HtmlElementProperty.scrollamount, HtmlElementProperty.truespeed, HtmlElementProperty.direction,
			HtmlElementProperty.scrolldelay, HtmlElementProperty.vspace, HtmlElementProperty.hspace,
			HtmlElementProperty.height, HtmlElementProperty.loop, HtmlElementProperty.compact,
			HtmlElementProperty.content, HtmlElementProperty.httpEquiv, HtmlElementProperty.scheme,
			HtmlElementProperty.min, HtmlElementProperty.low, HtmlElementProperty.high,
			HtmlElementProperty.optimum, HtmlElementProperty.cite, HtmlElementProperty.dateTime,
			HtmlElementProperty.declare, HtmlElementProperty.data, HtmlElementProperty.standby,
			HtmlElementProperty.codeType, HtmlElementProperty.codeBase, HtmlElementProperty.archive,
			HtmlElementProperty.code, HtmlElementProperty.useMap, HtmlElementProperty.border,
			HtmlElementProperty.start, HtmlElementProperty.selected, HtmlElementProperty.index,
			HtmlElementProperty.defaultSelected, HtmlElementProperty.form, HtmlElementProperty._for,
			HtmlElementProperty.name, HtmlElementProperty.value, HtmlElementProperty.max, 
			HtmlElementProperty.defer, HtmlElementProperty.multiple, HtmlElementProperty.selectedIndex,
			HtmlElementProperty.type, HtmlElementProperty.media, HtmlElementProperty.cellPadding,
			HtmlElementProperty.frame, HtmlElementProperty.cellSpacing, HtmlElementProperty.summary,
			HtmlElementProperty.rules, HtmlElementProperty.ch, HtmlElementProperty.chOff,
			HtmlElementProperty.vAlign, HtmlElementProperty.rowSpan, HtmlElementProperty.cellIndex,
			HtmlElementProperty.noWrap, HtmlElementProperty.colSpan, HtmlElementProperty.abbr, 
			HtmlElementProperty.scope, HtmlElementProperty.headers, HtmlElementProperty.axis, 
			HtmlElementProperty.bgColor, HtmlElementProperty.rows, HtmlElementProperty.cols, 
			HtmlElementProperty.readOnly, HtmlElementProperty.defaultValue, HtmlElementProperty.rowspan,
			HtmlElementProperty.nowrap, HtmlElementProperty.colspan, HtmlElementProperty.text,
			HtmlElementProperty.rowIndex, HtmlElementProperty.sectionRowIndex, HtmlElementProperty.poster,
			HtmlElementProperty.autoPlay, HtmlElementProperty.autoBuffer, HtmlElementProperty.src,
			HtmlElementProperty.contentEditable, HtmlElementProperty.tabIndex, HtmlElementProperty.language,
			HtmlElementProperty.atomicSelection, HtmlElementProperty.unselectable, HtmlElementProperty.hideFocus,
        }, Category.tag,
		new HtmlStyleProperty[]{
			HtmlStyleProperty.background, HtmlStyleProperty.backgroundAttachment, HtmlStyleProperty.backgroundColor,
			HtmlStyleProperty.backgroundImage, HtmlStyleProperty.backgroundPosition, HtmlStyleProperty.backgroundPositionX,
			HtmlStyleProperty.backgroundPositionY, HtmlStyleProperty.backgroundRepeat, HtmlStyleProperty.mozOpacity,
			HtmlStyleProperty.opacity,
	    }, Category.background,
		new HtmlStyleProperty[]{
			HtmlStyleProperty.border, HtmlStyleProperty.borderBottom, HtmlStyleProperty.borderBottomColor,
			HtmlStyleProperty.borderBottomStyle, HtmlStyleProperty.borderBottomWidth, HtmlStyleProperty.borderColor,
			HtmlStyleProperty.borderLeft, HtmlStyleProperty.borderLeftColor, HtmlStyleProperty.borderLeftStyle,
			HtmlStyleProperty.borderLeftWidth, HtmlStyleProperty.borderRight, HtmlStyleProperty.borderRightColor,
			HtmlStyleProperty.borderRightStyle, HtmlStyleProperty.borderRightWidth, HtmlStyleProperty.borderStyle,
			HtmlStyleProperty.borderTop, HtmlStyleProperty.borderTopColor, HtmlStyleProperty.borderTopStyle,
			HtmlStyleProperty.borderTopWidth, HtmlStyleProperty.borderWidth,
			HtmlStyleProperty.outline, HtmlStyleProperty.outlineColor, 
			HtmlStyleProperty.outlineStyle, HtmlStyleProperty.outlineWidth,
	    }, Category.border,
		new HtmlStyleProperty[]{
			HtmlStyleProperty.clip, HtmlStyleProperty.height, HtmlStyleProperty.left, 
			HtmlStyleProperty.overflow, HtmlStyleProperty.position, HtmlStyleProperty.top, 
			HtmlStyleProperty.visibility, HtmlStyleProperty.width, HtmlStyleProperty.zIndex,
			HtmlStyleProperty.maxHeight, HtmlStyleProperty.maxWidth, HtmlStyleProperty.minHeight,
			HtmlStyleProperty.minWidth, HtmlStyleProperty.cssFloat, HtmlStyleProperty.clear,
			HtmlStyleProperty.margin, HtmlStyleProperty.marginBottom, HtmlStyleProperty.marginLeft,
			HtmlStyleProperty.marginRight, HtmlStyleProperty.marginTop, HtmlStyleProperty.padding,
			HtmlStyleProperty.paddingBottom, HtmlStyleProperty.paddingLeft, HtmlStyleProperty.paddingRight,
			HtmlStyleProperty.paddingTop,
	    }, Category.box,
		new HtmlStyleProperty[]{
			HtmlStyleProperty.listStyle, HtmlStyleProperty.listStyleImage, HtmlStyleProperty.listStylePosition,
			HtmlStyleProperty.listStyleType, HtmlStyleProperty.counterIncrement, HtmlStyleProperty.markerOffset,
	    }, Category.list,
		new HtmlStyleProperty[]{
			HtmlStyleProperty.font, HtmlStyleProperty.fontFamily, HtmlStyleProperty.fontSize,
			HtmlStyleProperty.fontSizeAdjust, HtmlStyleProperty.fontStretch, HtmlStyleProperty.fontStyle,
			HtmlStyleProperty.fontVariant, HtmlStyleProperty.fontWeight,
			HtmlStyleProperty.textAlign, HtmlStyleProperty.textDecoration, HtmlStyleProperty.textIndent,
			HtmlStyleProperty.textShadow, HtmlStyleProperty.textTransform, HtmlStyleProperty.letterSpacing,
			HtmlStyleProperty.lineBreak, HtmlStyleProperty.lineHeight, HtmlStyleProperty.verticalAlign, 
			HtmlStyleProperty.whiteSpace, HtmlStyleProperty.wordSpacing, HtmlStyleProperty.color,
			HtmlStyleProperty.direction, HtmlStyleProperty.quotes, HtmlStyleProperty.unicodeBidi,
			HtmlStyleProperty.layoutFlow, HtmlStyleProperty.layoutGrid, HtmlStyleProperty.layoutGridChar,
			HtmlStyleProperty.layoutGridLine, HtmlStyleProperty.layoutGridMode, HtmlStyleProperty.layoutGridType,
	    }, Category.text,
		new HtmlStyleProperty[]{
			HtmlStyleProperty.accelerator, HtmlStyleProperty.behavior, HtmlStyleProperty.content,
			HtmlStyleProperty.cursor, HtmlStyleProperty.display, HtmlStyleProperty.filter,
			HtmlStyleProperty.imeMode, HtmlStyleProperty.marks, HtmlStyleProperty.zoom,
	    }, Category.misc,
	};

	public static String jsonizeCategories() {
		int i = 0;
		StringBuffer buffer = new StringBuffer(1024);
		buffer.append('[');	
		for(Category cat : Category.values()) {
			if(i==0)
				buffer.append("'");
			else
				buffer.append(",'");
			buffer.append(cat.toString()).append("'");
			i++;
		}
		buffer.append(']');
		return buffer.toString();
	}

	public static String jsonizeGrouping() {
		StringBuffer buffer = new StringBuffer(1024);
		buffer.append('{');
		for(int i=0; i<grouping.length;) {
			Object[] props = (Object[])grouping[i];
			if(i==0)
				buffer.append("'");
			else
				buffer.append(",'");
			for(int j=0; j<props.length; j++) {
				if(j==0)
				    buffer.append(props[j].toString());
				else
					buffer.append("|").append(props[j].toString());
			}
			buffer.append("':");
			Object cat = grouping[i+1];
			buffer.append("'").append(cat.toString()).append("'");
			i = i + 2;
		}
		buffer.append('}');
		return buffer.toString();
	}

}
