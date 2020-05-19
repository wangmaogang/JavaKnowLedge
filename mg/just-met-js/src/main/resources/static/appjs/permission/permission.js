
//父类
function PermissionCheck() {}
PermissionCheck.prototype.buttons="test";

//子类1
function Son1(){}
Son1.prototype = new PermissionCheck();

PermissionCheck.setField = function(){
    setFieldFun()
}

PermissionCheck.getField = function(){
    getFieldFun()
}

function setFieldFun(){
    var son1 = new Son1();
    son1.buttons = "modify"
}

function getFieldFun(){
    alert(PermissionCheck.prototype.buttons)
}



