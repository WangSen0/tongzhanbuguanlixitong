/**
 * Created by Administrator on 2017/10/18.
 */
var sex=[{id:'男',text:'男'},{id:'女',text:'女'}]
var gatq=[{id:'台联',text:'台联'},{id:'侨联',text:'侨联'}]
var nation=[{id:'汉族',text:'汉族'},{id:'壮族',text:'壮族'},{id:'满族',text:'满族'},{id:'回族',text:'回族'},{id:'苗族',text:'苗族'},{id:'维吾尔族',text:'维吾尔族'},{id:'土家族',text:'土家族'},{id:'彝族',text:'彝族'},{id:'蒙古族',text:'蒙古族'},
    {id:'藏族',text:'藏族'},{id:'布依族',text:'布依族'},{id:'侗族',text:'侗族'},{id:'瑶族',text:'瑶族'},{id:'朝鲜族',text:'朝鲜族'},{id:'白族',text:'白族'},{id:'哈尼族',text:'哈尼族'},{id:'哈萨克族',text:'哈萨克族'},{id:'黎族',text:'黎族'},
    {id:'傣族',text:'傣族'},{id:'畲族',text:'畲族'},{id:'傈僳族',text:'傈僳族'},{id:'仡佬族',text:'仡佬族'},{id:'东乡族',text:'东乡族'},{id:'高山族',text:'高山族'},{id:'拉祜族',text:'拉祜族'},{id:'水族',text:'水族'},{id:'佤族',text:'佤族'},
    {id:'纳西族',text:'纳西族'},{id:'羌族',text:'羌族'},{id:'土族',text:'土族'},{id:'仫佬族',text:'仫佬族'},{id:'锡伯族',text:'锡伯族'},{id:'柯尔克孜族',text:'柯尔克孜族'},{id:'达斡尔族',text:'达斡尔族'},{id:'景颇族',text:'景颇族'},{id:'毛南族',text:'毛南族'},
    {id:'撒拉族',text:'撒拉族'},{id:'塔吉克族',text:'塔吉克族'},{id:'阿昌族',text:'阿昌族'},{id:'普米族',text:'普米族'},{id:'鄂温克族',text:'鄂温克族'},{id:'怒族',text:'怒族'},{id:'京族',text:'京族'},{id:'基诺族',text:'基诺族'},{id:'德昂族',text:'德昂族'},
    {id:'保安族',text:'保安族'},{id:'俄罗斯族',text:'俄罗斯族'},{id:'裕固族',text:'裕固族'},{id:'乌兹别克族',text:'乌兹别克族'},{id:'门巴族	',text:'门巴族	'},{id:'伦春族',text:'伦春族'},{id:'独龙族',text:'独龙族'},{id:'塔塔尔族',text:'塔塔尔族'},{id:'赫哲族',text:'赫哲族'},
    {id:'珞巴族',text:'珞巴族'},{id:'布朗族',text:'布朗族'}]
var politicalStatus=[{id:"中国共产党党员",text:"中国共产党党员"},{id:"中国共产党预备党员",text:"中国共产党预备党员"},{id:"共青团员",text:"共青团员"},{id:"中国国民党革命委员会会员",text:"中国国民党革命委员会会员"},{id:"中国民主同盟盟员",text:"中国民主同盟盟员"},{id:"中国民主建国会会员",text:"中国民主建国会会员"},{id:"中国民主促进会会员",text:"中国民主促进会会员"},
    {id:"农工党党员",text:"农工党党员"},{id:"致公党党员",text:"致公党党员"},{id:"九三学社社员",text:"九三学社社员"},{id:"台盟盟员",text:"台盟盟员"},{id:"无党派民主人士",text:"无党派民主人士"},{id:"群众",text:"群众"}]
var highestEducation=[{id:"初中",text:"初中"},{id:"中等专业学校",text:"中等专业学校"},{id:"高中",text:"高中"},{id:"大学专科",text:"大学专科"},{id:"大学本科",text:"大学本科"},{id:"硕士研究生",text:"硕士研究生"},{id:"研究生",text:"研究生"},{id:"博士研究生",text:"博士研究生"}]
var highestDegree=[{id:"无学位",text:"无学位"},{id:"学士",text:"学士"},{id:"硕士",text:"硕士"},{id:"博士",text:"博士"}]
var maritalStatus=[{id:"已婚",text:"已婚"},{id:"未婚",text:"未婚"}]
var fullTimeEducation=[{id:"中等专业学校",text:"中等专业学校"},{id:"高中",text:"高中"},{id:"大学专科",text:"大学专科"},{id:"大学本科",text:"大学本科"},{id:"硕士研究生",text:"硕士研究生"},{id:"博士研究生",text:"博士研究生"}];
var partTimeEducation=[{id:"中等专业学校",text:"中等专业学校"},{id:"高中",text:"高中"},{id:"大学专科",text:"大学专科"},{id:"大学本科",text:"大学本科"},{id:"硕士研究生",text:"硕士研究生"},{id:"博士研究生",text:"博士研究生"}];
var residencePermitAbroadStatus=[{id:"有",text:"有"},{id:"无",text:"无"}]
var staffStatus=[{id:'教辅人员',text:'教辅人员'},{id:'专任教师',text:'专任教师'},{id:'工勤人员',text:'工勤人员'},{id:'行政人员',text:'行政人员'},{id:'其它附属机构人员',text:'其它附属机构人员'}]
var currentStatus=[{id:'在职',text:'在职'},{id:'调出',text:'调出'},{id:'开除',text:'开除'},{id:'退休',text:'退休'},{id:'退养',text:'退养'},{id:'辞职',text:'辞职'},{id:'自动离职',text:'自动离职'},{id:'调出未办手续',text:'调出未办手续'},{id:'解除合同',text:'解除合同'},{id:'死亡',text:'死亡'}]
var positionLevel=[{id:'初级',text:'初级'},{id:'中级',text:'中级'},{id:'副高级',text:'副高级'},{id:'正高级',text:'正高级'}]
var stationLevel=[{id:"初级岗位一级",text:"初级岗位一级"},{id:"初级岗位二级",text:"初级岗位二级"},{id:"初级岗位三级",text:"初级岗位三级"},{id:"中级岗位一级",text:"中级岗位一级"},{id:"中级岗位二级",text:"中级岗位二级"},{id:"中级岗位三级",text:"中级岗位三级"},{id:"副高级岗位一级",text:"副高级岗位一级"},{id:"副高级岗位二级",text:"副高级岗位二级"},{id:"副高级岗位三级",text:"副高级岗位三级"},{id:"正高级岗位一级",text:"正高级岗位一级"},{id:"正高级岗位二级",text:"正高级岗位二级"},{id:"正高级岗位三级",text:"正高级岗位三级"},{id:"正高级岗位四级",text:"正高级岗位四级"}]
var staffLevel=[{id:'未定级',text:'未定级'},{id:'1级职员',text:'1级职员'},{id:'2级职员',text:'2级职员'},{id:'3级职员',text:'3级职员'},{id:'4级职员',text:'4级职员'},{id:'5级职员',text:'5级职员'},{id:'6级职员',text:'6级职员'},{id:'7级职员',text:'7级职员'},{id:'8级职员',text:'8级职员'},{id:'9级职员',text:'9级职员'}]
var outparttraining=[{id:"参政议政",text:"参政议政"},{id:"党派后备",text:"党派后备"},{id:"学术骨干",text:"学术骨干"},{id:"党外干部后备",text:"党外干部后备"}]
var currentStatus=[{id:"在职",text:"在职"},{id:"退休",text:"退休"}]


