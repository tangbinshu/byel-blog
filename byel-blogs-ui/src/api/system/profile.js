import request from '@/utils/request'



export function login(user) {
  return request({
    url: '/users/login',
    method: 'post',
    data: {
      user
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
export function register(user) {
  return request({
    url: '/users/register',
    method: 'post',
    data: {
      user
    }
  })
}
