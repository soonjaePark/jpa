// Spinner Delay Base (ms)
var _SPINNER_DELAY = 300; 

// ajax request
function getJson (_url, _callback) 
{

    let xhr = new XMLHttpRequest (); 

    xhr.open ('GET', _url); 

    xhr.responseType = 'json'; 

    xhr.onload = function () {


        _callback (xhr.response); 
    }

    xhr.send (); 
}

function getJsonWithoutSpin (_url, _callback)
{

    let xhr = new XMLHttpRequest ();

    xhr.open ('GET', _url);

    xhr.responseType = 'json';

    xhr.onload = function () {
        _callback (xhr.response);
    }
    xhr.send ();
}

function getJsonWithForm (_formID, _callback) 
{
    let formElement = document.getElementById (_formID); 
    let _url = formElement.getAttribute ('action'); 

    if ( formElement == undefined || formElement == null )
        return; 
    

    var oField, sFieldType, nFile, sSearch = "";
    for (var nItem = 0; nItem < formElement.elements.length; nItem++) 
    {
        oField = formElement.elements[nItem];
        if ( !oField.hasAttribute("name") ) { continue; }
        sFieldType = oField.nodeName.toUpperCase() === "INPUT" ? oField.getAttribute("type").toUpperCase() : "TEXT";
        if ( sFieldType === "FILE" ) 
        {
            for ( nFile = 0; nFile < oField.files.length; sSearch += "&" + escape(oField.name) + "=" + escape(oField.files[nFile++].name) );
        }
        else if ((sFieldType !== "RADIO" && sFieldType !== "CHECKBOX") || oField.checked) 
        {
            sSearch += "&" + escape(oField.name) + "=" + escape(oField.value);
        }
    }

    let xhr = new XMLHttpRequest (); 

    // xhr.open ('GET', _url); 
    xhr.open ('GET', formElement.action.replace(/(?:\?.*)?$/, sSearch.replace(/^&/, "?")), true); 

    xhr.responseType = 'json'; 

    xhr.onload = function () {
        
        _callback (xhr.response); 
    }

    xhr.send (null); 

    // xhr.send (new FormData (formElement)); 
}

function getUrlsWithForm (_formID)
{
    let formElement = document.getElementById (_formID); 

    if ( formElement == undefined || formElement == null )
        return; 

    var oField, sFieldType, nFile, sSearch = "";
    for (var nItem = 0; nItem < formElement.elements.length; nItem++) 
    {
        oField = formElement.elements[nItem];
        if ( !oField.hasAttribute("name") ) { continue; }
        sFieldType = oField.nodeName.toUpperCase() === "INPUT" ? oField.getAttribute("type").toUpperCase() : "TEXT";
        if ( sFieldType === "FILE" ) 
        {
            for ( nFile = 0; nFile < oField.files.length; sSearch += "&" + escape(oField.name) + "=" + escape(oField.files[nFile++].name) );
        }
        else if ((sFieldType !== "RADIO" && sFieldType !== "CHECKBOX") || oField.checked) 
        {
            sSearch += "&" + escape(oField.name) + "=" + escape(oField.value);
        }
    }

    return sSearch.replace(/^&/, "?"); 
}

function postJsonWithForm (_formID, _callback) 
{
    let formElement = document.getElementById (_formID); 
    let _url = formElement.getAttribute ('action'); 

    if ( formElement == undefined || formElement == null )
        return; 

    let xhr = new XMLHttpRequest (); 

    xhr.open ('POST', _url); 

    xhr.responseType = 'json'; 

    xhr.onload = function () {

        _callback (xhr.response); 
    }

    xhr.send (new FormData (formElement));
}

function postJsonWithFormData (_formdata, _url, _callback) 
{
    if ( _formdata == undefined || _formdata == null )
        return; 
    
    spinnerOn (); 

    let xhr = new XMLHttpRequest (); 

    xhr.open ('POST', _url); 

    xhr.responseType = 'json'; 

    xhr.onload = function () {
        setTimeout(() => {
            spinnerOff();
        }, _SPINNER_DELAY);

        _callback (xhr.response); 
    }

    xhr.send (_formdata);
}

function postJsonWithJsonData (_formdata, _url, _callback)
{
    if ( _formdata == undefined || _formdata == null )
        return;

    spinnerOn ();

    let xhr = new XMLHttpRequest ();

    xhr.open ('POST', _url);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    xhr.responseType = 'json';

    xhr.onload = function () {
        setTimeout(() => {
            spinnerOff();
        }, _SPINNER_DELAY);

        _callback (xhr.response);
    }

    xhr.send (_formdata);
}

function postJsonWithJsonDataWOSpin (_formdata, _url, _callback)
{
    if ( _formdata == undefined || _formdata == null )
        return;

    let xhr = new XMLHttpRequest ();

    xhr.open ('POST', _url);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    xhr.responseType = 'json';

    xhr.onload = function () {
        _callback (xhr.response);
    }

    xhr.send (_formdata);
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}