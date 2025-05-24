<template>
  <view class="uni-tree-select">
    <view class="tree-select-input" @click="toggleDropdown">
      <text class="placeholder" v-if="!selectedLabel">{{ placeholder }}</text>
      <text class="selected-label" v-else>{{ selectedLabel }}</text>
      <uni-icons :type="showDropdown ? 'arrowup' : 'arrowdown'" size="20" color="#999"></uni-icons>
    </view>

    <view class="tree-dropdown" v-show="showDropdown">
      <view class="tree-search" v-if="searchable">
        <input type="text" v-model="searchQuery" :placeholder="searchPlaceholder" @input="handleSearch" />
      </view>

      <scroll-view scroll-y class="tree-container">
        <tree-node v-for="node in filteredTree" :key="node[fieldConfig.value]" :node="node" :field-config="fieldConfig"
          :level="0" :selected-value="selectedValue" @node-click="handleNodeClick" />
      </scroll-view>
    </view>
  </view>
</template>

<script setup>
import { ref, computed, watch } from 'vue'
import TreeNode from './TreeNode.vue'

const props = defineProps({
// modelValue 会在以下位置发生变化：
// 1. 当用户点击树节点时，在 handleNodeClick 函数中通过 emit('update:modelValue', node[props.fieldConfig.value]) 触发更新。
// 2. 外部组件通过传入新的 modelValue 属性值来更新。
  modelValue: {
    type: [String, Number, Array],
    default: ''
  },
  data: {
    type: Array,
    default: () => []
  },
  fieldConfig: {
    type: Object,
    default: () => ({
      label: 'label',
      value: 'value',
      children: 'children'
    })
  },
  placeholder: {
    type: String,
    default: '请选择'
  },
  searchable: {
    type: Boolean,
    default: false
  },
  searchPlaceholder: {
    type: String,
    default: '请输入关键词搜索'
  }
})

// 定义组件触发的事件，用于更新 modelValue 和通知外部组件节点已被点击
const emit = defineEmits(['update:modelValue', 'change'])

const showDropdown = ref(false)
const searchQuery = ref('')
const selectedLabel = ref('')
const selectedValue = ref('')

const filteredTree = computed(() => {
  //console.log(props.data)
  if (!searchQuery.value) return props.data

  const filter = (nodes) => {
    return nodes.filter(node => {
      const label = node[props.fieldConfig.label].toLowerCase()
      const matches = label.includes(searchQuery.value.toLowerCase())

      if (node[props.fieldConfig.children] && node[props.fieldConfig.children].length) {
        const filteredChildren = filter(node[props.fieldConfig.children])
        if (filteredChildren.length) {
          return {
            ...node,
            [props.fieldConfig.children]: filteredChildren
          }
        }
      }
      console.log(matches)
      return matches
    })
  }

  return filter(props.data)
})

// 监听 props 中的 modelValue 属性，当该属性值发生变化时，调用 updateSelectedLabel 函数更新选中项的标签。
// immediate: true 表示在 watch 初始化时就执行一次回调函数。
watch(() => props.modelValue, (val) => {
  updateSelectedLabel(val)
}, { immediate: true })

function toggleDropdown() {
  showDropdown.value = !showDropdown.value
}

function handleSearch() {
  // 搜索逻辑已在filteredTree计算属性中处理
}

function handleNodeClick(node) {
// 触发 'update:modelValue' 事件，将当前点击节点的 value 值更新到外部组件绑定的 modelValue 上
emit('update:modelValue', node[props.fieldConfig.value])
// 触发 change 事件，将当前点击的节点作为参数传递出去，用于通知外部组件节点已被点击
  emit('change', node)
  selectedLabel.value = node[props.fieldConfig.label]
  selectedValue.value = node[props.fieldConfig.value]
  showDropdown.value = false
}

function updateSelectedLabel(value) {
  if (!value) {
    selectedLabel.value = ''
    return
  }

  const findNode = (nodes) => {
    console.log(nodes)
    for (const node of nodes) {
      if (node[props.fieldConfig.value] === value) {
        selectedLabel.value = node[props.fieldConfig.label]
        return true
      }

      if (node[props.fieldConfig.children] && node[props.fieldConfig.children].length) {
        if (findNode(node[props.fieldConfig.children])) {
          return true
        }
      }
    }
    return false
  }
  findNode(props.data)
}
</script>

<style>
.uni-tree-select {
  position: relative;
  width: 100%;
}

.tree-select-input {
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 80rpx;
  padding: 0 24rpx;
  border: 1px solid #e0e0e0;
  border-radius: 8rpx;
  background-color: #f9f9f9;
  font-size: 28rpx;
  color: #333;
}

.placeholder {
  color: #999;
}

.tree-dropdown {
  position: absolute;
  top: 100%;
  left: 0;
  right: 0;
  max-height: 500rpx;
  margin-top: 8rpx;
  background-color: #fff;
  border: 1px solid #e0e0e0;
  border-radius: 8rpx;
  box-shadow: 0 2rpx 16rpx rgba(0, 0, 0, 0.1);
  z-index: 1000;
  overflow: hidden;
}

.tree-search {
  padding: 16rpx;
  border-bottom: 1px solid #eee;
}

.tree-search input {
  width: 100%;
  height: 60rpx;
  padding: 0 20rpx;
  border: 1px solid #e0e0e0;
  border-radius: 8rpx;
  font-size: 26rpx;
}

.tree-container {
  max-height: 400rpx;
  padding: 16rpx 0;
}
</style>