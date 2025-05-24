<template>
	<view class="container">


		<view class="tip">
			<text class="tip-text">请按照以下步骤填写宿舍申请信息，带</text>
			<text class="required">*</text>
			<text class="tip-text">的为必填项</text>
		</view>

		<view class="card">
			<text class="card-title">身份证信息</text>
			<view class="id-card-upload">
				<button class="upload-btn" type="primary">
					<uni-icons type="camera" size="16" color="#fff"></uni-icons>
					<text class="btn-text">扫描身份证</text>
				</button>
				<text class="upload-tip"><text class="required">*</text>请将身份证正面放入框内进行扫描</text>
			</view>

			<view class="form-group">
				<text class="form-label"><text class="required">*</text>身份证号码</text>
				<input class="form-input" type="idcard" v-model="tenant.idCard" placeholder="扫描成功自动填写" disabled />
			</view>

			<view class="form-row">
				<view class="form-col">
					<text class="form-label"><text class="required">*</text>姓名</text>
					<input class="form-input" type="text" v-model="tenant.name" placeholder="扫描成功自动填写" disabled />
				</view>
				<view class="form-col">
					<text class="form-label"><text class="required">*</text>性别</text>
					<picker mode="selector" :range="gender" range-key="name" :value="tenant.gender"
						@change="handleGenderChange">
						<view class="form-input">{{ genderText }}</view>
					</picker>
				</view>
			</view>
		</view>

		<view class="card">
			<text class="card-title">基本信息</text>
			<view class="form-group">
				<text class="form-label">手机号码</text>
				<input class="form-input" type="text" v-model="tenant.phone" />
			</view>

			<view class="form-group">
				<text class="form-label"><text class="required">*</text>入职时间</text>
				<view class="picker-wrapper">
					<picker mode="date" :value="tenant.hireDate" @change="handleHireDateChange" :start="startDate"
						:end="endDate">
						<view class="picker-value">{{ tenant.hireDate || '请选择入职时间' }}</view>
					</picker>
				</view>
			</view>

			<view class="form-group">
				<text class="form-label"><text class="required">*</text>任职部门</text>
				<view class="select-wrapper">
					<picker class="form-select" mode="selector" :range="departments" range-key="deptName"
						v-model="tenant.department">
						<view class="select-placeholder">请选择部门</view>
					</picker>
					<uni-icons type="arrowdown" size="20" color="#999"></uni-icons>
				</view>
			</view>

			<view class="form-group">
				<text class="form-label"><text class="required">*</text>岗位</text>
				<view class="select-wrapper">
					<picker class="form-select" mode="selector" :range="positions" range-key="name"
						v-model="tenant.position">
						<view class="select-placeholder">请选择岗位</view>
					</picker>
					<uni-icons type="arrowdown" size="20" color="#999"></uni-icons>
				</view>
			</view>
		</view>

		<view class="card">
			<text class="card-title">联系信息</text>
			<view class="form-group">
				<text class="form-label"><text class="required">*</text>家庭地址</text>
				<input class="form-input" type="text" v-model="tenant.address" placeholder="请输入详细家庭住址" />
			</view>

			<view class="form-group">
				<text class="form-label">车牌号码</text>
				<input class="form-input" type="idcard" v-model="tenant.licensePlate" placeholder="请输入车牌号码（如有）" />
			</view>

			<view class="form-row">
				<view class="form-col">
					<text class="form-label"><text class="required">*</text>紧急联系人</text>
					<input class="form-input" type="text" v-model="tenant.emergencyContact" placeholder="请输入姓名" />
				</view>
				<view class="form-col">
					<text class="form-label"><text class="required">*</text>紧急联系电话</text>
					<input class="form-input" type="tel" v-model="tenant.emergencyPhone" placeholder="请输入手机号码" />
				</view>
			</view>
		</view>

		<view class="card">
			<text class="card-title">申请原因</text>
			<textarea class="form-textarea" v-model="tenant.applyReason" placeholder="请简要说明申请宿舍的原因..."
				maxlength="200"></textarea>
			<text class="textarea-tip">最多可输入200字</text>
		</view>

		<view class="footer">
			<button class="submit-btn" type="primary" @click="submitForm()">提交申请</button>
		</view>
	</view>
</template>

