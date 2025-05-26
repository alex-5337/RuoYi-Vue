<!-- 代码已包含 CSS：使用 TailwindCSS , 安装 TailwindCSS 后方可看到布局样式效果 -->
<template>
	<div class="container">
		<div class="tip">
			<span class="tip-text">请按照以下步骤填写宿舍申请信息，带</span>
			<span class="required">*</span>
			<span class="tip-text">的为必填项</span>
		</div>

		<el-card class="card">
			<h2 class="card-title">身份证信息</h2>
			<div class="id-card-upload">
				<el-button class="upload-btn" type="primary">
					<el-icon :size="16" color="#fff">
						<Camera />
					</el-icon>
					<span class="btn-text">扫描身份证</span>
				</el-button>
				<p class="upload-tip">请将身份证正面放入框内进行扫描</p>
			</div>

			<div class="form-group">
				<label class="form-label required">身份证号码<em class="required">*</em></label>
				<el-input class="form-input" placeholder="扫描后自动填写" v-model="queryParams.idCard" />
			</div>

			<div class="form-row">
				<div class="form-col">
					<label class="form-label required">姓名<em class="required">*</em></label>
					<el-input class="form-input" placeholder="扫描后自动填写" v-model="queryParams.name" />
				</div>
				<div class="form-col">
					<label class="form-label required">性别<em class="required">*</em></label>
					<el-select class="form-input" v-model="queryParams.gender">
						<el-option v-for="dict in sys_user_sex" :key="dict.dictValue" :label="dict.dictLabel"
							:value="dict.dictValue" />
					</el-select>
				</div>
			</div>
		</el-card>

		<el-card class="card">
			<h2 class="card-title">基本信息</h2>
			<div class="form-group">
				<label class="form-label">手机号码</label>
				<el-input class="form-input" v-model="queryParams.phone" />
			</div>

			<div class="form-group">
				<label class="form-label required">入职时间<em class="required">*</em></label>
				<el-date-picker class="form-input" type="date" v-model="queryParams.hireDate" />
			</div>

			<div class="form-group">
				<label class="form-label required">所在部门<em class="required">*</em></label>
				<el-tree-select v-model="queryParams.department" :data="departments"
					:props="{ value: 'deptId', label: 'deptName', children: 'children' }" value-key="deptId"
					placeholder="选择公司" check-strictly clearable style="min-width:200px;" />
			</div>


			<!-- <div class="form-group">
				<label class="form-label required">岗位<em class="required">*</em></label>
				<div class="select-wrapper">
					<el-select class="form-select" placeholder="请选择岗位" v-model="queryParams.position">
						<el-option v-for="item in positions" :key="item.id" :label="item.name" :value="item.id" />
					</el-select>
					<el-icon :size="20" color="#999">
						<ArrowDown />
					</el-icon>
				</div>
			</div> -->
		</el-card>

		<el-card class="card">
			<h2 class="card-title">联系信息</h2>
			<div class="form-group">
				<label class="form-label required">家庭地址<em class="required">*</em></label>
				<el-input class="form-input" placeholder="请输入详细家庭住址" v-model="queryParams.address" />
			</div>

			<div class="form-group">
				<label class="form-label">车牌号码</label>
				<el-input class="form-input" placeholder="请输入车牌号码（如有）" v-model="queryParams.licensePlate" />
			</div>

			<div class="form-row">
				<div class="form-col">
					<label class="form-label required">紧急联系人<em class="required">*</em></label>
					<el-input class="form-input" placeholder="请输入姓名" v-model="queryParams.emergencyContact" />
				</div>
				<div class="form-col">
					<label class="form-label required">紧急联系电话<em class="required">*</em></label>
					<el-input class="form-input" placeholder="请输入手机号码" type="tel"
						v-model="queryParams.emergencyPhone" />
				</div>
			</div>
		</el-card>

		<el-card class="card">
			<h2 class="card-title">申请原因</h2>
			<el-input class="form-textarea" type="textarea" placeholder="请简要说明申请宿舍的原因..." :maxlength="200" :rows="4"
				v-model="queryParams.applyReason" />
			<p class="textarea-tip">最多可输入200字</p>
		</el-card>

		<div class="footer" style="display: flex; gap: 10px;">
			<!-- <el-button class="cache-btn btn-size" type="warning" @click="handleCache">缓存</el-button> -->
			<el-button class="submit-btn btn-size" type="primary" @click="handleSubmit">提交</el-button>
		</div>
	</div>
</template>

