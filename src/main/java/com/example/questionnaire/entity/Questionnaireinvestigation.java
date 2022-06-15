package com.example.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.*;
import javafx.scene.chart.ValueAxis;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("ISMART.QUESTIONNAIREINVESTIGATION")
@KeySequence(value = "ISMART.SEQ_QUESTIONNAIREINVESTIGATION")
public class Questionnaireinvestigation {

    @TableId(value = "SID" ,type = IdType.INPUT)
    private Integer sid;
    private Date filling_date;//提交时间
    private String costomer_name;//公司名称
    private String department;//所在部门
    private Integer fra_industry_backround;//具有真实可信的行业背景
    private Integer fra_upscale;//是国内领先的中、高端线路板供应商
    private Integer fra_well_known;//是全球知名的线路板服务商
    private Integer fra_costomer_position;//能够站在客户的立场思考问题
    private Integer fra_production_quality_control;//具有完善的生产和品管体系
    private Integer fra_control_ability;//具有良好的制程控制能力
    private Integer fra_meet_requirements;//特殊工艺的生产能力完全满足贵司要求
    private Integer fra_research_development;//具有国内领先的线路板新工艺的研发能力
    private Integer fra_overall_satisfaction;//总体满意度
    private Integer fra_recommended_value;//推荐值
    private Integer fra_loyalty;//忠诚度
    private Integer fra_product_appearance;//产品外观
    private Integer fra_quality_reliability;//产品质量可靠性
    private Integer fra_quality_stability;//产品品质稳定性
    private Integer fra_material_development;//新产品/材料开发的总体满意度
    private Integer fra_development_speed;//新产品/材料开发的速度和效率
    private Integer fra_information_accuracy;//新产品/材料信息或资料传递方面的工作（比如信息传递的及时性和准确性是否有助于贵公司了解崇达的新产品信息等等）
    private Integer fra_material_satisfaction;//新产品/材料对需求的满足程度
    @TableField("fra_overall_befSales_service")
    private Integer fra_overall_befSales_service;//售前技术服务的总体满意度
    private Integer fra_ac_frequency;//产品技术交流的频率
    private Integer fra_development_requirements;//正确了解贵公司的产品开发需求
    private Integer fra_response_speed;//对贵公司产品开发过程中相关需求的响应速度
    private Integer fra_timeliness;//崇达解决产品和技术问题的时效性
    private Integer fra_technical_information;//及时向贵公司提供相关的产品和技术资料
    private Integer fra_sales_satisfaction;//销售服务的总体满意度
    private Integer fra_actual_demand;//正确了解贵公司的实际需求
    private Integer fra_demand_responsiveness;//对贵公司的需求的响应度和及时性
    private Integer fra_processing_capacity;//对业务问题的处理能力
    private Integer fra_expressive_ability;//销售人员沟通表达能力
    private Integer fra_reception_capacity;//贵公司到崇达工厂，销售人员接待能力
    private Integer fra_rationality_quotation;//报价合理性/规范性
    private Integer fra_allsupply_satisfaction;//供货环节的总体满意度
    private Integer fra_business_service_attitude;//商务负责人的服务态度
    private Integer fra_business_capability;//商务负责人的处理能力
    private Integer fra_delivery_date_setting;//交期设置
    private Integer fra_order_delivery_punctuality;//订单交货准时性
    private Integer fra_research_development_speed;//样品/研发板供货的响应速度
    private Integer fra_supply_satisfaction;//样品/研发板供货的满足程度
    @TableField("fra_all_aftSales_satisfaction")
    private Integer fra_all_aftSales_satisfaction;//售后服务的总体满意度
    private Integer fra_customer_professionalism;//客服人员专业性
    private Integer fra_customer_service_stability;//客服人员稳定性
    private Integer fra_reflection_channel;//向崇达反映问题的渠道
    private Integer fra_problem_response_speed;//崇达对问题的响应速度
    private Integer fra_tecexchange_frequency;//日常的品质技术交流频率
    private Integer fra_help_provided;//崇达给贵公司的品质改善提供了帮助
    private Integer fra_correct_errors;//纠正或预防措施（防止再次发生同样的问题）
    private Integer fra_purchase_proportion;//贵公司每年向崇达采购线路板的金额约占年度线路板采购总金额的多大比例
    private String demand_sheet;//贵公司目前需求量最大的PCB产品集中在几层板
    private String opinion_product_quality;//产品质量
    private String opinion_new_product;//新产品/材料研发
    private String opinion_presales_tecservice;//售前技术服务
    private String opinion_sales_service;//销售服务
    private String opinion_supply_link;//供货环节
    private String opinion_after_sale_service;//售后服务
    private String opinion_financial_link;//财务环节
    private String opinion_other_aspects;//其他方面
    private Integer fra_hazardous_materials;//有害物质管控的总体满意度

}
