<%@ page import="issues.JobItem; issues.EquipmentItem" %>
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
                <td><g:link action="create" controller="jobItem" id="${itemized.id}">Create Job Item</g:link></td>
                <td><g:link action="create" controller="equipmentItem" id="${itemized.id}">Create Equipment Item</g:link></td>
                <td><g:link action="edit" id="${itemized.id}">Edit</g:link></td>
                <td><g:link action="delete" id="${itemized.id}">Delete</g:link></td>
            </tr>
            <g:each var="lineItem" in="${itemized.lineItems}">
                <tr>
                    <td></td>
                    <g:if test="${lineItem instanceof EquipmentItem}">%{--<g:if test="${lineItem.manufacturer}">--}% %{--Mongo Plugin #688 - Can't use commented code anymore - used to be valid--}%
                        <td>Manufacturer: ${lineItem.manufacturer}</td>
                        <td>Create Sub-Item</td>
                        <td><g:link action="edit" controller="equipmentItem" id="${itemized.id}" params="[equipmentItemId: lineItem.id]">Edit</g:link></td>
                        <td><g:link action="delete" controller="equipmentItem" id="${itemized.id}" params="[equipmentItemId: lineItem.id]">Delete</g:link></td>
                    </g:if>
                    <g:elseif test="${lineItem instanceof issues.JobItem}">%{--<g:elseif test="${lineItem.teamSize}">--}% %{--Mongo Plugin #688 - Can't use commented code anymore - used to be valid--}%
                        <td>Team Size: ${lineItem.teamSize}</td>
                        <td>Create Sub-Item</td>
                        <td><g:link action="edit" controller="jobItem" id="${itemized.id}" params="[jobItemId: lineItem.id]">Edit</g:link></td>
                        <td><g:link action="delete" controller="jobItem" id="${itemized.id}" params="[jobItemId: lineItem.id]">Delete</g:link></td>
                    </g:elseif>
                </tr>
            </g:each>
        </g:each>
    </table>
</body>
</html>