
var i=0;
var arev =[];
var arda =[];
function del()
{
  document.getElementById("demo").style.display = "none";
    
}
function edit()
{
  document.getElementById("form").style.display = "block";
}


function sub()
{
 

  var val="demo"+i;
  var event = document.getElementById("eventname").value;
  arev.push(event);
  var date = document.getElementById("eventdate").value;
  console.log(date);
  arda.push(date);
  
  document.getElementById("eventtable").innerHTML+=`<tr id=${val}>
  <td>${event}</td>
  <td>${date}</td>
  <td><input type='button' name='Editbutton' value='Edit' style='width:60px' id='Edit' onclick='edit()'></td>
  <td><input type='button' name='DELbutton' value='Delete' style='width:60px' onclick='((this.parentElement).parentElement).style.display="none";arev.pop();
  arda.pop();'></td>
  </tr>`; 


  i=i+1;
}




function share(){
  localStorage.clear();
  localStorage.setItem("a",JSON.stringify(arev));
  localStorage.setItem("b",JSON.stringify(arda));

  
console.log(arev);
console.log(arda);

}
function create()
{

  document.getElementById("form").style.display = "block";


}

var len;
function update(){
  var a = localStorage.getItem("a");
  var b = localStorage.getItem("b");
  var arev = JSON.parse(a);
  var arda = JSON.parse(b);
  var j=0;
  len = arev.length;
  for(j=0;j<=len-1;j++)
  {
    console.log(len);
    document.getElementById("studentevent").innerHTML+=`
    <tr>
    <td>${arev[j]}</td>
    <td>${arda[j]}</td>
    <td><input type="radio" name="flag${j}" id="flag${j}" value="completed"></td>
    <td><input type="radio" name="flag${j}" id=""flag${j}" value="pending"></td>
    <td><input type="radio" name="flag${j}" id=""flag${j}" value="upcoming"></td>
    <td><input type="radio" name="flag${j}" id=""flag${j}" value="highprior"></td>
    </tr>`

  }
}


function sendstatus(){

 var status = []
 var s1;
 for(k1=0;k1<len;k1++)
 {
 var v = document.getElementsByName(`flag${k1}`);
 
 for(k = 0; k < v.length; k++) { 
  if(v[k].checked) 
  {
    s1=v[k].value;
    
  
}
 } 
 status.push(s1);
}
localStorage.setItem("c",JSON.stringify(status));
localStorage.setItem("len",len);

}


function getstatus()
{
  
  var a = localStorage.getItem("a");
  var b = localStorage.getItem("b");
  var arev = JSON.parse(a);
  var arda = JSON.parse(b);
 var k1 = localStorage.getItem("len");
 var status = JSON.parse(localStorage.getItem("c"))
if(status==null)
{
  alert("Status already updated");
}
else
{
  for(k1=0;k1<status.length;k1++)
{

  document.getElementById("statustable").innerHTML+=`

  <tr>
  <td>${arev[k1]}</td>
  <td>${arda[k1]}</td>
  <td>${status[k1]}</td>
  </tr>
  
  
  `
}
localStorage.clear();
}
}
