﻿/*
 * jQuery UI 1.7.1
 *
 * Copyright (c) 2009 AUTHORS.txt (http://jqueryui.com/about)
 * Dual licensed under the MIT (MIT-LICENSE.txt)
 * and GPL (GPL-LICENSE.txt) licenses.
 *
 * http://docs.jquery.com/UI
 */
jQuery.ui || function (e) { function a(t, n, r, i) { function s(r) { var i = e[t][n][r] || []; return typeof i == "string" ? i.split(/,?\s+/) : i } var o = s("getter"); if (i.length == 1 && typeof i[0] == "string") { o = o.concat(s("getterSetter")) } return e.inArray(r, o) != -1 } var t = e.fn.remove, n = e.browser.mozilla && parseFloat(e.browser.version) < 1.9; e.ui = { version: "1.7.1", plugin: { add: function (t, n, r) { var i = e.ui[t].prototype; for (var s in r) { i.plugins[s] = i.plugins[s] || []; i.plugins[s].push([n, r[s]]) } }, call: function (e, t, n) { var r = e.plugins[t]; if (!r || !e.element[0].parentNode) { return } for (var i = 0; i < r.length; i++) { if (e.options[r[i][0]]) { r[i][1].apply(e.element, n) } } } }, contains: function (e, t) { return document.compareDocumentPosition ? e.compareDocumentPosition(t) & 16 : e !== t && e.contains(t) }, hasScroll: function (t, n) { if (e(t).css("overflow") == "hidden") { return false } var r = n && n == "left" ? "scrollLeft" : "scrollTop", i = false; if (t[r] > 0) { return true } t[r] = 1; i = t[r] > 0; t[r] = 0; return i }, isOverAxis: function (e, t, n) { return e > t && e < t + n }, isOver: function (t, n, r, i, s, o) { return e.ui.isOverAxis(t, r, s) && e.ui.isOverAxis(n, i, o) }, keyCode: { BACKSPACE: 8, CAPS_LOCK: 20, COMMA: 188, CONTROL: 17, DELETE: 46, DOWN: 40, END: 35, ENTER: 13, ESCAPE: 27, HOME: 36, INSERT: 45, LEFT: 37, NUMPAD_ADD: 107, NUMPAD_DECIMAL: 110, NUMPAD_DIVIDE: 111, NUMPAD_ENTER: 108, NUMPAD_MULTIPLY: 106, NUMPAD_SUBTRACT: 109, PAGE_DOWN: 34, PAGE_UP: 33, PERIOD: 190, RIGHT: 39, SHIFT: 16, SPACE: 32, TAB: 9, UP: 38 } }; if (n) { var r = e.attr, i = e.fn.removeAttr, s = "http://www.w3.org/2005/07/aaa", o = /^aria-/, u = /^wairole:/; e.attr = function (e, t, n) { var i = n !== undefined; return t == "role" ? i ? r.call(this, e, t, "wairole:" + n) : (r.apply(this, arguments) || "").replace(u, "") : o.test(t) ? i ? e.setAttributeNS(s, t.replace(o, "aaa:"), n) : r.call(this, e, t.replace(o, "aaa:")) : r.apply(this, arguments) }; e.fn.removeAttr = function (e) { return o.test(e) ? this.each(function () { this.removeAttributeNS(s, e.replace(o, "")) }) : i.call(this, e) } } e.fn.extend({ remove: function () { e("*", this).add(this).each(function () { e(this).triggerHandler("remove") }); return t.apply(this, arguments) }, enableSelection: function () { return this.attr("unselectable", "off").css("MozUserSelect", "").unbind("selectstart.ui") }, disableSelection: function () { return this.attr("unselectable", "on").css("MozUserSelect", "none").bind("selectstart.ui", function () { return false }) }, scrollParent: function () { var t; if (e.browser.msie && /(static|relative)/.test(this.css("position")) || /absolute/.test(this.css("position"))) { t = this.parents().filter(function () { return /(relative|absolute|fixed)/.test(e.curCSS(this, "position", 1)) && /(auto|scroll)/.test(e.curCSS(this, "overflow", 1) + e.curCSS(this, "overflow-y", 1) + e.curCSS(this, "overflow-x", 1)) }).eq(0) } else { t = this.parents().filter(function () { return /(auto|scroll)/.test(e.curCSS(this, "overflow", 1) + e.curCSS(this, "overflow-y", 1) + e.curCSS(this, "overflow-x", 1)) }).eq(0) } return /fixed/.test(this.css("position")) || !t.length ? e(document) : t } }); e.extend(e.expr[":"], { data: function (t, n, r) { return !!e.data(t, r[3]) }, focusable: function (t) { var n = t.nodeName.toLowerCase(), r = e.attr(t, "tabindex"); return (/input|select|textarea|button|object/.test(n) ? !t.disabled : "a" == n || "area" == n ? t.href || !isNaN(r) : !isNaN(r)) && !e(t)["area" == n ? "parents" : "closest"](":hidden").length }, tabbable: function (t) { var n = e.attr(t, "tabindex"); return (isNaN(n) || n >= 0) && e(t).is(":focusable") } }); e.widget = function (t, n) { var r = t.split(".")[0]; t = t.split(".")[1]; e.fn[t] = function (n) { var i = typeof n == "string", s = Array.prototype.slice.call(arguments, 1); if (i && n.substring(0, 1) == "_") { return this } if (i && a(r, t, n, s)) { var o = e.data(this[0], t); return o ? o[n].apply(o, s) : undefined } return this.each(function () { var o = e.data(this, t); !o && !i && e.data(this, t, new e[r][t](this, n))._init(); o && i && e.isFunction(o[n]) && o[n].apply(o, s) }) }; e[r] = e[r] || {}; e[r][t] = function (n, i) { var s = this; this.namespace = r; this.widgetName = t; this.widgetEventPrefix = e[r][t].eventPrefix || t; this.widgetBaseClass = r + "-" + t; this.options = e.extend({}, e.widget.defaults, e[r][t].defaults, e.metadata && e.metadata.get(n)[t], i); this.element = e(n).bind("setData." + t, function (e, t, r) { if (e.target == n) { return s._setData(t, r) } }).bind("getData." + t, function (e, t) { if (e.target == n) { return s._getData(t) } }).bind("remove", function () { return s.destroy() }) }; e[r][t].prototype = e.extend({}, e.widget.prototype, n); e[r][t].getterSetter = "option" }; e.widget.prototype = { _init: function () { }, destroy: function () { this.element.removeData(this.widgetName).removeClass(this.widgetBaseClass + "-disabled" + " " + this.namespace + "-state-disabled").removeAttr("aria-disabled") }, option: function (t, n) { var r = t, i = this; if (typeof t == "string") { if (n === undefined) { return this._getData(t) } r = {}; r[t] = n } e.each(r, function (e, t) { i._setData(e, t) }) }, _getData: function (e) { return this.options[e] }, _setData: function (e, t) { this.options[e] = t; if (e == "disabled") { this.element[t ? "addClass" : "removeClass"](this.widgetBaseClass + "-disabled" + " " + this.namespace + "-state-disabled").attr("aria-disabled", t) } }, enable: function () { this._setData("disabled", false) }, disable: function () { this._setData("disabled", true) }, _trigger: function (t, n, r) { var i = this.options[t], s = t == this.widgetEventPrefix ? t : this.widgetEventPrefix + t; n = e.Event(n); n.type = s; if (n.originalEvent) { for (var o = e.event.props.length, u; o;) { u = e.event.props[--o]; n[u] = n.originalEvent[u] } } this.element.trigger(n, r); return !(e.isFunction(i) && i.call(this.element[0], n, r) === false || n.isDefaultPrevented()) } }; e.widget.defaults = { disabled: false }; e.ui.mouse = { _mouseInit: function () { var t = this; this.element.bind("mousedown." + this.widgetName, function (e) { return t._mouseDown(e) }).bind("click." + this.widgetName, function (e) { if (t._preventClickEvent) { t._preventClickEvent = false; e.stopImmediatePropagation(); return false } }); if (e.browser.msie) { this._mouseUnselectable = this.element.attr("unselectable"); this.element.attr("unselectable", "on") } this.started = false }, _mouseDestroy: function () { this.element.unbind("." + this.widgetName); e.browser.msie && this.element.attr("unselectable", this._mouseUnselectable) }, _mouseDown: function (t) { t.originalEvent = t.originalEvent || {}; if (t.originalEvent.mouseHandled) { return } this._mouseStarted && this._mouseUp(t); this._mouseDownEvent = t; var n = this, r = t.which == 1, i = typeof this.options.cancel == "string" ? e(t.target).parents().add(t.target).filter(this.options.cancel).length : false; if (!r || i || !this._mouseCapture(t)) { return true } this.mouseDelayMet = !this.options.delay; if (!this.mouseDelayMet) { this._mouseDelayTimer = setTimeout(function () { n.mouseDelayMet = true }, this.options.delay) } if (this._mouseDistanceMet(t) && this._mouseDelayMet(t)) { this._mouseStarted = this._mouseStart(t) !== false; if (!this._mouseStarted) { t.preventDefault(); return true } } this._mouseMoveDelegate = function (e) { return n._mouseMove(e) }; this._mouseUpDelegate = function (e) { return n._mouseUp(e) }; e(document).bind("mousemove." + this.widgetName, this._mouseMoveDelegate).bind("mouseup." + this.widgetName, this._mouseUpDelegate); e.browser.safari || t.preventDefault(); t.originalEvent.mouseHandled = true; return true }, _mouseMove: function (t) { if (e.browser.msie && !t.button) { return this._mouseUp(t) } if (this._mouseStarted) { this._mouseDrag(t); return t.preventDefault() } if (this._mouseDistanceMet(t) && this._mouseDelayMet(t)) { this._mouseStarted = this._mouseStart(this._mouseDownEvent, t) !== false; this._mouseStarted ? this._mouseDrag(t) : this._mouseUp(t) } return !this._mouseStarted }, _mouseUp: function (t) { e(document).unbind("mousemove." + this.widgetName, this._mouseMoveDelegate).unbind("mouseup." + this.widgetName, this._mouseUpDelegate); if (this._mouseStarted) { this._mouseStarted = false; this._preventClickEvent = t.target == this._mouseDownEvent.target; this._mouseStop(t) } return false }, _mouseDistanceMet: function (e) { return Math.max(Math.abs(this._mouseDownEvent.pageX - e.pageX), Math.abs(this._mouseDownEvent.pageY - e.pageY)) >= this.options.distance }, _mouseDelayMet: function (e) { return this.mouseDelayMet }, _mouseStart: function (e) { }, _mouseDrag: function (e) { }, _mouseStop: function (e) { }, _mouseCapture: function (e) { return true } }; e.ui.mouse.defaults = { cancel: null, distance: 1, delay: 0 } }(jQuery)
