const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootxnkj/",
            name: "springbootxnkj",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootxnkj/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "体检中心健康体检管理系统"
        } 
    }
}
export default base
