vjo.needs("unknown.Name");
vjo.ctype("defect.D1573")
.protos({
    
    //> String state
    state:null,
    //> protected void setState(String s)
    setState:function(s){
        this.state=s;
    },
    //> protected String getState()
    getState:function(){
        return this.state;
    }
});