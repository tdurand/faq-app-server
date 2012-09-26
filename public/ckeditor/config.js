/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';


	//config.toolbar = ['CrudToolbar', 'CardToolbar'];
	config.removePlugins = 'scayt,menubutton,contextmenu';
	config.toolbar_CrudToolbar =
	[
		{ name: 'document', items : [ 'Source', '-', 'Preview' ] },
		{ name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
		{ name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','Scayt' ] },
		{ name: 'tools', items : [ 'Maximize',  'ShowBlocks', '-','About' ] },
                '/',
		{ name: 'basicstyles', items : [ 'Bold','Italic', 'Underline', 'Strike','-','RemoveFormat' ] },
		{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote', 'JustifyLeft','JustifyCenter','JustifyRight', 'CreateDiv' ] },
		{ name: 'insert', items : [ 'Image', 'Table','HorizontalRule','Smiley','SpecialChar','PageBreak'] },
		'/',
		{ name: 'styles', items : [ 'Styles', 'Format', 'Font', 'FontSize' ] },
		{ name: 'colors', items : [ 'TextColor','BGColor' ] },
		{ name: 'links', items : [ 'Link','Unlink','Anchor' ] }
	];
	config.toolbar_CardToolbar =
	[
		{ name: 'document', items : [ 'Styles', 'Format', 'Templates', '-', 'Source', '-', 'Preview' ] },
		{ name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
        '/',		
		{ name: 'basicstyles', items : [ 'Bold','Italic', 'Underline', 'Strike','-','RemoveFormat' ] },
		{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote', 'JustifyLeft','JustifyCenter','JustifyRight', 'CreateDiv' ] },
		{ name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','Scayt' ] },
		{ name: 'tools', items : [ 'Maximize',  'ShowBlocks', '-','About' ] },
		'/',
		{ name: 'styles', items : [ 'Font', 'FontSize' ] },
		{ name: 'colors', items : [ 'TextColor','BGColor' ] },
		{ name: 'links', items : [ 'Link','Unlink' ] },
		{ name: 'insert', items : [ 'Image', 'Table','HorizontalRule','Smiley','SpecialChar','PageBreak'] }
	];
	config.toolbar_SendWindowToolbar = [
		{ name: 'document', items : [ 'Source', '-', 'Preview', 'Maximize'] }, 
		{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },
		{ name: 'insert', items : [ 'Image', 'Table','HorizontalRule','Smiley','SpecialChar','PageBreak'] },
                '/',
		{ name: 'styles', items : [ 'Format', 'Font', 'FontSize' ] },
		{ name: 'basicstyles', items : [ 'Bold','Italic', 'Underline', 'Strike','-','RemoveFormat' ] },
		{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-'] },
		{ name: 'colors', items : [ 'TextColor','BGColor' ] },
		
	];
	
	config.keystrokes.push([CKEDITOR.CTRL + 79 /*O*/, 'templates']);
	config.keystrokes.push([CKEDITOR.CTRL + 76 /*L*/, 'toolbarFocus']);
};