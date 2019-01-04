package com.jhmk.model.service;

import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.bean.rule.*;
import com.jhmk.model.bean.sqlbean.*;
import com.jhmk.model.bean.sqlbean.repository.service.*;
import com.jhmk.model.util.CompareUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ziyu.zhou
 * @date 2018/12/17 10:29
 */
@Service
public class JbzdZhubiaoService {
    @Autowired
    ZlfaZhubiaoRepService zlfaZhubiaoRepService;
    @Autowired
    JbzdZhubiaoService zlfaZhubiaoService;
    @Autowired
    ZlfaModelRepService zlfaModelRepService;
    @Autowired
    ZlfaOrderModelRepService zlfaOrderModelRepService;
    @Autowired
    ZlfaSubordinationDiagnosisDetailRepService zlfaSubordinationDiagnosisDetailRepService;
    @Autowired
    ZlfaMianDiagnosisDetailRepService zlfaMianDiagnosisDetailRepService;
    @Autowired
    ZlfaUpdateDeleteModelRepService zlfaUpdateDeleteModelRepService;
    @Autowired
    ZlfaIncidentModelRepService zlfaIncidentModelRepService;

    @Autowired
    ZlfaUpdateAddModelDetailRepService zlfaUpdateAddModelDetailRepService;

//    @Transactional
//    public void saveAll(String map) {
//        ZlfaZhubiao zlfaZhubiao = JSONObject.parseObject(map, ZlfaZhubiao.class);
//        List<ZlfaModel> zlfaModelList = zlfaZhubiao.getZlfaModelList();
//        ZlfaZhubiao zhubiao = zlfaZhubiaoRepService.save(zlfaZhubiao);
//        for (ZlfaModel zlfaModel : zlfaModelList) {
//            zlfaModel.setZlfaZhubiao(zhubiao);
//            //治疗方案模型
//            ZlfaModel model = zlfaModelRepService.save(zlfaModel);
//            //治疗方案主
//            List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = model.getZlfaMianDiagnosisDetailList();
//            for (ZlfaMianDiagnosisDetail bean : zlfaMianDiagnosisDetailList) {
////                bean.setZlfnModelId(modelId);
//                bean.setZlfaModel(model);
//                //主疾病治疗方案明细
//                ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail = zlfaMianDiagnosisDetailRepService.save(bean);
//                int zlfaMianDiagnosisDetailId = zlfaMianDiagnosisDetail.getId();//主疾病治疗方案明细id
//                List<ZlfaOrderModel> zlfaOrderModelList = zlfaMianDiagnosisDetail.getZlfaOrderModelList();
//                if (zlfaOrderModelList.size() > 0) {
//                    for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
////                        zlfaOrderModel.setZlfaMianDiagnosisDetailId(zlfaMianDiagnosisDetailId);
//                    }
//                    zlfaOrderModelRepService.save(zlfaOrderModelList);
//                }
//            }
//            //主疾病治疗方案明细
//            List<ZlfaSubordinationDiagnosisDetail> zlfaSubordinationDiagnosisDetailList = model.getZlfaSubordinationDiagnosisDetailList();
//            if (zlfaSubordinationDiagnosisDetailList.size() > 0) {
//                for (ZlfaSubordinationDiagnosisDetail zlfaSubordinationDiagnosisDetail : zlfaSubordinationDiagnosisDetailList) {
//                    zlfaSubordinationDiagnosisDetail.setZlfaModel(model);
////                    zlfaSubordinationDiagnosisDetail.setZlfnModelId(modelId);
//                    ZlfaSubordinationDiagnosisDetail zlfaMianDiagnosisDetailBean = zlfaSubordinationDiagnosisDetailRepService.save(zlfaSubordinationDiagnosisDetail);
//                    List<ZlfaOrderModel> zlfaOrderModelList = zlfaSubordinationDiagnosisDetail.getZlfaOrderModelList();
//                    if (zlfaOrderModelList.size() > 0) {
//                        for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
//                            zlfaOrderModel.setZlfaSubordinationDiagnosisDetail(zlfaMianDiagnosisDetailBean);
//                        }
//                        zlfaOrderModelRepService.save(zlfaOrderModelList);
//                    }
//                }
//            }
//            //增加
//            List<ZlfaUpdateAddModel> increaseList = model.getIncreaseList();
//            if (increaseList.size() > 0) {
//                for (ZlfaUpdateAddModel zlfnUpdateAddModel : increaseList) {
//                    zlfnUpdateAddModel.setZlfaModel(zlfaModel);
//                    ZlfaUpdateAddModel zlfnUpdateAddModel1 = zlfaUpdateAddModelDetailRepService.save(zlfnUpdateAddModel);
//                    //事件模型
//                    List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateAddModel1.getZlfaIncidentModelList();
//                    for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
//                        zlfaIncidentModel.setZlfaUpdateAddModel(zlfnUpdateAddModel1);
//                    }
//                    zlfaIncidentModelRepService.save(zlfaIncidentModelList);
//                    //医嘱模型
//                    List<ZlfaOrderModel> zlfaOrderModelList = zlfnUpdateAddModel1.getZlfaOrderModelList();
//                    for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
//                        zlfaOrderModel.setZlfaUpdateAddModel(zlfnUpdateAddModel1);
//                    }
//                    zlfaOrderModelRepService.save(zlfaOrderModelList);
//                }
//            }
//            //减少
//            List<ZlfaUpdateDeleteModel> decreaseList = model.getDecreaseList();
//
//
//            for (ZlfaUpdateDeleteModel zlfnUpdateDeleteModel : decreaseList) {
//                zlfnUpdateDeleteModel.setZlfaModel(model);
//                ZlfaUpdateDeleteModel zlfnUpdateDeleteModelBean = zlfaUpdateDeleteModelRepService.save(zlfnUpdateDeleteModel);
//                //治疗方案事件模型
//                List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateDeleteModel.getZlfaIncidentModelList();
//                for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
//                    zlfaIncidentModel.setZlfaUpdateDeleteModel(zlfnUpdateDeleteModelBean);
//                }
//                zlfaIncidentModelRepService.save(zlfaIncidentModelList);
//                List<ZlfaOrderModel> zlfaOrderModelList = zlfnUpdateDeleteModel.getZlfaOrderModelList();
//                for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
//                    zlfaOrderModel.setZlfaUpdateDeleteModel(zlfnUpdateDeleteModelBean);
//                }
//                zlfaOrderModelRepService.save(zlfaOrderModelList);
//            }
//        }
//
//    }

