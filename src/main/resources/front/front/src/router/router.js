import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import canjianrenyuanList from '../pages/canjianrenyuan/list'
import canjianrenyuanDetail from '../pages/canjianrenyuan/detail'
import canjianrenyuanAdd from '../pages/canjianrenyuan/add'
import tijianyishiList from '../pages/tijianyishi/list'
import tijianyishiDetail from '../pages/tijianyishi/detail'
import tijianyishiAdd from '../pages/tijianyishi/add'
import tijiantaocanList from '../pages/tijiantaocan/list'
import tijiantaocanDetail from '../pages/tijiantaocan/detail'
import tijiantaocanAdd from '../pages/tijiantaocan/add'
import tijianyuyueList from '../pages/tijianyuyue/list'
import tijianyuyueDetail from '../pages/tijianyuyue/detail'
import tijianyuyueAdd from '../pages/tijianyuyue/add'
import tijianjinchengList from '../pages/tijianjincheng/list'
import tijianjinchengDetail from '../pages/tijianjincheng/detail'
import tijianjinchengAdd from '../pages/tijianjincheng/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'canjianrenyuan',
					component: canjianrenyuanList
				},
				{
					path: 'canjianrenyuanDetail',
					component: canjianrenyuanDetail
				},
				{
					path: 'canjianrenyuanAdd',
					component: canjianrenyuanAdd
				},
				{
					path: 'tijianyishi',
					component: tijianyishiList
				},
				{
					path: 'tijianyishiDetail',
					component: tijianyishiDetail
				},
				{
					path: 'tijianyishiAdd',
					component: tijianyishiAdd
				},
				{
					path: 'tijiantaocan',
					component: tijiantaocanList
				},
				{
					path: 'tijiantaocanDetail',
					component: tijiantaocanDetail
				},
				{
					path: 'tijiantaocanAdd',
					component: tijiantaocanAdd
				},
				{
					path: 'tijianyuyue',
					component: tijianyuyueList
				},
				{
					path: 'tijianyuyueDetail',
					component: tijianyuyueDetail
				},
				{
					path: 'tijianyuyueAdd',
					component: tijianyuyueAdd
				},
				{
					path: 'tijianjincheng',
					component: tijianjinchengList
				},
				{
					path: 'tijianjinchengDetail',
					component: tijianjinchengDetail
				},
				{
					path: 'tijianjinchengAdd',
					component: tijianjinchengAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
