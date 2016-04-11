<html>
<head>

</head>
<body>
<g:form action="save" id="${itemized.id}">
    Sub Name: <g:textField name="name"/><br/>
    <br/>
    <g:hiddenField name="lineItemId" value="${lineItem.id}"/>
    <g:submitButton name="Submit"/>
</g:form>
</body>
</html>