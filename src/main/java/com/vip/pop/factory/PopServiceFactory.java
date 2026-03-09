package com.vip.pop.factory;

import com.pjbest.cis.service.*;
import com.pjbest.pdc.service.*;
import com.pjbest.wop.wm.service.*;
import com.vip.pop.BaseService;
import com.vip.wop.app.jit.service.WopJitOrderPopService;
import com.vip.wop.app.jit.service.WopJitxOrderPopService;

/**
 * POP SDK服务工厂类
 * 提供各种服务实例的创建和管理
 */
public class PopServiceFactory {

	// 单例模式 - 基础服务
	private static volatile BaseService baseService;

    // 单例模式 - 仓储报表服务
    private static volatile WmReportingService wmReportingService;
    
    // 单例模式 - 外部订单服务
    private static volatile WopOuterOrderService wopOuterOrderService;
    
    // 单例模式 - 入库单PO服务
    private static volatile WopOuterPoService wopOuterPoService;
    
    // 单例模式 - CIS渠道库存查询API
    private static volatile CisInvChannelQueryAPI cisInvChannelQueryAPI;
    
    // 单例模式 - 类目API
    private static volatile CategoryAPI categoryAPI;
    
    // 单例模式 - 大订单服务
    private static volatile WopBigOrderService wopBigOrderService;
    
    // 单例模式 - 退供单服务
    private static volatile WopOuterInvReturnOrderService wopOuterInvReturnOrderService;
    
    // 单例模式 - 订单事件服务
    private static volatile WopOrderEventService wopOrderEventService;
    
    // 单例模式 - 仓间调拨单服务
    private static volatile WopOuterTransferService wopOuterTransferService;
    
    // 单例模式 - ERP商品同步服务
    private static volatile PdcDecItemErpService pdcDecItemErpService;
    
    // 单例模式 - 客退单服务
    private static volatile WopOuterOrderBackService wopOuterOrderBackService;
    
    // 单例模式 - 品牌同步服务
    private static volatile PdcBrandService pdcBrandService;
    
    // 单例模式 - 海淘订单服务
    private static volatile WopOutterHtOrderService wopOutterHtOrderService;
    
    // 单例模式 - JIT订单服务
    private static volatile WopJitOrderPopService wopJitOrderPopService;
    
    // 单例模式 - JITX订单服务
    private static volatile WopJitxOrderPopService wopJitxOrderPopService;

	/**
	 * 获取基础服务实例（单例）
	 *
	 * @return BaseService实例
	 */
	public static BaseService getBaseService() {
		if (baseService == null) {
			synchronized (PopServiceFactory.class) {
				if (baseService == null) {
					baseService = new BaseService();
				}
			}
		}
		return baseService;
	}

    /**
     * 获取仓储报表服务实例（单例）
     * 
     * @return WmReportingService实例
     */
    public static WmReportingService getWmReportingService() {
        if (wmReportingService == null) {
            synchronized (PopServiceFactory.class) {
                if (wmReportingService == null) {
                    wmReportingService = new WmReportingService();
                }
            }
        }
        return wmReportingService;
    }

