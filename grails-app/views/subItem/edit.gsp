<html>
<head>

</head>
<body>
<g:form action="update" id="${itemized.id}">
    Sub Name: <g:textField name="name" value="${subItem.name}"/><br/>
    <br/>
    <g:hiddenField name="lineItemId" value="${lineItem.id}"/>
    <g:hiddenField name="subItemId" value="${subItem.id}"/>
    <g:submitButton name="Submit"/>
</g:form>
</body>
</html>