<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户ID"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="idCard">
        <el-input
          v-model="queryParams.idCard"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入地址"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否删除" prop="isDeleted">
        <el-select v-model="queryParams.isDeleted" placeholder="请选择是否删除" clearable style="min-width: 100px;">
          <el-option
            v-for="dict in sys_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="删除时间" prop="deleteTime">
        <el-date-picker clearable
          v-model="queryParams.deleteTime"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择删除时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable style="min-width: 100px;">
          <el-option
            v-for="dict in sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生日" prop="birthday">
        <el-date-picker clearable
          v-model="queryParams.birthday"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择生日">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="民族" prop="ethnicity">
        <el-input
          v-model="queryParams.ethnicity"
          placeholder="请输入民族"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学历" prop="education">
        <el-input
          v-model="queryParams.education"
          placeholder="请输入学历"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工作单位" prop="company">
        <el-input
          v-model="queryParams.company"
          placeholder="请输入工作单位"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入职时间" prop="hireDate">
        <el-date-picker clearable
          v-model="queryParams.hireDate"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择入职时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="离职时间" prop="leaveDate">
        <el-date-picker clearable
          v-model="queryParams.leaveDate"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择离职时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="头像" prop="avatar">
        <el-input
          v-model="queryParams.avatar"
          placeholder="请输入头像"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否在职" prop="isEmployed">
        <el-select v-model="queryParams.isEmployed" placeholder="请选择是否在职" clearable style="min-width: 100px;">
          <el-option
            v-for="dict in sys_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="离职证明" prop="resignationCert">
        <el-input
          v-model="queryParams.resignationCert"
          placeholder="请输入离职证明"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所在部门" prop="department">
        <el-input
          v-model="queryParams.department"
          placeholder="请输入所在部门"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="岗位" prop="position">
        <el-input
          v-model="queryParams.position"
          placeholder="请输入岗位"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职级" prop="jobLevel">
        <el-input
          v-model="queryParams.jobLevel"
          placeholder="请输入职级"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工号" prop="employeeId">
        <el-input
          v-model="queryParams.employeeId"
          placeholder="请输入工号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建人" prop="creator">
        <el-input
          v-model="queryParams.creator"
          placeholder="请输入创建人"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改人" prop="modifier">
        <el-input
          v-model="queryParams.modifier"
          placeholder="请输入修改人"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车牌号" prop="licensePlate">
        <el-input
          v-model="queryParams.licensePlate"
          placeholder="请输入车牌号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急联系人" prop="emergencyContact">
        <el-input
          v-model="queryParams.emergencyContact"
          placeholder="请输入紧急联系人"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急联系人电话" prop="emergencyPhone">
        <el-input
          v-model="queryParams.emergencyPhone"
          placeholder="请输入紧急联系人电话"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="婚姻状况" prop="maritalStatus">
        <el-select v-model="queryParams.maritalStatus" placeholder="请选择婚姻状况" clearable style="min-width: 100px;">
          <el-option
            v-for="dict in sys_marriage"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="联系地址" prop="contactAddress">
        <el-input
          v-model="queryParams.contactAddress"
          placeholder="请输入联系地址"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入行时间" prop="entryTime">
        <el-date-picker clearable
          v-model="queryParams.entryTime"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择入行时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['proj:ProjTenantInfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['proj:ProjTenantInfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['proj:ProjTenantInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['proj:ProjTenantInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ProjTenantInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="租客ID" align="center" prop="tenantId" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="身份证号" align="center" prop="idCard" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="手机号" align="center" prop="phone" />
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="是否删除" align="center" prop="isDeleted">
        <template #default="scope">
          <dict-tag :options="sys_yes_no" :value="scope.row.isDeleted"/>
        </template>
      </el-table-column>
      <el-table-column label="删除时间" align="center" prop="deleteTime" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.deleteTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="性别" align="center" prop="gender">
        <template #default="scope">
          <dict-tag :options="sys_user_sex" :value="scope.row.gender"/>
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="生日" align="center" prop="birthday" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="民族" align="center" prop="ethnicity" />
      <el-table-column label="学历" align="center" prop="education" />
      <el-table-column label="工作单位" align="center" prop="company" />
      <el-table-column label="入职时间" align="center" prop="hireDate" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.hireDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="离职时间" align="center" prop="leaveDate" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.leaveDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="头像" align="center" prop="avatar" />
      <el-table-column label="是否在职" align="center" prop="isEmployed">
        <template #default="scope">
          <dict-tag :options="sys_yes_no" :value="scope.row.isEmployed"/>
        </template>
      </el-table-column>
      <el-table-column label="离职原因" align="center" prop="leaveReason" />
      <el-table-column label="离职证明" align="center" prop="resignationCert" />
      <el-table-column label="所在部门" align="center" prop="department" />
      <el-table-column label="岗位" align="center" prop="position" />
      <el-table-column label="职级" align="center" prop="jobLevel" />
      <el-table-column label="工号" align="center" prop="employeeId" />
      <el-table-column label="创建人" align="center" prop="creator" />
      <el-table-column label="修改人" align="center" prop="modifier" />
      <el-table-column label="车牌号" align="center" prop="licensePlate" />
      <el-table-column label="紧急联系人" align="center" prop="emergencyContact" />
      <el-table-column label="紧急联系人电话" align="center" prop="emergencyPhone" />
      <el-table-column label="婚姻状况" align="center" prop="maritalStatus">
        <template #default="scope">
          <dict-tag :options="sys_marriage" :value="scope.row.maritalStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="联系地址" align="center" prop="contactAddress" />
      <el-table-column label="入行时间" align="center" prop="entryTime" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.entryTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['proj:ProjTenantInfo:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['proj:ProjTenantInfo:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改租客信息对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="ProjTenantInfoRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="是否删除" prop="isDeleted">
          <el-select v-model="form.isDeleted" placeholder="请选择是否删除" style="min-width: 100px;">
            <el-option
              v-for="dict in sys_yes_no"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="删除时间" prop="deleteTime">
          <el-date-picker clearable
            v-model="form.deleteTime"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择删除时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="form.gender" placeholder="请选择性别" style="min-width: 100px;">
            <el-option
              v-for="dict in sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker clearable
            v-model="form.birthday"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择生日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="民族" prop="ethnicity">
          <el-input v-model="form.ethnicity" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="学历" prop="education">
          <el-input v-model="form.education" placeholder="请输入学历" />
        </el-form-item>
        <el-form-item label="工作单位" prop="company">
          <el-input v-model="form.company" placeholder="请输入工作单位" />
        </el-form-item>
        <el-form-item label="入职时间" prop="hireDate">
          <el-date-picker clearable
            v-model="form.hireDate"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择入职时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="离职时间" prop="leaveDate">
          <el-date-picker clearable
            v-model="form.leaveDate"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择离职时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="头像" prop="avatar">
          <el-input v-model="form.avatar" placeholder="请输入头像" />
        </el-form-item>
        <el-form-item label="是否在职" prop="isEmployed">
          <el-select v-model="form.isEmployed" placeholder="请选择是否在职" style="min-width: 100px;">
            <el-option
              v-for="dict in sys_yes_no"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="离职原因" prop="leaveReason">
          <el-input v-model="form.leaveReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="离职证明" prop="resignationCert">
          <el-input v-model="form.resignationCert" placeholder="请输入离职证明" />
        </el-form-item>
        <el-form-item label="所在部门" prop="department">
          <el-input v-model="form.department" placeholder="请输入所在部门" />
        </el-form-item>
        <el-form-item label="岗位" prop="position">
          <el-input v-model="form.position" placeholder="请输入岗位" />
        </el-form-item>
        <el-form-item label="职级" prop="jobLevel">
          <el-input v-model="form.jobLevel" placeholder="请输入职级" />
        </el-form-item>
        <el-form-item label="工号" prop="employeeId">
          <el-input v-model="form.employeeId" placeholder="请输入工号" />
        </el-form-item>
        <el-form-item label="创建人" prop="creator">
          <el-input v-model="form.creator" placeholder="请输入创建人" />
        </el-form-item>
        <el-form-item label="修改人" prop="modifier">
          <el-input v-model="form.modifier" placeholder="请输入修改人" />
        </el-form-item>
        <el-form-item label="车牌号" prop="licensePlate">
          <el-input v-model="form.licensePlate" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="紧急联系人" prop="emergencyContact">
          <el-input v-model="form.emergencyContact" placeholder="请输入紧急联系人" />
        </el-form-item>
        <el-form-item label="紧急联系人电话" prop="emergencyPhone">
          <el-input v-model="form.emergencyPhone" placeholder="请输入紧急联系人电话" />
        </el-form-item>
        <el-form-item label="婚姻状况" prop="maritalStatus">
          <el-radio-group v-model="form.maritalStatus">
            <el-radio
              v-for="dict in sys_marriage"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="联系地址" prop="contactAddress">
          <el-input v-model="form.contactAddress" placeholder="请输入联系地址" />
        </el-form-item>
        <el-form-item label="入行时间" prop="entryTime">
          <el-date-picker clearable
            v-model="form.entryTime"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择入行时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="ProjTenantInfo">
import { listProjTenantInfo, getProjTenantInfo, delProjTenantInfo, addProjTenantInfo, updateProjTenantInfo } from "@/api/proj/ProjTenantInfo"

const { proxy } = getCurrentInstance()
const { sys_marriage, sys_yes_no, sys_user_sex } = proxy.useDict('sys_marriage', 'sys_yes_no', 'sys_user_sex')

const ProjTenantInfoList = ref([])
const open = ref(false)
const loading = ref(true)
const showSearch = ref(true)
const ids = ref([])
const single = ref(true)
const multiple = ref(true)
const total = ref(0)
const title = ref("")

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    userId: null,
    idCard: null,
    name: null,
    phone: null,
    email: null,
    address: null,
    isDeleted: null,
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
    entryTime: null
  },
  rules: {
  }
})

