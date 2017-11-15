var XtIto = XtIto || {REVISION: '01'};

XtIto.Scene = function() {
    this.name = "王";
    this.age = 10;
    console.log("内部打印 " + this.name + " : " + this.age);
};

XtIto.Print = function() {
    this.Scene = new XtIto.Scene();

    this.setScene = function(Scene) {
        this.Scene = Scene;
    };

    this.print = function() {
        console.log("Print: " + this.Scene.name + "  :  " + this.Scene.age);
    }
};

var Update = {
    Setting: function() {
        this.name = "王";
        this.age = 10;
        console.log("内部打印 " + this.name + " : " + this.age);
    },

    Print: function() {
        this.Setting = new Update.Setting();
        this.setSetting = function(Setting) {
            this.Setting = Setting;
        };
        this.print = function() {
            console.log("PrintSetting: " + this.Setting.name + "  :  " + this.Setting.age);
        }
    }
};