    public BiaozhuZhubiao getBiaozhuZhubiaoResult(String map) {
        BiaozhuZhubiao zhubiao = JSONObject.parseObject(map, BiaozhuZhubiao.class);
        //鉴别诊断
        List<BiaozhuJbzdmodel> biaozhuJbzdmodelList = zhubiao.getBiaozhuJbzdmodelList();
        for (BiaozhuJbzdmodel model : biaozhuJbzdmodelList) {
            model.setBiaozhuZhubiao(zhubiao);
            //鉴别诊断原因
            List<BiaozhuJbzdcause> biaozhuJbzdcauseList = model.getBiaozhuJbzdcauseList();
            for (BiaozhuJbzdcause bean : biaozhuJbzdcauseList) {
                bean.setBiaozhuJbzdmodel(model);
                //鉴别诊断疾病特征因素
                List<BiaozhuTzysmodel> differentialDiagnosisFeatures = bean.getDifferentialDiagnosisFeatures();
                if (differentialDiagnosisFeatures.size() > 0) {
                    for (BiaozhuTzysmodel biaozhuTzysmodel : differentialDiagnosisFeatures) {
                        biaozhuTzysmodel.setDifferentialDiagnosisFeature(bean);
                    }
                }
                //患者具有的特征因素
                List<BiaozhuTzysmodel> patientFeatures = bean.getPatientFeatures();
                if (patientFeatures.size() > 0) {
                    for (BiaozhuTzysmodel biaozhuTzysmodel : patientFeatures) {
                        biaozhuTzysmodel.setPatientFeature(bean);
                    }
                }

            }
        }
        return zhubiao;

    }


