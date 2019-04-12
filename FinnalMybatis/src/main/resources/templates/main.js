<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript" src="http://code.jquery.com/jquery-2.0.0.min.js"></script>
        <script language="javascript">
            function load_ajax(){
                $.ajax({
                    url : "result.php",
                    type : "post",
                    dataType:"text",
                    data : {
                         
                    },
                    success : function (result){
                        $('#result').html(result);
                    }
                });
            }
        </script>
    </head>
    <body>
        <div id="result">
            Nội dung ajax sẽ được load ở đây
        </div>
        <input type="button" name="clickme" id="clickme" onclick="load_ajax()" value="Click Me"/>
    </body>
</html>