<%--
  Created by IntelliJ IDEA.
  User: wenhuili2
  Date: 2/10/20
  Time: 10:19 am
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Staff</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
</head>
<body>
<table id="admin" title="Staff admin" class="easyui-datagrid" fitColumns="true" pagination="true"
       fit="true" rownumbers="true" url="staffController"
       data-options="fitColumns:true,singleSelect:false,checkbox:true" toolbar="#toolbar">
    <thead checkbox="true">
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="ID" width="50" hidden>ID</th>
        <th field="cardID" width="50">Card ID</th>
        <th field="opalCardNumber" width="50">Opal Card Number</th>
        <th field="cardType" width="50">Card Type</th>
        <th field="cardBalance" width="50">Card Balance</th>
        <th field="cardStatus" width="50">Card Status</th>
        <th field="userEmail" width="50">User Email</th>
        <th field="is_linked" width="50">Is Linked</th>
        <th field="is_sold" width="50">Is Sold</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New
        Entity</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit
        Entity</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteItems()">Remove
        Entity</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:800px"
     data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" style="margin:0;padding:20px 50px" action="staffInsert">
        <h3>Entity Information</h3>
        <div style="margin-bottom:10px">
            <label>Card Type</label>
            <select name="cardType" class="easyui-combobox" required="true" style="width:100%">
                <option>Adult</option>
                <option>Youth</option>
                <option>Gold Senior</option>
                <option>Concession</option>
            </select>
        </div>
        <button type="submit" class="easyui-linkbutton c6" iconCls="icon-ok" style="width:90px">Save</button>
    </form>
</div>

<div id="update-dlg" class="easyui-dialog" style="width:800px"
     data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="update-fm" method="post" style="margin:0;padding:20px 50px" action="staffUpdate">
        <h3>Entity Information</h3>
        <div style="margin-bottom:10px; display: none">
            <label>ID</label>
            <input name="ID" class="easyui-textbox" required="true" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <label>Card ID</label>
            <input name="cardID" class="easyui-numberbox" required="true" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <label>Card Number</label>
            <input name="opalCardNumber" class="easyui-textbox" required="true" style="width:100%;">
        </div>
        <div style="margin-bottom:10px">
            <label>Card Type</label>
            <input name="cardType" class="easyui-textbox" required="true" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <label>Card Balance</label>
            <input name="cardBalance" class="easyui-numberbox" data-options="min:0,precision:2" required="true" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <label>Card Status</label>
            <input name="cardStatus" class="easyui-textbox" required="true" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <label>User email</label>
            <input name="userEmail" validType="email" class="easyui-textbox" required="true"
                   style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <label>Is Linked</label>
            <select name="is_linked" class="easyui-combobox" required="true" style="width:100%">
                <option>true</option>
                <option>false</option>
            </select>
        </div>
        <div style="margin-bottom:10px">
            <label>Is Sold</label>
            <select name="is_sold" class="easyui-combobox" required="true" style="width:100%">
                <option>true</option>
                <option>false</option>
            </select>
        </div>
        <button type="submit" class="easyui-linkbutton c6" iconCls="icon-ok" style="width:90px">Save</button>
    </form>
</div>
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">

    var url;

    function newUser() {
        $('#dlg').dialog('open').dialog('center').dialog('setTitle', 'New Entity');
        $('#fm').form('clear');
    }

    function editUser() {
        var row = $('#admin').datagrid('getSelected');
        if (row) {
            $('#update-dlg').dialog('open').dialog('center').dialog('setTitle', 'Edit Entity');
            $('#update-fm').form('load', row);
            url = 'staffUpdate'
        }
    }

    function saveUser() {
        $('#fm').form('submit', {
            url: url,
            iframe: false,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (result) {
                var result = eval('(' + result + ')');
                if (result.errorMsg) {
                    $.messager.show({
                        title: 'Error',
                        msg: result.errorMsg
                    });
                } else {
                    $('#dlg').dialog('close');        // close the dialog
                    $('#dg').datagrid('reload');    // reload the user data
                }
            }
        });
    }

    function deleteItems() {
        var row = $('#admin').datagrid('getSelections');
        if (row.length > 0) {
            var deletIDs = [];
            for (var i = 0; i < row.length; i++) {
                deletIDs.push(row[i].ID);
            }

            var ids = deletIDs.join(",");
            $.messager.confirm('Confirm', 'Are you sure you want to destroy those <font color="red">' + row.length + ' item(s)?', function (r) {
                if (r) {
                    $.post('staffDelete', {deleteIds: ids});
                    setInterval(() => {
                        window.location.reload();
                    }, 500);
                }
            });

        } else if (row.length == 0) {
            $.messager.alert(" ", "Please Select some items you want to delete.");
        }
    }
</script>
</body>
</html>
