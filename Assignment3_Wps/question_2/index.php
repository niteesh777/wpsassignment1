<!DOCTYPE html>
<html>

<head>
    <title>Test page</title>
    <meta name="viewport" width="device-width" initial-scale="1" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>


<body>

<h1>
Enter url
</h1>
<input type="text" placeholder="url" id="url">
<h1>
Description
</h1>
<input type="text" placeholder="description" id="desc">
<br>

<button style="margin-top:30px" onclick="adddb()">Submit</button>
    
<script>

function adddb()
{

  var a = document.getElementById("url").value;
  var b = document.getElementById("desc").value;
  console.log(a,b);

 $.ajax({
      url: "adddb.php",
      type: "POST",
      data: {
        url1: a,
        desc1: b,
      },
      success: function (data) {
        console.log('data: '+data);
      },
      
      error: function(error) {
        console.log('Error: ' + error);
      }
    });


}
</script>

</body>
</html>

