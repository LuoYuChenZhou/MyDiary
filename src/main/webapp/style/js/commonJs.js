const preUrl = "/MyDiary";

function fieldIsNull(field) {
	return field === null || typeof (field) === "undefined" || $.trim(field) === "";
}