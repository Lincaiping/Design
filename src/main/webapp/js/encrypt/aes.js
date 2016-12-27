/*
<script type="text/javascript" src="http://www.osctools.net/js/CryptoJS/components/core-min.js"></script>
<script type="text/javascript" src="http://www.osctools.net/js/CryptoJS/rollups/aes.js"></script>
 */

function Encrypt(word){  
         var key = CryptoJS.enc.Utf8.parse("0102030405060708");   
         var iv  = CryptoJS.enc.Utf8.parse('0102030405060708');   
         var srcs = CryptoJS.enc.Utf8.parse(word);  
         var encrypted = CryptoJS.AES.encrypt(srcs, key, { iv: iv,mode:CryptoJS.mode.CBC});  
         return encrypted.toString();  
    }  
function Decrypt(word){  
         var key = CryptoJS.enc.Utf8.parse("0102030405060708");   
         var iv  = CryptoJS.enc.Utf8.parse('0102030405060708');   
         var decrypt = CryptoJS.AES.decrypt(srcs, key, { iv: iv,mode:CryptoJS.mode.CBC});  
         return CryptoJS.enc.Utf8.stringify(encrypted).toString();  
    }  