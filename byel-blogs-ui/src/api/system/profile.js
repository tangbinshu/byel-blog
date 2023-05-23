import request from '@/utils/request'



export function login(data) {
  return request({
    url: '/users/login',
    method: 'post',
    data: {
      data
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/users/info',
    method: 'get',
    params: { token }
  })
}

export function logout(token) {
  return request({
    url: '/users/logout',
    method: 'get',
    params: { token }
  })
}
