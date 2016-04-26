<%@ page import="issues.JobItem; issues.EquipmentItem" %>
<html>
<head>
    <style>
        td {
            padding-left: 10px;
        }
        td.indent1 {
            padding-left: 50px;
        }
        td.indent2 {
            padding-left: 100px;
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
                <td><g:link action="edit" id="${itemized.id}">Edit</g:link></td>
                <td><g:link action="delete" id="${itemized.id}">Delete</g:link></td>
                <td><g:link action="create" controller="jobItem" id="${itemized.id}">Create Job Item</g:link></td>
                <td><g:link action="create" controller="equipmentItem" id="${itemized.id}">Create Equipment Item</g:link></td>
            </tr>
            <g:each var="lineItem" in="${itemized.lineItems}">
                <tr>
                    <g:if test="${lineItem instanceof EquipmentItem}">
                        <td class="indent1">Manufacturer: ${lineItem.manufacturer}</td>
                        <td><g:link action="edit" controller="equipmentItem" id="${itemized.id}" params="[equipmentItemId: lineItem.id]">Edit</g:link></td>
                        <td><g:link action="delete" controller="equipmentItem" id="${itemized.id}" params="[equipmentItemId: lineItem.id]">Delete</g:link></td>
                    </g:if>
                    <g:elseif test="${lineItem instanceof JobItem}">
                        <td class="indent1">Team Size: ${lineItem.teamSize}</td>
                        <td><g:link action="edit" controller="jobItem" id="${itemized.id}" params="[jobItemId: lineItem.id]">Edit</g:link></td>
                        <td><g:link action="delete" controller="jobItem" id="${itemized.id}" params="[jobItemId: lineItem.id]">Delete</g:link></td>
                    </g:elseif>
                    <td><g:link action="create" controller="subItem" id="${itemized.id}" params="[lineItemId: lineItem.id]">Create Sub-Item</g:link></td>
                </tr>
                <g:each var="subItem" in="${lineItem.subItems}">
                    <tr>
                        <td class="indent2">Sub Name: ${subItem.name}</td>
                        <td><g:link action="edit" controller="subItem" id="${itemized.id}" params="[lineItemId: lineItem.id, subItemId: subItem.id]">Edit</g:link></td>
                        <td><g:link action="delete" controller="subItem" id="${itemized.id}" params="[lineItemId: lineItem.id, subItemId: subItem.id]">Delete</g:link></td>
                    </tr>
                </g:each>
            </g:each>
        </g:each>
    </table>
</body>
</html>