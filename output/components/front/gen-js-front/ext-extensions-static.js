/**
 * Basic status bar component that can be used as the bottom toolbar of any {@link Ext.Panel}.  In addition to
 * supporting the standard {@link Ext.toolbar.Toolbar} interface for adding buttons, menus and other items, the StatusBar
 * provides a greedy status element that can be aligned to either side and has convenient methods for setting the
 * status text and icon.  You can also indicate that something is processing using the {@link #showBusy} method.
 *
 *     Ext.create('Ext.Panel', {
 *         title: 'StatusBar',
 *         // etc.
 *         bbar: Ext.create('Ext.ux.StatusBar', {
 *             id: 'my-status',
 *      
 *             // defaults to use when the status is cleared:
 *             defaultText: 'Default status text',
 *             defaultIconCls: 'default-icon',
 *      
 *             // values to set initially:
 *             text: 'Ready',
 *             iconCls: 'ready-icon',
 *      
 *             // any standard Toolbar items:
 *             items: [{
 *                 text: 'A Button'
 *             }, '-', 'Plain Text']
 *         })
 *     });
 *
 *     // Update the status bar later in code:
 *     var sb = Ext.getCmp('my-status');
 *     sb.setStatus({
 *         text: 'OK',
 *         iconCls: 'ok-icon',
 *         clear: true // auto-clear after a set interval
 *     });
 *
 *     // Set the status bar to show that something is processing:
 *     sb.showBusy();
 *
 *     // processing....
 *
 *     sb.clearStatus(); // once completeed
 *
 */
Ext.define('Ext.ux.statusbar.StatusBar', {
    extend: 'Ext.toolbar.Toolbar',
    alternateClassName: 'Ext.ux.StatusBar',
    alias: 'widget.statusbar',
    requires: ['Ext.toolbar.TextItem'],
    /**
     * @cfg {String} statusAlign
     * The alignment of the status element within the overall StatusBar layout.  When the StatusBar is rendered,
     * it creates an internal div containing the status text and icon.  Any additional Toolbar items added in the
     * StatusBar's {@link #cfg-items} config, or added via {@link #method-add} or any of the supported add* methods, will be
     * rendered, in added order, to the opposite side.  The status element is greedy, so it will automatically
     * expand to take up all sapce left over by any other items.  Example usage:
     *
     *     // Create a left-aligned status bar containing a button,
     *     // separator and text item that will be right-aligned (default):
     *     Ext.create('Ext.Panel', {
     *         title: 'StatusBar',
     *         // etc.
     *         bbar: Ext.create('Ext.ux.statusbar.StatusBar', {
     *             defaultText: 'Default status text',
     *             id: 'status-id',
     *             items: [{
     *                 text: 'A Button'
     *             }, '-', 'Plain Text']
     *         })
     *     });
     *
     *     // By adding the statusAlign config, this will create the
     *     // exact same toolbar, except the status and toolbar item
     *     // layout will be reversed from the previous example:
     *     Ext.create('Ext.Panel', {
     *         title: 'StatusBar',
     *         // etc.
     *         bbar: Ext.create('Ext.ux.statusbar.StatusBar', {
     *             defaultText: 'Default status text',
     *             id: 'status-id',
     *             statusAlign: 'right',
     *             items: [{
     *                 text: 'A Button'
     *             }, '-', 'Plain Text']
     *         })
     *     });
     */
    /**
     * @cfg {String} [defaultText='']
     * The default {@link #text} value.  This will be used anytime the status bar is cleared with the
     * `useDefaults:true` option.
     */
    /**
     * @cfg {String} [defaultIconCls='']
     * The default {@link #iconCls} value (see the iconCls docs for additional details about customizing the icon).
     * This will be used anytime the status bar is cleared with the `useDefaults:true` option.
     */
    /**
     * @cfg {String} text
     * A string that will be <b>initially</b> set as the status message.  This string
     * will be set as innerHTML (html tags are accepted) for the toolbar item.
     * If not specified, the value set for {@link #defaultText} will be used.
     */
    /**
     * @cfg {String} [iconCls='']
     * A CSS class that will be **initially** set as the status bar icon and is
     * expected to provide a background image.
     *
     * Example usage:
     *
     *     // Example CSS rule:
     *     .x-statusbar .x-status-custom {
     *         padding-left: 25px;
     *         background: transparent url(images/custom-icon.gif) no-repeat 3px 2px;
     *     }
     *
     *     // Setting a default icon:
     *     var sb = Ext.create('Ext.ux.statusbar.StatusBar', {
     *         defaultIconCls: 'x-status-custom'
     *     });
     *
     *     // Changing the icon:
     *     sb.setStatus({
     *         text: 'New status',
     *         iconCls: 'x-status-custom'
     *     });
     */

    /**
     * @cfg {String} cls
     * The base class applied to the containing element for this component on render.
     */
    cls : 'x-statusbar',
    /**
     * @cfg {String} busyIconCls
     * The default {@link #iconCls} applied when calling {@link #showBusy}.
     * It can be overridden at any time by passing the `iconCls` argument into {@link #showBusy}.
     */
    busyIconCls : 'x-status-busy',
    /**
     * @cfg {String} busyText
     * The default {@link #text} applied when calling {@link #showBusy}.
     * It can be overridden at any time by passing the `text` argument into {@link #showBusy}.
     */
    busyText : 'Loading...',
    /**
     * @cfg {Number} autoClear
     * The number of milliseconds to wait after setting the status via
     * {@link #setStatus} before automatically clearing the status text and icon.
     * Note that this only applies when passing the `clear` argument to {@link #setStatus}
     * since that is the only way to defer clearing the status.  This can
     * be overridden by specifying a different `wait` value in {@link #setStatus}.
     * Calls to {@link #clearStatus} always clear the status bar immediately and ignore this value.
     */
    autoClear : 5000,

    /**
     * @cfg {String} emptyText
     * The text string to use if no text has been set. If there are no other items in
     * the toolbar using an empty string (`''`) for this value would end up in the toolbar
     * height collapsing since the empty string will not maintain the toolbar height.
     * Use `''` if the toolbar should collapse in height vertically when no text is
     * specified and there are no other items in the toolbar.
     */
    emptyText : '&#160;',

    // private
    activeThreadId : 0,

    // private
    initComponent : function(){
        var right = this.statusAlign === 'right';

        this.callParent(arguments);
        this.currIconCls = this.iconCls || this.defaultIconCls;
        this.statusEl = Ext.create('Ext.toolbar.TextItem', {
            cls: 'x-status-text ' + (this.currIconCls || ''),
            text: this.text || this.defaultText || ''
        });

        if (right) {
            this.cls += ' x-status-right';
            this.add('->');
            this.add(this.statusEl);
        } else {
            this.insert(0, this.statusEl);
            this.insert(1, '->');
        }
    },

    /**
     * Sets the status {@link #text} and/or {@link #iconCls}. Also supports automatically clearing the
     * status that was set after a specified interval.
     *
     * Example usage:
     *
     *     // Simple call to update the text
     *     statusBar.setStatus('New status');
     *
     *     // Set the status and icon, auto-clearing with default options:
     *     statusBar.setStatus({
     *         text: 'New status',
     *         iconCls: 'x-status-custom',
     *         clear: true
     *     });
     *
     *     // Auto-clear with custom options:
     *     statusBar.setStatus({
     *         text: 'New status',
     *         iconCls: 'x-status-custom',
     *         clear: {
     *             wait: 8000,
     *             anim: false,
     *             useDefaults: false
     *         }
     *     });
     *
     * @param {Object/String} config A config object specifying what status to set, or a string assumed
     * to be the status text (and all other options are defaulted as explained below). A config
     * object containing any or all of the following properties can be passed:
     *
     * @param {String} config.text The status text to display.  If not specified, any current
     * status text will remain unchanged.
     *
     * @param {String} config.iconCls The CSS class used to customize the status icon (see
     * {@link #iconCls} for details). If not specified, any current iconCls will remain unchanged.
     *
     * @param {Boolean/Number/Object} config.clear Allows you to set an internal callback that will
     * automatically clear the status text and iconCls after a specified amount of time has passed. If clear is not
     * specified, the new status will not be auto-cleared and will stay until updated again or cleared using
     * {@link #clearStatus}. If `true` is passed, the status will be cleared using {@link #autoClear},
     * {@link #defaultText} and {@link #defaultIconCls} via a fade out animation. If a numeric value is passed,
     * it will be used as the callback interval (in milliseconds), overriding the {@link #autoClear} value.
     * All other options will be defaulted as with the boolean option.  To customize any other options,
     * you can pass an object in the format:
     * 
     * @param {Number} config.clear.wait The number of milliseconds to wait before clearing
     * (defaults to {@link #autoClear}).
     * @param {Boolean} config.clear.anim False to clear the status immediately once the callback
     * executes (defaults to true which fades the status out).
     * @param {Boolean} config.clear.useDefaults False to completely clear the status text and iconCls
     * (defaults to true which uses {@link #defaultText} and {@link #defaultIconCls}).
     *
     * @return {Ext.ux.statusbar.StatusBar} this
     */
    setStatus : function(o) {
        var me = this;

        o = o || {};
        Ext.suspendLayouts();
        if (Ext.isString(o)) {
            o = {text:o};
        }
        if (o.text !== undefined) {
            me.setText(o.text);
        }
        if (o.iconCls !== undefined) {
            me.setIcon(o.iconCls);
        }

        if (o.clear) {
            var c = o.clear,
                wait = me.autoClear,
                defaults = {useDefaults: true, anim: true};

            if (Ext.isObject(c)) {
                c = Ext.applyIf(c, defaults);
                if (c.wait) {
                    wait = c.wait;
                }
            } else if (Ext.isNumber(c)) {
                wait = c;
                c = defaults;
            } else if (Ext.isBoolean(c)) {
                c = defaults;
            }

            c.threadId = this.activeThreadId;
            Ext.defer(me.clearStatus, wait, me, [c]);
        }
        Ext.resumeLayouts(true);
        return me;
    },

    /**
     * Clears the status {@link #text} and {@link #iconCls}. Also supports clearing via an optional fade out animation.
     *
     * @param {Object} [config] A config object containing any or all of the following properties.  If this
     * object is not specified the status will be cleared using the defaults below:
     * @param {Boolean} config.anim True to clear the status by fading out the status element (defaults
     * to false which clears immediately).
     * @param {Boolean} config.useDefaults True to reset the text and icon using {@link #defaultText} and
     * {@link #defaultIconCls} (defaults to false which sets the text to '' and removes any existing icon class).
     *
     * @return {Ext.ux.statusbar.StatusBar} this
     */
    clearStatus : function(o) {
        o = o || {};

        var me = this,
            statusEl = me.statusEl;

        if (o.threadId && o.threadId !== me.activeThreadId) {
            // this means the current call was made internally, but a newer
            // thread has set a message since this call was deferred.  Since
            // we don't want to overwrite a newer message just ignore.
            return me;
        }

        var text = o.useDefaults ? me.defaultText : me.emptyText,
            iconCls = o.useDefaults ? (me.defaultIconCls ? me.defaultIconCls : '') : '';

        if (o.anim) {
            // animate the statusEl Ext.Element
            statusEl.el.puff({
                remove: false,
                useDisplay: true,
                callback: function() {
                    statusEl.el.show();
                    me.setStatus({
                        text: text,
                        iconCls: iconCls
                    });
                }
            });
        } else {
             me.setStatus({
                 text: text,
                 iconCls: iconCls
             });
        }
        return me;
    },

    /**
     * Convenience method for setting the status text directly.  For more flexible options see {@link #setStatus}.
     * @param {String} text (optional) The text to set (defaults to '')
     * @return {Ext.ux.statusbar.StatusBar} this
     */
    setText : function(text) {
        var me = this;
        me.activeThreadId++;
        me.text = text || '';
        if (me.rendered) {
            me.statusEl.setText(me.text);
        }
        return me;
    },

    /**
     * Returns the current status text.
     * @return {String} The status text
     */
    getText : function(){
        return this.text;
    },

    /**
     * Convenience method for setting the status icon directly.  For more flexible options see {@link #setStatus}.
     * See {@link #iconCls} for complete details about customizing the icon.
     * @param {String} iconCls (optional) The icon class to set (defaults to '', and any current icon class is removed)
     * @return {Ext.ux.statusbar.StatusBar} this
     */
    setIcon : function(cls) {
        var me = this;

        me.activeThreadId++;
        cls = cls || '';

        if (me.rendered) {
            if (me.currIconCls) {
                me.statusEl.removeCls(me.currIconCls);
                me.currIconCls = null;
            }
            if (cls.length > 0) {
                me.statusEl.addCls(cls);
                me.currIconCls = cls;
            }
        } else {
            me.currIconCls = cls;
        }
        return me;
    },

    /**
     * Convenience method for setting the status text and icon to special values that are pre-configured to indicate
     * a "busy" state, usually for loading or processing activities.
     *
     * @param {Object/String} config (optional) A config object in the same format supported by {@link #setStatus}, or a
     * string to use as the status text (in which case all other options for setStatus will be defaulted).  Use the
     * `text` and/or `iconCls` properties on the config to override the default {@link #busyText}
     * and {@link #busyIconCls} settings. If the config argument is not specified, {@link #busyText} and
     * {@link #busyIconCls} will be used in conjunction with all of the default options for {@link #setStatus}.
     * @return {Ext.ux.statusbar.StatusBar} this
     */
    showBusy : function(o){
        if (Ext.isString(o)) {
            o = { text: o };
        }
        o = Ext.applyIf(o || {}, {
            text: this.busyText,
            iconCls: this.busyIconCls
        });
        return this.setStatus(o);
    }
});
/**
 * A control that allows selection of multiple items in a list.
 */
Ext.define('Ext.ux.form.MultiSelect', {

    extend: 'Ext.form.FieldContainer',

    mixins: [
        'Ext.util.StoreHolder',
        'Ext.form.field.Field'
    ],

    alternateClassName: 'Ext.ux.Multiselect',
    alias: ['widget.multiselectfield', 'widget.multiselect'],

    requires: ['Ext.panel.Panel', 'Ext.view.BoundList', 'Ext.layout.container.Fit'],

    uses: ['Ext.view.DragZone', 'Ext.view.DropZone'],

    layout: 'anchor',

    /**
     * @cfg {String} [dragGroup=""] The ddgroup name for the MultiSelect DragZone.
     */

    /**
     * @cfg {String} [dropGroup=""] The ddgroup name for the MultiSelect DropZone.
     */

    /**
     * @cfg {String} [title=""] A title for the underlying panel.
     */

    /**
     * @cfg {Boolean} [ddReorder=false] Whether the items in the MultiSelect list are drag/drop reorderable.
     */
    ddReorder: false,

    /**
     * @cfg {Object/Array} tbar An optional toolbar to be inserted at the top of the control's selection list.
     * This can be a {@link Ext.toolbar.Toolbar} object, a toolbar config, or an array of buttons/button configs
     * to be added to the toolbar. See {@link Ext.panel.Panel#tbar}.
     */

    /**
     * @cfg {String} [appendOnly=false] `true` if the list should only allow append drops when drag/drop is enabled.
     * This is useful for lists which are sorted.
     */
    appendOnly: false,

    /**
     * @cfg {String} [displayField="text"] Name of the desired display field in the dataset.
     */
    displayField: 'text',

    /**
     * @cfg {String} [valueField="text"] Name of the desired value field in the dataset.
     */

    /**
     * @cfg {Boolean} [allowBlank=true] `false` to require at least one item in the list to be selected, `true` to allow no
     * selection.
     */
    allowBlank: true,

    /**
     * @cfg {Number} [minSelections=0] Minimum number of selections allowed.
     */
    minSelections: 0,

    /**
     * @cfg {Number} [maxSelections=Number.MAX_VALUE] Maximum number of selections allowed.
     */
    maxSelections: Number.MAX_VALUE,

    /**
     * @cfg {String} [blankText="This field is required"] Default text displayed when the control contains no items.
     */
    blankText: 'This field is required',

    /**
     * @cfg {String} [minSelectionsText="Minimum {0}item(s) required"]
     * Validation message displayed when {@link #minSelections} is not met.
     * The {0} token will be replaced by the value of {@link #minSelections}.
     */
    minSelectionsText: 'Minimum {0} item(s) required',

    /**
     * @cfg {String} [maxSelectionsText="Maximum {0}item(s) allowed"]
     * Validation message displayed when {@link #maxSelections} is not met
     * The {0} token will be replaced by the value of {@link #maxSelections}.
     */
    maxSelectionsText: 'Maximum {0} item(s) required',

    /**
     * @cfg {String} [delimiter=","] The string used to delimit the selected values when {@link #getSubmitValue submitting}
     * the field as part of a form. If you wish to have the selected values submitted as separate
     * parameters rather than a single delimited parameter, set this to `null`.
     */
    delimiter: ',',

    /**
     * @cfg {String} [dragText="{0} Item{1}"] The text to show while dragging items.
     * {0} will be replaced by the number of items. {1} will be replaced by the plural
     * form if there is more than 1 item.
     */
    dragText: '{0} Item{1}',

    /**
     * @cfg {Ext.data.Store/Array} store The data source to which this MultiSelect is bound (defaults to `undefined`).
     * Acceptable values for this property are:
     * <div class="mdetail-params"><ul>
     * <li><b>any {@link Ext.data.Store Store} subclass</b></li>
     * <li><b>an Array</b> : Arrays will be converted to a {@link Ext.data.ArrayStore} internally.
     * <div class="mdetail-params"><ul>
     * <li><b>1-dimensional array</b> : (e.g., <tt>['Foo','Bar']</tt>)<div class="sub-desc">
     * A 1-dimensional array will automatically be expanded (each array item will be the combo
     * {@link #valueField value} and {@link #displayField text})</div></li>
     * <li><b>2-dimensional array</b> : (e.g., <tt>[['f','Foo'],['b','Bar']]</tt>)<div class="sub-desc">
     * For a multi-dimensional array, the value in index 0 of each item will be assumed to be the combo
     * {@link #valueField value}, while the value at index 1 is assumed to be the combo {@link #displayField text}.
     * </div></li></ul></div></li></ul></div>
     */

    ignoreSelectChange: 0,

    /**
     * @cfg {Object} listConfig
     * An optional set of configuration properties that will be passed to the {@link Ext.view.BoundList}'s constructor.
     * Any configuration that is valid for BoundList can be included.
     */

    initComponent: function(){
        var me = this;

        me.items = me.setupItems();

        me.bindStore(me.store, true);

        if (me.store.autoCreated) {
            me.valueField = me.displayField = 'field1';
            if (!me.store.expanded) {
                me.displayField = 'field2';
            }
        }

        if (!Ext.isDefined(me.valueField)) {
            me.valueField = me.displayField;
        }

        me.callParent();
        me.initField();
    },

    setupItems: function() {
        var me = this;

        me.boundList = Ext.create('Ext.view.BoundList', Ext.apply({
            anchor: 'none 100%',
            border: 1,
            multiSelect: true,
            store: me.store,
            displayField: me.displayField,
            disabled: me.disabled
        }, me.listConfig));

        me.boundList.getSelectionModel().on('selectionchange', me.onSelectChange, me);

        // Boundlist expects a reference to its pickerField for when an item is selected (see Boundlist#onItemClick).
        me.boundList.pickerField = me;

        // Only need to wrap the BoundList in a Panel if we have a title.
        if (!me.title) {
            return me.boundList;
        }

        // Wrap to add a title
        me.boundList.border = false;
        return {
            border: true,
            anchor: 'none 100%',
            layout: 'anchor',
            title: me.title,
            tbar: me.tbar,
            items: me.boundList
        };
    },

    onSelectChange: function(selModel, selections){
        if (!this.ignoreSelectChange) {
            this.setValue(selections);
        }
    },

    getSelected: function(){
        return this.boundList.getSelectionModel().getSelection();
    },

    // compare array values
    isEqual: function(v1, v2) {
        var fromArray = Ext.Array.from,
            i = 0,
            len;

        v1 = fromArray(v1);
        v2 = fromArray(v2);
        len = v1.length;

        if (len !== v2.length) {
            return false;
        }

        for(; i < len; i++) {
            if (v2[i] !== v1[i]) {
                return false;
            }
        }

        return true;
    },

    afterRender: function(){
        var me = this,
            records;

        me.callParent();
        if(me.disableDD){
            return;
        }
        if (me.selectOnRender) {
            records = me.getRecordsForValue(me.value);
            if (records.length) {
                ++me.ignoreSelectChange;
                me.boundList.getSelectionModel().select(records);
                --me.ignoreSelectChange;
            }
            delete me.toSelect;
        }

        if (me.ddReorder && !me.dragGroup && !me.dropGroup){
            me.dragGroup = me.dropGroup = 'MultiselectDD-' + Ext.id();
        }

        if (me.draggable || me.dragGroup){
            me.dragZone = Ext.create('Ext.view.DragZone', {
                view: me.boundList,
                ddGroup: me.dragGroup,
                dragText: me.dragText
            });
        }
        if (me.droppable || me.dropGroup){
            me.dropZone = Ext.create('Ext.view.DropZone', {
                view: me.boundList,
                ddGroup: me.dropGroup,
                handleNodeDrop: function(data, dropRecord, position) {
                    var view = this.view,
                        store = view.getStore(),
                        records = data.records,
                        index;

                    // remove the Models from the source Store
                    data.view.store.remove(records);

                    index = store.indexOf(dropRecord);
                    if (position === 'after') {
                        index++;
                    }
                    store.insert(index, records);
                    view.getSelectionModel().select(records);
                    me.fireEvent('drop', me, records);
                }
            });
        }
    },

    isValid : function() {
        var me = this,
            disabled = me.disabled,
            validate = me.forceValidation || !disabled;


        return validate ? me.validateValue(me.value) : disabled;
    },

    validateValue: function(value) {
        var me = this,
            errors = me.getErrors(value),
            isValid = Ext.isEmpty(errors);

        if (!me.preventMark) {
            if (isValid) {
                me.clearInvalid();
            } else {
                me.markInvalid(errors);
            }
        }

        return isValid;
    },

    markInvalid : function(errors) {
        // Save the message and fire the 'invalid' event
        var me = this,
            oldMsg = me.getActiveError();
        me.setActiveErrors(Ext.Array.from(errors));
        if (oldMsg !== me.getActiveError()) {
            me.updateLayout();
        }
    },

    /**
     * Clear any invalid styles/messages for this field.
     *
     * __Note:__ this method does not cause the Field's {@link #validate} or {@link #isValid} methods to return `true`
     * if the value does not _pass_ validation. So simply clearing a field's errors will not necessarily allow
     * submission of forms submitted with the {@link Ext.form.action.Submit#clientValidation} option set.
     */
    clearInvalid : function() {
        // Clear the message and fire the 'valid' event
        var me = this,
            hadError = me.hasActiveError();
        me.unsetActiveError();
        if (hadError) {
            me.updateLayout();
        }
    },

    getSubmitData: function() {
        var me = this,
            data = null,
            val;
        if (!me.disabled && me.submitValue && !me.isFileUpload()) {
            val = me.getSubmitValue();
            if (val !== null) {
                data = {};
                data[me.getName()] = val;
            }
        }
        return data;
    },

    /**
     * Returns the value that would be included in a standard form submit for this field.
     *
     * @return {String} The value to be submitted, or `null`.
     */
    getSubmitValue: function() {
        var me = this,
            delimiter = me.delimiter,
            val = me.getValue();

        return Ext.isString(delimiter) ? val.join(delimiter) : val;
    },

    getValue: function(){
        return this.value || [];
    },

    getRecordsForValue: function(value){
        var me = this,
            records = [],
            all = me.store.getRange(),
            valueField = me.valueField,
            i = 0,
            allLen = all.length,
            rec,
            j,
            valueLen;

        for (valueLen = value.length; i < valueLen; ++i) {
            for (j = 0; j < allLen; ++j) {
                rec = all[j];
                if (rec.get(valueField) == value[i]) {
                    records.push(rec);
                }
            }
        }

        return records;
    },

    setupValue: function(value){
        var delimiter = this.delimiter,
            valueField = this.valueField,
            i = 0,
            out,
            len,
            item;

        if (Ext.isDefined(value)) {
            if (delimiter && Ext.isString(value)) {
                value = value.split(delimiter);
            } else if (!Ext.isArray(value)) {
                value = [value];
            }

            for (len = value.length; i < len; ++i) {
                item = value[i];
                if (item && item.isModel) {
                    value[i] = item.get(valueField);
                }
            }
            out = Ext.Array.unique(value);
        } else {
            out = [];
        }
        return out;
    },

    setValue: function(value){
        var me = this,
            selModel = me.boundList.getSelectionModel(),
            store = me.store;

        // Store not loaded yet - we cannot set the value
        if (!store.getCount()) {
            store.on({
                load: Ext.Function.bind(me.setValue, me, [value]),
                single: true
            });
            return;
        }

        value = me.setupValue(value);
        me.mixins.field.setValue.call(me, value);

        if (me.rendered) {
            ++me.ignoreSelectChange;
            selModel.deselectAll();
            if (value.length) {
                selModel.select(me.getRecordsForValue(value));
            }
            --me.ignoreSelectChange;
        } else {
            me.selectOnRender = true;
        }
    },

    clearValue: function(){
        this.setValue([]);
    },

    onEnable: function(){
        var list = this.boundList;
        this.callParent();
        if (list) {
            list.enable();
        }
    },

    onDisable: function(){
        var list = this.boundList;
        this.callParent();
        if (list) {
            list.disable();
        }
    },

    getErrors : function(value) {
        var me = this,
            format = Ext.String.format,
            errors = [],
            numSelected;

        value = Ext.Array.from(value || me.getValue());
        numSelected = value.length;

        if (!me.allowBlank && numSelected < 1) {
            errors.push(me.blankText);
        }
        if (numSelected < me.minSelections) {
            errors.push(format(me.minSelectionsText, me.minSelections));
        }
        if (numSelected > me.maxSelections) {
            errors.push(format(me.maxSelectionsText, me.maxSelections));
        }
        return errors;
    },

    onDestroy: function(){
        var me = this;

        me.bindStore(null);
        Ext.destroy(me.dragZone, me.dropZone);
        me.callParent();
    },

    onBindStore: function(store){
        var boundList = this.boundList;

        if (boundList) {
            boundList.bindStore(store);
        }
    },






     setOwnerCmp: function(comp, instanced) {
            var me = this;
            me.parentMenu = comp.isMenuItem ? comp : null;
            me.ownerCmp = comp;
            me.registerWithOwnerCt();
            delete me.hierarchicallyHidden;
            if (me.inheritedState && instanced) {
                me.invalidateInheritedState();
            }
            if (me.reference) {
                me.fixReference();
            }



            if (instanced) {
                Ext.ComponentManager.markReferencesDirty();
            }
        }

});
// vim: ts=4:sw=4:nu:fdc=4:nospell
/*
 * RowActions plugin for Ext grid
 *
 * Contains renderer for icons and fires events when an icon is clicked
 *
 * @author    Ing. Jozef Sakáloš
 * @date      22. March 2008
 * @version   $Id: Ext.ux.grid.RowActions.js 262 2008-05-15 14:55:29Z jozo $
 *
 * @license Ext.ux.grid.RowActions is licensed under the terms of
 * the Open Source LGPL 3.0 license.  Commercial use is permitted to the extent
 * that the code/component(s) do NOT become part of another Open Source or Commercially
 * licensed development library or toolkit without explicit permission.
 * 
 * License details: http://www.gnu.org/licenses/lgpl.html
 */

