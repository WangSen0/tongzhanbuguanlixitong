var items={"achievement":1,"book":2,"deputypeople":3,"family":4,"paper":5,"parttimejob":6,"patent":7,"phenom":8,"politicalconsult":9,"politicalpart":10,
    "politicalperformence":11,"project":12,"report":13,"resume":14,"reward":15,"studyabroad":16,"training":17,"unitedpart":18,"works":19};
var type=new Array("main","achievement","book","deputypeople","family","paper","parttimejob","patent","phenom","politicalconsult","politicalpart","politicalperformence",
    "project","report","resume","reward","studyabroad","training","unitedpart","works");
function display(k) {
    for (i in type) {
        if (k == type[i]) {
            document.getElementById(k).style.display = "block";
        }
        else {
            document.getElementById(type[i]).style.display = "none";
        }
    }
}
var achievement=new Array("achievementContent");
var book=new Array("bookTitle","bookPublish");
var deputypeople=new Array("deputypeopleCountry","deputypeopleProvince","deputypeopleCity","deputypeopleCounty","deputypeopleTimes","deputypeopleStartTime","deputypeopleEndTime");
var family=new Array("familyRelation","familyName","familyBirthday","familyPoliticalStatus","familyCompany","familyPosition");
var paper=new Array("paperTitle","paperPublications","paperLevel");
var parttimejob=new Array("parttimejobContent");
var patent=new Array("patentTitle","patentType","patentAuthor");
var phenom=new Array("phenomTitle","phenomStartTime","phenomEndTime");
var politicalconsult=new Array("politicalconsultCountry","politicalconsultProvince","politicalconsultCity","politicalconsultCounty","politicalconsultTimes","politicalconsultStartTime","politicalconsultEndTime");
var politicalpart=new Array("politicalpartCountry","politicalpartProvince","politicalpartCity","politicalpartCounty","politicalpartSchool","politicalpartTimes","politicalpartPosition","politicalpartStartTime","politicalpartEndTime");
var politicalperformence=new Array("politicalperformenceContent");
var project=new Array("projectTitle","projectLevel","projectOutlay");
var report=new Array("reportTitle","reportBelong");
var resume=new Array("resumeStartTime","resumeEndTime","resumeContent");
var reward=new Array("rewardName","rewardAchievement");
var studyabroad=new Array("studyabroadStatus","studyabroadType","studyabroadPurpose","studyabroadCountry","studyabroadSchool","studyabroadGoabroadIdentity","studyabroadStudyabroadIdentity","studyabroadLimit","studyabroadLimitMonth","studyabroadStartTime","studyabroadEndTime","studyabroadRemark");
var training=new Array("trainingPlace","trainingCompany","trainingContent","trainingStartTime","trainingEndTime");
var unitedpart=new Array("unitedpartCountry","unitedpartProvince","unitedpartCity","unitedpartCounty","unitedpartSchool","unitedpartTimes","unitedpartPosition","unitedpartStartTime","unitedpartEndTime");
var works=new Array("worksTitle","worksBelong");
function closee(s) {
    document.getElementById(s+"Light").style.display='none';
    switch (items[s]){
        case 1:for(i in achievement){document.getElementById(achievement[i]).value="";}break;
        case 2:for(i in book){document.getElementById(book[i]).value="";}break;
        case 3:for(i in deputypeople){document.getElementById(deputypeople[i]).value="";}break;
        case 4:for(i in family){
            if(family[i]=='familyPoliticalStatus'){
                $("#familyPoliticalStatus").select2("val","0");
            }else{
                $("#"+family[i]+"").val("");
            }
        }break;
        case 5:for(i in paper){document.getElementById(paper[i]).value="";}break;
        case 6:for(i in parttimejob){document.getElementById(parttimejob[i]).value="";}break;
        case 7:for(i in patent){document.getElementById(patent[i]).value="";}break;
        case 8:for(i in phenom){document.getElementById(phenom[i]).value="";}break;
        case 9:for(i in politicalconsult){document.getElementById(politicalconsult[i]).value="";}break;
        case 10:for(i in politicalpart){document.getElementById(politicalpart[i]).value="";}break;
        case 11:for(i in politicalperformence){document.getElementById(politicalperformence[i]).value="";}break;
        case 12:for(i in project){document.getElementById(project[i]).value="";}break;
        case 13:for(i in report){document.getElementById(report[i]).value="";}break;
        case 14:for(i in resume){document.getElementById(resume[i]).value="";}break;
        case 15:for(i in reward){document.getElementById(reward[i]).value="";}break;
        case 16:for(i in studyabroad){document.getElementById(studyabroad[i]).value="";}break;
        case 17:for(i in training){document.getElementById(training[i]).value="";}break;
        case 18:for(i in unitedpart){document.getElementById(unitedpart[i]).value="";}break;
        case 19:for(i in works){document.getElementById(works[i]).value="";}break;
    }
}
function addd(s){
    var personId=$("#personId").val();
    if(personId==""||personId==null){
        alert("请先填写工号");
        return;
    }
    var k=s+"Count";
    var count=parseInt(document.getElementById(k).value);
    document.getElementById(k).value=count+1;
    var root=document.getElementById(s+"Table");
    var newRow=root.insertRow();
    var input100="style='width: 110px'";
    var input150="style='width: 150px'";
    var input600="style='width: 600px'";
    var input200="style='width: 200px'";

    switch (items[s]){
        case 1:{var num=0;for(i in achievement){var s1=document.getElementById(achievement[i]).value; if(s1.trim()=="")num++;} if(num==achievement.length){alert("内容不能为空！");return;} break;
        }case 2:{var num=0;for(i in book){var s1=document.getElementById(book[i]).value; if(s1.trim()=="")num++;} if(num==book.length){alert("内容不能为空！");return;} break;
        }case 3:{var num=0;for(i in deputypeople){var s1=document.getElementById(deputypeople[i]).value; if(s1.trim()=="")num++;} if(num==deputypeople.length){alert("内容不能为空！");return;} break;
        }case 4:{var num=0;for(i in family){var s1=document.getElementById(family[i]).value; if(s1.trim()=="")num++;} if(num==family.length){alert("内容不能为空！");return;} break;
        }case 5:{var num=0;for(i in paper){var s1=document.getElementById(paper[i]).value; if(s1.trim()=="")num++;} if(num==paper.length){alert("内容不能为空！");return;} break;
        }case 6:{var num=0;for(i in parttimejob){var s1=document.getElementById(parttimejob[i]).value; if(s1.trim()=="")num++;} if(num==parttimejob.length){alert("内容不能为空！");return;} break;
        }case 7:{var num=0;for(i in patent){var s1=document.getElementById(patent[i]).value; if(s1.trim()=="")num++;} if(num==patent.length){alert("内容不能为空！");return;} break;
        }case 8:{var num=0;for(i in phenom){var s1=document.getElementById(phenom[i]).value; if(s1.trim()=="")num++;} if(num==phenom.length){alert("内容不能为空！");return;} break;
        }case 9:{var num=0;for(i in politicalconsult){var s1=document.getElementById(politicalconsult[i]).value; if(s1.trim()=="")num++;} if(num==politicalconsult.length){alert("内容不能为空！");return;} break;
        }case 10:{var num=0;for(i in politicalpart){var s1=document.getElementById(politicalpart[i]).value; if(s1.trim()=="")num++;} if(num==politicalpart.length){alert("内容不能为空！");return;} break;
        }case 11:{var num=0;for(i in politicalperformence){var s1=document.getElementById(politicalperformence[i]).value; if(s1.trim()=="")num++;} if(num==politicalperformence.length){alert("内容不能为空！");return;} break;
        }case 12:{var num=0;for(i in project){var s1=document.getElementById(project[i]).value; if(s1.trim()=="")num++;} if(num==project.length){alert("内容不能为空！");return;} break;
        }case 13:{var num=0;for(i in report){var s1=document.getElementById(report[i]).value; if(s1.trim()=="")num++;} if(num==report.length){alert("内容不能为空！");return;} break;
        }case 14:{var num=0;for(i in resume){var s1=document.getElementById(resume[i]).value; if(s1.trim()=="")num++;} if(num==resume.length){alert("内容不能为空！");return;} break;
        }case 15:{var num=0;for(i in reward){var s1=document.getElementById(reward[i]).value; if(s1.trim()=="")num++;} if(num==reward.length){alert("内容不能为空！");return;} break;
        }case 16:{var num=0;for(i in studyabroad){var s1=document.getElementById(studyabroad[i]).value; if(s1.trim()=="")num++;} if(num==studyabroad.length){alert("内容不能为空！");return;} break;
        }case 17:{var num=0;for(i in training){var s1=document.getElementById(training[i]).value; if(s1.trim()=="")num++;} if(num==training.length){alert("内容不能为空！");return;} break;
        }case 18:{var num=0;for(i in unitedpart){var s1=document.getElementById(unitedpart[i]).value; if(s1.trim()=="")num++;} if(num==unitedpart.length){alert("内容不能为空！");return;} break;
        }case 19:{var num=0;for(i in works){var s1=document.getElementById(works[i]).value; if(s1.trim()=="")num++;} if(num==works.length){alert("内容不能为空！");return;} break;
    }}


    switch (items[s]){
    case 1:{for(i in achievement){var cell=newRow.insertCell();cell.innerHTML="<input "+input600+" name='"+s+"List["+count+"]."+achievement[i]+"' type='text' value='"+document.getElementById(achievement[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 2:{for(i in book){var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+book[i]+"' type='text' value='"+document.getElementById(book[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 3:{for(i in deputypeople){var text=$("#deputypeopleTimes").val();if(isNaN(text)){$(this)[0].focus();return;}
        var cell=newRow.insertCell();cell.innerHTML="<input "+input100+" name='"+s+"List["+count+"]."+deputypeople[i]+"' type='text' value='"+document.getElementById(deputypeople[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 4:{for(i in family){var cell=newRow.insertCell();cell.innerHTML="<input "+input150+" name='"+s+"List["+count+"]."+family[i]+"' type='text' value='"+document.getElementById(family[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 5:{for(i in paper){var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+paper[i]+"' type='text' value='"+document.getElementById(paper[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 6:{for(i in parttimejob){var cell=newRow.insertCell();cell.innerHTML="<input "+input600+" name='"+s+"List["+count+"]."+parttimejob[i]+"' type='text' value='"+document.getElementById(parttimejob[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 7:{for(i in patent){var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+patent[i]+"' type='text' value='"+document.getElementById(patent[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 8:{for(i in phenom){var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+phenom[i]+"' type='text' value='"+document.getElementById(phenom[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 9:{for(i in politicalconsult){var text=$("#politicalconsultTimes").val();if(isNaN(text)){$(this)[0].focus();return;}
        var cell=newRow.insertCell();cell.innerHTML="<input "+input100+" name='"+s+"List["+count+"]."+politicalconsult[i]+"' type='text' value='"+document.getElementById(politicalconsult[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 10:{for(i in politicalpart){var text=$("#politicalpartTimes").val();if(isNaN(text)){$(this)[0].focus();return;}
        var cell=newRow.insertCell();cell.innerHTML="<input "+input100+" name='"+s+"List["+count+"]."+politicalpart[i]+"' type='text' value='"+document.getElementById(politicalpart[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId'  value='"+document.getElementById('personId').value+"'/>";break;
    }case 11:{for(i in politicalperformence){var text=$("#politicalconsultTimes").val();if(isNaN(text)){$(this)[0].focus();return;}
        var cell=newRow.insertCell();cell.innerHTML="<input "+input600+" name='"+s+"List["+count+"]."+politicalperformence[i]+"' type='text' value='"+document.getElementById(politicalperformence[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 12:{for(i in project){var text=$("#projectOutlay").val();if(isNaN(text)){$(this)[0].focus();return;}
        var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+project[i]+"' type='text' value='"+document.getElementById(project[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 13:{for(i in report){var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+report[i]+"' type='text' value='"+document.getElementById(report[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 14:{for(i in resume){var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+resume[i]+"' type='text' value='"+document.getElementById(resume[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 15:{for(i in reward){var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+reward[i]+"' type='text' value='"+document.getElementById(reward[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 16:{for(i in studyabroad){var text=$("#studyabroadLimitMonth").val();if(isNaN(text)){$(this)[0].focus();return;}
        var cell=newRow.insertCell();cell.innerHTML="<input "+input100+" name='"+s+"List["+count+"]."+studyabroad[i]+"' type='text' value='"+document.getElementById(studyabroad[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 17:{for(i in training){var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+training[i]+"' type='text' value='"+document.getElementById(training[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 18:{for(i in unitedpart){var text=$("#unitedpartTimes").val();if(isNaN(text)){$(this)[0].focus();return;}
        var cell=newRow.insertCell();cell.innerHTML="<input "+input100+" name='"+s+"List["+count+"]."+unitedpart[i]+"' type='text' value='"+document.getElementById(unitedpart[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;
    }case 19:{for(i in works){var cell=newRow.insertCell();cell.innerHTML="<input "+input200+" name='"+s+"List["+count+"]."+works[i]+"' type='text' value='"+document.getElementById(works[i]).value+"'/>";}deletee();
        var cell1=newRow.insertCell();cell1.style.display="none";cell1.innerHTML="<input name='"+s+"List["+count+"].personId' type='hidden' value='"+document.getElementById('personId').value+"'/>";break;}
    }
    function deletee() {
        var cell=newRow.insertCell();
        cell.innerHTML="<input type='button' value='删除' onclick='removeRow(this.parentNode.parentNode)'/>";
    }
    closee(s);
}
function removeRow(r) {
    var root = r.parentNode;
    root.removeChild(r);
}
function addSubmit() {
    var test=$("#personId").val();
    if(test==""||test==null)
        alert("工号不能为空！");
    else{
        $("#addSubmit").submit();
    }

}