// Cloud Code entry point

Parse.Cloud.define('hello', function(req, res) { 
	console.info("hello function");
	res.success('Hi, parse function'); 
});