    /**
     * 获取外部订单服务实例（单例）
     * 
     * @return WopOuterOrderService实例
     */
    public static WopOuterOrderService getWopOuterOrderService() {
        if (wopOuterOrderService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopOuterOrderService == null) {
                    wopOuterOrderService = new WopOuterOrderService();
                }
            }
        }
        return wopOuterOrderService;
    }

    /**
     * 创建新的仓储报表服务实例
     * 
     * @return 新的WmReportingService实例
     */
    public static WmReportingService createWmReportingService() {
        return new WmReportingService();
    }

    /**
     * 创建新的外部订单服务实例
     * 
     * @return 新的WopOuterOrderService实例
     */
    public static WopOuterOrderService createWopOuterOrderService() {
        return new WopOuterOrderService();
    }

    /**
     * 获取入库单PO服务实例（单例）
     * 
     * @return WopOuterPoService实例
     */
    public static WopOuterPoService getWopOuterPoService() {
        if (wopOuterPoService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopOuterPoService == null) {
                    wopOuterPoService = new WopOuterPoService();
                }
            }
        }
        return wopOuterPoService;
    }

    /**
     * 创建新的入库单PO服务实例
     * 
     * @return 新的WopOuterPoService实例
     */
    public static WopOuterPoService createWopOuterPoService() {
        return new WopOuterPoService();
    }

    // ==================== CIS渠道库存查询API ====================
    
    /**
     * 获取CIS渠道库存查询API实例（单例）
     * 
     * @return CisInvChannelQueryAPI实例
     */
    public static CisInvChannelQueryAPI getCisInvChannelQueryAPI() {
        if (cisInvChannelQueryAPI == null) {
            synchronized (PopServiceFactory.class) {
                if (cisInvChannelQueryAPI == null) {
                    cisInvChannelQueryAPI = new CisInvChannelQueryAPI();
                }
            }
        }
        return cisInvChannelQueryAPI;
    }

    /**
     * 创建新的CIS渠道库存查询API实例
     * 
     * @return 新的CisInvChannelQueryAPI实例
     */
    public static CisInvChannelQueryAPI createCisInvChannelQueryAPI() {
        return new CisInvChannelQueryAPI();
    }

    // ==================== 类目API ====================
    
    /**
     * 获取类目API实例（单例）
     * 
     * @return CategoryAPI实例
     */
    public static CategoryAPI getCategoryAPI() {
        if (categoryAPI == null) {
            synchronized (PopServiceFactory.class) {
                if (categoryAPI == null) {
                    categoryAPI = new CategoryAPI();
                }
            }
        }
        return categoryAPI;
    }

    /**
     * 创建新的类目API实例
     * 
     * @return 新的CategoryAPI实例
     */
    public static CategoryAPI createCategoryAPI() {
        return new CategoryAPI();
    }

    // ==================== 大订单服务 ====================
    
    /**
     * 获取大订单服务实例（单例）
     * 
     * @return WopBigOrderService实例
     */
    public static WopBigOrderService getWopBigOrderService() {
        if (wopBigOrderService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopBigOrderService == null) {
                    wopBigOrderService = new WopBigOrderService();
                }
            }
        }
        return wopBigOrderService;
    }

    /**
     * 创建新的大订单服务实例
     * 
     * @return 新的WopBigOrderService实例
     */
    public static WopBigOrderService createWopBigOrderService() {
        return new WopBigOrderService();
    }

    // ==================== 退供单服务 ====================
    
    /**
     * 获取退供单服务实例（单例）
     * 
     * @return WopOuterInvReturnOrderService实例
     */
    public static WopOuterInvReturnOrderService getWopOuterInvReturnOrderService() {
        if (wopOuterInvReturnOrderService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopOuterInvReturnOrderService == null) {
                    wopOuterInvReturnOrderService = new WopOuterInvReturnOrderService();
                }
            }
        }
        return wopOuterInvReturnOrderService;
    }

    /**
     * 创建新的退供单服务实例
     * 
     * @return 新的WopOuterInvReturnOrderService实例
     */
    public static WopOuterInvReturnOrderService createWopOuterInvReturnOrderService() {
        return new WopOuterInvReturnOrderService();
    }

    // ==================== 订单事件服务 ====================
    
    /**
     * 获取订单事件服务实例（单例）
     * 
     * @return WopOrderEventService实例
     */
    public static WopOrderEventService getWopOrderEventService() {
        if (wopOrderEventService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopOrderEventService == null) {
                    wopOrderEventService = new WopOrderEventService();
                }
            }
        }
        return wopOrderEventService;
    }

    /**
     * 创建新的订单事件服务实例
     * 
     * @return 新的WopOrderEventService实例
     */
    public static WopOrderEventService createWopOrderEventService() {
        return new WopOrderEventService();
    }

    // ==================== 仓间调拨单服务 ====================
    
    /**
     * 获取仓间调拨单服务实例（单例）
     * 
     * @return WopOuterTransferService实例
     */
    public static WopOuterTransferService getWopOuterTransferService() {
        if (wopOuterTransferService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopOuterTransferService == null) {
                    wopOuterTransferService = new WopOuterTransferService();
                }
            }
        }
        return wopOuterTransferService;
    }

    /**
     * 创建新的仓间调拨单服务实例
     * 
     * @return 新的WopOuterTransferService实例
     */
    public static WopOuterTransferService createWopOuterTransferService() {
        return new WopOuterTransferService();
    }

    // ==================== ERP商品同步服务 ====================
    
    /**
     * 获取ERP商品同步服务实例（单例）
     * 
     * @return PdcDecItemErpService实例
     */
    public static PdcDecItemErpService getPdcDecItemErpService() {
        if (pdcDecItemErpService == null) {
            synchronized (PopServiceFactory.class) {
                if (pdcDecItemErpService == null) {
                    pdcDecItemErpService = new PdcDecItemErpService();
                }
            }
        }
        return pdcDecItemErpService;
    }

    /**
     * 创建新的ERP商品同步服务实例
     * 
     * @return 新的PdcDecItemErpService实例
     */
    public static PdcDecItemErpService createPdcDecItemErpService() {
        return new PdcDecItemErpService();
    }

    // ==================== 客退单服务 ====================
    
    /**
     * 获取客退单服务实例（单例）
     * 
     * @return WopOuterOrderBackService实例
     */
    public static WopOuterOrderBackService getWopOuterOrderBackService() {
        if (wopOuterOrderBackService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopOuterOrderBackService == null) {
                    wopOuterOrderBackService = new WopOuterOrderBackService();
                }
            }
        }
        return wopOuterOrderBackService;
    }

    /**
     * 创建新的客退单服务实例
     * 
     * @return 新的WopOuterOrderBackService实例
     */
    public static WopOuterOrderBackService createWopOuterOrderBackService() {
        return new WopOuterOrderBackService();
    }

    // ==================== 品牌同步服务 ====================
    
    /**
     * 获取品牌同步服务实例（单例）
     * 
     * @return PdcBrandService实例
     */
    public static PdcBrandService getPdcBrandService() {
        if (pdcBrandService == null) {
            synchronized (PopServiceFactory.class) {
                if (pdcBrandService == null) {
                    pdcBrandService = new PdcBrandService();
                }
            }
        }
        return pdcBrandService;
    }

    /**
     * 创建新的品牌同步服务实例
     * 
     * @return 新的PdcBrandService实例
     */
    public static PdcBrandService createPdcBrandService() {
        return new PdcBrandService();
    }

    // ==================== 海淘订单服务 ====================
    
    /**
     * 获取海淘订单服务实例（单例）
     * 
     * @return WopOutterHtOrderService实例
     */
    public static WopOutterHtOrderService getWopOutterHtOrderService() {
        if (wopOutterHtOrderService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopOutterHtOrderService == null) {
                    wopOutterHtOrderService = new WopOutterHtOrderService();
                }
            }
        }
        return wopOutterHtOrderService;
    }

    /**
     * 创建新的海淘订单服务实例
     * 
     * @return 新的WopOutterHtOrderService实例
     */
    public static WopOutterHtOrderService createWopOutterHtOrderService() {
        return new WopOutterHtOrderService();
    }

    // ==================== JIT订单服务 ====================
    
    /**
     * 获取JIT订单服务实例（单例）
     * 
     * @return WopJitOrderPopService实例
     */
    public static WopJitOrderPopService getWopJitOrderPopService() {
        if (wopJitOrderPopService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopJitOrderPopService == null) {
                    wopJitOrderPopService = new WopJitOrderPopService();
                }
            }
        }
        return wopJitOrderPopService;
    }

    /**
     * 创建新的JIT订单服务实例
     * 
     * @return 新的WopJitOrderPopService实例
     */
    public static WopJitOrderPopService createWopJitOrderPopService() {
        return new WopJitOrderPopService();
    }

    // ==================== JITX订单服务 ====================
    
    /**
     * 获取JITX订单服务实例（单例）
     * 
     * @return WopJitxOrderPopService实例
     */
    public static WopJitxOrderPopService getWopJitxOrderPopService() {
        if (wopJitxOrderPopService == null) {
            synchronized (PopServiceFactory.class) {
                if (wopJitxOrderPopService == null) {
                    wopJitxOrderPopService = new WopJitxOrderPopService();
                }
            }
        }
        return wopJitxOrderPopService;
    }

    /**
     * 创建新的JITX订单服务实例
     * 
     * @return 新的WopJitxOrderPopService实例
     */
    public static WopJitxOrderPopService createWopJitxOrderPopService() {
        return new WopJitxOrderPopService();
    }

    /**
     * 重置所有服务实例（用于测试）
     */
    public static void resetServices() {
        wmReportingService = null;
        wopOuterOrderService = null;
        wopOuterPoService = null;
        cisInvChannelQueryAPI = null;
        categoryAPI = null;
        wopBigOrderService = null;
        wopOuterInvReturnOrderService = null;
        wopOrderEventService = null;
        wopOuterTransferService = null;
        pdcDecItemErpService = null;
        wopOuterOrderBackService = null;
        pdcBrandService = null;
        wopOutterHtOrderService = null;
        wopJitOrderPopService = null;
        wopJitxOrderPopService = null;
    }
}