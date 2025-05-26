import request from '@/utils/request'

// 查询租客信息列表
export function listProjTenantInfo(query) {
  return request({
    url: '/proj/ProjTenantInfo/list',
    method: 'get',
    params: query
  })
}

// 查询租客信息详细
export function getProjTenantInfo(tenantId) {
  return request({
    url: '/proj/ProjTenantInfo/' + tenantId,
    method: 'get'
  })
}

// 新增租客信息
export function addProjTenantInfo(data) {
  return request({
    url: '/proj/ProjTenantInfo',
    method: 'post',
    data: data
  })
}

// 修改租客信息
export function updateProjTenantInfo(data) {
  return request({
    url: '/proj/ProjTenantInfo',
    method: 'put',
    data: data
  })
}

// 删除租客信息
export function delProjTenantInfo(tenantId) {
  return request({
    url: '/proj/ProjTenantInfo/' + tenantId,
    method: 'delete'
  })
}

//执行后续操作
export function afterDo(response,proxy){
	if(response.code=='200'){
		if(response.msg=='操作成功'){
			proxy.$modal.msgSuccess()
		}else{
			proxy.$modal.msg(response.msg)
		}
	}else{
		proxy.$modal.msg(response.code)
	}
	proxy.$tab.navigateBack();
}