<html>
<head>
    <style>
        td {
            padding-left: 10px;
        }
    </style>
</head>
    <g:link action="create">Create Itemized</g:link><br/>
    <br/>
    Total Objects: ${itemizeds.size()}<br/>
    <br/>
    <table>
        <g:each var="itemized" in="${itemizeds}">
            <tr>
                <td>Name: ${itemized?.name}</td>
                <td><g:link action="create" controller="lineItem">Create Person Item</g:link></td>
                <td><g:link action="create" controller="lineItem">Create Equipment Item</g:link></td>
                <td><g:link action="edit" id="${itemized.id}">Edit</g:link></td>
                <td><g:link action="delete" id="${itemized.id}">Delete</g:link></td>
            </tr>
        </g:each>
    </table>
</body>
</html>