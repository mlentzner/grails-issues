<html>
<head>

</head>
<body>
    <g:form action="update" id="${itemized.id}">
        Team Size: <g:textField name="teamSize" value="${jobItem.teamSize}"/><br/>
        <br/>
        <g:hiddenField name="jobItemId" value="${jobItem.id}"/>
        <g:submitButton name="Submit"/>
    </g:form>
</body>
</html>