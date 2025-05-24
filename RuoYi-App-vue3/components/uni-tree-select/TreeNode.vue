<template>
  <view>
    <view 
      class="tree-node" 
      :style="{ paddingLeft: `${level * 20 + 10}rpx` }"
      @click="toggleExpand"
    >
      <uni-icons 
        v-if="hasChildren" 
        :type="isExpanded ? 'minus' : 'plus'" 
        size="16" 
        color="#666"
      ></uni-icons>
      <text 
        class="node-label" 
        :class="{ 'node-selected': isSelected }"
        @click.stop="selectNode"
      >{{ node[fieldConfig.label] }}</text>
    </view>
    
    <view v-show="isExpanded && hasChildren">
      <tree-node 
        v-for="child in node[fieldConfig.children]" 
        :key="child[fieldConfig.value]" 
        :node="child" 
        :field-config="fieldConfig"
        :level="level + 1"
        :selected-value="selectedValue"
        @node-click="handleChildClick"
      />
    </view>
  </view>
</template>

<script setup>
import { ref, computed } from 'vue'

const props = defineProps({
  node: {
    type: Object,
    required: true
  },
  fieldConfig: {
    type: Object,
    default: () => ({
      label: 'label',
      value: 'value',
      children: 'children'
    })
  },
  level: {
    type: Number,
    default: 0
  },
  selectedValue: {
    type: Number,
    default: 0
  }
})

const emit = defineEmits(['node-click'])

const isExpanded = ref(false)
const isSelected = computed(() => {
  const nodeValue = props.node[props.fieldConfig.value]
  const selected = props.selectedValue
  return selected === nodeValue
})

const hasChildren = computed(() => {
  return props.node[props.fieldConfig.children] && props.node[props.fieldConfig.children].length
})

function toggleExpand() {
  if (hasChildren.value) {
    isExpanded.value = !isExpanded.value
  }
}

function selectNode() {
  emit('node-click', props.node)
}

function handleChildClick(node) {
// 这行代码的作用是触发一个名为 'node-click' 的自定义事件，并将参数 node 传递出去。
// 当子节点被点击时，通过这个事件通知父组件哪个节点被点击了。
  emit('node-click', node)
}
</script>

<style>
.tree-node {
  display: flex;
  align-items: center;
  height: 80rpx;
  font-size: 28rpx;
  color: #333;
}

.node-label {
  margin-left: 10rpx;
}

.node-selected {
  color: #2979ff;
  font-weight: bold;
}
</style>