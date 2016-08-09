$('#toggleFormButton').click(toggleNewPersonForm);

function toggleNewPersonForm() {
	var button = $('#toggleFormButton');
	var form = $('#formContainer');
	var isVisible = form.is(':visible');

	if (isVisible === true) {
		form.hide();
		button.html('Add person');
	} else {
		form.show();
		button.html('Hide');
	}

}

function personPost() {
}