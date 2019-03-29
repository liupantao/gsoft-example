$(function () {
    initCarrierName();
});


//初始化页面的时候,把物流公司的下拉进行填充
function initCarrierName() {
    $.ajax({
        //isAysn: true,
        url: "/dubbo/tsc/tscTruckinsuranceManager/getCompCarrier.json",
        success: function (result) {
            var $carrierName = $(".carrierName");
            var result = JSON.parse(result);
            var options = result.data;
            $carrierName.empty();
            $carrierName.append("<option value=''>请选择</option>");
            $.each(options, function (index, content) {
                $carrierName.append("<option value='" + content.id + "'>" + content.carrierName + "</option>");
            });
        }
    });
}

//当前公司下的部门
function initDepartName(carriedId, form) {
    $.ajax({

        url: "/dubbo/tsc/tscTruckinsuranceManager/getDepartment.json?carrierId=" + carriedId,
        success: function (result) {
            var $departmentName = $(".departmentName");
            var result = JSON.parse(result);
            var options = result.data;
            $departmentName.empty();
            $departmentName.append("<option value=''>请选择</option>");

            $.each(options, function (index, content) {
                $departmentName.append("<option value='" + content.id + "'>" + content.name + "</option>");
            });
            form.render("select");
        }
    });
}