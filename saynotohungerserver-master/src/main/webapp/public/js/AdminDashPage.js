// Source: https://stackoverflow.com/questions/23764863/how-to-close-an-open-collapsed-navbar-when-clicking-outside-of-the-navbar-elemen
jQuery('body').bind('click', function(e) {
  // alert(e.target);
    if(jQuery(e.target).closest('.navbar').length == 0) {
        // click happened outside of .navbar, so hide
        var opened = jQuery('.navbar-collapse').hasClass('collapse in');
        if ( opened === true ) {
            jQuery('.navbar-collapse').collapse('hide');
        }
    }
});

// tabs switch to drop-down menu:
// https://stackoverflow.com/questions/25599777/toggle-bootstrap-tabs-to-dropdown-in-mobile-view
$('#tab_selector').on('change', function (e) {
    $('#pillsTabs li a').eq($(this).val()).tab('show');
});

// fixes bug of not preserving of the selected tab name when converts to the selectable list 
// on mobile devices
$('.nav-link').on('click', function() {
  $("#tab_selector").val($(this).attr("data-index"));
})

var userCardsMap = new Map();

function constructCardHtml(entry, cardType) {
	var userCard =
		"<div class=\"block\" id=\"" + entry.userId + "\">" + 
			"<div class=\"text-right\">"+
				"<button type=\"button\" class=\"btn btn-primary btn-icon\">"+
					"<span class=\"glyphicon glyphicon-envelope\"></span>"+
				"</button>"+
			"</div>"+
			"<div><div class=\"card-keys\">first name</div>: "+entry.userFirstName+"</div>"+
			"<div><div class=\"card-keys\">last  name</div>: "+entry.userLastName+"</div>"+
			"<div><div class=\"card-keys\">role</div>: "+entry.userRole+"</div>"+
			"<div><div class=\"card-keys\">type</div>: "+entry.userType+"</div>"+
			"<div><div class=\"card-keys\">Phone</div>: "+entry.userPhone+"</div>"+
			"<div><div class=\"card-keys\">email</div>: "+entry.userEmail+"</div>"+
			"<div><div class=\"card-keys\">city</div>: "+entry.userCity+"</div>";
		
		switch(cardType) {
		case "newApplications":
			userCard += 
			"<div class=\"btn-group btn-group-justified\" role=\"group\">"+
				"<div class=\"btn-group\" role=\"group\">"+
					"<button type=\"button\" class=\"btn btn-success\" onClick=\"approveApplication(" + entry.userId + ")\">Approve</button>"+
				"</div>"+
				"<div class=\"btn-group\" role=\"group\">"+
					"<button type=\"button\" class=\"btn btn-danger\" onClick=\"declineApplication(" + entry.userId + ")\">Decline</button>"+
				"</div>"+
			"</div>";
			break;
		case "suspendedUsers":
			userCard +=
			"<div class=\"btn-group btn-group-justified\" role=\"group\">"+	
				"<div class=\"btn-group\" role=\"group\">"+
					"<button type=\"button\" class=\"btn btn-success\" onClick=\"resumeUser(" + entry.userId + ")\">Resume</button>"+
				"</div>"+
			"</div>";
			break;
		case "regularUsers":
			userCard +=
			"<div class=\"btn-group btn-group-justified\" role=\"group\">"+	
				"<div class=\"btn-group\" role=\"group\">"+
					"<button type=\"button\" class=\"btn btn-danger\" onClick=\"suspendUser(" + entry.userId + ")\">Suspend</button>"+
				"</div>"+
			"</div>";
			break;
		case "inactiveApplications":
			userCard +=
			"<div class=\"btn-group btn-group-justified\" role=\"group\">"+
				"<div class=\"btn-group\" role=\"group\">"+
					"<button type=\"button\" class=\"btn btn-danger\" onClick=\"deleteInactiveApplication(" + entry.userId + ")\">Delete</button>"+
				"</div>"
			"</div>";
			break;
		}
		"</div>";

		return userCard;
}

//usage of $.getJSON was taken from here :
//https://medium.freecodecamp.org/here-is-the-most-popular-ways-to-make-an-http-request-in-javascript-954ce8c95aaa
function populateCards(cardType){
	$.getJSON( "/" + cardType, function( json ) {	
		userCards = [];
		$.each(json, function(i, entry){
			userCards.push(entry);
			userCardHtml = constructCardHtml(entry, cardType);
			$("#" + cardType + "Cards").append(userCardHtml);
		})
		
		userCardsMap.set(cardType, userCards);
	});
}


populateCards("newApplications");
populateCards("regularUsers");
populateCards("inactiveApplications");
populateCards("suspendedUsers");