<script lang="ts" setup>
	import { ref, watch, getCurrentInstance } from 'vue';
	import { Camera } from '@element-plus/icons-vue';
	import { getUserProfile } from '@/api/system/user';
	import { getDicts } from '@/api/system/dict/data';
	import { listDept } from '@/api/dept'
	import { arrayToTree } from '@/utils/treeUtil'
	import { updateProjTenantInfo, addProjTenantInfo, afterDo } from '@/api/proj/dormitory/dormitory-application'

	const { proxy } = getCurrentInstance()
	const queryParams = ref({
		tenantId: null,
		userId: null,
		idCard: null,
		name: null,
		phone: null,
		email: null,
		address: null,
		isDeleted: 'N',
		deleteTime: null,
		gender: null,
		age: null,
		birthday: null,
		ethnicity: null,
		education: null,
		company: null,
		hireDate: null,
		leaveDate: null,
		avatar: null,
		isEmployed: 'Y',
		leaveReason: null,
		resignationCert: null,
		department: null,
		position: null,
		jobLevel: null,
		employeeId: null,
		creator: null,
		modifier: null,
		licensePlate: null,
		emergencyContact: null,
		emergencyPhone: null,
		maritalStatus: null,
		contactAddress: null,
		entryTime: null,
		applyReason: '',
		renewalReason: null,
		statue: '发起申请'
	})

	const sys_user_sex = ref([])
	const departments = ref([]);
	// const positions = ref([
	// 	{ id: 1, name: '前端开发工程师' },
	// 	{ id: 2, name: 'UI设计师' },
	// 	{ id: 3, name: '产品经理' },
	// 	{ id: 4, name: '人力资源专员' },
	// 	{ id: 5, name: '财务主管' },
	// ]);

	// const handleCache = () => {
	// 	// 缓存表单数据到本地存储中，键名为 'formData'，值为 queryParams.value 对象
	// 	localStorage.setItem('formData', JSON.stringify(queryParams.value));
	// }
	
	const handleSubmit = () => {
		if(queryParams.value.tenantId == null){
			addProjTenantInfo(queryParams.value).then(response => {
				localStorage.removeItem('formData')
				//afterDo(response, proxy)
			})
		}else{
			updateProjTenantInfo(queryParams.value).then(response => {
				afterDo(response, proxy)
			})
		}	
	}
	function getQueryParams() {
		// 从本地存储中获取 'formData' 键值
		const formData = localStorage.getItem('formData');
		// 如果 'formData' 键值存在，则将其解析为 JSON 对象并赋值给 queryParams.value 对象
		if (formData) {
			queryParams.value = JSON.parse(formData);
		} else {
			// 调用 getUserProfile 方法获取用户个人信息，当请求成功后执行回调函数
			getUserProfile().then(response => {
				queryParams.value.userId = response.data.userId;
				//queryParams.value.company = response.data.dept.ancestors.split(',')[0] || '0';
				queryParams.value.department = response.data.deptId;
				queryParams.value.phone = response.data.phonenumber;
				queryParams.value.gender = response.data.sex;
				queryParams.value.name = response.data.nickName;
				queryParams.value.hireDate = response.data.createTime;
				// console.log(queryParams.value.userId)
			})

			// 调用 getDicts 方法获取系统用户性别字典数据，当请求成功后执行回调函数
			getDicts('sys_user_sex').then(response => {
				sys_user_sex.value = response.data
			})

			// 调用 listDept 方法获取部门列表数据，当请求成功后执行回调函数
			listDept().then(response => {
				departments.value = arrayToTree(response.data, {
					idKey: 'deptId',
					parentKey: 'parentId',
					childrenKey: 'children'
				})
			})
		}
	}

	getQueryParams()

	// 监听 queryParams.value 对象的变化，当值发生变化时执行回调函数
	watch(queryParams.value, (newValue, oldValue) => {
		// 缓存表单数据到本地存储中，键名为 'formData'，值为 queryParams.value 对象
		localStorage.setItem('formData', JSON.stringify(queryParams.value));
	})
</script>

<style scoped>
	.container {
		padding: 8px 12px 60px;
		max-width: 375px;
		margin: 0 auto;
	}

	.header {
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding: 10px 0;
		position: sticky;
		top: 0;
		background-color: #fff;
		z-index: 10;
	}

	.header-title {
		font-size: 18px;
		font-weight: bold;
		color: #333;
		margin: 0;
	}

	.tip {
		display: flex;
		align-items: center;
		margin-bottom: 16px;
		font-size: 12px;
		color: #666;
	}

	.required {
		color: #f56c6c;
		margin: 0 2px;
	}

	.card {
		margin-bottom: 12px;
	}

	.card-title {
		font-size: 16px;
		font-weight: 600;
		margin-bottom: 16px;
		color: #333;
	}

	.id-card-upload {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		padding: 30px 0;
		border: 1px dashed #ddd;
		border-radius: 8px;
		margin-bottom: 16px;
	}

	.upload-btn {
		display: flex;
		align-items: center;
		justify-content: center;
		width: 150px;
		height: 40px;
	}

	.btn-text {
		margin-left: 6px;
		font-size: 14px;
	}

	.upload-tip {
		font-size: 12px;
		color: #999;
		margin-top: 12px;
	}

	.form-group {
		margin-bottom: 16px;
	}

	.form-row {
		display: flex;
		justify-content: space-between;
		margin-bottom: 16px;
	}

	.form-col {
		width: 48%;
	}

	.form-label {
		display: block;
		font-size: 14px;
		color: #333;
		margin-bottom: 8px;
	}

	.form-input {
		width: 100%;
	}

	.date-picker,
	.select-wrapper {
		position: relative;
	}

	.date-picker .el-icon,
	.select-wrapper .el-icon {
		position: absolute;
		right: 10px;
		top: 50%;
		transform: translateY(-50%);
		z-index: 2;
	}

	.form-textarea {
		width: 100%;
	}

	:deep(.el-date-editor.el-input) {
		width: 100%;
	}

	.textarea-tip {
		font-size: 12px;
		color: #999;
		margin-top: 6px;
	}

	.footer {
		position: fixed;
		bottom: 0;
		left: 0;
		right: 0;
		padding: 12px;
		background-color: #fff;
		box-shadow: 0 -1px 8px rgba(0, 0, 0, 0.05);
	}

	.cache-btn,
	.submit-btn {
		width: 100%;
		height: 48px;
		font-size: 16px;
	}

	.container[data-v-e8bcc958] {
		padding: 8px 12px 72px;
		/* 修改了这里 */
		max-width: 375px;
		margin: 0 auto;
	}
</style>