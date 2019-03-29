var menus = [
	{
        id: "01",
        text: "测试",
        icon: "fa fa-tags",
        children: [
            {
                id: "0110",
                text: "测试管理",
                icon: "fa fa-registered",
                url: "page/sys.sysMenu/sysMenu.html",
                targetType: "iframe-tab"
            }
        ]
    },
    {
        id: "10",
        text: "商品信息",
        icon: "fa fa-tags",
        children: [
            {
                id: "1010",
                text: "商品品牌管理",
                icon: "fa fa-registered",
                url: "page/commodity.brand/brand.html",
                targetType: "iframe-tab"
            },
            {
                id: "1020",
                text: "商品车车型配置",
                url: "page/commodity.vehiclemodel/vehicle_model.html",
                targetType: "iframe-tab",
                icon: "fa fa-steam"
            },
            {
                id: "1030",
                text: "商品车外观色管理",
                url: "page/commodity.exteriorcolor/exterior_color.html",
                targetType: "iframe-tab",
                icon: "fa fa-circle-o"
            },
            {
                id: "1040",
                text: "商品车内饰色管理",
                url: "page/commodity.interiorcolor/interior_color.html",
                targetType: "iframe-tab",
                icon: "fa fa-dot-circle-o"
            },
            {
                id: "1050",
                text: "随车备品信息维护",
                url: "page/commodity.accessory/accessory.html",
                targetType: "iframe-tab",
                icon: "fa fa-fire-extinguisher"
            },
            {
                id: "1060",
                text: "随车备品套装管理",
                url: "page/commodity.accessorygroup/accessory_group.html",
                targetType: "iframe-tab",
                icon: "fa fa-archive"
            }
        ]
    },
    {
        id: "15",
        text: "货主信息",
        icon: "fa fa-cube",
        children: [
            {
                id: "1510",
                text: "货主信息维护",
                url: "page/consignor.consignorinfo/consignor_info.html",
                targetType: "iframe-tab",
                icon: "fa fa-dropbox"
            }
        ]
    },
    {
        id: "20",
        text: "收货方信息",
        icon: "fa fa-user-circle",
        children: [
            {
                id: "2010",
                text: "收货方信息维护",
                url: "/page/cmdp.cmpCustomer/cmpCustomer.html",
                targetType: "iframe-tab",
                icon: "fa fa-address-book-o"
            }
        ]
    },
    {
        id: "25",
        text: "承运商信息",
        icon: "fa fa-car",
        children: [
            {
                id: "2510",
                text: "平台承运商信息维护",
                url: "page/carrier.carrierinfo/carrier_info.html",
                targetType: "iframe-tab",
                icon: "fa fa-rocket"
            },
            {
                id: "2513",
                text: "承运商外部关系维护",
                url: "page/carrier.carrierrelation/carrierrelation.html",
                targetType: "iframe-tab",
                icon: "fa fa-link"
            },
            {
                id: "2516",
                text: "承运商外部关系",
                url: "page/carrier.carrierrelationlist/carrierrelationlist.html",
                targetType: "iframe-tab",
                icon: "fa fa-handshake-o"
            },
            {
                id: "2520",
                text: "组织结构维护",
                // url: "page/carrier.carrierorg/carrier_org.html",
                url: "page/finance/financeorg/finance_org.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "2523",
                text: "平台查看组织结构",
                url: "page/carrier.carrierorgview/carrier_org_view.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "2530",
                text: "运输车辆备案",
                url: "page/carrier.truck/truck.html",
                targetType: "iframe-tab",
                icon: "fa fa-book"
            },
            {
                id: "2540",
                text: "司机备案",
                url: "page/carrier.driver/driver.html",
                targetType: "iframe-tab",
                icon: "fa fa-user-circle-o"
            },
            {
                id: "2550",
                text: "运输车辆司机匹配",
                url: "page/carrier.truckdriver/truckdriver.html",
                targetType: "iframe-tab",
                icon: "fa fa-truck"
            },
            {
                id: "2560",
                text: "运输车辆维修保养",
                url: "page/carrier.maintenance/maintenance.html",
                targetType: "iframe-tab",
                icon: "fa fa-gears"
            },
            {
                id: "2561",
                text: "运输车辆年检",
                url: "page/carrier.inspection/inspection.html",
                targetType: "iframe-tab",
                icon: "fa fa-industry"
            },
            {
                id: "2562",
                text: "运输车辆保险",
                url: "page/carrier.insurance/insurance.html",
                targetType: "iframe-tab",
                icon: "fa fa-life-ring"
            },
            {
                id: "2563",
                text: "违章信息查询",
                url: "page/carrier.offences/offences.html",
                targetType: "iframe-tab",
                icon: "fa fa-exclamation-triangle"
            },
            {
                id: "2590",
                text: "一键救援信息备案",
                url: "page/tsc.tspSuccor/tspSuccor.html",
                targetType: "iframe-tab",
                icon: "fa fa-ambulance"
            }
        ]
    },
    {
        id: "30",
        text: "订单管理",
        icon: "fa fa-file-text-o",
        children: [
            {
                id: "3010",
                text: "我的订单汇总",
                url: "page/order/myorder/my_order.html",
                targetType: "iframe-tab",
                icon: "fa fa-paste"
            },
            {
                id: "3020",
                text: "订单信息列表",
                url: "page/order/myorder_list_info/my_order_list.html",
                targetType: "iframe-tab",
                icon: "fa fa-paste"
            },
            {
                id: "3030",
                text: "订单详情列表",
                url: "page/order/myorder_list/my_order_list.html",
                targetType: "iframe-tab",
                icon: "fa fa-paste"
            }
        ]
    },
    {
        id: "35",
        text: "调度配载",
        icon: "fa fa-bullhorn",
        children: [
            {
                id: "3510",
                text: "调度任务(驻场)",
                url: "page/dispatch/dispatchtask_factroy/dispatch_task.html",
                targetType: "iframe-tab",
                icon: "fa fa-tasks"
            }, {
                id: "3511",
                text: "订单调度(承运商)",
                url: "page/dispatch/orderDispatch/orderDispatch.html",
                targetType: "iframe-tab",
                icon: "fa fa-tasks"
            }, {
                id: "3512",
                text: "任务调度(承运商)",
                url: "page/dispatch/taskDispatch/taskDispatch.html",
                targetType: "iframe-tab",
                icon: "fa fa-tasks"
            }
        ]
    },
    {
        id: "40",
        text: "仓储管理",
        icon: "fa fa-bank",
        children: [
            {
                id: "4010",
                text: "仓库信息备案",
                url: "page/warehouse/warehouseinfo/warehouse_info.html",
                targetType: "iframe-tab",
                icon: "fa fa-book"
            },
            // {
            //     id: "4020",
            //     text: "货主库管理",
            //     url: "page/warehouse/bhmctmpwarehouse/bhmc_tmp_warehouse.html",
            //     targetType: "iframe-tab",
            //     icon: "fa fa-building"
            // },
            {
                id: "4030",
                text: "入库管理",
                url: "page/warehouse/stockin/stockin.html",
                targetType: "iframe-tab",
                icon: "fa fa-sign-in"
            },
            {
                id: "4040",
                text: "出库管理",
                url: "page/warehouse/stockout/stockout.html",
                targetType: "iframe-tab",
                icon: "fa fa-sign-out"
            },
            {
                id: "4050",
                text: "库存管理",
                url: "page/warehouse/stockmanager/stockmanager.html",
                targetType: "iframe-tab",
                icon: "fa fa-sign-out"
            },
            {
                id: "4060",
                text: "库存汇总",
                url: "page/warehouse/stockmanager/stockmanager_list.html",
                targetType: "iframe-tab",
                icon: "fa fa-sign-out"
            },
            {
                id: "4070",
                text: "待入库车辆导入",
                url: "page/whs.whsWaitinbound/whsWaitinbound.html",
                targetType: "iframe-tab",
                icon: "fa fa-sign-out"
            }
            /* {
             id: "4070",
             text: "库存汇总2",
             url: "page/warehouse/stockmanager/stockmanager_list2.html",
             targetType: "iframe-tab",
             icon: "fa fa-sign-out"
             },*/
            // {
            //     id: "4060",
            //     text: "库存管理temp",
            //     url: "page/warehouse/stockmanagertemp/stockmanager.html",
            //     targetType: "iframe-tab",
            //     icon: "fa fa-sign-out"
            // }
        ]
    },
    {
        id: "41",
        text: "运力管理",
        icon: "fa fa-soundcloud",
        children: [
            {
                id: "4130",
                text: "运输车辆备案",
                url: "page/tsc.tscTruck/tscTruck.html",
                targetType: "iframe-tab",
                icon: "fa fa-book"
            },
            {
                id: "4140",
                text: "司机备案",
                url: "page/tsc.tscDriver/tscDriver.html",
                targetType: "iframe-tab",
                icon: "fa fa-user-circle-o"
            },
            {
                id: "4144",
                text: "司机排行榜",
                url: "page/carrier.driverlist/driver_list.html",
                targetType: "iframe-tab",
                icon: "fa fa-user-circle-o"
            },
            {
                id: "4150",
                text: "运输车辆司机匹配",
                url: "page/carrier.truckdriver/truckdriver.html",
                targetType: "iframe-tab",
                icon: "fa fa-truck"
            },
            {
                id: "4392",
                text: "车头挂车匹配",
                url: "page/carrier.headstock/headstockMatching.html",
                targetType: "iframe-tab",
                icon: "fa fa-truck"
            },
            {
                id: "4250",
                text: "运力管理",
                url: "page/carrier.capacitymag/capacity_management.html",
                targetType: "iframe-tab",
                icon: "fa fa-truck"
            },
            {
                id: "4160",
                text: "运输车辆维修保养",
                url: "page/carrier.maintenance/maintenance.html",
                targetType: "iframe-tab",
                icon: "fa fa-gears"
            },
            {
                id: "4161",
                text: "运输车辆年检",
                url: "page/carrier.inspection/inspection.html",
                targetType: "iframe-tab",
                icon: "fa fa-industry"
            },
            {
                id: "4162",
                text: "运输车辆保险",
                url: "page/tsc.tscTruckinsurance/tscTruckinsurance.html",
                targetType: "iframe-tab",
                icon: "fa fa-life-ring"
            },
            {
                id: "4163",
                text: "违章信息查询",
                url: "page/carrier.offences/offences.html",
                targetType: "iframe-tab",
                icon: "fa fa-exclamation-triangle"
            }
        ]
    },
    {
        id: "42",
        text: "云盒管理",
        icon: "fa fa-soundcloud",
        children: [
            {
                id: "4210",
                text: "云盒设备备案",
                url: "page/carrier.obd/obd.html",
                targetType: "iframe-tab",
                icon: "fa fa-soundcloud"
            }
        ]
    },
    {
        id: "45",
        text: "运输监控",
        icon: "fa fa-truck",
        children: []
    },
    {
        id: "50",
        text: "服务评价",
        icon: "fa fa-thumbs-up",
        children: []
    },
    {
        id: "55",
        text: "结算激励",
        icon: "fa fa-credit-card-alt",
        children: [
            {
                id: "65",
                text: "单价里程维护",
                url: "page/balance.pricemileage/price_mileage.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "75",
                text: "运单上传",
                url: "page/balance.orderupload/order_upload.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "85",
                text: "运单审核",
                url: "page/balance.orderauditing/orderauditing_list.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "90",
                text: "手动对账明细",
                url: "page/balance.checkdetailManually/detail_manually_by_order.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "95",
                text: "收款明细确认",
                url: "page/balance.checkdetail/check_detail_list.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "105",
                text: "付款明细确认",
                url: "page/balance.checkdetail_consignor/check_detail_list.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "115",
                text: "额外费用记录",
                url: "page/balance.extracostrecord/extracost_list.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "125",
                text: "月度损益报表",
                url: "page/balance.monthlyGainsLosses/monthlyGainsLosses.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            },
            {
                id: "130",
                text: "司机积分（平台）",
                url: "page/balance.driverIntegral/TheDriverIntegral.html",
                targetType: "iframe-tab",
                icon: "fa fa-sitemap"
            }
        ]
    },
    {
        id: "60",
        text: "报表中心",
        icon: "fa fa-bar-chart",
        children: []
    },
    {
        id: "90",
        text: "系统管理",
        icon: "fa fa-desktop",
        children: [
            {
                id: "9010",
                text: "菜单图标管理",
                icon: "fa fa-circle-o-notch",
                url: "page/system.menuicon/menu_icon.html",
                targetType: "iframe-tab"
            },
            {
                id: "9020",
                text: "通用代码管理",
                icon: "fa fa-file-code-o",
                url: "page/sys.codemap/codemap.html",
                targetType: "iframe-tab"
            },
            {
                id: "9030",
                text: "公司信息管理",
                url: "page/system.companyinfo/company_info.html",
                targetType: "iframe-tab",
                icon: "fa fa-cc"
            },
            {
                id: "9033",
                text: "我的平台信息(公司)",
                url: "page/sys.sysInfo/my_company_info.html",
                targetType: "iframe-tab",
                icon: "fa fa-user-o"
            },
            {
                id: "9034",
                text: "我的平台信息(个人)",
                url: "page/sys.sysInfo/my_personal_info.html",
                targetType: "iframe-tab",
                icon: "fa fa-user-o"
            },
            {
                id: "9036",
                text: "注册用户审核",
                url: "page/system.userapproval/user_approval.html",
                targetType: "iframe-tab",
                icon: "fa fa-gavel"
            },
            {
                id: "9040",
                text: "公司管理员管理",
                url: "page/system.companyadmin/company_admin.html",
                targetType: "iframe-tab",
                icon: "fa fa-user-plus"
            },
            {
                id: "9050",
                text: "公司权限模板管理",
                url: "page/system.authoritytemplet/authority_templet.html",
                targetType: "iframe-tab",
                icon: "fa fa-book"
            },
            {
                id: "9060",
                text: "公司权限管理",
                url: "page/system.companyauthority/company_authority.html",
                targetType: "iframe-tab",
                icon: "fa fa-hand-stop-o"
            },
            {
                id: "9070",
                text: "用户管理",
                url: "page/system.user/user.html",
                targetType: "iframe-tab",
                icon: "fa fa-address-card"
            },
            {
                id: "9079",
                text: "角色模板管理",
                url: "page/system.roletemplet/role_templet.html",
                targetType: "iframe-tab",
                icon: "fa fa-user-secret"
            },
            {
                id: "9080",
                text: "角色管理",
                url: "page/system.role/role.html",
                targetType: "iframe-tab",
                icon: "fa fa-user-secret"
            }, {
                id: "9090",
                text: "短信管理",
                icon: "fa fa-commenting-o",
                url: "page/system.messageinfo/messageinfo.html",
                targetType: "iframe-tab"
            }, {
                id: "90A0",
                text: "登录日志",
                icon: "fa fa-file-text",
                url: "page/system.loginlog/login_log.html",
                targetType: "iframe-tab"
            }, {
                id: "90B0",
                text: "操作日志",
                icon: "fa fa-file-o",
                url: "page/system.optionlog/option_log.html",
                targetType: "iframe-tab"
            }
        ]
    }
];