<script setup>
	import {
		ref,
		getCurrentInstance
	} from 'vue';
	import {
		addProjTenantInfo,
		updateProjTenantInfo,
		afterDo
	} from "@/api/dormitory/dormitory-application.js"
	import {
		listDept
	} from "@/api/dept.js"
	
	const {
		proxy
	} = getCurrentInstance()

	// 可选：设置最小和最大日期范围
	const startDate = ref('1990-01-01');
	const endDate = ref('2030-12-31');
	const genderText = ref('男');

	function handleHireDateChange(e) {
		const date = new Date(e.detail.value);
		const year = date.getFullYear();
		const month = (date.getMonth() + 1).toString().padStart(2, '0');
		const day = date.getDate().toString().padStart(2, '0');
		tenant.value.hireDate = `${year}-${month}-${day}`;
	}

	function handleGenderChange(e) {
		tenant.value.gender = e.detail.value
		genderText.value = gender.value[e.detail.value].name
	}



	const departments = ref([]);
	listDept().then(response => {
		departments.value = response.data
	})
	

	const positions = ref([{
			id: 1,
			name: '前端开发工程师'
		},
		{
			id: 2,
			name: 'UI设计师'
		},
		{
			id: 3,
			name: '产品经理'
		},
		{
			id: 4,
			name: '人力资源专员'
		},
		{
			id: 5,
			name: '财务主管'
		}
	]);

	const gender = ref([{
		id: 1,
		name: '男'
	}, {
		id: 2,
		name: '女'
	}, {
		id: 3,
		name: '未知'
	}])

	const tenant = ref({
		tenantId: null,
		userId: null,
		idCard: null,
		name: null,
		phone: null,
		email: null,
		address: null,
		createTime: null,
		updateTime: null,
		isDeleted: null,
		deleteTime: null,
		gender: '1',
		age: null,
		birthday: null,
		ethnicity: null,
		education: null,
		company: null,
		hireDate: null,
		leaveDate: null,
		avatar: null,
		isEmployed: null,
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
		applyReason: null,
		renewalReason: null,
		statue: null
	});

	/** 提交校验 */
	function validateForm() {
		const requiredFields = [
			'idCard',
			'name',
			'phone',
			'hireDate',
			'department',
			'position',
			'address',
			'emergencyContact',
			'emergencyPhone',
			'applyReason'
		];
		for (const field of requiredFields) {
			if (!tenant.value[field]) {
				uni.showToast({
					title: `请填写${fieldLabelMap[field]}`,
					icon: 'none'
				});
				return false;
			}
		}
		return true;
	}

	/** 提交按钮 */
	function submitForm() {
		if (!validateForm()) return;

		if (tenant.value.tenantId != null) {
			updateProjTenantInfo(tenant.value).then(response => {
				afterDo(response, proxy)
			})
		} else {
			addProjTenantInfo(tenant.value).then(response => {
				afterDo(response, proxy)
			})
		}
	}
</script>

<style>
	page {
		height: 100%;
		background-color: #f5f5f5;
	}

	.container {
		padding: 16rpx 24rpx 120rpx;
	}

	.header {
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding: 20rpx 0;
		position: sticky;
		top: 0;
		background-color: #fff;
		z-index: 10;
	}

	.header-title {
		font-size: 36rpx;
		font-weight: bold;
		color: #333;
	}

	.tip {
		display: flex;
		align-items: center;
		margin-bottom: 32rpx;
		font-size: 24rpx;
		color: #666;
	}

	.required {
		color: #f56c6c;
		margin: 0 4rpx;
	}

	.card {
		background-color: #fff;
		border-radius: 16rpx;
		padding: 32rpx;
		margin-bottom: 24rpx;
		box-shadow: 0 2rpx 16rpx rgba(0, 0, 0, 0.05);
	}

	.card-title {
		font-size: 32rpx;
		font-weight: 600;
		margin-bottom: 32rpx;
		color: #333;
	}

	.id-card-upload {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		padding: 60rpx 0;
		border: 2rpx dashed #ddd;
		border-radius: 16rpx;
		margin-bottom: 32rpx;
	}

	.upload-btn {
		display: flex;
		align-items: center;
		justify-content: center;
		width: 300rpx;
		height: 80rpx;
		border-radius: 8rpx;
	}

	.btn-text {
		margin-left: 12rpx;
		font-size: 28rpx;
		color: #fff;
	}

	.upload-tip {
		font-size: 24rpx;
		color: #999;
		margin-top: 24rpx;
	}

	.form-group {
		margin-bottom: 32rpx;
	}

	.form-row {
		display: flex;
		justify-content: space-between;
		margin-bottom: 32rpx;
	}

	.form-col {
		width: 48%;
	}

	.form-label {
		display: block;
		font-size: 28rpx;
		color: #333;
		margin-bottom: 16rpx;
	}

	.form-input {
		width: 100%;
		height: 80rpx;
		padding: 0 24rpx;
		border: 1px solid #e0e0e0;
		border-radius: 8rpx;
		background-color: #f9f9f9;
		font-size: 28rpx;
		color: #333;
		display: flex;
		align-items: center;
	}

	.date-picker,
	.select-wrapper {
		position: relative;
	}

	.date-picker uni-icons,
	.select-wrapper uni-icons {
		position: absolute;
		right: 20rpx;
		top: 50%;
		transform: translateY(-50%);
	}

	.form-select {
		width: 100%;
		height: 80rpx;
		padding: 0 24rpx;
		border: 1px solid #e0e0e0;
		border-radius: 8rpx;
		background-color: #f9f9f9;
		font-size: 28rpx;
		color: #333;
		display: flex;
		align-items: center;
	}

	.select-placeholder {
		color: #999;
	}

	.form-textarea {
		width: 100%;
		height: 200rpx;
		padding: 24rpx;
		border: 1px solid #e0e0e0;
		border-radius: 8rpx;
		background-color: #f9f9f9;
		font-size: 28rpx;
		color: #333;
	}

	.textarea-tip {
		font-size: 24rpx;
		color: #999;
		margin-top: 12rpx;
	}

	.footer {
		position: fixed;
		bottom: 0;
		left: 0;
		right: 0;
		padding: 24rpx;
		background-color: #fff;
		box-shadow: 0 -2rpx 16rpx rgba(0, 0, 0, 0.05);
	}

	.submit-btn {
		width: 100%;
		height: 96rpx;
		border-radius: 8rpx;
		font-size: 32rpx;
	}

	.picker-wrapper {
		position: relative;
		width: 100%;
	}

	.picker-wrapper .picker-value {
		height: 80rpx;
		line-height: 80rpx;
		padding: 0 24rpx;
		border: 1px solid #e0e0e0;
		border-radius: 8rpx;
		background-color: #f9f9f9;
		font-size: 28rpx;
		color: #333;
	}

	.picker-wrapper uni-icons {
		position: absolute;
		right: 20rpx;
		top: 50%;
		transform: translateY(-50%);
	}
</style>