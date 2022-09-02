$(function () {
    var _fileService = fih.fileManagement.files.file;
    var l = abp.localization.getResource('Docs');
    var treeNodeId = $("#treeNodeId").val();
    //年月日
    $('.J-datepicker-range-day').datePicker({
        hasShortcut: true,
        format: 'YYYY-MM-DD',
        isRange: true,
        shortcutOptions: DATAPICKERAPI.rangeShortcutOption1
    });

    var _createModal = new abp.ModalManager({
        viewUrl: abp.appPath + 'FileManagement/CreateOrEditFile',
        modalClass: 'fileCreate',
    });

    var _editModal = new abp.ModalManager({
        viewUrl: abp.appPath + 'FileManagement/CreateOrEditFile',
        modalClass: 'fileEdit',
    });

    getFileList(treeNodeId);
    
    var _dataTable = {};


    //查詢
    $("#btnSearch").click(function (event) {
        //_dataTable.ajax.reload() 00000000-0000-0000-0000-000000000000;
        getFileList(treeNodeId);
    }
    );

    //查詢
    $('#btnRefresh').click(function () {
        window.location.reload(true);
    });

    //新增
    $('#btnFileAdd').click(function (event) {
        event.preventDefault();
        _createModal.open({
            EditMode: 'Edit',
            Id: '',
            From: '0',
            tid: 0,
            isAudit: false,
            windowOpen: true
        });
    });

    //刷新
    $('#btnRefresh').click(function () {
        window.location.reload(true);
    });

    _createModal.onClose(function () {
        //_dataTable.ajax.reload();
        getFileList(treeNodeId);
    });

    _editModal.onResult(function () {
        //_dataTable.ajax.reload();
        getFileList(treeNodeId);
    });

    function searchCondition(requestData, settings) {
        var queryConditions = {
            "dynamicColumns": "",
            "fileName": $("#FileName").val(),
            "beginTime": $("#beginTime").val(),
            "endTime": $("#endTime").val()

        }
        return queryConditions;
    }

    function getFileList(nodeId) {
        var columns = [];
        var queryList = [];
        //_fileService.getList(searchCondition)
        //    .done(function (dataList) {
        //        if (dataList.rows.length > 0) {
        //            for (var i = 0; i < dataList.rows.length; i++) {
        //                queryList.push(dataList.rows[i]);
        //            }
        //        }


        //字段索引
        var Index = 0;
        //獲取動態列
        $.ajax({
            url: "/api/admin/files/GetDynamicColumns",
            type: 'get',
            data: "nodeId=" + nodeId,
            dataType: "json",
            async: true,
            success: function (returnValue) {
                //異步獲取要動態生成的列，別名，寬度也可以
                var arr = returnValue.result;
                var colunmStr = "";
                //操作
                columns.push({
                    title: "操作",
                    data: 'id',
                    visible: true,
                    rowAction:
                    {
                        items: [
                            {
                                text: l('Edit'),
                                visible: abp.auth.isGranted(
                                    'FileManagement.Admin.Files.Update'
                                ),
                                action: function (data) {
                                    _editModal.open({
                                        EditMode: 'Edit',
                                        Id: data.record.id,
                                        From: '0',
                                        tid: 0,
                                        isAudit: false,
                                        windowOpen: true
                                    });
                                },
                            },
                            {
                                text: l('Delete'),
                                visible: abp.auth.isGranted(
                                    'FileManagement.Admin.Files.Delete'
                                ),
                                confirmMessage: function (data) {
                                    return l('ProjectDeletionWarningMessage');
                                },
                                action: function (data) {
                                    volo.docs.admin.projectsAdmin
                                        .delete(data.record.id)
                                        .then(function () {
                                            _dataTable.ajax.reload();
                                        });
                                },
                            },

                        ],
                    }
                }
                );
                //文件編號
                //columns.push({ title: "序列號", data: 'id', visible: false });
                //文件編號
                columns.push({ title: l('文件編碼'), data: 'fileCode' });
                columns.push({ title: l('文件名稱'), data: 'fileName' });
                columns.push({ title: l('流程號'), data: 'pID' });
                columns.push({ title: l('文件類型'), data: 'fileTypeName' });
                columns.push({ data: 'fileStatusCode', visible: false });
                columns.push({ title: l('文件狀態'), data: 'fileStatusName' });

                //動態屬性列
                $.each(arr, function (i, item) {
                    Index += i;
                    colunmStr += item.colname + ",";
                    columns.push({ data: item.colname });
                });
                columns.push({ title: l('創建人'), data: 'creatorName' });
                columns.push({ title: l('創建時間'), data: 'creationTime' });
                columns.push({ data: 'sourceFileUrl', visible: false });
                searchCondition.dynamicColumns = colunmStr;


            


            }
        })
            //})
            .always(function () {
                _dataTable = $('#FilesTable').DataTable(//{
                    abp.libs.datatables.normalizeConfiguration({
                        processing: true,
                        serverSide: true,
                        scrollX: true,
                        paging: true,
                        searching: false,
                        autoWidth: false,
                        scrollCollapse: true,
                        order: [[2, 'desc']],
                        destroy: true,
                        //ajax: abp.libs.datatables.createAjax(
                        ////volo.docs.admin.projectsAdmin.getList
                        //fih.fileManagement.files.file.getList, searchCondition
                        //),
                        ajax: {
                            url: abp.appPath + 'api/admin/files/GetList',
                            type: 'get',
                            dataType: "json",
                            data: searchCondition,
                            dataSrc: function (json) {
                                return json.items;
                            }
                        },
                        columnDefs: [{
                            title: "操作",
                            data: 'id',
                            visible: true,
                            rowAction:
                            {
                                items: [
                                    {
                                        text: l('Edit'),
                                        visible: abp.auth.isGranted(
                                            'FileManagement.Admin.Files.Update'
                                        ),
                                        action: function (data) {
                                            _editModal.open({
                                                Id: data.record.id,
                                            });
                                        },
                                    },
                                    {
                                        text: l('Delete'),
                                        visible: abp.auth.isGranted(
                                            'FileManagement.Admin.Files.Delete'
                                        ),
                                        confirmMessage: function (data) {
                                            return l('ProjectDeletionWarningMessage');
                                        },
                                        action: function (data) {
                                            volo.docs.admin.projectsAdmin
                                                .delete(data.record.id)
                                                .then(function () {
                                                    _dataTable.ajax.reload();
                                                });
                                        },
                                    },

                                ],
                            }
                        }],

                        columns: columns,
                    })
                );
 
            });
    }



});
