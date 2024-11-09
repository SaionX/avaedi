Ext.define('At4FrameworkIntranet.MultiList', {
	extend: 'Ext.grid.filters.filter.SingleFilter',
	alias: 'grid.filter.multiList',

	type: 'multiList',

	constructor: function() {
		console.log("Se esta creando un filtro personalizado multiList");
		this.callParent(arguments);
	},
	/*
		menuDefaults: {},
		itemDefaults: {},
		createMenu: function(config) {
			var me = this,
				gridStore = me.getGridStore(),
				store = me.store,
				options = me.options,
				menu;

			if (store) {
				me.store = store = Ext.StoreManager.lookup(store);
			}

			menu = me.menu = Ext.create("Ext.ux.form.MultiSelect", {
				store: store
			});

			if (store) {
				if (!store.getCount()) {
					menu =
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
			}
		},*/
	selectOnFocus: true,
	value: '',

	/**  
	 * @private
	 * Template method that is to initialize the filter and install required menu items.
	 */
	init: function(config) {
		console.log("Init method called")

		this.comboItem = new Ext.ux.form.MultiSelect(config);
		this.comboItem.on('change', this.onChange, this);
		this.comboItem.store.on('load', this.onLoad, this);



		//this.menu.add(this.comboItem);


		this.menu.add({
			xtype: "container",
			html: "loren ipsum dolor sit amet"
		})
		this.updateTask = new Ext.util.DelayedTask(this.fireUpdate, this);
	},


	onLoad: function(store, records) {
		this.comboItem.setHeight(Math.min(300, 20 + (store.getCount() * 20)));
	},

	/**
	 * @private
	 * Template method that is to get and return the value of the filter.
	 * @return {String} The value of this filter
	 */
	getValue: function() {
		if (this.comboItem.rendered) {
			return this.comboItem.getValue();
		} else {
			return this.value;
		}
	},

	/**
	 * @private
	 * Template method that is to set the value of the filter.
	 * @param {Object} value The value to set the filter
	 */
	setValue: function(value) {
		this.value = value;

		if (this.comboItem.rendered) {
			this.comboItem.setValue(value);
		} else {
			var setValueFunction = function() {
				this.setValue(value);
				this.un('afterrender', setValueFunction, this);
			};
			this.comboItem.on('afterrender', setValueFunction, this.comboItem);
		}
		this.fireEvent('update', this);
	},

	/**
	 * @private
	 * Template method that is to return <tt>true</tt> if the filter
	 * has enough configuration information to be activated.
	 * @return {Boolean}
	 */
	isActivatable: function() {
		if (this.comboItem.rendered) {
			return this.comboItem.getValue().length > 0;
		} else {
			return this.value.length > 0;
		}
	},

	/**
	 * @private
	 * Template method that is to get and return serialized filter data for
	 * transmission to the server.
	 * @return {Object/Array} An object or collection of objects containing
	 * key value pairs representing the current configuration of the filter.
	 */
	getSerialArgs: function() {
		return {
			type: 'list',
			value: this.getValue()
		};
	},

	onChange: function() {
		// restart the timer
		this.updateTask.delay(this.updateBuffer);
	},
	activateMenu: function() {
		
	}


});