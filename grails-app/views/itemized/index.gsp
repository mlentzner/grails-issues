<html>
<head>

</head>
<body>
    <g:link action="create">Create</g:link><br/>
    <br/>
    Total Objects: ${itemizeds.size()}<br/>
    <br/>
    <g:each var="itemized" in="${itemizeds}">
        Name: ${itemized?.name}<br/>
    </g:each>
</body>
</html>