const { queryParams, form, rules } = toRefs(data)

/** 查询租客信息列表 */
function getList() {
  loading.value = true
  listProjTenantInfo(queryParams.value).then(response => {
    ProjTenantInfoList.value = response.rows
    total.value = response.total
    loading.value = false
  })
}

// 取消按钮
function cancel() {
  open.value = false
  reset()
}

// 表单重置
function reset() {
  form.value = {
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
    gender: null,
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
    entryTime: null
  }
  proxy.resetForm("ProjTenantInfoRef")
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1
  getList()
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef")
  handleQuery()
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.tenantId)
  single.value = selection.length != 1
  multiple.value = !selection.length
}

/** 新增按钮操作 */
function handleAdd() {
  reset()
  open.value = true
  title.value = "添加租客信息"
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset()
  const _tenantId = row.tenantId || ids.value
  getProjTenantInfo(_tenantId).then(response => {
    form.value = response.data
    open.value = true
    title.value = "修改租客信息"
  })
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["ProjTenantInfoRef"].validate(valid => {
    if (valid) {
      if (form.value.tenantId != null) {
        updateProjTenantInfo(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功")
          open.value = false
          getList()
        })
      } else {
        addProjTenantInfo(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功")
          open.value = false
          getList()
        })
      }
    }
  })
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _tenantIds = row.tenantId || ids.value
  proxy.$modal.confirm('是否确认删除租客信息编号为"' + _tenantIds + '"的数据项？').then(function() {
    return delProjTenantInfo(_tenantIds)
  }).then(() => {
    getList()
    proxy.$modal.msgSuccess("删除成功")
  }).catch(() => {})
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('proj/ProjTenantInfo/export', {
    ...queryParams.value
  }, `ProjTenantInfo_${new Date().getTime()}.xlsx`)
}

getList()
</script>