/*global Ext */

// add RegExp.escape if it has not been already added
if('function' !== typeof RegExp.escape) {
	RegExp.escape = function(s) {
		if('string' !== typeof s) {
			return s;
		}
		// Note: if pasting from forum, precede ]/\ with backslash manually
		return s.replace(/([.*+?^=!:${}()|[\]\/\\])/g, '\\$1');
	}; // eo function escape
}


Ext.ns('Ext.ux.grid');

Ext.define('Ext.ux.grid.RowActions', {
    extend: 'Ext.util.Observable',
//Ext.extend(Ext.ux.grid.RowActions, Ext.util.Observable, {

	// configuration options
	// {{{
	/**
	 * @cfg {Array} actions Mandatory. Array of action configuration objects. The following
	 * configuration options of action are recognized:
	 *
	 * - @cfg {Function} callback Optional. Function to call if the action icon is clicked.
	 *   This function is called with same signature as action event and in its original scope.
	 *   If you need to call it in different scope or with another signature use 
	 *   createCallback or createDelegate functions. Works for statically defined actions. Use
	 *   callbacks configuration options for store bound actions.
	 *
	 * - @cfg {Function} cb Shortcut for callback.
	 *
	 * - @cfg {String} iconIndex Optional, however either iconIndex or iconCls must be
	 *   configured. Field name of the field of the grid store record that contains
	 *   css class of the icon to show. If configured, shown icons can vary depending
	 *   of the value of this field.
	 *
	 * - @cfg {String} iconCls. css class of the icon to show. It is ignored if iconIndex is
	 *   configured. Use this if you want static icons that are not base on the values in the record.
	 *
	 * - @cfg {Boolean} hide Optional. True to hide this action while still have a space in 
	 *   the grid column allocated to it. IMO, it doesn't make too much sense, use hideIndex instead.
	 *
	 * - @cfg (string} hideIndex Optional. Field name of the field of the grid store record that
	 *   contains hide flag (falsie [null, '', 0, false, undefined] to show, anything else to hide).
	 *
	 * - @cfg {String} qtipIndex Optional. Field name of the field of the grid store record that 
	 *   contains tooltip text. If configured, the tooltip texts are taken from the store.
	 *
	 * - @cfg {String} tooltip Optional. Tooltip text to use as icon tooltip. It is ignored if 
	 *   qtipIndex is configured. Use this if you want static tooltips that are not taken from the store.
	 *
	 * - @cfg {String} qtip Synonym for tooltip
	 *
	 * - @cfg {String} textIndex Optional. Field name of the field of the grids store record
	 *   that contains text to display on the right side of the icon. If configured, the text
	 *   shown is taken from record.
	 *
	 * - @cfg {String} text Optional. Text to display on the right side of the icon. Use this
	 *   if you want static text that are not taken from record. Ignored if textIndex is set.
	 *
	 * - @cfg {String} style Optional. Style to apply to action icon container.
	 */

	/**
	 * @cfg {String} actionEvnet Event to trigger actions, e.g. click, dblclick, mouseover (defaults to 'click')
	 */
	 actionEvent:'click'

    /**
     * @cfg {Boolean} isColumn
     * Tell ColumnModel that we are column. Do not touch!
     * @private
     */
    ,isColumn:true  
    
	/**
	 * @cfg {Boolean} autoWidth true to calculate field width for iconic actions only.
	 */
	,autoWidth:true

	/**
	 * @cfg {String} dataIndex - Do not touch!
	 * @private
	 */
	,dataIndex:''

	/**
	 * @cfg {Array} groupActions Array of action to use for group headers of grouping grids.
	 * These actions support static icons, texts and tooltips same way as actions. There is one
	 * more action config recognized:
	 * - @cfg {String} align Set it to 'left' to place action icon next to the group header text.
	 *   (defaults to undefined = icons are placed at the right side of the group header.
	 */

	/**
	 * @cfg {Object} callbacks iconCls keyed object that contains callback functions. For example:
	 * callbacks:{
	 *      'icon-open':function(...) {...}
	 *     ,'icon-save':function(...) {...}
	 * }
	 */

	/**
	 * @cfg {String} header Actions column header
	 */
	,header:''

	/**
	 * @cfg {Boolean} menuDisabled No sense to display header menu for this column
	 */
	,menuDisabled:true

	/**
	 * @cfg {Boolean} sortable Usually it has no sense to sort by this column
	 */
	,sortable:false

	/**
	 * @cfg {String} tplGroup Template for group actions
	 * @private
	 */
	,tplGroup:
		 '<tpl for="actions">'
		+'<div class="ux-grow-action-item<tpl if="\'right\'===align"> ux-action-right</tpl> '
		+'{cls}" style="{style}" qtip="{qtip}">{text}</div>'
		+'</tpl>'

	/**
	 * @cfg {String} tplRow Template for row actions
	 * @private
	 */
	,tplRow:
		 '<div class="ux-row-action">'
		+'<tpl for="actions">'
		+'<div class="ux-row-action-item {cls} <tpl if="text">'
		+'ux-row-action-text</tpl>" style="{hide}{style}" qtip="{qtip}">'
		+'<tpl if="text"><span qtip="{qtip}">{text}</span></tpl></div>'
		+'</tpl>'
		+'</div>'

	/**
	 * @cfg {String} hideMode How to hide hidden icons. Valid values are: visibility and display
	 * (defaluts to visibility).
	 */
	,hideMode:'visiblity'

	/**
	 * @cfg {Number} widthIntercept constant used for auto-width calculation
	 */
	,widthIntercept:4

	/**
	 * @cfg {Number} widthSlope constant used for auto-width calculation
	 */
	,widthSlope:21
	// }}}

	// methods
	// {{{
	/**
	 * Init function
	 * @param {Ext.grid.GridPanel} grid Grid this plugin is in
	 */
	,init:function(grid) {
		this.grid = grid;
		
		// {{{
		// setup template
		if(!this.tpl) {
			this.tpl = this.processActions(this.actions);

		} // eo template setup
		// }}}

		// calculate width
		if(this.autoWidth) {
			this.width =  this.widthSlope * this.actions.length + this.widthIntercept;
			this.fixed = true;
		}

		// body click handler
		var view = grid.getView();
		var cfg = {scope:this};
		cfg[this.actionEvent] = this.onClick;
		grid.afterRender = grid.afterRender.createSequence(function() {
			view.mainBody.on(cfg);
		}, this);
//		grid.on({
//			render:{scope:this, fn:function() {
//				view.mainBody.on(cfg);
//			}}
//		});

		// setup renderer
		if(!this.renderer) {
			this.renderer = function(value, cell, record, row, col, store) {
				cell.css += (cell.css ? ' ' : '') + 'ux-row-action-cell';
				return this.tpl.apply(this.getData(value, cell, record, row, col, store));
			}.createDelegate(this);
		}

		// actions in grouping grids support
		if(view.groupTextTpl && this.groupActions) {
			view.interceptMouse = view.interceptMouse.createInterceptor(function(e) {
				if(e.getTarget('.ux-grow-action-item')) {
					return false;
				}
			});
			view.groupTextTpl = 
				 '<div class="ux-grow-action-text">' + view.groupTextTpl +'</div>' 
				+this.processActions(this.groupActions, this.tplGroup).apply()
			;
		}
		
	} // eo function init
	// }}}
	// {{{
	/**
	 * Returns data to apply to template. Override this if needed.
	 * @param {Mixed} value 
	 * @param {Object} cell object to set some attributes of the grid cell
	 * @param {Ext.data.Record} record from which the data is extracted
	 * @param {Number} row row index
	 * @param {Number} col col index
	 * @param {Ext.data.Store} store object from which the record is extracted
	 * @returns {Object} data to apply to template
	 */
	,getData:function(value, cell, record, row, col, store) {
		return record? (record.data || {}) : {};
	} // eo function getData
	// }}}
	// {{{
	/**
	 * Processes actions configs and returns template.
	 * @param {Array} actions
	 * @param {String} template Optional. Template to use for one action item.
	 * @return {String}
	 * @private
	 */
	,processActions:function(actions, template) {
		var acts = [];

		// actions loop
		Ext.each(actions, function(a, i) {
			// save callback
			if(a.iconCls && 'function' === typeof (a.callback || a.cb)) {
				this.callbacks = this.callbacks || {};
				this.callbacks[a.iconCls] = a.callback || a.cb;
			}

			// data for intermediate template
			var o = {
				 cls:a.iconIndex ? '{' + a.iconIndex + '}' : (a.iconCls ? a.iconCls : '')
				,qtip:a.qtipIndex ? '{' + a.qtipIndex + '}' : (a.tooltip || a.qtip ? a.tooltip || a.qtip : '')
				,text:a.textIndex ? '{' + a.textIndex + '}' : (a.text ? a.text : '')
				,hide:a.hideIndex 
					? '<tpl if="' + a.hideIndex + '">' 
						+ ('display' === this.hideMode ? 'display:none' :'visibility:hidden') + ';</tpl>' 
					: (a.hide ? ('display' === this.hideMode ? 'display:none' :'visibility:hidden;') : '')
				,align:a.align || 'right'
				,style:a.style ? a.style : ''
			};
			acts.push(o);

		}, this); // eo actions loop

		var xt = new Ext.XTemplate(template || this.tplRow);
		return new Ext.XTemplate(xt.apply({actions:acts}));

	} // eo function processActions
	// }}}
	// {{{
	/**
	 * Grid body actionEvent event handler
	 * @private
	 */
	,onClick:function(e, target) {

		var view = this.grid.getView();
		var action = false;

		// handle row action click
		var row = e.getTarget('.x-grid3-row');
		var col = view.findCellIndex(target.parentNode.parentNode);

		var t = e.getTarget('.ux-row-action-item');
		if(t) {
			action = t.className.replace(/ux-row-action-item /, '');
			if(action) {
				action = action.replace(/ ux-row-action-text/, '');
				action = action.trim();
			}
		}
		if(false !== row && false !== col && false !== action) {
			var record = this.grid.store.getAt(row.rowIndex);

			// call callback if any
			if(this.callbacks && 'function' === typeof this.callbacks[action]) {
				this.callbacks[action](this.grid, record, action, row.rowIndex, col);
			}

			// fire events
			if(true !== this.eventsSuspended && false === this.fireEvent('beforeaction', this.grid, record, action, row.rowIndex, col)) {
				return;
			}
			else if(true !== this.eventsSuspended) {
				this.fireEvent('action', this.grid, record, action, row.rowIndex, col);
			}

		}

		// handle group action click
		t = e.getTarget('.ux-grow-action-item');
		if(t) {
			// get groupId
			var group = view.findGroup(target);
			var groupId = group ? group.id.replace(/ext-gen[0-9]+-gp-/, '') : null;
            
			// get matching records
			var records;
			if(groupId) {
                /* agarcia: necesario porque sino falla obtener los registros del grupo cuando
                 *          el renderer del campo por el que se está agrupando incluye tags
                 */
                var groupIdSearch = Ext.util.Format.htmlEncode(groupId);
				var re = new RegExp(RegExp.escape(groupIdSearch));
				records = this.grid.store.queryBy(function(r) {
					return r._groupId.match(re);
				});
				records = records ? records.items : [];
			}
			action = t.className.replace(/ux-grow-action-item (ux-action-right )*/, '');

			// call callback if any
			if(this.callbacks && 'function' === typeof this.callbacks[action]) {
				this.callbacks[action](this.grid, records, action, groupId);
			}

			// fire events
			if(true !== this.eventsSuspended && false === this.fireEvent('beforegroupaction', this.grid, records, action, groupId)) {
				return false;
			}
			this.fireEvent('groupaction', this.grid, records, action, groupId);
		}
	} // eo function onClick
	// }}}
	/**
	 * @class Ext.ux.grid.RowActions
	 *
	 * CSS rules from Ext.ux.RowActions.css are mandatory
	 *
	 * Important general information: Actions are identified by iconCls. Wherever an <i>action</i>
	 * is referenced (event argument, callback argument), the iconCls of clicked icon is used.
	 * In another words, action identifier === iconCls.
	 *
	 * Creates new RowActions plugin
	 * @extends-ext Ext.util.Observable
	 * @constructor
	 * @param {Object} config The config object
	 */
	,constructor: function(config) {

		//Ext.ux.grid.RowActions = function(config) {
			Ext.apply(this, config);

			// {{{
			this.addEvents(
				/**
				 * @event beforeaction
				 * Fires before action event. Return false to cancel the subsequent action event.
				 * @param {Ext.grid.GridPanel} grid
				 * @param {Ext.data.Record} record Record corresponding to row clicked
				 * @param {String} action Identifies the action icon clicked. Equals to icon css class name.
				 * @param {Integer} rowIndex Index of clicked grid row
				 * @param {Integer} colIndex Index of clicked grid column that contains all action icons
				 */
				 'beforeaction'
				/**
				 * @event action
				 * Fires when icon is clicked
				 * @param {Ext.grid.GridPanel} grid
				 * @param {Ext.data.Record} record Record corresponding to row clicked
				 * @param {String} action Identifies the action icon clicked. Equals to icon css class name.
				 * @param {Integer} rowIndex Index of clicked grid row
				 * @param {Integer} colIndex Index of clicked grid column that contains all action icons
				 */
				,'action'
				/**
				 * @event beforegroupaction
				 * Fires before group action event. Return false to cancel the subsequent groupaction event.
				 * @param {Ext.grid.GridPanel} grid
				 * @param {Array} records Array of records in this group
				 * @param {String} action Identifies the action icon clicked. Equals to icon css class name.
				 * @param {String} groupId Identifies the group clicked
				 */
				,'beforegroupaction'
				/**
				 * @event groupaction
				 * Fires when icon in a group header is clicked
				 * @param {Ext.grid.GridPanel} grid
				 * @param {Array} records Array of records in this group
				 * @param {String} action Identifies the action icon clicked. Equals to icon css class name.
				 * @param {String} groupId Identifies the group clicked
				 */
				,'groupaction'
			);
			// }}}

			// call parent
			Ext.ux.grid.RowActions.superclass.constructor.call(this);
		}

});

// registre xtype
//Ext.reg('rowactions', 'Ext.ux.grid.RowActions');

// eof
/*
 * Note that this control will most likely remain as an example, and not as a core Ext form
 * control.  However, the API will be changing in a future release and so should not yet be
 * treated as a final, stable API at this time.
 */

/**
 * A control that allows selection of between two Ext.ux.form.MultiSelect controls.
 */
Ext.define('Ext.ux.form.ItemSelector', {
    extend: 'Ext.ux.form.MultiSelect',
    alias: ['widget.itemselectorfield', 'widget.itemselector'],
    alternateClassName: ['Ext.ux.ItemSelector'],
    requires: [
        'Ext.button.Button',
        'Ext.ux.form.MultiSelect'
    ],

    /**
     * @cfg {Boolean} [hideNavIcons=false] True to hide the navigation icons
     */
    hideNavIcons:false,

    /**
     * @cfg {Array} buttons Defines the set of buttons that should be displayed in between the ItemSelector
     * fields. Defaults to <tt>['top', 'up', 'add', 'remove', 'down', 'bottom']</tt>. These names are used
     * to build the button CSS class names, and to look up the button text labels in {@link #buttonsText}.
     * This can be overridden with a custom Array to change which buttons are displayed or their order.
     */
    buttons: ['top', 'up', 'add', 'remove', 'down', 'bottom'],

    /**
     * @cfg {Object} buttonsText The tooltips for the {@link #buttons}.
     * Labels for buttons.
     */
    buttonsText: {
        top: "Move to Top",
        up: "Move Up",
        add: "Add to Selected",
        remove: "Remove from Selected",
        down: "Move Down",
        bottom: "Move to Bottom"
    },

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    initComponent: function() {
        var me = this;

        me.ddGroup = me.id + '-dd';
        me.callParent();

        // bindStore must be called after the fromField has been created because
        // it copies records from our configured Store into the fromField's Store
        me.bindStore(me.store);
    },

    createList: function(title){
        var me = this;

        return Ext.create('Ext.ux.form.MultiSelect', {
            // We don't want the multiselects themselves to act like fields,
            // so override these methods to prevent them from including
            // any of their values
            submitValue: false,
            getSubmitData: function(){
                return null;
            },
            getModelData: function(){
                return null;
            },
            flex: 1,
            dragGroup: me.ddGroup,
            dropGroup: me.ddGroup,
            title: title,
            disableDD: me.disableDD,
            store: {
                model: me.store.model,
                data: []
            },
            displayField: me.displayField,
            valueField: me.valueField,
            ddReorder: me.ddReorder,
            disabled: me.disabled,
            listeners: {
                boundList: {
                    scope: me,
                    itemdblclick: me.onItemDblClick,
                    drop: me.syncValue
                }
            }
        });
    },

    setupItems: function() {
        var me = this;

        me.fromField = me.createList(me.fromTitle);
        me.toField = me.createList(me.toTitle);

        return [
            me.fromField,
            {
                xtype: 'container',
                margin: '0 4',
                layout: {
                    type: 'vbox',
                    pack: 'center'
                },
                items: me.createButtons()
            },
            me.toField
        ];
    },

    createButtons: function() {
        var me = this,
            buttons = [];

        if (!me.hideNavIcons) {
            Ext.Array.forEach(me.buttons, function(name) {
                buttons.push({
                    xtype: 'button',
                    tooltip: me.buttonsText[name],
                    handler: me['on' + Ext.String.capitalize(name) + 'BtnClick'],
                    cls: Ext.baseCSSPrefix + 'form-itemselector-btn',
                    iconCls: Ext.baseCSSPrefix + 'form-itemselector-' + name,
                    navBtn: true,
                    scope: me,
                    margin: '4 0 0 0'
                });
            });
        }
        return buttons;
    },

    /**
     * Get the selected records from the specified list.
     *
     * Records will be returned *in store order*, not in order of selection.
     * @param {Ext.view.BoundList} list The list to read selections from.
     * @return {Ext.data.Model[]} The selected records in store order.
     *
     */
    getSelections: function(list) {
        var store = list.getStore();

        return Ext.Array.sort(list.getSelectionModel().getSelection(), function(a, b) {
            a = store.indexOf(a);
            b = store.indexOf(b);

            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            return 0;
        });
    },

    onTopBtnClick : function() {
        var list = this.toField.boundList,
            store = list.getStore(),
            selected = this.getSelections(list);

        store.suspendEvents();
        store.remove(selected, true);
        store.insert(0, selected);
        store.resumeEvents();
        list.refresh();
        this.syncValue();
        list.getSelectionModel().select(selected);
    },

    onBottomBtnClick : function() {
        var list = this.toField.boundList,
            store = list.getStore(),
            selected = this.getSelections(list);

        store.suspendEvents();
        store.remove(selected, true);
        store.add(selected);
        store.resumeEvents();
        list.refresh();
        this.syncValue();
        list.getSelectionModel().select(selected);
    },

    onUpBtnClick : function() {
        var list = this.toField.boundList,
            store = list.getStore(),
            selected = this.getSelections(list),
            rec,
            i = 0,
            len = selected.length,
            index = 0;

        // Move each selection up by one place if possible
        store.suspendEvents();
        for (; i < len; ++i, index++) {
            rec = selected[i];
            index = Math.max(index, store.indexOf(rec) - 1);
            store.remove(rec, true);
            store.insert(index, rec);
        }
        store.resumeEvents();
        list.refresh();
        this.syncValue();
        list.getSelectionModel().select(selected);
    },

    onDownBtnClick : function() {
        var list = this.toField.boundList,
            store = list.getStore(),
            selected = this.getSelections(list),
            rec,
            i = selected.length - 1,
            index = store.getCount() - 1;

        // Move each selection down by one place if possible
        store.suspendEvents();
        for (; i > -1; --i, index--) {
            rec = selected[i];
            index = Math.min(index, store.indexOf(rec) + 1);
            store.remove(rec, true);
            store.insert(index, rec);
        }
        store.resumeEvents();
        list.refresh();
        this.syncValue();
        list.getSelectionModel().select(selected);
    },

    onAddBtnClick : function() {
        var me = this,
            selected = me.getSelections(me.fromField.boundList);

        me.moveRec(true, selected);
        me.toField.boundList.getSelectionModel().select(selected);
    },

    onRemoveBtnClick : function() {
        var me = this,
            selected = me.getSelections(me.toField.boundList);

        me.moveRec(false, selected);
        me.fromField.boundList.getSelectionModel().select(selected);
    },

    moveRec: function(add, recs) {
        var me = this,
            fromField = me.fromField,
            toField   = me.toField,
            fromStore = add ? fromField.store : toField.store,
            toStore   = add ? toField.store   : fromField.store;

        fromStore.suspendEvents();
        toStore.suspendEvents();
        fromStore.remove(recs);
        toStore.add(recs);
        fromStore.resumeEvents();
        toStore.resumeEvents();

        fromField.boundList.refresh();
        toField.boundList.refresh();

        me.syncValue();
    },

    // Synchronizes the submit value with the current state of the toStore
    syncValue: function() {
        var me = this;
        me.mixins.field.setValue.call(me, me.setupValue(me.toField.store.getRange()));
    },

    onItemDblClick: function(view, rec) {
        this.moveRec(view === this.fromField.boundList, rec);
    },

    setValue: function(value) {
        var me = this,
            fromField = me.fromField,
            toField = me.toField,
            fromStore = fromField.store,
            toStore = toField.store,
            selected;

        // Wait for from store to be loaded
        if (!me.fromStorePopulated) {
            me.fromField.store.on({
                load: Ext.Function.bind(me.setValue, me, [value]),
                single: true
            });
            return;
        }

        value = me.setupValue(value);
        me.mixins.field.setValue.call(me, value);

        selected = me.getRecordsForValue(value);

        // Clear both left and right Stores.
        // Both stores must not fire events during this process.
        fromStore.suspendEvents();
        toStore.suspendEvents();
        fromStore.removeAll();
        toStore.removeAll();

        // Reset fromStore
        me.populateFromStore(me.store);

        // Copy selection across to toStore
        Ext.Array.forEach(selected, function(rec){
            // In the from store, move it over
            if (fromStore.indexOf(rec) > -1) {
                fromStore.remove(rec);
            }
            toStore.add(rec);
        });

        // Stores may now fire events
        fromStore.resumeEvents();
        toStore.resumeEvents();

        // Refresh both sides and then update the app layout
        Ext.suspendLayouts();
        fromField.boundList.refresh();
        toField.boundList.refresh();
        Ext.resumeLayouts(true);
    },

    onBindStore: function(store, initial) {
        var me = this;

        if (me.fromField) {
            me.fromField.store.removeAll();
            me.toField.store.removeAll();

            // Add everything to the from field as soon as the Store is loaded
            if (store.getCount()) {
                me.populateFromStore(store);
            } else {
                me.store.on('load', me.populateFromStore, me);
            }
        }
    },

    populateFromStore: function(store) {
        var fromStore = this.fromField.store;

        // Flag set when the fromStore has been loaded
        this.fromStorePopulated = true;

        fromStore.add(store.getRange());

        // setValue waits for the from Store to be loaded
        fromStore.fireEvent('load', fromStore);
    },

    onEnable: function(){
        var me = this;

        me.callParent();
        me.fromField.enable();
        me.toField.enable();

        Ext.Array.forEach(me.query('[navBtn]'), function(btn){
            btn.enable();
        });
    },

    onDisable: function(){
        var me = this;

        me.callParent();
        me.fromField.disable();
        me.toField.disable();

        Ext.Array.forEach(me.query('[navBtn]'), function(btn){
            btn.disable();
        });
    },

    onDestroy: function(){
        this.bindStore(null);
        this.callParent();
    }
});
//vim: ts=4:sw=4:nu:fdc=2:nospell
/*global Ext, console */
/**
 * @class Ext.ux.state.HttpProvider
 * @extends Ext.state.Provider
 *
 * Buffering state provider that sends and receives state information to/from server
 *
 * @author Ing. Jozef Sakáloš
 * @copyright (c) 2008, Ing. Jozef Sakáloš
 * @version 1.2
 * @revision $Id: Ext.ux.state.HttpProvider.js 589 2009-02-21 23:30:18Z jozo $
 * @depends Ext.ux.util
 *
 * @license Ext.ux.state.HttpProvider is licensed under the terms of
 * the Open Source LGPL 3.0 license. Commercial use is permitted to the extent
 * that the code/component(s) do NOT become part of another Open Source or Commercially
 * licensed development library or toolkit without explicit permission.
 *
 * <p>License details: <a href="http://www.gnu.org/licenses/lgpl.html"
 * target="_blank">http://www.gnu.org/licenses/lgpl.html</a></p>
 *
 * @forum 24970
 * @demo http://cellactions.extjs.eu
 *
 * @donate
 * <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_blank">
 * <input type="hidden" name="cmd" value="_s-xclick">
 * <input type="hidden" name="hosted_button_id" value="3430419">
 * <input type="image" src="https://www.paypal.com/en_US/i/btn/x-click-butcc-donate.gif"
 * border="0" name="submit" alt="PayPal - The safer, easier way to pay online.">
 * <img alt="" border="0" src="https://www.paypal.com/en_US/i/scr/pixel.gif" width="1" height="1">
 * </form>
 */

Ext.ns('Ext.ux.state');

