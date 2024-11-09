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