    public BiaozhuZhubiao rule2ZlfaZhubiao(Rule rule) {
        BiaozhuZhubiao zhubiao = new BiaozhuZhubiao();
        String patientId = rule.getPatient_id();
        String visitId = rule.getVisit_id();
        Binganshouye binganshouye = rule.getBinganshouye();
        String rycz = rule.getRycz();
        String cyzd = rule.getCyzd();
        if (binganshouye != null) {
            zhubiao.setDoctorId(binganshouye.getPat_visit_dept_request_doctor_name());
            zhubiao.setAdmissionMainDiagnosis(rycz);
            zhubiao.setDischargeMainDiagnosis(cyzd);
            zhubiao.setDeptName(binganshouye.getDept_admission_to_name());
            zhubiao.setCreateTime(new Date());
            zhubiao.setHospitalName("北医三院");
            zhubiao.setDischargeMainDiagnosis(cyzd);
            zhubiao.setPatientId(patientId);
            zhubiao.setVisitId(visitId);
        }
        //首次病程
        Shoucibingchengjilu shoucibingchengjilu = rule.getShoucibingchengjilu();
        //诊断与鉴别诊断
        DiagnosisAndDifferentialDiagnosis diagnosisAndDifferentialDiagnosis = shoucibingchengjilu.getDiagnosisAndDifferentialDiagnosis();
        List<FirstCourseDifferentialDiagnosis> firstCourseDifferentialDiagnosisList = diagnosisAndDifferentialDiagnosis.getFirstCourseDifferentialDiagnosisList();
        //鉴别诊断模型
        List<BiaozhuJbzdmodel> biaozhuJbzdmodelList = new ArrayList<>(firstCourseDifferentialDiagnosisList.size());
        for (FirstCourseDifferentialDiagnosis differentialDiagnosis : firstCourseDifferentialDiagnosisList) {
            String differential_diagnostic_no = differentialDiagnosis.getDifferential_diagnostic_no();
        }
        return zhubiao;
    }

//    public void saveAll(String map) {
//        ZlfaZhubiao zlfaZhubiao = JSONObject.parseObject(map, ZlfaZhubiao.class);
//        List<ZlfaModel> zlfaModelList = zlfaZhubiao.getZlfaModelList();
//        ZlfaZhubiao zhubiao = zlfaZhubiaoRepService.save(zlfaZhubiao);
//        int id = zhubiao.getId();//主表id
//        for (ZlfaModel zlfaModel : zlfaModelList) {
//            zlfaModel.setZlfaZhubiao(zhubiao);
//            //治疗方案模型
//            ZlfaModel model = zlfaModelRepService.save(zlfaModel);
//            //主料方案modelId
//            int modelId = model.getId();
//            //治疗方案主
//            List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = model.getZlfaMianDiagnosisDetailList();
//            for (ZlfaMianDiagnosisDetail bean : zlfaMianDiagnosisDetailList) {
////                bean.setZlfnModelId(modelId);
//                //主疾病治疗方案明细
//                ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail = zlfaMianDiagnosisDetailRepService.save(bean);
//                int zlfaMianDiagnosisDetailId = zlfaMianDiagnosisDetail.getId();//主疾病治疗方案明细id
//                List<ZlfaOrderModel> zlfaOrderModelList = zlfaMianDiagnosisDetail.getZlfaOrderModelList();
//                if (zlfaOrderModelList.size() > 0) {
//                    for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
////                        zlfaOrderModel.setZlfaMianDiagnosisDetailId(zlfaMianDiagnosisDetailId);
//                    }
//                    zlfaOrderModelRepService.save(zlfaOrderModelList);
//                }
//            }
//            //主疾病治疗方案明细
//            List<ZlfaSubordinationDiagnosisDetail> zlfaSubordinationDiagnosisDetailList = model.getZlfaSubordinationDiagnosisDetailList();
//            if (zlfaSubordinationDiagnosisDetailList.size() > 0) {
//                for (ZlfaSubordinationDiagnosisDetail zlfaSubordinationDiagnosisDetail : zlfaSubordinationDiagnosisDetailList) {
////                    zlfaSubordinationDiagnosisDetail.setZlfnModelId(modelId);
//                    ZlfaSubordinationDiagnosisDetail zlfaMianDiagnosisDetailBean = zlfaSubordinationDiagnosisDetailRepService.save(zlfaSubordinationDiagnosisDetail);
//                    int zlfaMianDiagnosisDetailBeanId = zlfaMianDiagnosisDetailBean.getId();
//                    List<ZlfaOrderModel> zlfaOrderModelList = zlfaSubordinationDiagnosisDetail.getZlfaOrderModelList();
//                    if (zlfaOrderModelList.size() > 0) {
//                        for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
////                            zlfaOrderModel.setZlfaMianDiagnosisDetailId(zlfaMianDiagnosisDetailBeanId);
//                        }
//                        zlfaOrderModelRepService.save(zlfaOrderModelList);
//                    }
//                }
//            }
//            //增加
//            List<ZlfnUpdateAddModel> increaseList = model.getIncreaseList();
//            if (increaseList.size() > 0) {
//                for (ZlfnUpdateAddModel zlfnUpdateAddModel : increaseList) {
////                    zlfnUpdateAddModel.setZlfnModelId(modelId);
//                    ZlfnUpdateAddModel zlfnUpdateAddModel1 = zlfaUpdateAddModelDetailRepService.save(zlfnUpdateAddModel);
//                    int zlfnUpdateAddModel1Id = zlfnUpdateAddModel1.getId();
//                    //事件模型
//                    List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateAddModel1.getZlfaIncidentModelList();
//                    for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
//                        zlfaIncidentModel.setZlfnUpdateDeleteModelId(zlfnUpdateAddModel1Id);
//                    }
//                    zlfaIncidentModelRepService.save(zlfaIncidentModelList);
//                    //医嘱模型
//                    List<ZlfaOrderModel> zlfaOrderModelList = zlfnUpdateAddModel1.getZlfaOrderModelList();
//                    for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
//                        zlfaOrderModel.setZlfnUpdateDeleteModelId(zlfnUpdateAddModel1Id);
//                    }
//                    zlfaOrderModelRepService.save(zlfaOrderModelList);
//                }
//            }
//            //减少
//            List<ZlfnUpdateDeleteModel> decreaseList = model.getDecreaseList();
//
//
//            for (ZlfnUpdateDeleteModel zlfnUpdateDeleteModel : decreaseList) {
//                zlfnUpdateDeleteModel.setZlfnModelId(modelId);
//                ZlfnUpdateDeleteModel zlfnUpdateDeleteModelBean = zlfaUpdateDeleteModelRepService.save(zlfnUpdateDeleteModel);
//                int zlfnUpdateDeleteModelBeanId = zlfnUpdateDeleteModelBean.getId();
//                //治疗方案事件模型
//                List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateDeleteModel.getZlfaIncidentModelList();
//                for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
//                    zlfaIncidentModel.setZlfnUpdateDeleteModelId(zlfnUpdateDeleteModelBeanId);
//                }
//                zlfaIncidentModelRepService.save(zlfaIncidentModelList);
//                List<ZlfaOrderModel> zlfaOrderModelList = zlfnUpdateDeleteModel.getZlfaOrderModelList();
//                for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
//                    zlfaOrderModel.setZlfnUpdateDeleteModelId(zlfnUpdateDeleteModelBeanId);
//                }
//                zlfaOrderModelRepService.save(zlfaOrderModelList);
//            }
//        }
//
//    }

}