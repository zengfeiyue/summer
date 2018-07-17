import config from './http.config'
import axios from 'axios'
import store from '../store/index'

axios.defaults.baseURL=config.baseUrl

axios.interceptors.request.use(function (config) {
  let token=store.state.token||sessionStorage.token
  if(token){
    config.headers['token']=token
  }
  // 在发送请求之前做些什么
  return config;
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error);
});

// 添加响应拦截器
axios.interceptors.response.use(function (response) {
  if(response.status!==200) {
    return {
      msg:response.statusText,
      error:response.status
    }
  }
  // 对响应数据做点什么
 
  return response;
}, function (error) {
  // 对响应错误做点什么
  return Promise.reject(error);
});

function requestError(promise,msg){
  return Promise.reject({
    error:msg
  })
}

function timeoutRequest(promise,msg){
  store.user.dispatch('clearToken')
  return Promise.reject({
    error:msg
  })
}

const HTTPREQUEST={
  timeout:100000,
}

function get(url,params){
  return axios({
    url,
    ...HTTPREQUEST,
    method: 'GET',
    params: {
      ...params
    }
  }).then(res=>{

    return res
  }).catch(error=>{
    return error
  })
}

function post(url,params){
  return axios({
    url,
    ...HTTPREQUEST,
    method:'POST',
    data:{...params}
  }).then((res)=>{
    return res
  }).catch(error=>{
    return error
  })
}

function all (arr,fn) {
  return axios.all(arr)
    .then(axios.spread(fn))
}


export default {
  get,
  post,
  all
}