//Ext.extend(Ext.ux.state.HttpProvider, Ext.state.Provider, {
Ext.define("Ext.ux.state.HttpProvider", {
	extend: "Ext.state.Provider",

	//	localizable texts
	saveSuccessText: 'Save Success',
	saveFailureText: 'Save Failure',
	readSuccessText: 'Read Success',
	readFailureText: 'Read Failure',
	dataErrorText: 'Data Error',



	/*
	 * Creates new HttpProvider
	 * @constructor
	 * @param {Object} config Configuration object
	 */

	//Ext.ux.state.HttpProvider = function(config) {

	constructor: function(config) {
		//	call parent
		//Ext.ux.state.HttpProvider.superclass.constructor.call(this);
		this.callParent(arguments);

		Ext.apply(this, config, {
			//		defaults
			delay: 750, // buffer changes for 750 ms
			dirty: false,
			started: false,
			autoStart: true,
			autoRead: true,
			user: 'user',
			id: 1,
			session: 'session',
			logFailure: false,
			logSuccess: false,
			queue: [],
			url: '.',
			readUrl: undefined,
			saveUrl: undefined,
			method: 'post',
			saveBaseParams: {},
			readBaseParams: {},
			paramNames: {
				id: 'id',
				name: 'name',
				value: 'value',
				user: 'user',
				session: 'session',
				data: 'data'
			}
		}); // eo apply

		if (this.autoRead) {
			this.readState();
		}

		this.dt = new Ext.util.DelayedTask(this.submitState, this);
		if (this.autoStart) {
			this.start();
		}
	}, // eo constructor

	/*
	 * Initializes state from the passed state object or array.
	 * This method can be called early during page load having the state Array/Object
	 * retrieved from database by server.
	 * @param {Array/Object} state State to initialize state manager with
	 */

	initState: function(state) {
		if (state instanceof Array) {
			Ext.each(state, function(item) {
				this.state[item.name] = this.decodeValue(item[this.paramNames.value]);
			}, this);
		} else {
			this.state = state ? state : {};
		}
	}, // eo function initState


	/*
	 * Sets the passed state variable name to the passed value and queues the change
	 * @param {String} name Name of the state variable
	 * @param {Mixed} value Value of the state variable
	 */

	set: function(name, value) {
		if (!name) {
			return;
		}

		this.queueChange(name, value);

	}, // eo function set


	/*
	 * Starts submitting state changes to server
	 */

	start: function() {
		this.dt.delay(this.delay);
		this.started = true;
	}, // eo function start


	/*
	 * Stops submitting state changes
	 */

	stop: function() {
		this.dt.cancel();
		this.started = false;
	}, // eo function stop


	/*
	 * private, queues the state change if state has changed
	 */

	queueChange: function(name, value) {
		var changed = undefined === this.state[name] || this.state[name] !== value;
		var o = {};
		var i;
		var found = false;
		if (changed) {
			o[this.paramNames.name] = name;
			o[this.paramNames.value] = this.encodeValue(value);
			for (i = 0; i < this.queue.length; i++) {
				if (this.queue[i].name === o.name) {
					this.queue[i] = o;
					found = true;
				}
			}
			if (false === found) {
				this.queue.push(o);
			}
			this.dirty = true;
		}
		if (this.started) {
			this.start();
		}
		return changed;
	}, // eo function bufferChange


	/*
	 * private, submits state to server by asynchronous Ajax request
	 */

	submitState: function() {
		if (!this.dirty) {
			this.dt.delay(this.delay);
			return;
		}
		this.dt.cancel();

		var o = {
			url: this.saveUrl || this.url,
			method: this.method,
			scope: this,
			success: this.onSaveSuccess,
			failure: this.onSaveFailure,
			//queue: Ext.ux.util.clone(this.queue),
			queue: Ext.clone(this.queue),
			params: {}
		};

		var params = Ext.apply({}, this.saveBaseParams);
		params[this.paramNames.id] = this.id;
		params[this.paramNames.user] = this.user;
		params[this.paramNames.session] = this.session;
		params[this.paramNames.data] = Ext.encode(o.queue);

		Ext.apply(o.params, params);

		//	be optimistic
		this.dirty = false;

		Ext.Ajax.request(o);
	}, // eo function submitState


	/*
	 * Clears the state variable
	 * @param {String} name Name of the variable to clear
	 */

	clear: function(name) {
		this.set(name, undefined);
	}, // eo function clear


	/*
	 * private, save success callback
	 */

	onSaveSuccess: function(response, options) {
		var o = {};
		try {
			o = Ext.decode(response.responseText);
		} catch (e) {
			if (true === this.logFailure) {
				this.log(this.saveFailureText, e, response);
			}
			this.dirty = true;
			return;
		}
		if (true !== o.success) {
			if (true === this.logFailure) {
				this.log(this.saveFailureText, o, response);
			}
			this.dirty = true;
		} else {
			Ext.each(options.queue, function(item) {
				if (!item) {
					return;
				}
				var name = item[this.paramNames.name];
				var value = this.decodeValue(item[this.paramNames.value]);

				if (undefined === value || null === value) {
					Ext.ux.state.HttpProvider.superclass.clear.call(this, name);
				} else {
					//				parent sets value and fires event
					Ext.ux.state.HttpProvider.superclass.set.call(this, name, value);
				}
			}, this);
			if (false === this.dirty) {
				this.queue = [];
			} else {
				var i, j, found;
				for (i = 0; i < options.queue.length; i++) {
					found = false;
					for (j = 0; j < this.queue.length; j++) {
						if (options.queue[i].name === this.queue[j].name) {
							found = true;
							break;
						}
					}
					if (true === found && this.encodeValue(options.queue[i].value) === this.encodeValue(this.queue[j].value)) {
						this.queue.remove(this.queue[j]);
					}
				}
			}
			if (true === this.logSuccess) {
				this.log(this.saveSuccessText, o, response);
			}
			this.fireEvent('savesuccess', this);
		}
	}, // eo function onSaveSuccess


	/*
	 * private, save failure callback
	 */

	onSaveFailure: function(response, options) {
		if (true === this.logFailure) {
			this.log(this.saveFailureText, response);
		}
		this.dirty = true;
		this.fireEvent('savefailure', this);
	}, // eo function onSaveFailure


	/*
	 * private, read state callback
	 */

	onReadFailure: function(response, options) {
		if (true === this.logFailure) {
			this.log(this.readFailureText, response);
		}
		this.fireEvent('readfailure', this);

	}, // eo function onReadFailure


	/*
	 * private, read success callback
	 */

	onReadSuccess: function(response, options) {
		var o = {},
			data;
		try {
			o = Ext.decode(response.responseText);
		} catch (e) {
			if (true === this.logFailure) {
				this.log(this.readFailureText, e, response);
			}
			return;
		}
		if (true !== o.success) {
			if (true === this.logFailure) {
				this.log(this.readFailureText, o, response);
			}
		} else {
			data = o[this.paramNames.data];
			if (!(data instanceof Array) && true === this.logFailure) {
				this.log(this.dataErrorText, data, response);
				return;
			}
			Ext.each(data, function(item) {
				this.state[item[this.paramNames.name]] = this.decodeValue(item[this.paramNames.value]);
			}, this);
			this.queue = [];
			this.dirty = false;
			if (true === this.logSuccess) {
				this.log(this.readSuccessText, data, response);
			}
			this.fireEvent('readsuccess', this);
		}
	}, // eo function onReadSuccess


	/**
	 * Reads saved state from server by sending asynchronous Ajax request and processing the response
	 */

	readState: function() {
		var o = {
			url: this.readUrl || this.url,
			method: this.method,
			scope: this,
			success: this.onReadSuccess,
			failure: this.onReadFailure,
			params: {}
		};

		var params = Ext.apply({}, this.readBaseParams);
		params[this.paramNames.id] = this.id;
		params[this.paramNames.user] = this.user;
		params[this.paramNames.session] = this.session;

		Ext.apply(o.params, params);
		Ext.Ajax.request(o);
	}, // eo function readState


	/**
	 * private, logs errors or successes
	 */

	log: function() {
			if (console) {
				console.log.apply(console, arguments);
			}
		} // eo log



}); // eo extend

//eof
// vim: ts=4:sw=4:nu:fdc=4:nospell
/*global Ext */
/**
 * @singleton 
 * @class Ext.ux.util
 *
 * Contains utilities that do not fit elsewhere
 *
 * @author     Ing. Jozef Sakáloš
 * @copyright  (c) 2009, Ing. Jozef Sakáloš
 * @version    1.0
 * @date       30. January 2009
 * @revision   $Id: Ext.ux.util.js 620 2009-03-09 12:41:44Z jozo $
 *
 * @license
 * Ext.ux.util.js is licensed under the terms of
 * the Open Source LGPL 3.0 license.  Commercial use is permitted to the extent
 * that the code/component(s) do NOT become part of another Open Source or Commercially
 * licensed development library or toolkit without explicit permission.
 *
 * <p>License details: <a href="http://www.gnu.org/licenses/lgpl.html"
 * target="_blank">http://www.gnu.org/licenses/lgpl.html</a></p>
 *
 * @donate
 * <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_blank">
 * <input type="hidden" name="cmd" value="_s-xclick">
 * <input type="hidden" name="hosted_button_id" value="3430419">
 * <input type="image" src="https://www.paypal.com/en_US/i/btn/x-click-butcc-donate.gif" 
 * border="0" name="submit" alt="PayPal - The safer, easier way to pay online.">
 * <img alt="" border="0" src="https://www.paypal.com/en_US/i/scr/pixel.gif" width="1" height="1">
 * </form>
 */

Ext.ns('Ext.ux.util');

// {{{
/**
 * @param {String} s
 * @return {String} MD5 sum
 * Calculates MD5 sum of the argument
 * @forum   28460
 * @author  <a href="http://extjs.com/forum/member.php?u=13648">wm003</a>
 * @version 1.0
 * @date    20. March 2008
 *
 */
Ext.ux.util.MD5 = function(s) {
    var hexcase = 0;
    var chrsz = 8;

    function safe_add(x, y){
        var lsw = (x & 0xFFFF) + (y & 0xFFFF);
        var msw = (x >> 16) + (y >> 16) + (lsw >> 16);
        return (msw << 16) | (lsw & 0xFFFF);
    }
    function bit_rol(num, cnt){
        return (num << cnt) | (num >>> (32 - cnt));
    }
    function md5_cmn(q, a, b, x, s, t){
        return safe_add(bit_rol(safe_add(safe_add(a, q), safe_add(x, t)), s),b);
    }
    function md5_ff(a, b, c, d, x, s, t){
        return md5_cmn((b & c) | ((~b) & d), a, b, x, s, t);
    }
    function md5_gg(a, b, c, d, x, s, t){
        return md5_cmn((b & d) | (c & (~d)), a, b, x, s, t);
    }
    function md5_hh(a, b, c, d, x, s, t){
        return md5_cmn(b ^ c ^ d, a, b, x, s, t);
    }
    function md5_ii(a, b, c, d, x, s, t){
        return md5_cmn(c ^ (b | (~d)), a, b, x, s, t);
    }

    function core_md5(x, len){
        x[len >> 5] |= 0x80 << ((len) % 32);
        x[(((len + 64) >>> 9) << 4) + 14] = len;
        var a =  1732584193;
        var b = -271733879;
        var c = -1732584194;
        var d =  271733878;
        for(var i = 0; i < x.length; i += 16){
            var olda = a;
            var oldb = b;
            var oldc = c;
            var oldd = d;
            a = md5_ff(a, b, c, d, x[i+ 0], 7 , -680876936);
            d = md5_ff(d, a, b, c, x[i+ 1], 12, -389564586);
            c = md5_ff(c, d, a, b, x[i+ 2], 17,  606105819);
            b = md5_ff(b, c, d, a, x[i+ 3], 22, -1044525330);
            a = md5_ff(a, b, c, d, x[i+ 4], 7 , -176418897);
            d = md5_ff(d, a, b, c, x[i+ 5], 12,  1200080426);
            c = md5_ff(c, d, a, b, x[i+ 6], 17, -1473231341);
            b = md5_ff(b, c, d, a, x[i+ 7], 22, -45705983);
            a = md5_ff(a, b, c, d, x[i+ 8], 7 ,  1770035416);
            d = md5_ff(d, a, b, c, x[i+ 9], 12, -1958414417);
            c = md5_ff(c, d, a, b, x[i+10], 17, -42063);
            b = md5_ff(b, c, d, a, x[i+11], 22, -1990404162);
            a = md5_ff(a, b, c, d, x[i+12], 7 ,  1804603682);
            d = md5_ff(d, a, b, c, x[i+13], 12, -40341101);
            c = md5_ff(c, d, a, b, x[i+14], 17, -1502002290);
            b = md5_ff(b, c, d, a, x[i+15], 22,  1236535329);
            a = md5_gg(a, b, c, d, x[i+ 1], 5 , -165796510);
            d = md5_gg(d, a, b, c, x[i+ 6], 9 , -1069501632);
            c = md5_gg(c, d, a, b, x[i+11], 14,  643717713);
            b = md5_gg(b, c, d, a, x[i+ 0], 20, -373897302);
            a = md5_gg(a, b, c, d, x[i+ 5], 5 , -701558691);
            d = md5_gg(d, a, b, c, x[i+10], 9 ,  38016083);
            c = md5_gg(c, d, a, b, x[i+15], 14, -660478335);
            b = md5_gg(b, c, d, a, x[i+ 4], 20, -405537848);
            a = md5_gg(a, b, c, d, x[i+ 9], 5 ,  568446438);
            d = md5_gg(d, a, b, c, x[i+14], 9 , -1019803690);
            c = md5_gg(c, d, a, b, x[i+ 3], 14, -187363961);
            b = md5_gg(b, c, d, a, x[i+ 8], 20,  1163531501);
            a = md5_gg(a, b, c, d, x[i+13], 5 , -1444681467);
            d = md5_gg(d, a, b, c, x[i+ 2], 9 , -51403784);
            c = md5_gg(c, d, a, b, x[i+ 7], 14,  1735328473);
            b = md5_gg(b, c, d, a, x[i+12], 20, -1926607734);
            a = md5_hh(a, b, c, d, x[i+ 5], 4 , -378558);
            d = md5_hh(d, a, b, c, x[i+ 8], 11, -2022574463);
            c = md5_hh(c, d, a, b, x[i+11], 16,  1839030562);
            b = md5_hh(b, c, d, a, x[i+14], 23, -35309556);
            a = md5_hh(a, b, c, d, x[i+ 1], 4 , -1530992060);
            d = md5_hh(d, a, b, c, x[i+ 4], 11,  1272893353);
            c = md5_hh(c, d, a, b, x[i+ 7], 16, -155497632);
            b = md5_hh(b, c, d, a, x[i+10], 23, -1094730640);
            a = md5_hh(a, b, c, d, x[i+13], 4 ,  681279174);
            d = md5_hh(d, a, b, c, x[i+ 0], 11, -358537222);
            c = md5_hh(c, d, a, b, x[i+ 3], 16, -722521979);
            b = md5_hh(b, c, d, a, x[i+ 6], 23,  76029189);
            a = md5_hh(a, b, c, d, x[i+ 9], 4 , -640364487);
            d = md5_hh(d, a, b, c, x[i+12], 11, -421815835);
            c = md5_hh(c, d, a, b, x[i+15], 16,  530742520);
            b = md5_hh(b, c, d, a, x[i+ 2], 23, -995338651);
            a = md5_ii(a, b, c, d, x[i+ 0], 6 , -198630844);
            d = md5_ii(d, a, b, c, x[i+ 7], 10,  1126891415);
            c = md5_ii(c, d, a, b, x[i+14], 15, -1416354905);
            b = md5_ii(b, c, d, a, x[i+ 5], 21, -57434055);
            a = md5_ii(a, b, c, d, x[i+12], 6 ,  1700485571);
            d = md5_ii(d, a, b, c, x[i+ 3], 10, -1894986606);
            c = md5_ii(c, d, a, b, x[i+10], 15, -1051523);
            b = md5_ii(b, c, d, a, x[i+ 1], 21, -2054922799);
            a = md5_ii(a, b, c, d, x[i+ 8], 6 ,  1873313359);
            d = md5_ii(d, a, b, c, x[i+15], 10, -30611744);
            c = md5_ii(c, d, a, b, x[i+ 6], 15, -1560198380);
            b = md5_ii(b, c, d, a, x[i+13], 21,  1309151649);
            a = md5_ii(a, b, c, d, x[i+ 4], 6 , -145523070);
            d = md5_ii(d, a, b, c, x[i+11], 10, -1120210379);
            c = md5_ii(c, d, a, b, x[i+ 2], 15,  718787259);
            b = md5_ii(b, c, d, a, x[i+ 9], 21, -343485551);
            a = safe_add(a, olda);
            b = safe_add(b, oldb);
            c = safe_add(c, oldc);
            d = safe_add(d, oldd);
        }
        return [a, b, c, d];
    }
    function str2binl(str){
        var bin = [];
        var mask = (1 << chrsz) - 1;
        for(var i = 0; i < str.length * chrsz; i += chrsz) {
            bin[i>>5] |= (str.charCodeAt(i / chrsz) & mask) << (i%32);
        }
        return bin;
    }
    function binl2hex(binarray){
        var hex_tab = hexcase ? "0123456789ABCDEF" : "0123456789abcdef";
        var str = "";
        for(var i = 0; i < binarray.length * 4; i++) {
            str += hex_tab.charAt((binarray[i>>2] >> ((i%4)*8+4)) & 0xF) + hex_tab.charAt((binarray[i>>2] >> ((i%4)*8  )) & 0xF);
        }
        return str;
    }
    return binl2hex(core_md5(str2binl(s), s.length * chrsz));
};  
// }}}
// {{{
/**
 * Clone Function
 * @param {Object/Array} o Object or array to clone
 * @return {Object/Array} Deep clone of an object or an array
 * @author Ing. Jozef Sakáloš
 */
Ext.ux.util.clone = function(o) {
	if(!o || 'object' !== typeof o) {
		return o;
	}
	if('function' === typeof o.clone) {
		return o.clone();
	}
	var c = '[object Array]' === Object.prototype.toString.call(o) ? [] : {};
	var p, v;
	for(p in o) {
		if(o.hasOwnProperty(p)) {
			v = o[p];
			if(v && 'object' === typeof v) {
				c[p] = Ext.ux.util.clone(v);
			}
			else {
				c[p] = v;
			}
		}
	}
	return c;
}; // eo function clone
// }}}
// {{{
/**
 * Copies the source object properties with names that match target object properties to the target. 
 * Undefined properties of the source object are ignored even if names match.
 * This way it is possible to create a target object with defaults, apply source to it not overwriting 
 * target defaults with <code>undefined</code> values of source.
 * @param {Object} t The target object
 * @param {Object} s (optional) The source object. Equals to scope in which the function runs if omitted. That 
 * allows to set this function as method of any object and then call it in the scope of that object. E.g.:
 * <pre>
 * var p = new Ext.Panel({
 * &nbsp;	 prop1:11
 * &nbsp;	,prop2:22
 * &nbsp;	,<b>applyMatching:Ext.ux.util.applyMatching</b>
 * &nbsp;	// ...
 * });
 * var t = p.applyMatching({prop1:0, prop2:0, prop3:33});
 * </pre>
 * The resulting object:
 * <pre>
 * t = {prop1:11, prop2:22, prop3:33};
 * </pre>
 * @return {Object} Original passed target object with properties updated from source
 */
Ext.ux.util.applyMatching = function(t, s) {
	var s = s || this;
	for(var p in t) {
		if(t.hasOwnProperty(p) && undefined !== s[p]) {
			t[p] = s[p];
		}
	}
	return t;
}; // eo function applyMatching
// }}}

// conditional override
// {{{
/**
 * Same as {@link Ext#override} but overrides only if method does not exist in the target class
 * @member Ext
 * @param {Object} origclass
 * @param {Object} overrides
 */
Ext.overrideIf = 'function' === typeof Ext.overrideIf ? Ext.overrideIf : function(origclass, overrides) {
	if(overrides) {
		var p = origclass.prototype;
		for(var method in overrides) {
			if(!p[method]) {
				p[method] = overrides[method];
			}
		}
	}
};
// }}}

// RegExp
// {{{
/**
 * @class RegExp
 */
if('function' !== typeof RegExp.escape) {
	/**
	 * Escapes regular expression
	 * @param {String} s
	 * @return {String} The escaped string
	 * @static
	 */
	RegExp.escape = function(s) {
		if('string' !== typeof s) {
			return s;
		}
		return s.replace(/([.*+?\^=!:${}()|\[\]\/\\])/g, '\\$1');
	};
}
Ext.overrideIf(RegExp, {

	/**
	 * Clones RegExp object
	 * @return {RegExp} Clone of this RegExp
	 */
	 clone:function() {
		return new RegExp(this);
	} // eo function clone
});
// }}}

// Array
// {{{
Ext.overrideIf(Array, {
	// {{{
	/**
	 * One dimensional copy. Use {@link Ext.ux.util#clone Ext.ux.util.clone} to deeply clone an Array.
	 * @member Array
	 * @return {Array} New Array that is copy of this
	 */
	 copy:function() {
		var a = [];
		for(var i = 0, l = this.length; i < l; i++) {
			a.push(this[i]);
		}
		return a;
	} // eo function copy
	// }}}
	// {{{
	/**
	 * Not used anyway as Ext has its own indexOf
	 * @member Array
	 * @return {Integer} Index of v or -1 if not found
	 * @param {Mixed} v Value to find indexOf
	 * @param {Integer} b Starting index
	 */
	,indexOf:function(v, b) {
		for(var i = +b || 0, l = this.length; i < l; i++) {
			if(this[i] === v) { 
				return i; 
			}
		}
		return -1;
	} // eo function indexOf
	// }}}
	// {{{
	/**
	 * Returns intersection of this Array and passed arguments
	 * @member Array
	 * @return {Array} Intersection of this and passed arguments
	 * @param {Mixed} arg1 (optional)
	 * @param {Mixed} arg2 (optional)
	 * @param {Mixed} etc. (optional)
	 */
	,intersect:function() {
		if(!arguments.length) {
			return [];
		}
		var a1 = this, a2, a;
		for(var k = 0, ac = arguments.length; k < ac; k++) {
			a = [];
			a2 = arguments[k] || [];
			for(var i = 0, l = a1.length; i < l; i++) {
				if(-1 < a2.indexOf(a1[i])) {
					a.push(a1[i]);
				}
			}
			a1 = a;
		}
		return a.unique();
	} // eo function intesect
	// }}}
	// {{{
	/**
	 * Returns last index of passed argument
	 * @member Array
	 * @return {Integer} Index of v or -1 if not found
	 * @param {Mixed} v Value to find indexOf
	 * @param {Integer} b Starting index
	 */
	,lastIndexOf:function(v, b) {
		b = +b || 0;
		var i = this.length; 
		while(i-- > b) {
			if(this[i] === v) { 
				return i; 
			}
		}
		return -1;
	} // eof function lastIndexOf
	// }}}
	// {{{
	/**
	 * @member Array
	 * @return {Array} New Array that is union of this and passed arguments
	 * @param {Mixed} arg1 (optional)
	 * @param {Mixed} arg2 (optional)
	 * @param {Mixed} etc. (optional)
	 */
	,union:function() {
		var a = this.copy(), a1;
		for(var k = 0, ac = arguments.length; k < ac; k++) {
			a1 = arguments[k] || [];
			for(var i = 0, l = a1.length; i < l; i++) {
				a.push(a1[i]);
			}
		}
		return a.unique();
	} // eo function union
	// }}}
	// {{{
	/**
	 * Removes duplicates from array
	 * @member Array
	 * @return {Array} New Array with duplicates removed
	 */
	,unique:function() {
		var a = [], i, l = this.length;
		for(i = 0; i < l; i++) {
			if(a.indexOf(this[i]) < 0) { 
				a.push(this[i]); 
			}
		}
		return a;
	} // eo function unique
	// }}}

});
// }}}

// eof
Ext.define("Ext.ux.form.XCheckbox", {
	extend: "Ext.form.Checkbox",
	inputValue: "true",
	uncheckedValue: "false",
    boxLabelAlign: "before",
});
/*global Ext */

Ext.ns('Ext.ux.form');
/**
 * @class Ext.ux.VCheckbox
 * @extends-ext Ext.form.Checkbox
 */
//Ext.ux.form.VCheckbox = Ext.extend(Ext.ux.form.XCheckbox, {
Ext.define("Ext.ux.form.VCheckbox", {
	extend: "Ext.ux.form.XCheckbox",
	checkedCls: 'v-form-check-checked',

	focusCls: 'v-form-check-focus',

	overCls: 'v-form-check-over',

	mouseDownCls: 'v-form-check-down',

	baseCls: 'v-form-check'

}); // eo extend

// register xtype
//Ext.reg('vcheckbox', 'Ext.ux.form.VCheckbox');

