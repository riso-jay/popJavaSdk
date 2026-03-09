# 本地API文档

此目录包含从在线API文档站点下载的本地副本，便于离线查看。

## 文件结构

```
docs/api/
├── index.html                    # API文档主页
├── static/                       # 静态资源
│   └── assets/
│       └── img/
│           └── icon/
│               └── logo.svg      # 站点图标
├── openService/                  # API服务文档
│   ├── CategoryAPI.html          # WOP类目API
│   ├── CisInvChannelQueryAPI.html # CIS渠道库存查询API
│   ├── PdcBrandService.html      # WOP品牌同步API
│   ├── PdcDecItemErpService.html # ERP商品同步服务
│   ├── WmReportingService.html   # WOP外部报表接口
│   ├── WopBigOrderService.html   # WOP大订单服务
│   ├── WopJitOrderPopService.html # 云仓JIT订单服务
│   ├── WopJitxOrderPopService.html # 云仓JITX订单服务
│   ├── WopOrderEventService.html # WOP订单事件服务
│   ├── WopOuterInvReturnOrderService.html # WOP退供单服务
│   ├── WopOuterOrderBackService.html # 客退单接口服务
│   ├── WopOuterOrderService.html # WOP外部订单接口
│   ├── WopOuterPoService.html    # WOP入库单PO服务
│   ├── WopOuterTransferService.html # WOP仓间调拨单服务
│   └── WopOutterHtOrderService.html # WOP海淘订单服务
└── README.md                    # 本文档
```

## 使用方法

您可以直接在浏览器中打开这些HTML文件来查看API文档：

- `index.html` - API文档主页，列出所有可用的服务
- `openService/WopOuterPoService.html` - WOP入库单PO服务详细文档
- `openService/WmReportingService.html` - WOP外部报表接口详细文档
- `openService/WopBigOrderService.html` - WOP大订单服务详细文档
- `openService/CisInvChannelQueryAPI.html` - CIS渠道库存查询API详细文档
- `openService/CategoryAPI.html` - WOP类目API详细文档
- `openService/PdcBrandService.html` - WOP品牌同步API详细文档
- `openService/PdcDecItemErpService.html` - ERP商品同步服务详细文档
- `openService/WopJitOrderPopService.html` - 云仓JIT订单服务详细文档
- `openService/WopJitxOrderPopService.html` - 云仓JITX订单服务详细文档
- `openService/WopOrderEventService.html` - WOP订单事件服务详细文档
- `openService/WopOuterInvReturnOrderService.html` - WOP退供单服务详细文档
- `openService/WopOuterOrderBackService.html` - 客退单接口服务详细文档
- `openService/WopOuterOrderService.html` - WOP外部订单接口详细文档
- `openService/WopOuterTransferService.html` - WOP仓间调拨单服务详细文档
- `openService/WopOutterHtOrderService.html` - WOP海淘订单服务详细文档

## 更新说明

要更新本地文档副本，您可以重新运行下载命令：

```bash
# 更新主页
curl -s -L "https://56.pjbest.com/app/wx/doc/index" -o "docs/api/index.html"

# 更新特定服务文档
curl -s -L "https://56.pjbest.com/app/wx/doc/openService?defCode=4102&serviceName=WopOuterPoService" -o "docs/api/openService/WopOuterPoService.html"
```

## 注意事项

- 本地文档为特定时间点的快照，可能与在线版本存在差异
- 如需最新文档，请访问原始URL
- 仅用于开发参考，不得用于商业用途