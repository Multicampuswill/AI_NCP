<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var xhr = new XMLHttpRequest();
var url = 'http://apis.data.go.kr/1262000/SafetyNewsList/getCountrySafetyNewsList'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'63Jk4KYSAeT0Kif97Z6jQm7H4vk6jMJSJ29jfJB4wMtKA%2FDfN7igbdpFRmXbS%2BfopaXmPMqvIhJWeVLeuy2DXw%3D%3D'; /*Service Key*/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
queryParams += '&' + encodeURIComponent('title1') + '=' + encodeURIComponent('입국'); /**/
queryParams += '&' + encodeURIComponent('title2') + '=' + encodeURIComponent('코로나'); /**/
queryParams += '&' + encodeURIComponent('title3') + '=' + encodeURIComponent('운항'); /**/
queryParams += '&' + encodeURIComponent('title4') + '=' + encodeURIComponent('항공권'); /**/
queryParams += '&' + encodeURIComponent('title5') + '=' + encodeURIComponent('격리'); /**/
xhr.open('GET', url + queryParams);
xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
        alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
    }
};

xhr.send('');


</script>
</head>
<body>

</body>
</html>