// eo file
Ext.define('Ext.ux.colorpick.ColorUtils', function (ColorUtils) {
    var oldIE = Ext.isIE && Ext.ieVersion < 10;

    return {
        singleton: true,

        constructor: function () {
            ColorUtils = this;
        },

        backgroundTpl: oldIE ?
            'filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0, ' +
                'startColorstr=\'#{alpha}{hex}\', endColorstr=\'#{alpha}{hex}\');' :
            'background: {rgba};',

        setBackground: oldIE ? function (el, color) {
            if (el) {
                var tpl = Ext.XTemplate.getTpl(ColorUtils, 'backgroundTpl'),
                    data = {
                        hex: ColorUtils.rgb2hex(color.r, color.g, color.b),
                        alpha: Math.floor(color.a * 255).toString(16)
                    },
                    bgStyle = tpl.apply(data);

                el.applyStyles(bgStyle);
            }
        } : function (el, color) {
            if (el) {
                var tpl = Ext.XTemplate.getTpl(ColorUtils, 'backgroundTpl'),
                    data = {
                        rgba: ColorUtils.getRGBAString(color)
                    },
                    bgStyle = tpl.apply(data);

                el.applyStyles(bgStyle);
            }
        },

        // parse and format functions under objects that match supported format config
        // values of the color picker; parse() methods recieve the supplied color value
        // as a string (i.e "FFAAAA") and return an object form, just like the one
        // ColorPickerModel vm "selectedColor" uses. That same object form is used as a
        // parameter to the format() methods, where the appropriate string form is expected
        // for the return result
        formats: {
            // "FFAA00"
            HEX6: function(colorO) {
                return ColorUtils.rgb2hex(colorO.r, colorO.g, colorO.b);
            },

            // "FFAA00FF" (last 2 are opacity)
            HEX8: function(colorO) {
                var hex = ColorUtils.rgb2hex(colorO.r, colorO.g, colorO.b),
                    opacityHex = Math.round(colorO.a * 255).toString(16);

                if (opacityHex.length < 2) {
                    hex += '0';
                }

                hex += opacityHex.toUpperCase();

                return hex;
            }
        },

        hexRe: /#?([0-9a-f]{3,8})/i,
        rgbaAltRe: /rgba\(\s*([\w#\d]+)\s*,\s*([\d\.]+)\s*\)/,
        rgbaRe: /rgba\(\s*([\d\.]+)\s*,\s*([\d\.]+)\s*,\s*([\d\.]+)\s*,\s*([\d\.]+)\s*\)/,
        rgbRe: /rgb\(\s*([\d\.]+)\s*,\s*([\d\.]+)\s*,\s*([\d\.]+)\s*\)/,

        /**
         * Turn a string to a color object. Supports these formats:
         *
         * - "#ABC" (HEX short)
         * - "#ABCDEF" (HEX)
         * - "#ABCDEFDD" (HEX with opacity)
         * - "red" (named colors - see {@link #colorMap} source code for a full list)
         * - "rgba(r,g,b,a)" i.e "rgba(255,0,0,1)" (a == alpha == 0-1)
         * - "rgba(red, 0.4)"
         * - "rgba(#ABC, 0.9)"
         * - "rgba(#ABCDEF, 0.8)"
         *
         * @param {String} color The color string to parse.
         * @return {Object} Object with various color properties.
         * @return {Number} return.r The red component (0-255).
         * @return {Number} return.g The green component (0-255).
         * @return {Number} return.b The blue component (0-255).
         * @return {Number} return.a The red component (0-1).
         * @return {Number} return.h The hue component (0-1).
         * @return {Number} return.s The saturation component (0-1).
         * @return {Number} return.v The value component (0-1).
         */
        parseColor: function (color) {
            if (!color) {
                return null;
            }

            var me = this,
                rgb = me.colorMap[color],
                match, ret, hsv;

            if (rgb) {
                ret = {
                    r: rgb[0],
                    g: rgb[1],
                    b: rgb[2],
                    a: 1
                };
            }
            else if (color === 'transparent') {
                ret = {
                    r: 0,
                    g: 0,
                    b: 0,
                    a: 0
                };
            }
            else {
                match = me.hexRe.exec(color);
                if (match) {
                    match = match[1]; // the captured hex
                    switch (match.length) {
                        default:
                            return null;

                        case 3:
                            ret = {
                                //double the number (e.g. 6 - > 66, a -> aa) and convert to decimal
                                r: parseInt(match[0] + match[0], 16),
                                g: parseInt(match[1] + match[1], 16),
                                b: parseInt(match[2] + match[2], 16),
                                a: 1
                            };
                            break;

                        case 6:
                        case 8:
                            ret = {
                                r: parseInt(match.substr(0,2), 16),
                                g: parseInt(match.substr(2,2), 16),
                                b: parseInt(match.substr(4,2), 16),
                                a: parseInt(match.substr(6,2) || 'ff', 16) / 255
                            };
                            break;
                    }
                }
                else {
                    match = me.rgbaRe.exec(color);
                    if (match) {
                        // proper css => rgba(r,g,b,a)
                        ret = {
                            r: parseFloat(match[1]),
                            g: parseFloat(match[2]),
                            b: parseFloat(match[3]),
                            a: parseFloat(match[4])
                        };
                    }
                    else {
                        match = me.rgbaAltRe.exec(color);
                        if (match) {
                            // scss shorthands =? rgba(red, 0.4), rgba(#222, 0.9), rgba(#444433, 0.8)
                            ret = me.parseColor(match[1]);
                            // we have HSV filled in, so poke on "a" and we're done
                            ret.a = parseFloat(match[2]);
                            return ret;
                        }

                        match = me.rgbRe.exec(color);
                        if (match) {
                            ret = {
                                r: parseFloat(match[1]),
                                g: parseFloat(match[2]),
                                b: parseFloat(match[3]),
                                a: 1
                            };
                        }
                        else {
                            return null;
                        }
                    }
                }
            }

            hsv = this.rgb2hsv(ret.r, ret.g, ret.b);

            return Ext.apply(ret, hsv);
        },

        /**
         *
         * @param rgba
         * @return {String}
         */
        getRGBAString: function(rgba) {
            return "rgba(" + rgba.r + "," + rgba.g + "," + rgba.b + "," + rgba.a + ")";
        },

        /**
         * Returns a rgb css string whith this color (without the alpha channel)
         * @param rgb
         * @return {String}
         */
        getRGBString: function(rgb) {
            return "rgb(" + rgb.r + "," + rgb.g + "," + rgb.b + ")";
        },

        /**
         * Following standard math to convert from hsl to rgb
         * Check out wikipedia page for more information on how this works
         * h => [0,1]
         * s,l => [0,1]
         * @param h
         * @param s
         * @param v
         * @return {Object} An object with "r", "g" and "b" color properties.
         */
        hsv2rgb: function(h, s, v) {
            h = h * 360;

            if (h === 360) {
                h = 0;
            }

            var c = v * s;

            var hprime = h / 60;

            var x = c * (1 - Math.abs(hprime % 2 - 1));

            var rgb = [0, 0, 0];

            switch (Math.floor(hprime)) {
                case 0:
                    rgb = [c, x, 0];
                    break;
                case 1:
                    rgb = [x, c, 0];
                    break;
                case 2:
                    rgb = [0, c, x];
                    break;
                case 3:
                    rgb = [0, x, c];
                    break;
                case 4:
                    rgb = [x, 0, c];
                    break;
                case 5:
                    rgb = [c, 0, x];
                    break;
                default:
                    // <debug>
                    console.error("unknown color " + h + ' ' + s + " " + v);
                    // </debug>
                    break;
            }

            var m = v - c;

            rgb[0] += m;
            rgb[1] += m;
            rgb[2] += m;

            rgb[0] = Math.round(rgb[0] * 255);
            rgb[1] = Math.round(rgb[1] * 255);
            rgb[2] = Math.round(rgb[2] * 255);

            return {
                r: rgb[0],
                g: rgb[1],
                b: rgb[2]
            };
        },

        /**
         * http://en.wikipedia.org/wiki/HSL_and_HSV
         * @param {Number} r The red component (0-255).
         * @param {Number} g The green component (0-255).
         * @param {Number} b The blue component (0-255).
         * @return {Object} An object with "h", "s" and "v" color properties.
         */
        rgb2hsv: function(r,g,b) {
            r = r / 255;
            g = g / 255;
            b = b / 255;

            var M = Math.max(r,g,b);
            var m = Math.min(r,g,b);
            var c = M - m;

            var hprime = 0;
            if (c !== 0) {
                if (M === r) {
                    hprime = ((g - b) / c) % 6;
                } else if (M === g) {
                    hprime = ((b - r) / c) + 2;
                } else if (M === b) {
                    hprime = ((r - g) / c) + 4;
                }
            }

            var h = hprime * 60;
            if (h === 360) {
                h = 0;
            }

            var v = M;

            var s = 0;
            if (c !== 0) {
                s = c/v;
            }

            h = h / 360;

            if (h < 0) {
                h = h + 1;
            }

            return {
                h: h,
                s: s,
                v: v
            };
        },

        /**
         *
         * @param r
         * @param g
         * @param b
         * @return {String}
         */
        rgb2hex: function(r, g, b) {
            r = r.toString(16);
            g = g.toString(16);
            b = b.toString(16);

            if (r.length < 2) {
                r = '0' + r;
            }

            if (g.length < 2) {
                g = '0' + g;
            }

            if (b.length < 2) {
                b = '0' + b;
            }

            return (r + g + b).toUpperCase();
        },

        colorMap: {
            aliceblue:              [240, 248, 255],
            antiquewhite:           [250, 235, 215],
            aqua:                   [0, 255, 255],
            aquamarine:             [127, 255, 212],
            azure:                  [240, 255, 255],
            beige:                  [245, 245, 220],
            bisque:                 [255, 228, 196],
            black:                  [0, 0, 0],
            blanchedalmond:         [255, 235, 205],
            blue:                   [0, 0, 255],
            blueviolet:             [138, 43, 226],
            brown:                  [165, 42, 42],
            burlywood:              [222, 184, 135],
            cadetblue:              [95, 158, 160],
            chartreuse:             [127, 255, 0],
            chocolate:              [210, 105, 30],
            coral:                  [255, 127, 80],
            cornflowerblue:         [100, 149, 237],
            cornsilk:               [255, 248, 220],
            crimson:                [220, 20, 60],
            cyan:                   [0, 255, 255],
            darkblue:               [0, 0, 139],
            darkcyan:               [0, 139, 139],
            darkgoldenrod:          [184, 132, 11],
            darkgray:               [169, 169, 169],
            darkgreen:              [0, 100, 0],
            darkgrey:               [169, 169, 169],
            darkkhaki:              [189, 183, 107],
            darkmagenta:            [139, 0, 139],
            darkolivegreen:         [85, 107, 47],
            darkorange:             [255, 140, 0],
            darkorchid:             [153, 50, 204],
            darkred:                [139, 0, 0],
            darksalmon:             [233, 150, 122],
            darkseagreen:           [143, 188, 143],
            darkslateblue:          [72, 61, 139],
            darkslategray:          [47, 79, 79],
            darkslategrey:          [47, 79, 79],
            darkturquoise:          [0, 206, 209],
            darkviolet:             [148, 0, 211],
            deeppink:               [255, 20, 147],
            deepskyblue:            [0, 191, 255],
            dimgray:                [105, 105, 105],
            dimgrey:                [105, 105, 105],
            dodgerblue:             [30, 144, 255],
            firebrick:              [178, 34, 34],
            floralwhite:            [255, 255, 240],
            forestgreen:            [34, 139, 34],
            fuchsia:                [255, 0, 255],
            gainsboro:              [220, 220, 220],
            ghostwhite:             [248, 248, 255],
            gold:                   [255, 215, 0],
            goldenrod:              [218, 165, 32],
            gray:                   [128, 128, 128],
            green:                  [0, 128, 0],
            greenyellow:            [173, 255, 47],
            grey:                   [128, 128, 128],
            honeydew:               [240, 255, 240],
            hotpink:                [255, 105, 180],
            indianred:              [205, 92, 92],
            indigo:                 [75, 0, 130],
            ivory:                  [255, 255, 240],
            khaki:                  [240, 230, 140],
            lavender:               [230, 230, 250],
            lavenderblush:          [255, 240, 245],
            lawngreen:              [124, 252, 0],
            lemonchiffon:           [255, 250, 205],
            lightblue:              [173, 216, 230],
            lightcoral:             [240, 128, 128],
            lightcyan:              [224, 255, 255],
            lightgoldenrodyellow:   [250, 250, 210],
            lightgray:              [211, 211, 211],
            lightgreen:             [144, 238, 144],
            lightgrey:              [211, 211, 211],
            lightpink:              [255, 182, 193],
            lightsalmon:            [255, 160, 122],
            lightseagreen:          [32, 178, 170],
            lightskyblue:           [135, 206, 250],
            lightslategray:         [119, 136, 153],
            lightslategrey:         [119, 136, 153],
            lightsteelblue:         [176, 196, 222],
            lightyellow:            [255, 255, 224],
            lime:                   [0, 255, 0],
            limegreen:              [50, 205, 50],
            linen:                  [250, 240, 230],
            magenta:                [255, 0, 255],
            maroon:                 [128, 0, 0],
            mediumaquamarine:       [102, 205, 170],
            mediumblue:             [0, 0, 205],
            mediumorchid:           [186, 85, 211],
            mediumpurple:           [147, 112, 219],
            mediumseagreen:         [60, 179, 113],
            mediumslateblue:        [123, 104, 238],
            mediumspringgreen:      [0, 250, 154],
            mediumturquoise:        [72, 209, 204],
            mediumvioletred:        [199, 21, 133],
            midnightblue:           [25, 25, 112],
            mintcream:              [245, 255, 250],
            mistyrose:              [255, 228, 225],
            moccasin:               [255, 228, 181],
            navajowhite:            [255, 222, 173],
            navy:                   [0, 0, 128],
            oldlace:                [253, 245, 230],
            olive:                  [128, 128, 0],
            olivedrab:              [107, 142, 35],
            orange:                 [255, 165, 0],
            orangered:              [255, 69, 0],
            orchid:                 [218, 112, 214],
            palegoldenrod:          [238, 232, 170],
            palegreen:              [152, 251, 152],
            paleturquoise:          [175, 238, 238],
            palevioletred:          [219, 112, 147],
            papayawhip:             [255, 239, 213],
            peachpuff:              [255, 218, 185],
            peru:                   [205, 133, 63],
            pink:                   [255, 192, 203],
            plum:                   [221, 160, 203],
            powderblue:             [176, 224, 230],
            purple:                 [128, 0, 128],
            red:                    [255, 0, 0],
            rosybrown:              [188, 143, 143],
            royalblue:              [65, 105, 225],
            saddlebrown:            [139, 69, 19],
            salmon:                 [250, 128, 114],
            sandybrown:             [244, 164, 96],
            seagreen:               [46, 139, 87],
            seashell:               [255, 245, 238],
            sienna:                 [160, 82, 45],
            silver:                 [192, 192, 192],
            skyblue:                [135, 206, 235],
            slateblue:              [106, 90, 205],
            slategray:              [119, 128, 144],
            slategrey:              [119, 128, 144],
            snow:                   [255, 255, 250],
            springgreen:            [0, 255, 127],
            steelblue:              [70, 130, 180],
            tan:                    [210, 180, 140],
            teal:                   [0, 128, 128],
            thistle:                [216, 191, 216],
            tomato:                 [255, 99, 71],
            turquoise:              [64, 224, 208],
            violet:                 [238, 130, 238],
            wheat:                  [245, 222, 179],
            white:                  [255, 255, 255],
            whitesmoke:             [245, 245, 245],
            yellow:                 [255, 255, 0],
            yellowgreen:            [154, 205, 5]
        }
    };
},
function (ColorUtils) {
    var formats = ColorUtils.formats,
        lowerized = {};

    formats['#HEX6'] = function (color) {
        return '#' + formats.HEX6(color);
    };

    formats['#HEX8'] = function (color) {
        return '#' + formats.HEX8(color);
    };

    Ext.Object.each(formats, function (name, fn) {
        lowerized[name.toLowerCase()] = function (color) {
            var ret = fn(color);
            return ret.toLowerCase();
        }
    });

    Ext.apply(formats, lowerized);
});
Ext.define('Ext.ux.colorpick.Selection', {
    mixinId: 'colorselection',

    config : {
        /**
         * @cfg {"hex6","hex8","#hex6","#hex8","HEX6","HEX8","#HEX6","#HEX8"} [format=hex6]
         * The color format to for the `value` config. The `value` can be set using any
         * supported format or named color, but the stored value will always be in this
         * format.
         *
         * Supported formats are:
         *
         * - hex6 - For example "ffaa00" (Note: does not preserve transparency).
         * - hex8 - For eaxmple "ffaa00ff" - the last 2 digits represent transparency
         * - #hex6 - For example "#ffaa00" (same as "hex6" but with a leading "#").
         * - #hex8 - For example "#ffaa00ff" (same as "hex8" but with a leading "#").
         * - HEX6 - Same as "hex6" but upper case.
         * - HEX8 - Same as "hex8" but upper case.
         * - #HEX6 - Same as "#hex6" but upper case.
         * - #HEX8 - Same as "#hex8" but upper case.
         */
        format: 'hex6',

        /**
         * @cfg {String} [value=FF0000]
         * The initial color to highlight; see {@link #format} for supported formats.
         */
        value: 'FF0000',

        /**
         * @cfg {Object} color
         * This config property is used internally by the UI to maintain the full color.
         * Changes to this config are automatically reflected in `value` and vise-versa.
         * Setting `value` can, however, cause the alpha to be dropped if the new value
         * does not contain an alpha component.
         * @private
         */
        color: null,
        previousColor: null
    },

    applyColor: function (color) {
        var c = color;
        if (Ext.isString(c)) {
            c = Ext.ux.colorpick.ColorUtils.parseColor(color);
        }
        return c;
    },

    applyValue: function (color) {
        // Transform whatever incoming color we get to the proper format
        var c = Ext.ux.colorpick.ColorUtils.parseColor(color);
        return this.formatColor(c);
    },

    formatColor: function (color) {
        return Ext.ux.colorpick.ColorUtils.formats[this.getFormat()](color);
    },

    updateColor: function (color) {
        var me = this;

        // If the "color" is changed (via internal changes in the UI), update "value" as
        // well. Since these are always tracking each other, we guard against the case
        // where we are being updated *because* "value" is being set.
        if (!me.syncing) {
            me.syncing = true;
            me.setValue(me.formatColor(color));
            me.syncing = false;
        }
    },

    updateValue: function (value, oldValue) {
        var me = this;

        // If the "value" is changed, update "color" as well. Since these are always
        // tracking each other, we guard against the case where we are being updated
        // *because* "color" is being set.
        if (!me.syncing) {
            me.syncing = true;
            me.setColor(value);
            me.syncing = false;
        }

        this.fireEvent('change', me, value, oldValue);
    }
});
Ext.define('Ext.ux.colorpick.ColorMapController', {
    extend : 'Ext.app.ViewController',
    alias: 'controller.colorpickercolormapcontroller',

    requires: [
        'Ext.ux.colorpick.ColorUtils'
    ],

    // After the component is rendered
    onFirstBoxReady: function() {
        var me         = this,
            colorMap   = me.getView(),
            dragHandle = colorMap.down('#dragHandle'),
            dd         = dragHandle.dd;

        // configure draggable constraints 
        dd.constrain = true;
        dd.constrainTo = colorMap.getEl();
        dd.initialConstrainTo = dd.constrainTo; // needed otheriwse error EXTJS-13187

        // event handlers
        dd.on('drag', Ext.bind(me.onHandleDrag, me));
        me.mon(colorMap.getEl(), {
            mousedown: me.onMouseDown,
            dragstart: me.onDragStart,
            scope: me
        });
    },

    // Fires when handle is dragged; propagates "handledrag" event on the ColorMap
    // with parameters "percentX" and "percentY", both 0-1, representing the handle
    // position on the color map, relative to the container
    onHandleDrag: function(componentDragger, e) {
        var me              = this,
            container       = me.getView(), // the Color Map
            dragHandle      = container.down('#dragHandle'),
            x               = dragHandle.getX() - container.getX(),
            y               = dragHandle.getY() - container.getY(),
            containerEl     = container.getEl(),
            containerWidth  = containerEl.getWidth(),
            containerHeight = containerEl.getHeight(),
            xRatio          = x/containerWidth,
            yRatio          = y/containerHeight;

        // Adjust x/y ratios for dragger always being 1 pixel from the edge on the right
        if (xRatio > 0.99) {
            xRatio = 1;
        }
        if (yRatio > 0.99) {
            yRatio = 1;
        }
        
        container.fireEvent('handledrag', xRatio, yRatio);
    },

    // Whenever we mousedown over the colormap area
    onMouseDown: function(e) {
        var me         = this,
            container  = me.getView(),
            dragHandle = container.down('#dragHandle');

        // position drag handle accordingly
        dragHandle.setY(e.getY());
        dragHandle.setX(e.getX());
        me.onHandleDrag();

        // tie into the default dd mechanism
        dragHandle.dd.onMouseDown(e, dragHandle.dd.el);
    },

    // Whenever we start a drag over the colormap area
    onDragStart: function(e) {
        var me         = this,
            container  = me.getView(),
            dragHandle = container.down('#dragHandle');

        // tie into the default dd mechanism
        dragHandle.dd.onDragStart(e, dragHandle.dd.el);
    },

    // Whenever the map is clicked (but not the drag handle) we need to position
    // the drag handle to the point of click
    onMapClick: function (e) {
        var me          = this,
            container   = me.getView(), // the Color Map
            dragHandle  = container.down('#dragHandle'),
            cXY         = container.getXY(),
            eXY         = e.getXY(),
            left, top;

        left = eXY[0] - cXY[0];
        top  = eXY[1] - cXY[1];

        dragHandle.getEl().setStyle({
            left : left + 'px',
            top  : top + 'px'
        });

        me.onHandleDrag();
    },

    // Whenever the underlying binding data is changed we need to 
    // update position of the dragger; active drag state has been
    // accounted for earlier
    onColorBindingChanged: function(selectedColor) {
        var me              = this,
            vm              = me.getViewModel(),
            rgba            = vm.get('selectedColor'),
            hsv,
            container       = me.getView(), // the Color Map
            dragHandle      = container.down('#dragHandle'),
            containerEl     = container.getEl(),
            containerWidth  = containerEl.getWidth(),
            containerHeight = containerEl.getHeight(),
            xRatio,
            yRatio,
            left,
            top;

        // Color map selection really only depends on saturation and value of the color
        hsv = Ext.ux.colorpick.ColorUtils.rgb2hsv(rgba.r, rgba.g, rgba.b);

        // x-axis of color map with value 0-1 translates to saturation
        xRatio = hsv.s;
        left = containerWidth*xRatio;

        // y-axis of color map with value 0-1 translates to reverse of "value"
        yRatio = 1-hsv.v;
        top = containerHeight*yRatio;

        // Position dragger
        dragHandle.getEl().setStyle({
            left : left + 'px',
            top  : top + 'px'
        });
    },

    // Whenever only Hue changes we can update the 
    // background color of the color map
    // Param "hue" has value of 0-1
    onHueBindingChanged: function(hue) {
        var me            = this,
            vm            = me.getViewModel(),
            fullColorRGB,
            hex;

        fullColorRGB = Ext.ux.colorpick.ColorUtils.hsv2rgb(hue, 1, 1);
        hex = Ext.ux.colorpick.ColorUtils.rgb2hex(fullColorRGB.r, fullColorRGB.g, fullColorRGB.b);
        me.getView().getEl().applyStyles({ 'background-color': '#' + hex });
    }
});
/**
 * The main colorful square for selecting color shades by dragging around the
 * little circle.
 * @private
 */
Ext.define('Ext.ux.colorpick.ColorMap', {
    extend     : 'Ext.container.Container',
    alias      : 'widget.colorpickercolormap',
    controller : 'colorpickercolormapcontroller',

    requires: [
        'Ext.ux.colorpick.ColorMapController'
    ],

    cls  : Ext.baseCSSPrefix + 'colorpicker-colormap',

    // This is the drag "circle"; note it's 1x1 in size to allow full
    // travel around the color map; the inner div has the bigger image
    items: [{
        xtype     : 'component',
        cls       : Ext.baseCSSPrefix + 'colorpicker-colormap-draghandle-container',
        itemId    : 'dragHandle',
        width     : 1,
        height    : 1,
        draggable : true,
        html      : '<div class="' + Ext.baseCSSPrefix + 'colorpicker-colormap-draghandle"></div>'
    }],

    listeners : {
        boxready : {
            single  : true,
            fn      : 'onFirstBoxReady',
            scope   : 'controller'
        },
        colorbindingchanged: {
            fn    : 'onColorBindingChanged',
            scope : 'controller'
        },
        huebindingchanged: {
            fn    : 'onHueBindingChanged',
            scope : 'controller'
        }
    },

    afterRender: function () {
        var me  = this,
            src = me.mapGradientUrl,
            el  = me.el;

        me.callParent();

        if (!src) {
            // We do this trick to allow the Sass to calculate resource image path for
            // our package and pick up the proper image URL here.
            src = el.getStyle('background-image');
            src = src.substring(4, src.length - 1);  // strip off outer "url(...)"

            // In IE8 this path will have quotes around it
            if (src.indexOf('"') === 0) {
                src = src.substring(1, src.length-1);
            }

            // Then remember it on our prototype for any subsequent instances.
            Ext.ux.colorpick.ColorMap.prototype.mapGradientUrl = src;
        }

        // Now clear that style because it will conflict with the background-color
        el.setStyle('background-image', 'none');

        // Create the image with transparent PNG with black and white gradient shades;
        // it blends with the background color (which changes with hue selection). This
        // must be an IMG in order to properly stretch to fit.
        el = me.layout.getElementTarget(); // the el for items and html
        el.createChild({
            tag: 'img',
            cls: Ext.baseCSSPrefix + 'colorpicker-colormap-blender',
            src: src
        });
    },

    // Called via data binding whenever selectedColor changes; fires "colorbindingchanged"
    setPosition: function(data) {
        var me         = this,
            dragHandle = me.down('#dragHandle');

        // Too early in the render cycle? Skip event
        if (!dragHandle.dd || !dragHandle.dd.constrain) {
            return;
        }

        // User actively dragging? Skip event
        if (typeof dragHandle.dd.dragEnded !== 'undefined' && !dragHandle.dd.dragEnded) {
            return;
        }

        me.fireEvent('colorbindingchanged', data);
    },

    // Called via data binding whenever selectedColor.h changes; fires "huebindingchanged" event
    setHue: function(hue) {
        var me = this;

        // Too early in the render cycle? Skip event
        if (!me.getEl()) {
            return;
        }

        me.fireEvent('huebindingchanged', hue);
    }
});
/**
 * View Model that holds the "selectedColor" of the color picker container.
 */
Ext.define('Ext.ux.colorpick.SelectorModel', {
    extend : 'Ext.app.ViewModel',
    alias  : 'viewmodel.colorpick-selectormodel',

    requires: [
        'Ext.ux.colorpick.ColorUtils'
    ],

    data: {
        selectedColor: {
            r : 255,  // red
            g : 255,  // green
            b : 255,  // blue
            h : 0,    // hue,
            s : 1,    // saturation
            v : 1,    // value
            a : 1     // alpha (opacity)
        },
        previousColor: {
            r : 0,    // red
            g : 0,    // green
            b : 0,    // blue
            h : 0,    // hue,
            s : 1,    // saturation
            v : 1,    // value
            a : 1     // alpha (opacity)
        }
    },

    formulas: {
        // Hexadecimal representation of the color
        hex: {
            get: function (get) {
                var r = get('selectedColor.r').toString(16),
                    g = get('selectedColor.g').toString(16),
                    b = get('selectedColor.b').toString(16),
                    result;

                result = Ext.ux.colorpick.ColorUtils.rgb2hex(r, g, b);
                return '#' + result;
            },

            set: function (hex) {
                var rgb = Ext.ux.colorpick.ColorUtils.hex2rgb(hex);
                this.changeRGB(rgb);
            }
        },

        // "R" in "RGB"
        red: {
            get: function(get) {
                return get('selectedColor.r');
            },

            set: function(r) {
                this.changeRGB({ r: r });
            }
        },

        // "G" in "RGB"
        green: {
            get: function(get) {
                return get('selectedColor.g');
            },

            set: function(g) {
                this.changeRGB({ g: g });
            }
        },

        // "B" in "RGB"
        blue: {
            get: function(get) {
                return get('selectedColor.b');
            },

            set: function(b) {
                this.changeRGB({ b: b });
            }
        },

        // "H" in HSV
        hue: {
            get: function(get) {
                return get('selectedColor.h') * 360;
            },

            set: function(hue) {
                this.changeHSV({ h: hue / 360 });
            }
        },

        // "S" in HSV
        saturation: {
            get : function(get) {
                return get('selectedColor.s') * 100;
            },

            set: function(saturation) {
                this.changeHSV({ s: saturation / 100 });
            }
        },

        // "V" in HSV
        value: {
            get: function(get) {
                var v = get('selectedColor.v');
                return v * 100;
            },

            set: function(value) {
                this.changeHSV({ v: value / 100 });
            }
        },

        alpha: {
            get: function(data) {
                var a = data('selectedColor.a');
                return a * 100;
            },

            set: function(alpha) {
                this.set('selectedColor', Ext.applyIf({
                    a: alpha / 100
                }, this.data.selectedColor));
            }
        }
    }, // formulas

    changeHSV: function (hsv) {
        Ext.applyIf(hsv, this.data.selectedColor);

        var rgb = Ext.ux.colorpick.ColorUtils.hsv2rgb(hsv.h, hsv.s, hsv.v);

        hsv.r = rgb.r;
        hsv.g = rgb.g;
        hsv.b = rgb.b;

        this.set('selectedColor', hsv);
    },

    changeRGB: function (rgb) {
        Ext.applyIf(rgb, this.data.selectedColor);

        var hsv = Ext.ux.colorpick.ColorUtils.rgb2hsv(rgb.r, rgb.g, rgb.b);

        rgb.h = hsv.h;
        rgb.s = hsv.s;
        rgb.v = hsv.v;

        this.set('selectedColor', rgb);
    }
});
Ext.define('Ext.ux.colorpick.SelectorController', {
    extend : 'Ext.app.ViewController',
    alias  : 'controller.colorpick-selectorcontroller',

    requires: [
        'Ext.ux.colorpick.ColorUtils'
    ],

    initViewModel: function () {
        var me = this,
            view = me.getView();

        // And ensure that the
        view.childViewModel.bind('{selectedColor}', function (color) {
            view.setColor(color);
        });
    },

    destroy: function () {
        var me = this,
            view = me.getView(),
            childViewModel = view.childViewModel;

        if (childViewModel) {
            childViewModel.destroy();
            view.childViewModel = null;
        }

        me.callParent();
    },

    changeHSV: function (hsv) {
        var view = this.getView(),
            color = view.getColor(),
            rgb;

        // Put in values we are not changing (like A, but also missing HSV values)
        Ext.applyIf(hsv, color);

        // Now that HSV is complete, recalculate RGB and combine them
        rgb = Ext.ux.colorpick.ColorUtils.hsv2rgb(hsv.h, hsv.s, hsv.v);
        Ext.apply(hsv, rgb);

        view.setColor(hsv);
    },

    // Updates Saturation/Value in the model based on ColorMap; params:
    // xPercent - where is the handle relative to the color map width
    // yPercent - where is the handle relative to the color map height
    onColorMapHandleDrag: function(xPercent, yPercent) {
        this.changeHSV({
            s: xPercent,
            v: 1 - yPercent
        });
    },

    // Updates HSV Value in the model and downstream RGB settings
    onValueSliderHandleDrag: function(yPercent) {
        this.changeHSV({
            v: 1 - yPercent
        });
    },

    // Updates HSV Saturation in the model and downstream RGB settings
    onSaturationSliderHandleDrag: function(yPercent) {
        this.changeHSV({
            s: 1 - yPercent
        });
    },

    // Updates Hue in the model and downstream RGB settings
    onHueSliderHandleDrag: function(yPercent) {
        this.changeHSV({
            h: 1 - yPercent
        });
    },

    onAlphaSliderHandleDrag: function (yPercent) {
        var view = this.getView(),
            color = view.getColor(),
            newColor = Ext.applyIf({
                a: 1 - yPercent
            }, color);

        view.setColor(newColor);
        view.el.repaint();
    },

    onPreviousColorSelected: function (comp, color) {
        var view = this.getView();

        view.setColor(color);
    },

    onOK: function () {
        var me   = this,
            view = me.getView();

        view.fireEvent('ok', view, view.getValue());
    },

    onCancel: function () {
        this.fireViewEvent('cancel', this.getView());
    },

    onResize: function() {
        var me   = this,
            view = me.getView(),
            vm   = view.childViewModel,
            refs = me.getReferences(),
            h, s, v, a;

        // Skip initial rendering resize
        if (!me.hasResizedOnce) {
            me.hasResizedOnce = true;
            return;
        }

        h = vm.get('hue');
        s = vm.get('saturation');
        v = vm.get('value');
        a = vm.get('alpha');
console.log('h=' + h);
        // Reposition the colormap's & sliders' drag handles
        refs.colorMap.setPosition(vm.getData());
        refs.hueSlider.setHue(h);
        refs.satSlider.setSaturation(s);
        refs.valueSlider.setValue(v);
        refs.alphaSlider.setAlpha(a);
    }
});
/**
 * A basic component that changes background color, with considerations for opacity
 * support (checkered background image and IE8 support).
 */
Ext.define('Ext.ux.colorpick.ColorPreview', {
    extend     : 'Ext.Component',
    alias      : 'widget.colorpickercolorpreview',

    requires: [
        'Ext.util.Format'
    ],

    //hack to solve issue with IE, when applying a filter the click listener is not being fired.
    style: 'position: relative',
    html: '<div class="filter" style="height:100%; width:100%; position: absolute;"></div>'+
          '<a class="btn" style="height:100%; width:100%; position: absolute;"></a>',
    //eo hack

    cls: 'x-colorpreview',

    height: 256,

    onRender: function () {
        var me = this;

        me.callParent(arguments);

        me.mon(me.el.down('.btn'), 'click', me.onClick, me);
    },

    onClick: function () {
        this.fireEvent('click', this, this.color);
    },

    // Called via databinding - update background color whenever ViewModel changes
    setColor: function(color) {
        var me = this,
            el = me.getEl();

        // Too early in rendering cycle; skip
        if (!el) {
            return;
        }
        me.color = color;

        me.applyBgStyle(color);
    },

    bgStyleTpl: Ext.create('Ext.XTemplate',
        Ext.isIE && Ext.ieVersion < 10 ?
          'filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0, startColorstr=\'#{hexAlpha}{hex}\', endColorstr=\'#{hexAlpha}{hex}\');' /* IE6-9 */
        : 'background: {rgba};'
    ),

    applyBgStyle: function (color) {
        var me         = this,
            colorUtils = Ext.ux.colorpick.ColorUtils,
            el         = me.getEl().down('.filter'),
            hex, alpha, rgba, bgStyle;

        hex     = colorUtils.rgb2hex(color.r, color.g, color.b);
        alpha   = Ext.util.Format.hex(Math.floor(color.a * 255), 2);
        rgba    = colorUtils.getRGBAString(color);
        bgStyle = this.bgStyleTpl.apply({hex: hex, hexAlpha: alpha, rgba: rgba});

        el.applyStyles(bgStyle);
    }
});
Ext.define('Ext.ux.colorpick.SliderController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.colorpick-slidercontroller',

    // After the component is rendered
    boxReady: function (view) {
        var me         = this,
            container  = me.getDragContainer(),
            dragHandle = me.getDragHandle(),
            dd         = dragHandle.dd;

        // configure draggable constraints 
        dd.constrain = true;
        dd.constrainTo = container.getEl();
        dd.initialConstrainTo = dd.constrainTo; // needed otheriwse error EXTJS-13187
        
        // event handlers
        dd.on('drag', me.onHandleDrag, me);
    },

    getDragHandle: function () {
        return this.view.lookupReference('dragHandle');
    },

    getDragContainer: function () {
        return this.view.lookupReference('dragHandleContainer');
    },

    // Fires when handle is dragged; fires "handledrag" event on the slider
    // with parameter  "percentY" 0-1, representing the handle position on the slider
    // relative to the height
    onHandleDrag: function(e) {
        var me              = this,
            view            = me.getView(),
            container       = me.getDragContainer(),
            dragHandle      = me.getDragHandle(),
            y               = dragHandle.getY() - container.getY(),
            containerEl     = container.getEl(),
            containerHeight = containerEl.getHeight(),
            yRatio          = y/containerHeight;

        // Adjust y ratio for dragger always being 1 pixel from the edge on the bottom
        if (yRatio > 0.99) {
            yRatio = 1;
        }

        view.fireEvent('handledrag', yRatio);
    },

    // Whenever we mousedown over the slider area
    onMouseDown: function(e) {
        var me         = this,
            dragHandle = me.getDragHandle(),
            y = e.getY();

        // position drag handle accordingly
        dragHandle.setY(y);
        me.onHandleDrag();

        dragHandle.el.repaint();
        // tie into the default dd mechanism
        dragHandle.dd.onMouseDown(e, dragHandle.dd.el);
    },

    // Whenever we start a drag over the colormap area
    onDragStart: function(e) {
        var me         = this,
            dragHandle = me.getDragHandle();

        // tie into the default dd mechanism
        dragHandle.dd.onDragStart(e, dragHandle.dd.el);
    },

    onMouseUp: function () {
        var dragHandle = this.getDragHandle();

        dragHandle.dd.dragEnded = true; // work around DragTracker bug
    }
});
/**
 * Parent view for the 4 sliders seen on the color picker window.
 * @private
 */
Ext.define('Ext.ux.colorpick.Slider', {
    extend     : 'Ext.container.Container',
    xtype      : 'colorpickerslider',
    controller : 'colorpick-slidercontroller',

    baseCls : Ext.baseCSSPrefix + 'colorpicker-slider',
    layout  : 'center',

    requires: [
        'Ext.layout.container.Center',
        'Ext.ux.colorpick.SliderController'
    ],

    referenceHolder: true,

    listeners : {
        element: 'el',
        mousedown: 'onMouseDown',
        mouseup: 'onMouseUp',
        dragstart: 'onDragStart'
    },

    // Container for the drag handle; needed since the slider
    // is of static size, while the parent container positions
    // it in the center; this is what receives the beautiful
    // color gradients for the visual
    items: {
        xtype     : 'container',
        cls       : Ext.baseCSSPrefix + 'colorpicker-draghandle-container',
        reference : 'dragHandleContainer',
        height    : '100%',

        // This is the drag handle; note it's 100%x1 in size to allow full
        // vertical drag travel; the inner div has the bigger image
        items: {
            xtype     : 'component',
            cls       : Ext.baseCSSPrefix + 'colorpicker-draghandle-outer',
            reference : 'dragHandle',
            width     : '100%',
            height    : 1,
            draggable : true,
            html      : '<div class="' + Ext.baseCSSPrefix + 'colorpicker-draghandle"></div>'
        }
    },

    // <debug>
    // Called via data binding whenever selectedColor.h changes;
    setHue: function () {
        Ext.Error.raise('Must implement setHue() in a child class!');
    },
    // </debug>

    getDragHandle: function () {
        return this.lookupReference('dragHandle');
    },

    getDragContainer: function () {
        return this.lookupReference('dragHandleContainer');
    }
});
/**
 * Used for "Alpha" slider.
 * @private
 */
Ext.define('Ext.ux.colorpick.SliderAlpha', {
    extend : 'Ext.ux.colorpick.Slider',
    alias  : 'widget.colorpickerslideralpha',
    cls    : Ext.baseCSSPrefix + 'colorpicker-alpha',

    requires: [
        'Ext.XTemplate'
    ],

    gradientStyleTpl: Ext.create('Ext.XTemplate',
        Ext.isIE && Ext.ieVersion < 10
        ? 'filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0, startColorstr=\'#FF{hex}\', endColorstr=\'#00{hex}\');' /* IE6-9 */
        : 'background: -mox-linear-gradient(top, rgba({r}, {g}, {b}, 1) 0%, rgba({r}, {g}, {b}, 0) 100%);' +   /* FF3.6+ */
          'background: -webkit-linear-gradient(top,rgba({r}, {g}, {b}, 1) 0%, rgba({r}, {g}, {b}, 0) 100%);' + /* Chrome10+,Safari5.1+ */
          'background: -o-linear-gradient(top, rgba({r}, {g}, {b}, 1) 0%, rgba({r}, {g}, {b}, 0) 100%);' +      /* Opera 11.10+ */
          'background: -ms-linear-gradient(top, rgba({r}, {g}, {b}, 1) 0%, rgba({r}, {g}, {b}, 0) 100%);' +     /* IE10+ */
          'background: linear-gradient(to bottom, rgba({r}, {g}, {b}, 1) 0%, rgba({r}, {g}, {b}, 0) 100%);'     /* W3C */
    ),

    // Called via data binding whenever selectedColor.a changes; param is 0-100
    setAlpha: function (value) {
        var me              = this,
            container       = me.getDragContainer(),
            dragHandle      = me.getDragHandle(),
            containerEl     = container.getEl(),
            containerHeight = containerEl.getHeight(),
            el, top;

        // Too early in the render cycle? Skip event
        if (!dragHandle.dd || !dragHandle.dd.constrain) {
            return;
        }

        // User actively dragging? Skip event
        if (typeof dragHandle.dd.dragEnded !== 'undefined' && !dragHandle.dd.dragEnded) {
            return;
        }

        // y-axis of slider with value 0-1 translates to reverse of "value"
        top = containerHeight * (1 - (value / 100));

        // Position dragger
        el = dragHandle.getEl();
        el.setStyle({
            top: top
        });
    },

    // Called via data binding whenever selectedColor.h changes; hue param is 0-1
    setColor: function(color) {
        var me = this,
            container = me.getDragContainer(),
            hex, el;

        // Too early in the render cycle? Skip event
        if (!me.getEl()) {
            return;
        }

        // Determine HEX for new hue and set as background based on template
        hex = Ext.ux.colorpick.ColorUtils.rgb2hex(color.r, color.g, color.b);

        el = container.getEl().down('.x-autocontainer-innerCt');
        el.applyStyles(me.gradientStyleTpl.apply({hex: hex, r: color.r, g: color.g, b: color.b}));
    }
});
/**
 * Used for "Saturation" slider
 * @private
 */
Ext.define('Ext.ux.colorpick.SliderSaturation', {
    extend : 'Ext.ux.colorpick.Slider',
    alias  : 'widget.colorpickerslidersaturation',
    cls    : Ext.baseCSSPrefix + 'colorpicker-saturation',

    gradientStyleTpl: Ext.create('Ext.XTemplate',
        Ext.isIE && Ext.ieVersion < 10
        ? 'filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0, startColorstr=\'#{hex}\', endColorstr=\'#ffffff\');' /* IE6-9 */
        : 'background: -mox-linear-gradient(top, #{hex} 0%, #ffffff 100%);' +   /* FF3.6+ */
          'background: -webkit-linear-gradient(top, #{hex} 0%,#ffffff 100%);' + /* Chrome10+,Safari5.1+ */
          'background: -o-linear-gradient(top, #{hex} 0%,#ffffff 100%);' +      /* Opera 11.10+ */
          'background: -ms-linear-gradient(top, #{hex} 0%,#ffffff 100%);' +     /* IE10+ */
          'background: linear-gradient(to bottom, #{hex} 0%,#ffffff 100%);'     /* W3C */
    ),

    // Called via data binding whenever selectedColor.s changes; saturation param is 0-100
    setSaturation: function(saturation) {
        var me              = this,
            container       = me.getDragContainer(),
            dragHandle      = me.getDragHandle(),
            containerEl     = container.getEl(),
            containerHeight = containerEl.getHeight(),
            yRatio,
            top;

        // Too early in the render cycle? Skip event
        if (!dragHandle.dd || !dragHandle.dd.constrain) {
            return;
        }

        // User actively dragging? Skip event
        if (typeof dragHandle.dd.dragEnded !== 'undefined' && !dragHandle.dd.dragEnded) {
            return;
        }

        // y-axis of slider with value 0-1 translates to reverse of "saturation"
        yRatio = 1-(saturation/100);
        top = containerHeight*yRatio;

        // Position dragger
        dragHandle.getEl().setStyle({
            top  : top + 'px'
        });
    },

    // Called via data binding whenever selectedColor.h changes; hue param is 0-1
    setHue: function(hue) {
        var me = this,
            container = me.getDragContainer(),
            rgb, hex;

        // Too early in the render cycle? Skip event
        if (!me.getEl()) {
            return;
        }

        // Determine HEX for new hue and set as background based on template
        rgb = Ext.ux.colorpick.ColorUtils.hsv2rgb(hue, 1, 1);
        hex = Ext.ux.colorpick.ColorUtils.rgb2hex(rgb.r, rgb.g, rgb.b);
        container.getEl().applyStyles(me.gradientStyleTpl.apply({hex: hex}));
    }
});
/**
 * Used for "Value" slider.
 * @private
 */
Ext.define('Ext.ux.colorpick.SliderValue', {
    extend : 'Ext.ux.colorpick.Slider',
    alias  : 'widget.colorpickerslidervalue',
    cls    : Ext.baseCSSPrefix + 'colorpicker-value',

    requires: [
        'Ext.XTemplate'
    ],

    gradientStyleTpl: Ext.create('Ext.XTemplate',
        Ext.isIE && Ext.ieVersion < 10
        ? 'filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0, startColorstr=\'#{hex}\', endColorstr=\'#000000\');' /* IE6-9 */
        : 'background: -mox-linear-gradient(top, #{hex} 0%, #000000 100%);' +   /* FF3.6+ */
          'background: -webkit-linear-gradient(top, #{hex} 0%,#000000 100%);' + /* Chrome10+,Safari5.1+ */
          'background: -o-linear-gradient(top, #{hex} 0%,#000000 100%);' +      /* Opera 11.10+ */
          'background: -ms-linear-gradient(top, #{hex} 0%,#000000 100%);' +     /* IE10+ */
          'background: linear-gradient(to bottom, #{hex} 0%,#000000 100%);'     /* W3C */
    ),

    // Called via data binding whenever selectedColor.v changes; value param is 0-100
    setValue: function(value) {
        var me              = this,
            container       = me.getDragContainer(),
            dragHandle      = me.getDragHandle(),
            containerEl     = container.getEl(),
            containerHeight = containerEl.getHeight(),
            yRatio,
            top;

        // Too early in the render cycle? Skip event
        if (!dragHandle.dd || !dragHandle.dd.constrain) {
            return;
        }

        // User actively dragging? Skip event
        if (typeof dragHandle.dd.dragEnded !== 'undefined' && !dragHandle.dd.dragEnded) {
            return;
        }

        // y-axis of slider with value 0-1 translates to reverse of "value"
        yRatio = 1-(value/100);
        top = containerHeight*yRatio;

        // Position dragger
        dragHandle.getEl().setStyle({
            top  : top + 'px'
        });
    },

    // Called via data binding whenever selectedColor.h changes; hue param is 0-1
    setHue: function(hue) {
        var me = this,
            container = me.getDragContainer(),
            rgb, hex;

        // Too early in the render cycle? Skip event
        if (!me.getEl()) {
            return;
        }

        // Determine HEX for new hue and set as background based on template
        rgb = Ext.ux.colorpick.ColorUtils.hsv2rgb(hue, 1, 1);
        hex = Ext.ux.colorpick.ColorUtils.rgb2hex(rgb.r, rgb.g, rgb.b);
        container.getEl().applyStyles(me.gradientStyleTpl.apply({hex: hex}));
    }
});
/**
 * Used for "Hue" slider.
 * @private
 */
Ext.define('Ext.ux.colorpick.SliderHue', {
    extend : 'Ext.ux.colorpick.Slider',
    alias  : 'widget.colorpickersliderhue',
    cls    : Ext.baseCSSPrefix + 'colorpicker-hue',

    afterRender: function () {
        var me  = this,
            src = me.gradientUrl,
            el  = me.el;

        me.callParent();
        
        if (!src) {
            // We do this trick to allow the Sass to calculate resource image path for
            // our package and pick up the proper image URL here.
            src = el.getStyle('background-image');
            src = src.substring(4, src.length - 1);  // strip off outer "url(...)"

            // In IE8 this path will have quotes around it
            if (src.indexOf('"') === 0) {
                src = src.substring(1, src.length-1);
            }

            // Then remember it on our prototype for any subsequent instances.
            Ext.ux.colorpick.SliderHue.prototype.gradientUrl = src;
        }

        // Now clear that style because it will conflict with the background-color
        el.setStyle('background-image', 'none');

        // Create the image with the background PNG
        el = me.getDragContainer().layout.getElementTarget(); // the el for items and html
        el.createChild({
            tag: 'img',
            cls: Ext.baseCSSPrefix + 'colorpicker-hue-gradient',
            src: src
        });
    },


    // Called via data binding whenever selectedColor.h changes; hue param is 0-1
    setHue: function(hue) {
        var me              = this,
            container       = me.getDragContainer(),
            dragHandle      = me.getDragHandle(),
            containerEl     = container.getEl(),
            containerHeight = containerEl.getHeight(),
            el, top;

        // Too early in the render cycle? Skip event
        if (!dragHandle.dd || !dragHandle.dd.constrain) {
            return;
        }

        // User actively dragging? Skip event
        if (typeof dragHandle.dd.dragEnded !== 'undefined' && !dragHandle.dd.dragEnded) {
            return;
        }

        // y-axis of slider with value 0-1 translates to reverse of "hue"
        top = containerHeight * (360 - hue) / 360;

        // Position dragger
        el = dragHandle.getEl();
        el.setStyle({
            top  : top + 'px'
        });
    }
});
/**
 * Sencha Pro Services presents xtype "colorselector".
 * API has been kept as close to the regular colorpicker as possible. The Selector can be
 * rendered to any container.
 *
 * The defaul selected color is configurable via {@link #value} config. Usually used in
 * forms via {@link Ext.ux.colorpick.Button} or {@link Ext.ux.colorpick.Field}.
 *
 * Typically you will need to listen for the change event to be notified when the user
 * chooses a color. Alternatively, you can bind to the "value" config
 *
 *     @example
 *     Ext.create('Ext.ux.colorpick.Selector', {
 *         value     : '993300',  // initial selected color
 *         renderTo  : Ext.getBody(),
 *         listeners: {
 *             change: function (colorselector, color) {
 *                 console.log('New color: ' + color);
 *             }
 *         }
 *     });
 */
Ext.define('Ext.ux.colorpick.Selector', {
    extend: 'Ext.container.Container',
    xtype: 'colorselector',

    mixins: [
        'Ext.ux.colorpick.Selection'
    ],

    controller : 'colorpick-selectorcontroller',

    requires: [
        'Ext.layout.container.HBox',
        'Ext.form.field.Text',
        'Ext.form.field.Number',
        'Ext.ux.colorpick.ColorMap',
        'Ext.ux.colorpick.SelectorModel',
        'Ext.ux.colorpick.SelectorController',
        'Ext.ux.colorpick.ColorPreview',
        'Ext.ux.colorpick.Slider',
        'Ext.ux.colorpick.SliderAlpha',
        'Ext.ux.colorpick.SliderSaturation',
        'Ext.ux.colorpick.SliderValue',
        'Ext.ux.colorpick.SliderHue'
    ],

    width: 580, // default width and height gives 255x255 color map in Crisp
    height: 337,

    cls: Ext.baseCSSPrefix + 'colorpicker',
    padding: 10,

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    defaultBindProperty: 'value',
    twoWayBindable: [
        'value'
    ],

    /**
     * @cfg fieldWidth {Number} Width of the text fields on the container (excluding HEX);
     * since the width of the slider containers is the same as the text field under it 
     * (it's the same vbox column), changing this value will also affect the spacing between
     * the sliders.
     */
    fieldWidth: 50,

    /**
     * @cfg fieldPad {Number} padding between the sliders and HEX/R/G/B fields.
     */    
    fieldPad: 5,

    /**
     * @cfg {Boolean} [showPreviousColor]
     * Whether "previous color" region (in upper right, below the selected color preview) should be shown;
     * these are relied upon by the {@link Ext.ux.colorpick.Button} and the {@link Ext.ux.colorpick.Field}.
     */
    showPreviousColor: false,

    /**
     * @cfg {Boolean} [showOkCancelButtons]
     * Whether Ok and Cancel buttons (in upper right, below the selected color preview) should be shown;
     * these are relied upon by the {@link Ext.ux.colorpick.Button} and the {@link Ext.ux.colorpick.Field}.
     */
    showOkCancelButtons: false,

    /**
     * @event change
     * Fires when a color is selected. Simply dragging sliders around will trigger this.
     * @param {Ext.ux.colorpick.Selector} this
     * @param {String} color The value of the selected color as per specified {@link #format}.
     * @param {String} previousColor The previous color value.
     */

    /**
     * @event ok
     * Fires when OK button is clicked (see {@link #showOkCancelButtons}).
     * @param {Ext.ux.colorpick.Selector} this
     * @param {String} color The value of the selected color as per specified {@link #format}.
     */

    /**
     * @event cancel
     * Fires when Cancel button is clicked (see {@link #showOkCancelButtons}).
     * @param {Ext.ux.colorpick.Selector} this
     */

    listeners: {
        resize: 'onResize'
    },

    constructor: function (config) {
        var me             = this,
            childViewModel = Ext.Factory.viewModel('colorpick-selectormodel');

        // Since this component needs to present its value as a thing to which users can
        // bind, we create an internal VM for our purposes.
        me.childViewModel = childViewModel;
        me.items = [
            me.getMapAndHexRGBFields(childViewModel),
            me.getSliderAndHField(childViewModel),
            me.getSliderAndSField(childViewModel),
            me.getSliderAndVField(childViewModel),
            me.getSliderAndAField(childViewModel),
            me.getPreviewAndButtons(childViewModel, config)
        ];

        me.callParent(arguments);
    },

    updateColor: function (color) {
        var me = this;

        me.mixins.colorselection.updateColor.call(me, color);

        me.childViewModel.set('selectedColor', color);
    },

    updatePreviousColor: function (color) {
        this.childViewModel.set('previousColor', color);
    },

    // Splits up view declaration for readability
    // "Map" and HEX/R/G/B fields
    getMapAndHexRGBFields: function (childViewModel) {
        var me = this,
            fieldMargin = { top: 0, right: me.fieldPad, bottom: 0, left: 0 },
            fieldWidth = me.fieldWidth;

        return {
            xtype     : 'container',
            viewModel : childViewModel,
            cls       : Ext.baseCSSPrefix + 'colorpicker-escape-overflow',
            flex      : 1,
            layout    : {
                type  : 'vbox',
                align : 'stretch'
            },
            margin : '0 10 0 0',
            items  : [
                // "MAP"
                {
                    xtype : 'colorpickercolormap',
                    reference: 'colorMap',
                    flex  : 1,
                    bind  : {
                        position: {
                            bindTo : '{selectedColor}',
                            deep   : true
                        },
                        hue: '{selectedColor.h}'
                    },
                    listeners : {
                        handledrag: 'onColorMapHandleDrag'
                    }
                },
                // HEX/R/G/B FIELDS
                {
                    xtype    : 'container',
                    layout   : 'hbox',

                    defaults : {
                        labelAlign: 'top',
                        labelSeparator: '',
                        allowBlank: false,

                        onChange: function () { // prevent data binding propagation if bad value
                            if (this.isValid()) {
                                // this is kind of dirty and ideally we would extend these fields
                                // and override the method, but works for now
                                Ext.form.field.Base.prototype.onChange.apply(this, arguments);
                            }
                        }
                    },

                    items: [{
                        xtype      : 'textfield',
                        fieldLabel : 'HEX',
                        flex       : 1,
                        bind       : '{hex}',
                        margin     : fieldMargin,
                        readOnly   : true
                    }, {
                        xtype       : 'numberfield',
                        fieldLabel  : 'R',
                        bind        : '{red}',
                        width       : fieldWidth,
                        hideTrigger : true,
                        maxValue    : 255,
                        minValue    : 0,
                        margin      : fieldMargin
                    }, {
                        xtype       : 'numberfield',
                        fieldLabel  : 'G',
                        bind        : '{green}',
                        width       : fieldWidth,
                        hideTrigger : true,
                        maxValue    : 255,
                        minValue    : 0,
                        margin      : fieldMargin
                    }, {
                        xtype       : 'numberfield',
                        fieldLabel  : 'B',
                        bind        : '{blue}',
                        width       : fieldWidth,
                        hideTrigger : true,
                        maxValue    : 255,
                        minValue    : 0,
                        margin      : 0
                    }]
                }
            ]
        };
    },

    // Splits up view declaration for readability
    // Slider and H field 
    getSliderAndHField: function (childViewModel) {
        var me = this;
        return {
            xtype     : 'container',
            viewModel : childViewModel,
            cls       : Ext.baseCSSPrefix + 'colorpicker-escape-overflow',
            width     : me.fieldWidth,
            layout    : {
                type  : 'vbox',
                align : 'stretch'
            },
            items  : [
                {
                    xtype: 'colorpickersliderhue',
                    reference: 'hueSlider',
                    flex  : 1,
                    bind: {
                        hue: '{selectedColor.h}'
                    },
                    listeners: {
                        handledrag: 'onHueSliderHandleDrag'
                    }
                },
                {
                    xtype          : 'numberfield',
                    fieldLabel     : 'H',
                    labelAlign     : 'top',
                    width          : me.fieldWidth,
                    labelSeparator : '',
                    bind           : '{hue}',
                    hideTrigger    : true,
                    maxValue       : 360,
                    minValue       : 0,
                    allowBlank     : false,
                    margin         : 0
                }
            ]
        };
    },

    // Splits up view declaration for readability
    // Slider and S field 
    getSliderAndSField: function (childViewModel) {
        var me = this;
        return {
            xtype     : 'container',
            viewModel : childViewModel,
            cls       : Ext.baseCSSPrefix + 'colorpicker-escape-overflow',
            width     : me.fieldWidth,
            layout    : {
                type  : 'vbox',
                align : 'stretch'
            },
            margin: {
                right  : me.fieldPad,
                left   : me.fieldPad
            },
            items: [
                {
                    xtype : 'colorpickerslidersaturation',
                    reference: 'satSlider',
                    flex  : 1,
                    bind  : {
                        saturation : '{saturation}',
                        hue        : '{selectedColor.h}'
                    },
                    listeners : {
                        handledrag: 'onSaturationSliderHandleDrag'
                    }
                },
                {
                    xtype          : 'numberfield',
                    fieldLabel     : 'S',
                    labelAlign     : 'top',
                    labelSeparator : '',
                    bind           : '{saturation}',
                    hideTrigger    : true,
                    maxValue       : 100,
                    minValue       : 0,
                    allowBlank     : false,
                    margin         : 0
                }
            ]
        };
    },

    // Splits up view declaration for readability
    // Slider and V field 
    getSliderAndVField: function (childViewModel) {
        var me = this;
        return {
            xtype     : 'container',
            viewModel : childViewModel,
            cls       : Ext.baseCSSPrefix + 'colorpicker-escape-overflow',
            width     : me.fieldWidth,
            layout    : {
                type  : 'vbox',
                align : 'stretch'
            },
            items: [
                {
                    xtype : 'colorpickerslidervalue',
                    reference: 'valueSlider',
                    flex  : 1,
                    bind  : {
                        value : '{value}',
                        hue   : '{selectedColor.h}'
                    },
                    listeners : {
                        handledrag: 'onValueSliderHandleDrag'
                    }
                },
                {
                    xtype          : 'numberfield',
                    fieldLabel     : 'V',
                    labelAlign     : 'top',
                    labelSeparator : '',
                    bind           : '{value}',
                    hideTrigger    : true,
                    maxValue       : 100,
                    minValue       : 0,
                    allowBlank     : false,
                    margin         : 0
                }
            ]
        };
    },

    // Splits up view declaration for readability
    // Slider and A field 
    getSliderAndAField: function (childViewModel) {
        var me = this;
        return {
            xtype     : 'container',
            viewModel : childViewModel,
            cls       : Ext.baseCSSPrefix + 'colorpicker-escape-overflow',
            width     : me.fieldWidth,
            layout    : {
                type  : 'vbox',
                align : 'stretch'
            },
            margin: {
                left: me.fieldPad
            },
            items: [
                {
                    xtype : 'colorpickerslideralpha',
                    reference: 'alphaSlider',
                    flex  : 1,
                    bind  : {
                        alpha : '{alpha}',
                        color : {
                            bindTo: '{selectedColor}',
                            deep: true
                        }
                    },
                    listeners : {
                        handledrag: 'onAlphaSliderHandleDrag'
                    }
                },
                {
                    xtype          : 'numberfield',
                    fieldLabel     : 'A',
                    labelAlign     : 'top',
                    labelSeparator : '',
                    bind           : '{alpha}',
                    hideTrigger    : true,
                    maxValue       : 100,
                    minValue       : 0,
                    allowBlank     : false,
                    margin         : 0
                }
            ]
        };
    },

    // Splits up view declaration for readability
    // Preview current/previous color squares and OK and Cancel buttons
    getPreviewAndButtons: function (childViewModel, config) {
        // selected color preview is always shown
        var items = [{
            xtype : 'colorpickercolorpreview',
            flex  : 1,
            bind  : {
                color: {
                    bindTo : '{selectedColor}',
                    deep   : true
                }
            }
        }];

        // previous color preview is optional
        if (config.showPreviousColor) {
            items.push({
                xtype  : 'colorpickercolorpreview',
                flex   : 1,
                bind   : {
                    color: {
                        bindTo : '{previousColor}',
                        deep   : true
                    }
                },
                listeners: {
                    click: 'onPreviousColorSelected'
                }
            });
        }

        // Ok/Cancel buttons are optional
        if (config.showOkCancelButtons) {
            items.push({
                xtype   : 'button',
                text    : 'OK',
                margin  : '10 0 0 0',
                handler : 'onOK'
            },
            {
                xtype   : 'button',
                text    : 'Cancel',
                margin  : '10 0 0 0',
                handler : 'onCancel'
            });
        }

        return {
            xtype     : 'container',
            viewModel : childViewModel,
            width     : 70,
            margin    : '0 0 0 10',
            items     : items,
            layout    : {
                type  : 'vbox',
                align : 'stretch'
            }
        };
    }
});
/**
 * A field that can be clicked to bring up the color picker.
 * The selected color is configurable via {@link #value}.
 *
 *      @example
 *      Ext.create({
 *          xtype: 'colorfield',
 *          renderTo: Ext.getBody(),
 *
 *          value: '#993300',  // initial selected color
 *
 *          listeners : {
 *              change: function (field, color) {
 *                  console.log('New color: ' + color);
 *              }
 *          }
 *      });
 */
Ext.define('Ext.ux.colorpick.Field', {
    extend: 'Ext.form.field.Picker',
    xtype: 'colorfield',

    mixins: [
        'Ext.ux.colorpick.Selection'
    ],

    requires: [
        'Ext.window.Window',
        'Ext.ux.colorpick.Selector',
        'Ext.ux.colorpick.ColorUtils',
        'Ext.layout.container.Fit'
    ],

    editable: false,

    matchFieldWidth: false, // picker is usually wider than field

    // "Color Swatch" shown on the left of the field
    beforeBodyEl: [
        '<div class="' + Ext.baseCSSPrefix + 'colorpicker-field-swatch">' +
            '<div id="{id}-swatchEl" data-ref="swatchEl" class="' + Ext.baseCSSPrefix +
                    'colorpicker-field-swatch-inner"></div>' +
        '</div>'
    ],

    cls: Ext.baseCSSPrefix + 'colorpicker-field',
    childEls: [
        'swatchEl'
    ],

    config: {
        /**
         * @cfg {Object} popup
         * This object configures the popup window and colorselector component displayed
         * when this button is clicked. Applications should not need to configure this.
         * @private
         */
        popup: {
            lazy: true,
            $value: {
                xtype: 'window',
                referenceHolder: true,
                minWidth: 540,
                minHeight: 200,
                layout: 'fit',
                header: false,
                resizable: true,
                items: {
                    xtype: 'colorselector',
                    reference: 'selector',
                    showPreviousColor: true,
                    showOkCancelButtons: true
                }
            }
        }
    },

    /**
     * @event change
     * Fires when a color is selected.
     * @param {Ext.ux.colorpick.Field} this
     * @param {String} color The value of the selected color as per specified {@link #format}.
     * @param {String} previousColor The previous color value.
     */

    // NOTE: Since much of the logic of a picker class is overriding methods from the
    // base class, we don't bother to split out the small remainder as a controller.

    afterRender: function () {
        this.callParent();

        this.updateValue(this.value);
    },

    // override as required by parent pickerfield
    createPicker: function() {
        var me = this,
            popup = me.getPopup(),
            picker;

        // the window will actually be shown and will house the picker
        me.colorPickerWindow = popup = Ext.create(popup);
        me.colorPicker = picker = popup.lookupReference('selector');

        picker.setFormat(me.getFormat());
        picker.setColor(me.getColor());
        picker.on({
            ok: 'onColorPickerOK',
            cancel: 'onColorPickerCancel',
            scope: me
        });

        return me.colorPickerWindow;
    },

    // When the Ok button is clicked on color picker, preserve the previous value
    onColorPickerOK: function (colorPicker) {
        this.setColor(colorPicker.getColor());

        this.collapse();
    },

    onColorPickerCancel: function () {
        this.collapse();
    },

    onExpand: function () {
        var color = this.getColor();

        this.colorPicker.setPreviousColor(color);
    },

    // Expects value formatted as per "format" config
    setValue: function(color) {
        var me = this,
            c = me.applyValue(color);

        me.callParent([c]);

        // always update in case opacity changes, even if value doesn't have it
        // to handle "hex6" non-opacity type of format
        me.updateValue(c);
    },

    // Sets this.format and color picker's setFormat()
    updateFormat: function(format) {
        var cp = this.colorPicker;

        if (cp) {
            cp.setFormat(format);
        }
    },

    updateValue: function (color) {
        var me = this,
            c;

        // If the "value" is changed, update "color" as well. Since these are always
        // tracking each other, we guard against the case where we are being updated
        // *because* "color" is being set.
        if (!me.syncing) {
            me.syncing = true;
            me.setColor(color);
            me.syncing = false;
        }

        c = me.getColor();

        Ext.ux.colorpick.ColorUtils.setBackground(me.swatchEl, c);

        if (me.colorPicker) {
            me.colorPicker.setColor(c);
        }
    }
});
/**
 * Plugin for adding a close context menu to tabs. Note that the menu respects
 * the closable configuration on the tab. As such, commands like remove others
 * and remove all will not remove items that are not closable.
 */
Ext.define('Ext.ux.TabCloseMenu', {
    extend: 'Ext.plugin.Abstract',

    alias: 'plugin.tabclosemenu',

    mixins: {
        observable: 'Ext.util.Observable'
    },

    /**
     * @cfg {String} closeTabText
     * The text for closing the current tab.
     */
    closeTabText: 'Close Tab',

    /**
     * @cfg {Boolean} showCloseOthers
     * Indicates whether to show the 'Close Others' option.
     */
    showCloseOthers: true,

    /**
     * @cfg {String} closeOthersTabsText
     * The text for closing all tabs except the current one.
     */
    closeOthersTabsText: 'Close Other Tabs',

    /**
     * @cfg {Boolean} showCloseAll
     * Indicates whether to show the 'Close All' option.
     */
    showCloseAll: true,

    /**
     * @cfg {String} closeAllTabsText
     * The text for closing all tabs.
     */
    closeAllTabsText: 'Close All Tabs',

    /**
     * @cfg {Array} extraItemsHead
     * An array of additional context menu items to add to the front of the context menu.
     */
    extraItemsHead: null,

    /**
     * @cfg {Array} extraItemsTail
     * An array of additional context menu items to add to the end of the context menu.
     */
    extraItemsTail: null,

    //public
    constructor: function (config) {
        this.callParent([config]);
        this.mixins.observable.constructor.call(this, config);
    },

    init : function(tabpanel){
        this.tabPanel = tabpanel;
        this.tabBar = tabpanel.down("tabbar");

        this.mon(this.tabPanel, {
            scope: this,
            afterlayout: this.onAfterLayout,
            single: true
        });
    },

    onAfterLayout: function() {
        this.mon(this.tabBar.el, {
            scope: this,
            contextmenu: this.onContextMenu,
            delegate: '.x-tab'
        });
    },

    destroy : function(){
        this.callParent();
        Ext.destroy(this.menu);
    },

    // private
    onContextMenu : function(event, target){
        var me = this,
            menu = me.createMenu(),
            disableAll = true,
            disableOthers = true,
            tab = me.tabBar.getChildByElement(target),
            index = me.tabBar.items.indexOf(tab);

        me.item = me.tabPanel.getComponent(index);
        menu.child('#close').setDisabled(!me.item.closable);

        if (me.showCloseAll || me.showCloseOthers) {
            me.tabPanel.items.each(function(item) {
                if (item.closable) {
                    disableAll = false;
                    if (item !== me.item) {
                        disableOthers = false;
                        return false;
                    }
                }
                return true;
            });

            if (me.showCloseAll) {
                menu.child('#closeAll').setDisabled(disableAll);
            }

            if (me.showCloseOthers) {
                menu.child('#closeOthers').setDisabled(disableOthers);
            }
        }

        event.preventDefault();
        me.fireEvent('beforemenu', menu, me.item, me);

        menu.showAt(event.getXY());
    },

    createMenu : function() {
        var me = this;

        if (!me.menu) {
            var items = [{
                itemId: 'close',
                text: me.closeTabText,
                scope: me,
                handler: me.onClose
            }];

            if (me.showCloseAll || me.showCloseOthers) {
                items.push('-');
            }

            if (me.showCloseOthers) {
                items.push({
                    itemId: 'closeOthers',
                    text: me.closeOthersTabsText,
                    scope: me,
                    handler: me.onCloseOthers
                });
            }

            if (me.showCloseAll) {
                items.push({
                    itemId: 'closeAll',
                    text: me.closeAllTabsText,
                    scope: me,
                    handler: me.onCloseAll
                });
            }

            if (me.extraItemsHead) {
                items = me.extraItemsHead.concat(items);
            }

            if (me.extraItemsTail) {
                items = items.concat(me.extraItemsTail);
            }

            me.menu = Ext.create('Ext.menu.Menu', {
                items: items,
                listeners: {
                    hide: me.onHideMenu,
                    scope: me
                }
            });
        }

        return me.menu;
    },

    onHideMenu: function () {
        var me = this;
        me.fireEvent('aftermenu', me.menu, me);
    },

    onClose : function(){
        this.tabPanel.remove(this.item);
    },

    onCloseOthers : function(){
        this.doClose(true);
    },

    onCloseAll : function(){
        this.doClose(false);
    },

    doClose : function(excludeActive){
        var items = [];

        this.tabPanel.items.each(function(item){
            if(item.closable){
                if(!excludeActive || item !== this.item){
                    items.push(item);
                }
            }
        }, this);

        Ext.suspendLayouts();
        Ext.Array.forEach(items, function(item){
            this.tabPanel.remove(item);
        }, this);
        Ext.resumeLayouts(true);
    }
});
/*
ExtJS 4.x wrapper for CKEditor (http://ckeditor.com/)
https://github.com/fp0/extjs4-ckeditor
*/

//Adaptacion a Extjs5 hecha por GArrom.

if (typeof CKEDITOR !== "undefined") {
	Ext.define('Ext.ux.CKEditor', {
		extend: 'Ext.form.field.TextArea',
		alias: 'widget.ckeditor',

		isReady: false,
		valueCache: null,

		initComponent: function () {
			this.callParent(arguments);
			//this.fireEvent("render", this, this.editor);
			//console.log("Define afterrender");
			this.on("afterrender", function () {
				var size = {
					height: this.getHeight() + 100,
					width: this.getWidth()
				};
				Ext.apply(this.CKConfig, size);

				this.editor = CKEDITOR.replace(this.inputEl.id, this.CKConfig);
				this.editor.name = this.name;
				this.editor.extField = this;
				this.dt = new Ext.util.DelayedTask(function () {
					this.extField.fireEvent("change");
				});
				this.editor.on("change", function () {
					this.extField.dt.delay(500, null, this);
				});

				//console.log("Define instanceReady");
				this.editor.on("instanceReady", function () {
					//console.log("instanceReady", this.isReady);
					this.fireEvent("instanceReady", this, this.editor);
					this.isReady = true;
					if (this.valueCache) {
						this.setValue(this.valueCache);
					}
				}, this);

				this.dtResize = new Ext.util.DelayedTask();

				this.editor.on("resize", function (evt) {
					// console.log("resized", arguments);
					this.extField.dtResize.delay(500, function () {
						this.fireEvent("resize", this, this.editor);
					}, this.extField);
				});
			}, this);
		},

		onRender: function (ct, position) {
			if (!this.el) {
				this.defaultAutoCreate = {
					tag: 'textarea',
					autocomplete: 'off'
				};
			}
			this.callParent(arguments)
		},

		setValue: function (value) {
			var me = this;
			if (this.isReady) {
				if (this.editor) {
					this.editor.setData(value);
					//console.log("EDITOR: seteamos value", value);
				} else {
					//console.log("EDITOR: no esta ready", value);
				}
				this.callParent(arguments);
			} else {

				//console.log("EDITOR: ponemos valor en cache", value);
			}
			this.valueCache = value;
		},

		getValue: function () {
			if (this.editor) {
				//console.log("Devolviendo datos");
				return this.editor.getData();
			} else {
				//console.log("No hay datos que retornar")
				return ''
			}
		}
	});

	(function () {
		CKEDITOR.plugins.add('multilang', {
			init: function (editor) {
				var pluginName = 'multilang';
				editor.ui.addButton('multilang', {
					label: 'Cambiar idioma',
					command: 'OpenWindow',
					toolbar: 'multilanggroup',
					icon: 'langimg/multilang-icon-Es.png'
				});
				var cmd = editor.addCommand('OpenWindow', {
					exec: showMyDialog
				});
			}
		});

		function showMyDialog(e) {
			var extjs = e.extField;
			var cls = extjs.seleccionarIdioma.call(extjs, extjs.currentLang + 1);
			//CKEDITOR.plugins.getPath('multilang');
			var btn = Ext.select("#" + e.id + "_toolbox .cke_button__multilang_icon").elements[0];
			//btn.style.backgroundImage.match(/https?:\/\/[^\)\"\']*/)[0]

			/*
			var newCls = btn.style.backgroundImage.split("langimg/")[0];
			newCls += "langimg/" + cls + ".png" + "\")";
			*/

			var origin = window.location.protocol + "//" + window.location.host;
			var pathName = window.location.pathname;
			var path = "";
			pathName = pathName.split("/");
			if (pathName.length > 3) {
				//garrom: No esta testeado, pero si hay mas de una ruta de path, deberia funcionar
				for (var i = 1; i < pathName.length - 1; i++) {
					path = "/" + pathName[i];
				};
			} else {
				path = "/" + pathName[pathName.length - 2];
			}
			var imgUrl = origin + path + "/ext5/uxAt4/ckeditor/ckeditor/langimg/" + cls + ".png";
			var newCls = "url(\"" + imgUrl + "\")";
			btn.style.backgroundImage = newCls;
		}
	})();
}
Ext.define('At4FrameworkIntranet.MultiList', {
    extend: 'Ext.grid.filters.filter.SingleFilter',
    alias: 'grid.filter.multiList',

    type: 'multiList',

    operator: 'in',

    itemDefaults: {
        checked: false,
        hideOnClick: false,
        maxWidth: 300
    },
    menuDefaults: {
        xtype: 'menu',
        maxHeight: 450,
        minWidth: 250,
        cls: "at4-multilist",
        maxWidth: 300
    },
    multiConfigDefaults: {
        xtype: 'multiselect',
        displayField: "DISPLAY",
        valueField: "ID",
        minWidth: 250,
        dock: "top"
    },
    /**
     * @cfg {Object} [itemDefaults]
     * See the {@link Ext.grid.filters.Base#cfg-itemDefaults documentation} for the base class for
     * details.
     *
     * In the case of this class, however, note that the `checked` config should **not** be
     * specified.
     */

    /**
     * @cfg {Array} [options]
     * The data to be used to implicitly create a data store to back this list. This is used only when
     * the data source is **local**. If the data for the list is remote, use the {@link #store}
     * config instead.
     *
     * If neither store nor {@link #options} is specified, then the choices list is automatically
     * populated from all unique values of the specified {@link #dataIndex} field in the store at first
     * time of filter invocation.
     *
     * Each item within the provided array may be in one of the following formats:
     *
     *   - **Array** :
     *
     *         options: [
     *             [11, 'extra small'],
     *             [18, 'small'],
     *             [22, 'medium'],
     *             [35, 'large'],
     *             [44, 'extra large']
     *         ]
     *
     *   - **Object** :
     *
     *         labelField: 'name', // override default of 'text'
     *         options: [
     *             {id: 11, name:'extra small'},
     *             {id: 18, name:'small'},
     *             {id: 22, name:'medium'},
     *             {id: 35, name:'large'},
     *             {id: 44, name:'extra large'}
     *         ]
     *
     *   - **String** :
     *
     *         options: ['extra small', 'small', 'medium', 'large', 'extra large']
     *
     */

    /**
     * @cfg {String} [idField="id"]
     * The field name for the `id` of records in this list's `{@link #cfg-store}`. These values are
     * used to populate the filter for the grid's store.
     */
    idField: 'id',

    /**
     * @cfg {String} [labelField="text"]
     * The field name for the menu item text in the records in this list's `{@link #cfg-store}`.
     */
    labelField: 'text',

    /**
     * @cfg {String} [labelIndex]
     * The field in the records of the grid's store from which the menu item text should be retrieved.
     * This field is only used when no `{@link #cfg-options}` and no `{@link #cfg-store}` is provided
     * and the distinct value of the grid's store need to be generated dynamically.
     *
     * If not provided, this field defaults to the column's `dataIndex` property.
     * @since 5.1.0
     */
    labelIndex: null,

    //<locale>
    /**
     * @cfg {String} paramPrefix
     * Defaults to 'Loading...'.
     */
    loadingText: 'Loading...',

    filterText: 'Search...',

    elemSelec: "{0} elementos seleccionados.",
    //</locale>

    /**
     * @cfg {Boolean} loadOnShow
     * Defaults to true.
     */
    loadOnShow: true,

    /**
     * @cfg {Boolean} single
     * Specify true to group all items in this list into a single-select
     * radio button group. Defaults to false.
     */
    single: false,

    plain: true,

    /**
     * @cfg {Ext.data.Store} [store]
     * The {@link Ext.data.Store} this list should use as its data source.
     *
     * If neither store nor {@link #options} is specified, then the choices list is automatically
     * populated from all unique values of the specified {@link #dataIndex} field in the store at first
     * time of filter invocation.
     */

    constructor: function(config) {
        //console.log("MultilistFilter constructor");
        //return;
        var me = this,
            options, store;

        me.callParent([config]);

        //<debug>
        if (me.itemDefaults.checked) {
            Ext.Error.raise('The itemDefaults.checked config is not supported, use the value config instead.');
        }
        //</debug>

        options = me.options;
        store = me.store;

        // In order to fully support the `active` config, we need to do some preprocessing in case we need to fetch store data
        // in order to create the options menu items.
        //
        // In addition, if the List filter is auto-creating its store from the unique values in the grid store (i.e., no `options` or
        // `store` configs), it will need to listen to grid store events to properly sync its options when the grid store changes.
        if (!options && !store) {
            // Here we need to subscribe to very specific events. We can't subscribe to a catch-all like 'datachanged' because the listener
            // will get called too many times.
            // This will respond to the following scenarios:
            //  1. Removing a filter
            //  2. Adding a filter
            //  3. (Re)loading the store
            //  4. Updating a model
            me.getGridStore().on({
                scope: me,
                add: me.onDataChanged,
                refresh: me.onDataChanged,
                remove: me.onDataChanged,
                update: me.onDataChanged
            });
        }

        me.labelIndex = me.labelIndex || me.column.dataIndex;
    },

    destroy: function() {
        //console.log("MultilistFilter destroy");
        return;
        var me = this,
            store = me.store,
            autoStore = me.autoStore;

        // We may bind listeners to both the options store & grid store, so we
        // need to unbind both sets here
        if (store) {
            if (autoStore || store.autoDestroy) {
                store.destroy();
            } else {
                store.un('load', me.bindMenuStore, me);
            }

            me.store = null;
        }

        if (autoStore) {
            me.getGridStore().un({
                scope: me,
                add: me.onDataChanged,
                refresh: me.onDataChanged,
                remove: me.onDataChanged,
                update: me.onDataChanged
            });
        }

        me.callParent();
    },

    activateMenu: function() {
        console.log("MultilistFilter activateMenu");

        var me = this,
            value = me.filter.getValue(),
            items, i, len, checkItem;

        // me.multiselect.store.load();


        if (!value || !value.length) {
            return;
        }

        items = me.menu.items;

        for (i = 0, len = items.length; i < len; i++) {
            checkItem = items.getAt(i);

            if (Ext.Array.indexOf(value, checkItem.value) > -1) {
                checkItem.setChecked(true, /*suppressEvents*/ true);
            }
        }
    },

    bindMenuStore: function(options) {
        console.log("MultilistFilter bindMenuStore");
        return;
        var me = this;

        if (me.grid.isDestroyed || me.preventFilterRemoval) {
            return;
        }

        me.createListStore(options);
        me.createMenuItems(me.store);
        me.loaded = true;
    },

    createListStore: function(options) {
        console.log("MultilistFilter createListStore");
        return;
        var me = this,
            store = me.store,
            isStore = options.isStore,
            idField = me.idField,
            labelField = me.labelField,
            optionsStore = false,
            storeData, o, record, i, len, value, filter;

        if (isStore) {
            if (options !== me.getGridStore()) {
                optionsStore = true;
                store = me.store = options;
            } else {
                me.autoStore = true;
                storeData = me.getOptionsFromStore(options);
            }
        } else {
            storeData = [];

            for (i = 0, len = options.length; i < len; i++) {
                value = options[i];

                switch (Ext.typeOf(value)) {
                    case 'array':
                        storeData.push(value);
                        break;
                    case 'object':
                        storeData.push(value);
                        break;
                    default:
                        if (value != null) {
                            o = {};
                            o[idField] = value;
                            o[labelField] = value;
                            storeData.push(o);
                        }
                }
            }
        }

        if (!optionsStore) {
            if (store) {
                store.destroy();
            }

            store = me.store = new Ext.data.Store({
                fields: [idField, labelField],
                data: storeData
            });

            me.loaded = true;
        }

        me.setStoreFilter(store);
    },

    /**
     * @private
     * Creates the Menu for this filter.
     * @param {Object} config Filter configuration
     * @return {Ext.menu.Menu}
     */
    createMenu: function(config) {
        console.log("MultilistFilter createMenu");
        //return;
        var me = this,
            gridStore = me.getGridStore(),
            store = me.store,
            options = me.options,
            menu;

        if (store) {
            me.store = store = Ext.StoreManager.lookup(store);
        }
        me.store.setRemoteFilter(false);
        me.callParent([config]);
        menu = me.menu;

        /*menu.add({
            xtype: "container",
            html: "loren ipsum dolor sit amet"
        })*/
        me.resumenFilter = Ext.create({
            xtype: "box",
            dock: "bottom",
            style: "padding: 2px; background-color: white;",
            html: Ext.String.format(this.elemSelec, 0)
        });
        me.vaciosFilter = Ext.create({
            xtype: "checkbox",
            boxLabel: "Vacios",
            style: "padding-left: 2px; background-color: white;",
            resumenMsg: "Viendo solo los vacios",
            listeners: {
                change: {
                    fn: function(el, newVal, oldVal, options) {
                        if (newVal) {
                            me.onCheckChange(el, ["cosa"], oldVal, options);
                        } else {
                            me.onCheckChange(el, [], oldVal, options);
                        }
                        me.checkCheckBoxes(el, newVal);
                    },
                    scope: me
                }
            }


        })
        me.noVaciosFilter = Ext.create({
            xtype: "checkbox",
            boxLabel: "No vacios",
            style: "padding-left: 2px; background-color: white;",
            resumenMsg: "Viendo solo los no vacios",
            listeners: {
                change: {
                    fn: function(el, newVal, oldVal, options) {
                        if (newVal) {
                            me.onCheckChange(el, ["cosa"], oldVal, options);
                        } else {
                            me.onCheckChange(el, [], oldVal, options);
                        }
                        me.checkCheckBoxes(el, newVal);
                    },
                    scope: me
                }
            }


        })
        me.multiselectFilter = Ext.create({
            xtype: "textfield",
            listeners: {
                change: {
                    scope: me,
                    fn: function(input, newVal, oldval, options) {
                        var me = this;
                        me.filterMultiSelect({
                            property: 'DISPLAY',
                            value: newVal,
                            anyMatch: true
                        });
                    }
                }
            },
            emptyText: At4FrameworkIntranet.At4FrameworkIntranet.prototype.filterText,
            minWidth: 150
        })
        var multiConfig = Ext.apply(this.multiConfigDefaults, {
            listeners: {
                change: function(el, newVal, oldVal, opts) {
                    me.resumenFilter.setHtml(Ext.String.format(this.elemSelec, newVal.length))
                    return me.onCheckChange(el, newVal, oldVal, opts);
                },
                scope: me
            },
            store: store,
        });
        me.multiselect = Ext.create(multiConfig);
        var activarCB = false;
        if (activarCB) {
            menu.addDocked(me.vaciosFilter);
            menu.addDocked(me.noVaciosFilter);
        }
        menu.addDocked(me.multiselectFilter);
        menu.addDocked(me.resumenFilter);
        menu.add(me.multiselect);
        me.store.load();

        /*
        this.menu = Ext.create("Ext.ux.form.MultiSelect", {
            store: me.store,
            floating: true
        })*/



        /*
                if (store) {
                    if (!store.getCount()) {
                        menu.add({
                            text: me.loadingText,
                            iconCls: Ext.baseCSSPrefix + 'mask-msg-text'
                        });

                        // Add a listener that will auto-load the menu store if `loadOnShow` is true (the default).
                        // Don't bother with mon here, the menu is destroyed when we are
                        menu.on('show', me.show, me);

                        store.on('load', me.bindMenuStore, me, {
                            single: true
                        });
                    } else {
                        me.createMenuItems(store);
                    }

                }
                // If there are supplied options, then we know the store is local.
                else if (options) {
                    me.bindMenuStore(options);
                }
                // A ListMenu which is completely unconfigured acquires its store from the unique values of its field in the store.
                // Note that the gridstore may have already been filtered on load if the column filter had been configured as active
                // with no items checked by default.
                else if (gridStore.getCount() || gridStore.data.filtered) {
                    me.bindMenuStore(gridStore);
                }
                // If there are no records in the grid store, then we know it's async and we need to listen for its 'load' event.
                else {
                    gridStore.on('load', me.bindMenuStore, me, {
                        single: true
                    });
                }*/
    },

    /** @private */
    createMenuItems: function(store) {
        console.log("MultilistFilter createMenuItems");
        return;
        var me = this,
            menu = me.menu,
            len = store.getCount(),
            contains = Ext.Array.contains,
            listeners, itemDefaults, record, gid, idValue, idField, labelValue, labelField, i, item, processed;

        // B/c we're listening to datachanged event, we need to make sure there's a menu.
        if (len && menu) {
            listeners = {
                checkchange: me.onCheckChange,
                scope: me
            };

            itemDefaults = me.getItemDefaults();
            menu.suspendLayouts();
            menu.removeAll(true);
            gid = me.single ? Ext.id() : null;
            idField = me.idField;
            labelField = me.labelField;

            processed = [];

            for (i = 0; i < len; i++) {
                record = store.getAt(i);
                idValue = record.get(idField);
                labelValue = record.get(labelField);

                // Only allow unique values.
                if (labelValue == null || contains(processed, idValue)) {
                    continue;
                }

                processed.push(labelValue);

                // Note that the menu items will be set checked in filter#activate() if the value of the menu
                // item is in the cfg.value array.
                item = menu.add(Ext.apply({
                    text: labelValue,
                    group: gid,
                    value: idValue,
                    listeners: listeners
                }, itemDefaults));
            }

            menu.resumeLayouts(true);
        }
    },

    getFilterConfig: function(config, key) {
        // List filter needs to have its value set immediately or else could will fail when filtering since its
        // _value would be undefined.
        config.value = config.value || [];
        return this.callParent([config, key]);
    },

    getOptionsFromStore: function(store) {
        var me = this,
            data = store.getData(),
            map = {},
            ret = [],
            dataIndex = me.dataIndex,
            labelIndex = me.labelIndex,
            items, i, length, recData, idValue, labelValue;

        if (store.isFiltered()) {
            data = data.getSource();
        }

        items = data.items;
        length = items.length;

        for (i = 0; i < length; ++i) {
            recData = items[i].data;

            idValue = recData[dataIndex];
            labelValue = recData[labelIndex];

            if (labelValue === undefined) {
                labelValue = idValue;
            }

            // TODO: allow null?
            //if ((allowNull || !Ext.isEmpty(value)) && !map[strValue1]) {
            if (!map[idValue]) {
                map[idValue] = 1;
                ret.push([idValue, labelValue]);
            }
        }

        return ret;
    },

    onCheckChange: function() {
        // Note that we don't care about the checked state here because #setValue will sort this out.
        // #setValue will get the values of the currently-checked items and set its filter value from that.
        var me = this,
            updateBuffer = me.updateBuffer;

        if (updateBuffer) {
            me.task.delay(updateBuffer, null, null);
        } else {
            me.setValue();
        }
    },

    onDataChanged: function(store) {
        // If the menu item options (and the options store) are being auto-generated from the grid store, then it
        // needs to know when the grid store has changed its data so it can remain in sync.
        if (!this.preventDefault) {
            this.bindMenuStore(store);
        }
    },

    setStoreFilter: function(options) {
        var me = this,
            value = me.value,
            filter = me.filter,
            contains, i, len, val, list;

        // If there are user-provided values we trust that they are valid (an empty array IS valid!).
        if (value) {
            if (!Ext.isArray(value)) {
                value = [value];
            }

            filter.setValue(value);
        }

        if (me.active) {
            me.preventFilterRemoval = true;
            me.addStoreFilter(filter);
            me.preventFilterRemoval = false;
        }
    },

    /**
     * @private
     * Template method that is to set the value of the filter.
     */
    setValue: function() {
        /*var me = this,
            //items = me.menu.items,
            items = me.multiselect.items,
            value = [],
            i, len, checkItem;

        // The store filter will be updated, but we don't want to recreate the list store or the menu items in the
        // onDataChanged listener so we need to set this flag.
        me.preventDefault = true;

        for (i = 0, len = items.length; i < len; i++) {
            checkItem = items.getAt(i);

            if (checkItem.checked) {
                value.push(checkItem.value);
            }
        }
*/
        var me = this;
        var value = me.multiselect.getValue();


        me.filter.setValue(value);
        len = value.length;

        if (len && me.active) {
            me.updateStoreFilter();
        } else {
            me.setActive(!!len);
        }

        me.preventDefault = false;
    },

    show: function() {
        var store = this.store;
        if (this.loadOnShow && !this.loaded && !store.hasPendingLoad()) {
            store.load();
        }
    },
    filterMultiSelect: function(filter) {
        var me = this;
        if (me.taskFilterMultiselect) {
            clearTimeout(me.taskFilterMultiselect);
        }
        me.taskFilterMultiselect = setTimeout(function() {
            var me = this;
            me.multiselect.store.filter([filter]);
            me.taskFilterMultiselect = null;
        }.bind(me), 500)

    },
    checkCheckBoxes: function(item, val) {
        var me = this;
        var items = [
            me.vaciosFilter,
            me.noVaciosFilter,
            me.multiselectFilter,
            me.multiselect
        ];
        var fn = {};
        if (val) {
            fn = function(subItem, index, array) {
                if (item == subItem) return;
                subItem.hide();
            }
            me.resumenFilter.setHtml(item.resumenMsg);
        } else {
            fn = function(subItem, index, array) {
                subItem.show();
            }
            me.resumenFilter.setHtml(Ext.String.format(this.elemSelec, 0));
        }
        Ext.each(items, fn);

    }
});
/**
 * @author Shea Frederick
 *
 * The GMap Panel UX extends `Ext.panel.Panel` in order to display Google Maps.
 *
 * It is important to note that you must include the following Google Maps API above bootstrap.js in your 
 * application's index.html file (or equivilant).
 *
 *     <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3&sensor=false"></script>
 *
 * It is important to note that due to the Google Maps loader, you cannot currently include
 * the above JS resource in the Cmd generated app.json file.  Doing so interferes with the loading of
 * Ext JS and Google Maps. 
 *
 * The following example creates a window containing a GMap Panel.  In this case, the center 
 * is set as geoCodeAddr, which is a string that Google translates into longitude and latitude.
 * 
 *     var mapwin = Ext.create('Ext.Window', {
 *         layout: 'fit',
 *         title: 'GMap Window',
 *         width: 450,
 *         height: 250,
 *         items: {
 *             xtype: 'gmappanel',
 *             gmapType: 'map',
 *             center: {
 *                 geoCodeAddr: "221B Baker Street",
 *                 marker: {
 *                     title: 'Holmes Home'
 *                 }
 *             },
 *             mapOptions : {
 *                 mapTypeId: google.maps.MapTypeId.ROADMAP
 *             }
 *         }
 *     }).show();
 * 
 */
Ext.define('Ext.ux.GMapPanel', {
    extend: 'Ext.panel.Panel',
    
    alias: 'widget.gmappanel',
    
    requires: ['Ext.window.MessageBox'],
    
    initComponent : function(){
        Ext.applyIf(this,{
            plain: true,
            gmapType: 'map',
            border: false
        });
        
        this.callParent();        
    },
    
    onBoxReady : function(){
        var center = this.center;
        this.callParent(arguments);       
        
        if (center) {
            if (center.geoCodeAddr) {
                this.lookupCode(center.geoCodeAddr, center.marker);
            } else {
                this.createMap(center);
            }
        } else {
            Ext.Error.raise('center is required');
        }
              
    },
    
    createMap: function(center, marker) {
        var options = Ext.apply({}, this.mapOptions);
        
        options = Ext.applyIf(options, {
            zoom: 14,
            center: center,
            mapTypeId: google.maps.MapTypeId.HYBRID
        });
        this.gmap = new google.maps.Map(this.body.dom, options);
        if (marker) {
            this.addMarker(Ext.applyIf(marker, {
                position: center
            }));
        }
        
        Ext.each(this.markers, this.addMarker, this);
        this.fireEvent('mapready', this, this.gmap);
    },
    
    addMarker: function(marker) {
        marker = Ext.apply({
            map: this.gmap
        }, marker);
        
        if (!marker.position) {
            marker.position = new google.maps.LatLng(marker.lat, marker.lng);
        }
        var o =  new google.maps.Marker(marker);
        Ext.Object.each(marker.listeners, function(name, fn){
            google.maps.event.addListener(o, name, fn);    
        });
        return o;
    },
    
    lookupCode : function(addr, marker) {
        this.geocoder = new google.maps.Geocoder();
        this.geocoder.geocode({
            address: addr
        }, Ext.Function.bind(this.onLookupComplete, this, [marker], true));
    },
    
    onLookupComplete: function(data, response, marker){
        if (response != 'OK') {
            Ext.MessageBox.alert('Error', 'An error occured: "' + response + '"');
            return;
        }
        this.createMap(data[0].geometry.location, marker);
    },
    
    afterComponentLayout : function(w, h){
        this.callParent(arguments);
        this.redraw();
    },
    
    redraw: function(){
        var map = this.gmap;
        if (map) {
            google.maps.event.trigger(map, 'resize');
        }
    }
 
});
Ext.define("At4FrameworkIntranet.BaseGMapField", {
	extend: "Ext.form.FieldContainer",
	mixins: [
		'Ext.form.Labelable',
		'Ext.form.field.Field'
	],
	width: "100%",
	height: 650,
	layout: 'vbox',

	gmapsReady: false,
	isEditing: false,
	name: "at4mapfield",
	fieldLabel: "at4mapfield",
	labelAlign: "top",
	markerIcon: "ext5/uxAt4/gmapsfield/img/pinxito.png",

	showEditButton: false,
	showHelpButton: false,
	showCancelButton: false,

	valueCache: null,


	constructor: function (options) {
		var me = this;
		window.test = me;
		Ext.apply(this, options);
		this.callParent();
		var panelSuperior = false;
		if (me.showEditButton) {
			panelSuperior = true;
			me.button = new Ext.button.Button({
				xtype: "button",
				text: me.editPolytxt,
				btnID: "edit",
				listeners: {
					click: {
						fn: me.buttonHandler,
						scope: me
					}
				}
			});
		}
		if (me.showCancelButton) {
			panelSuperior = true;
			me.cancelButton = new Ext.button.Button({
				xtype: "button",
				btnID: "cancel",
				text: me.cancelButtonTxt,
				listeners: {
					click: {
						fn: me.cancelButtonHandler,
						scope: me
					}
				}
			});
		}


		if (me.showHelpButton) {
			panelSuperior = true;
			me.helpButton = new Ext.button.Button({
				xtype: "button",
				text: me.buttonHelpTxt,
				margin: "0 0 0 20",
				btnID: "help",
				listeners: {
					click: {
						fn: me.buttonHelpHandler,
						scope: me
					}
				}
			});
		}

		me.map = Ext.create('Ext.panel.Panel', {
			closeAction: "hide",
			//title: 'GMap Window',
			layout: 'fit',
			//region:'center',
			width: me.width,
			height: me.height - 60,
			items: {
				xtype: 'gmappanel',
				gmapType: 'map',
				border: true,

				center: {
					lat: 39.570718,
					lng: 2.650641
				},
				mapOptions: {
					//disableDefaultUI: true,
					streetViewControl: false,
					mapTypeId: google.maps.MapTypeId.ROADMAP,
					styles: [{
						"featureType": "poi",
						"elementType": "labels.text",
						"stylers": [{
							"visibility": "off"
						}]
					}, {
						"elementType": "labels.icon",
						"stylers": [{
							"visibility": "off"
						}]
					}]
				},
				listeners: {
					"mapready": {
						fn: function (extjsOBJ, gmapsOBJ) {
							me.gmaps = gmapsOBJ;
							me.gmapsReady = true;
							me.onMapReady();
						}
					}
				}
			}
		});
		if (panelSuperior) {
			me.panelSuperior = new Ext.panel.Panel({
				height: 35,
				defaults: {
					margin: "0 5px 0px 5px"
				},
				margin: "7px 0px 7px 0px",
				//region:'west',
				//items: [me.btGuardarPol, me.btEditarPol, me.btTest]
				items: [me.button, me.helpButton, me.cancelButton]

			});
			me.items.add(me.panelSuperior);
		}
		me.items.add(me.map);
		me.border = true;
		me.addCls("at4-gmapField");
	},
	onMapClick: function (event) {
		var me = this;
		if (!me.isEditing) {
			return;
		}
		var lat = event.latLng.lat();
		var lng = event.latLng.lng();
		var latLng = new google.maps.LatLng(lat, lng);
		me.addMarker(latLng);
	},

	onMapReady: function () {
		var me = this;
		if (me.valueCache) {
			me.mapReadySetValue(me.valueCache);
		}
		me.gmaps.addListener('click', function (ev) {
			me.onMapClick(ev);
		});
	},

	getValue: function () {
		console.log("getValue");
		console.warn("Not implemented yet");
		return "Not implemented";
	},
	getSubmitData: function () {
		console.log("getSubmitData");
		console.warn("Not implemented yet");
		return "Not implemented";
	},
	setValue: function (val) {
		var me = this;
		if (me.gmapsReady) {
			me.mapReadySetValue(val);
		} else {
			me.valueCache = val;
		}
	},
	mapReadySetValue: function (val) {
		console.log(val);
		console.log("setValue");
		console.warn("Not implemented yet");
	},
	centerMap: function (val1, val2) {
		var me = this;
		var latLng;
		if (typeof (val1) == "object") {
			latLng = val1;
		} else {
			var lat = val1,
				lng = val2;
			latLng = new google.maps.LatLng(lat, lng)
		}
		me.gmaps.setCenter(latLng);
	}

});
if (typeof google !== "undefined") {
	google.maps.Polygon.prototype.my_getBounds = function () {
		var bounds = new google.maps.LatLngBounds()
		this.getPath().forEach(function (element, index) {
			bounds.extend(element)
		})
		return bounds
	}
}
Ext.define("At4FrameworkIntranet.PointGMapField", {
	extend: "At4FrameworkIntranet.BaseGMapField",
	xtype: "At4PointGMapField",

	showEditButton: false,
	showHelpButton: false,
	isEditing: true,

	marker: null,

	addMarker: function(myLatLng) {
		var me = this;
		if (me.marker) {
			me.marker.setMap(null);
		}
		me.marker = new google.maps.Marker({
			position: myLatLng,
			title: '#Localizacion',
			icon: me.markerIcon,
			map: me.gmaps
		});
	},


	getValue: function() {
		var me = this;
		if (!me.marker) {
			return null;
		}
		var position = me.marker.getPosition();
		var data = {
			y: position.lat(),
			x: position.lng()
		};
		return JSON.stringify(data);
	},
	getSubmitData: function() {
		var me = this;
		var data = {};
		data[me.name] = me.getValue();
		return data;
	},
});
Ext.define("At4FrameworkIntranet.PolyGMapField", {
	extend: "At4FrameworkIntranet.BaseGMapField",
	xtype: "At4PolyGMapField",

	//locale
	editPolytxt: "Redibujar",
	savePolytxt: "Aceptar",
	buttonHelpTxt: "Ayuda",
	cancelButtonTxt: "Cancelar",
	helpWindowTitle: "Ayuda: Editor de poligonos sobre mapa",
	helpHtml: "<div>Test</div>",
	//end locale

	showEditButton: true,
	showHelpButton: false,
	showCancelButton: true,

	constructor: function(options) {
		var me = this;
		Ext.apply(this, options);
		this.callParent();
		me.cancelButton.hide();
		me.store = new Ext.data.SimpleStore({
			fields: ['id', 'lat', 'lng'],
		});
		me.coords = [];
		me.markers = [];
	},

	buttonHandler: function(btn) {
		var me = this;
		if (btn.btnID == "edit") {
			if (me.isEditing) {
				me.isEditing = false;
				me.map.mask();
				me.button.setText(me.editPolytxt);
				return me.guardarPolHandler(btn);
			} else {
				me.isEditing = true;
				me.map.unmask();
				me.button.setText(me.savePolytxt);
				return me.editarPolHandler(btn);
			}
		} else {
			me.isEditing = false;
			me.map.mask();
			me.button.setText(me.editPolytxt);
			me.cancelButton.hide();
			me.showPoly();
		}


	},

	editarPolHandler: function(btn) {
		var me = this;
		me.cancelButton.show();
		if (me.polygon) {
			me.polygon.setMap(null);
		}
		me.store.clearData();
		return;
		/*
		//Este codigo repinta los datos
		me.store.each(function(item) {
			var myLatLng = new google.maps.LatLng({
				lat: item.get("lat"),
				lng: item.get("lng")
			});
			me.addMarker(myLatLng);
		})
		*/
	},

	cancelButtonHandler: function(btn) {
		var me = this;
		me.buttonHandler(btn);
	},

	showPoly: function() {
		var me = this;
		me.poly.getPath().clear();
		Ext.each(me.markers, function(obj) {
			obj.setMap(null);
		});
		if (me.polygon) {
			me.polygon.setMap(null);
		}
		me.polygon = new google.maps.Polygon({
			paths: me.coords,
			strokeColor: '#FF0000',
			strokeOpacity: 0.5,
			strokeWeight: 3,
			fillColor: '#FF0000',
			fillOpacity: 0.15
		});
		me.polygon.setMap(me.gmaps);

		var bounds = me.polygon.my_getBounds();
		me.gmaps.fitBounds(bounds);
		me.centerMap(bounds.getCenter());

	},

	buttonHelpHandler: function() {
		var me = this;
		Ext.create('Ext.window.Window', {
			title: me.helpWindowTitle,
			closeAction: "destroy",
			height: 200,
			width: 400,
			html: me.helpHtml
		}).show();
	},

	guardarPolHandler: function() {
		var me = this;
		me.cancelButton.hide();
		//marker.setMap(null);
		//me.poly.setMap(null);
		me.coords = [];
		me.store.each(function(obj) {
			coord = {
				lat: obj.get("lat"),
				lng: obj.get("lng")
			};
			me.coords.push(coord);
		});
		me.showPoly();
	},

	onMapReady: function() {
		this.callParent();
		var me = this;
		me.poly = new google.maps.Polyline({
			strokeColor: '#000000',
			strokeOpacity: 1.0,
			strokeWeight: 3
		});
		me.poly.setMap(me.gmaps);
	},


	addMarker: function(latLng) {
		var me = this;
		me.saveMark(latLng);
		var path = me.poly.getPath();
		path.push(latLng);
		var marker = new google.maps.Marker({
			position: latLng,
			title: '#' + path.getLength() + latLng.lat() + ":" + latLng.lng(),
			icon: me.markerIcon,
			map: me.gmaps
		});
		marker.addListener('click', function(ev) {
			me.onMarkerClick(ev, marker);
		});
		me.markers.push(marker);
	},
	saveMark: function(latLng) {
		var me = this;
		var lat = latLng.lat();
		var lng = latLng.lng();
		var id = lat + ":" + lng;
		if (me.store.getById(id)) return;
		me.store.add({
			lat: lat,
			lng: lng,
			id: id
		});
	},

	onMarkerClick: function(event, marker) {
		var me = this;
		me.poly.getPath().forEach(function(el, index) {
			if (el == event.latLng) {
				me.poly.getPath().removeAt(index);
				marker.setMap(null);
				me.store.removeAt(index, 1);
			}
		});
		console.log(arguments);
	},
	getValue: function() {
		var me = this;
		/*var datos = [];
		me.store.each(function(obj) {
			var coord = {
				y: obj.get("lat"),
				x: obj.get("lng")
			};
			datos.push(coord);
		});
		return datos;*/
		return me.coords;
	},
	getSubmitData: function() {
		var me = this;
		var data = {};
		data[me.name] = JSON.stringify(me.getValue());
		return data;
	},
	mapReadySetValue: function(val) {
		var me = this;
		if (!val || !val.points) {
			console.warn("El formato de los datos recibidos es erroneo");
			return;
		}
		var points = val.points;
		var bounds = new google.maps.LatLngBounds();
		Ext.each(points, function(point) {
			var lat = point.y;
			var lng = point.x;
			var coord = {
				lat: lat,
				lng: lng
			};
			me.coords.push(coord);
		})
		me.showPoly();
		me.map.mask();

	}



});
Ext.define("At4FrameworkIntranet.ZonaPointGMapField", {
	extend: "At4FrameworkIntranet.PointGMapField",
	xtype: "At4ZonaPointGMapField",

	//locale
	editPolytxt: "Editar",
	savePolytxt: "Aceptar",
	buttonHelpTxt: "Ayuda",
	helpWindowTitle: "Ayuda: Selector de ubicacion sobre mapa",
	helpHtml: "<div>Test</div>",
	//end locale

	showEditButton: true,
	showHelpButton: false,
	isEditing: false,

	constructor: function() {
		this.callParent(arguments);
		var me = this;
		me.zonas = [];

	},
	disable: function(){
		var me = this;
		me.disabled = true;
		me.button.disable();
	},
	enable: function(){
		var me = this;
		me.disabled = false;
		me.button.enable();
	},

	buttonHandler: function(btn) {
		var me = this;
		if (me.isEditing) {
			return me.stopEdit(btn);
		} else {
			btn.setText(me.savePolytxt);
			return me.startEdit(btn);
		}
	},

	onMapReady: function() {
		this.callParent();
		var me = this;
		me.map.mask();
	},
	mostrarZonas: function() {
		var me = this;
		me.store.each(function(item) {
			console.log(item);
		});
	},
	mapReadySetValue: function(val) {
		var me = this;
		if (val && val.x && val.y) {
			var myLatLng = new google.maps.LatLng({
				lat: val.y,
				lng: val.x
			});
			me.centerMap(myLatLng);
			me.addMarker(myLatLng);
		}else{
			if(me.marker){
				me.marker.setMap(null);
				me.marker = null;
			}
		}
	},

	startEdit: function() {
		var me = this;
		me.isEditing = true;
		me.button.setText(me.savePolytxt);
		me.map.unmask();
	},
	stopEdit: function() {
		var me = this;
		me.isEditing = false;
		me.button.setText(me.editPolytxt);
		me.map.mask();
		if(me.marker){
			me.centerMap(me.marker.getPosition());
		}
	},

	setValue: function(){
		this.stopEdit();
		return this.callParent(arguments);
	},

	getValue:function(){
		this.stopEdit();
		return this.callParent();
	}
	/*
	ocultarZonas: function() {

},

createaStore: function() {
var me = this;
var modelName = "At4FrameworkIntranet.zonasPointModel-" + me.name;
var model = "";
var campos = [{
name: "ID"
}, {
name: "DISPLAY"
}];
if (Ext.ClassManager.isCreated(modelName)) {
model = Ext.ClassManager.get(modelName);
} else {
model = Ext.define(modelName, {
extend: 'Ext.data.Model',
fields: campos,
proxy: {
type: "dwr",
dwrFunction: FormDataService.devolverZonasPoly,
reader: {
type: "json",
totalProperty: "totalNumRecords",
rootProperty: "resultados",
model: modelName
},
//dwrParams: [formName, fieldName],
listeners: {
'beforeload': function(dataProxy, config) {
var params = config.params ? config.params : [];
},
'loadexception': function(dataProxy, message, loadCallback, exception) {
Ext.Msg.alert('Error:', message);
}
}
}
});
}
var store = Ext.create("Ext.data.Store", {
model: model
});
return store;
}
*/

});
// Add style for "null"-value dynamically
/*
var sStyle = '.x-checkbox-null input {\n';
sStyle += '-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";\n';
sStyle += 'filter:progid:DXImageTransform.Microsoft.Alpha(Opacity=50);\n';
sStyle += 'opacity:.5;}';
Ext.util.CSS.createStyleSheet(sStyle, 'Ext.ux.form.TriCheckbox');
*/
// Define class Ext.ux.form.TriCheckbox
//Codigo extraido de:
//https://www.sencha.com/forum/showthread.php?138664-Ext.ux.form.TriCheckbox&p=619810
Ext.define('Ext.ux.form.TriCheckbox', {
    extend: 'Ext.form.field.Checkbox',
    alias: ['widget.xtricheckbox', "widget.tri-checkbox"],

    triState: true, // triState can dynamically be disabled using enableTriState

    cls: "triStateCBX",
    values: ['desconocido', '1', '0'], // The values which are toggled through
    checkedClasses: ['x-checkbox-null', Ext.baseCSSPrefix + 'form-cb-checked', ''], // The classes used for the different states

    currentCheck: 0, // internal use: which state we are in?

    value: "desconocido",

    getSubmitValue: function() {
        return this.value;
    },

    getRawValue: function() {
        return this.value;
    },

    getValue: function() {
        return this.value;
    },

    initValue: function() {
        var me = this;
        me.originalValue = me.lastValue = me.value;
        me.suspendCheckChange++;
        me.setValue(me.value);
        me.suspendCheckChange--;
    },

    setRawValue: function(v) {
        var me = this;

        if (v === false) v = '0';
        if (v === true) v = '1';
        if (v == null || v == '' || v === undefined) {
            if (!this.triState) {
                v = '0';
            } else {
                v = 'desconocido';
            }
        }

        me.oldCheck = me.currentCheck;
        me.currentCheck = me.getCheckIndex(v);
        me.value = me.rawValue = me.values[me.currentCheck];
    },

    setValue: function(){
        var me = this;
        me.callParent(arguments)
        // Update classes
        var inputEl = me.inputEl;
        if (inputEl) {
            inputEl.dom.setAttribute('aria-checked', me.value == '1' ? true : false);
            me['removeCls'](me.checkedClasses[me.oldCheck])
            me['addCls'](me.checkedClasses[me.currentCheck]);
        }else{
            me.addCls(me.checkedClasses[me.currentCheck]);
        }
    },

    // Returns the index from a value to a member of me.values 
    getCheckIndex: function(value) {
        for (var i = 0; i < this.values.length; i++) {
            if (value === this.values[i]) {
                return i;
            }
        }
        return 0;
    },

    // Handels a click on the checkbox
    onBoxClick: function(e) {
        this.toggle();
    },

    // Switches to the next checkbox-state
    toggle: function() {
        var me = this;
        if (!me.disabled && !me.readOnly) {
            var check = me.currentCheck;
            check++;
            if (check >= me.values.length) check = 0;
            this.setValue(me.values[check]);
        }
    },

    // Enables/Disables tristate-handling at runtime (enableTriState(false) gives a 'normal' checkbox)
    enableTriState: function(bTriState) {
        if (bTriState == undefined) bTriState = true;
        this.triState = bTriState;
        if (!this.triState) {
            this.setValue(this.value);
        }
    },

    // Toggles tristate-handling ar runtime
    toggleTriState: function() {
        this.enableTriState(!this.triState);
    }
});
Ext.define("At4FrameworkIntranet.FilterItemSelector", {
    extend: "Ext.form.FieldContainer",
    mixins: [
        //"Ext.form.Labelable",
        "Ext.form.field.Field"
    ],

    layout: "vbox",
    // margin: 0,
    padding: 0,

    constructor: function(cfg){
        this.fieldLabel = cfg.fieldLabel;
        this.hidden = cfg.hidden;
        delete cfg.hidden;
        delete cfg.fieldLabel;
        if(!cfg.listeners){
            cfg.listeners = {};
        }
        cfg.listeners.resize = {
            scope: this,
            fn: function(el, width, height, oldWidth, oldHeight, opts){
                if(height<oldHeight){
                    //console.log("aaay");
                    el.setHeight(oldHeight)
                    //return false;
                }
            }
        }
        this.selectorInput = Ext.create("At4FrameworkIntranet.ItemSelector", cfg);
        this.filterInput = Ext.create({
            xtype: "textfield",
            width: 200,
            emptyText: "Filtrar...",
            tabIndex: -1,
            enableKeyEvents: true,
            width: At4FrameworkIntranet.FormDefaults.HALF_TEXT_FIELD_WIDTH,
            listeners: {
                change:{
                    scope: this,
                    fn: function(input, newval, oldval){
                        if(newval){
                            var filter = {
                                property: "DISPLAY",
                                id: "searchFilter",
                                operator: "like",
                                type: "string",
                                value: newval
                            };
                            this.selectorInput.fromStore.remoteFilter = false;
                            // this.selectorInput.fromStore.addFilter(filter);
                            // this.selectorInput.fromStore.fireEvent("load", this.selectorInput.fromStore)
                            this.selectorInput.fromField.store.addFilter(filter)
                        }else{
                            this.selectorInput.fromField.store.clearFilter();
                        }
                    }
                },
                keypress: {
                    scope: this,
                    fn: function(el, ev, eopts){
                        // console.log(arguments);
                        if(ev.keyCode == 13){
                            // console.log("buscar");
                            var value = this.selectorInput.fromField.store.getRange();
                            this.selectorInput.moveRec(true, value);
                            el.blur();
                            el.setValue("");
                            // this.selectorInput.setValue(value);
                        }
                    }
                }
            }
        });
        var primercont = this.filterInput;
        if(cfg.extraFilter){
            cfg.extraFilter.margin = "0 0 0 15";
            primercont =
                {
                    xtype: "container",
                    layout: "hbox",
                    margin: "2 0 7 0",
                    items: [this.filterInput, cfg.extraFilter]
                };
        }
        this.items = [primercont, this.selectorInput];
        this.callParent();
        // window.test = this;
    },
    setValue: function(value){
        this.selectorInput.setValue(value);
    },
    getValue: function(){
        return this.selectorInput.getValue();
    }

})
/**
 * Barebones iframe implementation. 
 */
Ext.define('Ext.ux.IFrame', {
    extend: 'Ext.Component',

    alias: 'widget.uxiframe',

    loadMask: 'Loading...',

    src: 'about:blank',

    renderTpl: [
        '<iframe src="{src}" id="{id}-iframeEl" data-ref="iframeEl" name="{frameName}" width="100%" height="100%" frameborder="0"></iframe>'
    ],
    childEls: ['iframeEl'],

    initComponent: function () {
        this.callParent();

        this.frameName = this.frameName || this.id + '-frame';
    },

    initEvents : function() {
        var me = this;
        me.callParent();
        me.iframeEl.on('load', me.onLoad, me);
    },

    initRenderData: function() {
        return Ext.apply(this.callParent(), {
            src: this.src,
            frameName: this.frameName
        });
    },

    getBody: function() {
        var doc = this.getDoc();
        return doc.body || doc.documentElement;
    },

    getDoc: function() {
        try {
            return this.getWin().document;
        } catch (ex) {
            return null;
        }
    },

    getWin: function() {
        var me = this,
            name = me.frameName,
            win = Ext.isIE
                ? me.iframeEl.dom.contentWindow
                : window.frames[name];
        return win;
    },

    getFrame: function() {
        var me = this;
        return me.iframeEl.dom;
    },

    beforeDestroy: function () {
        this.cleanupListeners(true);
        this.callParent();
    },
    
    cleanupListeners: function(destroying){
        var doc, prop;

        if (this.rendered) {
            try {
                doc = this.getDoc();
                if (doc) {
                    Ext.get(doc).un(this._docListeners);
                    if (destroying) {
                        for (prop in doc) {
                            if (doc.hasOwnProperty && doc.hasOwnProperty(prop)) {
                                delete doc[prop];
                            }
                        }
                    }
                }
            } catch(e) { }
        }
    },

    onLoad: function() {
        var me = this,
            doc = me.getDoc(),
            fn = me.onRelayedEvent;

        if (doc) {
            try {
                // These events need to be relayed from the inner document (where they stop
                // bubbling) up to the outer document. This has to be done at the DOM level so
                // the event reaches listeners on elements like the document body. The effected
                // mechanisms that depend on this bubbling behavior are listed to the right
                // of the event.
                Ext.get(doc).on(
                    me._docListeners = {
                        mousedown: fn, // menu dismisal (MenuManager) and Window onMouseDown (toFront)
                        mousemove: fn, // window resize drag detection
                        mouseup: fn,   // window resize termination
                        click: fn,     // not sure, but just to be safe
                        dblclick: fn,  // not sure again
                        scope: me
                    }
                );
            } catch(e) {
                // cannot do this xss
            }

            // We need to be sure we remove all our events from the iframe on unload or we're going to LEAK!
            Ext.get(this.getWin()).on('beforeunload', me.cleanupListeners, me);

            this.el.unmask();
            this.fireEvent('load', this);

        } else if (me.src) {

            this.el.unmask();
            this.fireEvent('error', this);
        }


    },

    onRelayedEvent: function (event) {
        // relay event from the iframe's document to the document that owns the iframe...

        var iframeEl = this.iframeEl,

            // Get the left-based iframe position
            iframeXY = iframeEl.getTrueXY(),
            originalEventXY = event.getXY(),

            // Get the left-based XY position.
            // This is because the consumer of the injected event will
            // perform its own RTL normalization.
            eventXY = event.getTrueXY();

        // the event from the inner document has XY relative to that document's origin,
        // so adjust it to use the origin of the iframe in the outer document:
        event.xy = [iframeXY[0] + eventXY[0], iframeXY[1] + eventXY[1]];

        event.injectEvent(iframeEl); // blame the iframe for the event...

        event.xy = originalEventXY; // restore the original XY (just for safety)
    },

    load: function (src) {
        var me = this,
            text = me.loadMask,
            frame = me.getFrame();

        if (me.fireEvent('beforeload', me, src) !== false) {
            if (text && me.el) {
                me.el.mask(text);
            }

            frame.src = me.src = (src || me.src);
        }
    }
});

/*
 * TODO items:
 *
 * Iframe should clean up any Ext.dom.Element wrappers around its window, document
 * documentElement and body when it is destroyed.  This helps prevent "Permission Denied"
 * errors in IE when Ext.dom.GarbageCollector tries to access those objects on an orphaned
 * iframe.  Permission Denied errors can occur in one of the following 2 scenarios:
 *
 *     a. When an iframe is removed from the document, and all references to it have been
 *     removed, IE will "clear" the window object.  At this point the window object becomes
 *     completely inaccessible - accessing any of its properties results in a "Permission
 *     Denied" error. http://msdn.microsoft.com/en-us/library/ie/hh180174(v=vs.85).aspx
 *
 *     b. When an iframe is unloaded (either by navigating to a new url, or via document.open/
 *     document.write, new html and body elements are created and the old the html and body
 *     elements are orphaned.  Accessing the html and body elements or any of their properties
 *     results in a "Permission Denied" error.
 */


//Ext.ux.Image = Ext.extend(Ext.Component, {

Ext.define("Ext.ux.Image", {
    extend: "Ext.Component",
    autoEl: {
        tag: 'img',
        src: Ext.BLANK_IMAGE_URL,
        cls: 'tng-managed-image'
    },

    //  Add our custom processing to the onRender phase.
    //  We add a ‘load’ listener to our element.
    onRender: function() {
        Ext.ux.Image.superclass.onRender.apply(this, arguments);
        this.el.on('load', this.onLoad, this);
        if (this.url) {
            this.setSrc(this.url);
        }
    },

    onLoad: function() {
        this.fireEvent('load', this);
    },

    setSrc: function(src) {
        if (this.rendered) {
            this.el.dom.src = src;
        } else {
            this.url = src;
        }
    }
});

//Ext.reg('image', 'Ext.ux.Image');
/**
 * Ext.ux.grid.PageSize
 * http://www.elvishsu66.com/2011/05/pagesize-plugin-for-paging-toolbar-for.html#.VaeVqFXtlBc
 */
Ext.define('Ext.ux.grid.PageSize', {
    extend: 'Ext.form.field.ComboBox',
    alias: 'plugin.pagesize',
    beforeText  : 'Show',
    afterText   : 'rows/page',
    mode: 'local',
    displayField: 'text',
    valueField: 'value',
    allowBlank: false,
    triggerAction: 'all',
    width: 65,
    editable: false,
    maskRe: /[0-9]/,


    /**
     * initialize the paging combo after the pagebar is randered
     */
    init: function(paging) {
        paging.on('afterrender', this.onInitView, this);
    },
    /**
     * create a local store for availabe range of pages
     */
    store: new Ext.data.SimpleStore({
        fields: ['text', 'value'],
        // data: [['5', 5], ['10', 10], ['15', 15], ['20', 20], ['25', 25], ['50', 50], ['100', 100], ['200', 200], ['500', 500]]
        data: [
            ['10', 10],
            ['20', 20],
            ['30', 30],
            ['50', 50],
            ['100', 100],
            ['500', 500],
            ['1000', 1000]
        ]
    }),
    /**
     * assing the select and specialkey events for the combobox
     * after the pagebar is rendered.
     */
    onInitView: function(paging) {
        this.setValue(paging.store.pageSize);
        paging.add('-', this.beforeText, this, this.afterText);
        this.on('select', this.onPageSizeChanged, paging);
        this.on('specialkey', function(combo, e) {
            if (13 === e.getKey()) {
                this.onPageSizeChanged.call(paging, this);
            }
        });
    },
    /**
     * refresh the page when the value is changed
     */
    onPageSizeChanged: function(combo) {
        this.store.pageSize = parseInt(combo.getRawValue(), 10);
        this.store.currentPage = 1;
        this.doRefresh();
    }
});
/**
 * Copyright(c) 2012 André Fiedler, <https://twitter.com/sonnenkiste>
 *
 * license: MIT-style license
 */

Ext.define('Ext.ux.panel.PDF',{
    extend: 'Ext.panel.Panel',

    alias: 'widget.pdfpanel',

    extraBaseCls: Ext.baseCSSPrefix + 'pdf',
    extraBodyCls: Ext.baseCSSPrefix + 'pdf-body',

    autoScroll: true,

    xtype: "uxPanelPdf",

    /**
     * @cfg{String} src
     * URL to the PDF - Same Domain or Server with CORS Support
     */
    src: '',

    /**
     * @cfg{Double} pageScale
     * Initial scaling of the PDF. 1 = 100%
     */
    pageScale: 1,

    /**
     * @cfg{Boolean} disableWorker
     * Disable workers to avoid yet another cross-origin issue(workers need the URL of
     * the script to be loaded, and currently do not allow cross-origin scripts)
     */
    disableWorker: true,

    /**
     * @cfg{Boolean} disableTextLayer
     * Enable to render selectable but hidden text layer on top of an PDF-Page.
     * This feature is buggy by now and needs more investigation!
     */
    disableTextLayer: true, // true by now, cause it´s buggy
    
    /**
     * @cfg{String} loadingMessage
     * The text displayed when loading the PDF.
     */
    loadingMessage: 'Loading PDF, please wait...',
    
    /**
     * @cfg{String} beforePageText
     * The text displayed before the input item.
     */
    beforePageText: 'Page',
    
    /**
     * @cfg{String} afterPageText
     * Customizable piece of the default paging text. Note that this string is formatted using
     *{0} as a token that is replaced by the number of total pages. This token should be preserved when overriding this
     * string if showing the total page count is desired.
     */
    afterPageText: 'of {0}',
    
    /**
     * @cfg{String} firstText
     * The quicktip text displayed for the first page button.
     * **Note**: quick tips must be initialized for the quicktip to show.
     */
    firstText: 'First Page',
    
    /**
     * @cfg{String} prevText
     * The quicktip text displayed for the previous page button.
     * **Note**: quick tips must be initialized for the quicktip to show.
     */
    prevText: 'Previous Page',
    
    /**
     * @cfg{String} nextText
     * The quicktip text displayed for the next page button.
     * **Note**: quick tips must be initialized for the quicktip to show.
     */
    nextText: 'Next Page',
    
    /**
     * @cfg{String} lastText
     * The quicktip text displayed for the last page button.
     * **Note**: quick tips must be initialized for the quicktip to show.
     */
    lastText: 'Last Page',
    
    /**
     * @cfg{Number} inputItemWidth
     * The width in pixels of the input field used to display and change the current page number.
     */
    inputItemWidth: 30,
    
    /**
     * @cfg{Number} inputItemWidth
     * The width in pixels of the combobox used to change display scale of the PDF.
     */
    scaleWidth: 60,

    getPagingItems: function(){
        var me = this;

        return [{
            itemId: 'first',
            tooltip: me.firstText,
            overflowText: me.firstText,
            iconCls: Ext.baseCSSPrefix + 'tbar-page-first',
            disabled: true,
            handler: me.moveFirst,
            scope: me
        },
        {
            itemId: 'prev',
            tooltip: me.prevText,
            overflowText: me.prevText,
            iconCls: Ext.baseCSSPrefix + 'tbar-page-prev',
            disabled: true,
            handler: me.movePrevious,
            scope: me
        },
        '-',
        me.beforePageText,
        {
            xtype: 'numberfield',
            itemId: 'inputItem',
            name: 'inputItem',
            cls: Ext.baseCSSPrefix + 'tbar-page-number',
            allowDecimals: false,
            minValue: 1,
            hideTrigger: true,
            enableKeyEvents: true,
            keyNavEnabled: false,
            selectOnFocus: true,
            submitValue: false,
            // mark it as not a field so the form will not catch it when getting fields
            isFormField: false,
            width: me.inputItemWidth,
            margins: '-1 2 3 2',
            disabled: true,
            listeners: {
                scope: me,
                keydown: me.onPagingKeyDown,
                blur: me.onPagingBlur
            }
        },
        {
            xtype: 'tbtext',
            itemId: 'afterTextItem',
            text: Ext.String.format(me.afterPageText, 1),
            margins: '0 5 0 0'
        },
        '-',
        {
            itemId: 'next',
            tooltip: me.nextText,
            overflowText: me.nextText,
            iconCls: Ext.baseCSSPrefix + 'tbar-page-next',
            disabled: true,
            handler: me.moveNext,
            scope: me
        },
        {
            itemId: 'last',
            tooltip: me.lastText,
            overflowText: me.lastText,
            iconCls: Ext.baseCSSPrefix + 'tbar-page-last',
            disabled: true,
            handler: me.moveLast,
            scope: me
        },
        '->',
        {
            itemId: 'scaleCombo',
            xtype: 'combobox',
            editable: false,
            keyNavEnabled: true,
            selectOnFocus: false,
            submitValue: false,
            // mark it as not a field so the form will not catch it when getting fields
            isFormField: false,
            autoSelect: true,
            disabled: true,
            width: me.scaleWidth,
            store: new Ext.data.SimpleStore({
                id: 0,
                fields: ['scale', 'text'],
                data: [
                    [0.5, '50%'],
                    [0.75, '75%'],
                    [1, '100%'],
                    [1.25, '125%'],
                    [1.5, '150%'],
                    [2, '200%']
                ]
            }),
            valueField: 'scale',
            displayField: 'text',
            mode: 'local',
            listeners: {
                scope: me,
                change: me.onScaleChange,
                blur: me.onScaleBlur
            }
        }];
    },

    initComponent: function(){
        var me = this,
            pagingItems = me.getPagingItems(),
            userItems = me.items || [],
            userDockedItems = me.dockedItems || [];

        me.bodyCls = me.bodyCls || '';
        me.bodyCls += (' ' + me.extraBodyCls);

        me.cls = me.cls || '';
        me.cls += (' ' + me.extraBaseCls);

        PDFJS.disableTextLayer = me.disableTextLayer;

        userDockedItems.push({
            itemId: 'pagingToolbar',
            xtype: 'toolbar',
            dock: 'bottom',
            items: pagingItems
        });
        me.dockedItems = userDockedItems;

        var textLayerDiv = '';
        if(!PDFJS.disableTextLayer){
            textLayerDiv = '<div class="pdf-text-layer"></div>';
        }

        userItems.push({
            itemId: 'pdfPageContainer',
            xtype: 'container',
            width: '100%',
            height: '100%',
            html: '<canvas class="pdf-page-container"></canvas>' + textLayerDiv,
            listeners:{
                afterrender: function(){
                    me.pageContainer = this.el.query('.pdf-page-container')[0];
                    me.pageContainer.mozOpaque = true;
                    
                    var ctx = me.pageContainer.getContext('2d');
                    ctx.save();
                    ctx.fillStyle = 'rgb(255, 255, 255)';
                    ctx.fillRect(0, 0, me.pageContainer.width, me.pageContainer.height);
                    ctx.restore();
                    
                    if(!PDFJS.disableTextLayer){
                        me.textLayerDiv = this.el.query('.pdf-text-layer')[0];
                    }
                }
            }
        });
        me.items = userItems;

        me.callParent(arguments);
	
	// An exception was thrown in afterrender handler when upgrading to 2.4.3. It seems that there is
        // a bug in that version, however using a proposed workaround from Sencha forum solved the problem: 
	// (http://www.sencha.com/forum/showthread.php?291412-Error-after-upgrade-to-ExtJS-4.2.3&p=1064679)
	// 'afterrenderer' --> 'boxready'
        me.on('boxready', function(){ 
            me.loader = new Ext.LoadMask(me.child('#pdfPageContainer'),{
                msg: me.loadingMessage
            });
            me.loader.show();
        }, me,{
            single: true
        });

        if(me.disableWorker){
            PDFJS.disableWorker = true;
        }

        // Asynchronously download PDF as an ArrayBuffer
        me.getDocument();
    },

    onLoad: function() {
        try {
            var me = this, isEmpty;

            isEmpty = me.pdfDoc.numPages === 0;
            me.currentPage = me.currentPage || (isEmpty ? 0 : 1);

            me.renderPage(me.currentPage);
        }
        catch (error) {
            Ext.log( {level: "warning"}, "PDF: Can't render: " + error.message);
        }
    },

    renderPage: function(num){
        var me = this,
            toolbar = me.child('#pagingToolbar'),
            isEmpty, pageCount,
            currPage, afterText;

        if(me.isRendering) return;

        me.isRendering = true;
        me.currentPage = num;

        currPage = me.currentPage;
        pageCount = me.pdfDoc.numPages;
        afterText = Ext.String.format(me.afterPageText, isNaN(pageCount) ? 1 : pageCount);
        isEmpty = pageCount === 0;
        Ext.suspendLayouts();
        toolbar.child('#afterTextItem').setText(afterText);
        toolbar.child('#inputItem').setDisabled(isEmpty).setValue(currPage);
        toolbar.child('#first').setDisabled(currPage === 1 || isEmpty);
        toolbar.child('#prev').setDisabled(currPage === 1 || isEmpty);
        toolbar.child('#next').setDisabled(currPage === pageCount || isEmpty);
        toolbar.child('#last').setDisabled(currPage === pageCount || isEmpty);
        toolbar.child('#scaleCombo').setDisabled(isEmpty).setValue(me.pageScale);

        // Using promise to fetch the page
        me.pdfDoc.getPage(num).then(function(page) {
            
            if (!me.pageContainer) {
                // pageContainer not available. Widget destroyed already?
                Ext.log( {level: "warning"}, "PDF: pageContainer not ready to render page.");

                Ext.resumeLayouts(true);
                me.isRendering = false;
                
                return;
            }
            
            var viewport = page.getViewport(me.pageScale);
            me.pageContainer.height = viewport.height;
            me.pageContainer.width = viewport.width;

            var ctx = me.pageContainer.getContext('2d');
            ctx.save();
            ctx.fillStyle = 'rgb(255, 255, 255)';
            ctx.fillRect(0, 0, me.pageContainer.width, me.pageContainer.height);
            ctx.restore();

            var textLayer = me.textLayerDiv ? Ext.create('Ext.ux.util.PDF.TextLayerBuilder',{
                textLayerDiv: me.textLayerDiv
            }) : null;

            // Render PDF page into canvas context
            var renderContext ={
                canvasContext: ctx,
                viewport: viewport,
                textLayer: textLayer
            };
            page.render(renderContext);

            Ext.resumeLayouts(true);

            me.isRendering = false;

            if(me.loader){
                me.loader.destroy();
            }

            if(me.rendered){
                me.fireEvent('change', me, {
                    current: me.currentPage,
                    total: me.pdfDoc.numPages
                });
            }
        });
    },

    moveFirst: function(){
        var me = this;
        if(me.fireEvent('beforechange', me, 1) !== false){
            me.renderPage(1);
        }
    },

    movePrevious: function(){
        var me = this,
            prev = me.currentPage - 1;

        if(prev > 0){
            if(me.fireEvent('beforechange', me, prev) !== false){
                me.renderPage(prev);
            }
        }
    },

    moveNext: function(){
        var me = this,
            total = me.pdfDoc.numPages,
            next = me.currentPage + 1;

        if(next <= total){
            if(me.fireEvent('beforechange', me, next) !== false){
                me.renderPage(next);
            }
        }
    },

    moveLast: function(){
        var me = this,
            last = me.pdfDoc.numPages;

        if(me.fireEvent('beforechange', me, last) !== false){
            me.renderPage(last);
        }
    },

    readPageFromInput: function(){
        var me = this, v = me.child('#pagingToolbar').child('#inputItem').getValue(),
            pageNum = parseInt(v, 10);

        if(!v || isNaN(pageNum)){
            me.child('#pagingToolbar').child('#inputItem').setValue(me.currentPage);
            return false;
        }
        return pageNum;
    },

    onPagingFocus: function(){
        this.child('#pagingToolbar').child('#inputItem').select();
    },

    onPagingBlur: function(e){
        var curPage = this.getPageData().currentPage;
        this.child('#pagingToolbar').child('#inputItem').setValue(curPage);
    },

    onPagingKeyDown: function(field, e){
        var me = this,
            k = e.getKey(),
            increment = e.shiftKey ? 10 : 1,
            pageNum, total = me.pdfDoc.numPages;

        if(k == e.RETURN){
            e.stopEvent();
            pageNum = me.readPageFromInput();
            if(pageNum !== false){
                pageNum = Math.min(Math.max(1, pageNum), total);
                if(me.fireEvent('beforechange', me, pageNum) !== false){
                    me.renderPage(pageNum);
                }
            }
        } else if(k == e.HOME || k == e.END){
            e.stopEvent();
            pageNum = k == e.HOME ? 1 : total;
            field.setValue(pageNum);
        } else if(k == e.UP || k == e.PAGE_UP || k == e.DOWN || k == e.PAGE_DOWN){
            e.stopEvent();
            pageNum = me.readPageFromInput();
            if(pageNum){
                if(k == e.DOWN || k == e.PAGE_DOWN){
                    increment *= -1;
                }
                pageNum += increment;
                if(pageNum >= 1 && pageNum <= total){
                    field.setValue(pageNum);
                }
            }
        }
    },

    onScaleBlur: function(e){
        this.child('#pagingToolbar').child('#scaleCombo').setValue(this.pageScale);
    },

    onScaleChange: function(combo, newValue){
        var me = this;
        me.pageScale = newValue;
        me.renderPage(me.currentPage);
    },
    
    setSrc: function(src){
        this.src = src;
        return this.getDocument();
    },
    
    getDocument: function(){
        var me = this;
        if(!!me.src){
            PDFJS.getDocument(me.src).then(function(pdfDoc){
                me.pdfDoc = pdfDoc;
                me.onLoad();
            });
        }
        return me;
    }
});
/**
 * Copyright (c) 2012 André Fiedler, <https://twitter.com/sonnenkiste>
 *
 * license: MIT-style license
 */
 
 Ext.define('Ext.ux.util.PDF.TextLayerBuilder', {

    textLayerDiv: null,

    constructor: function(config){
        this.textLayerDiv = config.textLayerDiv;
    },

    beginLayout: function(){
        this.textDivs = [];
        this.textLayerQueue = [];
    },

    endLayout: function(){
        var me = this,
            textDivs = me.textDivs,
            textLayerDiv = me.textLayerDiv,
            renderTimer = null,
            renderingDone = false,
            renderInterval = 0,
            resumeInterval = 500, // in ms
            canvas = document.createElement('canvas'),
            ctx = canvas.getContext('2d');

        // Render the text layer, one div at a time
        function renderTextLayer(){
            if(textDivs.length === 0){
                clearInterval(renderTimer);
                renderingDone = true;
                me.textLayerDiv = textLayerDiv = canvas = ctx = null;
                return;
            }
            var textDiv = textDivs.shift();
            if(textDiv.dataset.textLength > 0){
                textLayerDiv.appendChild(textDiv);

                if(textDiv.dataset.textLength > 1){ // avoid div by zero
                    // Adjust div width to match canvas text

                    ctx.font = textDiv.style.fontSize + ' sans-serif';
                    var width = ctx.measureText(textDiv.textContent).width;

                    var textScale = textDiv.dataset.canvasWidth / width;

                    var vendorPrefix = (function(){
                        if('result' in arguments.callee) return arguments.callee.result;

                        var regex = /^(Moz|Webkit|Khtml|O|ms|Icab)(?=[A-Z])/;

                        var someScript = document.getElementsByTagName('script')[0];

                        for(var prop in someScript.style){
                            if(regex.test(prop)){
                                return arguments.callee.result = prop.match(regex)[0];
                            }
                        }
                        if('WebkitOpacity' in someScript.style) return arguments.callee.result = 'Webkit';
                        if('KhtmlOpacity' in someScript.style) return arguments.callee.result = 'Khtml';

                        return arguments.callee.result = '';
                    })();

                    var textDivEl = Ext.get(textDiv);

                    // TODO: Check if these styles get set correctly!
                    textDivEl.setStyle(vendorPrefix + '-transform', 'scale(' + textScale + ', 1)');
                    textDivEl.setStyle(vendorPrefix + '-transformOrigin', '0% 0%');
                }
            } // textLength > 0
        }
        renderTimer = setInterval(renderTextLayer, renderInterval);

        // Stop rendering when user scrolls. Resume after XXX milliseconds
        // of no scroll events
        var scrollTimer = null;

        function textLayerOnScroll(){
            if(renderingDone){
                window.removeEventListener('scroll', textLayerOnScroll, false);
                return;
            }

            // Immediately pause rendering
            clearInterval(renderTimer);

            clearTimeout(scrollTimer);
            scrollTimer = setTimeout(function textLayerScrollTimer(){
                // Resume rendering
                renderTimer = setInterval(renderTextLayer, renderInterval);
            }, resumeInterval);
        } // textLayerOnScroll

        window.addEventListener('scroll', textLayerOnScroll, false);
    }, // endLayout

    appendText: function(text, fontName, fontSize){
        var textDiv = document.createElement('div');

        // vScale and hScale already contain the scaling to pixel units
        var fontHeight = fontSize * text.geom.vScale;
        textDiv.dataset.canvasWidth = text.canvasWidth * text.geom.hScale;
        textDiv.dataset.fontName = fontName;

        textDiv.style.fontSize = fontHeight + 'px';
        textDiv.style.left = text.geom.x + 'px';
        textDiv.style.top = (text.geom.y - fontHeight) + 'px';
        textDiv.textContent = PDFJS.bidi(text, - 1);
        textDiv.dir = text.direction;
        textDiv.dataset.textLength = text.length;
        this.textDivs.push(textDiv);
    }
});
