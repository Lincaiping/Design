i = 1;
j = 1;
$(document).ready(
        function() {
            $("#btn_add1").click(
                    function() {
                        document.getElementById("newUpload1").innerHTML += '<div id="div_'
                            + i
                            + '"><input  name="file" type="file"  /><input type="button" value="删除" '+
                            ' onclick="del_1('
                            + i + ')"/></div>';
                        i = i + 1;
                        });
            $("#btn_add2").click(
                    function() {
                        document.getElementById("newUpload2").innerHTML += '<div id="div_'
                            + j
                            + '"><input  name="file_'
                            + j
                            + '" type="file"  /><input type="button" value="删除"  onclick="del_2('
                            + j + ')"/></div>';
                        j = j + 1;
                        });
            });

function del_1(o) {
    document.getElementById("newUpload1").removeChild(
    document.getElementById("div_" + o));
}

function del_2(o) {
    document.getElementById("newUpload2").removeChild(
    document.getElementById("div_" + o));
}