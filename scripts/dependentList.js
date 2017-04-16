var req;
var secondBoxId;

function myRetrieveSecondOptions(firstBox, box2Id, action, paramName)
{
    secondBoxId = box2Id;

    if(firstBox.selectedIndex < 0){
        return;
    }

	var d = new Date();
	
    var selectedOption = firstBox.options[firstBox.selectedIndex].value;
    var url=action + "?" + paramName + "=" + selectedOption+"&"+d.getTime();

    if (window.XMLHttpRequest){
        req = new XMLHttpRequest();
        req.onreadystatechange = populateSecondBox;
        try {
            //req.open("GET", url, true);
			req.open("GET", url, false);
        } catch (e) {
            alert('<fmt:message key="msg.connectFailed"/>');
        }
        req.send(null);
    } else if (window.ActiveXObject) { // IE
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = populateSecondBox;
            try {
                //req.open("GET", url, true);
				req.open("GET", url, false);
            } catch (e) {
                alert('<fmt:message key="msg.connectFailed"/>');
            }
            req.send();
        }
    }
}

  //Callback function
function populateSecondBox()
{

    if (req.readyState == 4) {
        if (req.status == 200) { // OK response
            var textToSplit = req.responseText;

            if(textToSplit == '') {
                alert("No select option available on the server");
                return;
            }
            document.getElementById(secondBoxId).options.length = 0;
            //Split the document
			if (textToSplit.indexOf(",") == 0)
			{
				textToSplit = textToSplit.substring(1);
			}
            var returnElements = textToSplit.split(",");

            //Process each of the elements
            for ( var i=0; i< returnElements.length; i++ ) {
                var valueLabelPair = returnElements[i].split("|");
                document.getElementById(secondBoxId).options[i] = new Option(valueLabelPair[1], valueLabelPair[0]);
            }
        } else {
            alert("Bad response by the server");
        }
    }
}