function putAddress(form, district) {
    var province = district.substring(0, 2) + "0000";
    var city = district.substring(0, 4) + "00";
    if (province == "110000"||province == "120000"||province == "310000"||province == "500000") {//北京,天津,上海.重庆 4个直辖市
        city=province;//省级别和市级别一致的
    }


    //渲染省
    $.ajax({
        url: "/dubbo/sys/sysProvinceManager/getSysProvinces.json",
        isAysn: false,
        success: function (result) {
            var res = $.parseJSON(result);
            var options = res.data;
            var sel = $("select[name='provinceCode']");
            sel.empty();
            sel.append("<option value=''>请选择省份</option>");
            $.each(options, function (index, content) {
                if (province == content.provinceCode) {
                    sel.append("<option value='" + content.provinceCode + "' selected>" + content.provinceName + "</option>");
                } else {
                    sel.append("<option value='" + content.provinceCode + "'>" + content.provinceName + "</option>");
                }
            });
            form.render("select");
        }
    });
    /*//渲染市*/
    $.ajax({
        url: "/dubbo/sys/sysCityManager/getCitysByProvinceCode.json",
        data: {provinceCode: province},
        isAysn: false,
        success: function (result) {
            var res = $.parseJSON(result);
            var options = res.data;
            var sel = $("select[name='cityCode']");
            sel.empty();
            sel.append("<option value=''>请选择城市</option>");
            $.each(options, function (index, content) {
                if (city == content.cityCode) {
                    sel.append("<option value='" + content.cityCode + "' selected>" + content.cityName + "</option>");
                } else {
                    sel.append("<option value='" + content.cityCode + "'>" + content.cityName + "</option>");
                }
            });
            form.render("select");

        }
    });
    //渲染区
    $.ajax({
        url: "/dubbo/sys/sysDistrictManager/getCountyByCityCode.json",
        data: {cityCode: city},
        isAysn: false,
        success: function (result) {
            var res = $.parseJSON(result);
            var options = res.data;
            var sel = $("select[name='districtCode']");
            sel.empty();
            sel.append("<option value=''>请选择区县</option>");

            $.each(options, function (index, content) {
                if (district == content.districtCode) {
                    sel.append("<option value='" + content.districtCode + "' selected>" + content.districtName + "</option>");
                } else {
                    sel.append("<option value='" + content.districtCode + "'>" + content.districtName + "</option>");
                }
            });
            form.render("select");

        }
    });
}