function populateNewsItems() {
	$.getJSON( "/getNewsItems", function( json ) {	
		$.each(json, function(i, entry){
			var newRow = 
				"<li class=\"list-group-item\">" +
					"<div class=\"actions\">"+
						"<i id=\"" + entry.newsId + "\" class=\"far fa-trash-alt delete-news-item\"></i>" +
					"</div>" +
					"<a target=\"_blank\" href=\"" + entry.newLink + "\">" + entry.newTitle +
					"</a>" +
				"</li>";
			$(newRow).insertBefore( "#newNewsItem" );
		})
	});
}

populateNewsItems();

function moveUserCard(userId, from, to) {
	var newApplications = userCardsMap.get(from);
	var applicationToDecline = null;
    var arrayLength = newApplications.length;
    for(var i = 0; i < arrayLength; i++) {
    	if(newApplications[i].userId == userId) {
    		applicationToDecline = newApplications.splice(i, 1)[0];
    		userCardsMap.get(to).unshift(applicationToDecline);
    		userCardHtml = constructCardHtml(applicationToDecline, to);
    		$("#" + to + "Cards").prepend(userCardHtml);
    		$("#" + from + "Cards #" + userId).remove();
    		break;
    	}
    }	
}

function suspendUser(userId) {
	$.getJSON( "/suspendUser/" + userId, function( json ) {	
		if(json.result === "success") {
			moveUserCard(userId,  "regularUsers", "suspendedUsers");
		} else {
			alert("Failed to suspend user with ID = " + userId);
		}
	});
	
}

function resumeUser(userId) {
	$.getJSON( "/resumeUser/" + userId, function( json ) {	
		if(json.result === "success") {
			moveUserCard(userId,  "suspendedUsers", "regularUsers");
		} else {
			alert("Failed to resume user with ID = " + userId);
		}
	});
}

function approveApplication(userId) {
	$.getJSON( "/approveApplication/" + userId, function( json ) {	
		if(json.result === "success") {
			moveUserCard(userId,  "newApplications", "regularUsers");
		} else {
			alert("Failed to approve the application with ID = " + userId);
		}
	});
}

function declineApplication(userId) {
	$.getJSON( "/declineApplication/" + userId, function( json ) {	
		if(json.result === "success") {
			moveUserCard(userId,  "newApplications", "inactiveApplications");
		} else {
			alert("Failed to decline the application with ID = " + userId);
		}
	});
}

function deleteInactiveApplication(userId) {
	$.getJSON( "/deleteInactiveApplication/" + userId, function( json ) {	
		if(json.result === "success") {
			var inactiveApplications = userCardsMap.get("inactiveApplications");
			var applicationToDelete = null;
		    var arrayLength = inactiveApplications.length;
		    for(var i = 0; i < arrayLength; i++) {
		    	if(inactiveApplications[i].userId == userId) {
		    		inactiveApplications.splice(i, 1)[0];
		    		$("#" + "inactiveApplications" + "Cards #" + userId).remove();
		    		break;
		    	}
		    }
		} else {
			alert("Failed to delete the application with ID = " + userId);
		}
	});
}

//source: https://stackoverflow.com/questions/1359018/in-jquery-how-to-attach-events-to-dynamic-html-elements
$("#pills-editNewsFeed").on("click", ".delete-news-item", function(){
	var thiss = this;
	$.getJSON( "/deleteNewsItem/" + $(this).attr("id"), function( json ) {	
		if(json.result === "success") {
			$(thiss).closest("li").remove();
		} else {
			alert("Failed to delete news item with ID = " + $(thiss).attr("id"));
		}
	});
});


function addNewsItem(){
	var title = $("#newTitle").val();
	var link = $("#newLink").val();
	if(title != "" && link != ""){
		var newsId = new Date().getTime();
		//source https://www.w3schools.com/js/js_json_stringify.asp
		var jsonString = JSON.stringify({"newsId":newsId, "newTitle":title, "newLink":link});
		//source https://stackoverflow.com/questions/18550418/json-post-to-spring-controller
		$.ajax({ 
		    url:"/addNewsItem",
		    type:"POST", 
		    contentType: "application/json; charset=utf-8",
		    data: jsonString, 
		    async: false,    
		    cache: false,      
		     processData:false, 
		     success: function(resposeJsonObject){
		    	 //source: https://www.w3schools.com/js/js_json_parse.asp
					if(JSON.parse(resposeJsonObject).result === "success") {
						var newRow = 
							"<li class=\"list-group-item\">" +
								"<div class=\"actions\">"+
									"<i id=\"" + newsId + "\" class=\"far fa-trash-alt delete-news-item\"></i>" +
								"</div>" +
								"<a target=\"_blank\" href=\"" + link + "\">" + title +
								"</a>" +
							"</li>";
						$(newRow).insertBefore( "#newNewsItem" );
						$("#newTitle").val("");
						$("#newLink").val("");
					} else {
						alert("Failed to add news item with ID = " + newsId);
					}
		    }
		});
	}
}	
