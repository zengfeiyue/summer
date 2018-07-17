import http from '../config/http'

export const login = (username,passworld)=>http.post('/',{username,passworld})