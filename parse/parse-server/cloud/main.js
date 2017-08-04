// Cloud Code entry point
Parse.Cloud.define('hello', function(req, res) { 
	console.info("hello functions");
	res.success('Hi, parse functions'); 
});