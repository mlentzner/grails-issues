<html>
<head>

</head>
<body>
    <g:form action="update" id="${itemized.id}">
        Manufacturer: <g:textField name="manufacturer" value="${equipmentItem.manufacturer}"/><br/>
        <br/>
        <g:hiddenField name="equipmentItemId" value="${equipmentItem.id}"/>
        <g:submitButton name="Submit"/>
    </g:form>
</body>
</html>