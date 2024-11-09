Ext.override(Ext.ux.grid.PageSize, {
	width: 75
});

Ext.override(At4FrameworkIntranet.FieldMainPanel, {
    margin: "8 7 2 7"
    //top, right, bottom, left
});
Ext.override(Ext.form.field.Date, {
    width: 320,
});
Ext.override(Ext.grid.Panel,{
	border: true
});

window.appOptions = {
	headerImageWidth: 260,
	toolbarHeight: 75
}


Ext.apply(At4FrameworkIntranet.FormDefaults, {
   TEXT_FIELD_WIDTH: 400,
   DOBLE_TEXT_FIELD_WIDTH: 810,
   YMEDIO_TEXT_FIELD_WIDTH: 343,
   HALF_TEXT_FIELD_WIDTH: 190,
   THIRD_TEXT_FIELD_LABEL_WIDTH: 227,
   THIRD_TEXT_FIELD_WIDTH: 295,
   QUARTER_TEXT_FIELD_WIDTH: 141,
   TINY_TEXT_FIELD_WIDTH: 90,
   TEXTAREA_FIELD_WIDTH: 643,
})

Ext.override(At4FrameworkIntranet.rowContainer,{
	margin: "10 0 10 0"
})

Ext.override(At4FrameworkIntranet.BasicPanel,{
	windowWidth: 860,
	windowHeight: 620
})
