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
            projectName: "健康体检中心预约与提醒系统"
        } 
    }
}
export default base
